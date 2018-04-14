
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

public class ChooserModeJSP2  extends HttpServlet{ 
	

	ArrayList <TechStrAccess>  arr;
	 String date;
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
		
		 System.out.println("DO doGet   :ChooserModeJSP2 1");
		 String nextJSP = "/ChooserModeJSP2.jsp";
			
		 ArrayList <TechStrAccess>  myarr =null;
		 
		 myarr = ( ArrayList <TechStrAccess> )request.getSession().getAttribute("TechStr");
		 if(myarr==null){
			 try(DAOFactoryTechStr dao = new DAOFactoryTechStr()) {
				 System.out.println("DO doGet   :ChooserModeJSP2 Get Today :");
				 myarr = dao.getTechStrList( null,LocalDate.now().toString() );
				 request.getSession().setAttribute("TechStr",myarr);
					
				} catch (Exception e) {
					System.out.println("DO doGet   :ChooserModeJSP2 EERRORR:"+e);
				}
			 
		 }
			
						 	  
				System.out.println("ChooserModeJSP doGET  DISPATCH NOW ");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
				dispatcher.forward(request,response);
				
				
				
			
			
			
			
		
		
		
		
		}





	

public void doPost(HttpServletRequest request,
          HttpServletResponse response)
  throws ServletException, IOException
	{
	 System.out.println("DO doPost   :ChooserModeJSP2 ** ");
	
			
		
			String combo1=request.getParameter("combo1");
			String MyModeDate = request.getParameter("MyModeDate");
			
			
			 System.out.println("DO doPost   :ChooserModeJSP2 combo1:"+combo1);
	
			 System.out.println("DO doPost   :ChooserModeJSP2 MyModeDate:"+MyModeDate);
			
			 
				
			 ArrayList <TechStrAccess>  myarr = new  ArrayList <TechStrAccess>  ();
				try(DAOFactoryTechStr dao = new DAOFactoryTechStr()) {
					 System.out.println("DO doPost   :ChooserModeJSP2 Get Data:");
					 myarr = dao.getTechStrListBySql("techstr." +MyModeDate,Integer.parseInt(combo1));
					
				} catch (Exception e) {
					System.out.println("DO doPost   :ChooserModeJSP2 EERRORR:"+e);
				}
				
					
				request.getSession().setAttribute("TechStr",myarr);
				doGet(request,response);		
	
			
			
			
			
	
			
			
	
	
	}

}
