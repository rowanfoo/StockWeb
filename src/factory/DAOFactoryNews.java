

package factory;

import java.sql.Connection;
import java.time.LocalDate;

import dao.Database;
import dao.NewsDAO;
import util.ExcelLogger;
import util.FormatUtil;

import java.sql.Connection;
import java.util.logging.Logger;

import access.NewsAccess;
import access.StockAccess;
import access.TechStrAccess;

import dao.StockDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

public class DAOFactoryNews extends DAOFactoryBase{


	
	NewsDAO dao=null;   
	
	public DAOFactoryNews(){

		try {
		
			 dao= new NewsDAO(con);
		} catch (Exception e) {
			System.out.println("Error initialize DAOFactoryNews "+e);
			 logger.severe("DAOFactoryNews Error initialize:"+e);	 
			
		}
	}


	
	
	public ArrayList <NewsAccess>   getAsxNewsByWishListAndDate(String  date)throws Exception {
		
		return dao.getAsxNewsByWishListAndDate( date    );
	}
	public ArrayList <NewsAccess>   getAsxNewsByWishListAndMonth(String  date)throws Exception{
		return dao.getAsxNewsByWishListAndMonth(  LocalDate.parse(date)       );
	}
	
	public ArrayList <NewsAccess>   getAsxNewsByYesAndDate(String  date)throws Exception {
		
		return dao.getAsxNewsByYesAndDate( date    );
	}
	public ArrayList <NewsAccess>   searchNewsKeywordDate(String date , String keyword)throws Exception{
		return dao.searchNewsKeywordDate(  date ,  keyword    );
	}
	
	public ArrayList <NewsAccess>   searchNewsKeywordMonth(int month, String keyword)throws Exception{
		return dao.searchNewsKeywordMonth(  month ,  keyword    );
	}
	public ArrayList <NewsAccess>   searchNewsKeywordMonth(int month, ArrayList <String> keywords)throws Exception{
		return dao.searchNewsKeywordMonth(  month ,  keywords   );
	}
	
	
	public ArrayList <NewsAccess>   searchNewsKeywordDate(String date, ArrayList <String>  keyword)throws Exception{
		return dao.searchNewsKeywordDate(  date ,  keyword   );
	}
	
	public ArrayList <NewsAccess>   searchNewsKeywordCustomDate(String date , String keyword)throws Exception{
		return dao.searchNewsKeywordCustomDate(  date ,  keyword    );
		
	}
	
	public ArrayList <NewsAccess>   getAsxNewsByYesAndMonth(String date)throws Exception {
		return dao.getAsxNewsByYesAndMonth(  LocalDate.parse(date)     );
	}
	
	public ArrayList <NewsAccess>   getAsxNewsByDate(Date date)throws Exception {
		
			return dao.getAsxNewsByDate( FormatUtil.convertDateToString(date)    );
	}
	
	public ArrayList <NewsAccess>   getAsxNewsByDate(String date)throws Exception {
		
			return dao.getAsxNewsByDate( date    );
	}	

	
	public ArrayList <NewsAccess>   getAsxNewsByOkAndDate(Date date)throws Exception {
		
			return dao.getAsxNewsByOkAndDate( FormatUtil.convertDateToString(date)    );
	}
	
	public ArrayList <NewsAccess>   getAsxNewsByOkAndDate(String  date)throws Exception {
		
		return dao.getAsxNewsByOkAndDate( date    );
}

public ArrayList <NewsAccess>   getAsxNewsByOkAndMonth(String  date)throws Exception {
		
		return dao.getAsxNewsByOkAndMonth( LocalDate.parse(date)    );
	}
	
