

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.regex.Pattern;

import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import access.DataAccess;
import access.StockAccess;
import factory.DAOFactoryData;
import factory.DAOFactoryStock;

public class RSJSP  extends HttpServlet{ 
	

	 //Hashtable <String,ArrayList <DataAccess>> ht = new Hashtable <String,ArrayList <DataAccess>>() ;
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

		System.out.println("DO doGet   :RS 1");
		System.out.println("DO doGet   :RS 1: "+request.getContextPath());
		System.out.println("DO doGet   :RS 1: "+request.getPathInfo()+" : "+request.getPathTranslated() );
		System.out.println("DO doGet   :RS 1: "+request.getRequestURL() );
		System.out.println("DO doGet   :RS 1: "+request.getSession().getServletContext().toString() );
		String nextJSP = "/chartrs.jsp";
		
		
		String url =request.getRequestURL()+"";
		String path=url.substring(url.lastIndexOf("/")+1,url.length());
		String pattern = ".*RSJSP.*";
		boolean isMatch = Pattern.matches(pattern, request.getRequestURL()+"");
		      System.out.println("The text contains 'book'? " + isMatch);
		      System.out.println("The text contains 'book'? " + url.substring(url.lastIndexOf("/"),url.length()    ));  
		if(!isMatch)nextJSP= "/chartsumm.jsp";     

		Hashtable  <String ,StockAccess>  arr  =  (Hashtable  <String ,StockAccess>)request.getSession().getAttribute("Stock");
		
		 try(DAOFactoryStock dao = new DAOFactoryStock()) {
			   System.out.println("1 ");
				if( arr == null) arr=dao.getAllHash();

				
				
				 request.getSession().setAttribute("Stock",arr);
				 request.setAttribute("path",path);
	
				 
				} catch (Exception e) {	
					System.out.println("StockJSP doGet ERROR :"+e); 
					throw new ServletException ("ERROR  StockJSP getAllHash :"+e);
		
		}
		 
		
		/*
		ArrayList <StockAccess>  arr = null;
		try (DAOFactoryStock dao = new DAOFactoryStock()) {

			arr = dao.getStockIndex(StockAccess.top300cat);
 
			System.out.println("RS doGet size :" + arr.size());

			
			System.out.println("RS doGET  FINISH");

		} catch (Exception e) {
			System.out.println("RS ERROR :" + e);
		}

		
		
		
		
		try (DAOFactoryData dao = new DAOFactoryData()) {

		
			for(StockAccess sa:arr){
				ht.put(sa.getCode(),dao.getStock(sa.getCode() )   );
			
			
			}
			
			
			
			
			
		} catch (Exception e) {
			System.out.println("RS ERROR :" + e);
		}
		request.setAttribute("Data", ht);
		*/
		

		System.out.println("RS doGET  DISPATCH NOW ");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);

		}

	



	
	
	
	public void doPost(HttpServletRequest request,
	          HttpServletResponse response)
	  throws ServletException, IOException
		{
		System.out.println("RS doPost  :" );
			String CODE = request.getParameter("CODE");
			
				
			try (DAOFactoryData dao = new DAOFactoryData()) {
				ArrayList <DataAccess> arr = 	dao.getStock(CODE);
	
				
				
				
				
				
				
				
				request.setAttribute("Data", arr);
				String code =arr.get(0).getCode();
				
				request.setAttribute("CODE",code.substring(0, code.indexOf("."))     );		
				
			} catch (Exception e) {
				System.out.println("RS doPost ERROR :" + e);
			}
		
				
			doGet( request,     response);	
		
		
		}

}
