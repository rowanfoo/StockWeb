<%@ page import="access.TechStrAccess" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="factory.DAOFactoryTechStr" %>


<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>Home</title>
    <meta name="generator" content="Serif WebPlus X8 (16,0,1,21)">
    <meta name="viewport" content="width=960">
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
    <div id="divMain" style="background:transparent;margin-left:auto;margin-right:auto;position:relative;width:960px;height:100px;">


        <p class="Body"><span class="C-1">Welcome Rowan Charts system</span></p>
        <p class="Body"><span class="C-1">mode listing</span></p>


<form name=frmTest  action="SpecialModeJSP" method="post">
 <p class="Body"><span class="C-1"><input type="checkbox" name="Refresh" value="Yes">Auto Refresh</span></p>
<input type="submit" value="Submit">
</form>





<%


     ArrayList <TechStrAccess>  arr =null;

try {

        arr =  (ArrayList<TechStrAccess>) request.getAttribute("SPECIALMODE");






         //ArrayList <TechStrAccess>  arr = (ArrayList ) 	request.getSession().getAttribute("TechStr");

  //      request.getSession().setAttribute("TechStr",myarr);
        //request.getSession().setAttribute("TechStr",arr);
        System.out.println("SpecialJSP doGET START ARR:"+arr.size());
        System.out.println("SpecialJSP doGET  FINISH");

      } catch (Exception e) {	System.out.println("ModeJSP doGet ERROR :"+e);  }


      String prefix ="au%3A";
      String postfix="&x=49&y=19&time=10&startdate=1%2F4%2F1999&enddate=8%2F12%2F2016&freq=2&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=3&maval=12&uf=0&lf=268435456&lf2=0&lf3=0&type=1&style=320&size=4&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11";
      String src="http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=Stock&symb=";




%>


    	<table class="auto-style1" style="width: 100%">
      <%
    //  System.out.println("ModeJSP make table ");
      //  System.out.println("ModeJSP make table "+arr);
  //    System.out.println("ModeJSP elem:"+arr.get(0));

		for(TechStrAccess obj :arr  ){
        //System.out.println("ModeJSP make table 2");
			out.println("<tr>");
                out.println("<td><font size=\"2\">  "+obj.getDate()  +"</font></td>");

      out.println("<td>  <a href=\" "+src+prefix+obj.getPureCode()+postfix +  "\" target=\"_blank\" >"+"<font size=\"3\">"+obj.getCode()  +"</font> </a></td>");
			out.println("<td><font size=\"3\">"+obj.getName()  +"</font></td>");
			out.println("<td><font size=\"3\">"+obj.getMode()  +"</font></td>");
			out.println("<td><font size=\"3\">"+obj.getModeUsefullNumber()  +"</td>");

                out.println("</tr>");
		}
      %>



		</table>
    </div>



  </body>
</html>
