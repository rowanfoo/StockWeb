package factory;

import access.CategoryAccess;
import dao.CategoryDAO;
import dao.StockDAO;

import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;

public class DAOFactoryCategory extends DAOFactoryBase{
	
	CategoryDAO dao=null;   
	
	public DAOFactoryCategory(){

		try {
		
			 dao= new CategoryDAO(con);
		} catch (Exception e) {
			System.out.println("Error initialize DAOFactoryStock "+e);
			 logger.severe("DAOFactoryStock Error initialize:"+e);	 
			
		}
	}
	
	
	public ArrayList<String>  getAllCategory()throws Exception {
		ArrayList <String> arr = new ArrayList<String> ();
		try(Statement stmt=				 con.createStatement();  	){
			String mysql="select * from category ";	
			ResultSet rs =stmt.executeQuery(mysql);
			
			while(rs.next()){
				arr.add(rs.getString("name"));
			}
			
			
			
			
			
		}catch(Exception e){
			System.out.println("DAOFactoryCategory getAllCategory:"+e);
		}
		return arr;

	
	}
	
	public ArrayList<String>  getAllCategoryASX()throws Exception {
		ArrayList <String> arr = new ArrayList<String> ();
		try(Statement stmt=				 con.createStatement();  	){
			String mysql="SELECT DISTINCT category FROM asx where category <>'Not Applic'";	
			ResultSet rs =stmt.executeQuery(mysql);
			
			while(rs.next()){
				arr.add(rs.getString("name"));
			}
			
			
			
			
			
		}catch(Exception e){
			System.out.println("DAOFactoryCategory getAllCategoryASX:"+e);
		}
		return arr;

	
	}
	
	
	
	
	public ArrayList<CategoryAccess>  getCategories()throws Exception {
		return dao.getCategories();

	
	}

}
