
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import access.TechStrAccess;

public class LookJSP  extends HttpServlet{
	int mycount =0;
	ArrayList <TechStrAccess>  arr ;

	public void init() throws ServletException	  {
		  
	  }
	
	
	
	
	
	
	public void doGet(HttpServletRequest request,
	          HttpServletResponse response)
	  throws ServletException, IOException
		{
			System.out.println("Do GET LookJSP");
			

			//arr = (ArrayList ) 	request.getSession().getAttribute("TechStr");
			/*
			if(arr==null){
				try(DAOFactoryTechStr dao = new DAOFactoryTechStr()) {
					
					
					
					  arr = dao.getTechStrList(null,"2016-10-25");
				
					 
					//request.getSession().setAttribute("TechStr",arr);
					System.out.println("ModeJSP doGET START ARR:"+arr.size());
					System.out.println("ModeJSP doGET  FINISH");
					
				} catch (Exception e) {	System.out.println("ModeJSP doGet ERROR :"+e);  }
				
				
			}
*/
			
			//arr= (ArrayList)request.getSession().getAttribute("TechStr");

			//request.setAttribute("CODE", code);
			//Integer d = new Integer(  mycount);
		//	 request.setAttribute("INDEX",new Integer(  mycount));

			 //request.setAttribute("TechStr",arr);
			
			// mycount++;
			 
			 //int index = ((Integer) request.getAttribute("TechStr")).intValue();
			 //TechStrAccess obj = arr.get(mycount);
			 
			 String nextJSP = "/Look.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
				dispatcher.forward(request,response);
		
			
			
	}
	
	
	public void doPost(HttpServletRequest request,
	          HttpServletResponse response)
	  throws ServletException, IOException
		{
			System.out.println("LookJSP DoPost ");
			
			if(request.getAttribute("INDEX")==null){
				request.setAttribute("INDEX","0");
			}else{
				int x = Integer.parseInt((String)request.getAttribute("INDEX"));
				x=x+1;
				request.setAttribute("INDEX",x+"");
				
			}
			
			System.out.println("LookJSP ENTER ");
			
			
			
		
		doGet( request, response);
		
		  
		
		
		}
	
	
}
