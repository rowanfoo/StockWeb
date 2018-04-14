

package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

import access.TechStrAccess;
import util.ExcelLogger;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.Statement;
import java.sql.PreparedStatement;

import java.util.Hashtable;
import java.util.Iterator;
import access.DataReport;
import java.util.Comparator;

import java.util.Collections;


public class DateReportDAO {
	
	 
	Connection con=null;
    Logger logger = null;
	
	public DateReportDAO( Connection mycon ){
		con=mycon;
		
	}   
	 		
	public ArrayList <DataReport>   getTenMonthAvgHistory (String code)throws Exception{
		ArrayList <DataReport> arr = new ArrayList();
		String mysql="SELECT date, min(twohundredchg) as low , max(twohundredchg) as high  FROM core_data where code=? and year(date)>=? group by month(date) , Year(date) order by (date)";
		
		Date mydate= new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(mydate);
		int year = cal.get(Calendar.YEAR);
		year = year-6;
		
		System.out.println("FINISH getTenMonthAvgHistory YEAR :"+year);
			PreparedStatement ps =
			        con.prepareStatement(mysql);
				ps.setString(1, code);
				ps.setInt(2, year);

				System.out.println("FINISH getTenMonthAvgHistory :"+ps);
			ResultSet rs = ps.executeQuery();
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			 
			 while(rs.next()){
				 String date=dateFormat.format( rs.getDate("date"));	
				 DataReport  dp = new DataReport ();
				 dp.setSdate(date);
				 dp.setCode(code);
				 dp.setTenmonthchgMax(rs.getDouble("high") );
				 dp.setTenmonthchgMin(rs.getDouble("low")  );
				 
				 arr.add(dp);
		      }
			ps.close();	
	return arr;     


}
	
	public ArrayList <DataReport>   getFiftyDayTwoYears (String code)throws Exception{
		ArrayList <DataReport> arr = new ArrayList();
		
		
		
		//String mysql="SELECT   date,code,   format((avg(fiftychg )*100),2)    as fiftychg FROM fortune.data where Year(date)=? and  code=? and  fiftychg<=0 group by Month(date)order by date desc";
		String mysql="SELECT   date,code,   format((fiftychg*100),2)    as fiftychg FROM core_data where Year(date)=? and  code=? order by date desc";
			// got to get 3 years before.
		Date mydate= new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(mydate);
		int year = cal.get(Calendar.YEAR);
		int totalDown=0;
		
		for (int count =0;count<3;count++){
			

			PreparedStatement ps =
			        con.prepareStatement(mysql);
				ps.setString(2, code);
				ps.setString(1, ""+(year-count));

			//	System.out.println("sql:"+ps);
			
			ResultSet rs = ps.executeQuery();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			 
			 while(rs.next()){
				 String date=dateFormat.format( rs.getDate("date"));	
				 DataReport  dp = new DataReport ();
				 dp.setSdate(date);
				 dp.setCode(rs.getString("code"));
				 //if(rs.getDouble("fiftychg")<0){
					 dp.setMonthAvgfiftyRed(rs.getDouble("fiftychg") );
				// }else if (rs.getDouble("fiftychg")>=0){
				//	 dp.setMonthAvgfiftyRed(0);
				// }
				 
				 arr.add(dp);
				 
				 totalDown+=rs.getDouble("fiftychg") ;
		    	  
		      }
			ps.close();	
		
		}
		//System.out.println("Arr isze:"+arr.size());
		
		 for(DataReport obj: arr){
			 obj.   setAvgMonthAvgfiftyRed(totalDown/arr.size());
		 }
		
		
		
		
	return arr;


}
	
	
	
