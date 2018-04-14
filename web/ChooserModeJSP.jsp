<%@ page import="access.TechStrAccess" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Hashtable" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="access.StockAccess" %>

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

        <form name=frmTest action="ChooserModeJSP" method="post">
      		<p>Date: <input type="text" id="datepicker" name="MyModeDate">



          <select name="TOP">
           <option value="Top 100-300"      >Top 100-300</option>
           <option value="Top Others"   ${requestScope.TOP == 'Top Others' ? 'selected' : ''}        >Top Others</option>
           <option value="Top 1B"  ${requestScope.TOP == 'Top 1B' ? 'selected' : ''}    >Top 1B</option>
           <option value="Top 500"  ${requestScope.TOP == 'Top 500' ? 'selected' : ''}   >Top 500</option>
            <option value="Monthly"  ${requestScope.TOP == 'Monthly' ? 'selected' : ''}   >Monthly Mode</option>
           <option value="Top 250">Top 250</option>
         </select>
         <input type="submit" name="Yes" value="Yes">

     </p>


     



</div>

<br>
  <br>
  <br>
    <br>
    <br>

  <div id="divMain" style="background:transparent;margin-left:auto;margin-right:auto;position:relative;width:960px;height:10;">




<select name="combo1" class="OBJ-1" size="5" style="width:393px;height:110px;"  onChange="frmTest.submit();">
	<option value="" SELECTED>Choose One
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
 		         <option value="13">ALL</option>



      </select>


<%
  	System.out.println("ChooserModeJSPNOW IN JSP  :1");
ArrayList <TechStrAccess>  arr = (ArrayList ) 	request.getSession().getAttribute("TechStr");
Hashtable<String,ArrayList<String>>  tb = (Hashtable<String,ArrayList<String>>) 	request.getSession().getAttribute("TechStrTable");
HashMap <String ,StockAccess>    wishlist =(HashMap <String ,StockAccess> )request.getSession().getAttribute("WishList");

String prefix ="au%3A";
String postfix="&x=57&y=18&time=8&startdate=1%2F4%2F1999&enddate=11%2F24%2F2016&freq=1&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=3&maval=50&uf=0&lf=268435456&lf2=2&lf3=0&type=1&style=320&size=4&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11";
String src="http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=Stock&symb=";
String postfix2="&x=23&y=11&time=7&startdate=1%2F4%2F1999&enddate=11%2F24%2F2016&freq=1&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=3&maval=20&uf=0&lf=268435456&lf2=2&lf3=0&type=1&style=320&size=4&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11";


String pre=" https://au.finance.yahoo.com/chart/";
String pro="#eyJzaG93QXJlYSI6ZmFsc2UsIm11bHRpQ29sb3JMaW5lIjpmYWxzZSwiYm9sbGluZ2VyVXBwZXJDb2xvciI6IiNlMjAwODEiLCJib2xsaW5nZXJMb3dlckNvbG9yIjoiIzk1NTJmZiIsInNob3dTbWEiOnRydWUsInNtYUNvbG9ycyI6IiNmMDEyNmYsIzFhYzU2NyIsInNtYVBlcmlvZHMiOiIyMCw0MCIsInNtYVdpZHRocyI6IjQsMSIsInNtYUdob3N0aW5nIjoiMCwwIiwibWZpTGluZUNvbG9yIjoiIzQ1ZTNmZiIsIm1hY2REaXZlcmdlbmNlQ29sb3IiOiIjZmY3YjEyIiwibWFjZE1hY2RDb2xvciI6IiM3ODdkODIiLCJtYWNkU2lnbmFsQ29sb3IiOiIjMDAwMDAwIiwicnNpTGluZUNvbG9yIjoiI2ZmYjcwMCIsInN0b2NoS0xpbmVDb2xvciI6IiNmZmI3MDAiLCJzdG9jaERMaW5lQ29sb3IiOiIjNDVlM2ZmIiwibGluZVR5cGUiOiJsaW5lIiwicmFuZ2UiOiIxeSJ9";
String postfix20cross40="&x=27&y=10&time=8&startdate=1%2F4%2F1999&enddate=11%2F24%2F2016&freq=1&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=3&maval=20&uf=0&lf=268435456&lf2=2&lf3=0&type=1&style=320&size=4&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11";


%>
<p class="Body"><span class="C-1"><input type="checkbox" name="autoRefresh" value="Yes">Auto Refresh</span></p>


</form>
    	<table class="auto-style1" style="width: 100%">
      <%
      String param="";
 		 String mycode="code=";

		for(TechStrAccess obj :arr  ){
      if( wishlist.get(obj.getCode())!= null || obj.getMode()==0  ){ out.println("<tr style=\"background-color:red\">"); }
      else{out.println("<tr>"); }

                out.println("<td><font size=\"2\">  "+obj.getDate()  +"</font></td>");

                if(obj.getMode()==29)   out.println("<td>  <a href=\" "+src+prefix+obj.getPureCode()+postfix2 +  "\" target=\"_blank\" >"+"<font size=\"3\">"+obj.getCode()  +"</font> </a></td>");
                else if (obj.getMode()==30)   out.println("<td>  <a href=\" "+src+prefix+obj.getPureCode()+postfix20cross40 +  "\" target=\"_blank\" >"+"<font size=\"3\">"+obj.getCode()  +"</font> </a></td>");
                else if (obj.getMode()==32)   out.println( " <td>   <a href=\" Charts8.jsp?code="+ obj.getPureCode()+"\" target=\"_blank\"><font size=\"3\">"+obj.getCode() +" </font></a>&nbsp;&nbsp;</td>");
                else if (obj.getMode()==0)   out.println( " <td>  <font size=\"3\">"+"Error RSI " +" </font></a>&nbsp;&nbsp;</td>");

                else   out.println("<td>  <a href=\" "+src+prefix+obj.getPureCode()+postfix +  "\" target=\"_blank\" >"+"<font size=\"3\">"+obj.getCode()  +"</font> </a></td>");






  		out.println("<td><font size=\"3\">"+obj.getName()  +"</font></td>");
  		out.println("<td><font size=\"3\">"+obj.getMode()  +"</font></td>");
  		out.println("<td><font size=\"3\">"+obj.getModeUsefullNumber()  +"</td>");
      out.println("<td>  <a href=\"Research/setResearch?code="+obj.getCode()+ "\" target=\"_blank\" >"+"<font size=\"3\">"+"Charts" +"</font> </a></td>");
            out.println("<td>  <a href=\"chart9.jsp?code="+obj.getCode()+ "\" target=\"_blank\" >"+"<font size=\"3\">"+" My Charts" +"</font> </a></td>");
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
        <div style="text-align: center">

        <%

        Enumeration<String>  key = tb.keys();

              while(key.hasMoreElements()){
                String name=key.nextElement();
                ArrayList<String> myarr= tb.get(name);
                String links="";
                for(String link:myarr){
                  links = links+link;

                }

                if(name.equals("mode 29" ))  out.println("<a href=Charts6.jsp?"+links+">"+name+"</a>&nbsp;&nbsp;");
                else if(name.equals("mode 30" ))  out.println("<a href=Charts7.jsp?"+links+">"+name+"</a>&nbsp;&nbsp;");
                else if(name.equals("mode 32" ))  out.println("<a href=Charts8.jsp?"+links+">"+name+"</a>&nbsp;&nbsp;");
                else    out.println("<a href=Charts5.jsp?"+links+">"+name+"</a>&nbsp;&nbsp;");



              }

        %>
        </div>




      <br>


    </div>

  </div>


  </body>
</html>