	public ArrayList <NewsAccess>   getAsxNewsUniqueByDate(Date date)throws Exception {
	//	ArrayList <TechStrAccess> arr = new ArrayList();
		
			return dao.getAsxNewsUniqueByDate( FormatUtil.convertDateToString(date)    );
	}
	public ArrayList <NewsAccess>   getAsxNewsUniqueByDate(String  date)throws Exception {
	//	ArrayList <TechStrAccess> arr = new ArrayList();
		
			return dao.getAsxNewsUniqueByDate( date    );
	}

	
	public void  updateNewsSeen(NewsAccess obj)throws Exception {
		try {
			dao.updateNewsSeen(obj);
			con.commit();
			System.out.println("  DAOFactoryStock DAOFactoryNews : OK !!");

		} catch (Exception e) {

			try {
				con.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			System.out.println("ERROR  DAOFactoryNews updateNewsSeen :" + e);
			throw new Exception("ERROR  DAOFactoryNews updateNewsSeen :" + e);

		}
		
	}
	
	
	
	public void  updateNews(NewsAccess obj)throws Exception {
		try {
			dao.updateNews(obj);
			con.commit();
			System.out.println("  DAOFactoryStock DAOFactoryNews : OK !!");

		} catch (Exception e) {

			try {
				con.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			System.out.println("ERROR  DAOFactoryNews updateNewsSeen :" + e);
			throw new Exception("ERROR  DAOFactoryNews updateNewsSeen :" + e);

		}
		
	}
	

	public void  insertNewNews(ArrayList<NewsAccess> arr)throws Exception {
		try {
			dao.insertNewNews(arr);
			con.commit();
			System.out.println("  DAOFactoryStock insertNewNews : OK !!");

		} catch (Exception e) {

			try {
				con.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			System.out.println("ERROR  DAOFactoryNews insertNewNews :" + e);
			throw new Exception("ERROR  DAOFactoryNews insertNewNews :" + e);

		}
		
	}
		
	
	public void  updateStockFundamental(StockAccess obj)throws Exception {
		try {
		//	dao.updateStockFundamental(obj);
			con.commit();
			System.out.println("  DAOFactoryNews updateStockFundamental : OK !!");  
		
		} catch (Exception e) {
			
			
			try {
				con.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			System.out.println("ERROR  DAOFactoryNews updateStockFundamental :"+e);  
			throw new Exception ("ERROR  DAOFactoryNews updateStockFundamental :"+e);	
		
		}
	
		
		
	}
	

	
	public void updateStockCategory(StockAccess obj) throws Exception {
		try {
			dao.updateStockCategory(obj);
			con.commit();
			System.out.println("  DAOFactoryNews updateStockFundamental : OK !!");

		} catch (Exception e) {
			try {
				con.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			System.out.println("ERROR  DAOFactoryNews updateStockFundamental :" + e);
			throw new Exception("ERROR  DAOFactoryNews updateStockFundamental :" + e);

		}

	}

	public void updateStockSubCategory(StockAccess obj) throws Exception {
		try {
			dao.updateStockSubCategory(obj);
			con.commit();
			System.out.println("  DAOFactoryNews updateStockFundamental : OK !!");

		} catch (Exception e) {
			try {
				con.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			System.out.println("ERROR  DAOFactoryNews updateStockFundamental :" + e);
			throw new Exception("ERROR  DAOFactoryNews updateStockFundamental :" + e);

		}

	}

	public void deleteTodayDate() throws Exception {

		try {
			dao.deleteTodayDate();
			con.commit();

		} catch (Exception e) {

			try {
				con.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			System.out.println("ERROR  DAOFactoryNews deleteTodayDate :" + e);
			throw new Exception("ERROR  DAOFactoryNews deleteTodayDate :" + e);

		}

	}
	
public static void main(String[] args) {

		
	try(DAOFactoryStock dao = new DAOFactoryStock()) {
		
		
	//	StockAccess obj = dao.getCode("wsa.ax");
		//		System.out.println("DAOFactoryStock :"+obj);
		
		/*
		//ArrayList <TechStrAccess>  arr = dao.getTechStrList("","2016-10-26");
		for(TechStrAccess obj :  dao.getCode("wsa.ax")){
			//System.out.println(tech);
		String code = obj.getCode();	
		
		System.out.println("code:"+code);
		//System.out.println("code chg :"+code.replaceAll("^.AX", ""));
		System.out.println("code chg :"+code.substring(0, code.lastIndexOf(".")) );
		
			

		}
		*/
				Hashtable<String,String> tb =new Hashtable();
				tb.put("a.ax", "hi");
				tb.put("b.ax", "how");
				tb.put("c.ax", "are");
				tb.put("d.ax", "you");
				for(String s:tb.keySet()   ){
					System.out.println("<option value=\" "+s+"\"> ");

										
									
					}

				
				
				
				
				
		System.out.println("DAOFactoryNews FINISH");
		
	} catch (Exception e) {
		System.out.println("ERROR :"+e);  
	}
			 
			   
		    
		    
		  
		  
		    
	
		        	
		        	
		        	
		        	
		   
		    
	

	
		
		
		  }
	
	
	

}

