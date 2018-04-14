<%@ page import="access.CategoryAccess" %>
<%@ page import="java.util.Hashtable" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>Untitled 1</title>



</head>

<body style="height: 1028px" bgcolor="#708090">


	  </datalist>
		<select  name="Mode" style="width: 100px">
		 <option value="1" selected="selected">Notes</option>
		 <option value="2">ToDo</option>
		</select>


<h1><c:out value="hello wold" /> </h1>

	<br />
	<br />

<br />
<br />
"${Categories}"
<form action="MyNotesJSP" method="post">


	<br />
	<br />
	Code<input list="browsers" name="CODE">
	  <datalist id="browsers">

			<c:forEach items="${Categories}"  var="obj">

					<option value="		'${obj.category}' ">

					</c:forEach>





	<br />
	<br />
    <input type="submit" name="Yes" value="Yes">

	<br />

<br />



</form>

 <style type="text/css" style="display: none !important;">

 textarea#styled {
 	width: 600px;
 	height: 120px;
 	border: 3px solid #cccccc;
 	padding: 5px;
 	font-family: Tahoma, sans-serif;
 	background-image: url(bg.gif);
 	background-position: bottom right;
 	background-repeat: no-repeat;
 }
 </style>

</body>

</html>
