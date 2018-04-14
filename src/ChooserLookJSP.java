
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import access.StockAccess;
import access.TechStrAccess;
import factory.DAOFactoryCategory;
import factory.DAOFactoryStock;
import factory.DAOFactoryTechStr;

public class ChooserLookJSP  extends HttpServlet{ 
	
  
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
		
		System.out.println("DO doGet   :ChooserTodayJSP 1");
		String nextJSP = "/ChooserLookJSP.jsp";

		try (DAOFactoryCategory dao = new DAOFactoryCategory()) {

			if (category == null)
				category = dao.getAllCategory();

			request.setAttribute("Categories", category);
			System.out.println("ChooserTodayJSP doGet CATT :" + category.size());

		} catch (Exception e) {
			System.out.println("ChooserTodayJSP doGet ERROR :" + e);
			throw new ServletException("ERROR  StockJSP getAllCategory :" + e);
		}

		// System.out.println("ChooserModeJSP doGET START ARR:"+arr.size());

		System.out.println("ChooserTodayJSP doGET  FINISH");
		request.getSession() .setAttribute("INDEX","-1");// user has come back to orignal page , set index back to zero, user no more at auto refresh page , so set index back to zero.

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
		
		
		}





	//using hashmap because autorefresh  now cache the data , instead of every call hitting dtbs.
	
	HashMap <String,ArrayList<StockAccess> >tableStock= new 	HashMap <String,ArrayList<StockAccess> >();;
	HashMap <String,ArrayList<TechStrAccess> >tableMode=new HashMap <String,ArrayList<TechStrAccess> >();;

