
<%@ page import="access.StockAccess" %>
<%@ page import="access.DataAccess" %>


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

    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
    $( function() {
      $( "#datepicker" ).datepicker({ dateFormat: 'yy-mm-dd' });
    } );





    </script>

  </head>

<body style="height: 1028px" bgcolor="#E6E6E6">
    <div id="divMain" style="background:transparent;margin-left:auto;margin-right:auto;position:relative;width:960px;height:100;">


        <p class="Body"><span class="C-1">Welcome Rowan Charts system :>mode listing<</span></p>

    <form action="ChooserLookJSP" method="post">
      	<p>Date: <input type="text" id="datepicker" name="MyModeDate">
  <select name="CATEGORY">

        <option value="NO" ></option>
          <c:forEach items="${Categories}"  var="obj">

                <option value="${obj}"      >${obj}</option>
    					</c:forEach>
              <option value="WISHLIST">WISHLIST</option>
  
   </select>

   <select name="SOURCE">
       <option value="NO" ></option>
         <option value="ALL">See All</option>
         <option value="Random">Random</option>
         <option value="9">Mode 9 recently fall 4% (5day)</option>
         <option value="3">Mode 3 recently large volume  (5day)</option>
         <option value="7">Mode 7 large fall low volume  (5day)</option>
    </select>
<p class="Body"><span class="C-1"><input type="checkbox" name="autoRefresh" value="Yes">Auto Refresh</span></p>

         <input type="submit" name="Yes" value="Yes">

     </p>


      	</form>













<br>
  <br>
  <br>
    <br>
    <br>

  <div id="divMain" style="background:transparent;margin-left:auto;margin-right:auto;position:relative;width:960px;height:10;">




  </div>


  </body>
</html>
