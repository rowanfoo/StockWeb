<!--Page Preamble-->
<!--Master A Preamble-->

<%@ page import="java.text.DecimalFormat" %>
<%@ page import="access.NewsAccess" %>
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


		<!--Page Head-->
		<!--Master A Head-->
		<link rel="stylesheet" type="text/css" href="wpscripts/wpstyles.css">
		<style type="text/css">
			/*Page StyleSheet*/
			/*Master A StyleSheet*/
			.OBJ-1 { border:1px solid #000000;border-radius:0; }
		</style>

<%
if(request.getAttribute("autorefresh") !=null ){
  out.println("<meta http-equiv=\"refresh\" content=\"20\">");

}


  %>
	</head>
	<body __AddCode="PageInBodyTag" __AddCode="Master A In Body Tag" style="height:2000px;background:#ffffff;/*Page Body Style*//*Master A Body Style*/">
		<!--Page Body Start-->
		<!--Master A Body Start-->

<%
//int index =Integer.parseInt((String)request.getAttribute("INDEX"));
//int total =Integer.parseInt((String)request.getAttribute("TOTAL"));
int index = ((Integer)request.getAttribute("INDEX")).intValue();
int total = ((Integer)request.getSession().getAttribute("TOTAL")).intValue();
DecimalFormat df = new DecimalFormat("#.#");

double precentage =0;
if(total>0){
   precentage = ((index/total)*100);

}

out.println(index+" / "+total+" :  : ");
ArrayList <NewsAccess> myarr = (ArrayList <NewsAccess> ) request.getSession().getAttribute("ASXNEWSLIST");
 NewsAccess obj =(NewsAccess) myarr.get(index);
request.setAttribute("news",obj);
request.setAttribute("newsItem",obj.getNewsCollection () );

//request.setAttribute("PERCENTAGE",precentage +"");

%>
 <h1>${news.code}</h1>(
<font size="4" color="blue"><b><% out.println(df.format(precentage)+" % "  );      %></b></font>



)
<br>
<a href="http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=Stock&symb=au%3A${ news.code }&x=64&y=14&time=8&startdate=1%2F4%2F1999&enddate=8%2F2%2F2016&freq=1&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=1&maval=50&uf=0&lf=268435456&lf2=0&lf3=0&type=1&style=320&size=4&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=9"  target="_blank" >  <font size="5">daily</font> </a>&nbsp

<a href="http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=Stock&symb=au%3A${ news.code }&x=50&y=19&time=12&startdate=1%2F4%2F1999&enddate=8%2F2%2F2016&freq=3&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=1&maval=10&uf=0&lf=268435456&lf2=0&lf3=0&type=1&style=320&size=4&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11 "  target="_blank" > <font size="5">monthly</font> </a>

		<div id="divMain" __AddCode="Spread DIV Tag" __AddCode="Master A DIV Tag" style="background:transparent;margin-left:auto;margin-right:auto;position:relative;width:100%;height:60%;/*Spread DIV Style*//*Master A DIV Style*/">
			<!--Page Start-->
			<!--Master A Start-->






			<!-- Document Frame ifrm_1 -->

			<!--Preamble for Document Frame ifrm_1-->
			<iframe id="ifrm_1" name="ifrm_1" src="http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=Stock&symb=au%3A${ news.code }&time=10&startdate=1%2F4%2F1999&enddate=8%2F2%2F2016&freq=2&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=1&maval=12&uf=0&lf=268435456&lf2=0&lf3=0&type=1&style=320&size=4&x=54&y=17&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11" class="OBJ-1" __AddCode="here"  scrolling="no" style=width:100%;height:100%;/*Add Style*/" ></iframe>
				<!--Postamble for Document Frame ifrm_1-->




			<!--Master A End-->
			<!--Page End-->
		</div>
		<!--Master A Body End-->
		<!--Page Body End-->
<br>
<br>
<br>




  <c:forEach items="${newsItem}"  var="obj">

 			<<a href="${obj.link} "  target="_blank" > <font size="5">${obj.title}</font> </a> >&nbsp;&nbsp;&nbsp;


 		 </c:forEach>






<br>


	 <form action="NewsJSP" method="post">

<input type="hidden" name="INDEX" value="${INDEX}">

 <textarea rows="4" cols="50" name="PRECOMMENT">

</textarea>

	<input type="submit" name="No" value="No" autofocus>
  <input type="submit" name="Yes" value="Yes">

</form>

	</body>
</html>
<!--Master A Postamble-->
<!--Page Postamble-->
