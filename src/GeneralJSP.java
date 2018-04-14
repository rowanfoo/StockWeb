import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class GeneralJSP  extends HttpServlet{
	int mycount =0;
	XSSFSheet sheet;
	private void openExcel()throws Exception {
		 // file = new FileInputStream(new File(filepath));
		 //  workbook = new XSSFWorkbook(file);
			 
		    //Get first sheet from the workbook
			// sheet = workbook.getSheetAt(2);
			// rowIterator = sheet.iterator();
	}
	 
	public void init() throws ServletException	  {
		 // System.out.println("i am init");
		 /*
			try{
				sheet = Excel.getExcel().getGeneralSheet();
				
			}catch(Exception e){
				  System.out.println("Error ININT :"+e);
			}
		   */ 
		  
		  
	  }
	
	
	//String url1= "http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=Index&symb=";
	//String url2 ="&time=11&startdate=1%2F4%2F1999&enddate=5%2F16%2F2016&freq=2&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=0&maval=9&uf=0&lf=1&lf2=0&lf3=0&type=2&style=320&size=3&x=36&y=6&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=9";
	
	
	
	
	public void doGet(HttpServletRequest request,
	          HttpServletResponse response)
	  throws ServletException, IOException
		{
			System.out.println("Do GET GeneralJSP");
			

			if (sheet== null){
				 sheet=(XSSFSheet)request.getSession().getAttribute("worksheet") ;
				// sheet.getSheetName()
			}
			
			mycount++;

			System.out.println("Do GET GeneralJSP  count :"+mycount);
			System.out.println("Do GET GeneralJSP  count :"+sheet.getSheetName());
			//System.out.println("Do GET ASXJsp total: "+sheet.getPhysicalNumberOfRows());
			//System.out.println("Do GET ASXJsp  divide :"+(mycount/sheet.getPhysicalNumberOfRows()));
			String sheetName = sheet.getSheetName();
			Cell cellt;
			String code="";
			if(mycount<sheet.getPhysicalNumberOfRows() ){
			
				
				if (sheetName.matches("toLook(.*)")){
					//i want to start to see from the latest not oldest.
					int index = sheet.getPhysicalNumberOfRows() - mycount;
					
					code= sheet.getRow(index).getCell(1).toString() ;
					
					
					
				}else{
				
				code= sheet.getRow(mycount).getCell(0).toString() ;
				System.out.println("Do GET GeneralJSP  code :"+code);

				/*
				cellt= sheet.getRow(mycount).getCell(0);
				
				System.out.println("FOrward now mycount code: "+cellt);
				if (cellt!=null){
					code= sheet.getRow(mycount).getCell(0).toString() ; 	
				}else{code="";};
				
				cellt= sheet.getRow(mycount).getCell(3);
				if (cellt!=null){
					headline=cellt.toString() ; 	
				}else{headline="";};
				
				
				cellt= sheet.getRow(mycount).getCell(5);
				
				if (cellt!=null&&cellt.getHyperlink()!=null){
					link=cellt.getHyperlink().getAddress(); 	
				}else{link="";};
				
				*/
				
				//contain();
				
				}
			}
			//String url3 = url1 + code+ url2;
			//String url4=response.encodeUrl(url3);
			
			 
			 //request.setAttribute("CODE", url4);
			 
			 
			 request.setAttribute("CODE", code);
			
			 request.setAttribute("INDEX",new Double(  mycount));
			 request.setAttribute("TOTAL",new Double(  sheet.getPhysicalNumberOfRows()));
			 
			 
			// request.setAttribute("INDEX",new Double(  mycount));
			// request.setAttribute("TOTAL",new Double(  sheet.getPhysicalNumberOfRows()));
			 String nextJSP = "/GeneralJSP.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
				dispatcher.forward(request,response);
		
			
			
	}
	
	
	public void doPost(HttpServletRequest request,
	          HttpServletResponse response)
	  throws ServletException, IOException
		{
			System.out.println("Do Post ASXJsp");
			String code = request.getParameter("CODE");
			String precomment = request.getParameter("PRECOMMENT");
			
			String yes = request.getParameter("Yes");
			String no = request.getParameter("No");
			System.out.println("Add record start : "+yes);
			if(yes != null){
				try{
					//ExcelToLook.getExcelToLook().addRecord ( code,"ASX NEWS", precomment);	
					System.out.println("Add record start : ");
					new ExcelToLook2().addRecord ( code, precomment);	
				}catch (Exception e){
					System.out.println("Failed adding record : "+e);
					throw new ServletException ("ünable to add record");
				}
				
				
			}
		
		doGet( request, response);
		
		  
		
		
		}
	
	
}
