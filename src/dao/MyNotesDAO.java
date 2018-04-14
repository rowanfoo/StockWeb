package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import access.MyNotesAccess;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MyNotesDAO extends DAO{

	

	
	
	public MyNotesDAO( Connection mycon ){
		con=mycon;
		
	}
	
	
	public void createNotes(MyNotesAccess obj)throws Exception {
		
		String mysql="	INSERT INTO mynotes (date, notes, code,mode) VALUES (?, ?, ?, ?)";
		PreparedStatement ps =
		        con.prepareStatement(mysql);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date=dateFormat.format(obj.getDate() );	
		
		ps.setString(1, date);
		ps.setString(2, obj.getNotes());
		ps.setString(3, obj.getCode());
		ps.setLong(4, obj.getMode());
	//	System.out.println("createNotesDAO SQL "+mysql  );
		ps.executeUpdate();
		
		
		ps.close();	
		
	}
	
	public ArrayList<MyNotesAccess> getNotesbyDate(String date,int mode)throws Exception {
		
		ArrayList<MyNotesAccess> arr = new ArrayList<MyNotesAccess>();
		
		String mysql="	select id,date,notes,code,mode from mynotes where date=?  and mode =?";
		PreparedStatement ps =
		        con.prepareStatement(mysql);
		


		ps.setString(1, date); 
		ps.setLong(2, (long)mode);
		System.out.println("getNotesbyDate SQL "+ps  );
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			MyNotesAccess acc = new MyNotesAccess (rs.getDate("date"),rs.getString("code"),rs.getString("notes"),(int)rs.getLong("mode"));
			acc.setId(rs.getLong("id"));
			arr.add(acc);
					

		}
		
		ps.close();	
		return arr;
		
	}
	
public ArrayList<MyNotesAccess> getAllNotesbyCode(String code)throws Exception {
		
		ArrayList<MyNotesAccess> arr = new ArrayList<MyNotesAccess>();
		
		String mysql="	select id,date,notes,code,mode from mynotes where code=? ";
		PreparedStatement ps =
		        con.prepareStatement(mysql);
		


		ps.setString(1, code); 
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			MyNotesAccess acc = new MyNotesAccess (rs.getDate("date"),rs.getString("code"),rs.getString("notes"),(int)rs.getLong("mode"));
			acc.setId(rs.getLong("id"));
			arr.add(acc);
					

		}
		
		ps.close();	
		return arr;
		
	}
	
	
	
	
//	public ArrayList<MyNotesAccess> getNotesbyWeek(int date,int mode)throws Exception {
	public ArrayList<MyNotesAccess> getNotesbyWeek(int mode)throws Exception {
			
		ArrayList<MyNotesAccess> arr = new ArrayList<MyNotesAccess>();
		
		//String mysql="	select id,date,notes,code,mode from mynotes where  WEEKOFYEAR(date) = ?  and mode =?";
		String mysql="	select id,date,notes,code,mode from mynotes where yearweek(`date`) = yearweek(curdate())  and mode =?";
		
		PreparedStatement ps =
		        con.prepareStatement(mysql);
		


		//ps.setInt(1, date); 
	//	ps.setLong(2, (long)mode);
		//System.out.println("getNotesbyDate SQL "+ps  );
		ps.setLong(1, (long)mode);
		System.out.println("getNotesbyWeek: "+ps);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			MyNotesAccess acc = new MyNotesAccess (rs.getDate("date"),rs.getString("code"),rs.getString("notes"),(int)rs.getLong("mode"));
			acc.setId(rs.getLong("id"));
			
			arr.add(acc);
					

		}
		
		ps.close();	
		return arr;
		
	}
	public void updateNotes(MyNotesAccess obj)throws Exception {
		
		String mysql="	update mynotes set notes=? where id=?";
		PreparedStatement ps =
		        con.prepareStatement(mysql);
		
		
		ps.setString(1, obj.getNotes());
		ps.setLong(2, obj.getId() );
		//System.out.println("createNotesDAO SQL "+ps  );
		ps.executeUpdate();
		
		
		ps.close();	
		
	}
	
	//try to get dates as rs.getString
	
	
	public void MyNotesDAO(MyNotesAccess obj)throws Exception {
	
	String mysql="	UPDATE mynotes SET Notes=?,OK=? WHERE  code=? and date=? and mode=?";
	PreparedStatement ps =
	        con.prepareStatement(mysql);
	/*
	ps.setString(1, obj.getNotes());
	ps.setString(2, obj.getOK());
	ps.setString(3, obj.getCode());
	ps.setString(4, obj.getDate().toString());
	ps.setInt(5, obj.getMode());
	System.out.println("Update SQL "+mysql  );
	ps.executeUpdate();
	
	*/
	ps.close();	
	}
	
	
	
	
}
