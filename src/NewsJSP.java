
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import access.NewsAccess;
import factory.DAOFactoryNews;

public class NewsJSP  extends HttpServlet{
	private String message;
	
	  
	
		
	  public void init() throws ServletException	  {
		  System.out.println("i am init");
		 
			try{
			
			}catch(Exception e){
				  System.out.println("Error ININT :"+e);
			}
		    
		  
		  
	  }
	 
	
	public void doGet(HttpServletRequest request,
          HttpServletResponse response)
  throws ServletException, IOException
	{
		System.out.println("Do GET NewsJSP");
		

		 ArrayList <NewsAccess> myarr;
		
		 myarr = (ArrayList <NewsAccess> ) request.getSession().getAttribute("ASXNEWSLIST");
		 
		 
		try(DAOFactoryNews fac =  new DAOFactoryNews()) {
			if(myarr == null){
				//myarr= fac.getAsxNewsByDate(new Date());
			//	myarr= fac.getAsxNewsUniqueByDate (new Date() );
				myarr= fac.getAsxNewsUniqueByDate(new Date());
				
				request.getSession().setAttribute("ASXNEWSLIST",myarr);
				request.getSession().setAttribute("TOTAL",new Integer( myarr.size()));
				System.out.println("Do GET ASXJsp  NewsJSP size  :"+myarr.size());
			}
		
			
			
			
		} catch (Exception e) {
			System.out.println("Do GET ASXJsp  NewsJSP errpr get News  :"+e);
		}
		System.out.println("Do GET ASXJsp  NewsJSP v1");
		
		if(request.getParameter("autorefresh")!=null  ){
			System.out.println("Do GET ASXJsp  NewsJSP run 1");

			request.setAttribute("autorefresh","Y");
			
			if ( request.getSession().getAttribute("ASXNEWSLIST.index")==null){
				request.getSession().setAttribute("ASXNEWSLIST.index" , new Integer(0));
			}else{
				Integer index =  (Integer)request.getSession().getAttribute("ASXNEWSLIST.index");
				request.getSession().setAttribute("ASXNEWSLIST.index",Integer.sum(index.intValue(), 1) );
				System.out.println("Do  AUTO REFRESH GET ASXJsp INDEX XX  :"+Integer.sum(index.intValue(), 1));
				
			}
			
			request.setAttribute("INDEX",request.getSession().getAttribute("ASXNEWSLIST.index") );
			
			
		}
	
		if(request.getAttribute("INDEX")==null  )request.setAttribute("INDEX",new Integer( 0));

		System.out.println("Do GET ASXJsp INDEX :"+request.getAttribute("INDEX"));
		
		System.out.println("Do GET ASXJsp  NewsJSP size:::  :"+myarr.size());
		
		 String nextJSP = "/NewsJSP.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			dispatcher.forward(request,response);
			
		
		
}
	
	public void doPost(HttpServletRequest request,
          HttpServletResponse response)
  throws ServletException, IOException
	{
		System.out.println("Do Post ASXJsp");
	String index = request.getParameter("INDEX");
	String code = request.getParameter("CODE");
	String precomment = request.getParameter("PRECOMMENT");
	String MyModeDate = request.getParameter("MyModeDate");
	
	
	
	
	String yes = request.getParameter("Yes");
	String no = request.getParameter("No");
	//System.out.println("Code to flag with NO: "+mycode);
	//System.out.println("Code to flag with yes: "+yes);
	//System.out.println("Code to flag with no: "+no);
	
	//System.out.println("code: "+code);
	//System.out.println("precomment: "+precomment);
	
	ArrayList <NewsAccess> myarr  = (ArrayList <NewsAccess> ) request.getSession().getAttribute("ASXNEWSLIST");
	if(MyModeDate == null){
		int myindex=Integer.parseInt(index.trim());
	
		try(DAOFactoryNews fac =  new DAOFactoryNews()) {

			
			NewsAccess news = myarr.get(myindex);
			news.setNotes(precomment);
			if(yes != null )news.setOk("Y");
			news.setSeen("Y");
			fac.updateNews(news);
			
			
		
			
			
			
			
			
		}catch (Exception e){
			System.out.println("Failed adding record : "+e);
			throw new ServletException ("ünable to add record");
		}
		 request.setAttribute("INDEX",new Integer( myindex+1));
		
	}else{
		try(DAOFactoryNews fac =  new DAOFactoryNews()) {
			
				
				myarr= fac.getAsxNewsUniqueByDate(MyModeDate);
			
				request.getSession().setAttribute("ASXNEWSLIST",myarr);
				request.getSession().setAttribute("TOTAL",new Integer( myarr.size()));
				System.out.println("Do GET ASXJsp  NewsJSP size  :"+myarr.size());
		
			
		} catch (Exception e) {
			System.out.println("Do GET ASXJsp  NewsJSP errpr get News  :"+e);
		}
	}
	

		
		
			System.out.println("Do POST ASXJsp INDEX :"+request.getAttribute("INDEX"));

	
	doGet( request, response);
	//cancel (  Integer.parseInt(mycode.trim())   );
	  
	
	
	}
	

	
	
	
}


