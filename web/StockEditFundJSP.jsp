<%@ page import="access.StockAccess" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>Untitled 1</title>
</head>

<body style="height: 1028px" bgcolor="#708090">
<%
StockAccess obj=(StockAccess)request. getAttribute ("CODE");
ArrayList <String> arr=(ArrayList)request.getAttribute("category");

String category = obj.getCategory();
String mywishlist=obj.getWishlist();
System.out.println("WISHLIST "+obj.getWishlist()+":::");
boolean wishlist=true;
if (obj.getWishlist()==null ||obj.getWishlist().trim().equals("") )wishlist=false;

boolean research=true;
if (obj.getResearch()==null ||obj.getResearch().trim().equals("") )research=false;
String notes = (String) request.getAttribute("NOTES");


%>


<form action="" method="post">
<font face="Consolas" size="4" color="#C7B097">	  Stock: <%out.println(obj.getCode());   %></font> <br />
<font face="Consolas" size="4"  color="#C7B097">	 	Name: <%out.println(obj.getName());   %></font><br />
<font face="Consolas" size="4"  color="#C7B097">	   Shares: <%out.println(obj.getShares());   %></font><br />

	<br />
	<br />
	Desc<br />
	<br />
	<textarea name="Descp" style="width: 1360px; height: 152px" id="styled" ><%out.println(obj.getDescp());   %> </textarea><br />
	<br />
	<br />
	category:

	<select name="Category" type="text" class="fixed-size">
   <option value="">""</option>
		<%
		for(String s:arr){

	      if(category!= null  ){
					if( category.trim().equals(s))
					out.println("<option value=\""+ s +" \" selected>"+s+"</option>" );
					else out.println("<option value=\""+ s +" \">"+s+"</option>" );

				}else{
				out.println("<option value=\""+ s +" \">"+s+"</option>" );
			}
		}
		%>
 </select>


 <br />
 <br />
 <br />

	Reason<br />
	<textarea name="Reason" style="width: 1359px; height: 163px" id="styled" ><%out.println(obj.getReason());   %></textarea><br />
	<br />
	<br />
	Moat:<br />
	<textarea name="Moat" style="width: 1357px; height: 168px" id="styled" ><%out.println(obj.getMoat());   %></textarea><br />
	<br />
	<br />
	<br />

	Fundamental Note<br />
	<br />
	<textarea name="FundNotes" style="width: 1358px; height: 168px" id="styled" > <%out.println(obj.getFundNotes());   %></textarea><br />
	<br />
	<br />
	<br />
	<br />
	Easy Change <br />
	<br />
	<textarea name="EasyChange" style="width: 1364px; height: 178px" id="styled" ><%out.println(obj.getEasyChange());   %></textarea><br />
	<br />
	<br />
	<br />
	<br />
  NEWS<br />
  <br />
  <textarea name="News" style="width: 1364px; height: 178px" id="styled" ><%out.println(obj.getNews());   %></textarea><br />
  <br />
	<br />
	<br />

	FY date month <input name="FYdate" style="width: 215px" type="text" value="<%out.println(obj.getFYdate());   %>" /><br />



	<br />

	<br />
	<br />

	<input name="wishList" type="checkbox"  value="Y"  <%if(wishlist)out.println("checked");   %>   /> wiishlist&nbsp;&nbsp;  <input name="research" type="checkbox"  value="Y"<%if(research)out.println("checked");   %> /> Research <br />

	<br />
	<br />
  <select name="ResearchCat">
      <option value="Runners"   <c:if test="${CODE.researchCat =='Runners'}"> selected="selected"  </c:if>    >Runners</option>
      <option value="Yes"  <c:if test="${CODE.researchCat =='okay'}"> selected="selected"  </c:if>    >YES</option>
          <option value="wishlist"  <c:if test="${CODE.researchCat =='wishlist'}"> selected="selected"  </c:if>    >WishList</option>
              <option value="news"  <c:if test="${CODE.researchCat =='news'}"> selected="selected"  </c:if>    >NEWS</option>

   </select>




	<br />
	<br />

<input type="hidden" name="formcode" value="<%out.println(obj.getCode());   %>">
    <input type="submit" name="Yes" value="Fund">

	<br />
	<input type="submit" name="BACK" value="BACK">

<br />


<textarea name="Notes" style="width: 900px; height: 168px" id="styled" readonly> <%out.println(notes);   %></textarea><br />
<br />
<br />

</form>
<style type="text/css" style="display: none !important;">

textarea#styled {
 width: 600px;
 height: 120px;
 border: 3px solid #cccccc;
 padding: 5px;
 font-family: Tahoma, sans-serif;
 background-image: url(bg.gif);
 background-position: bottom right;
 background-repeat: no-repeat;
}

.fixed-size  {
  width: 200px;
}

</style>
</body>

</html>
