
import java.io.IOException;
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

public class NewsListJSP  extends HttpServlet{
	private String message;
	
	  
	
		
	  public void init() throws ServletException	  {
		  System.out.println("i am init");
		 
			try{
			
			}catch(Exception e){
				  System.out.println("Error ININT :"+e);
			}
		    
		  
		  
	  }
	 
	private void makeCharts(HttpServletRequest request){
		 ArrayList <NewsAccess> myarr = ( ArrayList <NewsAccess>)request.getSession().getAttribute("ASXNEWSLIST");
		 HashMap set = new HashMap();
		 String param="";
		 String mycode="code=";
		 for(NewsAccess news:myarr){
			 
			 if(!set.containsKey(news.getCode() )  ){
				 set.put(news.getCode() , "");
				 param=param+mycode+news.getCode()+"&";
			 }
		 
		 
		 }
		 
		 request.setAttribute("LINK",param);
		 
	}
	  
	  
	  
	public void doGet(HttpServletRequest request,
          HttpServletResponse response)
  throws ServletException, IOException
	{
		System.out.println("Do GET NewsListJSP");
		String nextJSP = "/NewsListJSP.jsp";
		

		 ArrayList <NewsAccess> myarr;
		
		 myarr = (ArrayList <NewsAccess> ) request.getSession().getAttribute("ASXNEWSLIST");
		 
		 
		try(DAOFactoryNews fac =  new DAOFactoryNews()) {
			if(myarr == null){
				myarr= fac.getAsxNewsByWishListAndDate( FormatUtil.getTodayDateToString() );
				
				//myarr= fac.getAsxNewsByOkAndDate("2016-11-28");
				
				
				request.setAttribute("NEWSTYPE","wishlist");

				if(myarr.size()==0 ){
					myarr = fac.getAsxNewsByDate(FormatUtil.getTodayDateToString() );
					request.setAttribute("NEWSTYPE", "news");
				}
				
				
				request.getSession().setAttribute("TOTAL",new Integer( myarr.size()));
				request.getSession().setAttribute("ASXNEWSLIST",myarr);
				
				
				
			}
		
			
			
			
		} catch (Exception e) {
			System.out.println("Do GET NewsListJSP  NewsJSP errpr get News  :"+e);
		}
		if(request.getParameter("index")!=null){
			
			String index = request.getParameter("index");
			NewsAccess obj= myarr.get(Integer.parseInt( index   ));
			request.setAttribute("ASXNEWSITEM",obj);
			request.setAttribute("INDEX",index);
			double percent = (double)Integer.parseInt(index)/myarr.size();
			request.setAttribute("PERCENT",percent);
			
			nextJSP = "/NewsEditJSP.jsp";
		}
		
		makeCharts( request);
		System.out.println("Do GET NewsListJSP DONE");
		
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			dispatcher.forward(request,response);
			
		
		
}
/**
 * Use two pages .
 * 1. List news
 * 2. User can edit news from OK to YES.	
 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Do Post NewsListJSP");
		String index = request.getParameter("INDEX");
		String code = request.getParameter("CODE");
		String precomment = request.getParameter("YESCOMMENT");
		String MyModeDate = request.getParameter("MyModeDate");
		String NEWSTYPE = request.getParameter("NEWSTYPE");
		String monthly = request.getParameter("monthly");

		String yes = request.getParameter("Yes");
		String no = request.getParameter("No");
		// System.out.println("Code to flag with NO: "+mycode);
		// System.out.println("Code to flag with yes: "+yes);
		// System.out.println("Code to flag with no: "+no);

		// System.out.println("code: "+code);
		// System.out.println("precomment: "+precomment);
		System.out.println("index: " + index);

		System.out.println("Do POST ASXJsp MyModeDate :" + MyModeDate);
		ArrayList<NewsAccess> myarr = (ArrayList<NewsAccess>) request.getSession().getAttribute("ASXNEWSLIST");
		// this is when user edit news and set from OK to YES....
		if (index != null) {
			try (DAOFactoryNews fac = new DAOFactoryNews()) {

				int myindex = Integer.parseInt(index);
				NewsAccess news = myarr.get(myindex);

				news.setYesNotes(precomment);
				if (yes != null)
					news.setYes("Y");
				news.setSeen("Y");

				fac.updateNews(news);

				if (!((myindex + 1) > (myarr.size() - 1)))
					myindex = myindex + 1;
				response.sendRedirect("/NewsListJSP?index=" + myindex);

			} catch (Exception e) {
				System.out.println("Failed adding record : " + e);
				throw new ServletException("ünable to add record");
			}

		} else {

			try (DAOFactoryNews fac = new DAOFactoryNews()) {

				// myarr= fac.getAsxNewsByDate(new Date());
				if (NEWSTYPE.trim().equals("Intrested")) {
					if (monthly == null)
						myarr = fac.getAsxNewsByOkAndDate(MyModeDate);
					else
						myarr = fac.getAsxNewsByOkAndMonth(MyModeDate);
				} else if (NEWSTYPE.trim().equals("Yes")) {
					if (monthly == null)
						myarr = fac.getAsxNewsByYesAndDate(MyModeDate);
					else
						myarr = fac.getAsxNewsByYesAndMonth(MyModeDate);

				} else if (NEWSTYPE.trim().equals("wishlist")) {
					if (monthly == null)
						myarr = fac.getAsxNewsByWishListAndDate(MyModeDate);
					else
						myarr = fac.getAsxNewsByWishListAndMonth(MyModeDate);
				} else if (NEWSTYPE.trim().equals("news"))
					myarr = fac.getAsxNewsByDate(MyModeDate);

				request.setAttribute("NEWSTYPE", NEWSTYPE);

				request.getSession().setAttribute("ASXNEWSLIST", myarr);

			} catch (Exception e) {
				System.out.println("Do POST NewsListJSP  NewsJSP errpr get News  :" + e);
				request.setAttribute("error", e.getMessage());
			}
			doGet(request, response);

		}

	}

	
	
	
}


