<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 8/31/2026
  Time: 9:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>DS SP</h1>
    <ul>
        <%// thẻ mở, đóng vùng muốn viết java
            List<String> dssp= (List<String>) request.getAttribute("danhSach");
            if(dssp!=null){
                for(String sp:dssp){
        %>
               <li><%= sp %></li>
        <%}

            }
            %>

    </ul>

</body>
</html>
