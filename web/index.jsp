<%@ page import="access.MyNotesAccess" %>
<%@ page import="java.util.HashSet" %>


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

	<br />
	<br />
<h2>Welcome - Happy& Joyfull Searching </h2>

	<br />




	<br />



<p><a href = "ChooserModeJSP" ><font face="verdana" color="white" size="6">Choose daily trigger mode</font> </a>   </p>
<p><a href = "SpecialModeJSP" ><font face="verdana" color="white" size="6">Choose monthly special mode</font> </a>   </p>
<p><a href = "ChooserModeJSP2" ><font face="verdana" color="white" size="6">Choose date  mode</font> </a>   </p>


<hr width="20%" size="8" align="left">
	<p><h2>Stock</h2></p>
	<br>
<p><a href = "StockJSP" ><font face="verdana" color="white" size="6">Edit Stock details</font></a>   </p>
<p><a href = "ReportJSP" ><font face="verdana" color="white" size="6">Create Stock Report</font></a>   </p>
<hr width="20%" size="8" align="left">
<p><a href = "CategoryJSP" ><font face="verdana" color="white" size="6">Listing by Category </font></a>   </p>



<hr width="20%" size="8" align="left">
	<p><h2>News</h2></p>
	<br>
<p><a href = "TodayStockJSP" ><font face="verdana" color="white" size="6">LIVE data now ,  </a></font>   </p>
<p><a href = "ChooserModePanicJSP" ><font face="verdana" color="white" size="6">Panic,  </a></font>   </p>

<p><a href = "NewsListJSP" ><font face="verdana" color="white" size="6">List of news for today  </a></font>   </p>
<p><a href = "ChooseNewsJSP.jsp" ><font face="verdana" color="white" size="6">Select date for news ,  </a></font>   </p>
<p><a href = "NewsSearchJSP" ><font face="verdana" color="white" size="6">News by keywords  </a></font>   </p>

<hr width="20%" size="8" align="left">
<p><h2>Notes</h2></p>
<br>
<p><a href = "MyNotesJSP" ><font face="verdana" color="white" size="6">Create new Notes</font></a>   </p>
<p><a href = "GetNoteJSP" ><font face="verdana" color="white" size="6">Edit Notes</a></font>   </p>
<p><a href = "ChooserNoteJSP" ><font face="verdana" color="white" size="6">List Notes</a></font>   </p>

<hr width="20%" size="8" align="left">
<p><h2>WorkSheet</h2></p>
<br>
<p><a href = "WorkSheetJSP" ><font face="verdana" color="white" size="6">Create new WorkSheet</font></a>   </p>
<p><a href = "ChooserWorkSheetJSP" ><font face="verdana" color="white" size="6">Find workSheet</a></font>   </p>
<hr width="20%" size="8" align="left">
<p><h2>Research charts</h2></p>
<br>
<p><a href = "ResearchJSP" ><font face="verdana" color="white" size="6">Runner charts</font></a>   </p>
<p><a href = "ReportJSP" ><font face="verdana" color="white" size="6">Report</font></a>   </p>
<p><a href = "RSJSP" ><font face="verdana" color="white" size="6">Relative Strenght</font></a>   </p>
<p><a href = "SummaryJSP" ><font face="verdana" color="white" size="6">RSI,RS,..</font></a>   </p>
<p><a href = "ChooserLookJSP" ><font face="verdana" color="white" size="6">Browsing through stocks </a></font>   </p>
<p><a href = "Research/chart" ><font face="verdana" color="white" size="6">Research images </a></font>   </p>
<p><a href = "Research/chartres" ><font face="verdana" color="white" size="6">Research charts by code</a></font>   </p>
<p><a href = "SaveChart/chart" ><font face="verdana" color="white" size="6"> Save Research images </a></font>   </p>
<p><a href = "SaveChart/chartres" ><font face="verdana" color="white" size="6">Save Research charts by code</a></font>   </p>
<p><a href = "JPA/notes" ><font face="verdana" color="white" size="6"> Enter Buy/Sell Trade </a></font>   </p>
<p><a href = "JPA/findTrade" ><font face="verdana" color="white" size="6">Find Buy/Sell Trade</a></font>   </p>
<p><a href = "JPACompany/display" ><font face="verdana" color="white" size="6">Enter Research Info</a></font>   </p>


<hr width="20%" size="8" align="left">
<p><h2>Weekly</h2></p>
<br>
	<p><a href = "Week/getWeek" ><font face="verdana" color="white" size="6">Weekly Mode</font></a>   </p>

	<p><a href = "Summary/getIndex" ><font face="verdana" color="white" size="6">Asx Index Charts</font></a>   </p>
	<p><a href = "Summary/getWishlist" ><font face="verdana" color="white" size="6">WishList Charts</font></a>   </p>


	<hr width="20%" size="8" align="left">
	<p><h2>Search</h2></p>
	<br>
		<p><a href = "NewsSearchJSP" ><font face="verdana" color="white" size="6">Find News</font></a>   </p>
		<p><a href = "CategoryJSP" ><font face="verdana" color="white" size="6">Listing by Category </font></a>   </p>
		<p><a href = "ASX/getASX" ><font face="verdana" color="white" size="6"> All ASX company </a></font>   </p>
		<p><a href = "ASX/lookASX" ><font face="verdana" color="white" size="6">Get all ok ASX </a></font>   </p>
		<p><a href = "NewsSearchJSP" ><font face="verdana" color="white" size="6">News by keywords  </a></font>   </p>
	<p><a href = "Week/getWeek" ><font face="verdana" color="white" size="6">Mode by Week </a></font>   </p>





<hr width="20%" size="20" align="left">
<p>Daily</p>

<p><a href = "ChooserModeJSP" ><font face="verdana" color="white" size="6">Choose daily trigger mode</font> </a>   </p>
<p><a href = "NewsListJSP" ><font face="verdana" color="white" size="6">List of news for today  </a></font>   </p>
<p><a href = "CategoryJSP" ><font face="verdana" color="white" size="6">Listing by Category </font></a>   </p>


	<br />
	<br />
	<hr width="20%" size="20" align="left">
	<p>Daily</p>

	<p><a href = "MyDiary/DiaryAdd.jsp" ><font face="verdana" color="white" size="6">Add report today </font> </a>   </p>
	<p><a href = "MyDiary/WeekReport.jsp" ><font face="verdana" color="white" size="6"Daily report  </a></font>   </p>


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
