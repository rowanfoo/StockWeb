
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

import access.DataAccess;
import access.StockAccess;
import util.FormatUtil;


public class DataDAO extends DAO{
	
	

	
	public DataDAO( Connection mycon ){
		con=mycon;
		
	}
	 		
	
	
	public ArrayList <DataAccess>   getStockbyYear(String code, String year )throws Exception{
		ArrayList <DataAccess> arr = new ArrayList<DataAccess>();
		String mysql="SELECT * FROM core_data where code=? and Year(Date)=?; ";

		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1, code);
		ps.setString(2, year);
	
		ResultSet rs = ps.executeQuery();
		
		
		while(rs.next()){
			
		
	    	 	 
	    	  
	      
		
			 arr.add( new  DataAccess(rs.getDouble("open"), rs.getDouble("high"), rs.getDouble("low"), rs.getDouble("close"), rs.getString("closeVol") , rs.getDouble("volume"), rs.getDouble("changes"),
						rs.getDouble("changePercent"), rs.getString("previousClose") , rs.getDouble("avg3mth"), rs.getDouble("fifty"),rs.getDouble("fiftychg") ,
						rs.getDouble("twohundred"), rs.getDouble("twohundredchg"), rs.getString("code"), rs.getDate("date")));
		
		
		}
	

