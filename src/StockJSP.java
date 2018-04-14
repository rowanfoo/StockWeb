
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import access.MovingAverageAccess;
import access.MyNotesAccess;
import access.StockAccess;
import factory.DAOFactoryCategory;
import factory.DAOFactoryMovingAverage;
import factory.DAOFactoryMyNotes;
import factory.DAOFactoryStock;

public class StockJSP  extends HttpServlet{
	int mycount =0;
	
	ArrayList <String> category;
	public void init() throws ServletException	  {
		  
	  }
	
	
	
	
	/**
	 * direct to 3 pages, 
	 * 1. Input page , which then directs 
	 * 	2. Technical page
	 *  3. Fundamental page.
	 */
	
	public void doGet(HttpServletRequest request,
	          HttpServletResponse response)
	  throws ServletException, IOException
		{
			System.out.println("Do GET StockJSP 1.1");
			
			String jsp="";
			String nextJSP = "/StockJSP.jsp";
			String nextJSP2 = "/StockEditJSP.jsp";
			String nextJSP3 = "/StockEditFundJSP.jsp";
			Hashtable  <String ,StockAccess>  arr  =  (Hashtable  <String ,StockAccess>)request.getSession().getAttribute("Stock");
			//request.setAttribute("CODE", code);
			//Integer d = new Integer(  mycount);
			 //request.setAttribute("INDEX",new Integer(  mycount));

			 //request.setAttribute("TechStr",arr);
			
			 //mycount++;
			 
			 //int index = ((Integer) request.getAttribute("TechStr")).intValue();
			 //TechStrAccess obj = arr.get(mycount);
			 try(DAOFactoryStock dao = new DAOFactoryStock()) {
				
				if( arr == null) arr=dao.getAllHash();
				
				   
				 request.getSession().setAttribute("Stock",arr);
					
				} catch (Exception e) {	
					System.out.println("StockJSP doGet ERROR :"+e); 
					throw new ServletException ("ERROR  StockJSP getAllHash :"+e);
				}
			 
			 try(DAOFactoryCategory dao = new DAOFactoryCategory()) {
					
					if( category == null) category=dao.getAllCategory();
						
					 request.setAttribute("category",category);
					 System.out.println("StockJSP doGet CATT :"+category.size()); 
						
				} catch (Exception e) {	
						System.out.println("StockJSP doGet ERROR :"+e); 
						throw new ServletException ("ERROR  StockJSP getAllCategory :"+e);
				}
			
		
			 
			 
			 
			 
			 if(request.getAttribute("CODE")==null){
				 jsp=nextJSP;
			 }else{
				 if(request.getAttribute("TYPE-PAGE").equals("1")   ){// technical page
					 jsp=nextJSP2;
				 }else if (request.getAttribute("TYPE-PAGE").equals("2")   ){// fundamental page
					 jsp=nextJSP3; 
					 try(DAOFactoryMyNotes daon = new DAOFactoryMyNotes()) {
						 StockAccess obj=(StockAccess) request.getAttribute("CODE");
						 String code = obj.getCode();
						 ArrayList<MyNotesAccess>  notes =daon.getAllNotesbyCode(code);
						 
						 StringBuffer buf = new StringBuffer();
						 for( MyNotesAccess note: notes    ){
							 String date="date: "+note.getDate()+"\n";
							 String data=note.getNotes()+"\n \n ";
							 buf.append(date+data);
							 
							 
						 }
						 request.setAttribute("NOTES",buf.toString());
						 System.out.println("StockJSP NOTES:"+buf.toString() ); 
								
					} catch (Exception e) {	
								System.out.println("StockJSP doGet  NOTES ERROR :"+e); 
								throw new ServletException ("ERROR  StockJSP getNotes :"+e);
					}
					
					
					 
					 
					 
				 }else{
					 try(DAOFactoryStock dao = new DAOFactoryStock()) {// summary page
						 System.out.println("StockJSP doGet  Find SUmmary :"); 
						 StockAccess obj=(StockAccess) request.getAttribute("CODE");
						 StockAccess find=null;
						 String code = obj.getCode();
						 for(int x=0;x<5;x++){
							 
							 LocalDate yesterday = LocalDate.now().minusDays(x);
							 find = dao.getStockData(yesterday.toString(),code );
							 if(find!=null) {
								 request.setAttribute("CODE",find );
								 break;
							 }
						 }
						 try(DAOFactoryMovingAverage avg = new DAOFactoryMovingAverage()) {
							 MovingAverageAccess move =  avg.getStockMovingAverage(code);		
							 request.setAttribute("MovingAverage",move);
							 
						 } catch (Exception e) {
									System.out.println("StockJSP doGet  getStockData ERROR :"+e); 
									throw new ServletException ("ERROR  StockJSP getStockData  :"+e);
						  }
						 
						
						 
						 jsp="/StockSummary.jsp";
						 
					//	 
						 
					} catch (Exception e) {
						System.out.println("StockJSP doGet  getStockData ERROR :"+e); 
						throw new ServletException ("ERROR  StockJSP getStockData  :"+e);
					}
					 
					 
				 }
				 
				 
				 
				
			 }
			 
			  
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
				dispatcher.forward(request,response);
		
			
			
	}
	
