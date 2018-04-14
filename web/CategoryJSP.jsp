
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

    <form action="CategoryJSP" method="post">
      	<p>Date: <input type="text" id="datepicker" name="MyModeDate">
  <select name="CATEGORY">


          <c:forEach items="${Categories}"  var="obj">

                <option value="${obj}"      >${obj}</option>



    					</c:forEach>
              <option value="WISHLIST">WISHLIST</option>

   </select>

   <select name="SOURCE">
         <option value="Database" selected="selected">Database</option>
         <option value="XLS">XLS</option>
    </select>

<p class="Body"><span class="C-1"><input type="checkbox" name="autoRefresh" value="Yes">Auto Refresh</span></p>
         <input type="submit" name="Yes" value="Yes">

     </p>


      	</form>

<br>
  <p>${TYPE} </p>




        <table class="auto-style1" style="width: 100%">
          <tr>
            <c:if test="${TYPE == 'WISHLIST'}">
              <td><font size="3"name</font></td>
              <td><font size="3">close</td>
              <td><font size="3">change</td>
              <td><font size="3">50d change</td>
                <td><font size="3">buy price</td>
                <td><font size="3">sell price</td>
                <td><font size="3">volume</td>
                <td><font size="3">avg3mthVolume</td>


            </c:if>

            <c:if test="${TYPE != 'WISHLIST'}">
              <td><font size="3"name</font></td>
              <td><font size="3">close</td>
              <td><font size="3">change</td>
              <td><font size="3">50d change</td>
              <td><font size="3">200d change</td>
                <td><font size="3">MarketCAP</td>


            </c:if>







         </tr>
        <c:forEach items="${Stocks}"  var="obj">
       <tr>

           <c:if test="${TYPE == 'WISHLIST'}">
             <td> <a href=http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=Stock&symb=au%3A${obj.pureCode}&x=51&y=10&time=8&startdate=1%2F4%2F1999&enddate=11%2F24%2F2016&freq=1&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=3&maval=50&uf=0&lf=268435456&lf2=0&lf3=0&type=1&style=320&size=4&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11  ><font size="3">${obj.name}</font></a> </td>
             <td><font size="3"><fmt:formatNumber type="NUMBER" minFractionDigits="1"  maxIntegerDigits="4" value="${obj.data.close}" /></td>
             <td><font size="3"><fmt:formatNumber type="PERCENT" minFractionDigits="1"  maxIntegerDigits="4" value="${obj.data.changePercent}" /></td>
             <td><font size="3"><fmt:formatNumber type="PERCENT" minFractionDigits="1"   maxIntegerDigits="4" value="${obj.data.fiftychg}" /></td>
             <td><font size="3"><fmt:formatNumber type="NUMBER" minFractionDigits="1"   maxIntegerDigits="4" value="${obj.whenBuyPrice}" /></td>
             <td><font size="3"><fmt:formatNumber type="NUMBER" minFractionDigits="1"   maxIntegerDigits="4" value="${obj.stopLoss}" /></td>
             <td><font size="3"><fmt:formatNumber type="NUMBER" minFractionDigits="0"   maxFractionDigits="2" value="${obj.data.volume}" /></td>
            <td><font size="3"><fmt:formatNumber type="NUMBER" minFractionDigits="0"   maxFractionDigits="6" value="${obj.data.avg3mth}" /></td>


           </c:if>


           <c:if test="${TYPE != 'WISHLIST'}">
             <td> <a href=http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=Stock&symb=au%3A${obj.pureCode}&x=51&y=10&time=8&startdate=1%2F4%2F1999&enddate=11%2F24%2F2016&freq=1&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=3&maval=50&uf=0&lf=268435456&lf2=0&lf3=0&type=1&style=320&size=4&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11  ><font size="3">${obj.name}</font></a> </td>
             <td><font size="3"><fmt:formatNumber type="NUMBER" minFractionDigits="1"  maxIntegerDigits="4" value="${obj.data.close}" /></td>
             <td><font size="3"><fmt:formatNumber type="PERCENT" minFractionDigits="1"  maxIntegerDigits="4" value="${obj.data.changePercent}" /></td>
             <td><font size="3"><fmt:formatNumber type="PERCENT" minFractionDigits="1"   maxIntegerDigits="4" value="${obj.data.fiftychg}" /></td>
             <td><font size="3"><fmt:formatNumber type="PERCENT" minFractionDigits="1"   maxIntegerDigits="4" value="${obj.data.twohundredchg}" /></td>
             <td><font size="3"><fmt:formatNumber type="NUMBER" minFractionDigits="1"   maxIntegerDigits="4" value="${obj.myMarketCap}" /></td>



           </c:if>



      </tr>
            </c:forEach>

      </table>

          </div>
      <br>
  <div style="text-align: center">
        <%
ArrayList<StockAccess> myarr = (ArrayList<StockAccess> )request.getAttribute("Stocks");
        String href="Charts.jsp?";
        int count=1;
          String param="code";
          String link="";
          if(myarr!=null){
        for(StockAccess obj: myarr){
          String code= obj.getPureCode();

          param=param+"="+code+"&";
          link=link+param;
          param="code";


          count++;
        }

        href= href+link;
out.println( "<a href=\" "+href+ " \">" +"charts </a>");
}
        %>

      <br>


        </div>
        <br>
        <br>







<br>
  <br>
  <br>
    <br>
    <br>

  <div id="divMain" style="background:transparent;margin-left:auto;margin-right:auto;position:relative;width:960px;height:10;">




  </div>


  </body>
</html>
