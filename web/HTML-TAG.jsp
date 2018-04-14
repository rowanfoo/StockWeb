combo box
------------
<select name="NEWSTYPE">
    <option value="Intrested"   <c:if test="${NEWSTYPE =='Intrested'}"> selected="selected"  </c:if>    >Intrested</option>
    <option value="Yes"  <c:if test="${NEWSTYPE =='okay'}"> selected="selected"  </c:if>    >YES</option>
        <option value="wishlist"  <c:if test="${NEWSTYPE =='wishlist'}"> selected="selected"  </c:if>    >WishList</option>
            <option value="news"  <c:if test="${NEWSTYPE =='news'}"> selected="selected"  </c:if>    >NEWS</option>

 </select>


for each
 ---------
 <select name="birthday_month">
     <c:forEach items="${months}" var="month">
         <option value="${month.key}" ${month.key == selectedMonth ? 'selected' : ''}>${month.value}</option>
     </c:forEach>
 </select>


--------selesct

<select name="NEWSTYPE">
    <option value="Intrested"   <c:if test="${NEWSTYPE =='Intrested'}"> selected="selected"  </c:if>    >Intrested</option>
    <option value="Yes"  <c:if test="${NEWSTYPE =='okay'}"> selected="selected"  </c:if>    >YES</option>
        <option value="wishlist"  <c:if test="${NEWSTYPE =='wishlist'}"> selected="selected"  </c:if>    >WishList</option>
            <option value="news"  <c:if test="${NEWSTYPE =='news'}"> selected="selected"  </c:if>    >NEWS</option>

 </select>
