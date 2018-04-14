package dao;



	import java.sql.Connection;
	import java.sql.PreparedStatement;

	import access.CategoryAccess;

	import java.text.DateFormat;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.sql.ResultSet;
	import java.util.ArrayList;

	public class CategoryDAO extends DAO{
		
		public CategoryDAO( Connection mycon ){
			con=mycon;
			
		}
		
		public ArrayList<CategoryAccess> getCategories()throws Exception {
			
			ArrayList<CategoryAccess> arr = new ArrayList<CategoryAccess>();
			
			String mysql="	select id,name from category";
			
			PreparedStatement ps =
			        con.prepareStatement(mysql);
		
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				CategoryAccess acc = new CategoryAccess (rs.getLong("id"),rs.getString("name"));
				arr.add(acc);
						

			}
			
			ps.close();	
			return arr;
			
		}

	
	
	}
