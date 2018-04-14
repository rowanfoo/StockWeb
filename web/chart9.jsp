


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
                chart,
                names = ['MSFT', 'AAPL', 'GOOG'];

            yourdata = [{"date": "2018-01-20", "price": 3.0}, {"date": "2018-01-21", "price": 2.9}, {
                "date": "2018-01-22",
                "price": 2.88
            }, {"date": "2018-01-23", "price": 2.78}];


            /**
             * Create the chart when all data is loaded
             * @returns {undefined}
             */
            function createChart() {

                // create the chart
                chart = new  Highcharts.StockChart('container', {

                    rangeSelector: {
                        selected: 1
                    },

                    title: {
                        text: '<%=request.getParameter("code") %> Historical'
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
                    console.log('--a--'+a );
                    var b = a* 2;
                    console.log('--val--'+b );

                    chart.series[3].update({
                        params: {
                            period: a
                        }
                    }, false);
                    chart.series[4].update({
                        params: {
                            period: b
                        }
                    }, true);



                });





//            createChart() ;
            });

        });


    </script>
</head>
<html>
<body>
<h3>Raw data chart 6</h3>
<label>
    <input type="radio" name="grouping" value="day" checked /> Daily
</label>
<label>
    <input type="radio" name="grouping" value="week" /> Weekly
</label>
<label>
    <input type="radio" name="grouping" value="month" /> Monthly
</label>
<label>
    <p>
        Moving Average: <input type="text" id="ma" value="20">
        <button id="btn3">Set Value</button>
    </p>
</label>
<label>

</label>



<div id="container" style="min-width: 500px; height: 700px; margin: 0 auto"  ></div>

</body>
</html>
