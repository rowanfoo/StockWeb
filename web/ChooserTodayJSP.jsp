<%@ page import="access.TechStrAccess" %>
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


      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>jQuery UI Datepicker - Default functionality</title>
      <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
      <link rel="stylesheet" href="/resources/demos/style.css">




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
    <div id="divMain" style="background:transparent;margin-left:auto;margin-right:auto;position:relative;width:960px;height:100;">


        <p class="Body"><span class="C-1">Live price ></span></p>
<p>mode listing for drop greater 4%<</p>
<p>Volume greater than average<</p>



</div>

<br>
  <br>
  <br>
    <br>
    <br>

  <div id="divMain" style="background:transparent;margin-left:auto;margin-right:auto;position:relative;width:1260px;height:10;">
<form name=frmTest  action="TodayStockJSP" method="post" >







<p class="Body"><span class="C-1"><input type="checkbox" name="autoRefresh" value="Yes">Auto Refresh 1</span></p>
<p class="Body"><span class="C-1"><input type="checkbox" name="delete" value="Yes">Delete</span></p>
<p class="Body"><span class="C-1"><input type="submit" name="submit" value="Yes"></span></p>

</form>



<%

ArrayList <TechStrAccess>  arr = (ArrayList ) 	request.getSession().getAttribute("TechStr");


%>



    	<table class="auto-style1" style="width: 100%">

      <c:forEach items="${TechStr}"  var="obj">
     <tr>
       <td><font size=\"2\">  <fmt:formatDate pattern="dd-MM"     value="${obj.date}" />  </font></td>

         <td><font size="3">${obj.name}</font></td>
            <td><a href="LookToday.jsp?code=${obj.pureCode}" target="_blank" >${obj.code}  </font> </a></td>

            <td><font size="3">${obj.mode}</font></td>
            <td><font size="3">${obj.modeUsefullNumber}</td>
            <td><font size="3">from 50d :<fmt:formatNumber type="PERCENT"  maxIntegerDigits="3" value="${obj.fiftychg}" /></td>


    </tr>
          </c:forEach>

		</table>
        </div>
    <br>
    <br>
      <div style="text-align: center">

      </div>
      <br>
      <br>


    </div>

  </div>


  </body>
</html>
