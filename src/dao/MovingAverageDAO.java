package dao;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import access.MovingAverageAccess;
import access.StockAccess;


public class MovingAverageDAO extends DAO{
	
	

	
	public MovingAverageDAO( Connection mycon ){
		con=mycon;
		
	}
	 		
			

	public MovingAverageAccess getStockMovingAverage(String code)throws Exception{
		String mysql="select * from (SELECT count(*)as nodays FROM core_data where date >= DAYSADDNOWK(current_date(),60) and code=? and twentychg < 0)a,"+
					"(SELECT count(*)as nodays1 FROM core_data where date >= DAYSADDNOWK(current_date(),120) and code=? and fiftychg < 0)b,"+
					"(SELECT count(*)as nodays2 FROM core_data where date >= DAYSADDNOWK(current_date(),240) and code=? and fiftychg < 0)c";


			 
		//System.out.println("111sql:"+mysql);
	
		
		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1, code);
		ps.setString(2, code);
		ps.setString(3, code);
		
		
		ResultSet rs = ps.executeQuery();
		MovingAverageAccess  mov =null ;
		while(rs.next()){
			
			mov = new MovingAverageAccess(code,new Date());
			
			mov.setNodayBelow20MAfor60d(rs.getInt("nodays"));
			mov.setNodayBelow50MAfor120d(rs.getInt("nodays1"));
			mov.setNodayBelow50MAfor240d(rs.getInt("nodays2"));
			
			
			
	    	 	 
	    	  
	      }
		ps.close();	
		
	return mov;
	
	
	}
	
	
	
	
	

	
	


	
	
	
	
	
	
}
