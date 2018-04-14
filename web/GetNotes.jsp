<%@ page import="access.MyNotesAccess" %>
<%@ page import="java.util.ArrayList" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>Untitled 1</title>


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

</head>



<body style="height: 1028px" bgcolor="#708090">

	<form action="GetNoteJSP" method="post">
		<p>Date: <input type="text" id="datepicker" name="MyNoteDate">


				<select  name="Mode" style="width: 100px">
				 <option value="1" selected="selected">Notes</option>
				 <option value="2">ToDo</option>
				</select>
				<input type="submit" name="Yes" value="Yes">

		</p>

	</form>


<%

ArrayList <MyNotesAccess>  arr = (ArrayList) 	request.getAttribute("MyNotes");
if(arr==null)arr=new ArrayList();

%>





	<br />
	<br />
	<%
System.out.println("MyNotesJSP :"+arr);
	for(MyNotesAccess obj:arr   ){
out.println(" <form action=\"GetNoteJSP\" method=\"post\">");

	out.println(" <input type=\"hidden\" name=\"ID\" value=\""+obj.getId()+"\">" );
	out.println("<textarea name=\"Note1\" style=\"width: 1360px; height: 152px \" id=\"styled\"  ; setbg('yellow');\" onblur=\"setbg('yellow')\" >  "+obj.getNotes()+"</textarea>");





out.println(" <br />");
out.println("<input type=\"submit\" name=\"Yes\" value=\"Yes\">");

out.println(" <br />");
out.println(" <br />");

	}
	%>

	<br />




	<br />
	<br />
<br />
<br />



	<br />
	<br />


	<br />

<br />





 <style type="text/css" style="display: none !important;">

 textarea#styled {
 	width: 600px;
 	height: 120px;
 	border: 3px solid #cccccc;
 	padding: 5px;
 	font-family: Tahoma, sans-serif;
 	background-image: url(bg.gif);
 	background-position: bottom right;
 	background-repeat: no-repeat;
	color:black;
 }
 </style>

</body>

</html>
