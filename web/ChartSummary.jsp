<%@ page import="java.util.ArrayList" %>
<%@ page import="util.ChartImage" %>

<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="en-us" http-equiv="Content-Language" />
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>code</title>
</head>

<body>
  <%
  String ccode=request.getParameter("code");
   ArrayList<String>  ls  = ChartImage. chartImage( ccode);
  %>

<div>
	code:<h2> <%out.println(ccode);%><h2>


<%
for (String  img : ls) {
out.println(img);
}
%>



</div>
<div>
    <img alt="" height="1000" src="https://chart.finance.yahoo.com/z?s=<%out.println(ccode);%>.AX&t=6m&q=l&l=on&z=l&p=m20,m40,m150,m400&a=vm&lang=en-AU&region=AU" width="1500" />
</div>
</body>

</html>
