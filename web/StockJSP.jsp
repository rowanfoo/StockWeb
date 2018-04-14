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
Hashtable <String ,StockAccess>  arr = (Hashtable) 	request.getSession().getAttribute("Stock");


%>


<form name="StockJspForm" action="StockJSP" method="post">

	<br />
	<br />

Code<input list="browsers" name="CODE">
  <datalist id="browsers">
<%
for(String s:arr.keySet()   ){
out.println("<option value=\""+s+"\"> ");



}
%>


  </datalist>

	<br />
	<br />
	<br />

	<select name="combo1" class="OBJ-1" size="5" style="width:393px;" onChange="StockJspForm.submit();">
	 	<option value="" SELECTED>Choose One
			 	<option value="1">>Technicals</option>
				<option value="2">>Fundamentals</option>
					<option value="3">>Summary</option>
		</select>









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
