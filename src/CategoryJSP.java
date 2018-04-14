
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import access.StockAccess;
import factory.DAOFactoryCategory;
import factory.DAOFactoryData;
import factory.DAOFactoryStock;

public class CategoryJSP  extends HttpServlet{ 
	

	ArrayList <String>  category;
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
		
		 System.out.println("DO doGet   :CategoryJSP 1");
		 String nextJSP = "/CategoryJSP.jsp";
			
			
			
			
			
			
    		
			 try(DAOFactoryCategory dao = new DAOFactoryCategory()) {
					
					if( category == null) category=dao.getAllCategory();
						
					 request.setAttribute("Categories",category);
					 System.out.println("StockJSP doGet CATT :"+category.size()); 
						
					} catch (Exception e) {	
						System.out.println("StockJSP doGet ERROR :"+e); 
						throw new ServletException ("ERROR  StockJSP getAllCategory :"+e);
					}
				    
			 
					 
				
					//System.out.println("ChooserModeJSP doGET START ARR:"+arr.size());
					
					
					
					 
					System.out.println("CategoryJSP doGET  FINISH");
			  
					
					
					
					
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
				dispatcher.forward(request,response);
				
				
				
			
			
			
			
		
		
		
		
		}





	//int mycount =0;
	
	

public void doPost(HttpServletRequest request,
          HttpServletResponse response)
  throws ServletException, IOException
	{
		System.out.println("DO doPost   :CategoryJSP");

		ArrayList<StockAccess> myarr = null;

		String CATEGORY = request.getParameter("CATEGORY");

		String MyModeDate = request.getParameter("MyModeDate");
		System.out.println("DO doPost   :CategoryJSP:" + CATEGORY);

		String SOURCE = request.getParameter("SOURCE");
		System.out.println("CategoryJSP doPost SOURCE:" + SOURCE);
		
		
	
		

		if (CATEGORY != null) {

			try (DAOFactoryStock dao = new DAOFactoryStock()) {// can choose  source from either from database or XLS , 

				String date = "";
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				if (MyModeDate == null || MyModeDate.trim().equals(""))
					date = dateFormat.format(new Date());
				else
					date = MyModeDate;

				if (SOURCE.equals("XLS")) {
					try (DAOFactoryData dot = new DAOFactoryData()) {

						myarr = dot.getDataListXLSbyCategory(dao.getAllList(), CATEGORY);
					} catch (Exception e) {
						System.out.println("CategoryJSP doPost Data:" + e);
					}
				} else {
					myarr = dao.getStockCategory(CATEGORY, date);
								
				}

				System.out.println("DO doPost   :arr size :" + myarr.size());

				request.setAttribute("Stocks", myarr);
				request.setAttribute("TYPE", CATEGORY);

			} catch (Exception e) {
				System.out.println("CategoryJSP doGet ERROR :" + e);
			}

		}

		doGet(request, response);
	
	}

}
