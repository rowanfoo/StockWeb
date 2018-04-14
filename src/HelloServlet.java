import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class HelloServlet extends HttpServlet  {

	
	 private String message;
	
	  XSSFWorkbook workbook;
		XSSFSheet sheet;
		Iterator<Row> rowIterator ;
		int mycount =0;
		String code="WOW";
	  public void init() throws ServletException
	  {
		  System.out.println("i am init");
		 
			try{
				 FileInputStream file = new FileInputStream(new File("C:\\Users\\rowan\\Desktop\\Prospects.xlsx"));
				   workbook = new XSSFWorkbook(file);
					 
				    //Get first sheet from the workbook
					 sheet = workbook.getSheetAt(1);
					 rowIterator = sheet.iterator();
					 
			}catch(Exception e){
				
			}
		    
		  
		  
	  }


public void doGet(HttpServletRequest request,
            HttpServletResponse response)
    throws ServletException, IOException
{
// Set response content type
response.setContentType("text/html");
mycount++;

if(mycount<sheet.getPhysicalNumberOfRows() ){
	code= sheet.getRow(mycount).getCell(1).toString() ; 
	response.setIntHeader("Refresh", 10); 
}else{
	response.setIntHeader("Refresh", 1000);  	
}

System.out.println("<h1>" + change + "</h1>");
response.sendRedirect(change);

/*	
// Actual logic goes here.
PrintWriter out = response.getWriter();
message=html1+html2+html3;
out.println("<h1>" + code + "</h1>");
out.println("<h1>" + message + "</h1>");

out.println("<h1>" + mycount + "</h1>");
out.println("<h1>" + "ver 11" + "</h1>");

//out.println("<h1>" + htmlT + "</h1>");
*/
}
String total="";
String change ="http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=Stock&symb=au%3A"+code+"&x=51&y=12&time=9&startdate=1%2F12%2F2014&enddate=1%2F1%2F2015&freq=2&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=4&maval=7&uf=0&lf=268435456&lf2=2&lf3=0&type=1&style=320&size=4&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=15";


String html1 = " <!DOCTYPE html> <html lang=\"en\">"+
	"<head>"+
		"<meta charset=\"UTF-8\">"+
		"<title>Home</title>"+
		"<meta name=\"generator\" content=\"Serif WebPlus X8 (16,0,1,21)\">"+
		"<meta name=\"viewport\" content=\"width=960\">"+
		"<link rel=\"stylesheet\" type=\"text/css\" href=\"wpscripts/wpstyles.css\">"+
		"<style type=\"text/css\">  </style>  </head>"+
		"<body __AddCode=\"PageInBodyTag\" __AddCode=\"Master A In Body Tag\" style=\"height:1000px;background:#ffffff;/*Page Body Style*//*Master A Body Style*/\">"+
		"<div id=\"divMain\" __AddCode=\"Spread DIV Tag\" __AddCode=\"Master A DIV Tag\" style=\"background:transparent;margin-left:auto;margin-right:auto;position:relative;width:960px;height:1000px;/*Spread DIV Style*//*Master A DIV Style*/\">";


String html2= "<img alt=\"\" src=\"http://bigcharts.marketwatch.com/kaavio.Webhost/charts/big.chart?nosettings=1&amp;symb=au%253aWOW&amp;uf=0&amp;type=1&amp;size=4&amp;sid=137971&amp;style=320&amp;freq=2&amp;entitlementtoken=0c33378313484ba9b46b8e24ded87dd6&amp;time=8&amp;rand=2079496537&amp;compidx=aaaaa%253a0&amp;ma=4&amp;maval=7&amp;lf=268435456&amp;lf2=2&amp;lf3=0&amp;height=808&amp;width=1045&amp;mocktick=1\" __AddCode=\"here\" style=\"position:absolute;left:63px;top:79px;width:855px;height:711px;/*Add Style*/\">";
	

//String html2= 	"<img alt=\"\" src=\"http://bigcharts.marketwatch.com/kaavio.Webhost/charts/big.chart?nosettings=1&symb=au%3awow&uf=0&type=1&size=4&sid=795869&style=320&freq=1&entitlementtoken=0c33378313484ba9b46b8e24ded87dd6&time=8&rand=1791944663&compidx=aaaaa%3a0&ma=4&maval=50&lf=268435456&lf2=2&lf3=0&height=808&width=1045&mocktick=1\" __AddCode=\"here\" style=\"position:absolute;left:56px;top:25px;width:832px;height:864px;/*Add Style*/\">";




//String htmlT= 	"<\"http://bigcharts.marketwatch.com/kaavio.Webhost/charts/big.chart?nosettings=1&amp;symb=au%3a"+code+"&uf=0&amp;type=1&amp;size=4&amp;sid=137971&amp;style=320&amp;freq=2&amp;entitlementtoken=0c33378313484ba9b46b8e24ded87dd6&amp;time=8&amp;rand=2029752206&amp;compidx=aaaaa%253a0&amp;ma=4&amp;maval=7&amp;lf=268435456&amp;lf2=2&amp;lf3=0&amp;height=808&amp;width:100%&amp;mocktick=1>";
//http://bigcharts.marketwatch.com/kaavio.Webhost/charts/big.chart?nosettings=1&symb=au%3axuj&uf=0&type=1&size=4&sid=795869&style=320&freq=1&entitlementtoken=0c33378313484ba9b46b8e24ded87dd6&time=8&rand=1791944663&compidx=aaaaa%3a0&ma=4&maval=50&lf=268435456&lf2=2&lf3=0&height=808&width=1045&mocktick=1
//http://bigcharts.marketwatch.com/kaavio.Webhost/charts/big.chart?nosettings=1&symb=au%3abhp&uf=0&type=1&size=4&sid=137971&style=320&freq=2&entitlementtoken=0c33378313484ba9b46b8e24ded87dd6&time=8&rand=2079496537&compidx=aaaaa%3a0&ma=4&maval=7&lf=268435456&lf2=2&lf3=0&height=808&width=1045&mocktick=1



String html3= "</div></body></html>		";

		
}
