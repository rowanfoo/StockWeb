<%@ page import="access.TechStrAccess" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.ArrayList" %>

<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>Home</title>
    <meta name="generator" content="Serif WebPlus X8 (16,0,1,21)">
    <meta name="viewport" content="width=960">
    <link rel="stylesheet" type="text/css" href="wpscripts/wpstyles.css">
    <style type="text/css">
      .OBJ-1 { border:1px solid #000000;border-radius:2px / 2px;background-color:#ffffff;background:#ffffff; }
      .C-1 { line-height:18.00px;font-family:"Verdana", sans-serif;font-style:normal;font-weight:normal;color:#000000;background-color:transparent;text-decoration:none;font-variant:normal;font-size:16.0px;vertical-align:0; }
    .auto-style1 {
	margin-top: 253px;
}


th, td {
    padding: 15px;
    text-align: left;
}
th, td {
    border-bottom: 1px solid #ddd;
}
tr:nth-child(even) {background-color: #f2f2f2}
TD{font-family: Consolas;}
    </style>
  </head>

    <body style="height: 1028px" bgcolor="#E6E6E6">



        <p class="Body"><span class="C-1">Welcome Rowan Charts system</span></p>
        <p class="Body"><span class="C-1">mode listing</span></p>










        <c:forEach items="${RESEARCH}"  var="obj">
              <c:if test="${not empty obj.dailychart}">

                <img alt="" height="475" src="${obj.dailychart} " width="600" />

              </c:if>

              <c:if test="${not empty obj.weeklychart}">

                <img alt="" height="475" src="${obj.weeklychart} " width="600" />

              </c:if>

              <c:if test="${not empty obj.monthlychart}">

                <img alt="" height="475" src="${obj.monthlychart} " width="600" />

              </c:if>
              
       		 </c:forEach>







  </body>
</html>
