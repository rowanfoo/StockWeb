package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import access.ChartResAccess;
import util.FormatUtil;

public class ChartResDAO extends ChartDAO {

	public ChartResDAO(Connection mycon) {
		super(mycon);
		
	}
	
	
	
	private ChartResAccess getChartAccess(ResultSet rs)throws Exception {
		
		while(rs.next()){
			return new ChartResAccess(rs.getString("code"),rs.getDate("date"),rs.getString("year10"),rs.getString("year5"),rs.getString("year3"),rs.getString("year1"), 
					rs.getString("yearhalf"),rs.getString("year10notes"),rs.getString("year5notes"), rs.getString("year3notes"),rs.getString("year1notes"),rs.getString("yearhalfnotes"),rs.getString("category") );
		
	      }
		return null;

	}
	
	private ArrayList<ChartResAccess> getAllChartAccess(ResultSet rs)throws Exception {
		 ArrayList<ChartResAccess> arr = new  ArrayList<>();
		while(rs.next()){
			arr.add(new ChartResAccess(rs.getString("code"),rs.getDate("date"),rs.getString("year10"),rs.getString("year5"),rs.getString("year3"),rs.getString("year1"), 
					rs.getString("yearhalf"),rs.getString("year10notes"),rs.getString("year5notes"), rs.getString("year3notes"),rs.getString("year1notes"),rs.getString("yearhalfnotes"),rs.getString("category") ));
		
	      }
		return arr;

	}

	public ArrayList<ChartResAccess> getChartbyCode(String code) throws Exception {

		String mysql = "SELECT * FROM fortune.chartres where code=?";

		PreparedStatement ps = con.prepareStatement(mysql);

		ps.setString(1, code);
		System.out.println(" ChartResDAO getAllChart : "+ps);
		
		ResultSet rs = ps.executeQuery();
		 ArrayList<ChartResAccess>a=  getAllChartAccess(rs);
		ps.close();
		return a;
	}
	public ChartResAccess getChart(String code,String category) throws Exception {

		String mysql = "SELECT * FROM fortune.chartres where code=? and category=?";

		PreparedStatement ps = con.prepareStatement(mysql);

		ps.setString(1, code);
		ps.setString(2, category);
		System.out.println(" ChartResDAO getChartByCategory : "+ps);
		
		ResultSet rs = ps.executeQuery();
		ChartResAccess a= getChartAccess(rs);
		ps.close();
		return a;
	}
	public ArrayList<ChartResAccess> getCategory(String category) throws Exception {

		String mysql = "SELECT * FROM fortune.chartres where category=?";

		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1, category);
		System.out.println(" ChartResDAO getCategory : "+ps);
		
		ResultSet rs = ps.executeQuery();
		 ArrayList<ChartResAccess>a=  getAllChartAccess(rs);
		ps.close();
		return a;
	}
	
	public void updateAll(ChartResAccess obj) throws Exception {
		 
		String mysql = "update chartres set year10=?,year5=?,year3=?,year1=?,yearhalf=?,year10notes=?,year5notes=?,year3notes=?,year1notes=?,yearhalfnotes=? ,date=? WHERE code=? and category=?";
		System.out.println("ChartResDAO updateAll : "  );
		System.out.println("ChartResDAO updateAll code: "+obj.getCode()  );

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
		ps.setString(13, obj.getCategory());
		
		System.out.println("updateAll : "+ps  );
		ps.executeUpdate();
			
		System.out.println("ChartResDAO updateAll : finish "  );
		ps.close();

	}	
	public void insertNewRecord(ChartResAccess obj) throws Exception {

		String mysql = "INSERT INTO chartres (code,date,category)VALUES(?,?,?)";
		System.out.println("insertNewRecord ChartResDAO: "  );
		
		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1, obj.getCode());
		ps.setString(2, obj.changeStringToDate());
		ps.setString(3, obj.getCategory() );
		
		System.out.println("insertNewRecord sql : "+ps  );
		ps.executeUpdate();
			
		System.out.println("insertNewRecord : finish "  );
		ps.close();

	}	


	
	
	

}
