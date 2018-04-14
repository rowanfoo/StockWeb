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
      <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
      <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
      <script>
      $( function() {
      	$( "#datepicker" ).datepicker({ dateFormat: 'yy-mm-dd' });
      } );
      </script>



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


        <p class="Body"><span class="C-1">Welcome Rowan Charts system :>mode listing<</span></p>

        <form action="ChooserModeJSP2" method="post">


            Date<input list="MyModeDate" name="MyModeDate">
              <datalist id="MyModeDate">
                  <option value="techstr.date=' ' " >
                  <option value="techstr.date>' ' " >
                  <option value="techstr.date<' ' "  >
                  <option value="month(techstr.date)=  and Year(techstr.date)=YEAR(CURDATE())  ">
                  <option value="month(techstr.date)>  and Year(techstr.date)=YEAR(CURDATE())  ">


              </datalist>




     </p>
     <select name="combo1"   style="width:393px"  >
        <option value="0" SELECTED>>All </option>
         	<option value="1">>1.-5% from 50d</option>
             <option value="2">>2.&gt; avg 3 years 50d</option>
             <option value="3">>3. 3mthAvg Volume</option>
     	   <option value="4">>4.>Up 4% TODAY</option>
             <option value="5">>5.>20% from 50d</option>
             <option value="6">>6.Consequtive day down 4d</option>
             <option value="7">>7.large $ fall + low Volume</option>
     	   <option value="8">>8.3month conseq low</option>
           <option value="9">>9Down 4% TODAY</option>
             <option value="10">>Below 50d for 6 months out of 8 months</option>
               <option value="11">>Day reversal </option>
                 <option value="12">>6 month higher lows</option>
       <option value="13">>Break 6 month low</option>
              <option value="14">>Break 6 month lows</option>
                     <option value="15">>Wish list price Normandy </option>
                            <option value="16">>Wish list  buy price </option>
                                   <option value="17">>. Price rally too far from 50d, > 20% </option>
                                   <option value="18">>Leser and lesser volatility </option>
                                   <option value="19">>Break 10 month Average <5%(just break) or >5%</option>
                                   <option value="20">> Break 1$ </option>
                                   <option value="21">>Break below 1$</option>

                                   <option value="22">>Break above 2$</option>



           </select>
           <input type="submit" name="Yes" value="Yes">

      	</form>



</div>

<br>
  <br>
  <br>
    <br>
    <br>

  <div id="divMain" style="background:transparent;margin-left:auto;margin-right:auto;position:relative;width:960px;height:10;">







<%
  	System.out.println("ChooserModeJSPNOW IN JSP  :1");
ArrayList <TechStrAccess>  arr = (ArrayList ) 	request.getSession().getAttribute("TechStr");
  	System.out.println("ChooserModeJSPNOW IN JSP  :2"+arr.size());

String prefix ="au%3A";
String postfix="&x=32&y=10&time=8&startdate=1%2F4%2F1999&enddate=11%2F24%2F2016&freq=1&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=3&maval=50&uf=0&lf=268435456&lf2=0&lf3=0&type=1&style=320&size=4&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11";
String src="http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=Stock&symb=";



%>
<p class="Body"><span class="C-1"><input type="checkbox" name="autoRefresh" value="Yes">Auto Refresh</span></p>


</form>
    	<table class="auto-style1" style="width: 100%">
      <%
      String param="";
     		 String mycode="code=";

		for(TechStrAccess obj :arr  ){

			out.println("<tr>");
                out.println("<td><font size=\"2\">  "+obj.getDate()  +"</font></td>");
  		out.println("<td>  <a href=\" "+src+prefix+obj.getPureCode()+postfix +  "\" target=\"_blank\" >"+"<font size=\"3\">"+obj.getCode()  +"</font> </a></td>");
  		out.println("<td><font size=\"3\">"+obj.getName()  +"</font></td>");
  		out.println("<td><font size=\"3\">"+obj.getMode()  +"</font></td>");
  		out.println("<td><font size=\"3\">"+obj.getModeUsefullNumber()  +"</td>");


                out.println("</tr>");
                param=param+mycode+obj.getPureCode()+"&";

    }

      %>



		</table>
        </div>
    <br>
    <br>
      <div style="text-align: center">
      <a href="Charts.jsp? <%out.println(param); %> ">Charts </a>&nbsp;&nbsp;
      <a href="SpecialModeJSP">Special Mode </a>
      </div>
      <br>
      <br>


    </div>

  </div>


  </body>
</html>
