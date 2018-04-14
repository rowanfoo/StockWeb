

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import access.TechStrAccess;
import factory.DAOFactoryTechStr;

public class SpecialModeJSP  extends HttpServlet{
	int mycount =0;
	ArrayList <TechStrAccess>  arr ;

	public void init() throws ServletException	  {
		  
	  }
	
	
	
	
	
	
	public void doGet(HttpServletRequest request,
	          HttpServletResponse response)
	  throws ServletException, IOException
		{
			System.out.println("Do GET SpecialModeJSP");
			

			try(DAOFactoryTechStr dao = new DAOFactoryTechStr()) {
		        arr =  new ArrayList<TechStrAccess>() ;
		         arr = dao.getTechStrListByMonthMode(LocalDate.now().getMonthValue() );


		      } catch (Exception e) {	System.out.println("SpecialModeJSP doGet ERROR :"+e);  }

			 request.setAttribute("SPECIALMODE", arr);
			 String nextJSP = "/SpecialMode.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
				dispatcher.forward(request,response);
		
			
			
	}
	
	
	public void doPost(HttpServletRequest request,
	          HttpServletResponse response)
	  throws ServletException, IOException
		{
			System.out.println("DOPost SpecialModeJSP ");
			
			if(request.getParameter("Refresh") !=null){
				System.out.println("SpecialModeJSP REFRESH ");
				
				//refresh data
				try(DAOFactoryTechStr dao = new DAOFactoryTechStr()) {
			        arr =  new ArrayList<TechStrAccess>() ;
			         arr = dao.getTechStrListByMonthMode(LocalDate.now().getMonthValue() );
			         if(arr.size()>0)dao.deleteThisMonthTechStrListByMonthMode(); 

			      } catch (Exception e) {	System.out.println("SpecialModeJSP Refesh ERROR :"+e);  }

				
				
				
				new HigherLowStr().run();
			//	new LesserVolatileStr().run();
				new DownSixMonthBelowFifty().run();	    
				new ThreeMonthDownTrendStr().run();
				System.out.println("SpecialModeJSP REFRESH OK!!");
			
			}
			
			
		
		doGet( request, response);
		
		  
		
		
		}
	
	
}