		 ps.close();	
		 System.out.println("RSI for a "+arr.size() );
	return arr;
	
	
	}
	public ArrayList <DataAccess>   getDate(String date)throws Exception{
		System.out.println("DataAccess getStock  start: ");
		ArrayList <DataAccess> arr = new ArrayList<DataAccess>();
		String mysql="SELECT * FROM core_data where date=?";
		
		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1, date);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){

			arr.add( new  DataAccess(rs.getDouble("open"), rs.getDouble("high"), rs.getDouble("low"), rs.getDouble("close"), rs.getString("closeVol") , rs.getDouble("volume"), rs.getDouble("changes"),
						rs.getDouble("changePercent"), rs.getString("previousClose") , rs.getDouble("avg3mth"), rs.getDouble("fifty"),rs.getDouble("fiftychg") ,
						rs.getDouble("twohundred"), rs.getDouble("twohundredchg"), rs.getString("code"), rs.getDate("date"),rs.getDouble("relativestrenght"),rs.getDouble("rsi"),rs.getDouble("rsivol")  ));
    	}
		
		 
		ps.close();	
	return arr;
	
	
	}
	
	
	public ArrayList <DataAccess>   getStock(String code)throws Exception{
		 System.out.println("DataAccess getStock  start: ");
		ArrayList <DataAccess> arr = new ArrayList<DataAccess>();
		String mysql="SELECT * FROM core_data where code=?";
		
		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1, code);
		//System.out.println("DataAccess getStock: "+ps);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			/*
			System.out.println("DataAccess getStock date: "+ rs.getDate("date") );
			System.out.println("DataAccess getStock1 : "+rs.getDouble("open"));
			System.out.println("DataAccess getStock2:1 "+rs.getDouble("high"));
			System.out.println("DataAccess getStock3: "+rs.getDouble("low"));
			System.out.println("DataAccess getStock4: "+rs.getDouble("close"));
			System.out.println("DataAccess getStock5: "+rs.getDouble("volume"));
			System.out.println("DataAccess getStock6: "+rs.getDouble("changes"));
			System.out.println("DataAccess getStock7: "+rs.getDouble("changePercent"));
			System.out.println("DataAccess getStock8: "+rs.getDouble("avg3mth"));
			System.out.println("DataAccess getStock9: "+rs.getDouble("fifty"));
			System.out.println("DataAccess getStock10: "+rs.getDouble("fiftychg"));
			System.out.println("DataAccess getStock11: "+rs.getDouble("twohundred"));
			System.out.println("DataAccess getStock12: "+rs.getDouble("twohundredchg"));
	    	 	
	    	  
			System.out.println("DataAccess getStock 11 : "+ rs.getString("closeVol"));
			System.out.println("DataAccess getStock 12 : "+ rs.getString("previousClose"));
			System.out.println("DataAccess getStock 13 : "+ rs.getString("code"));
		//	System.out.println("DataAccess getStock 14 : "+ rs.getString("closeVol"));
		//	System.out.println("DataAccess getStock 15 : "+ rs.getString("closeVol"));
			*/
			 arr.add( new  DataAccess(rs.getDouble("open"), rs.getDouble("high"), rs.getDouble("low"), rs.getDouble("close"), rs.getString("closeVol") , rs.getDouble("volume"), rs.getDouble("changes"),
						rs.getDouble("changePercent"), rs.getString("previousClose") , rs.getDouble("avg3mth"), rs.getDouble("fifty"),rs.getDouble("fiftychg") ,
						rs.getDouble("twohundred"), rs.getDouble("twohundredchg"), rs.getString("code"), rs.getDate("date"),rs.getDouble("relativestrenght"),rs.getDouble("rsi"),rs.getDouble("rsivol")  ));
    	
			// System.out.println("DataAccess getStock OK !!!!!!!!!!!!: ");
		
			 
		}
		
		 System.out.println("DataAccess getStock OK !!!!!!!!!!!! DONE : ");
		 ps.close();	
	return arr;
	
	
	}
	
	
	
	

			/**
			 * Get latest data record.
			 * @param code
			 * @return
			 * @throws Exception
			 */
		public DataAccess   getLastData(String code)throws Exception{
				 System.out.println("DataAccess getLastData  start: ");
				
				String mysql="SELECT * FROM core_data where code=? order by date desc limit 1";
				
				PreparedStatement ps = con.prepareStatement(mysql);
				ps.setString(1, code);
				ResultSet rs = ps.executeQuery();
				DataAccess dt=null;
				while(rs.next()){
			
						dt = new  DataAccess(rs.getDouble("open"), rs.getDouble("high"), rs.getDouble("low"), rs.getDouble("close"), rs.getString("closeVol") , rs.getDouble("volume"), rs.getDouble("changes"),
								rs.getDouble("changePercent"), rs.getString("previousClose") , rs.getDouble("avg3mth"), rs.getDouble("fifty"),rs.getDouble("fiftychg") ,
								rs.getDouble("twohundred"), rs.getDouble("twohundredchg"), rs.getString("code"), rs.getDate("date"),rs.getDouble("relativestrenght"),rs.getDouble("rsi"),rs.getDouble("rsivol")  );
						dt.setTwenty(rs.getDouble("twenty") );	
						dt.setTwentychg(rs.getDouble("twentychg") );
						dt.setFourhundred(rs.getDouble("fourhundred") );
						dt.setFourhundredchg(rs.getDouble("fourhundredchg"));
						dt.setFourty(rs.getDouble("fourty"));
						dt.setFourtychg(rs.getDouble("fourtychg"));
						dt.setFourhundred(rs.getDouble("fourhundred"));
						dt.setFourhundredchg(rs.getDouble("fourhundredchg"));

						dt.setOnehundredfifty(rs.getDouble("onehundredfifty"));
						dt.setOnehundredfiftychg(rs.getDouble("onehundredfiftychg"));

				}
				
				 System.out.println("DataAccess getLastData OK !!!!!!!!!!!! DONE : ");
				 ps.close();	
			return dt;
			
			
			}
			
	
	
	public HashMap<String,DataAccess>  getDataByCategory(String category,String date)throws Exception{
		HashMap <String,DataAccess> arr = new HashMap<String,DataAccess>();
		String mysql="SELECT * FROM core_data join stock on core_stock.code=stock.code where stock.category=? and core_stock.date=? ";
		
		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1, category);
		ps.setString(2, date);
		
		System.out.println("DataAccess getStock: "+ps);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			
		
	    	 	
	    	  
	      
		
			 arr.put( rs.getString("code"), new  DataAccess(rs.getDouble("open"), rs.getDouble("high"), rs.getDouble("low"), rs.getDouble("close"), rs.getString("closeVol") , rs.getDouble("volume"), rs.getDouble("changes"),
						rs.getDouble("changePercent"), rs.getString("previousClose") , rs.getDouble("avg3mth"), rs.getDouble("fifty"),rs.getDouble("fiftychg") ,
						rs.getDouble("twohundred"), rs.getDouble("twohundredchg"), rs.getString("code"), rs.getDate("date")));
    	
		
		
		}
		 ps.close();	
	return arr;
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	

	public StockAccess getStockCode(String code)throws Exception{
		ArrayList <StockAccess> arr = new ArrayList();
		String mysql="select * from core_stock where code=?";

			 
		System.out.println("111sql:"+mysql);
	
		
		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1, code);
		
		ResultSet rs = ps.executeQuery();
		StockAccess stock=null ;
		while(rs.next()){
			
			 stock = new StockAccess (rs.getString("code"),rs.getDate("date"),rs.getString("name"),rs.getString("descp"),rs.getLong("shares") ,rs.getString("marketCap"),rs.getString("category"),
					 rs.getString("top"),rs.getString("notes1"),rs.getString("notes2"),rs.getString("reason"),rs.getString("moat"),rs.getString("fundNotes"),
					 rs.getDouble("buyTrigger"),rs.getString("wishlist"),rs.getString("trend"),rs.getDouble("alertPrice"), rs.getDouble("normandyPrice"),  rs.getString("normandyNotes"), rs.getString("fYdate"),
					 rs.getString("technicalNotes"), rs.getString("montlyNotes"), rs.getString("weeklyNotes"),rs.getString("dailyNotes"), rs.getDouble("stopLoss"),rs.getString("stopLossNotes"),
					 rs.getString("whenBuy"), rs.getDouble("whenBuyPrice"), rs.getString("easyChange"), rs.getDouble("keySupportPrice"),rs.getString("keySupportPriceNotes"), rs.getDouble("defendKeyPrice"),rs.getString("defendKeyNotes")
					 , rs.getString("Nope"), rs.getString("news"),rs.getString("chart")	,rs.getString("stageGrowth"),rs.getString("research"),rs.getString("researchCat"),rs.getString("oneNotes")		);

	    	 	 
	    	  
	      }
		ps.close();	
		
	return stock;
	
	
	}
	
	
	
	
	

	
	
	public void updateData50d(DataAccess obj)throws Exception {
		
	//	String mysql="	UPDATE techstr SET Notes=?,OK=? WHERE  code=? and date=? and mode=?";
		
		String mysql="UPDATE core_data SET fifty=?, fiftychg=?  WHERE code=? and date=?  ";
	
		
		
		
		PreparedStatement ps =
		        con.prepareStatement(mysql);
		
		ps.setDouble(1,obj.getFifty() );
		System.out.println("DataDAO SQL "+obj.getClose()+"::"+obj.getFifty()  );
		
		if(obj.getFifty()>0){
			double close =obj.getClose();
			double fifty = obj.getFifty();
			
			ps.setDouble(2, FormatUtil.formatDouble((close-fifty)/fifty  ,2) );
		}else{
			ps.setDouble(2,0); 
		}
		
		ps.setString(3, obj.getCode());	
		ps.setString(4, obj.changeStringToDate());
	
		
		
		
		
		System.out.println("DataDAO SQL "+ps  );
		ps.executeUpdate();
		
		
		ps.close();	
	}
	

	/**
	 * Done daily , because yahoo dosent provide 20d and 75 moving avg
	 * @param arr
	 * @throws Exception
	 */
	
	public void updateDataNewAverages(ArrayList<DataAccess>arr)throws Exception {
		
	//	String mysql="	UPDATE techstr SET Notes=?,OK=? WHERE  code=? and date=? and mode=?";
		System.out.println("DataDAO updateDataNewAverages" );
		//String mysql="UPDATE data SET sevenfive=?, sevenfivechg=?, twenty=?, twentychg=?,fourty=?,fourtychg=?,onehundredfifty=?,onehundredfiftychg=? ,fourhundred=?,fourhundredchg=?  WHERE code=? and date=?  ";
		
		String mysql="UPDATE core_data SET sevenfive=?, sevenfivechg=?, twenty=?, twentychg=?,fourty=?,fourtychg=?,onehundredfifty=?,onehundredfiftychg=? ,fourhundred=?,fourhundredchg=?, "
				+ " twohundred=?,twohundredchg=?, "
				+ " fifty=?,fiftychg=? "
				+ " WHERE code=? and date=?  ";
		
		PreparedStatement ps =
		        con.prepareStatement(mysql);
		
		
		LocalDate date75 = FormatUtil.getWorkDay(LocalDate.now(), 75);
		LocalDate date20 = FormatUtil.getWorkDay(LocalDate.now(), 20);
		LocalDate date40 = FormatUtil.getWorkDay(LocalDate.now(), 40);
		LocalDate date150 = FormatUtil.getWorkDay(LocalDate.now(), 150);
		LocalDate date400 = FormatUtil.getWorkDay(LocalDate.now(), 400);	
		LocalDate date200 = FormatUtil.getWorkDay(LocalDate.now(), 200);	
		LocalDate date50 = FormatUtil.getWorkDay(LocalDate.now(), 50);	
		
		String mysql1="sELECT Avg(close)as average1   FROM core_data where date >= ? and code=? union all  sELECT Avg(close)as average2  FROM core_data where date >= ? and code=? "+
				 " union all  sELECT Avg(close)as average3  FROM core_data where date >= ? and code=?  union all  sELECT Avg(close)as average4  FROM core_data where date >= ? and code=? " +
				 "union all  sELECT Avg(close)as average4  FROM core_data where date >= ? and code=?  union all  sELECT Avg(close)as average4  FROM core_data where date >= ? and code=? "+
				" union all  sELECT Avg(close)as average4  FROM core_data where date >= ? and code=?";
		
//		String mysql="UPDATE data SET sevenfive=?, sevenfivechg=?, twenty=?, twentychg=?   WHERE code=? and date=?  ";
	

//		String mysql1="sELECT Avg(close)as average1   FROM fortune.data where date >= ? and code=? union all  sELECT Avg(close)as average2  FROM fortune.data where date >= ? and code=? "+
//				 " union all  sELECT Avg(close)as average3  FROM fortune.data where date >= ? and code=?  union all  sELECT Avg(close)as average4  FROM fortune.data where date >= ? and code=? " +
//				 "union all  sELECT Avg(close)as average4  FROM fortune.data where date >= ? and code=? ";
//		
		
		
		PreparedStatement ps1 =
		        con.prepareStatement(mysql1);
	
		//System.out.println("DataDAO preSQL updateDataNewAverages:"+ps1 );

		
		for(DataAccess obj:arr){
	
			
			ps1.setString(1,date20.toString()    );	
			ps1.setString(2, obj.getCode() );	
			
			ps1.setString(3, date75.toString());	
			ps1.setString(4, obj.getCode() );	
	
			
			ps1.setString(5, date40.toString());	
			ps1.setString(6, obj.getCode() );	
	
			ps1.setString(7, date150.toString());	
			ps1.setString(8, obj.getCode() );	
	
			ps1.setString(9, date400.toString());	
			ps1.setString(10, obj.getCode() );	
			
			ps1.setString(11, date200.toString());	
			ps1.setString(12, obj.getCode() );	
			
			ps1.setString(13, date50.toString());	
			ps1.setString(14, obj.getCode() );	
			
			
			
			double close = obj.getClose();
			//System.out.println("DataDAO updateDataNewAverages: code"+ obj.getCode() );
			ResultSet rs = ps1.executeQuery();
			double twenty=0;
			double seventy=0;
			double fourty=0;
			double oneHundredfifty=0;
			double fourhundred=0;
			double twohundred=0;
			double fifty=0;
			int count =0;
			while(rs.next()){
				if(count==0){
					twenty=rs.getDouble("average1");
					
				}else if(count==1){
					seventy=rs.getDouble("average1");
				}else if(count==2){
					fourty=rs.getDouble("average1");
				}else if(count==3){
					oneHundredfifty=rs.getDouble("average1");
				}else if(count==4){
					fourhundred=rs.getDouble("average1");
				}else if(count==5){
					twohundred=rs.getDouble("average1");
				}else if(count==6){
					fifty=rs.getDouble("average1");
				}
				
				
				
				count++;
		    	 	 
		    	  
		     }
			
			
		
			
			ps.setDouble(1,seventy );
			ps.setDouble(2,FormatUtil.formatDouble((close-seventy)/seventy  ,2) );
			ps.setDouble(3,twenty );
			ps.setDouble(4, FormatUtil.formatDouble((close-twenty)/twenty  ,2) );
			
			ps.setDouble(5,fourty );
			ps.setDouble(6, FormatUtil.formatDouble((close-fourty)/fourty  ,2) );
			ps.setDouble(7,oneHundredfifty );
			ps.setDouble(8, FormatUtil.formatDouble((close-oneHundredfifty)/oneHundredfifty  ,2) );
			
			ps.setDouble(9,fourhundred );
			ps.setDouble(10, FormatUtil.formatDouble((close-fourhundred)/fourhundred  ,2) );
			
			
			
			ps.setDouble(11,twohundred );
			ps.setDouble(12, FormatUtil.formatDouble((close-twohundred)/twohundred  ,2) );
			
			
			ps.setDouble(13,fifty );
			ps.setDouble(14, FormatUtil.formatDouble((close-fifty)/fifty  ,2) );
			
			
			
			ps.setString(15  ,obj.getCode()  );	
			ps.setString(16  ,obj.changeStringToDate()) ;	
			//System.out.println("DataDAO updateDataNewAverages:"+ps );
			
		ps.addBatch();
			
			
			
		}
		ps1.close();
		 ps.executeBatch();
		ps.close();
		
		
	}

	/**
	 * this is used in updating new data import , not daily operation (IMPORT)
	 * @param arr
	 * @throws Exception
	 */
		
	public void updateDataNewAveragesImport(ArrayList<DataAccess>arr )throws Exception {
	       
	    //    String mysql="    UPDATE techstr SET Notes=?,OK=? WHERE  code=? and date=? and mode=?";
	       
	       

	        System.out.println("DataDAO new data avg" );
	       
	        String mysql="UPDATE core_data SET sevenfive=?, sevenfivechg=?, twenty=?, twentychg=?   WHERE code=? and date=?  ";
	   
	        PreparedStatement ps =
	                con.prepareStatement(mysql);
	   
	        for(DataAccess obj:arr){
	       
	       
	       
	           
	            ps.setDouble(1,obj.getSevenfive() );
	            ps.setDouble(3,obj.getTwenty());
	           
	          //  System.out.println("DataDAO SQL "+obj.getClose()+"::"+obj.getTwenty()  );
	          //  System.out.println("DataDAO SQL " +obj.getTwenty()  );
	           
	            if(obj.getTwenty()>0){
	                double close =obj.getClose();
	                double twenty = obj.getTwenty();
	               
	                ps.setDouble(4, FormatUtil.formatDouble((close-twenty)/twenty  ,2) );
	            }else{
	                ps.setDouble(4,0);
	            }
	       
	            if(obj.getSevenfive()>0){
	                double close =obj.getClose();
	                double sevenfive = obj.getSevenfive();
	               
	                ps.setDouble(2, FormatUtil.formatDouble((close-sevenfive)/sevenfive  ,2) );
	            }else{
	                ps.setDouble(2,0);
	            }
	           
	           
	           
	           
	            ps.setString(5, obj.getCode());   
	            ps.setString(6, obj.changeStringToDate());
	       
	           
	            ps.addBatch();
	           
	           
	            //System.out.println("DataDAO SQL "+ps  );
	           
	        }
	       
	        ps.executeBatch();
	       
	        ps.close();   
	    }
	
	
	public void updateDataNewAveragesImport400(ArrayList<DataAccess>arr )throws Exception {
	       
        System.out.println("DataDAO new data updateDataNewAveragesImport400" );
	       
	        String mysql="UPDATE core_data SET fourhundred=?, fourhundredchg=? WHERE code=? and date=?  ";
	   
	        PreparedStatement ps =
	                con.prepareStatement(mysql);
	   
	        for(DataAccess obj:arr){
	       
	       
	       
	           
	            ps.setDouble(1,obj.getFourhundred() );
	           
	          //  System.out.println("DataDAO SQL "+obj.getClose()+"::"+obj.getTwenty()  );
	          //  System.out.println("DataDAO SQL " +obj.getTwenty()  );
	           
	            if(obj.getFourhundred()>0){
	                double close =obj.getClose();
	                double fourhundred = obj.getFourhundred();
	               
	                ps.setDouble(2, FormatUtil.formatDouble((close-fourhundred)/fourhundred  ,2) );
	            }else{
	                ps.setDouble(2,0);
	            }
	       
	           
	           
	           
	            ps.setString(3, obj.getCode());   
	            ps.setString(4, obj.changeStringToDate());
	       
	           
	            ps.addBatch();
	           
	           
	            //System.out.println("DataDAO SQL "+ps  );
	           
	        }
	       
	        ps.executeBatch();
	       
	        ps.close();   
	    }
		
	
	
	public void updateDataNewAveragesImportNew(ArrayList<DataAccess>arr )throws Exception {

		System.out.println("DataDAO new data avg");

		String mysql = "UPDATE core_data SET fourty=?, fourtychg=?, onehundredfifty=?, onehundredfiftychg=?   WHERE code=? and date=?  ";

		PreparedStatement ps = con.prepareStatement(mysql);

		for (DataAccess obj : arr) {

			ps.setDouble(1, obj.getFourty());
			ps.setDouble(3, obj.getOnehundredfifty());

			// System.out.println("DataDAO SQL
			// "+obj.getClose()+"::"+obj.getTwenty() );
			// System.out.println("DataDAO SQL " +obj.getTwenty() );

			if (obj.getOnehundredfifty() > 0) {
				double close = obj.getClose();
				double onehundredfifty = obj.getOnehundredfifty();

				ps.setDouble(4, FormatUtil.formatDouble((close - onehundredfifty) / onehundredfifty, 2));
			} else {
				ps.setDouble(4, 0);
			}

			if (obj.getFourty() > 0) {
				double close = obj.getClose();
				double fourty = obj.getFourty();

				ps.setDouble(2, FormatUtil.formatDouble((close - fourty) / fourty, 2));
			} else {
				ps.setDouble(2, 0);
			}

			ps.setString(5, obj.getCode());
			ps.setString(6, obj.changeStringToDate());

			ps.addBatch();

			// System.out.println("DataDAO SQL "+ps );

		}

		ps.executeBatch();

		ps.close();
	    }
				
		
		
		
		
			
	
	/**
	 * this is used in updating new data import , not daily operation (IMPORT)
	 * @param arr
	 * @throws Exception
	 */
	
	
	
	public void updateDataAveragesImport(ArrayList<DataAccess>arr )throws Exception {
		
	//	String mysql="	UPDATE techstr SET Notes=?,OK=? WHERE  code=? and date=? and mode=?";
		
		String mysql="UPDATE core_data SET fifty=?, fiftychg=?, twohundred=?, twohundredchg=? ,Avg3mth=?    WHERE code=? and date=?  ";
	
		PreparedStatement ps =
		        con.prepareStatement(mysql);
	
		for(DataAccess obj:arr){
		
		
		
			
			ps.setDouble(1,obj.getFifty() );
			//System.out.println("DataDAO SQL "+obj.getClose()+"::"+obj.getFifty()  );
			
			if(obj.getFifty()>0){
				double close =obj.getClose();
				double fifty = obj.getFifty();
				
				ps.setDouble(2, FormatUtil.formatDouble((close-fifty)/fifty  ,2) );
			}else{
				ps.setDouble(2,0); 
			}
			ps.setDouble(3,obj.getTwohundred() );
			if(obj.getTwohundred()>0){
				double close =obj.getClose();
				double twohundred = obj.getTwohundred();
				
				ps.setDouble(4, FormatUtil.formatDouble((close-twohundred)/twohundred  ,2) );
			}else{
				ps.setDouble(4,0); 
			}
			
			ps.setDouble(5,obj.getAvg3mth()) ;
			
			
			ps.setString(6, obj.getCode());	
			ps.setString(7, obj.changeStringToDate());
		
			
			ps.addBatch();
			
			
		//	System.out.println("DataDAO SQL "+ps  );
			
		}
		
	
		ps.executeBatch();
		ps.close();	
	}
	
	

	
	
	
	
	
	
	public void updateData200d(DataAccess obj)throws Exception {
		
	//	String mysql="	UPDATE techstr SET Notes=?,OK=? WHERE  code=? and date=? and mode=?";
		
		String mysql="UPDATE core_data SET twohundred=?, twohundredchg=?  WHERE code=? and date=?  ";
	
		
		
		
		PreparedStatement ps =
		        con.prepareStatement(mysql);
		
		ps.setDouble(1,obj.getFifty() );
		System.out.println("DataDAO SQL "+obj.getClose()+"::"+obj.getTwohundred()   );
		
		if(obj.getTwohundred()>0){
			double close =obj.getClose();
			double twohundred = obj.getTwohundred();
			
			ps.setDouble(2, FormatUtil.formatDouble((close-twohundred)/twohundred  ,2) );
		}else{
			ps.setDouble(2,0); 
		}
		
		ps.setString(3, obj.getCode());	
		ps.setString(4, obj.changeStringToDate());
	
		
		
		
		
		System.out.println("DataDAO SQL "+ps  );
		ps.executeUpdate();
		
		
		ps.close();	
	}
	
	public void updateDataAvgVol(DataAccess obj)throws Exception {
		
	//	String mysql="	UPDATE techstr SET Notes=?,OK=? WHERE  code=? and date=? and mode=?";
		
		String mysql="UPDATE core_data SET Avg3mth=?  WHERE code=? and date=?  ";
	
		
		
		
		PreparedStatement ps =
		        con.prepareStatement(mysql);
		
		ps.setDouble(1,obj.getAvg3mth()) ;
		
		

		ps.setString(3, obj.getCode());	
		ps.setString(4, obj.changeStringToDate());
	
		
		
		
		
		System.out.println("DataDAO SQL "+ps  );
		ps.executeUpdate();
		
		
		ps.close();	
	}
	
	
	
	
	
	
	

		public void updateStockFundamental(StockAccess obj)throws Exception {
		
		
			
			String mysql="UPDATE core_stock SET descp=?, category=?, reason=?, moat=?, fundNotes=?, FYdate=?, EasyChange=?,news=? WHERE code=?";
			
		
			
			
			
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

			ps.setString(9, obj.getCode());
			
			
			
		
			
			
			
			
			System.out.println("updateStockFundamental SQL "+mysql  );
			ps.executeUpdate();
			
			
			ps.close();	
		}
		
	
	



		public void deleteTodayDate()throws Exception {
		
		
			
			String mysql="delete from core_data where date=curdate()";
			
		
			
			
			
			PreparedStatement ps =
			        con.prepareStatement(mysql);
			System.out.println("deleteTodayDate SQL "+mysql  );
			ps.executeUpdate();
			
			
			ps.close();	
		}
		
	
	
	
	
	
	
	
}
