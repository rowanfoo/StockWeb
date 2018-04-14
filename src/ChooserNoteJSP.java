

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import access.MyNotesAccess;
import access.StockAccess;
import factory.DAOFactoryMyNotes;
import util.FormatUtil;

public class ChooserNoteJSP  extends HttpServlet{
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
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Do GET ChooserNoteJSP");

		ArrayList<MyNotesAccess> arr = (ArrayList<MyNotesAccess>) request.getSession().getAttribute("NewsList");

		String nextJSP = "/ChooseNotesJSP.jsp";

		try (DAOFactoryMyNotes dao = new DAOFactoryMyNotes()) {

			if (arr == null) {
				arr = dao.getNotesbyDate(FormatUtil.getTodayDateToString(), MyNotesAccess.MODE_NOTES);
				System.out.println("ChooserNoteJSP doGet  arr :"+arr.size());
				ArrayList<MyNotesAccess> arr2 =  dao.getNotesbyDate(LocalDate.now().minusDays(1).toString() , MyNotesAccess.MODE_NOTES);
				System.out.println("ChooserNoteJSP doGet  arr :"+arr2.size());

				arr.addAll(arr2);
				
				request.getSession().setAttribute("NewsList", arr);
			}
		} catch (Exception e) {
			System.out.println("MyNotesJSP doPost ERROR :" + e);
			throw new ServletException("ERROR  MyNotesJSP getTechStrList :" + e);
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);

	}
	
	
	public void doPost(HttpServletRequest request,
	          HttpServletResponse response)
	  throws ServletException, IOException
		{
		
		System.out.println("Do POST  ChooserNoteJSP");
		String MyModeDate = request.getParameter("MyModeDate");		
		String weekly = request.getParameter("weekly");
		String mode = request.getParameter("combo1");
		ArrayList< MyNotesAccess> arr =	null;
			
		
		//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		//String date=dateFormat.format( new Date());	
					
		System.out.println("ChooserNoteJSP CANNOT UPDATE MyModeDate :"+MyModeDate);
		System.out.println("ChooserNoteJSP CANNOT UPDATE weekly :"+weekly);
		System.out.println("ChooserNoteJSP CANNOT UPDATE weekly :"+mode);
			try(DAOFactoryMyNotes dao = new DAOFactoryMyNotes()) {
				
			if(weekly==null  ){
				 arr=dao.getNotesbyDate(MyModeDate,   Integer.parseInt(mode));
			}
			else{
				System.out.println("GetWeek");
				// arr=dao.getNotesbyWeek(MyModeDate,  Integer.parseInt(mode));
				 arr=dao.getNotesbyWeek(Integer.parseInt(mode));
					
			}
				
				
			request.getSession(). setAttribute("NewsList",arr);	
			}
			catch(Exception e){
				System.out.println("ChooserNoteJSP CANNOT get notes ERROR :"+e);
				throw new ServletException("ChooserNoteJSP CANNOT UPDATE ERROR :");
			}
			
			
		
		
		
		
		


			 
		doGet( request, response);
		
		  
		
		
		}
	
	
}
