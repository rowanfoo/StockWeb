
package factory;

import java.sql.Connection;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;

import dao.Database;
import util.ExcelLogger;


import java.sql.Connection;
import java.util.logging.Logger;

import access.StockAccess;
import access.TechStrAccess;

import dao.StockDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Locale;
import java.time.temporal.WeekFields;
import java.time.temporal.Temporal;;

public class DAOFactoryStock extends DAOFactoryBase{


	
	StockDAO dao=null;   
	
	public DAOFactoryStock(){

		try {
		
			 dao= new StockDAO(con);
		} catch (Exception e) {
			System.out.println("Error initialize DAOFactoryStock "+e);
			 logger.severe("DAOFactoryStock Error initialize:"+e);	 
			
		}
	}

	public ArrayList <StockAccess>   getAllList()throws Exception {
	//	ArrayList <TechStrAccess> arr = new ArrayList();
		
			return (ArrayList) dao.getAllStock();
	}
	
	public HashMap <String ,StockAccess>   getAllStockWishList()throws Exception{
		return dao.getAllStockWishList();
	}
	
	
	public ArrayList <StockAccess>   getAllStockDataList(String date)throws Exception {

		return (ArrayList) dao.getAllStockData(date);
	}
	public ArrayList<StockAccess> getStockIndex() throws Exception {
		return dao.getStockIndex();
	}
	
	public Hashtable  <String ,StockAccess>    getAllHash()throws Exception {
		
			
				return (Hashtable <String ,StockAccess> ) dao.getAllStockHash();
		}
		
	
	/**
	 * return an array of stock base on index -- top300, top30,....
	 * @param cat
	 * @return
	 * @throws Exception
	 */
	public ArrayList <StockAccess>   getStockIndex(String cat)throws Exception {
			return (ArrayList) dao.getStockIndex(cat);
	}
	 
	public   StockAccess getStockData(String date,String code)throws Exception {
		return dao.getStockData(date,code);
	}

	

	public   StockAccess getCode(String code)throws Exception {
		
			
				return dao.getStockCode(code);
		}
		
	
	
	public    ArrayList <StockAccess>  getStockCategory(String category,String date)throws Exception {
		if(category.trim().equalsIgnoreCase("wishlist")  )return dao. geStockWishList( date);
		else return dao.getStockCategory(category,date);
	}


	
	public void  updateStockTechnical(StockAccess obj)throws Exception {
		try {
			dao.updateStockTechnical(obj);
			con.commit();
			System.out.println("  DAOFactoryStock updateStockTechnical : OK !!");  
		
		} catch (Exception e) {
			
			
			try {
				con.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			System.out.println("ERROR  DAOFactoryStock updateStockTechnical :"+e);  
			throw new Exception ("ERROR  DAOFactoryStock updateStockTechnical :"+e);	
		
		}
		/*
		finally {
			try {
				System.out.println("AM I EVER CLOSE :");  

				con.close();
			} catch (Exception e2) {
				System.out.println("ERROR  DAOFactoryTechStr Cannot Close :"+e2);  
			}
				
		}*/
		
		
		
		
	}
	
	
	
	public void  updateStockFundamental(StockAccess obj)throws Exception {
		try {
			dao.updateStockFundamental(obj);
			con.commit();
			System.out.println("  DAOFactoryStock updateStockFundamental : OK !!");  
		
		} catch (Exception e) {
			
			
			try {
				con.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			System.out.println("ERROR  DAOFactoryStock updateStockFundamental :"+e);  
			throw new Exception ("ERROR  DAOFactoryStock updateStockFundamental :"+e);	
		
		}
	
		
		
	}
	

	
	
		public void  updateStockCategory(StockAccess obj)throws Exception {
			try {
				dao.updateStockCategory(obj);
				con.commit();
				System.out.println("  DAOFactoryStock updateStockFundamental : OK !!");  
			
			} catch (Exception e) {
				try {
					con.rollback();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				System.out.println("ERROR  DAOFactoryStock updateStockFundamental :"+e);  
				throw new Exception ("ERROR  DAOFactoryStock updateStockFundamental :"+e);	
			
			}
		
			
			
		}
		
		

		
			public void  updateStockSubCategory(StockAccess obj)throws Exception {
				try {
					dao.updateStockSubCategory(obj);
					con.commit();
					System.out.println("  DAOFactoryStock updateStockFundamental : OK !!");  
				
				} catch (Exception e) {
					try {
						con.rollback();
					} catch (Exception e2) {
						// TODO: handle exception
					}
					System.out.println("ERROR  DAOFactoryStock updateStockFundamental :"+e);  
					throw new Exception ("ERROR  DAOFactoryStock updateStockFundamental :"+e);	
				
				}
			
				
				
			}
			
			
			
			public static LocalDate getWorkDay(LocalDate date, int workdays) {
			    if (workdays < 1) {
			        return date;
			    }
			   // workdays =workdays+1;
			    LocalDate result = date;
			    int addedDays = 0;
			    while (addedDays <= workdays) {
			       
			    	result = result.minusDays(1);
			        if ((result.getDayOfWeek() == DayOfWeek.SATURDAY ||
			              result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
			        	 result = result.minusDays(1);
			        	
			        }
			        addedDays++;
			    }
			   System.out.println("DAOFactoryStock days:"+addedDays);
			    return result;
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
		*//*
				Hashtable<String,String> tb =new Hashtable();
				tb.put("a.ax", "hi");
				tb.put("b.ax", "how");
				tb.put("c.ax", "are");
				tb.put("d.ax", "you");
				for(String s:tb.keySet()   ){
					System.out.println("<option value=\" "+s+"\"> ");

										
									
					}

				*/
		
		LocalDate currentDate = LocalDate.now();

		System.out.println("DAOFactoryStock FINISH:"+currentDate);		
		LocalDate yesterday = LocalDate.now().minusDays(0);
				System.out.println("DAOFactoryStock FINISH:"+yesterday);		
				yesterday = LocalDate.now().minusDays(1);
		System.out.println("DAOFactoryStock FINISH:"+yesterday);		
		String asCustomPattern = yesterday.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println("DAOFactoryStock FINISH:"+yesterday);		
		System.out.println("DAOFactoryStock FINISH");
		//LocalDate week = LocalDate.now();
		LocalDate week = LocalDate.parse("2016-11-30");
		
		WeekFields weekFields = WeekFields.of(Locale.getDefault()); 
		int weekNumber = week.get(weekFields.weekOfWeekBasedYear());
		System.out.println("DAOFactoryStock FINISH weekNumber:"+weekNumber);
		
		
		getWorkDay(LocalDate.now(), 20);
		System.out.println("DAOFactoryStock FINISH weekNumber:"+getWorkDay(LocalDate.now(), 75));
		
		
		
		
	} catch (Exception e) {
		System.out.println("ERROR :"+e);  
	}
			 
			   
		    
		    
		  
		  
		    
	
		        	
		        	
		        	
		        	
		   
		    
	

	
		
		
		  }
	
	public ArrayList getAllStockResearchList() throws Exception {

		return dao.getAllStockResearchList();

	}
	

}

