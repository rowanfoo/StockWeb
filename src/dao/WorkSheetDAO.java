
package dao;





import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.logging.Logger;



import util.ExcelLogger;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.PreparedStatement;

import access.DataAccess;
import access.NewsAccess;
import access.StockAccess;
import access.WorkSheetAccess;

import java.util.Hashtable;


public class WorkSheetDAO extends DAO{
	
	

	
	public WorkSheetDAO( Connection mycon ){
		con=mycon;
		
	}
	 		


	public ArrayList<WorkSheetAccess> getWorkSheetByDate(String date) throws Exception {
		ArrayList<WorkSheetAccess> arr = new ArrayList<WorkSheetAccess>();
		String mysql = "SELECT * FROM fortune.worksheet where date=? ";

		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1, date);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			arr.add(getWorkSheet(rs));

		}
		ps.close();

		return arr;

	}
	
	
	private WorkSheetAccess getWorkSheet (ResultSet rs)throws Exception {
		return new WorkSheetAccess(rs.getString("code") ,rs.getDate("date"), rs.getString("time"),  rs.getString("reason"),rs.getDouble("buy"), rs.getDouble("stopLoss"), rs.getString("edate"), rs.getString("trend"), rs.getString("volatiles"),
				rs.getString("panic"), rs.getString("discounted"), rs.getString("multiMonth"), rs.getString("majorSupport"), rs.getString("meanRevision"),
				rs.getString("changeTrend"), rs.getString("sellergain"), rs.getString("Yes"));
	}
	
	public ArrayList<WorkSheetAccess> getWorkSheetByWeek(int date) throws Exception {
		ArrayList<WorkSheetAccess> arr = new ArrayList<WorkSheetAccess>();
		String mysql = "SELECT * FROM fortune.worksheet where  WEEKOFYEAR(date) = ? ";

		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setInt(1, date);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			arr.add(getWorkSheet(rs));

		}
		ps.close();

		return arr;

	}
	
	







	public void createWorkSheet(WorkSheetAccess obj) throws Exception {

		String mysql = "INSERT INTO worksheet(code,date,time,reason,Yes,buy,stopLoss,edate,trend,volatiles,panic,discounted,multiMonth,majorSupport,meanRevision,changeTrend,sellergain)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


		System.out.println("conc:"+con);

		PreparedStatement ps = con.prepareStatement(mysql);
		System.out.println("conc:"+ps);


			ps.setString(1, obj.getCode());
			ps.setString(2, obj.changeStringToDate());

			ps.setString(3, obj.getTime() );
			ps.setString(4, obj.getReason() );
			ps.setString(5, obj.getYes())  ;

			ps.setDouble(6, obj.getBuy());
			ps.setDouble(7, obj.getStopLoss());
			
			ps.setString(8, obj.getEdate() );
			ps.setString(9, obj.getTrend() );

			ps.setString(10, obj.getVolatiles()  );
			ps.setString(11, obj.getPanic() );
			ps.setString(12, obj.getDiscounted()  );

			ps.setString(13, obj.getMultiMonth() );
			ps.setString(14, obj.getMajorSupport() );
			ps.setString(15, obj.getMeanRevision() );
			

			ps.setString(16, obj.getChangeTrend() );
			ps.setString(17, obj.getSellergain() );
			System.out.println("createWorkSheet : "+ps);
			ps.executeUpdate();
			

			ps.close();

	}	
	
	public void updateWorkSheet(WorkSheetAccess obj) throws Exception {

		String mysql = "update worksheet set time=?,reason=?,Yes=?,buy=?,stopLoss=?,edate=?,trend=?,volatiles=?,panic=?,discounted=?,multiMonth=?,majorSupport=?,meanRevision=?,changeTrend=?,sellergain=? where code= and date=?";


		

		PreparedStatement ps = con.prepareStatement(mysql);



			ps.setString(1, obj.getTime() );
			ps.setString(2, obj.getReason() );
			ps.setString(3, obj.getYes() );

			ps.setDouble(4, obj.getBuy());
			ps.setDouble(5, obj.getStopLoss());
			
			ps.setString(6, obj.getEdate() );
			ps.setString(7, obj.getTrend() );

			ps.setString(8, obj.getVolatiles()  );
			ps.setString(9, obj.getPanic() );
			ps.setString(10, obj.getDiscounted()  );

			ps.setString(11, obj.getMultiMonth() );
			ps.setString(12, obj.getMajorSupport() );
			ps.setString(13, obj.getMeanRevision() );
			

			ps.setString(14, obj.getChangeTrend() );
			ps.setString(15, obj.getSellergain() );

			
			ps.setString(16, obj.getCode());
			ps.setString(17, obj.changeStringToDate());

			
			ps.executeUpdate();
			

			ps.close();

	}	
	

	

	

	
	



	
	
	
	
	
	
	
}
