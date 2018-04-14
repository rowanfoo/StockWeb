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
