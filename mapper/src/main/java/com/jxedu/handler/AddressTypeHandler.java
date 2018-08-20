package com.jxedu.handler;

import com.jxedu.bean.Address;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class AddressTypeHandler extends BaseTypeHandler<Address> {


    /**
     * 执行sql语句之前做的处理
     *
     * @param preparedStatement
     * @param i
     * @param address
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Address address, JdbcType jdbcType) throws SQLException {


        StringBuilder ads = new StringBuilder();
        ads.append(address.getProvince()).append(",").append(address.getCity()).append(",").append(address.getStreet());
        preparedStatement.setString(i, ads.toString());

    }

    @Override
    public Address getNullableResult(ResultSet resultSet, String columnName) throws SQLException {

        String result = resultSet.getString(columnName);
        Address address = new Address();
        if (Objects.nonNull(result) && result.contains(",")) {
            String[] split = result.split(",");
            address.setProvince(split[0]);
            address.setCity(split[1]);
            address.setStreet(split[2]);
        }
        return address;
    }

    @Override
    public Address getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String result = resultSet.getString(i);
        Address address = new Address();
        if (Objects.nonNull(result) && result.contains(",")) {
            String[] split = result.split(",");
            address.setProvince(split[0]);
            address.setCity(split[1]);
            address.setStreet(split[2]);
        }
        return address;
    }

    @Override
    public Address getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String result = callableStatement.getString(i);
        Address address = new Address();
        if (Objects.nonNull(result) && result.contains(",")) {
            String[] split = result.split(",");
            address.setProvince(split[0]);
            address.setCity(split[1]);
            address.setStreet(split[2]);
        }
        return address;
    }


}
