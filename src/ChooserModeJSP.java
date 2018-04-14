

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import access.StockAccess;
import access.TechStrAccess;
import factory.DAOFactoryStock;
import factory.DAOFactoryTechStr;

public class ChooserModeJSP  extends HttpServlet{ 
	

	
	HashMap <String ,StockAccess>    wishlist;
	 //String date;
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
		ArrayList <TechStrAccess>  arr;
		 System.out.println("DO doGet   :ChooserModeJSP 1");
		 String nextJSP = "/ChooserModeJSP.jsp";
			
			
		 	String date  = (String)request.getAttribute("MyModeDate");
			 String TOP = (String)request.getAttribute("TOP");
			 if(date==null){

					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					 date=dateFormat.format( new Date());	
						 
			 }
			    
			
			 try(DAOFactoryStock dao = new DAOFactoryStock()) {
				
				 if(wishlist ==null){				
					 wishlist  =dao.getAllStockWishList();
					 
					
					 request.getSession().setAttribute("WishList",wishlist);
				 }
				 if(request.getSession().getAttribute("WishList")==null){				
					 request.getSession().setAttribute("WishList",wishlist);
				 }
				 System.out.println("ChooserModeJSP doGet WishList : "+ wishlist.size() ); 
				 
			 }catch(Exception e){
				 System.out.println("ChooserModeJSP doGet wishlist : "+e); 
			 }
    		     
				try(DAOFactoryTechStr dao = new DAOFactoryTechStr()) {
					
						System.out.println("ChooserModeJSP doGet MyModeDate :"+date); 
				
					
					//ArrayList <TechStrAccess>  arr = dao.getTechStrList(null,"2016-10-25");
					// this is load when user load the page from doGet
				//	arr = dao.getTechStrList(null,date);
					//arr = dao.getTechStrList(null,"2016-10-25");
					//for(TechStrAccess tech :  dao.getTechStrList(null,"2016-10-25")){
						//System.out.println(tech);
				///	}
					
					System.out.println("TOP :"+TOP);
					System.out.println("ChooserModeJSP doGet MyModeDate  v3:"); 
					if(TOP == null || TOP.equals("Top 100-300")  ){//loaded from doPost
						arr = dao.getTechStrListByTop300ByDate("Top 100-300",date); // always default and show the top 300.
						//arr = dao.getTechStrListByTop300ByDate("Top 100-300","2017-02-13"); // always default and show the top 300.
						
						
						request.setAttribute("TOP",""  );
						System.out.println("ChooserModeJSP doGet TOP100 - 300:"); 
					}
					else if(TOP.equals("Monthly")){
						//arr = dao.getTechStrListByTop300ByDate("Top Others",date);
						LocalDate mydate = LocalDate.parse(date);
						
						arr = dao.getTechStrListByMonthMode(mydate.getMonthValue());
						System.out.println("ChooserModeJSP doGet MONTHLY"); 
						
						
						
						request.setAttribute("TOP","Monthly"  );
					}else{
						System.out.println("ChooserModeJSP doGet OTHERS "); 
						
						arr = dao.getTechStrListByTop300ByDate("Top Others",date);
						request.setAttribute("TOP","Top Others"  );
						
					}
				
					
						 
					 
					request.getSession().setAttribute("TechStr",arr);
					System.out.println("ChooserModeJSP doGET START ARR:"+arr.size());
					Hashtable<String,ArrayList<String>>  tb= new Hashtable<String,ArrayList<String>>  ();
					
					for(TechStrAccess obj:arr){
						int mode=obj.getMode();
						if(tb.get("mode "+mode) == null  )tb.put("mode "+mode, new ArrayList<String>());
						
						 tb.get("mode "+mode). add("code="+obj.getPureCode()+"&"   )          ;
						
					}
					request.getSession().setAttribute("TechStrTable",tb);
			
					 
					System.out.println("ChooserModeJSP doGET  FINISH");
					
				} catch (Exception e) {
					System.out.println("ChooserModeJSP ERROR :"+e);  
				}
						 	  
				System.out.println("ChooserModeJSP doGET  DISPATCH NOW ");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
				dispatcher.forward(request,response);
				
				
				
			
			
			
			
		
		
		
		
		}





	//int mycount =0;
	
	

public void doPost(HttpServletRequest request,
          HttpServletResponse response)
  throws ServletException, IOException
	{
	 System.out.println("DO doPost   :ChooserModeJSP  v2");
	
			
			String refresh = request.getParameter("autoRefresh");
			 
			  String TOP = request.getParameter("TOP"); 
				 System.out.println("ChooserModeJSP DO Post TOP :"+ TOP);

			 if (refresh != null )request.getSession().setAttribute("refresh","Y");
	
		
			
			 
				String date  = request.getParameter("MyModeDate");
				 if(date==null){

						DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						 date=dateFormat.format( new Date());	
							 
				 }
				    
				
				 System.out.println("ChooserModeJSP DO Post Chooser  INDEX XX :"+ request.getParameter("combo1") );
//					 System.out.println("ChooserModeJSP DO Post Chooser  INDEX XX :"+ Integer.parseInt( request.getParameter("combo1").trim()));
					
				
				
			if(!request.getParameter("combo1").equals("") ){// user has selected this section
				int  index = Integer.parseInt( request.getParameter("combo1").trim());
				 System.out.println("ChooserModeJSP DO Post Chooser  INDEX:"+ index);
				 System.out.println("ChooserModeJSP DO Post Chooser  date:"+ date);
			
				 ArrayList <TechStrAccess>  myarr =null;
				try(DAOFactoryTechStr dao = new DAOFactoryTechStr()) {
					
					//ArrayList <TechStrAccess>  myarr = dao.getTechStrList(null,date);
					// System.out.println("DO Post find **** :"+dao.getTechStrList(null,date,index));  
					//ArrayList <TechStrAccess>  myarr = dao.getTechStrList(null,"2016-10-25",index);
					 
					 if(index < 10) myarr = dao.getTechStrList(null,date,index); // get date and mode
					 else myarr = dao.getTechStrList(null,date);// get all for today.
//					 
//					 TechStrAccess test=null;
//					 
//					 if(test.getMode()==28){
//						 
//					 }
			
					 
					 request.getSession().setAttribute("TechStr",myarr);
	
					//request.getSession().setAttribute("TechStr",arr);
					System.out.println("ModeJSP doGET START ARR:"+myarr);
					System.out.println("-------------------------------------:");
					System.out.println("ModeJSP doGET START ARR:"+myarr.size());
					System.out.println("ModeJSP doGET  FINISH");
					
				} catch (Exception e) {	System.out.println("ModeJSP doGet ERROR :"+e);  }
			
				if(myarr.size()==0 ){// if no result found 
					doGet(request,response);
				}else{
					//request.setAttribute("INDEX",new Integer(index)  );
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ModeJSP");
					dispatcher.forward(request,response);	
				}
				
				
				  
				
				
			
			}else{
				System.out.println("DO doPost1   :got Date");
				request.setAttribute("MyModeDate",date  );
				request.setAttribute("TOP",TOP  );
				doGet(request,response);
			
			}
			 
			 
	
			
			
			
			
	
			
			
	
	
	}

}
