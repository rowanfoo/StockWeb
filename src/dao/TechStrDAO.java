package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.logging.Logger;

import access.DataAccess;
import access.StockAccess;
import access.TechStrAccess;
import util.ExcelLogger;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.sql.PreparedStatement;


import access.TechStrAccess;

public class TechStrDAO extends DAO {
	
	
	public TechStrDAO( Connection mycon ){
		con=mycon;
		
	}
	
	public ArrayList <TechStrAccess>   getTechStrListByMonthMode(int  month)throws Exception{
		ArrayList <TechStrAccess> arr = new ArrayList();
		String mysql="";
		mysql ="SELECT tech_techstr.code,tech_techstr.date,mode,name,close,fifty,fiftychg,volume,threemthvol,changePercent,seen,OK,Notes,fiftycount,lowlow,sixMonthPrice,twohundredchg,open " +
				" FROM tech.tech_techstr join core_stock on stock.code= tech_techstr.code and Month(tech_techstr.date)=? and mode in(8,10,12,18)";
			 
		PreparedStatement ps =
		        con.prepareStatement(mysql);
			ps.setInt(1, month);
		//System.out.println("sql:"+ps);
		
		ResultSet rs = ps.executeQuery();
		
		 while(rs.next()){
			
			 arr.add(   getTechStrAccess(rs)            );

	    	 	 
	    	  
	      }
		ps.close();	
		Collections.sort(arr, new Comparator<TechStrAccess>() {
	        @Override
	        public int compare(TechStrAccess fr2, TechStrAccess fr1)
	        {

	            return (int) (fr2.getMode() - fr1.getMode());

	        }
	    });

	return arr;
	
	
	}
	
	
	
	
	
	public ArrayList <TechStrAccess>   getTechStrListBySql(String sql,int mode)throws Exception{
		ArrayList <TechStrAccess> arr = new ArrayList();
		String mysql="";
		//System.out.println("getTechStrListBySql:"+sql);
		if (mode==0){
		mysql="SELECT tech_techstr.code,tech_techstr.date,mode,name,close,fifty,fiftychg,volume,threemthvol,changePercent,seen,OK,Notes,fiftycount,top,lowlow,sixMonthPrice,twohundredchg,open "+
			 "FROM tech_techstr join core_stock on stock.code= tech_techstr.code "+
			 " where top in('50','100','200','300','top0.5b','top1b') and "+sql;
		}else{
			mysql="SELECT tech_techstr.code,tech_techstr.date,mode,name,close,fifty,fiftychg,volume,threemthvol,changePercent,seen,OK,Notes,fiftycount,top,lowlow,sixMonthPrice,twohundredchg,open  "+
					 "FROM tech_techstr join core_stock on stock.code= tech_techstr.code "+
					 " where top in('50','100','200','300','top0.5b','top1b') and tech_techstr.mode=? and "+sql;
					
		}
		
		
		
		PreparedStatement ps =
		        con.prepareStatement(mysql);
		if (mode!=0)ps.setInt(1, mode);
		//System.out.println("sql:"+ps);
		
		ResultSet rs = ps.executeQuery();
		
		 while(rs.next()){
			
			 arr.add(   getTechStrAccess(rs)            );

	    	 	 
	    	  
	      }
		ps.close();	
		Collections.sort(arr, new Comparator<TechStrAccess>() {
	        @Override
	        public int compare(TechStrAccess fr2, TechStrAccess fr1)
	        {

	            return (int) (fr2.getMode() - fr1.getMode());

	        }
	    });

	return arr;
	
	
	}
	
	
	
	
	private TechStrAccess getTechStrAccess(ResultSet rs)throws Exception {
		return   new TechStrAccess (rs.getString("code"),rs.getDate("date"),rs.getString("name"),rs.getInt("mode") ,rs.getDouble("close"),rs.getDouble("fifty"),rs.getDouble("fiftychg"),rs.getLong("volume") ,rs.getDouble("threemthvol")  ,rs.getDouble("changePercent"),
				 rs.getString("seen"),rs.getString("OK"),rs.getString("Notes"),rs.getInt("fiftycount"),rs.getString("lowlow") ,rs.getDouble("sixMonthPrice")  ,rs.getDouble("twohundredchg") ,rs.getDouble("open")            ) ;
	}
	
	
	public ArrayList <TechStrAccess>   getTechStrListByDate(String code,String date)throws Exception{
		ArrayList <TechStrAccess> arr = new ArrayList();
		String mysql="";
		if(code == null)mysql ="SELECT tech_techstr.code,tech_techstr.date,mode,name,close,fifty,fiftychg,volume,threemthvol,changePercent,seen,OK,Notes,fiftycount," +
					" lowlow,sixMonthPrice,twohundredchg,open FROM tech_techstr join core_stock on stock.code= tech_techstr.code and tech_techstr.date=?"  ;
		else mysql ="SELECT tech_techstr.code,tech_techstr.date,mode,name,close,fifty,fiftychg,volume,threemthvol,changePercent,seen,OK,Notes,fiftycount,lowlow,sixMonthPrice," +
				" twohundredchg,open FROM tech_techstr join core_stock on stock.code= tech_techstr.code and tech_techstr.date=? and tech_techstr.code=? "  ;

			 
		//System.out.println("111sql:"+mysql);
		PreparedStatement ps =
		        con.prepareStatement(mysql);
		if(code == null)	ps.setString(1, date);
		else {
			ps.setString(1, code);
			ps.setString(2, date);
		}
	//	System.out.println("sql:"+ps);
		
		ResultSet rs = ps.executeQuery();
		
		 while(rs.next()){
			
			 arr.add(  getTechStrAccess(rs)        );

	    	 	 
	    	  
	      }
		ps.close();	
		System.out.println("iam SORTING");

		Collections.sort(arr, new Comparator<TechStrAccess>() {
		        @Override
		        public int compare(TechStrAccess fr2, TechStrAccess fr1)
		        {

		            return (int) (fr2.getMode() - fr1.getMode());

		        }
		    });
		
	return arr;
	
	
	}
	
