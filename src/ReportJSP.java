

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import access.DataReport;
import access.StockAccess;
import factory.DAOFactoryDataReport;
import factory.DAOFactoryStock;


public class ReportJSP  extends HttpServlet{
	int mycount =0;

	Hashtable  <String ,StockAccess>  stocks ;
	public void init() throws ServletException	  {
		  
	  }
	
	
	
	
	/**
	 * direct to 3 pages, 
	 * 1. Input page , which then directs 
	 * 	2. Technical page
	 *  3. Fundamental page.
	 */
	
	public void doGet(HttpServletRequest request,
	          HttpServletResponse response)
	  throws ServletException, IOException
		{
			System.out.println("Do GET MyNotesJSP");
			
			
			String nextJSP = "/ReportJSP.jsp";
			String nextJSP1 = "/ReportStockJSP.jsp";

			String jsp = "";
			 try(DAOFactoryStock dao = new DAOFactoryStock()) {
					
					if( stocks == null) stocks=dao.getAllHash();
						
					 request.setAttribute("Stock",stocks);
						
					} catch (Exception e) {	
						System.out.println("StockJSP doPost ERROR :"+e); 
						throw new ServletException ("ERROR  StockJSP getAllHash :"+e);
					}
			 
			
			
			 if(request.getAttribute("CODE")==null){
				 jsp=nextJSP1;
			 }else{
				jsp= nextJSP;
				 }
			
			 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
				dispatcher.forward(request,response);
		
			
			
	}
	
	
	public void doPost(HttpServletRequest request,
	          HttpServletResponse response)
	  throws ServletException, IOException
		{
		
		System.out.println("Do POST  MyNotesJSP");
		String code = request.getParameter("CODE");		
	
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date=dateFormat.format( new Date());	
		
		if(code!=null){
			 try(DAOFactoryDataReport dao = new DAOFactoryDataReport()) {
				 request.setAttribute("CODE",code.trim());
					ArrayList<DataReport>  arr = dao.getMonthAverageFromFiftyDayDownFourYears(code.trim());
					
					ArrayList<DataReport>  arr2 = dao.getFiftyDayTwoYears(code.trim());
							
					 request.setAttribute("report",arr);
					 request.setAttribute("report2",arr2);
					 System.out.println("ReportJSP doPost  SIZEE:"+arr2.size()); 
					 
					} catch (Exception e) {	
						System.out.println("ReportJSP doPost ERROR :"+e); 
						throw new ServletException ("ERROR  ReportJSP getTechStrList :"+e);
					}
			 
			 try(DAOFactoryDataReport dao = new DAOFactoryDataReport()) {
					ArrayList<DataReport>  arr = dao.getDownvsUpDayRatio(code.trim());
						
					 request.setAttribute("downupprice",arr);
						System.out.println("ReportJSP doPost downupprice :"+arr.size()); 
					} catch (Exception e) {	
						System.out.println("ReportJSP doPost ERROR :"+e); 
						throw new ServletException ("ERROR  ReportJSP getDownvsUpDayRatio :"+e);
					}
			 
			 
			 
			 try(DAOFactoryDataReport dao = new DAOFactoryDataReport()) {
					ArrayList<DataReport>  arr = dao.getDownvsUpVolumeRatio(code.trim());
						
					 request.setAttribute("downupvol",arr);
					 
					 arr = dao.getPriceVariance(code.trim());
					 request.setAttribute("pricevariance",arr);
					 
					 
					 System.out.println("ReportJSP doPost downupvol :"+arr.size()); 
					} catch (Exception e) {	
						System.out.println("ReportJSP doPost ERROR :"+e); 
						throw new ServletException ("ERROR  ReportJSP getDownvsUpDayRatio :"+e);
					}
			 
			 try(DAOFactoryDataReport dao = new DAOFactoryDataReport()) {
					ArrayList<DataReport>  arr = dao.getTenMonthAvgHistory(code.trim());
						
					 request.setAttribute("tenmonth",arr);
					 
									 
					 
					 System.out.println("ReportJSP doPost tenmonth  :"+arr.size()); 
					} catch (Exception e) {	
						System.out.println("ReportJSP doPost tenmonth ERROR :"+e); 
						throw new ServletException ("ERROR  ReportJSP tenmonth :"+e);
					}
			 
			 
			 
		}
		
	
			
		
			
		
		
		
		
		


			 
		doGet( request, response);
		
		  
		
		
		}
	
	
}
