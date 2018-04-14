<%@ page import="access.StockAccess" %>
<%@ page import="java.util.Hashtable" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>Untitled 1</title>
</head>

<body>
<%
Hashtable <String ,StockAccess>  arr = (Hashtable) 	request.getAttribute("Stock");


%>


<form name="StockJspForm" action="ReportJSP" method="post">

	<br />
	<br />

Code<input list="browsers" name="CODE">
  <datalist id="browsers">
<%
for(String s:arr.keySet()   ){
out.println("<option value=\" "+s+"\"> ");



}
%>


  </datalist>

	<br />
	<br />
	<br />

  <input type="submit" name="Yes" value="Fund">







	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
</form>



</body>

</html>
