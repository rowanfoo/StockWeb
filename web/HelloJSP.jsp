<!--Page Preamble-->
<!--Master A Preamble-->

<%
response.setIntHeader("Refresh", 10); 

%>


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
 <h1> <% out.println(request.getAttribute("NAME"));%> </h1>

		<div id="divMain" __AddCode="Spread DIV Tag" __AddCode="Master A DIV Tag" style="background:transparent;margin-left:auto;margin-right:auto;position:relative;width:100%;height:60%;/*Spread DIV Style*//*Master A DIV Style*/">
			<!--Page Start-->
			<!--Master A Start-->
			
			<h2> <% out.println(request.getAttribute("CATEGORY"));%> </h2>
                       



			<!-- Document Frame ifrm_1 -->

			<!--Preamble for Document Frame ifrm_1-->
			<iframe id="ifrm_1" name="ifrm_1" src="http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=Stock&symb=au%3A<% out.println(request.getAttribute("URI"));%>&x=51&y=12&time=9&startdate=1%2F12%2F2014&enddate=1%2F1%2F2015&freq=2&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=4&maval=7&uf=0&lf=268435456&lf2=2&lf3=0&type=1&style=320&size=4&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=15" class="OBJ-1" __AddCode="here" style="position:absolute;left:26px;top:32px;width:100%;height:100%;/*Add Style*/"></iframe>
			<!--Postamble for Document Frame ifrm_1-->
			 <form action="HelloJSP" method="post">
 


			<!--Master A End-->
			<!--Page End-->
		</div>
		<!--Master A Body End-->
		<!--Page Body End-->
<br>
<br>
<br>
<br>
<form>

<input type="hidden" name="INDEX" value="<% out.println(request.getAttribute("INDEX"));%>">

  <input type="submit" name="No" value="No">
  <input type="submit" name="Yes" value="Yes">

</form> 

	</body>
</html>
<!--Master A Postamble-->
<!--Page Postamble-->