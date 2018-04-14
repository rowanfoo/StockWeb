
<%@ page import="access.NewsAccess" %>
<%@ page import="java.util.ArrayList" %>
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

    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
    $( function() {
      $( "#datepicker" ).datepicker({ dateFormat: 'yy-mm-dd' });
    } );

    </script>


  </head>

<body style="height: 1028px" bgcolor="#E6E6E6">
    <div id="divMain" style="background:transparent;margin-left:auto;margin-right:auto;position:relative;width:960px;height:100;">


        <p class="Body"><span class="C-1">Welcome Rowan Charts system :>mode listing<</span></p>

    <form action="NewsListJSP" method="post">
      	<p>Date: <input type="text" id="datepicker" name="MyModeDate">
          <select name="NEWSTYPE">
              <option value="Intrested"   <c:if test="${NEWSTYPE =='Intrested'}"> selected="selected"  </c:if>    >Intrested</option>
              <option value="Yes"  <c:if test="${NEWSTYPE =='okay'}"> selected="selected"  </c:if>    >YES</option>
                  <option value="wishlist"  <c:if test="${NEWSTYPE =='wishlist'}"> selected="selected"  </c:if>    >WishList</option>
                      <option value="news"  <c:if test="${NEWSTYPE =='news'}"> selected="selected"  </c:if>    >NEWS</option>

           </select>


  	<input name="monthly" type="checkbox"  value="Y" /> Monthly &nbsp&nbsp
         <input type="submit" name="Yes" value="Yes">

     </p>


  <c:if test="${empty error}">
<p>     <h2>${error}    </h2></p>
</c:if>

      	</form>






        <table class="auto-style1" style="width: 100%">
          <tr>

              <td><font size="3"name</font></td>



<c:if test="{NEWSTYPE =='Intrested'}">
  <td><font size="3">notes</td>

</c:if>


<c:if test="{NEWSTYPE =='okay'}">
    <td><font size="3">Yes Notes</td>
</c:if>

<c:if test="{(NEWSTYPE =='news')||(NEWSTYPE =='wishlist') }">
  <td><font size="3">title</td>

</c:if>






         </tr>
         <%
         int count =0;
         %>
        <c:forEach items="${ASXNEWSLIST}"  var="obj">
       <tr>
           <td> <a href="/NewsListJSP?index=<% out.println(count++);%>"  ><font size="3">${obj.code}</font></a> </td>

          <c:if test="${NEWSTYPE =='Intrested'}">
            <td><font size="3">${obj.notes} </td>

          </c:if>


          <c:if test="${NEWSTYPE =='okay'}">
              <td><font size="3">${obj.yesNotes} </td>
          </c:if>

          <c:if test="${(NEWSTYPE =='news')||(NEWSTYPE =='wishlist') }">


            <td> <a href="${obj.link}" target="_blank"><font size="3">${obj.title}</font></a></td>


          </c:if>
          <td>  <a href="ChartSummary.jsp?code=${obj.code}" target="_blank" ><font size="3">Charts</font> </a></td>








      </tr>
            </c:forEach>

      </table>

          </div>
      <br>
      <br>
        <div style="text-align: center">
        <a href="Charts.jsp?${LINK}">All Charts </a>&nbsp;&nbsp;
        <a href="Charts5.jsp?${LINK}">All Charts 5yr</a>&nbsp;&nbsp;
        <a href="NewsJSP">All news Today </a>&nbsp;&nbsp;
        <a href="NewsJSP?autorefresh=y">All news Today (Auto Refresh) </a>

        </div>
        <br>
        <br>







<br>
  <br>
  <br>
    <br>
    <br>

  <div id="divMain" style="background:transparent;margin-left:auto;margin-right:auto;position:relative;width:960px;height:10;">




  </div>


  </body>
</html>