		public ArrayList <DataReport>   getMonthAverageFromFiftyDayDownFourYears (String code)throws Exception{
			ArrayList <DataReport> arr = new ArrayList();
			
			
			
			//String mysql="SELECT   date,code,   format((avg(fiftychg )*100),2)    as fiftychg FROM fortune.data where Year(date)=? and  code=? and  fiftychg<=0 group by Month(date)order by date desc";
			String mysql="SELECT   date,code,   format((avg(fiftychg )*100),2)    as fiftychg FROM core_data where Year(date)=? and  code=?  group by Month(date)order by date desc";
			
				// got to get 3 years before.
			Date mydate= new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(mydate);
			int year = cal.get(Calendar.YEAR);
			int totalDown=0;
			
			for (int count =0;count<5;count++){
				

				PreparedStatement ps =
				        con.prepareStatement(mysql);
					ps.setString(2, code);
					ps.setString(1, ""+(year-count));

				//	System.out.println("sql:"+ps);
				
				ResultSet rs = ps.executeQuery();
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				
				 
				 while(rs.next()){
					 String date=dateFormat.format( rs.getDate("date"));	
					 DataReport  dp = new DataReport ();
					 dp.setSdate(date);
					 dp.setCode(rs.getString("code"));
					 if(rs.getDouble("fiftychg")<0){
						 dp.setMonthAvgfiftyRed(rs.getDouble("fiftychg") );
					 }else if (rs.getDouble("fiftychg")>=0){
						 dp.setMonthAvgfiftyRed(0);
					 }
					 
					 arr.add(dp);
					 
					 totalDown+=rs.getDouble("fiftychg") ;
			    	  
			      }
				ps.close();	
			
			}
			//System.out.println("Arr isze:"+arr.size());
			
			 for(DataReport obj: arr){
				 obj.   setAvgMonthAvgfiftyRed(totalDown/arr.size());
			 }
			
			
			
			
		return arr;
	
	
	}
	
	
		public ArrayList <DataReport>   getDownvsUpDayRatio (String code)throws Exception{
			ArrayList <DataReport> arr = new ArrayList <DataReport>();
			
			
			
			String mysql="SELECT  date,count(*)as countdown FROM core_data where Year(date)=? and  code=? and  changePercent < 0 group by Month(date) order by date desc";
			String mysql2="SELECT  date,count(*)as countup FROM core_data where Year(date)=? and  code=? and  changePercent > 0 group by Month(date) order by date desc";
			
				// got to get 3 years before.
			Date mydate= new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(mydate);
			int year = cal.get(Calendar.YEAR);
			
			
			for (int count =0;count<5;count++){
				

				PreparedStatement ps =
				        con.prepareStatement(mysql);
					ps.setString(2, code);
					ps.setString(1, ""+(year-count));

					
					PreparedStatement ps2 =
					        con.prepareStatement(mysql2);
						ps2.setString(2, code);
						ps2.setString(1, ""+(year-count));
					
					
					
				//	System.out.println(" getDownvsUpDayRatio sql:"+ps);
				
				ResultSet rs = ps.executeQuery();
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				ResultSet rs2 = ps2.executeQuery();
				// this is make sure both set is equals , sometime set become unequal as month not complete as first day of month then system pick up and either rs or rs1 get extra column.
				rs.last();
				rs2.last();
				int size1 = rs.getRow() ;
				int size2 = rs2.getRow() ;
				rs.beforeFirst();
				rs2.beforeFirst();
				if(size1>size2)rs.next();
				if(size2>size1)rs2.next();
				
				
				 
				 while(rs.next() &&rs2.next() ){
					 
					// System.out.println("here :");
					 
					 if( getMonth(rs.getDate("date")) ==  getMonth(rs2.getDate("date"))  ){
					 
					 double down = rs.getDouble("countdown");
					 double up = rs2.getDouble("countup");
					 
					 
					 String date=dateFormat.format( rs.getDate("date"));	
					 DataReport  dp = new DataReport ();
					 dp.setSdate(date);
					 //dp.setCode(rs.getString("code"));
					dp.setDownvsupratioPrice(down/up); 
					 arr.add(dp);
					 }
			      }
				ps.close();	
			
			}      
			
			
			
		return arr;
	
	
	}
	
		
		public ArrayList <DataReport>   getDownvsUpVolumeRatio (String code)throws Exception{
			ArrayList <DataReport> arr = new ArrayList();
			
			
			String mysql="SELECT  date,sum(volume) as downvol FROM core_data where Year(date)=? and  code=? and  changePercent < 0 group by Month(date) order by date desc";
			String mysql2="SELECT  date,sum(volume) as upvol FROM core_data where Year(date)=? and  code=? and  changePercent > 0 group by Month(date) order by date desc";
			
				// got to get 3 years before.
			Date mydate= new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(mydate);
			int year = cal.get(Calendar.YEAR);
			
			
			for (int count =0;count<5;count++){
				

				PreparedStatement ps =
				        con.prepareStatement(mysql);
					ps.setString(2, code);
					ps.setString(1, ""+(year-count));

					
					PreparedStatement ps2 =
					        con.prepareStatement(mysql2);
						ps2.setString(2, code);
						ps2.setString(1, ""+(year-count));
					
					
					
					//	System.out.println(" getDownvsUpVolumeRatio sql:"+ps);
				
				ResultSet rs = ps.executeQuery();
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				ResultSet rs2 = ps2.executeQuery();
				// this is make sure both set is equals , sometime set become unequal as month not complete as first day of month then system pick up and either rs or rs1 get extra column.
				rs.last();
				rs2.last();
				int size1 = rs.getRow() ;
				int size2 = rs2.getRow() ;
				
			
				rs.beforeFirst();
				rs2.beforeFirst();
				if(size1>size2)rs.next();
				if(size2>size1)rs2.next();
				
				 
				 while(rs.next() &&rs2.next() ){
					 
					// System.out.println("here :"+rs.getDate("date")+"::: r2:::"+rs2.getDate("date")+":::"+rs.getDouble("downvol")+"::::"+ rs2.getDouble("upvol") );
					 
					 if( getMonth(rs.getDate("date")) ==  getMonth(rs2.getDate("date") )){
					 
						 double down = rs.getDouble("downvol");
						 double up = rs2.getDouble("upvol");
						 
						 
						 String date=dateFormat.format( rs.getDate("date"));	
						 DataReport  dp = new DataReport ();
						 dp.setSdate(date);
						 //dp.setCode(rs.getString("code"));
						dp.setDownvsupratioVolume (down/up); 
						 arr.add(dp);
					 }
			      }
				
				
				
		
		
				 
				 
				ps.close();	
			
			}
			//System.out.println("Arr isze:"+arr);
			
			
		return arr;
	
	
	}
	
		
		
		
		
		
		
		
		public int getMonth(Date date){
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			return cal.get(Calendar.MONTH);
		}
			
		
		
		
	
	
	public Hashtable <String ,DataReport>   getAllStockHash()throws Exception{
		Hashtable <String ,DataReport>   arr = new Hashtable();
		String mysql="select * from core_stock ";

			 
		//System.out.println("111sql:"+mysql);
	
		
		Statement stmt=				 con.createStatement();  	
		
		
		
		
		ResultSet rs =stmt.executeQuery(mysql);
		
		while(rs.next()){
			
		
	    	 	 
	    	  
	      }
		 stmt.close();	
	return arr;
	
	
	}
	
/*
	public DataReport getStockCode(String code)throws Exception{
		
		ArrayList <StockAccess> arr = new ArrayList();
		String mysql="select * from stock where code=?";

			 
		//System.out.println("111sql:"+mysql);
	
		
		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1, code);
		
		ResultSet rs = ps.executeQuery();
		StockAccess stock=null ;
		while(rs.next()){
		
	    	 	 
	    	  
	      }
		ps.close();	
		
	return stock;
	
	
	}
	
	*/
	
	
	

	
	
