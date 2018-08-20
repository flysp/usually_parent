package com.jxedu;

import com.jxedu.bean.User;
import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.mapperhelper.SqlHelper;

import java.util.Iterator;
import java.util.Set;

public class BatchProvider extends MapperTemplate {

    public BatchProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }


    /**
     * <insert id="batch" >
     *             insert  into  t_user (name) values
     *               <foreach collection="list" item="obj" separator=",">
     *                         (#{obj.name})
     *               </foreach>
     *      </insert>
     * @param mst
     * @return
     */
       public  String insertBatch(MappedStatement mst){

             StringBuilder sql  = new StringBuilder();

           Class<?> entityClass = super.getEntityClass(mst);
           String tableName = super.tableName(entityClass);
           String intoTable = SqlHelper.insertIntoTable(entityClass, tableName);
           sql.append(intoTable);
            sql.append("(");

           Set<EntityColumn> columns = EntityHelper.getColumns(entityClass);

           for (EntityColumn column : columns){
                  if (!column.isId()){
                      sql.append(column.getColumn()).append(",");
                  }
           }
           sql.deleteCharAt(sql.length()-1);
           sql.append(")");
           sql.append("VALUES");
           sql.append("<foreach collection=\"list\" item=\"obj\" separator=\",\">");
            for (EntityColumn column :columns){
                sql.append("(");
                    if (!column.isId()){
                        String columnHolder = column.getColumnHolder("obj");
                        sql.append(columnHolder);
                        sql.append(",");
                    }
                    sql.deleteCharAt(sql.length()-1);
            }
            sql.append(")");
           sql.append("</foreach>");
           sql.append(";");
           return  sql.toString();
       }

    public String updateBatch(MappedStatement mst){

        String idcolumn = "";
        String idvalue = "";
        StringBuilder sql = new StringBuilder("<foreach collection=\"list\" item=\"obj\">");

        Class<?> entityClass = super.getEntityClass(mst);

        sql.append(SqlHelper.updateTable(entityClass,super.tableName(entityClass)));
        sql.append("<set>");
        Set<EntityColumn> columns = EntityHelper.getColumns(entityClass);


        Iterator<EntityColumn> iterator = columns.iterator();

        while (iterator.hasNext()){

            EntityColumn x = iterator.next();

            if (x.isId()){
                idcolumn = x.getColumn();
                idvalue = x.getColumnHolder("obj");
            }else {
                sql.append(x.getColumn());
                sql.append("=");
                sql.append(x.getColumnHolder("obj"));
                sql.append(",");
            }
        }
        sql.append("</set>");
        sql.append("where")
                .append(" ")
                .append(idcolumn)
                .append("=")
                .append(idvalue);
        sql.append("</foreach>");
        return  sql.toString();
    }
}
