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
      <img alt="" height="475" src="https://chart.finance.yahoo.com/z?s=${codes}.AX&t=5y&q=l&l=on&z=l&p=m200,m400&a=vm&lang=en-AU&region=AU" width="800" />





			</c:forEach>





</body>

</html>
