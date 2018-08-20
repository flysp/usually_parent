<%--
  Created by IntelliJ IDEA.
  User: 27245
  Date: 2018/6/13
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ResultFul测试</title>
    <script src="js/jquery-3.3.1.min.js"></script>
</head>
<body>
   <button  id="get">GET测试</button>
   <button  id="post">POST测试</button>
   <button id="formData">POST FormData</button>
   <button id="put">PUT测试</button>
    <button id="delete">DELETE测试</button>
</body>
<script>
     $(function () {

           $("#get").off().on("click",function () {

                   $.get('user',{id:1},function (data) {

                        console.log(data);
                   });
           });

           $("#post").off().on("click",function () {


               var jsonstr ={address:"sdfasd",name:"sdfasd"};
               $.ajax({
                   url:'user',
                   type:'POST',
                   data:JSON.stringify(jsonstr),
                   contentType:"application/json",//设置请求参数类型为json字符串

                   success:function (data) {
                       console.log(data)
                   }
               });

           });

           $("#put").off().on("click",function(){
               var jsonstr = {address:"sdfsad",name:"safas"}
                $.ajax({
                    url:'user',
                    type:'PUT',
                    contentType:"application/json",//设置请求参数类型为json字符串
                    data:JSON.stringify(jsonstr),//将json对象转换成json字符串发送
                    success:function(data){
                         console.log(data)
                    }
                });
           });

         $("#delete").off().on("click",function () {

         var jsonstr = {address:"sdfsad",name:"safas"}
             $.ajax({
                 url:'user/'+'sadfasdf',
                 type:'DELETE',
                contentType:"application/json",//设置请求参数类型为json字符串
                 data:JSON.stringify(jsonstr),//将json对象转换成json字符串发送
             //    dataType:"json",    返回的数据类型指定
                 success:function (data) {
                     console.log(data)
                 }
             });
         });


         $("#formData").off().on("click",function () { // 必须 要配置multipartResolver
             var formData = new FormData();

             formData.append("address","sadfla");
             formData.append("name","jlskdjfl");
                 $.ajax({
                     url:'userd',
                     type:'POST',
                     data:formData,
                   processData:false,
                   contentType:false,
                     success:function (data) {

                         console.log(data)
                     }
                 });
         });

     });
</script>

</html>
