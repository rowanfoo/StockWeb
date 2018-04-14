

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

import java.sql.Statement;
import java.sql.PreparedStatement;

import java.util.Hashtable;
import java.util.Iterator;




public class DataDateDAO {
	/**
	
	Connection con=null;
    Logger logger = null;
	
	public DataDateDAO( Connection mycon ){
		con=mycon;
		
	}
	 		
	
	
	
		public ArrayList <DataReport>   getTechStrListByDate(String code,Date yeardate)throws Exception{
			ArrayList <DataReport> arr = new ArrayList();
			String mysql="SELECT   date, format((changePercent*100),2) as changePercent  FROM fortune.data where Year(date)=? and  code=? and  changePercent<0 group by Month(date)";
			
				// got to get 3 years before.
			//Date mydate= new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(yeardate);
			int year = cal.get(Calendar.YEAR);
			
			
			for (int count =0;count<4;count++){
				

				PreparedStatement ps =
				        con.prepareStatement(mysql);
					ps.setString(1, code);
					ps.setString(2, ""+(year-count));

					System.out.println("sql:"+ps);
				
				ResultSet rs = ps.executeQuery();
				
				 while(rs.next()){
					
				//	 arr.add(  new TechStrAccess (rs.getString("code"),rs.getDate("date"),rs.getString("name"),rs.getInt("mode") ,rs.getDouble("close"),rs.getDouble("fifty"),rs.getDouble("fiftychg"),rs.getLong("volume") ,rs.getDouble("3mthVol")  ,rs.getDouble("changePercent"),
					//		 rs.getString("seen"),rs.getString("OK"),rs.getString("Notes")          )               );
		
			    	 	 
			    	  
			      }
				ps.close();	
			
			}
			
			
			
		return arr;
	
	
	}
	
	
	
	public Hashtable <String ,DataReport>   getAllStockHash()throws Exception{
		Hashtable <String ,DataReport>   arr = new Hashtable();
		String mysql="select * from stock ";

			 
		//System.out.println("111sql:"+mysql);
	
		
		Statement stmt=				 con.createStatement();  	
		
		
		
		
		ResultSet rs =stmt.executeQuery(mysql);
		
		while(rs.next()){
			
		
	    	 	 
	    	  
	      }
		 stmt.close();	
	return arr;
	
	
	}
	

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
	
	
	
	
	

	
	
	public void updateTechStr(TechStrAccess obj)throws Exception {
	
	String mysql="	UPDATE techstr SET Notes=?,OK=? WHERE  code=? and date=? and mode=?";
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
	
	
	
	
	**/
	
	
	
	
	


	
	
	
	
	
	
}
