import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class HelloJSP extends HttpServlet {
	
	 private String message;
		
	  XSSFWorkbook workbook;
		XSSFSheet sheet;
		Iterator<Row> rowIterator ;
		int mycount =0;
		String code="WOW";
		String name="";
		FileInputStream file;
		
		String filepath ="C:\\Users\\rowan\\Desktop\\Prospects.xlsx";
	  public void init() throws ServletException	  {
		  System.out.println("i am init");
		 
			try{
				 openExcel();
					 
			}catch(Exception e){
				  System.out.println("Error ININT :"+e);
			}
		    
		  
		  
	  }
	
	
	public void doGet(HttpServletRequest request,
            HttpServletResponse response)
    throws ServletException, IOException
	{
		System.out.println("FOrward now ");
		
		
		String tolook="";
		String category="";
		mycount++;
		
		if(mycount<sheet.getPhysicalNumberOfRows() ){
			if(sheet.getRow(mycount).getCell(8)!= null){
				//cell is not empty means i have been here 
				//no need to see it.
				mycount++;
			}
			
			
		}
		
		
		if(mycount<sheet.getPhysicalNumberOfRows() ){
			code= sheet.getRow(mycount).getCell(1).toString() ; 
			name =sheet.getRow(mycount).getCell(2).toString() ;
			//System.out.println("FOrward now:"+code );
			if (sheet.getRow(mycount).getCell(7)==null){
				category="";	
			}else {category=sheet.getRow(mycount).getCell(7).toString(); }
			//System.out.println("FOrward now category:"+category );
			//response.setIntHeader("Refresh", 10); 
		}else{
			//response.setIntHeader("Refresh", 1000);  	
		}
		
		
		 request.setAttribute("NAME", name);
		 request.setAttribute("CATEGORY", category);
 		 request.setAttribute("URI", code);
		 request.setAttribute("INDEX", mycount);
		 String nextJSP = "/HelloJSP.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			dispatcher.forward(request,response);
			
		
		
		
}
	
	public void doPost(HttpServletRequest request,
            HttpServletResponse response)
    throws ServletException, IOException
	{
		System.out.println("Do Post ");
	String mycode = request.getParameter("INDEX");
	String yes = request.getParameter("Yes");
	String no = request.getParameter("No");
	System.out.println("Code to flag with NO: "+mycode);
	System.out.println("Code to flag with yes: "+yes);
	System.out.println("Code to flag with no: "+no);
	 	 
	if(yes != null )OK ( Integer.parseInt(mycode.trim())  );
	if(no != null )cancel ( Integer.parseInt(mycode.trim())  );
	
	doGet( request, response);
	//cancel (  Integer.parseInt(mycode.trim())   );
	
	
	
	}
	
	
	private void cancel ( int index){
		Cell cell = getCell(index , 8 );
		cell.setCellValue("N");
		setDate(index );
		System.out.println("REMOVE");
		try{
			file.close();
			FileOutputStream outFile =new FileOutputStream(new File(filepath));
			workbook.write(outFile);
			outFile.close();
			openExcel();
	
		}catch(Exception e){
			System.out.println("REMOVE ERROR:"+e);
			
		}
		
	}
	
	private void OK ( int index){
		Cell cell = getCell(index , 8 );
		cell.setCellValue("Y");
		setDate(index );
		System.out.println("ADD");
		try{
			file.close();
			FileOutputStream outFile =new FileOutputStream(new File(filepath));
			workbook.write(outFile);
			outFile.close();
			openExcel();
	
		}catch(Exception e){
			System.out.println("REMOVE ERROR:"+e);
			
		}
		
	}
	
	private void openExcel()throws Exception {
		  file = new FileInputStream(new File(filepath));
		   workbook = new XSSFWorkbook(file);
			 
		    //Get first sheet from the workbook
			 sheet = workbook.getSheetAt(1);
			 rowIterator = sheet.iterator();
	}
	

	private Cell getCell(int row , int colum ){
		Cell cell = sheet.getRow(row).getCell(colum);
		if (cell != null){
			return cell;
		}else{
			return sheet.getRow(row).createCell(colum);
		}
	}
	private void setDate(int row ){
		Cell cell = sheet.getRow(row).getCell(0);
		if (cell == null){
		 cell=sheet.getRow(row).createCell(0);
		}
		cell.setCellValue(Calendar .getInstance());
	
	}	
}
