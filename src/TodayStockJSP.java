import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import access.TechStrAccess;
import factory.DAOFactoryData;
import factory.DAOFactoryTechStr;

public class TodayStockJSP  extends HttpServlet{ 
	ArrayList<TechStrAccess>	arr = new ArrayList<TechStrAccess>	();
	 //HttpImportJSP ht=new HttpImportJSP();;
	String path="c:\\Java\\Excel\\bin\\myJava2.bat";
	public void doGet(HttpServletRequest request,
	          HttpServletResponse response)
	  throws ServletException, IOException
		{
		
		
		 System.out.println("DO doGet   :TodayStockJSP 1");
		 String nextJSP = "/ChooserTodayJSP.jsp";
		
		 
		 	
		 /*
		
				
				
			

				try {
					DAOFactoryTechStr dao = new DAOFactoryTechStr();
					
						
				
					
						//if( arr== null || request.getAttribute("refresh")!=null  )
							//{
							
						//	arr=ht.run();
							System.out.println("TodayStockJSP doGET START ARR:"+arr.size());
							//}
					 
					request.getSession().setAttribute("TechStr",arr);
					//System.out.println("ChooserModeJSP doGET START ARR:"+arr.size());
					
					
					
					 
					System.out.println("TodayStockJSP doGET  FINISH");
					
				} catch (Exception e) {
					System.out.println("TodayStockJSP ERROR :"+e);  
				}
						 	  
			
				
				
				*/
		 

		
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			dispatcher.forward(request,response);
		
		}




	private void refresh()throws ServletException {
		try {
			 System.out.println("REFRESHED   :TodayStockJSP   ");
			 //  String[] command = {"cmd.exe", "/C", "Start", ExcelConfig.excelDir+"testRun3.bat"};
	          //  Process p =  Runtime.getRuntime().exec(command);     
	          ///  System.out.println("REFRESHED   :TodayStockJSP  OK !!! ");
			
	    		
	    		
	    		//arr=ht.run();
			 delete();
			 System.out.println("run 1:");  
			 System.out.println("run  PATH : "+"cmd.exe /c start "+path);  
			 Process p= Runtime.getRuntime().exec("cmd.exe /c start "+path);
			 System.out.println("run 2:");   
			 System.out.println("wait 2:");   
			 p.waitFor();
			 System.out.println("wait  finish :");   
	            
		} catch (Exception e) {
			throw new ServletException("CANNOT REFRESH: "+e);
		} 
	}
	
	

	private void delete() throws ServletException {
		try (DAOFactoryTechStr tech = new DAOFactoryTechStr()) {
			tech.deleteTodayDate();
		} catch (Exception e) {
			throw new ServletException(e);
		}

		try (DAOFactoryData dt = new DAOFactoryData()) {
			dt.deleteTodayDate();
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}
	

public void doPost(HttpServletRequest request,
        HttpServletResponse response)
throws ServletException, IOException
	{
	 String nextJSP = "/ChooserModePanicJSP";
		
	 System.out.println("DO doPost   :TodayStockJSP");
	
			
			String refresh = request.getParameter("autoRefresh");
			String delete = request.getParameter("delete");
			
			 System.out.println("TodayStockJSP  DELETE param :" + delete);   
			 if (refresh != null ){
				 System.out.println("TodayStockJSP  refresh:");    
				 refresh();
				 
				 request.setAttribute("refresh","Y");
				 
			 }
			 if (delete != null ){
				 System.out.println("TodayStockJSP  DELETE:");  
				 delete();
				 
				 
				 
			 }
	
		
		//	 if (refresh != null )request.getSession().setAttribute("refresh","Y");
			 
			
				
				
				
					
				
			//doGet(request,response);
			 System.out.println("DO doPost   :TodayStockJSP FINISH ");
			 System.out.println("DO doPost   :TodayStockJSP REDIRECT to ChooserModePanicJSP  ");

			 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
				dispatcher.forward(request,response);
			
	
	
	}

}

