import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AsxJSP  extends HttpServlet{
	private String message;
	
	  XSSFWorkbook workbook;
		XSSFSheet sheet;
		Iterator<Row> rowIterator ;
		int mycount =1;
		String code="WOW";
		String headline="";
		String link="";
		FileInputStream file;
		
		String filepath ="C:\\Users\\rowan\\Desktop\\Prospects.xlsx";
		private int spreadSheetSize;
		Vector vec;
	  public void init() throws ServletException	  {
		  System.out.println("i am init");
		 
			try{
				 openExcel();
					vec= new Vector(); 
			}catch(Exception e){
				  System.out.println("Error ININT :"+e);
			}
		    
		  
		  
	  }
	  private void checkIndex(){
		  System.out.println("myspreadSheetSize"+spreadSheetSize+":::::::SYSspreadSheetSize"+sheet.getPhysicalNumberOfRows());
		  
		  
		  //start
		  if(spreadSheetSize == 0 ){// this is first time . also no need init()
			  spreadSheetSize =  sheet.getPhysicalNumberOfRows() ;
			  
		  }else if( spreadSheetSize != sheet.getPhysicalNumberOfRows()    ){
			  mycount = 0;
			  spreadSheetSize =  sheet.getPhysicalNumberOfRows() ;
		 // this mean new file , alter  the spreadsheet mean change index back to zero.
			  //reopen everything 
			  try {
				System.out.println("Reopen everything");
				  file.close();
				  init();
			} catch (Exception e) {
			System.out.println("Error reopen :"+e);
			}
			 
			  
			  
		  }
		  
		 
		  
	  }
	  
	  
	  
		private  void  contain(){
			
			if(mycount<sheet.getPhysicalNumberOfRows() ){
				code= sheet.getRow(mycount).getCell(0).toString() ;
				if(vec.contains(code) ){
					mycount++;
					contain();
				}else{
					vec.add(code);
					code= sheet.getRow(mycount).getCell(0).toString() ; 
					headline= sheet.getRow(mycount).getCell(3).toString(); 
					if(sheet.getRow(mycount).getCell(5).getHyperlink()!=null)link=sheet.getRow(mycount).getCell(5).getHyperlink().getAddress();
					else link="";
					//System.out.println("cell info:"+mycount+"  :   :"+code);
					System.out.println(code);
				}
			
			
			}
			
		}
		
	
	
	public void doGet(HttpServletRequest request,
          HttpServletResponse response)
  throws ServletException, IOException
	{
		System.out.println("Do GET ASXJsp");
		

		 checkIndex();
		
		mycount++;

		System.out.println("Do GET ASXJsp  count :"+mycount);
		//System.out.println("Do GET ASXJsp total: "+sheet.getPhysicalNumberOfRows());
		//System.out.println("Do GET ASXJsp  divide :"+(mycount/sheet.getPhysicalNumberOfRows()));
		
		Cell cellt;
		
		if(mycount<sheet.getPhysicalNumberOfRows() ){
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
			
			contain();
			
			
		}
		
		 request.setAttribute("CODE", code);
		 request.setAttribute("HEADLINE", headline);
		 request.setAttribute("LINK", link);
		 request.setAttribute("INDEX",new Double(  mycount));
		 request.setAttribute("TOTAL",new Double(  sheet.getPhysicalNumberOfRows()));
		 String nextJSP = "/AsxJSP.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			dispatcher.forward(request,response);
			
		
		
}
	
	public void doPost(HttpServletRequest request,
          HttpServletResponse response)
  throws ServletException, IOException
	{
		System.out.println("Do Post ASXJsp");
	String mycode = request.getParameter("INDEX");
	String code = request.getParameter("CODE");
	String precomment = request.getParameter("PRECOMMENT");
	
	String yes = request.getParameter("Yes");
	String no = request.getParameter("No");
	System.out.println("Code to flag with NO: "+mycode);
	//System.out.println("Code to flag with yes: "+yes);
	//System.out.println("Code to flag with no: "+no);
	
	//System.out.println("code: "+code);
	//System.out.println("precomment: "+precomment);
	
	if(yes != null){
		try{
			//ExcelToLook.getExcelToLook().addRecord ( code,"ASX NEWS", precomment);	
			
			new ExcelToLook().addRecord ( code,"ASX NEWS", precomment);	
		}catch (Exception e){
			System.out.println("Failed adding record : "+e);
			throw new ServletException ("ünable to add record");
		}
		
		
	}
	
	//if(yes != null )OK ( Integer.parseInt(mycode.trim())  );
	//if(no != null )cancel ( Integer.parseInt(mycode.trim())  );
	
	doGet( request, response);
	//cancel (  Integer.parseInt(mycode.trim())   );
	  
	
	
	}
	
	private void cancel ( int index){
		Cell cell = getCell(index , 6 );
		cell.setCellValue("N");
		
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
		Cell cell = getCell(index , 6 );
		cell.setCellValue("Y");
		
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
			 sheet = workbook.getSheetAt(2);
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
	
}


//<iframe id="ifrm_1" name="ifrm_1" src="http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=Stock&symb=au%3A<% out.println(request.getAttribute("CODE"));%>&x=51&y=12&time=9&startdate=1%2F12%2F2014&enddate=1%2F1%2F2015&freq=2&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=4&maval=7&uf=0&lf=268435456&lf2=2&lf3=0&type=1&style=320&size=4&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=15" class="OBJ-1" __AddCode="here" style="position:absolute;left:26px;top:32px;width:100%;height:100%;/*Add Style*/"></iframe>
