<!--Page Preamble-->
<!--Master A Preamble-->

<%@ page import="java.text.DecimalFormat" %>

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
		<style type="text/css">
			/*Page StyleSheet*/
			/*Master A StyleSheet*/
			.OBJ-1 { border:1px solid #000000;border-radius:0; }
		</style>
	</head>
	<body __AddCode="PageInBodyTag" __AddCode="Master A In Body Tag" style="height:2000px;background:#ffffff;/*Page Body Style*//*Master A Body Style*/">
		<!--Page Body Start-->
		<!--Master A Body Start-->
 <h1> <% out.println(request.getAttribute("CODE"));%> </h1>(
<% 
//int index =Integer.parseInt((String)request.getAttribute("INDEX"));
//int total =Integer.parseInt((String)request.getAttribute("TOTAL"));
double index = ((Double)request.getAttribute("INDEX")).doubleValue();
double total = ((Double)request.getAttribute("TOTAL")).doubleValue();
DecimalFormat df = new DecimalFormat("#.#");

double precentage = ((index/total)*100);
out.println(index+" / "+total+" :  : ");



%>

<font size="4" color="blue"><b><% out.println(df.format(precentage)+" % "  );      %></b></font>


)


		<div id="divMain" __AddCode="Spread DIV Tag" __AddCode="Master A DIV Tag" style="background:transparent;margin-left:auto;margin-right:auto;position:relative;width:100%;height:60%;/*Spread DIV Style*//*Master A DIV Style*/">
			<!--Page Start-->
			<!--Master A Start-->
			
			
                       



			<!-- Document Frame ifrm_1 -->

			<!--Preamble for Document Frame ifrm_1-->
			<iframe id="ifrm_1" name="ifrm_1" src="http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=Stock&symb=au%3A<% out.println(request.getAttribute("CODE"));%>&time=10&startdate=1%2F4%2F1999&enddate=7%2F25%2F2016&freq=2&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=1&maval=12&uf=0&lf=268435456&lf2=0&lf3=0&type=1&style=320&size=4&x=55&y=17&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11" class="OBJ-1" __AddCode="here" style="position:absolute;left:26px;top:32px;width:100%;height:100%;/*Add Style*/"></iframe>
				<!--Postamble for Document Frame ifrm_1-->
		
 


			<!--Master A End-->
			<!--Page End-->
		</div>
		<!--Master A Body End-->
		<!--Page Body End-->
<br>
<br>
<br>
 <font size="50"><a href="<% out.println(request.getAttribute("LINK"));%> "><% out.println(request.getAttribute("HEADLINE"));%> </a> </font>
<br>


	 <form action="AsxJSP" method="post">

<input type="hidden" name="INDEX" value="<% out.println(request.getAttribute("INDEX"));%>">
<input type="hidden" name="CODE" value="<% out.println(request.getAttribute("CODE"));%>">

 <textarea rows="4" cols="50" name="PRECOMMENT">

</textarea> 
  
	<input type="submit" name="No" value="No">
  <input type="submit" name="Yes" value="Yes">

</form> 

	</body>
</html>
<!--Master A Postamble-->
<!--Page Postamble-->