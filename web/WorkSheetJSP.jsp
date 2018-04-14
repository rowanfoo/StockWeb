
<%@ page import="java.util.Hashtable" %>
<%@ page import="access.WorkSheetAccess" %>
<%@ page import="access.StockAccess" %>

<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>Untitled 1</title>

<SCRIPT TYPE="text/javascript">
	<!--
	function setbg(color)
	{
	document.getElementById("styled").style.background=color
	}
	//-->
	</SCRIPT>


</head>

<body style="height: 1028px" bgcolor="#708090">
<%



Hashtable <String ,StockAccess>  arr = (Hashtable) 	request.getAttribute("Stock");

%>


<form action="WorkSheetJSP" method="post">

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


	<select  name="time" style="width: 100px">
	 <option value="short" selected="selected">Short Term</option>
	 <option value="Long">Long Term</option>
	</select>
	<c:if test="${empty error}">
<p><h2>    ${error}           </h2></p>

</c:if>

	<br />
	Reason <br />
	<textarea name="reason" style="width: 1359px; height: 163px" id="styled"   ></textarea>
	<br>
		<br>
		<br>

	&nbsp&nbsp	Buy $&nbsp&nbsp<input name="buy" type="text" value=" " />&nbsp&nbsp	stopLoss $<input name="stopLoss" type="text" value=" " />
<br>
	 &nbsp&nbsp	E date &nbsp<input name="edate" type="text" value=" " /><br />


	<br />


Trend:<br />
	<textarea name="trend" style="width: 1357px; height: 168px"  id="styled" ></textarea><br />
	<br />
	<br />

volatiles:<br />
	<textarea name="volatiles" style="width: 1357px; height: 168px"  id="styled" ></textarea><br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	panic<br />
	<br />
	<textarea name="panic" style="width: 1358px; height: 168px"  id="styled"> </textarea><br />
	<br />
	<br />
	<br />
	<br />
	discounted<br />
	<br />
	<textarea name="discounted" style="width: 1364px; height: 178px"  id="styled"></textarea><br />
	<br />
	<br />
	<br />
	multiMonth<br />
	<textarea name="multiMonth" style="width: 1364px; height: 186px"  id="styled"></textarea><br />
	<br />
	<br />
majorSupport:<br />
	<br />
	<textarea name="majorSupport" style="width: 1366px; height: 191px"  id="styled"></textarea><br />
	<br />
	<br />
meanRevision<br />
	<br />
	<textarea name="meanRevision" style="width: 1366px; height: 226px"  id="styled"></textarea><br />
	<br />
	<br />
	<br />

	<br />
	changeTrend<br />
	<br />
	<textarea name="changeTrend" style="width: 1387px; height: 266px"  id="styled"></textarea><br />
	<br />
	<br />
	<br />
	<br />

	<br />
	<br />
	<br />
	sellergain<br />
	<textarea name="sellergain" style="width: 1383px; height: 195px"  id="styled"></textarea><br />
	<br />



    <input type="submit" name="Yes" value="News">


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
