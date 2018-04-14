

<%@ page import="access.NewsAccess" %>

<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>Untitled 1</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
$(document).ready(function(){

	$('ul.tabs li').click(function(){
		var tab_id = $(this).attr('data-tab');

		$('ul.tabs li').removeClass('current');
		$('.tab-content').removeClass('current');

		$(this).addClass('current');
		$("#"+tab_id).addClass('current');
	})

})
$( function() {
  $( "#datepicker" ).datepicker({ dateFormat: 'yy-mm-dd' });
} );
	</SCRIPT>
  <style type="text/css">
  body{
  			margin-top: 100px;
  			font-family: 'Trebuchet MS', serif;
  			line-height: 1.6
  		}
  		.container{
  			width: 1500px;
  			margin: 0 auto;
  		}



  		ul.tabs{
  			margin: 0px;
  			padding: 0px;
  			list-style: none;
  		}
  		ul.tabs li{
  			background: none;
  			color: #222;
  			display: inline-block;
  			padding: 10px 15px;
  			cursor: pointer;
  		}

  		ul.tabs li.current{
  			background: #ededed;
  			color: #222;
  		}

  		.tab-content{
  			display: none;
  			background: #ededed;
  			padding: 15px;
  		}

  		.tab-content.current{
  			display: inherit;
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

<body  bgcolor="#708090">
  <div class="container">
    <form action="NewsSearchJSP" method="post">
        <p>Date: <input type="text" id="datepicker" name="MyModeDate">
          	<input name="monthly" type="checkbox"  value="Y" /> Monthly &nbsp&nbsp

            Date<input list="CustomDate" name="CustomDate">
              <datalist id="CustomDate">
                  <option value="techstr.date=' ' " >
                  <option value="techstr.date>' ' " >
                  <option value="techstr.date<' ' "  >
                  <option value="month(techstr.date)=  and Year(techstr.date)=YEAR(CURDATE())  ">
                  <option value="month(techstr.date)>  and Year(techstr.date)=YEAR(CURDATE())  ">


              </datalist>



   <input type="submit" name="Yes" value="Yes">

        </form>


  	<ul class="tabs">
  		<li class="tab-link current" data-tab="tab-1"> Change of Director </li>
  		<li class="tab-link" data-tab="tab-2">Webcast</li>
  		<li class="tab-link" data-tab="tab-3">Briefing</li>
  	  <li class="tab-link" data-tab="tab-4">boardroom </li>
      <li class="tab-link" data-tab="tab-5">teleconference </li>
      <li class="tab-link" data-tab="tab-6">CEO </li>
      <li class="tab-link" data-tab="tab-7"> update</li>
      <li class="tab-link" data-tab="tab-8"> conference</li>
      <li class="tab-link" data-tab="tab-9"> management</li>
      <li class="tab-link" data-tab="tab-10">Updated </li>



  	</ul>

  	<div id="tab-1" class="tab-content current">
<table class="auto-style1" style="width: 100%">
  <c:forEach items="${Director}"  var="obj">


    <tr>
     <td> <a href="http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=Stock&symb=au%3A${obj.code}&x=56&y=11&time=10&startdate=1%2F4%2F1999&enddate=8%2F2%2F2016&freq=2&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=1&maval=12&uf=0&lf=268435456&lf2=0&lf3=0&type=1&style=320&size=4&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11"  ><font size="3">${obj.code}</font></a> </td>
    <td><font size="3">${obj.title} </td>
    </tr>
    </c:forEach>
    </table>
  	</div>

    <div id="tab-2" class="tab-content">
        <c:forEach items="${Webcast}"  var="obj">
          <tr>
            <td> <a href="http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=Stock&symb=au%3A${obj.code}&x=56&y=11&time=10&startdate=1%2F4%2F1999&enddate=8%2F2%2F2016&freq=2&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=1&maval=12&uf=0&lf=268435456&lf2=0&lf3=0&type=1&style=320&size=4&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11"  ><font size="3">${obj.code}</font></a> </td>

          <td><font size="3">${obj.title} </td>
          </tr>
          </c:forEach>
          </table>



    	</div>
    	<div id="tab-3" class="tab-content">
        <c:forEach items="${Briefing}"  var="obj">
          <tr>
            <td> <a href="http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=Stock&symb=au%3A${obj.code}&x=56&y=11&time=10&startdate=1%2F4%2F1999&enddate=8%2F2%2F2016&freq=2&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=1&maval=12&uf=0&lf=268435456&lf2=0&lf3=0&type=1&style=320&size=4&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11"  ><font size="3">${obj.code}</font></a> </td>

          <td><font size="3">${obj.title} </td>
          </tr>
          </c:forEach>
          </table>

    	</div>
    	<div id="tab-4" class="tab-content">
        <c:forEach items="${boardroom}"  var="obj">
          <tr>
            <td> <a href="http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=Stock&symb=au%3A${obj.code}&x=56&y=11&time=10&startdate=1%2F4%2F1999&enddate=8%2F2%2F2016&freq=2&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=1&maval=12&uf=0&lf=268435456&lf2=0&lf3=0&type=1&style=320&size=4&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11"  ><font size="3">${obj.code}</font></a> </td>

          <td><font size="3">${obj.title} </td>
          </tr>
          </c:forEach>
          </table>

    	</div>
      <div id="tab-5" class="tab-content">
        <c:forEach items="${teleconference}"  var="obj">
          <tr>
            <td> <a href="http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=Stock&symb=au%3A${obj.code}&x=56&y=11&time=10&startdate=1%2F4%2F1999&enddate=8%2F2%2F2016&freq=2&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=1&maval=12&uf=0&lf=268435456&lf2=0&lf3=0&type=1&style=320&size=4&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11"  ><font size="3">${obj.code}</font></a> </td>

          <td><font size="3">${obj.title} </td>
          </tr>
          </c:forEach>
          </table>

    	</div>
      <div id="tab-6" class="tab-content">
        <c:forEach items="${CEO}"  var="obj">
          <tr>
            <td> <a href="http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=Stock&symb=au%3A${obj.code}&x=56&y=11&time=10&startdate=1%2F4%2F1999&enddate=8%2F2%2F2016&freq=2&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=1&maval=12&uf=0&lf=268435456&lf2=0&lf3=0&type=1&style=320&size=4&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11"  ><font size="3">${obj.code}</font></a> </td>

          <td><font size="3">${obj.title} </td>
          </tr>
          </c:forEach>
          </table>

    	</div>
      <div id="tab-7" class="tab-content">
        <c:forEach items="${update}"  var="obj">
          <tr>
            <td> <a href="http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=Stock&symb=au%3A${obj.pureCode}&x=56&y=11&time=10&startdate=1%2F4%2F1999&enddate=8%2F2%2F2016&freq=2&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=1&maval=12&uf=0&lf=268435456&lf2=0&lf3=0&type=1&style=320&size=4&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11"  ><font size="3">${obj.code}</font></a> </td>

          <td><font size="3">${obj.title} </td>
          </tr>
          </c:forEach>
          </table>

    	</div>
      <div id="tab-8" class="tab-content">
        <c:forEach items="${conference}"  var="obj">
          <tr>
            <td> <a href="http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=Stock&symb=au%3A${obj.code}&x=56&y=11&time=10&startdate=1%2F4%2F1999&enddate=8%2F2%2F2016&freq=2&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=1&maval=12&uf=0&lf=268435456&lf2=0&lf3=0&type=1&style=320&size=4&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11"  ><font size="3">${obj.code}</font></a> </td>

          <td><font size="3">${obj.title} </td>
          </tr>
          </c:forEach>
          </table>

    	</div>
      <div id="tab-9" class="tab-content">
        <c:forEach items="${management}"  var="obj">
          <tr>
            <td> <a href="http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=Stock&symb=au%3A${obj.code}&x=56&y=11&time=10&startdate=1%2F4%2F1999&enddate=8%2F2%2F2016&freq=2&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=1&maval=12&uf=0&lf=268435456&lf2=0&lf3=0&type=1&style=320&size=4&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11"  ><font size="3">${obj.code}</font></a> </td>

          <td><font size="3">${obj.title} </td>
          </tr>
          </c:forEach>
          </table>

    	</div>

      <div id="tab-10" class="tab-content">
        <c:forEach items="${Updated}"  var="obj">
          <tr>
            <td> <a href="http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=Stock&symb=au%3A${obj.code}&x=56&y=11&time=10&startdate=1%2F4%2F1999&enddate=8%2F2%2F2016&freq=2&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=1&maval=12&uf=0&lf=268435456&lf2=0&lf3=0&type=1&style=320&size=4&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11"  ><font size="3">${obj.code}</font></a> </td>

          <td><font size="3">${obj.title} </td>
          </tr>
          </c:forEach>
          </table>

    	</div>






  </div><!-- container -->

</body>

</html>
