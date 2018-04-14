

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

import access.StockAccess;
import factory.DAOFactoryStock;

public class ResearchJSP  extends HttpServlet{
	int mycount =0;
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
			System.out.println("Do GET ReseachJSP");
			
			
			String nextJSP = "/ResearchJSP.jsp";
			
			ArrayList<StockAccess> arr = new ArrayList<StockAccess> ();
			//File f = new java.io.File( ".\\webapps\\ROOT\\img\\TWE-D.gif" );
			
			//String current = f.getCanonicalPath();
			
	       // System.out.println("Current dir:"+current+"::"+f.exists());
			
			try(DAOFactoryStock dao = new DAOFactoryStock()) {
				
		
				arr = dao.getAllStockResearchList();
				request.setAttribute("RESEARCH", arr);
				System.out.println("Do GET ReseachJSP size:"+arr.size());
			
			
			}
			catch(Exception e){
				System.out.println("StockJSP CANNOT UPDATE ERROR :"+e);
				throw new ServletException("StockJSP CANNOT UPDATE ERROR :");
			}
			
			
		
		
		
			
			
			 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
				dispatcher.forward(request,response);
		
			
			
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Do POST  ReseachJSP");
		String code = request.getParameter("CODE");
		String note1 = request.getParameter("Note1");
		String mode = request.getParameter("Mode");

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = dateFormat.format(new Date());

		System.out.println("MyNotesJSP CANNOT UPDATE mode :" + mode);
		System.out.println("MyNotesJSP CANNOT UPDATE code :" + code);
/*
		try (DAOFactoryMyNotes dao = new DAOFactoryMyNotes()) {

			MyNotesAccess acc = new MyNotesAccess(date, code.trim(), note1.trim(), Integer.parseInt(mode.trim()));
			dao.createNotes(acc);

		} catch (Exception e) {
			System.out.println("ReseachJSP CANNOT UPDATE ERROR :" + e);
			throw new ServletException("ReseachJSP CANNOT UPDATE ERROR :");
		}
*/
		doGet(request, response);

	}
	
	
}
