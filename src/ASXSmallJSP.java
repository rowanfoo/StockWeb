import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFSheet;

public class ASXSmallJSP  extends HttpServlet{

	int mycount =0;
	XSSFSheet sheet;
	 
	public void init() throws ServletException	  {
		  System.out.println("i am init");
		 
			try{
				sheet = Excel.getExcel().getlowSheet();
				
			}catch(Exception e){
				  System.out.println("Error ININT :"+e);
			}
		    
		  
		  
	  }
	  
	
	
	public void doGet(HttpServletRequest request,
	          HttpServletResponse response)
	  throws ServletException, IOException
		{
			String code="";
			if(mycount<sheet.getPhysicalNumberOfRows() ){
				
				code= sheet.getRow(mycount).getCell(0).toString() ;
				System.out.println("Do GET GeneralJSP  code :"+code);
	
				
				
			}
			
			 request.setAttribute("CODE", code);
			 request.setAttribute("INDEX",new Double(  mycount));
			 request.setAttribute("TOTAL",new Double(  sheet.getPhysicalNumberOfRows()));
			 String nextJSP = "/ASXSmallJSP.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
				dispatcher.forward(request,response);
				
			
			
			
		}
	
	
		
	
	
	
	public void doPost(HttpServletRequest request,
	          HttpServletResponse response)
	  throws ServletException, IOException
		{
		
		
		}
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
