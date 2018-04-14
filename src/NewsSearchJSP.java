

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import access.NewsAccess;
import factory.DAOFactoryNews;
import util.FormatUtil;

public class NewsSearchJSP  extends HttpServlet{
	private String message;
	
	  
	
		
	  public void init() throws ServletException	  {
		  System.out.println("i am init");
		 
			try{
			
			}catch(Exception e){
				  System.out.println("Error ININT :"+e);
			}
		    
		  
		  
	  }
	 
	private void makeCharts(HttpServletRequest request, ArrayList <NewsAccess> myarr,String keywd){
		 
		 HashMap<String , String > set = new HashMap<String , String >();
		 String param="";
		 String mycode="code=";
		 for(NewsAccess news:myarr){
			 
			 if(!set.containsKey(news.getCode() )  ){
				 set.put(news.getCode() , "");
				 param=param+mycode+news.getCode()+"&";
			 }
		 
		 
		 }
		 
		 request.setAttribute(keywd,param);
		 
	}
	String keywords[]={"Webcast","Briefing","boardroom","teleconference","CEO","update","conference","management","Presentation","Growth","New","Feasibility","Acquisition"};
	
	
	private void setData(HttpServletRequest request, String date) {
		ArrayList<NewsAccess> myar;

		try (DAOFactoryNews fac = new DAOFactoryNews()) {
			for (String keywd : keywords) {

				myar = fac.searchNewsKeywordDate(date, keywd);
				System.out.println("Do GET NewsSearch  NewsJSP setData  :" + myar.size());
				
				//if(keywd.equals("Change of Director")){
					//request.setAttribute("Director", myar);
				//	makeCharts( request, myar,"DirectorC");
			//	}
				//else{
					request.setAttribute(keywd, myar);
					makeCharts( request, myar,keywd+"C");
					setDirector( request, date);
				//}

			}
			request. setAttribute("info", "for date :"+date);
		} catch (Exception e) {
			System.out.println("Do GET NewsSearch  NewsJSP errpr get News  :" + e);
		}

	} 
	private void setDirector(HttpServletRequest request, int date){
		ArrayList <String> arr = new ArrayList <String>();
		arr.add("Director");
		arr.add("appendix 3Y");
	
		try (DAOFactoryNews fac = new DAOFactoryNews()) {
				ArrayList<NewsAccess> myar  = fac.searchNewsKeywordMonth(date, arr);
				request.getSession().  setAttribute("Director", myar);
				System.out.println("Do GET NewsSearch   keyword:  MULTI :: "+ myar.size()  );	
		} catch (Exception e) {
			System.out.println("Do GET NewsSearch  NewsJSP errpr get News  :" + e);
		}
		
	}
	
	private void setDirector(HttpServletRequest request, String date){
		ArrayList <String> arr = new ArrayList <String>();
		arr.add("Director");
		arr.add("appendix 3Y");
	
		try (DAOFactoryNews fac = new DAOFactoryNews()) {
				ArrayList<NewsAccess> myar  = fac.searchNewsKeywordDate(date, arr);
				request.getSession().  setAttribute("Director", myar);
				System.out.println("Do GET NewsSearch   keyword:  MULTI :: "+ myar.size()  );	
		} catch (Exception e) {
			System.out.println("Do GET NewsSearch  NewsJSP errpr get News  :" + e);
		}
		
	}

	
	private void setDataMonth(HttpServletRequest request, int date) {
		ArrayList<NewsAccess> myar;

		try (DAOFactoryNews fac = new DAOFactoryNews()) {
			for (String keywd : keywords) {

				myar = fac.searchNewsKeywordMonth(date, keywd);
				//System.out.println("Do GET NewsSearch   keyword:" + keywd+" :: "+ myar.size()  );
				request.getSession().  setAttribute(keywd, myar);
			}
			setDirector( request, date);
		} catch (Exception e) {
			System.out.println("Do GET NewsSearch  NewsJSP errpr get News  :" + e);
		}
		request. setAttribute("info", "for month :"+date);
	} 
	
	private void setCusomDate(HttpServletRequest request, String customdate) {
		ArrayList<NewsAccess> myar;

		try (DAOFactoryNews fac = new DAOFactoryNews()) {
			for (String keywd : keywords) {

				myar = fac.searchNewsKeywordCustomDate(customdate, keywd);
				request.setAttribute(keywd, myar);

			}
		} catch (Exception e) {
			System.out.println("Do GET NewsSearch  NewsJSP errpr get News  :" + e);
		}

	}
	
	  
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Do GET NewsSearch");
		String nextJSP = "/NewsSearch.jsp";
		
		setData(request, LocalDate.now().toString());
		//setDataMonth(request,FormatUtil.convertStringToDate("2017-03-01").getMonthValue() );
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);

	}
/**
 * Use two pages .
 * 1. List news
 * 2. User can edit news from OK to YES.	
 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Do Post NewsSearch");
		String MyModeDate = request.getParameter("MyModeDate");
		String CustomDate = request.getParameter("CustomDate");
		String monthly = request.getParameter("monthly");
		System.out.println("MyModeDate: " + MyModeDate);

		System.out.println("Do POST ASXJsp CustomDate :" + CustomDate);

		if (MyModeDate != null) {
			if(monthly == null) setData(request, MyModeDate);
			else setDataMonth(request,FormatUtil.convertStringToDate(MyModeDate).getMonthValue() );

		} else if (monthly != null) {

		

		} else if (CustomDate != null) {
			setCusomDate(request, CustomDate);
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/NewsSearch.jsp");
		dispatcher.forward(request, response);
	}
	
	
}


