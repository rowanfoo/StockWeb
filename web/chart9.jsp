
<html xmlns:th="http://www.thymeleaf.org">

<head>

    <html xmlns:th="http://www.thymeleaf.org">

    <head>



        <script src="highstock.js"></script>

        <script src="exporting.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
        <script src="https://code.highcharts.com/stock/indicators/indicators.js"></script>
        <script src="https://code.highcharts.com/stock/indicators/ema.js"></script>
        <script src="https://code.highcharts.com/stock/indicators/rsi.js"></script>
        <script type="text/javascript">
            $(function() {
                var seriesOptions = [],
                    seriesOptions20d = [],
                    seriesOptions75d = [],
                    seriesOptions150d = [],
                    volume=  [],
                    seriesCounter = 0,
                    chart



                /**
                 * Create the chart when all data is loaded
                 * @returns {undefined}
                 */
                function createChart() {

                    // create the chart
                    chart = new  Highcharts.StockChart('container', {

                        rangeSelector: {
                            buttons: [

                            {
                                type: 'month',
                                count: 6,
                                text: '6m'
                            }, {
                                type: 'ytd',
                                text: 'YTD'
                            }, {
                                type: 'year',
                                count: 1,
                                text: '1y'
                            },
                                {
                                    type: 'year',
                                    count: 2,
                                    text: '2y'
                                },
                                {
                                    type: 'year',
                                    count: 3,
                                    text: '3y'
                                },


                                {
                                type: 'all',
                                text: 'All'
                            }]
                        },


                        legend: {
                            enabled: true
                        },

                        yAxis: [{

                            title: {
                                text: 'OHLC'
                            },
                            top: 50,
                            height: 300,
                        }, {
                            labels: {
                                align: 'right',
                                x: -3
                            },
                            title: {
                                text: 'Volume'
                            },
                            top: 300,
                            height: 100,

                            lineWidth: 2
                        },
                            {
                                labels: {
                                    align: 'right',
                                    x: -3
                                },
                                title: {
                                    text: 'RSI'
                                },
                                top: 400,
                                height: 100,
                                offset: 0,
                                lineWidth: 2
                            }
                        ],

                        plotOptions: {
                            series: {
                                showInLegend: true,
                                dataGrouping: {
                                    enabled: true,
                                    units: [ ['month', [1]] ]

                                }

                            }
                        },





                        tooltip: {
                            split: true
                        },

                        series: [{
                            type: 'ohlc',
                            name: 'AAPL',
                            id: 'aapl',
                            data: seriesOptions
                        }, {
                            type: 'column',
                            name: 'Volume',
                            id: 'volume',
                            data: volume,
                            yAxis: 1
                        },{
                            yAxis: 2,
                            name:"rsi",
                            type: 'rsi',
                            linkedTo: 'aapl'
                        },
                            {
                                type: 'sma',
                                name: 'sma50',
                                linkedTo: 'aapl',

                                params: {
                                    period: 50
                                }
                            },
                            {
                                type: 'sma',
                                name: 'sma20',
                                linkedTo: 'aapl',

                                params: {
                                    period: 20
                                }
                            }


                        ]
                    });

                };




                 $.getJSON("http://<%=request.getServerName() %>:<%=request.getServerPort() %>/<%=request.getContextPath() %>stockadmin/data?code=<%=request.getParameter("code") %>&date=2015-03-01", function(data) {


                    console.log('xx');
                    //         data.map(function(p) {
                    //             var ymd = p.date.split("-");
                    //             seriesOptions.push([ Date.UTC(ymd[0], ymd[2] - 1, ymd[1]) , p.price ] );
                    //
                    //         })
                    // console.log('xx 1' +seriesOptions );
                    for(var i = 0; i < data.length; i++){



                        seriesOptions.push([
                            new Date(data[i].date).getTime(), // the date
                            data[i].open_price , // open
                            data[i].day_high_price, // high
                            data[i].day_low_price, // low
                            data[i].last_price // close
                        ]);


                        seriesOptions20d.push([ new Date(data[i].date).getTime(), data[i].twenty ]);
                        seriesOptions75d.push([ new Date(data[i].date).getTime(), data[i].sevenfive ]);
                        seriesOptions150d.push([ new Date(data[i].date).getTime(), data[i].onehundredfifty ]);
                        volume.push( [ new Date(data[i].date).getTime(), data[i].volume ]);
                    }
                    createChart() ;

                    $('input[name=grouping]').change(function() {
                        //http://api.highcharts.com/highstock#plotOptions.series.dataGrouping.units
                        console.log(' SELECTED  :');
                        var unit = $(this).val();

                        //http://api.highcharts.com/highstock#Series.update
                        chart.series.forEach(function(ser) {
                            console.log('SELECTED -1')
                            ser.update({
                                dataGrouping: {
                                    units: [ [unit, [1]] ],
                                    groupPixelWidth: 10
                                }
                            }, false);
                        });

                        chart.redraw();
                    });

                });

                $(document).ready(function() {
                    // for(var i = 0; i < yourdata.length; i++){
                    //
                    //     seriesOptions.push([ new Date(yourdata[i].date).getTime(), yourdata[i].price ]);
                    // }

                    console.log('any  :' +seriesOptions);
                    $("#btn3").click(function(){

                        var a =  $("#ma").val();
                        var b =  $("#ma1").val();
                        if(a){
                            chart.series[3].update({
                                name: 'sma'+a,
                                params: {
                                    period: a
                                }
                            }, false);

                        }else{}
                        if(b){
                            chart.series[4].update({
                                params: {
                                    period: b
                                }
                            }, false);

                        }else{}
                        if(a||b){
                            console.log("will redraw")
                            chart.redraw();
                        }






                    });
                    $("#btn4").click(function(){
                        console.log('visible '+ chart.series[3].visible )
                        if( chart.series[3].visible) {
                            chart.series[3].update({
                                visible: false
                            }, false);
                            chart.series[4].update({
                                visible: false
                            }, true);
                        }else{
                            chart.series[3].update({
                                visible: true
                            }, false);
                            chart.series[4].update({
                                visible: true
                            }, true);
                        }


                    });




//            createChart() ;
                });

            });


        </script>
        <style>
            input[type=text] {
                width: 3em

            }

            font-size: 5px;
            label {
                font-weight: bold;
            }

        </style>

    </head>
    <html>
<body>
<label>
    <span th:text="${code}" />
</label>
<label>
    <input type="radio" name="grouping" value="day" checked /> Daily
</label>
<label>
    <input type="radio" name="grouping" value="week" /> Weekly
</label>
<label>
    <input type="radio" name="grouping" value="month" /> Monthly
                                                         &nbsp;&nbsp;
                                                         Moving Average: <input type="text" id="ma"> || <input type="text" id="ma1">

    <button id="btn3" height="5">Set Value</button>
    <button id="btn4" height="5">MA</button>
</label>





<div id="container" style="min-width: 500px; height: 700px; margin: 0 auto"  ></div>

</body>
</html>


