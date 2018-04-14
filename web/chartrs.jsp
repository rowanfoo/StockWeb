
<%@ page import="access.DataAccess" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Hashtable" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

    <script type="text/javascript">
    <c:if test="${not empty Data}">

      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);





      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['date', 'Strenght'],
          <c:forEach items="${Data}"  var="obj">

               [new Date(${obj.year}, ${obj.month},${obj.day}),${obj.relativeStrenght}  ],


         </c:forEach>

        ]);















      var options = {
        hAxis: {
          title: 'Date'

        },
        vAxis: {
          title: '<c:out value="${CODE}"/>'
        }
      };



      var chart = new google.visualization.LineChart(document.getElementById('chart_div'));

      chart.draw(data, options);
    }

</c:if>
    </script>
  </head>
  <body>

    <form name="relativeStrenght" action="${path}" method="post">

    	<br />
    	<br />

    Code<input list="browsers" name="CODE" >
      <datalist id="browsers">
        <c:forEach var="entry" items="${Stock}">
            <option value="${entry.key}">
        </c:forEach>
      </datalist>
   <input type="submit" name="Yes" value="Yes">

</form>






    <div id="chart_div" style="width: 900px; height: 500px"></div>


<c:if test="${not empty Data}">

&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; <img alt="" height="475" src="https://chart.finance.yahoo.com/z?s=${CODE}.AX&t=5yr&q=l&l=on&z=l&p=m200&a=vm&lang=en-AU&region=AU" width="700px" />

</c:if>
  </body>
</html>