	public ArrayList <TechStrAccess>   getTechStrListByWeek(int weekno)throws Exception{
		ArrayList<TechStrAccess> arr = new ArrayList<TechStrAccess> ();
		String mysql = "";
		mysql = "SELECT tech_techstr.code,tech_techstr.date,mode,name,close,fifty,fiftychg,volume,threemthvol,changePercent,seen,OK,Notes,fiftycount,lowlow,sixMonthPrice," +
				"twohundredchg,open FROM tech_techstr join core_stock on core_stock.code= tech_techstr.code and "
				+ "week(tech_techstr.date) = ? group by mode,code";

		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setInt(1, weekno);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			arr.add(getTechStrAccess(rs));

		}
		ps.close();


		return arr;

	}

	
	public ArrayList <TechStrAccess>   getTechStrListByMonth(int month)throws Exception{
		ArrayList<TechStrAccess> arr = new ArrayList<TechStrAccess> ();
		String mysql = "";
		mysql = "SELECT tech_techstr.code,tech_techstr.date,mode,name,close,fifty,fiftychg,volume,threemthvol,changePercent,seen,OK,Notes,fiftycount,lowlow,sixMonthPrice,twohundredchg," +
				" open FROM tech_techstr join core_stock on core_stock.code= tech_techstr.code and "
				+ "month(tech_techstr.date) = ? group by mode,code";

		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setInt(1, month);
		 System.out.println("WeekModeAction  getTechStrListByMonth : "+ps); 
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			arr.add(getTechStrAccess(rs));

		}
		ps.close();


		return arr;

	}
	
	
	
	
	
	
	public ArrayList <TechStrAccess>   getTechStrListByDate(String code,String date,int mode)throws Exception{
		ArrayList <TechStrAccess> arr = new ArrayList();
		String mysql="";
		if(code == null)mysql ="SELECT tech_techstr.code,tech_techstr.date,mode,name,close,fifty,fiftychg,volume,threemthvol,changePercent,seen,OK,Notes," +
				"fiftycount,lowlow,sixMonthPrice,twohundredchg,open FROM tech_techstr join core_stock on core_stock.code= tech_techstr.code and tech_techstr.date=? and mode=?"  ;
		else mysql ="SELECT tech_techstr.code,tech_techstr.date,mode,name,close,fifty,fiftychg,volume,threemthvol,changePercent,seen,OK,Notes,fiftycount," +
				" lowlow,sixMonthPrice,twohundredchg,open FROM tech_techstr join core_stock on core_stock.code= tech_techstr.code and tech_techstr.date=? and tech_techstr.code=? and mode=? "  ;

			 
		//System.out.println("111sql:"+mysql);
		PreparedStatement ps =
		        con.prepareStatement(mysql);
		if(code == null){
			ps.setString(1, date);
			ps.setInt(2, mode);
		}else {
			ps.setString(1, code);
			ps.setString(2, date);
			ps.setInt(3, mode);
		}
		 System.out.println("TechStrDAO  getTechStrListByDate sql:"+ps);
		
		ResultSet rs = ps.executeQuery();
		
		 while(rs.next()){
			
			 arr.add(  getTechStrAccess(rs)      );

	    	 	 
	    	  
	      }
		ps.close();	
	return arr;
	
	
	}
	
	public ArrayList <TechStrAccess>   getTechStrListByTop300ByDate(String mode,  String date)throws Exception{
		ArrayList <TechStrAccess> arr = new ArrayList<TechStrAccess> ();
		System.out.println("------------>getTechStrListByTop300ByDate");
		String mysql="";
		if(mode.equals("Top 100-300")){
			mysql="SELECT tech_techstr.code,tech_techstr.date,mode,name,close,fifty,fiftychg,volume,threemthvol,changePercent,seen,OK,Notes,fiftycount,top,lowlow,sixMonthPrice,twohundredchg,open "+
			 "FROM tech_techstr join core_stock" +
					" on core_stock.code= tech_techstr.code "+
			 " where top in('50','100','200','300','top0.5b','top1b') and tech_techstr.date=?";
		}else if(mode.equals("Top Others")){	
		
			mysql="SELECT tech_techstr.code,tech_techstr.date,mode,name,close,fifty,fiftychg,volume,threemthvol,changePercent,seen,OK,Notes,fiftycount,top,lowlow,sixMonthPrice,twohundredchg,open "+
				  "FROM tech_techstr join core_stock on core_stock.code= tech_techstr.code "+
				  " where top not in('50','100','200','300','top0.5b','top1b') and tech_techstr.date=?";
				
		}

	//	System.out.println("111sql:"+date);
		//System.out.println("222sql:"+mode);
		PreparedStatement ps =
		        con.prepareStatement(mysql);
			ps.setString(1, date);
	//	System.out.println("sql:"+ps);
		
		ResultSet rs = ps.executeQuery();
		
		 while(rs.next()){
		//	 System.out.println("sql :"+rs.getString("code"));
			 TechStrAccess str = getTechStrAccess(rs)     ;
			 
			 
			 StockAccess st = new StockAccess();
			 st.setTop(rs.getString("top"));
			 str.setStock(st);

			 arr.add( str);
					 
	    	  
	      }
			Collections.sort(arr, new Comparator<TechStrAccess>() {
		        @Override
		        public int compare(TechStrAccess fr2, TechStrAccess fr1)
		        {

		            return (int) (fr2.getMode() - fr1.getMode());

		        }
		    });
		
		 
		ps.close();	
			return arr;
	
	
	}
	
	public ArrayList <TechStrAccess>   getTechStrListByPanic()throws Exception{
		ArrayList <TechStrAccess> arr = new ArrayList<TechStrAccess> ();
		String mysql="";
			mysql="SELECT tech_techstr.code,tech_techstr.date,mode,name,close,fifty,fiftychg,volume,threemthvol,changePercent,seen,OK,Notes,fiftycount,top,lowlow,sixMonthPrice,twohundredchg,open "+
					" FROM tech_techstr join core_stock on core_stock.code= tech_techstr.code "+
					 " where mode in (2,3,5,6,9,13,14,20,21,23,24,27,28,29) and tech_techstr.date=curdate()";
	
		PreparedStatement ps =
		        con.prepareStatement(mysql);
		ResultSet rs = ps.executeQuery();
		
		 while(rs.next()){
			 TechStrAccess str = getTechStrAccess(rs)     ;
			 
			 
			 StockAccess st = new StockAccess();
			 str.setStock(st);
			 arr.add( str);
	      }
			Collections.sort(arr, new Comparator<TechStrAccess>() {
		        @Override
		        public int compare(TechStrAccess fr2, TechStrAccess fr1)
		        {

		            return (int) (fr2.getMode() - fr1.getMode());

		        }
		    });
		ps.close();	
			return arr;
	
	}
	
	
	public ArrayList <TechStrAccess>   getTechStrListByMode(int mode)throws Exception{
		ArrayList <TechStrAccess> arr = new ArrayList();
		String mysql="SELECT tech_techstr.code,tech_techstr.date,mode,name,close,fifty,fiftychg,volume,threemthvol,changePercent,seen,OK,Notes,fiftycount,lowlow," +
				" sixMonthPrice,twohundredchg,open FROM tech_techstr  join core_stock on core_stock.code= tech_techstr.code and mode=?"  ;

			 
		//System.out.println("111sql:"+mysql);
		PreparedStatement ps =
		        con.prepareStatement(mysql);
				ps.setInt(1, mode);
		
		//System.out.println("sql:"+ps);
		
		ResultSet rs = ps.executeQuery();
		
		 while(rs.next()){
			
			 arr.add(  getTechStrAccess(rs)      );

	    	 	 
	    	  
	      }
		ps.close();	
	return arr;
	
	
	}

	
	
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
	
	
	
	/**
	 * this used , when user refreshes , start import of special mode , want to get the latest
	 * So if there is already data , done at begining of month , if user try to refresh he will get primary key constraint
	 * so he need to delete old data for this month , and restart import to get new data.
	 * @throws Exception
	 */
	public void deleteThisMonthTechStrListByMonthMode() throws Exception {
		String mysql = "delete from tech_techstr where  Month(tech_techstr.date)=? and mode in(8,10,12,18)";

		PreparedStatement ps = con.prepareStatement(mysql);

		ps.setInt(1, LocalDate.now().getMonthValue());

		System.out.println("sql:" + ps);
		ps.executeUpdate();
		ps.close();

	}	 
	
	/**
	 * Used at httpnow data . get and import data now, have to refresh , so got to delete data now , if not get primary key constraint
	 * @throws Exception
	 */
	public void deleteTodayDate()throws Exception {
		
		
		
		String mysql="delete from tech_techstr where date=curdate()";
		
	
		
		
		
		PreparedStatement ps =
		        con.prepareStatement(mysql);
		System.out.println("deleteTodayDate SQL "+mysql  );
		ps.executeUpdate();
		
		
		ps.close();	
	}
	

	


	
	
	
	
	
	
}
