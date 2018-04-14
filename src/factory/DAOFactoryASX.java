package factory;


import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import access.AsxAccess;
import access.CategoryAccess;
import dao.AsxDAO;

public class DAOFactoryASX extends DAOFactoryBase{
	
	AsxDAO dao=null;   
	
	public DAOFactoryASX(){

		try {
		
			 dao= new AsxDAO(con);
		} catch (Exception e) {
			System.out.println("Error initialize DAOFactoryStock "+e);
			 logger.severe("DAOFactoryStock Error initialize:"+e);	 
			
		}
	}
	
	
	public ArrayList<AsxAccess> getByCategories(String category) throws Exception {
		return dao. getByCategories(category); 
	}
	
	public ArrayList<AsxAccess> getAllCategories() throws Exception {
		return dao.getAllCategories() ;
	}
	
	public ArrayList<AsxAccess > getRandom() throws Exception {
		return dao.getRandom();
	}
	public ArrayList<AsxAccess > getAllOk() throws Exception {
		return dao.getAllOk();
	}
	public void updateASX(AsxAccess obj)throws Exception {
		
		try {
			dao.updateASX(obj);
			con.commit();
			System.out.println("  DAOFactoryASX updateASX : OK !!");  
		
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			System.out.println("ERROR  DAOFactoryASX updateASX :"+e);  
			throw new Exception ("ERROR  DAOFactoryASX updateASX :"+e);	
		
		}
	
		
		
		
	}
	
	public ArrayList<AsxAccess > getAllLook() throws Exception {
		return dao.getAllLook();
	}
	
		
}