	public void updateTechStr(TechStrAccess obj)throws Exception {
	
	String mysql="	UPDATE tech_techstr SET Notes=?,OK=? WHERE  code=? and date=? and mode=?";
	PreparedStatement ps =
	        con.prepareStatement(mysql);
	
	ps.setString(1, obj.getNotes());
	ps.setString(2, obj.getOK());
	ps.setString(3, obj.getCode());
	ps.setString(4, obj.getDate().toString());
	ps.setInt(5, obj.getMode());
	System.out.println("Update SQL "+mysql  );
	ps.executeUpdate();
	
	
	ps.close();	
	}
	
	public ArrayList <DataReport>   getPriceVariance (String code)throws Exception{
		ArrayList <DataReport> arr = new ArrayList <DataReport>();
		
		
		
		String mysql="select code ,date, VARIANCE(changePercent)as var from core_data where month(date)=? and code=?  and year(date)=? group by Month(date) ";
		
		
			// got to get 3 years before.
		LocalDate week = LocalDate.now();
		LocalDate month;
		
		PreparedStatement ps =
		        con.prepareStatement(mysql);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		for( int x =0;x<15;x++){
			month = week.minusMonths(x);
			//System.out.println(" DayReversalVolStr month :"+month.getMonthValue()+":"+month.getYear() );
			
			ps.setString(1, ""+month.getMonthValue());
			ps.setString(2, code);
			ps.setString(3, ""+month.getYear());
			//System.out.println(" DayReversalVolStr sql :"+ps );
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				double var = rs.getDouble("var"); 
				
				DataReport  dp = new DataReport ();
				String date=dateFormat.format( rs.getDate("date"));	
				 dp.setSdate(date);
				 dp.setCode(rs.getString("code"));
				 dp.setPriceVariance(var);
				 dp.setMonthVariance(month.getMonthValue() );
				 arr.add(dp);
				 
				 
				 
				
			
			}
			
		
		}
			        	
			        	
			        	
			        	
		
		
			ps.close();	
		
		
		
		
		
	return arr;


}
	
	
	
	
public static void main(String arg[]){
	/*
	Collections.sort(ls, new Comparator() 
	{
	    public int compare(Object o1, Object o2) 
	    {
	       if(o1 instanceof String && o2 instanceof String) 
	       {
	          String s_1 = (String)o1;
	          String s_2 = (String)o2;

	          return s_1.compareTo(s_2);
	       } 
	       return 0;    
	    }
	});
	*/
}
	
	
	


	
	
	
	
	
	
}
