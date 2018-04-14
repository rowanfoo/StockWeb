<!--Page Preamble-->
<!--Master A Preamble-->

<%@ page import="java.text.DecimalFormat" %>
<%@ page import="access.StockAccess" %>
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
		<!--Page Head-->
		<!--Master A Head-->
		<link rel="stylesheet" type="text/css" href="wpscripts/wpstyles.css">
      <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Tangerine">


    <style type="text/css">

    body {
     font-family: 'Tangerine', serif;
     font-size: 20px;
   }

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
	<body __AddCode="PageInBodyTag" __AddCode="Master A In Body Tag" style="height:2000px;background:#ffffff;/*Page Body Style*//*Master A Body Style*/">
		<!--Page Body Start-->
		<!--Master A Body Start-->

<%

//request.setAttribute("PERCENTAGE",precentage +"");

%>
 <h1>${CODE.code}</h1>



<br>
<a href="http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=Stock&symb=au%3A${ CODE.pureCode }&time=10&startdate=1%2F4%2F1999&enddate=8%2F2%2F2016&freq=2&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=1&maval=12&uf=0&lf=268435456&lf2=0&lf3=0&type=1&style=320&size=4&x=54&y=17&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11"  target="_blank" > <font size="5">weekly</font> </a>

<a href="http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=Stock&symb=au%3A${ CODE.pureCode }&x=50&y=19&time=12&startdate=1%2F4%2F1999&enddate=8%2F2%2F2016&freq=3&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=1&maval=10&uf=0&lf=268435456&lf2=0&lf3=0&type=1&style=320&size=4&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11 "  target="_blank" > <font size="5">monthly</font> </a>
<a href="ChartSummary.jsp?code=${CODE.pureCode}" target="_blank" ><font size="3">Charts</font> </a></td>

		<div id="divMain" __AddCode="Spread DIV Tag" __AddCode="Master A DIV Tag" style="background:transparent;margin-left:auto;margin-right:auto;position:relative;width:100%;height:60%;/*Spread DIV Style*//*Master A DIV Style*/">
			<!--Page Start-->
			<!--Master A Start-->






			<!-- Document Frame ifrm_1 -->

			<!--Preamble for Document Frame ifrm_1-->
			<iframe id="ifrm_1" name="ifrm_1" src="http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=Stock&symb=au%3A${ CODE.pureCode }&x=64&y=14&time=8&startdate=1%2F4%2F1999&enddate=8%2F2%2F2016&freq=1&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=1&maval=50&uf=0&lf=268435456&lf2=0&lf3=0&type=1&style=320&size=4&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=9" class="OBJ-1" scrolling="no" __AddCode="here" style="position:absolute;left:26px;top:32px;width:100%;height:90%;/*Add Style*/"></iframe>
				<!--Postamble for Document Frame ifrm_1-->




			<!--Master A End-->
			<!--Page End-->

		<!--Master A Body End-->
		<!--Page Body End-->
	</div>

            <table class="auto-style1" style="width: 100%">
           <tr>
               <td> Current price:  <fmt:formatNumber type="currency"   maxFractionDigits="3" value="${CODE.data.close}" />          </td>
               <td> Market cap :  <fmt:formatNumber type="currency"   maxFractionDigits="3" value="${CODE.myMarketCap}" />          </td>

           </tr>
           <tr>
              <td> 20d: <fmt:formatNumber type="currency"   maxFractionDigits="3" value="${CODE.data.twenty}" />            </td>
              <td> 20d%  :     <fmt:formatNumber type="percent"   maxFractionDigits="3" value=" ${CODE.data.twentychg}" />    </td>
              <td> 20d below 60d  :     ${MovingAverage.nodayBelow20MAfor60d}  days  </td>


           </tr>
           <tr>
             <td> 5od: <fmt:formatNumber type="currency"   maxFractionDigits="3" value="${CODE.data.fifty}" />            </td>
             <td> 5od%  :     <fmt:formatNumber type="percent"   maxFractionDigits="3" value=" ${CODE.data.fiftychg}" />    </td>
             <td> 50d below 120d  :     ${MovingAverage.nodayBelow50MAfor120d}   days </td>
             <td> 50d below 240d  :     ${MovingAverage.nodayBelow50MAfor240d}     days </td>


           </tr>

          </table>


  <br>








<br>



	</body>
</html>
<!--Master A Postamble-->
<!--Page Postamble-->
