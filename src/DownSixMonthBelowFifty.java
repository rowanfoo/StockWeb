

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

import dao.Database;
import util.ExcelLogger;
import util.FormatUtil;
/**
 * 
 * find all vol * 60%
 * 1. large vol small drop
 * 2.large vol break throug.
 * 3. large vol small gain - dying
 * 
 * 
 * 
 * @author rowan
 *
 */




public class  DownSixMonthBelowFifty {
	/**
	 * 
	 * 
	 * 
	 * if today close price is lesser then last month low 
	 * and last month low is also lesser then last last month low 
	 * and last last last month low , then let me see it.
	 * down 6 month out of 8 months.
	 * 
	 * 
	 * 
	 */
	Connection con=null;

	
	 Logger logger = null;
	
	 DownSixMonthBelowFifty(){
		
		
		try {
			
			logger = ExcelLogger.getLogger();
			
			System.out.println("DownSixMonthBelowFifty rUN    ");	
			logger.info("Data");	
			
				 con= Database.getConnection();
			    
				 logger.info("DownSixMonthBelowFifty ok");	    
				 con.setAutoCommit(false);
			   
			
		} catch (Exception e) {
			System.out.println("Error initialize "+e);
			 logger.severe("DownSixMonthBelowFifty Error initialize:"+e);	    
		}	
	}
	
	public void execute()throws Exception {
		//************************ THINGS to Do
		// 1. 6month + 1 month , always lead by 1 month .
		// if today > 140 , then 308 - 140 then should be 168d
		//if 0 , then 160-20d
		//if-ve then if -1 , then cover to 120-20 , until it is >-20 , convert to +ve.
		//if now is Nov then the down day should be up to Oct 1.
		//if now is jun , 6 month then just remove 1 month off
		//if now is mar , then discard all and just use 3 mths
		


Date mydate= new Date();
Calendar cal = Calendar.getInstance();
cal.setTime(mydate);

	
		int currday =0;
		// i want to find 6 month down but with 1 month spare.


    		String mysql =" select date,code,count(code) as no,fiftychg from data where fiftychg<=0 and  date>? group by code having no>=120"  ; 
    		PreparedStatement ps =
    		        con.prepareStatement(mysql);
    		
    	
    		
 
    		ps.setString(1,    		FormatUtil.getWorkDay(LocalDate.now(),160).toString()  );
    		//System.out.println("ok preparedStatement :    "+ps);	
    		
    		ResultSet rs = ps.executeQuery();
    		
    		boolean run =false;
    		String mysql1 ="INSERT INTO techstr (code,date ,fiftycount,mode) VALUES (?,?,?,10)"  ; 
    		PreparedStatement ps1 =
    		        con.prepareStatement(mysql1);
    		String date = cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-1"; // i just want save day as same , run this monthly , prevent this by running twice in 1 month , as run second will trigger constraint error
    		
    		 while(rs.next()){
    		    	run=true;
    					
    		    			
    		    		ps1.setString(1, rs.getString("code"));
    		    		ps1.setString(2, date);
    		    		ps1.setLong(3, rs.getLong("no") );
    					ps1.addBatch();
    		    		
    		    		
    		    		
    				}
    				if(run)ps1.executeBatch();
    				ps1.close();
    			
    			
    		
    		
    	    ps.close();
	
	}
	
	

	
		
	      
	
	
	
	
	
	
	
	public void run (){
		try {
			
			
			double percent=0.05;
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 String date=dateFormat.format( new Date());	
				System.out.println("1 ");
				
				
				 logger.info("DownSixMonthBelowFifty run 1");	
				
				 execute();
				
				//addData(percent,"2016-10-21");
				// addData(percent, new java.sql.Date(new java.util.Date().getTime())   );
				 
				 //test on one sheet firts 
				//sheet = workbook.getSheetAt(0);
				 //excel();
					
					//workbook.getNumberOfSheets()
					
				
				
					
					
					logger.info("DownSixMonthBelowFifty :   START COMMIT ");		
				 con.commit();
				 logger.info("DownSixMonthBelowFifty :   COMMIT OK !!!!");	
			
					

				
					
				 
				
			
				 logger.info(" DownSixMonthBelowFifty SUCCESS");
		
		     
			  
			   
				 
				 
			
			
		
			
			
		} catch (Exception e) {
			System.out.println("Error run "+e);
			 logger.severe("DownSixMonthBelowFifty Error run "+e);	
			 try {
				con.rollback();
			} catch (Exception e2) {
				System.out.println("Error rollback : "+e2);
				 logger.severe("DownSixMonthBelowFifty Error rollback : "+e2);	
				
			}
		}finally{
			try{
			
				con.close();  
				System.out.println("DownSixMonthBelowFifty finish closing]s :");
				
				 logger.info("DownSixMonthBelowFifty finish closing]s ");	
				 
			}catch (Exception e){
				System.out.println(" DownSixMonthBelowFifty error closing]s :"+e);
				logger.severe("ThreeMonthDownTrendStr finish closing]s error: " +e);	
			}
		}
	
	
	
	}
	
	
public static void main(String[] args) {

		
	new DownSixMonthBelowFifty().run();	    
		  
		  
		    
	
		        	
		        	
		        	
		        	
		   
		    
	

	
		
		
		  }
	
	
	
}



