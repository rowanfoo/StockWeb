
package dao;

import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Logger;

import access.TechStrAccess;

import util.ExcelLogger;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;


import java.sql.PreparedStatement;

import access.DataAccess;
import access.StockAccess;

import java.util.Hashtable;


public class StockDAO extends DAO{
	
	

	
	public StockDAO( Connection mycon ){
		con=mycon;
		
	}
	 		
	
	
	
	public ArrayList <StockAccess>   getAllStock()throws Exception{
		ArrayList <StockAccess> arr = new ArrayList();
		String mysql="select * from core_stock ";

			 
		//System.out.println("111sql:"+mysql);
	
		
		Statement stmt=				 con.createStatement();  	
		
		
		
		
		ResultSet rs =stmt.executeQuery(mysql);
		
		while(rs.next()){
			
			 arr.add(  getNewStockAccess(rs));

	    	 	 
	    	  
	      }
		 stmt.close();	
	return arr;
	
	
	}

	public ArrayList <StockAccess> getAllStockResearchList() throws Exception {
		ArrayList <StockAccess> arr = new ArrayList();
		String mysql = "select * from core_stock where research='Y'";

		// System.out.println("111sql:"+mysql);
String path = ".\\webapps\\ROOT\\img\\";
		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery(mysql);
		
		
		while (rs.next()) {
			StockAccess stk = getNewStockAccess(rs); 
			arr.add( stk );
			String  daily=".\\webapps\\ROOT\\img\\"+stk.getPureCode() . toUpperCase()+"-D.gif" ;
			String  weekly=".\\webapps\\ROOT\\img\\"+stk.getPureCode().toUpperCase()+"W.gif" ;
			String  monthly=".\\webapps\\ROOT\\img\\"+stk.getPureCode().toUpperCase()+"-M.gif" ;
				
			File fd = new java.io.File(daily );
			File fw = new java.io.File( weekly );
			File fm = new java.io.File(monthly );
			
			if(fd.exists())stk.setDailychart("img\\"+stk.getPureCode() . toUpperCase()+"-D.gif");
			if(fw.exists())stk.setWeeklychart("img\\"+stk.getPureCode() . toUpperCase()+"-W.gif");
			if(fm.exists())stk.setMonthlychart("img\\"+stk.getPureCode() . toUpperCase()+"-M.gif");
			
		}
		
        
		stmt.close();
		return arr;

	}
	
	
	public HashMap <String ,StockAccess>   getAllStockWishList()throws Exception{
		HashMap <String ,StockAccess> arr = new HashMap <String ,StockAccess>();
		String mysql="select * from core_stock where wishlist='Y'";

			 
		//System.out.println("111sql:"+mysql);
	
		
		Statement stmt=				 con.createStatement();  	
		
		
		
		
		ResultSet rs =stmt.executeQuery(mysql);
		
		while(rs.next()){
			
			 arr.put(rs.getString("code"),    getNewStockAccess(rs));

			
	    	  
	      }
		 stmt.close();	
	return arr;
	
	
	}
	
	public StockAccess getStockData(String date, String code) throws Exception {

		String mysql = "SELECT * FROM core_stock join  data on core_stock.code=data.code where data.date=?  and core_stock.code=?";

		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1, date);
		ps.setString(2, code);
		System.out.print("getStockData:"+ps);
		ResultSet rs = ps.executeQuery();
		StockAccess stock = null;

		while (rs.next()) {
			stock = getNewStockAccessData(rs);

		}
		ps.close();

