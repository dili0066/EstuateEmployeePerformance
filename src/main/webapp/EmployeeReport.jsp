<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*, com.Estuate.models.Employees" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
    List<Employees> eList = (List<Employees>)session.getAttribute("employeeList");

	System.out.print(eList);
    if (eList != null && !eList.isEmpty()) {
        for ( Employees ed : eList) {
        	
%>
	<%= ed.getId() %>
     <%= ed.getName() %>
       <%= ed.getEmail() %>
         <%= ed.getMobile() %> 
            <%= ed.getAddress() %>
            <%= ed.getRating() %>
        
    
<%
        }
    } else {
%>
    <p>No restaurants available at the moment. Please check back later.</p>
<%
    }
%>

</body>
</html>