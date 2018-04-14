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



)


		<div id="divMain" __AddCode="Spread DIV Tag" __AddCode="Master A DIV Tag" style="background:transparent;margin-left:auto;margin-right:auto;position:relative;width:100%;height:60%;/*Spread DIV Style*//*Master A DIV Style*/">
			<!--Page Start-->
			<!--Master A Start-->
			
			
                       



			<!-- Document Frame ifrm_1 -->
			<!--Preamble for Document Frame ifrm_1-->
			<iframe id="ifrm_1" name="ifrm_1" src="<% out.println(request.getAttribute("CODE"));%> "class="OBJ-1" __AddCode="here" style="position:absolute;left:26px;top:32px;width:100%;height:100%;/*Add Style*/"></iframe>
			<!--Postamble for Document Frame ifrm_1-->
		
 


			<!--Master A End-->
			<!--Page End-->
		</div>
		<!--Master A Body End-->
		<!--Page Body End-->
<br>
<br>
<br>










	 <form action="ChooserJSP" method="post">

<input type="hidden" name="INDEX" value="<% out.println(request.getAttribute("INDEX"));%>">
<input type="hidden" name="CODE" value="<% out.println(request.getAttribute("CODE"));%>">
  <input type="submit" name="Next" value="Yes">


</form> 
	</body>
</html>
<!--Master A Postamble-->
<!--Page Postamble-->
