

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import access.StockAccess;
import access.TechStrAccess;
import factory.DAOFactoryData;
import factory.DAOFactoryNews;
import factory.DAOFactoryStock;
import factory.DAOFactoryTechStr;

public class ChooserModePanicJSP  extends HttpServlet{ 
	

	ArrayList <TechStrAccess>  arr;
	String path="c:\\Java\\Excel\\bin\\myJava2.bat";
	
	 /**
	  * First time user come in just use default date , 
	  * Then user click on mode all user default date (today).
	  * 
	  * User can select custom dates , 
	  */
	public void doGet(HttpServletRequest request,
	          HttpServletResponse response)
	  throws ServletException, IOException
		{
		
		 System.out.println("DO doGet   :ChooserModePanicJSP 1");
		 String nextJSP = "/ChooserModePanicJSP.jsp";
			
			
		
				try(DAOFactoryTechStr dao = new DAOFactoryTechStr()) {
			
				arr = dao.getTechStrListByPanic(); 
						request.setAttribute("TOP",""  );
						System.out.println("ChooserModePanicJSP doGet Panic "); 
					
					
					
						
					 
					request.getSession().setAttribute("TechStr",arr);
					System.out.println("ChooserModePanicJSP doGET START ARR:"+arr.size());
				
					
					
					
					
					 
					System.out.println("ChooserModePanicJSP doGET  FINISH");
					
				} catch (Exception e) {
					System.out.println("ChooserModePanicJSP ERROR :"+e);  
				}
				
				
				 try(DAOFactoryStock dao = new DAOFactoryStock()) {
						
							
						 HashMap <String ,StockAccess>    	 wishlist  =dao.getAllStockWishList();
						 request.getSession().setAttribute("WishList",wishlist);
					
					 System.out.println("ChooserModeJSP doGet WishList : "+ wishlist.size() ); 
					 
				 }catch(Exception e){
					 System.out.println("ChooserModeJSP doGet wishlist : "+e); 
				 }
				
				
				System.out.println("ChooserModePanicJSP doGET  DISPATCH NOW ");
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
		try (DAOFactoryNews dt = new DAOFactoryNews()) {
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
			
		 System.out.println("DO doPost   :ChooserModePanicJSP");
		
				
				String refresh = request.getParameter("autoRefresh");
				String delete = request.getParameter("delete");
				
				 System.out.println("ChooserModePanicJSP  DELETE param :" + delete);   
				 if (refresh != null ){
					 System.out.println("ChooserModePanicJSP  refresh:");    
					 refresh();
					 
					 request.setAttribute("refresh","Y");
					 
				 }
				 if (delete != null ){
					 System.out.println("ChooserModePanicJSP  DELETE:");  
					 delete();
					 
					 
					 
				 }
		
			
			//	 if (refresh != null )request.getSession().setAttribute("refresh","Y");
				 
				
					
					
					
						
					
				//doGet(request,response);
				 System.out.println("DO doPost   :ChooserModePanicJSP FINISH ");
			
					doGet(request,response);
				
		
		
		}

	

}
