

import java.io.IOException;
import java.util.Date;
import java.util.Hashtable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import access.StockAccess;
import access.WorkSheetAccess;
import factory.DAOFactoryStock;
import factory.DAOFactoryWorkSheet;

public class WorkSheetJSP  extends HttpServlet{
	
	Hashtable  <String ,StockAccess>  arr ;

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
		String nextJSP="/WorkSheetJSP.jsp";
			System.out.println("Do GET WorkSheetJSP 1.1");
			
			 try(DAOFactoryStock dao = new DAOFactoryStock()) {
					
					if( arr == null) arr=dao.getAllHash();
						
					 request.setAttribute("Stock",arr);
						
					} catch (Exception e) {	
						System.out.println("WorkSheetJSP doGet ERROR :"+e); 
						
						 request.setAttribute("error",e.getMessage());
					}
			
			
			 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
				dispatcher.forward(request,response);
		
		
			
			
	}
	

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String CODE = request.getParameter("CODE");
		String time = request.getParameter("time");
		String reason = request.getParameter("reason");
		String buy = request.getParameter("buy");
		String stopLoss = request.getParameter("stopLoss");
		String edate = request.getParameter("edate");
		String trend = request.getParameter("trend");

		String volatiles = request.getParameter("volatiles");
		String panic = request.getParameter("panic");
		String discounted = request.getParameter("discounted");
		String multiMonth = request.getParameter("multiMonth");
		String majorSupport = request.getParameter("majorSupport");
		String meanRevision = request.getParameter("meanRevision");
		String changeTrend = request.getParameter("changeTrend");
		String sellergain = request.getParameter("sellergain");
		
		
		
		if (buy==null || buy.trim() .equals("")  )buy="0";
		if (stopLoss==null || stopLoss.trim().equals("")   )stopLoss="0";
		System.out.println("WorkSheetJSP doPost buy :"+buy );
		System.out.println("WorkSheetJSP doPost stopLoss :"+stopLoss );
		
		

		try (DAOFactoryWorkSheet dao = new DAOFactoryWorkSheet()) {
			WorkSheetAccess work = new WorkSheetAccess(CODE, new Date(), time, reason, Double.parseDouble(buy),
					Double.parseDouble(stopLoss), edate, trend, volatiles, panic, discounted, multiMonth, majorSupport,
					meanRevision, changeTrend, sellergain,"");
			System.out.println("WorkSheetJSP doPost createWorkSheet :" );
			dao.createWorkSheet(work);

		} catch (Exception e) {
			System.out.println("WorkSheetJSP doPost ERROR :" + e);
			 request.setAttribute("error",e.getMessage());
		}

		doGet(request, response);

	}
	
	
}
