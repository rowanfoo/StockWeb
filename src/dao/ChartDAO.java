package dao;





import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import access.ChartAccess;

import access.StockAccess;
import util.FormatUtil;


public class ChartDAO extends DAO{
	
	

	
	public ChartDAO( Connection mycon ){
		con=mycon;
		
	}
	 		

	
	private ChartAccess getChartAccess(ResultSet rs)throws Exception {
	
		while(rs.next()){
			return new ChartAccess(rs.getString("code"),rs.getDate("date"),rs.getString("year10"),rs.getString("year5"),rs.getString("year3"),rs.getString("year1"), 
					rs.getString("yearhalf"),rs.getString("year10notes"),rs.getString("year5notes"), rs.getString("year3notes"),rs.getString("year1notes"),rs.getString("yearhalfnotes"));
		
	      }
		return null;

	}

	public ChartAccess getChart(String code) throws Exception {

		String mysql = "SELECT * FROM fortune.chart where code=?";

		PreparedStatement ps = con.prepareStatement(mysql);

		ps.setString(1, code);
		System.out.println(" getChart : "+ps);
		
		ResultSet rs = ps.executeQuery();
		StockAccess stock = null;
		ChartAccess a= getChartAccess(rs);
		ps.close();
		return a;
	}
	


	
	public void insertNewRecord(ChartAccess obj) throws Exception {

		String mysql = "INSERT INTO chart (code,date)VALUES(?,?)";
		System.out.println("insertNewRecord : "  );
		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1, obj.getCode());
		ps.setString(2, obj.changeStringToDate());
		//System.out.println("insertNewRecord sql : "+ps  );
		ps.executeUpdate();
			
		System.out.println("insertNewRecord : finish "  );
		ps.close();

	}	


	public void insertChartYear10(ChartAccess obj) throws Exception {

		String mysql = "INSERT INTO news (code,date,year10,year10notes)VALUES(?,?,?,?)";
		System.out.println("insertChartYear10 : "  );
		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1, obj.getCode());
		ps.setString(2, obj.changeStringToDate());
		ps.setString(3, obj.getYear10() );
		ps.setString(4, obj.getYear10notes() );

		ps.executeUpdate();
			
		System.out.println("insertChartYear10 : finish "  );
		ps.close();

	}	

	public void updateAll(ChartAccess obj) throws Exception {
		 
		String mysql = "update chart set year10=?,year5=?,year3=?,year1=?,yearhalf=?,year10notes=?,year5notes=?,year3notes=?,year1notes=?,yearhalfnotes=? ,date=? WHERE code=?";
		System.out.println("updateAll : "  );
		PreparedStatement ps = con.prepareStatement(mysql);
		
		ps.setString(1, obj.getYear10() );
		ps.setString(2, obj.getYear5() );
		ps.setString(3, obj.getYear3() );
		ps.setString(4, obj.getYear1() );
		ps.setString(5, obj.getYearhalf() );
		ps.setString(6, obj.getYear10notes() );
		ps.setString(7, obj.getYear5notes() );
		ps.setString(8, obj.getYear3notes() );
		ps.setString(9, obj.getYear1notes() );
		ps.setString(10, obj.getYearhalfnotes() );
		ps.setString(11, FormatUtil.convertDateToString(new Date()));
		
		ps.setString(12, obj.getCode());
		///System.out.println("updateAll : "+ps  );
		ps.executeUpdate();
			
		System.out.println("updateAll : finish "  );
		ps.close();

	}	
	
	
	
	public void insertChartYear5(ChartAccess obj) throws Exception {

		String mysql = "INSERT INTO news (code,date,year5,year5notes)VALUES(?,?,?,?)";
		System.out.println("insertChartYear5 : "  );
		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1, obj.getCode());
		ps.setString(2, obj.changeStringToDate());
		ps.setString(3, obj.getYear5() );
		ps.setString(4, obj.getYear5notes() );

		ps.executeUpdate();
			
		System.out.println("insertChartYear10 : finish "  );
		ps.close();

	}	
	
	public void insertChartYear3(ChartAccess obj) throws Exception {

		String mysql = "INSERT INTO news (code,date,year3,year3notes)VALUES(?,?,?,?)";
		System.out.println("insertChartYear3 : "  );
		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1, obj.getCode());
		ps.setString(2, obj.changeStringToDate());
		ps.setString(3, obj.getYear3() );
		ps.setString(4, obj.getYear3notes() );

		ps.executeUpdate();
			
		System.out.println("insertChartYear10 : finish "  );
		ps.close();

	}	
	
	public void insertChartYear1(ChartAccess obj) throws Exception {

		String mysql = "INSERT INTO news (code,date,year1,year1notes)VALUES(?,?,?,?)";
		System.out.println("insertChartYear1 : "  );
		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1, obj.getCode());
		ps.setString(2, obj.changeStringToDate());
		ps.setString(3, obj.getYear1() );
		ps.setString(4, obj.getYear1notes() );

		ps.executeUpdate();
			
		System.out.println("insertChartYear10 : finish "  );
		ps.close();

	}	

	public void insertChartHalfYear(ChartAccess obj) throws Exception {

		String mysql = "INSERT INTO news (code,date,yearhalf,yearhalfnotes)VALUES(?,?,?,?)";
		System.out.println("insertChartHalfYear : "  );
		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1, obj.getCode());
		ps.setString(2, obj.changeStringToDate());
		ps.setString(3, obj.getYearhalf() );
		ps.setString(4, obj.getYearhalfnotes() );

		ps.executeUpdate();
			
		System.out.println("insertChartHalfYear : finish "  );
		ps.close();

	}	
	


	
	

	

	
	



	
	
	
	
}
