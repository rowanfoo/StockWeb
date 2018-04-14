import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SimpleDateFormat ft = new SimpleDateFormat ("T"); 
		//Date t;
		String url = "http://localhost:8080/RSJSP";
		 System.out.println(" " + url.substring(url.lastIndexOf("/")+1,url.length()    ));  
		
		/*
		DateTimeFormatter format =
		        DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT  );
		
		//ft.
		 try {
			 
			 LocalTime leetTime = LocalTime.parse("18:37", format);
			 XSSFWorkbook workbook = new XSSFWorkbook();
			// workbook.
			 
	         //t = ft.parse("18:05:19"); 
	         System.out.println(leetTime); 
	         LocalTime t = LocalTime.now();
	         System.out.println("After:"+t.isAfter(leetTime) ); 
	         
	         
	         
	      }catch (Exception e) { 
	         System.out.println("Unparseable using  " + e); 
	      }

		*/
		

	}

}
