<html>
  <head>
    <%@ page import="access.DataReport" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="java.util.ListIterator" %>



    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.load('current', {packages: ['corechart', 'bar']});
      google.charts.setOnLoadCallback(drawBasic);
            google.charts.setOnLoadCallback(drawBasic0);
      google.charts.setOnLoadCallback(drawBasicX);




        google.charts.setOnLoadCallback(drawBasic1);
      google.charts.setOnLoadCallback(drawBasic2);
      google.charts.setOnLoadCallback(drawBasic3);
    google.charts.setOnLoadCallback(drawBasic4);




      <%
       System.out.println("IN JSP");
      ArrayList <DataReport>  arr = (ArrayList ) 	request.getAttribute("report");
      ArrayList <DataReport>  arr2 = (ArrayList ) 	request.getAttribute("report2");
     ArrayList <DataReport>  downprice = (ArrayList ) 	request.getAttribute("downupprice");
 ArrayList <DataReport>  downvol = (ArrayList ) 	request.getAttribute("downupvol");
 ArrayList <DataReport>  pricevariance = (ArrayList ) 	request.getAttribute("pricevariance");
 ArrayList <DataReport>  tenmonth = (ArrayList ) 	request.getAttribute("tenmonth");
DataReport dt = arr.get(0);


      %>



      function drawBasic() {

        var data = google.visualization.arrayToDataTable([
                ['month', 'average away from 50d' ],

<%
ListIterator<DataReport> listIter = arr.listIterator(arr.size()-1);

while (listIter.hasPrevious()) {
     DataReport  dr= listIter.previous();

out.println("['"+dr.getSdate()+"',"+dr.getMonthAvgfiftyRed()+"],"   );


}
%>
    ]);

    var options = {
      title: 'Price away from 50d',
      hAxis: {
        title: 'Months',

      },
      vAxis: {
        title: '% away from 50d'
      }
    };




var chart = new google.visualization.ColumnChart(document.getElementById('chart_id'));
      chart.draw(data, options);
    }

//////
function drawBasic0() {

  var data = google.visualization.arrayToDataTable([
          ['month', 'average away from 50d' ],

<%
ListIterator<DataReport> listIter2 = arr2.listIterator(arr2.size()-1);

while (listIter2.hasPrevious()) {
     DataReport  dr2= listIter2.previous();

out.println("['"+dr2.getSdate()+"',"+dr2.getMonthAvgfiftyRed()+"],"   );


}
%>
    ]);

    var options = {
      title: 'Price away from 50d',
      hAxis: {


        title: 'days',


      },
      vAxis: {
        title: '% away from 50d'
      }
    };




var chart = new google.visualization.ColumnChart(document.getElementById('chart_id2'));
      chart.draw(data, options);
    }




//////


    function drawBasicX() {

      var data = google.visualization.arrayToDataTable([
                ['Month', 'Max', 'Min'],

<%


	for(DataReport obj :tenmonth  ){
   out.println("['"+obj.getSdate()+"',"+obj.getTenmonthchgMax()+","+obj.getTenmonthchgMin()           +"],"   );


}

%>
  ]);

  var options = {
    title: 'Ten month Average, distance from price ',
    curveType: 'function',
    legend: { position: 'bottom' }
  };




var chart = new google.visualization.LineChart(document.getElementById('chart_ten'));
    chart.draw(data, options);
  }






















          function drawBasic1() {

            var data = google.visualization.arrayToDataTable([
                    ['month', 'average away from 50d' ],

    <%
    ListIterator<DataReport> listIter3 = arr.listIterator(arr.size()-1);

    while (listIter3.hasPrevious()) {
         DataReport  dr3= listIter3.previous();

    out.println("['"+dr3.getSdate()+"',"+dr3.getDistanceMonthAvgfiftyRed()+"],"   );


    }
    %>
        ]);

        var options = {
          title: 'distance from average fiftyday',
          hAxis: {
            title: 'Months',

          },
          vAxis: {
            title: '% away from 50d'
          }
        };




    var chart = new google.visualization.ColumnChart(document.getElementById('chart_dist'));
          chart.draw(data, options);
        }




    function drawBasic2() {

      var data = google.visualization.arrayToDataTable([
              ['month', 'average away from 50d' ],

<%
ListIterator<DataReport> listIter1 = downprice.listIterator(downprice.size()-1);

while (listIter1.hasPrevious()) {
   DataReport  dr1= listIter1.previous();

out.println("['"+dr1.getSdate()+"',"+dr1.getDownvsupratioPrice()+"],"   );


}
%>
  ]);

  var options = {
    title: 'down / up days',
    hAxis: {
      title: 'Months',

    },
    vAxis: {
      title: 'down / up days'
    }
  };




var chart = new google.visualization.ColumnChart(document.getElementById('chart_price'));
    chart.draw(data, options);
  }

  function drawBasic3() {

    var data = google.visualization.arrayToDataTable([
            ['month', 'average away from 50d' ],

<%
ListIterator<DataReport> listIter5 = downvol.listIterator(downvol.size()-1);

while (listIter5.hasPrevious()) {
 DataReport  dr2= listIter5.previous();

out.println("['"+dr2.getSdate()+"',"+dr2.getDownvsupratioVolumeFormated()+"],"   );


}
%>
]);

var options = {
  title: 'Volume  down / Volume up ',
  hAxis: {
    title: 'Months',

  },
  vAxis: {
    title: 'Volume  down / Volume up'
  }
};




var chart = new google.visualization.ColumnChart(document.getElementById('chart_volume'));
  chart.draw(data, options);
}


function drawBasic4() {

  var data = google.visualization.arrayToDataTable([
          ['month', 'average away from 50d' ],

<%
ListIterator<DataReport> listIter4 = pricevariance.listIterator(pricevariance.size()-1);

while (listIter4.hasPrevious()) {
DataReport  dr4= listIter4.previous();

out.println("['"+dr4.getSdate()+"',"+dr4.getPriceVariance()+"],"   );


}
%>
]);

var options = {
title: 'months ',
hAxis: {
  title: 'Months',

},
vAxis: {
  title: 'Price variance'
}
};




var chart = new google.visualization.ColumnChart(document.getElementById('pricevariance'));
chart.draw(data, options);
}






    </script>
  </head>
  <body>

<br>
<br>
<br>
  <br>
  code:<% out.println(dt.getCode()   );%>

      <div id="chart_id2" style="width: 1800px; height: 500px"></div>
  <br>
    <br>
  <br>
<br>
code:<% out.println(dt.getCode()   );%>

    <div id="chart_id" style="width: 1300px; height: 500px"></div>
<br>
  <br>
<br>

<div id="chart_ten" style="width: 1300px; height: 500px"></div>


<br>
  <br>
<br>



  <div id="chart_dist" style="width: 1300px; height: 500px"></div>

<br>
  <br>
<br>


  <div id="chart_price" style="width: 1300px; height: 500px"></div>
  <br>
    <br>
  <br>
    <div id="chart_volume" style="width: 1300px; height: 500px"></div>
    <br>
      <div id="pricevariance" style="width: 1300px; height: 500px"></div>




  </body>
</html>
