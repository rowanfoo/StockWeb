
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import access.MyNotesAccess;
import access.StockAccess;
import factory.DAOFactoryMyNotes;
import factory.DAOFactoryStock;

public class MyNotesJSP  extends HttpServlet{
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
			System.out.println("Do GET MyNotesJSP");
			
			
			String nextJSP = "/MyNotes.jsp";
			
			 try(DAOFactoryStock dao = new DAOFactoryStock()) {
					
					if( arr == null) arr=dao.getAllHash();
						
					 request.setAttribute("Stock",arr);
						
					} catch (Exception e) {	
						System.out.println("MyNotesJSP doPost ERROR :"+e); 
						throw new ServletException ("ERROR  MyNotesJSP getTechStrList :"+e);
					}
			
			
			 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
				dispatcher.forward(request,response);
		
			
			
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Do POST  MyNotesJSP");
		String code = request.getParameter("CODE");
		String note1 = request.getParameter("Note1");
		String mode = request.getParameter("Mode");

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = dateFormat.format(new Date());

		System.out.println("MyNotesJSP CANNOT UPDATE mode :" + mode);
		System.out.println("MyNotesJSP CANNOT UPDATE code :" + code);

		try (DAOFactoryMyNotes dao = new DAOFactoryMyNotes()) {

			MyNotesAccess acc = new MyNotesAccess(date, code.trim(), note1.trim(), Integer.parseInt(mode.trim()));
			dao.createNotes(acc);

		} catch (Exception e) {
			System.out.println("MyNotesJSP CANNOT UPDATE ERROR :" + e);
			throw new ServletException("MyNotesJSP CANNOT UPDATE ERROR :");
		}

		doGet(request, response);

	}
	
	
}
