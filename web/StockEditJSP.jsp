<%@ page import="access.StockAccess" %>
<%@ page import="java.util.Hashtable" %>


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
StockAccess obj=(StockAccess)request.getAttribute("CODE");
request.setAttribute("StockObj",obj);
System.out.println("WISHLIST "+obj.getWishlist()+":::");
boolean wishlist=true;
if (obj.getWishlist()==null ||obj.getWishlist().trim().equals("") )wishlist=false;

%>


<form action="" method="post">
	Stock: <%out.println(obj.getCode());   %><br />
	Name: <%out.println(obj.getName());   %><br />

	<br />
	<br />
	Note1<br />
	<br />
<textarea name="Note1" style="width: 1360px; height: 152px " id="styled"  ; setbg('#e5fff3');" onblur="setbg('white')" ><%out.println(obj.getNotes1());   %> </textarea><br />

	<br />
	Note2<br />
	<textarea name="Note2" style="width: 1359px; height: 163px" id="styled"   ><%out.println(obj.getNotes2());   %></textarea><br />
	<br />
	<br />
	Tech Notes:<br />
	<textarea name="TechNotes" style="width: 1357px; height: 168px"  id="styled" ><%out.println(obj.getTechnicalNotes());   %></textarea><br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	Trend<br />
	<br />
	<textarea name="Trend" style="width: 1358px; height: 168px"  id="styled"> <%out.println(obj.getTrend());   %></textarea><br />
	<br />
	<br />
	<br />
	<br />
	Monthly Notes<br />
	<br />
	<textarea name="MonthlyNotes" style="width: 1364px; height: 178px"  id="styled"><%out.println(obj.getMontlyNotes());   %></textarea><br />
	<br />
	<br />
	<br />
	Weekly Notes<br />
	<textarea name="WeeklyNotes" style="width: 1364px; height: 186px"  id="styled"><%out.println(obj.getWeeklyNotes());   %></textarea><br />
	<br />
	<br />
	Daily Notes:<br />
	<br />
	<textarea name="DailyNotes" style="width: 1366px; height: 191px"  id="styled"><%out.println(obj.getDailyNotes());   %></textarea><br />
	<br />
	<br />
	Normandy Notes<br />
	<br />
	<textarea name="NormandyNotes" style="width: 1366px; height: 226px"  id="styled"><%out.println(obj.getNormandyNotes());   %></textarea><br />
	<br />
	<br />
	<br />
	Normandy $<input name="NormandyPrice " type="text" value="<%out.println(obj.getNormandyPt());   %>" />&nbsp (Alert)  <br />
	<br />
	<br />
	When buy Notes<br />
	<br />
	<textarea name="WhenBuyNotes" style="width: 1387px; height: 266px"  id="styled"><%out.println(obj.getWhenBuy());   %></textarea><br />
	<br />
	<br />
	<br />
	<br />
	When buy $ <input name="WhenBuyPrice" type="text" value="<%out.println(obj.getWhenBuyPrice());   %>" />&nbsp (Alert)<br />
	<br />
	<br />
	<br />
	Stop loss Notes<br />
	<textarea name="StopLossNotes" style="width: 1383px; height: 195px"  id="styled"><%out.println(obj.getStopLossNotes());   %></textarea><br />
	<br />
	Stop loss $ <input name="StopLossPrice" type="text" value="<%out.println(obj.getStopLoss());   %>"  /><br />

	<br />
	<br />
	Key Support Notes<br />
	<br />
	<textarea name="KeySupportNotes" style="width: 1400px; height: 240px"  id="styled"><%out.println(obj.getKeySupportPriceNotes());   %></textarea><br />
	<br />
	Key support $<input name="KeySupportPrice" style="width: 215px" type="text" value="<%out.println(obj.getKeySupportPrice());   %>" /><br />



	<br />
	<br />
	Key Defend Price Notes<br />
	<br />
	<textarea name="DefendKeyNotes" style="width: 1400px; height: 240px"  id="styled"><%out.println(obj.getDefendKeyNotes());   %></textarea><br />
	<br />
	Key Defend Price $<input name="DefendKeyPrice" style="width: 215px" type="text" value="<%out.println(obj.getDefendKeyPrice());   %>" /><br />

	<br />
	<br />

	Why Not !<br />
	<br />
	<textarea name="Nope" style="width: 1400px; height: 240px"  id="styled"><%out.println(obj.getNope());   %></textarea><br />
	<br />
	<br />
	Stage of Growth  !<br />
	<br />
	<textarea name="stageGrowth" style="width: 1400px; height: 240px"  id="styled"><%out.println(obj.getStageGrowth());   %></textarea><br />
	<br />
	<br />




	Alert $<input name="AlertPrice" type="text" value="<%out.println(obj.getAlertPrice());   %>"  /><br />
	<br />

	<br />
	Charts $<input name="Chart" type="text" size="50" value="<%out.println(obj.getChart());   %>"  /><br />
	<br />
	Notes $<input name="Chart" type="text" size="50" value="<%out.println(obj.getOneNotes());   %>"  /><br />



	<br />
<%
String link = obj.getChart();
if(link != null){
	if(! link.trim().equals(""))	{
	out.println("<a href=\""+link+"\">CHARTS</a> "       );

	}

}
 link = obj.getOneNotes();

if(link != null){
	if(! link.trim().equals(""))	{
	out.println("&nbsp&nbsp<a href=\""+link+"\">CHARTS</a> "       );

	}

}



%>
<br />
<br />


	<input name="wishList" type="checkbox"  <%if(wishlist)out.println("checked");   %>     /> Add Wish List<br />
	<br />
	<br />
	<br />
	<br />
	<br />

    <input type="submit" name="Yes" value="Tech">
	<input type="hidden" name="formcode" value="<%out.println(obj.getCode());   %>">

	<br />
	<input type="submit" name="BACK" value="BACK">

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
