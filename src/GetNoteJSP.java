

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

import access.MyNotesAccess;
import access.StockAccess;
import factory.DAOFactoryMyNotes;

public class GetNoteJSP  extends HttpServlet{
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
			
			
			String nextJSP = "/GetNotes.jsp";
			
			String MyNoteDate = (String) request.getAttribute("MyNoteDate");
			String mode = (String) request.getAttribute("mode");
			if(MyNoteDate==null){
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				MyNoteDate=dateFormat.format( new Date());	
			}
			if(mode==null){
				mode="2";
			}
			System.out.println("MyNotesJSP :");	
			
			try(DAOFactoryMyNotes dao = new DAOFactoryMyNotes()) {
				
				
					ArrayList<MyNotesAccess>  arr = dao.getNotesbyDate(MyNoteDate.trim(),Integer.parseInt(mode.trim()  ) );
			//		System.out.println("MyNotesJSP :"+arr);	
					request.setAttribute("MyNotes",arr);
			}
			catch(Exception e){
				System.out.println("MyNotesJSP CANNOT UPDATE ERROR :"+e);
				throw new ServletException("MyNotesJSP CANNOT UPDATE ERROR :");
			}
			
			
		
			 
			 
			 
			
			 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
				dispatcher.forward(request,response);
		
			
			
	}
	
	
	public void doPost(HttpServletRequest request,
	          HttpServletResponse response)
	  throws ServletException, IOException
		{
		
		System.out.println("Do POST  MyNotesJSP");
		String code = request.getParameter("CODE");		
		String note1 = request.getParameter("Note1");
		String mode = request.getParameter("Mode");
		String MyNoteDate = request.getParameter("MyNoteDate");
		String yes = request.getParameter("Yes");
		String id = request.getParameter("ID");  
		
		System.out.println("MyNotesJSP CANNOT UPDATE Yes :"+yes);			
		System.out.println("MyNotesJSP CANNOT UPDATE mode :"+mode);
		System.out.println("MyNotesJSP CANNOT UPDATE code :"+code);
	//	System.out.println("MyNotesJSP CANNOT UPDATE Note1 :"+note1);	
		System.out.println("MyNotesJSP CANNOT UPDATE id :"+id);	
			try(DAOFactoryMyNotes dao = new DAOFactoryMyNotes()) {
				
				if(yes!=null & id !=null ){
					MyNotesAccess acc = new MyNotesAccess (new Date(),"" ,note1.trim() ,0);// update notes  by using id
					acc.setId(Long.parseLong(id.trim()));
					dao.updateNotes(acc);
				}
				else{
					request.setAttribute("MyNoteDate", MyNoteDate);
					request.setAttribute("mode", mode);
				}
				
				
				
			}
			catch(Exception e){
				System.out.println("MyNotesJSP CANNOT UPDATE ERROR :"+e);
				throw new ServletException("MyNotesJSP CANNOT UPDATE ERROR :");
			}
			
			
		
		
		
		
		


			 
		doGet( request, response);
		
		  
		
		
		}
	
	
}
