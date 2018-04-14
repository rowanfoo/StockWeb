

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import access.WorkSheetAccess;
import factory.DAOFactoryWorkSheet;

public class ChooserWorkSheetJSP  extends HttpServlet{


	public void init() throws ServletException	  {
		  
	  }
	
	
	
	
	/**
	 * direct to 3 pages, 
	 * 1. Input page , which then directs 
	 * 	2. Technical page
	 *  3. Fundamental page.
	 */
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Do GET ChooserWorkSheetJSP");

		ArrayList<WorkSheetAccess> arr = (ArrayList<WorkSheetAccess>) request.getSession().getAttribute("WorkSheet");

		String nextJSP = "/WorkSheetListJSP.jsp";

		try (DAOFactoryWorkSheet dao = new DAOFactoryWorkSheet()) {

			if (arr == null) {
				arr =  dao.getWorkSheetByDate(LocalDate.now().toString() );
				ArrayList<WorkSheetAccess> arr2=  dao.getWorkSheetByDate(LocalDate.now().minusDays(1).toString() );
				arr.addAll(arr2);
				request.getSession().setAttribute("WorkSheet", arr);
			}
		} catch (Exception e) {
			System.out.println("ChooserWorkSheetJSP doPost ERROR :" + e);
			throw new ServletException("ERROR  ChooserWorkSheetJSP error :" + e);
		}

		String index = request.getParameter("index");
		if(index !=null){
			int no= Integer.parseInt(index.trim());
			System.out.println("ChooserWorkSheetJSP doGet index :" + no);
			request.setAttribute("WorkSheetObj", arr.get(no));
			
			nextJSP = "/WorkSheetEdit.jsp";
			
			
		}
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);

	}
	
	
	public void doPost(HttpServletRequest request,
	          HttpServletResponse response)
	  throws ServletException, IOException
		{
		
		System.out.println("Do POST  ChooserWorkSheetJSP");
		String MyModeDate = request.getParameter("MyModeDate");		
		String weekly = request.getParameter("weekly");
	
		ArrayList< WorkSheetAccess> arr =	null;
			
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
		System.out.println("ChooserWorkSheetJSP doPost buy :"+buy );
		System.out.println("ChooserWorkSheetJSP doPost stopLoss :"+stopLoss );
		

					
		System.out.println("ChooserWorkSheetJSP CANNOT UPDATE MyModeDate :"+MyModeDate);
		System.out.println("ChooserWorkSheetJSP CANNOT UPDATE weekly :"+weekly);
		if(MyModeDate!=null){
			try(DAOFactoryWorkSheet dao = new DAOFactoryWorkSheet()) {
				
			if(weekly==null  ){
				 arr=dao.getWorkSheetByDate(MyModeDate)  ;
			}
			else{
				 
				 arr = dao.getWorkSheetByWeek(MyModeDate);
			}
				
				
			request.getSession(). setAttribute("WorkSheet",arr);	
			}
			catch(Exception e){
				System.out.println("ChooserWorkSheetJSP CANNOT UPDATE ERROR :"+e);
				throw new ServletException("ChooserWorkSheetJSP CANNOT UPDATE ERROR :");
			}
			
			
		}else{
			
			try (DAOFactoryWorkSheet dao = new DAOFactoryWorkSheet()) {
				WorkSheetAccess work = new WorkSheetAccess(CODE, new Date(), time, reason, Double.parseDouble(buy),
						Double.parseDouble(stopLoss), edate, trend, volatiles, panic, discounted, multiMonth, majorSupport,
						meanRevision, changeTrend, sellergain,"");
				System.out.println("ChooserWorkSheetJSP doPost createWorkSheet :" );
				dao.updateWorkSheet(work);

			} catch (Exception e) {
				System.out.println("ChooserWorkSheetJSP doPost ERROR :" + e);
				 request.setAttribute("error",e.getMessage());
			}
			
			
		}
		
		
		
		
		


			 
		doGet( request, response);
		
		  
		
		
		}
	
	
}