	public double cleanDoubleString(String value){
		if(value!=null){
			String price = value.trim();
			if(value.equals(""))return 0;
			else return Double.parseDouble(value)		;
		}	
		return 0;
	}
	
	public void doPost(HttpServletRequest request,
	          HttpServletResponse response)
	  throws ServletException, IOException
		{
		
		/*
			System.out.println("StockJSP DoPost ");
			
			if(request.getParameter("INDEX")==null){
				System.out.println("ModeJSP INITIALIZE ");
				doGet( request, response);
				return;
			}
			System.out.println("StockJSP ENTER ");
			
			
			String index = request.getParameter("INDEX").trim();
			String precomment = request.getParameter("PRECOMMENT");
			
			String yes = request.getParameter("Yes");
			String no = request.getParameter("No");
			System.out.println("Add record start : "+yes);
			System.out.println("Add record start : INDEX:"+index+":");
			
			 System.out.println("StockJSP INDEX DOGET OBJ:"+arr.get(Integer.parseInt(index) ) );
			
			 */
		System.out.println("StockJSP doPost 1");
		Hashtable  <String ,StockAccess>  arr  =  (Hashtable  <String ,StockAccess>)request.getSession().getAttribute("Stock");
		 try(DAOFactoryStock dao = new DAOFactoryStock()) {// got to load this if someone call doPost directly like Look.jsp
				
				if( arr == null) arr=dao.getAllHash();
				
				   
				request.getSession().setAttribute("Stock",arr);
					
				} catch (Exception e) {	
					System.out.println("StockJSP doGet ERROR :"+e); 
					throw new ServletException ("ERROR  StockJSP getAllHash :"+e);
				}
		
		/**
		 * two function , one user click get specific stock base on code
		 * while other is when user click save ....
		 */
		String back = request.getParameter("BACK");
		String code = request.getParameter("CODE");		
		String yes = request.getParameter("Yes");//value when i submit // 2 pages  either FUND or TECH.
		String note1 = request.getParameter("Note1");
		String Note2 = request.getParameter("Note2");
		String TechNotes = request.getParameter("TechNotes");
		String Trend = request.getParameter("Trend");
		String MonthlyNotes = request.getParameter("MonthlyNotes");
		String WeeklyNotes = request.getParameter("WeeklyNotes");
		String DailyNotes = request.getParameter("DailyNotes");
		String NormandyNotes = request.getParameter("NormandyNotes");
		String NormandyPrice  = request.getParameter("NormandyPrice ");
	
		String WhenBuyNotes = request.getParameter("WhenBuyNotes");
		String WhenBuyPrice = request.getParameter("WhenBuyPrice");
		String StopLossNotes = request.getParameter("StopLossNotes");
		String StopLossPrice = request.getParameter("StopLossPrice");
		String KeySupportNotes = request.getParameter("KeySupportNotes");
		String KeySupportPrice = request.getParameter("KeySupportPrice");
		
		String DefendKeyPrice = request.getParameter("DefendKeyPrice");
		String DefendKeyNotes = request.getParameter("DefendKeyNotes");
		String Nope = request.getParameter("Nope");
		String Chart = request.getParameter("Chart");
		String wishList = request.getParameter("wishList");
		
		String AlertPrice = request.getParameter("AlertPrice");
		String stageGrowth = request.getParameter("stageGrowth");
		
		
		
		System.out.println("StockJSP doPost 1.1");
		
		
		
		
		String Descp = request.getParameter("Descp");
		String Category = request.getParameter("Category");
		String Reason = request.getParameter("Reason");
		String Moat = request.getParameter("Moat");
		String FundNotes  = request.getParameter("FundNotes ");
		String EasyChange = request.getParameter("EasyChange");
		String FYdate = request.getParameter("FYdate");
		String Formcode = request.getParameter("formcode");
			
		String News = request.getParameter("News");
		String research = request.getParameter("research");
		String ResearchCat = request.getParameter("ResearchCat");
		

		
		String OneNote = request.getParameter("OneNote");	
	 
		   
		  
		

		
		
		
		
		if(yes != null){
			//Go to save...
			
			System.out.println("StockJSP doPost SAVE 2");	
			//StockAccess obj =(StockAccess)request.getAttribute("StockObj");
			StockAccess obj =arr.get(Formcode.trim());
			
			
	
			
			try(DAOFactoryStock dao = new DAOFactoryStock()) {
			
				if(wishList!= null)obj.setWishlist("Y");
				else obj.setWishlist("");
				
				if(research!= null)obj.setResearch("Y");
				else obj.setResearch("");
				
				
				
				if(yes.trim().equals("Tech")){
				
					System.out.println("StockJSP doPost SAVE 3");	
					
					obj.setNotes1(note1);
					obj.setNotes2(Note2);
					obj.setTechnicalNotes(TechNotes);
					obj.setTrend(Trend);
					obj.setMontlyNotes(MonthlyNotes);
					obj.setWeeklyNotes(WeeklyNotes);
					obj.setDailyNotes(DailyNotes);
					obj.setNormandyNotes(NormandyNotes);
					obj.setNormandyPt(cleanDoubleString(NormandyPrice));
					obj.setWhenBuy(WhenBuyNotes);
					obj.setWhenBuyPrice(cleanDoubleString(WhenBuyPrice));
					obj.setStopLossNotes(StopLossNotes);
					obj.setStopLoss(cleanDoubleString(WhenBuyPrice));
					obj.setKeySupportPriceNotes(KeySupportNotes);
					obj.setKeySupportPrice(cleanDoubleString(KeySupportPrice));
					obj.setDefendKeyNotes(DefendKeyNotes);
					obj.setDefendKeyPrice(cleanDoubleString(DefendKeyPrice)  );
					obj.setAlertPrice(cleanDoubleString(AlertPrice));
					obj.setNope(Nope);
					obj.setChart(Chart);
					obj.setStageGrowth(stageGrowth);
					obj.setOneNotes(OneNote);
									
					dao.updateStockTechnical(obj);
					
					
				
				}
				else{
					System.out.println("StockJSP doPost UDDATE ");	
					System.out.println("StockJSP doPost UDDATE wishlist: "+wishList);	
					
					obj.setDescp(Descp);
					obj.setCategory(Category);
					obj.setReason(Reason);
					obj.setMoat(Moat);
					obj.setFundNotes(FundNotes);
					obj.setEasyChange(EasyChange);
					obj.setFYdate(FYdate);
					obj.setWishlist(wishList);
					obj.setNews(News);
					obj.setResearchCat(ResearchCat);
					dao.updateStockFundamental(obj);
				
				
				
				}
			
			}
			catch(Exception e){
				System.out.println("StockJSP CANNOT UPDATE ERROR :"+e);
				throw new ServletException("StockJSP CANNOT UPDATE ERROR :");
			}
			
			
		
		
		}
		
		
		if(back !=null || yes!= null|| code==null ){// go back to finding page
			request.setAttribute("CODE",null);
		}else{
			if(code.lastIndexOf(".AX")<0)code=code.trim().toUpperCase()+".AX";//this is when user just type in himself 
			System.out.println("StockJSP CODE REAL :"+code+"::");
			System.out.println("StockJSP CODE REAL  TYPE Page:"+code+"::"+ request.getParameter("combo1"));
			request.setAttribute("TYPE-PAGE",  request.getParameter("combo1").trim());
		
			//StockAccess acc =arr.get(code.trim()) ;
			
//			request.setAttribute("CODE",arr.get(code.trim())   );// go load stockEdit page.
			request.setAttribute("CODE",arr.get(code )   );// go load stockEdit page.

		}

			 
		doGet( request, response);
		
		  
		
		
		}
	
	
}