public void doPost(HttpServletRequest request,
          HttpServletResponse response)
  throws ServletException, IOException
	{
		System.out.println("DO doPost   :ChooserTodayJSP");

		ArrayList<StockAccess> myarr = 	new ArrayList<StockAccess> ();
		ArrayList<TechStrAccess> modes = new ArrayList<TechStrAccess>();
		//ArrayList<StockAccess> myarr = 	(ArrayList<StockAccess>) request.getSession().getAttribute("Stocks");
		//ArrayList<TechStrAccess> modes = (ArrayList<TechStrAccess>) request.getSession().getAttribute("MODES");
	
		
		String CATEGORY = request.getParameter("CATEGORY");

		String MyModeDate = request.getParameter("MyModeDate");
		System.out.println("DO doPost   :CategoryJSP:" + CATEGORY);

		String SOURCE = request.getParameter("SOURCE");
		System.out.println("CategoryJSP doPost SOURCE:" + SOURCE);

		String autoRefresh = request.getParameter("autoRefresh");
		System.out.println("CategoryJSP doPost autoRefresh:" + autoRefresh);
		if (autoRefresh != null)
			request.getSession().setAttribute("refresh", "Y");
		System.out.println("CategoryJSP doPost INDEX:" + request.getSession().getAttribute("INDEX"));
		
		
		
		String date = "";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if (MyModeDate == null || MyModeDate.trim().equals(""))
			date = dateFormat.format(new Date());
		else
			date = MyModeDate;
		
		
	
		if (! CATEGORY.trim().equals("NO")) {//user set category
			System.out.println("DO doPost   :ChooserTodayJSP FIND CATEGORY");
			try (DAOFactoryStock dao = new DAOFactoryStock()) {

			
				System.out.println("ChooserTodayJSP doGet FactoryStock Load CATEGORY :");
			
					
					if(! tableStock.containsKey(CATEGORY)){
						System.out.println("ChooserTodayJSP doGet FactoryStock Load CATEGORY -- GET DATABASE:");
						
						myarr = dao.getStockCategory(CATEGORY, date);
						tableStock.put(CATEGORY, myarr)	;	
						
						System.out.println("ChooserTodayJSP doGet FactoryStock Load CATEGORY:");
					}
					myarr=tableStock.get( CATEGORY);
					request.getSession().setAttribute("Stocks", myarr);
					

			

				

			} catch (Exception e) {
				System.out.println("ChooserTodayJSP doGet ERROR :" + e);
			}

		}
// some how bad everytime , it refresh it need to reload all data.
// too complex to change source as session..... what if user change configuration half way , session still got old config.		
		if (SOURCE != null) {//user set source
			if (SOURCE.equals("ALL") || SOURCE.equals("Random")) {

				try (DAOFactoryStock dao = new DAOFactoryStock()) {
					
					System.out.println("ChooserTodayJSP doGet FactoryStock Load SOURCE :"+SOURCE);
						
					if(! tableStock.containsKey("ALL"+date)){
						System.out.println("ChooserTodayJSP doGet FactoryStock Load SOURCE -- GET DATABASE:"+SOURCE);
						myarr = dao.getAllStockDataList(date);
					//	System.out.println("ChooserTodayJSP doGet FactoryStock Load size 1  :"+myarr.size());
						tableStock.put("ALL"+date, myarr)	;	
					}
					
					if (SOURCE.equals("Random")) {
						if(! tableStock.containsKey("Random"+date)){
							System.out.println("ChooserTodayJSP doGet FactoryStock Load SOURCE -- GET DATABASE:"+SOURCE);

							myarr = dao.getAllStockDataList(date);
							java.util.Collections.shuffle(myarr);
							tableStock.put("Random"+date, myarr)	;	
						}
						
						

					}
					myarr=  tableStock.get(SOURCE+date);
					request.getSession().setAttribute("Stocks", myarr);
					
					System.out.println("ChooserTodayJSP doGet FactoryStock Load SOURCE size:"+myarr.size());

				
				} catch (Exception e) {
					System.out.println("ChooserTodayJSP doGet FactoryStock  ERROR :" + e);
				}

			}
			// to do select with category , for now just like the top 300
			// company
			if (SOURCE.equals("9") || SOURCE.equals("3") || SOURCE.equals("7")) {
				
					System.out.println("ChooserTodayJSP doGet FactoryStock Load mode:"+SOURCE);
				LocalDate today = LocalDate.now();
				ArrayList<String> dates = new ArrayList<String>();
				for (int x = 1; x < 6; x++) {// add 5 days before.
					today.minusDays(x);
					dates.add(today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

				}

				try (DAOFactoryTechStr dao = new DAOFactoryTechStr()) {
					if(! tableMode.containsKey(SOURCE+today)){
						System.out.println("ChooserTodayJSP doGet FactoryStock Load mode------DATABASE:"+SOURCE);
					for (String mydate : dates) {
						ArrayList<TechStrAccess> mymodes = dao.getTechStrListByTop300ByDate(SOURCE, mydate);
						modes.addAll(mymodes);
						

					}
					tableMode.put(SOURCE+today, modes)	;	
					}
					modes=tableMode.get(SOURCE+today);
					request.getSession().setAttribute("MODES",modes );
				

				
				} catch (Exception e) {
					System.out.println("ChooserTodayJSP doGet FactoryStock  ERROR :" + e);
				}

			
		}
			
			
		
		
		//System.out.println("DO doPost   :Stock size :" + myarr.size());
		//System.out.println("DO doPost   :Modes size :" + modes.size());
		System.out.println("ChooserTodayJSP doGet FactoryStock  WHere to GO  :" );
		//if(myarr.size()==0 & modes.size()==0)doGet(request, response);
		
			int x = Integer.parseInt((String)request.getSession(). getAttribute("INDEX"));
			System.out.println("ChooserTodayJSP doGet FactoryStock  WHere to GO  : NO" );
			x=x+1;
			request.getSession(). setAttribute("INDEX",x+"");
			
			System.out.println("ChooserTodayJSP doGet FactoryStock  WHere to GO  : Number:" +x);
		
		boolean flag1=false;
		boolean flag2=false;
		
		if(myarr==null)flag1=true;
		else if ( myarr.size()==0 )flag1=true;
		if(modes==null)flag2=true;
		else if ( modes.size()==0 )flag2=true;	
			
		if(flag1&flag2 )	doGet(request, response);	
		else{
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Look.jsp");
			dispatcher.forward(request, response);
		}
		}
		
	}


public static void main(String[] args) {
	LocalDate tomorrow = LocalDate.now();
	String asCustomPattern = tomorrow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	System.out.println("ChooserTodayJSP doGet ERROR :" + asCustomPattern);

}

}
