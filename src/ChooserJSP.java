
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChooserJSP  extends HttpServlet{ 
	
/*
	int mycount =0;
	XSSFSheet sheet;
	  public void init() throws ServletException	  {
		  System.out.println("i am init");
		 
			try{
				 openExcel();
					vec= new Vector(); 
			}catch(Exception e){
				  System.out.println("Error ININT :"+e);
			}
		    
		  
		  
	  }
	
	*/
	
	
	public void doGet(HttpServletRequest request,
	          HttpServletResponse response)
	  throws ServletException, IOException
		{
		
		 System.out.println("DO doGet   :ChooserJSP");
		 String nextJSP = "/ChooserJSP.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			dispatcher.forward(request,response);
		}





	//int mycount =0;
	
	

public void doPost(HttpServletRequest request,
          HttpServletResponse response)
  throws ServletException, IOException
	{
	
	//	if(request.getSession().getAttribute("worksheet") == null ){
		
			String index = request.getParameter("combo1");
			String refresh = request.getParameter("autoRefresh");
			
			 System.out.println("DO Post  :"+ index);
			 System.out.println("DO Post refresh :"+ refresh);
			 if (refresh != null )request.getSession().setAttribute("refresh","Y");
			 try{
				 request.getSession().setAttribute("worksheet",Excel.getExcel().getSheetIndex(Integer.parseInt(index)    ));
			 }catch(Exception e){
				 System.out.println("ChooserJSP cant load worksheet :"+ e);
			 }
			 if(Integer.parseInt(index)== 25   ){
				 System.out.println("ChooserJSP is 25");
				 request.getSession().setAttribute("GENERAL","Y");
			 } else if(Integer.parseInt(index)== 19  ) request.getSession().setAttribute("WISHLIST","Y");
		//}else{
			
			
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/GeneralJSP");
			dispatcher.forward(request,response);
			
			
			
		//}
	
	}

}
