<%@ page import="access.StockAccess" %>
<%@ page import="java.util.Hashtable" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>Untitled 1</title>



</head>

<body style="height: 1028px" bgcolor="#708090">
<%

Hashtable <String ,StockAccess>  arr = (Hashtable) 	request.getAttribute("Stock");

%>


<form action="MyNotesJSP" method="post">


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
		<select  name="Mode" style="width: 100px">
		 <option value="2" selected="selected">Notes</option>
		 <option value="1">ToDo</option>
		  <option value="3">Technical</option>
		</select>




	<br />
	<br />
<textarea name="Note1" style="width: 1360px; height: 152px " id="styled"  ; setbg('#e5fff3';spellcheck="true");" onblur="setbg('white')" > </textarea><br />
<br />
<br />



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
