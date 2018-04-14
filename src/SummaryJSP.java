

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import access.DataAccess;
import access.StockAccess;
import factory.DAOFactoryData;
import factory.DAOFactoryStock;

public class SummaryJSP  extends HttpServlet{ 
	

	 Hashtable <String,ArrayList <DataAccess>> ht = new Hashtable <String,ArrayList <DataAccess>>() ;
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

		System.out.println("DO doGet   :SummaryJSP 1");
		String nextJSP = "/chartrs.jsp";

		Hashtable  <String ,StockAccess>  arr  =  (Hashtable  <String ,StockAccess>)request.getSession().getAttribute("Stock");
		
		 try(DAOFactoryStock dao = new DAOFactoryStock()) {
				
				if( arr == null) arr=dao.getAllHash();
				
				   
				 request.getSession().setAttribute("Stock",arr);
					
				} catch (Exception e) {	
					System.out.println("SummaryJSP doGet ERROR :"+e); 
					throw new ServletException ("ERROR  SummaryJSP getAllHash :"+e);
		
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
		

		System.out.println("SummaryJSP doGET  DISPATCH NOW ");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);

		}

	



	
	
	
	public void doPost(HttpServletRequest request,
	          HttpServletResponse response)
	  throws ServletException, IOException
		{
		System.out.println("SummaryJSP doPost  :" );
			String CODE = request.getParameter("CODE");
			
				
			try (DAOFactoryData dao = new DAOFactoryData()) {
				ArrayList <DataAccess> arr = 	dao.getStock(CODE);
				request.setAttribute("Data", arr);
				String code =arr.get(0).getCode();
				
				request.setAttribute("CODE",code.substring(0, code.indexOf("."))     );		
				
			} catch (Exception e) {
				System.out.println("SummaryJSP doPost ERROR :" + e);
			}
		
				
			doGet( request,     response);	
		
		
		}

}
