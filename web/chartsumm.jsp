
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

      google.charts.setOnLoadCallback(drawChart2);
    google.charts.setOnLoadCallback(drawChart3);



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


          function drawChart2() {
            var data = google.visualization.arrayToDataTable([
              ['date', 'rsi'],
              <c:forEach items="${Data}"  var="obj">

                   [new Date(${obj.year}, ${obj.month},${obj.day}),${obj.rsi}  ],


             </c:forEach>

            ]);















          var options = {
          curveType: 'function',

            hAxis: {
              title: 'Date'

            },
            vAxis: {
              title: '<c:out value="${CODE}"/>'
            }
          };



          var chart = new google.visualization.LineChart(document.getElementById('chart_div2'));

          chart.draw(data, options);
        }

        function drawChart3() {
          var data = google.visualization.arrayToDataTable([
            ['date', 'rsi vol'],
            <c:forEach items="${Data}"  var="obj">

                 [new Date(${obj.year}, ${obj.month},${obj.day}),${obj.rsivol}  ],


           </c:forEach>

          ]);















        var options = {
  curveType: 'function',
          hAxis: {

            title: 'Date'

          },
          vAxis: {
            title: '<c:out value="${CODE}"/>',
            viewWindowMode:'explicit',
                       viewWindow: {
                         max:30,
                         min:80
                       }

          }
        };



        var chart = new google.visualization.LineChart(document.getElementById('chart_div3'));

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


    <table style="width:100%">
     <tr>
       <th>    <div id="chart_div2" style="width: 900px; height: 500px"></div></th>
       <th>  <div id="chart_div3" style="width: 900px; height: 500px"></div></th>
      
     </tr>
   </table>






<c:if test="${not empty Data}">

&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; <img alt="" height="475" src="https://chart.finance.yahoo.com/z?s=${CODE}.AX&t=5yr&q=l&l=on&z=l&p=m200&a=vm&lang=en-AU&region=AU" width="700px" />

</c:if>
  </body>
</html>
