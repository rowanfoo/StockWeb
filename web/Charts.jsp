<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="en-us" http-equiv="Content-Language" />
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>code</title>
</head>

<body>

<div>
	code:<br />
  <!--			<img alt="" height="475" src="https://chart.finance.yahoo.com/z?s=${codes}.AX&amp;t=1y&amp;q=&amp;l=&amp;z=l&amp;a=v&amp;p=s&amp;lang=en-AU&amp;region=AU" width="800" /> -->


	<c:forEach items="${paramValues.code}"  var="codes">



    <img class=""  height="475" src="//chartbigchart.gtm.idmanagedsolutions.com/custom/fairfax-com-au/big.chart?rnd=0.12523523990067287&amp;style=2406&amp;symb=${codes}&amp;size=4&amp;type=1&amp;time=1yr&amp;freq=1dy&amp;comp=&amp;compidx=aaaaa~0&amp;ma=3&amp;maval=20&amp;lf=268435456&amp;lf2=2&amp;lf3=0&amp;arrowdates=&amp;arrowlegend=&amp;country=AU&amp;sid=25139472" width="800">


			</c:forEach>





</body>

</html>
