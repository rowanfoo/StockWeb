
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="access.TechStrAccess" %>
<%@ page import="access.AccessObject" %>
<%@ page import="access.StockAccess" %>


<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Home</title>
		<meta name="generator" content="Serif WebPlus X8 (16,0,1,21)">
		<meta name="viewport" content="width=960">
		<!--Page Head-->
		<!--Master A Head-->
		<link rel="stylesheet" type="text/css" href="wpscripts/wpstyles.css">
		<style type="text/css">
			/*Page StyleSheet*/
			/*Master A StyleSheet*/
			.OBJ-1 { border:1px solid #000000;border-radius:0; }


			img {
    /* Fills image into the parent element so it's fully covered. Contains aspect-ratio. */
    object-fit: cover;

    /* Fills image into the parent element so the img is fully shown. Can create letterboxes. */
    object-fit: contain;

    /* Fills image into the parent element so it's fully covered. Shrinks image, not respecting aspect-ratio. */
    object-fit: fill;
}
		</style>
<script type="text/JavaScript">
 function AutoRefresh( t ) {
 setTimeout("location.reload(true);", t); }
 function init(){
document.getElementById("ifrm_2").focus();
}
</script>


	</head>




<%
String INDEX = (String)request.getSession().getAttribute("INDEX");

			int x=Integer.parseInt(INDEX);

ArrayList<StockAccess> myarr=	(ArrayList<StockAccess> )request.getSession().getAttribute("Stocks");
ArrayList<TechStrAccess> mymodes=(ArrayList<TechStrAccess> )request.getSession().getAttribute("MODES");
AccessObject obj=null;
int size =0;
if(myarr!=null){
  obj=(AccessObject)myarr.get(x);
  size=myarr.size();
  request.setAttribute("STOCK",obj);


}
if(mymodes!=null){
  obj=(AccessObject)mymodes.get(x);
size=mymodes.size();
request.setAttribute("MODES", obj);

}

request.setAttribute("AccessObject", obj);
double percent =(double) x/size;
request.setAttribute("percent", percent);

%>




		<!--Page Body Start-->
		<!--Master A Body Start-->






<%
String prefix ="au%3A";


%>



<br>


	<c:choose>
	    <c:when test="${empty refresh}">
         <body __AddCode="PageInBodyTag" __AddCode="Master A In Body Tag" style="height:3000px;background:#ffffff;/*Page Body Style*//*Master A Body Style*/">

	    </c:when>
	    <c:otherwise>
        <body onload="JavaScript:AutoRefresh(20000);JavaScript:init();" __AddCode="PageInBodyTag" __AddCode="Master A In Body Tag" style="height:2000px;background:#ffffff;/*Page Body Style*//*Master A Body Style*/">
  				 <p>This page will refresh every 15 seconds.</p>
           <p>code is::${AccessObject.code} :(${STOCK.name}  )   </p>

           <p>Market cap is:: <fmt:formatNumber type="number"   maxFractionDigits="3" value="${STOCK.myMarketCap}" /></p>
           <p>index is::${INDEX}  out of <fmt:formatNumber type="PERCENT" minFractionDigits="1"   maxIntegerDigits="4" value="${percent}" /> </p>


      </c:otherwise>
	</c:choose>


		<div id="divMain" __AddCode="Spread DIV Tag" __AddCode="Master A DIV Tag" style="background:transparent;margin-left:auto;margin-right:auto;position:relative;width:100%;height:1000px;/*Spread DIV Style*//*Master A DIV Style*/">
			<!--Page Start-->
			<!--Master A Start-->
<p>${obj.code}</p>







			<!-- Document Frame ifrm_1 -->

			<!--Preamble for Document Frame ifrm_1-->
      <iframe id="ifrm_1" name="ifrm_1" src="http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=Stock&symb=au%3A${AccessObject.pureCode} &time=8&startdate=1%2F4%2F1999&enddate=8%2F12%2F2016&freq=1&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=3&maval=60&uf=0&lf=268435456&lf2=0&lf3=0&type=1&style=320&size=4&x=50&y=15&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11"
        class="OBJ-1" __AddCode="here" style="position:absolute;left:26px;top:32px;width:100%;height:100% ;/*Add Style*/" scrolling="No"  ></iframe>

      <!--Postamble for Document Frame ifrm_1-->
    <br>
    <br>


      </div>


      <div id="divMain" __AddCode="Spread DIV Tag" __AddCode="Master A DIV Tag" style="background:transparent;margin-left:auto;margin-right:auto;position:relative;width:100%;height:1100px;/*Spread DIV Style*//*Master A DIV Style*/">


            <iframe id="ifrm_2" name="ifrm_1" src="http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=Stock&symb=au%3A${AccessObject.pureCode}&time=10&startdate=1%2F4%2F1999&enddate=11%2F16%2F2016&freq=2&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=1&maval=12&uf=0&lf=268435456&lf2=0&lf3=0&type=1&style=320&size=4&x=65&y=7&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11"
              class="OBJ-1" __AddCode="here" style="position:absolute;left:26px;top:32px;width:100%;height:100%;/*Add Style*/" " scrolling="No"></iframe>







  <br>
      <br>









      <!--Master A End-->
      <!--Page End-->
    </div>


          <div id="divMain" __AddCode="Spread DIV Tag" __AddCode="Master A DIV Tag" style="background:transparent;margin-left:auto;margin-right:auto;position:relative;width:100%;height:1100px;/*Spread DIV Style*//*Master A DIV Style*/">


                <iframe id="ifrm_3" name="ifrm_1" src="http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=Stock&symb=au%3A${AccessObject.pureCode}&x=46&y=11&time=12&startdate=1%2F4%2F1999&enddate=8%2F9%2F2016&freq=3&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=1&maval=10&uf=0&lf=268435456&lf2=0&lf3=0&type=1&style=320&size=4&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11"
                  class="OBJ-1" __AddCode="here" style="position:absolute;left:26px;top:32px;width:100%;height:100%;/*Add Style*/" " scrolling="No"></iframe>







      <br>
          <br>









          <!--Master A End-->
          <!--Page End-->
        </div>




    <!--Master A Body End-->
    <!--Page Body End-->
    <br>








			<!--Master A End-->
			<!--Page End-->
		</div>
		<!--Master A Body End-->
		<!--Page Body End-->
<br>
    <br>
        <br>
            <br>
                <br>

                  <table>

                  <tr>   <td>
<p>
                  <form name="StockJspForm" action="StockJSP" method="post">

                  	<br />
                  	<br />

                    <input type="hidden" name="combo1" value="1">
                    <input type="hidden" name="CODE" value="${AccessObject.code}">
                      <input type="Submit" name="Technical" value="Technical">

                  </form>

</p></td>

 <td>             <p>
                  <form name="StockJspForm" action="StockJSP" method="post">

                  	<br />
                  	<br />

                    <input type="hidden" name="combo1" value="2">
                    <input type="hidden" name="CODE" value="${AccessObject.code}">
                      <input type="Submit" name="Fundamental" value="Fundamental">

                  </form>

</p></td></tr>



  <c:if test="${not empty STOCK}">
    <table>

    <tr>
      <td>   <p>name is::${STOCK.name}</p></td></tr>
      <tr>  <td>    <p>Top is::${STOCK.top}</p></td>  </tr>
      <tr><td>     <p>category is::${STOCK.category}</p></td></tr>




</table>
  </c:if>

  <c:if test="${not empty STOCK}">
    <table>

    <tr><td>   <p>5od ::${STOCK.data.fifty}cc</p></td>
    <td>    <p>50d %::<fmt:formatNumber type="PERCENT" minFractionDigits="1"   maxIntegerDigits="4" value="${STOCK.data.fiftychg}" />  </p></td></tr>

    <tr><td>   <p>200d::${STOCK.data.twohundred}cc</p></td>
    <td>    <p>200d %::<fmt:formatNumber type="PERCENT" minFractionDigits="1"   maxIntegerDigits="4" value="${STOCK.data.twohundredchg}" />   </p></td></tr>


</table>
  </c:if>



<br>
<p>(How much fall till now:) Price max: </p>
<br>
	<p>(30/70 rules) Average price fall : </p>
<br>
	<p>Average price fall : </p>
<br>
	<p>Average price fall (distance from  vs ) : </p>
<br>


	Was fall due to company fundamental , sharp fall in sales , bad bosses , or just didnt meet expectations, just bad environment
	<br>
Was it falling from a up trend line , side way , or still downwards
		<br>
Normandy price
					<br>

						<br>
50d,
200d									<br>

	</body>
</html>
<!--Master A Postamble-->
<!--Page Postamble-->
