
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import access.TechStrAccess;
import factory.DAOFactoryTechStr;

public class ModeJSP  extends HttpServlet{
	int mycount =0;
	ArrayList <TechStrAccess>  arr ;

	public void init() throws ServletException	  {
		  
	  }
	
	
	
	
	
	
	public void doGet(HttpServletRequest request,
	          HttpServletResponse response)
	  throws ServletException, IOException
		{
			System.out.println("Do GET ModeJSP");
			

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
			
			arr= (ArrayList)request.getSession().getAttribute("TechStr");

			//request.setAttribute("CODE", code);
			Integer d = new Integer(  mycount);
			 request.setAttribute("INDEX",new Integer(  mycount));

			 //request.setAttribute("TechStr",arr);
			
			 mycount++;
			 
			 //int index = ((Integer) request.getAttribute("TechStr")).intValue();
			 //TechStrAccess obj = arr.get(mycount);
			 
			 String nextJSP = "/ModeJSP.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
				dispatcher.forward(request,response);
		
			
			
	}
	
	
	public void doPost(HttpServletRequest request,
	          HttpServletResponse response)
	  throws ServletException, IOException
		{
			System.out.println("ModeJSP DoPost ");
			
			if(request.getParameter("INDEX")==null){
				System.out.println("ModeJSP INITIALIZE ");
				doGet( request, response);
				return;
			}
			System.out.println("ModeJSP ENTER ");
			
			
			String index = request.getParameter("INDEX").trim();
			String precomment = request.getParameter("PRECOMMENT");
			
			String yes = request.getParameter("Yes");
			String no = request.getParameter("No");
			System.out.println("Add record start : "+yes);
			System.out.println("Add record start : INDEX:"+index+":");
			
			 System.out.println("ModeJSP INDEX DOGET OBJ:"+arr.get(Integer.parseInt(index) ) );
			 TechStrAccess obj =  arr.get(Integer.parseInt(index) );
			 
			 try(DAOFactoryTechStr dao = new DAOFactoryTechStr()) {
					
				if(yes != null){
						obj.setNotes(precomment);
						obj.setOK("OK");
						
					
				}else {
					obj.setNotes(precomment);
					obj.setOK("NO");
				}
					
				
				dao.UpdateTechStr(obj);
				
				
				
			} catch (Exception e) {	
				System.out.println("ModeJSP doPost ERROR :"+e); 
				throw new ServletException ("ERROR  DAOFactoryTechStr getTechStrList :"+e);
			}
			
			
		
		doGet( request, response);
		
		  
		
		
		}
	
	
}
