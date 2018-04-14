  <cif>
----------
  <c:if test="${not empty STOCK}">
    <table>

    <tr>
      <td>   <p>name is::${STOCK.name}</p></td></tr>

	</tr>

  </c:if>


equals string:
-------------
<c:if test="${person.sokande_i == 'endast_usa'}">Endast USA</c:if>
!= )not equal


null
----------


<c:if test="${empty var1}">
    var1 is empty or null.
</c:if>
<c:if test="${not empty var1}">
    var1 is NOT empty or null.
</c:if>










	<c:choose>
-------------------

	<c:choose>
	    <c:when test="${empty refresh}">
         <body __AddCode="PageInBodyTag" __AddCode="Master A In Body Tag" style="height:3000px;background:#ffffff;/*Page Body Style*//*Master A Body Style*/">

	    </c:when>
	    <c:otherwise>
        <body onload="JavaScript:AutoRefresh(20000);JavaScript:init();" __AddCode="PageInBodyTag" __AddCode="Master A In Body Tag" style="height:2000px;background:#ffffff;/*Page Body Style*//*Master A Body Style*/">
  				 <p>This page will refresh every 15 seconds.</p>
           <p>code is::${AccessObject.code} :(${STOCK.name}  )   </p>




      </c:otherwise>
	</c:choose>


</table>






  FORMAT
  ----------

  <p>Market cap is:: <fmt:formatNumber type="number"   maxFractionDigits="3" value="${STOCK.myMarketCap}" /></p>
           <p>index is::${INDEX}  out of <fmt:formatNumber type="PERCENT" minFractionDigits="1"   maxIntegerDigits="4" value="${percent}" /> </p>



Get all parameters
---------------
http://localhost:8080/Charts.jsp?code=4DS&code=8CO&code=AAA&code=AAJ&code=AAU&code=ABW

	<c:forEach items="${paramValues.code}"  var="codes">


			<img alt="" height="475" src="https://chart.finance.yahoo.com/z?s=${codes}.AX&amp;t=1y&amp;q=&amp;l=&amp;z=l&amp;a=v&amp;p=s&amp;lang=en-AU&amp;region=AU" width="800" />
		</c:forEach>








foreach
------------
<select name="birthday_month" id="birthday_month">
  <c:forEach var="value" items="${birthdaymonth}">
    <option value="${birthdaymonth}">${birthdaymonth}</option>
    <option value="1">Jan</option>
    <option value="2">Feb</option>
    ...
  </c:forEach>
</select>


<select name="birthday_month">
    <c:forEach items="${months}" var="month">
        <option value="${month.key}" ${month.key == selectedMonth ? 'selected' : ''}>${month.value}</option>
    </c:forEach>
</select>
