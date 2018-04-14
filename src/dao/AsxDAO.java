
package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import access.AccessObject;
import access.AsxAccess;

public class AsxDAO extends DAO{
	
	public AsxDAO( Connection mycon ){
		con=mycon;
		
	}
	
	public ArrayList<AsxAccess> getByCategories(String category) throws Exception {
		System.out.println("getByCategories");
		ArrayList<AsxAccess> arr = new ArrayList<AsxAccess>();

		String mysql = "	select * from asx where category=?";

		PreparedStatement ps = con.prepareStatement(mysql);

		ps.setString(1, category);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			
			arr.add(getAsxAcess(  rs));
		}

		ps.close();
		return arr;

	}

	public ArrayList<AsxAccess > getRandom() throws Exception {
		System.out.println("getRandom");
		ArrayList<AsxAccess> arr = new ArrayList<AsxAccess>();

		String mysql = "SELECT * FROM fortune.asx where ok is null";

		PreparedStatement ps = con.prepareStatement(mysql);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
				arr.add( getAsxAcess(  rs) );
		}

		ps.close();
		return arr;

	}
	
	public ArrayList<AsxAccess > getAllOk() throws Exception {

		ArrayList<AsxAccess> arr = new ArrayList<AsxAccess>();

		String mysql = "SELECT * FROM fortune.asx where ok is not  null";

		PreparedStatement ps = con.prepareStatement(mysql);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			
			arr.add( getAsxAcess(  rs) );
		}

		ps.close();
		return arr;

	}
	public ArrayList<AsxAccess > getAllLook() throws Exception {

		ArrayList<AsxAccess> arr = new ArrayList<AsxAccess>();

		String mysql = "SELECT * FROM fortune.asx where ok='Y'";

		PreparedStatement ps = con.prepareStatement(mysql);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			
			arr.add( getAsxAcess(  rs) );
		}

		ps.close();
		return arr;

	}
	
	public ArrayList<AsxAccess> getAllCategories() throws Exception {

		ArrayList<AsxAccess> arr = new ArrayList<AsxAccess>();
		String mysql = "	select * from asx where category=?";

		PreparedStatement ps = con.prepareStatement(mysql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			
			arr.add(getAsxAcess(  rs));
		}

		ps.close();
		return arr;

	}


	public void updateASX(AsxAccess obj)throws Exception {
		String mysql="UPDATE asx SET notes=?, OK=?,date=? WHERE code=?";
		
		PreparedStatement ps =
		        con.prepareStatement(mysql);
		
		ps.setString(1, obj.getNotes() );
		ps.setString(2,obj.getOk());
		ps.setString(3, LocalDate.now().toString());
		ps.setString(4, obj.getCode() );
		
		System.out.println("AsxDAO updateASX "+ps  );
		ps.executeUpdate();
		
		
		ps.close();	
	}
	
	
	
	
	
	

	

	private AsxAccess getAsxAcess( ResultSet rs)throws Exception{
		return new AsxAccess(rs.getString("code"), rs.getDate("date") ,rs.getString("category"),rs.getString("name"), rs.getString("notes"), rs.getString("ok"),rs.getInt("id"));
	}
	
	
	
}