		return stock;

	}
	
	public ArrayList<StockAccess> getStockIndex() throws Exception {

		String mysql = "SELECT * FROM core_stock  where code like '^%'";

		ArrayList<StockAccess> ls = new ArrayList<>();
		PreparedStatement ps = con.prepareStatement(mysql);
		ResultSet rs = ps.executeQuery();
		StockAccess stock = null;

		while (rs.next()) {
			ls.add(getNewStockAccess(rs));

		}
		ps.close();

		return ls;

	}
	
	
	
	public ArrayList <StockAccess>   getAllStockData(String date)throws Exception{
		ArrayList <StockAccess> arr = new ArrayList();
		String mysql="SELECT * FROM core_stock join  data on core_stock.code=data.code where data.date=?";

			 
		
		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1, date);
		
		ResultSet rs = ps.executeQuery();
	
		while(rs.next()){
			/*
			 stock = new StockAccess (rs.getString("code"),rs.getDate("date"),rs.getString("name"),rs.getString("descp"),rs.getLong("shares") ,rs.getString("marketCap"),rs.getString("category"),
					 rs.getString("top"),rs.getString("notes1"),rs.getString("notes2"),rs.getString("reason"),rs.getString("moat"),rs.getString("fundNotes"),
					 rs.getDouble("buyTrigger"),rs.getString("wishlist"),rs.getString("trend"),rs.getDouble("alertPrice"), rs.getDouble("normandyPrice"),  rs.getString("normandyNotes"), rs.getString("fYdate"),
					 rs.getString("technicalNotes"), rs.getString("montlyNotes"), rs.getString("weeklyNotes"),rs.getString("dailyNotes"), rs.getDouble("stopLoss"),rs.getString("stopLossNotes"),
					 rs.getString("whenBuy"), rs.getDouble("whenBuyPrice"), rs.getString("easyChange"), rs.getDouble("keySupportPrice"),rs.getString("keySupportPriceNotes"), rs.getDouble("defendKeyPrice"),rs.getString("defendKeyNotes")
					 , rs.getString("Nope"), rs.getString("news"),rs.getString("chart")		);

	    	 	 
			 data=  new  DataAccess(rs.getDouble("open"), rs.getDouble("high"), rs.getDouble("low"), rs.getDouble("close"), rs.getString("closeVol") , rs.getDouble("volume"), rs.getDouble("changes"),
						rs.getDouble("changePercent"), rs.getString("previousClose") , rs.getDouble("avg3mth"), rs.getDouble("fifty"),rs.getDouble("fiftychg") ,
						rs.getDouble("twohundred"), rs.getDouble("twohundredchg"), rs.getString("code"), rs.getDate("date"));
			 stock.setData(data);
			 arr.add(stock); 
			 */
			 
			 
			 arr.add(getNewStockAccessData(rs)); 
			 
	      }
		ps.close();	
		
	return arr;
	
	
	}
	
	public ArrayList <StockAccess>   geStockWishList(String date)throws Exception{
		ArrayList <StockAccess> arr = new ArrayList();
		String mysql="select * from core_stock join  data on core_stock.code=data.code where data.date=?	and trim(coalesce(wishlist, '')) <>''";


			 
		
		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1, date);
		
		ResultSet rs = ps.executeQuery();
		StockAccess stock=null ;
		DataAccess data =null;
		while(rs.next()){
			/*
			 stock = new StockAccess (rs.getString("code"),rs.getDate("date"),rs.getString("name"),rs.getString("descp"),rs.getLong("shares") ,rs.getString("marketCap"),rs.getString("category"),
					 rs.getString("top"),rs.getString("notes1"),rs.getString("notes2"),rs.getString("reason"),rs.getString("moat"),rs.getString("fundNotes"),
					 rs.getDouble("buyTrigger"),rs.getString("wishlist"),rs.getString("trend"),rs.getDouble("alertPrice"), rs.getDouble("normandyPrice"),  rs.getString("normandyNotes"), rs.getString("fYdate"),
					 rs.getString("technicalNotes"), rs.getString("montlyNotes"), rs.getString("weeklyNotes"),rs.getString("dailyNotes"), rs.getDouble("stopLoss"),rs.getString("stopLossNotes"),
					 rs.getString("whenBuy"), rs.getDouble("whenBuyPrice"), rs.getString("easyChange"), rs.getDouble("keySupportPrice"),rs.getString("keySupportPriceNotes"), rs.getDouble("defendKeyPrice"),rs.getString("defendKeyNotes")
					 , rs.getString("Nope"), rs.getString("news"),rs.getString("chart")		);

	    	 	 
			 data=  new  DataAccess(rs.getDouble("open"), rs.getDouble("high"), rs.getDouble("low"), rs.getDouble("close"), rs.getString("closeVol") , rs.getDouble("volume"), rs.getDouble("changes"),
						rs.getDouble("changePercent"), rs.getString("previousClose") , rs.getDouble("avg3mth"), rs.getDouble("fifty"),rs.getDouble("fiftychg") ,
						rs.getDouble("twohundred"), rs.getDouble("twohundredchg"), rs.getString("code"), rs.getDate("date"));
			 stock.setData(data);
			 
			 
			 arr.add(stock); 
			 */
			 arr.add(getNewStockAccessData(rs)); 
				
			 
	      }
		ps.close();	
		
	return arr;
	
	
	}
	
	
	
	public Hashtable <String ,StockAccess>   getAllStockHash()throws Exception{
		Hashtable <String ,StockAccess>   arr = new Hashtable();
		String mysql="select * from core_stock ";

			 
		//System.out.println("111sql:"+mysql);
	
		
		Statement stmt=				 con.createStatement();  	
		
		
		
		
		ResultSet rs =stmt.executeQuery(mysql);
		
		while(rs.next()){
			
			 arr.put(rs.getString("code")  ,new StockAccess (rs.getString("code"),rs.getDate("date"),rs.getString("name"),rs.getString("descp"),rs.getLong("shares") ,rs.getString("marketCap"),rs.getString("category"),
					 rs.getString("top"),rs.getString("notes1"),rs.getString("notes2"),rs.getString("reason"),rs.getString("moat"),rs.getString("fundNotes"),
					 rs.getDouble("buyTrigger"),rs.getString("wishlist"),rs.getString("trend"),rs.getDouble("alertPrice"), rs.getDouble("normandyPrice"),  rs.getString("normandyNotes"), rs.getString("fYdate"),
					 rs.getString("technicalNotes"), rs.getString("montlyNotes"), rs.getString("weeklyNotes"),rs.getString("dailyNotes"), rs.getDouble("stopLoss"),rs.getString("stopLossNotes"),
					 rs.getString("whenBuy"), rs.getDouble("whenBuyPrice"), rs.getString("easyChange"), rs.getDouble("keySupportPrice"),rs.getString("keySupportPriceNotes"), rs.getDouble("defendKeyPrice"),rs.getString("defendKeyNotes")
					 , rs.getString("Nope"), rs.getString("news"),rs.getString("chart")	,rs.getString("stageGrowth"),rs.getString("research"),rs.getString("researchCat"),rs.getString("oneNotes")	));
			 
	    	 	 
	    	  
	      }
		 stmt.close();	
	return arr;
	
	
	}
	

	public StockAccess getStockCode(String code)throws Exception{
		ArrayList <StockAccess> arr = new ArrayList<StockAccess> ();
		String mysql="select * from core_stock where code=?";

			 
		//System.out.println("111sql:"+mysql);
	
		
		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1, code);
		
		ResultSet rs = ps.executeQuery();
		StockAccess stock=null ;
		while(rs.next()){
			
			 stock = getNewStockAccessData(rs);

	    	 	 
	    	  
	      }
		ps.close();	
		
	return stock;
	
	
	}
	private StockAccess getNewStockAccess(ResultSet rs)throws Exception{
		StockAccess stock = new StockAccess (rs.getString("code"),rs.getDate("date"),rs.getString("name"),rs.getString("descp"),rs.getLong("shares") ,rs.getString("marketCap"),rs.getString("category"),
				 rs.getString("top"),rs.getString("notes1"),rs.getString("notes2"),rs.getString("reason"),rs.getString("moat"),rs.getString("fundNotes"),
				 rs.getDouble("buyTrigger"),rs.getString("wishlist"),rs.getString("trend"),rs.getDouble("alertPrice"), rs.getDouble("normandyPrice"),  rs.getString("normandyNotes"), rs.getString("fYdate"),
				 rs.getString("technicalNotes"), rs.getString("montlyNotes"), rs.getString("weeklyNotes"),rs.getString("dailyNotes"), rs.getDouble("stopLoss"),rs.getString("stopLossNotes"),
				 rs.getString("whenBuy"), rs.getDouble("whenBuyPrice"), rs.getString("easyChange"), rs.getDouble("keySupportPrice"),rs.getString("keySupportPriceNotes"), rs.getDouble("defendKeyPrice"),rs.getString("defendKeyNotes")
				 , rs.getString("Nope"), rs.getString("news"),rs.getString("chart"),rs.getString("stageGrowth"),rs.getString("research"),rs.getString("researchCat")	,rs.getString("oneNotes")			);
	
		 
		// stock.setMyMarketCap((long)(stock.getShares()*rs.getDouble("close") )  );
		 return stock;
		 
	}
	
	private StockAccess getNewStockAccessData(ResultSet rs)throws Exception{
		StockAccess stock = new StockAccess (rs.getString("code"),rs.getDate("date"),rs.getString("name"),rs.getString("descp"),rs.getLong("shares") ,rs.getString("marketCap"),rs.getString("category"),
				 rs.getString("top"),rs.getString("notes1"),rs.getString("notes2"),rs.getString("reason"),rs.getString("moat"),rs.getString("fundNotes"),
				 rs.getDouble("buyTrigger"),rs.getString("wishlist"),rs.getString("trend"),rs.getDouble("alertPrice"), rs.getDouble("normandyPrice"),  rs.getString("normandyNotes"), rs.getString("fYdate"),
				 rs.getString("technicalNotes"), rs.getString("montlyNotes"), rs.getString("weeklyNotes"),rs.getString("dailyNotes"), rs.getDouble("stopLoss"),rs.getString("stopLossNotes"),
				 rs.getString("whenBuy"), rs.getDouble("whenBuyPrice"), rs.getString("easyChange"), rs.getDouble("keySupportPrice"),rs.getString("keySupportPriceNotes"), rs.getDouble("defendKeyPrice"),rs.getString("defendKeyNotes")
				 , rs.getString("Nope"), rs.getString("news"),rs.getString("chart"),rs.getString("stageGrowth"),rs.getString("research"),rs.getString("researchCat")	,rs.getString("oneNotes")	);

    	// 	 System.out.println("STOCKDAO---- avg3mth"+rs.getString("code")+":"+ rs.getDouble("volume")+":"+rs.getDouble("avg3mth"));
		
		DataAccess dt = new  DataAccess(rs.getDouble("open"), rs.getDouble("high"), rs.getDouble("low"), rs.getDouble("close"), rs.getString("closeVol") , rs.getDouble("volume"), rs.getDouble("changes"),
				rs.getDouble("changePercent"), rs.getString("previousClose") , rs.getDouble("avg3mth"), rs.getDouble("fifty"),rs.getDouble("fiftychg") ,
				rs.getDouble("twohundred"), rs.getDouble("twohundredchg"), rs.getString("code"), rs.getDate("date"));
		
	
		
		
		dt.setTwenty(rs.getDouble("twenty") );
		dt.setTwentychg(rs.getDouble("twentychg"));
		
		 System.out.println("DATAA---- "+dt.getCode() +":) "+ dt.getVolume() +":>>>>"+dt.getAvg3mth());
		
		stock.setData(dt );
		 
		 
		 
		 
		 stock.setMyMarketCap((long)(stock.getShares()*rs.getDouble("close") )  );
		 return stock;
		 
	}

	public ArrayList<StockAccess> getStockIndex(String category) throws Exception {
		// ArrayList <StockAccess> arr = new ArrayList<StockAccess> ();
		String mysql = "SELECT * FROM core_stock where top in(";
		mysql = mysql + category + ")";

		ArrayList<StockAccess> myarr = new ArrayList<StockAccess>();

		PreparedStatement ps = con.prepareStatement(mysql);

		//System.out.println("ArrayList:" + ps);
		ResultSet rs = ps.executeQuery();
		StockAccess stock = null;
		while (rs.next()) {

			myarr.add(getNewStockAccess(rs));

		}

		ps.close();

		return myarr;

	}

	
	public  ArrayList <StockAccess> getStockCategory(String category,String date)throws Exception{
		//ArrayList <StockAccess> arr = new ArrayList<StockAccess> ();
		String mysql="SELECT * FROM core_data join core_stock on data.code=core_stock.code where core_stock.category=? and data.date=?";

			 
		 ArrayList <StockAccess>  myarr =new ArrayList<StockAccess> ();
		
		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1, category);
		ps.setString(2, date);
		
		System.out.println("getStockCategory:"+ps);
		ResultSet rs = ps.executeQuery();
		StockAccess stock=null ;
		while(rs.next()){
			/**
			 stock = new StockAccess (rs.getString("code"),rs.getDate("date"),rs.getString("name"),rs.getString("descp"),rs.getLong("shares") ,rs.getString("marketCap"),rs.getString("category"),
					 rs.getString("top"),rs.getString("notes1"),rs.getString("notes2"),rs.getString("reason"),rs.getString("moat"),rs.getString("fundNotes"),
					 rs.getDouble("buyTrigger"),rs.getString("wishlist"),rs.getString("trend"),rs.getDouble("alertPrice"), rs.getDouble("normandyPrice"),  rs.getString("normandyNotes"), rs.getString("fYdate"),
					 rs.getString("technicalNotes"), rs.getString("montlyNotes"), rs.getString("weeklyNotes"),rs.getString("dailyNotes"), rs.getDouble("stopLoss"),rs.getString("stopLossNotes"),
					 rs.getString("whenBuy"), rs.getDouble("whenBuyPrice"), rs.getString("easyChange"), rs.getDouble("keySupportPrice"),rs.getString("keySupportPriceNotes"), rs.getDouble("defendKeyPrice"),rs.getString("defendKeyNotes")
					 , rs.getString("Nope"), rs.getString("news"),rs.getString("chart")		);

	    	 	 
			
			 
			 stock.setData(  new  DataAccess(rs.getDouble("open"), rs.getDouble("high"), rs.getDouble("low"), rs.getDouble("close"), rs.getString("closeVol") , rs.getDouble("volume"), rs.getDouble("changes"),
						rs.getDouble("changePercent"), rs.getString("previousClose") , rs.getDouble("avg3mth"), rs.getDouble("fifty"),rs.getDouble("fiftychg") ,
						rs.getDouble("twohundred"), rs.getDouble("twohundredchg"), rs.getString("code"), rs.getDate("date")));
			 
			 stock.setMyMarketCap((long)(stock.getShares()*rs.getDouble("close") )  );
			 myarr.add(stock);
			 */
			 myarr.add(getNewStockAccessData(rs));
			 
	      }
		
		
		ps.close();	
		
		System.out.println("HEre SORTED");
		
		 Collections.sort(myarr, new Comparator<StockAccess>() {
		        @Override
		        public int compare(StockAccess fr2, StockAccess fr1)
		        {

		            return (int) (fr2.getMyMarketCap() - fr1.getMyMarketCap());

		        }
		    });
		
	
		 
		 
		
	return myarr;
	
	
	}
	
	class MarketCapCompare implements Comparator<StockAccess> {
		 public int compare(StockAccess fr2, StockAccess fr1)
	        {

	            return (int) (fr2.getMyMarketCap() - fr1.getMyMarketCap());

	        }

	
	}
	

	
	
	public void updateStockTechnical(StockAccess obj)throws Exception {
		
	//	String mysql="	UPDATE techstr SET Notes=?,OK=? WHERE  code=? and date=? and mode=?";
		
		String mysql="UPDATE core_stock SET notes1=?, notes2=?, buyTrigger=?, wishlist=?, trend=?, AlertPrice=?, normandyPrice=?, normandyNotes=?, TechnicalNotes=?, "
		+ "montlyNotes=?, weeklyNotes=?, DailyNotes=?, stopLoss=?, stopLossNotes=?, whenBuy=?, whenBuyPrice=?, keySupportPrice=?, keySupportPriceNotes=?, "
		+ "defendKeyNotes=?, defendKeyPrice=?,Nope=?,chart=?,stageGrowth=? WHERE code=?";
	
		
		
		
		PreparedStatement ps =
		        con.prepareStatement(mysql);
		
		ps.setString(1, obj.getNotes1()  );
		ps.setString(2, obj.getNotes2() );
		ps.setDouble(3, obj.getBuyTrigger());
		ps.setString(4, obj.getWishlist());
		ps.setString(5, obj.getTrend() );
	
		ps.setFloat(6, (float) obj.getAlertPrice());
		ps.setFloat(7,  (float) obj.getNormandyPt());
		ps.setString(8,obj.getNormandyNotes() );
		ps.setString(9,obj.getTechnicalNotes() );
		ps.setString(10,obj.getMontlyNotes() );
		ps.setString(11,obj.getWeeklyNotes() );
	
		ps.setString(12,obj.getDailyNotes() );
		ps.setFloat(13, (float)obj.getStopLoss()  );
	
		ps.setString(14,obj.getStopLossNotes() );
		ps.setString(15,obj.getWhenBuy() );
		ps.setFloat(16,  (float)obj.getWhenBuyPrice());
	
		ps.setFloat(17,  (float)obj.getKeySupportPrice());
		ps.setString(18, obj.getKeySupportPriceNotes());
		
		ps.setString(19, obj.getDefendKeyNotes());
		ps.setFloat(20,  (float)obj.getDefendKeyPrice());
		ps.setString(21, obj.getNope()  );
		ps.setString(22, obj.getChart()  );	
		ps.setString(23, obj.getStageGrowth());	
		ps.setString(24, obj.getCode());
	
		
		
		
		
		System.out.println("updateStockTechnical SQL "+mysql  );
		ps.executeUpdate();
		
		
		ps.close();	
	}
	
	
	
	
	
	
	

		public void updateStockFundamental(StockAccess obj)throws Exception {
		
		
			
			String mysql="UPDATE core_stock SET descp=?, category=?, reason=?, moat=?, fundNotes=?, FYdate=?, EasyChange=?,news=?,wishlist=?,research=?,researchCat=? WHERE code=?";
			
		
			
			
			
			PreparedStatement ps =
			        con.prepareStatement(mysql);
			
			ps.setString(1, obj.getDescp() );
			ps.setString(2, obj.getCategory());
			ps.setString(3, obj.getReason() );
			ps.setString(4, obj.getMoat());
			ps.setString(5, obj.getFundNotes() );
			ps.setString(6, obj.getFYdate());
			ps.setString(7, obj.getEasyChange() );
			ps.setString(8, obj.getNews());
			ps.setString(9, obj.getWishlist()    );
			ps.setString(10, obj.getResearch()    );
			ps.setString(11, obj.getResearchCat()    );

			ps.setString(12, obj.getCode());
			
			
			
		
			
			
			
			
			System.out.println("updateStockFundamental SQL "+ps  );
			ps.executeUpdate();
			
			
			ps.close();	
		}
		
	
	


		public void updateStockCategory(StockAccess obj)throws Exception {
		
		
			
			String mysql="UPDATE core_stock SET category=?WHERE code=?";
			
		
			
			
			
			PreparedStatement ps =
			        con.prepareStatement(mysql);
			
			ps.setString(1, obj.getCategory());
			ps.setString(2, obj.getCode());
			System.out.println("StockDAO.java updateStockCategory "+mysql  );
			ps.executeUpdate();
			
			
			ps.close();	
		}
		public void updateStockSubCategory(StockAccess obj)throws Exception {
		
		
			
			String mysql="UPDATE core_stock SET subcategory=? WHERE code=?";
			
		
			
			
			
			PreparedStatement ps =
			        con.prepareStatement(mysql);
			
		
			ps.setString(1, obj.getSubcategory());
	
			ps.setString(2, obj.getCode());
			
			
			
		
			
			
			
			
			System.out.println("updateStockSubCategory SQL "+ps  );
			ps.executeUpdate();
			
			
			ps.close();	
		}
		
	
	
	
	
	
	
	
	
}
