<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
       google.charts.load('current', {packages: ['corechart', 'bar']});
      google.charts.setOnLoadCallback(drawBasic);

      function drawBasic() {



        var data = google.visualization.arrayToDataTable([
                ['month', 'average away from 50d' ],
                ['2013-11-18',-3.83],
         ['2013-09-03',-1.58],
         ['2013-08-28',-0.8],
         ['2013-07-01',-0.65],
         ['2013-06-03',-5.5],
         ['2013-05-30',-1.15],
         ['2013-03-01',-3.08],
         ['2013-02-20',-2.46],
         ['2014-12-05',-6.55],
         ['2014-08-01',-3.19],
         ['2014-07-01',-4.69],
         ['2014-06-02',-3.93],
         ['2014-05-01',-1.19],
         ['2014-04-15',-0.64],
         ['2014-02-04',-1.09],
         ['2015-12-01',-4.75],
         ['2015-11-12',-2.14],
         ['2015-09-01',-3.2],
         ['2015-08-13',-0.47],
         ['2015-07-06',-0.51],
         ['2015-06-01',-4.21],
         ['2015-05-05',-1.44],
         ['2015-01-01',-6.2],
         ['2016-10-03',-26.5],
         ['2016-09-06',-14.45],
         ['2016-08-29',-0.87],
         ['2016-06-24',-1.14],
         ['2016-04-22',-0.72],
         ['2016-02-10',-0.67],
         ['2016-01-01',-5.73]
              ]);

          var options = {
            title: 'Price away from 50d',
            hAxis: {
              title: 'Months',

            },
            vAxis: {
              title: 'Rating (scale of 1-10)'
            }
          };

          var chart = new google.visualization.ColumnChart(
            document.getElementById('chart_div'));

          chart.draw(data, options);
        }


    </script>
  </head>
  <body>
    <div id="chart_div" style="width: 900px; height: 500px"></div>
  </body>
</html>
