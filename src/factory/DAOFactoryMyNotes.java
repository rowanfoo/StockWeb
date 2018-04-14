package factory;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.temporal.WeekFields;

import dao.Database;
import util.ExcelLogger;


import java.sql.Connection;
import java.util.logging.Logger;



import access.MyNotesAccess;
import access.StockAccess;
import dao.MyNotesDAO;


import java.util.ArrayList;

import java.util.Hashtable;
import java.util.Locale;
public class DAOFactoryMyNotes extends DAOFactoryBase{
	MyNotesDAO dao=null;   
	
	public DAOFactoryMyNotes(){

		try {
		
			 dao= new MyNotesDAO(con);
		} catch (Exception e) {
			System.out.println("Error initialize DAOFactoryStock "+e);
			 logger.severe("DAOFactoryStock Error initialize:"+e);	 
			
		}
	}

	
	
	public void  createNotes(MyNotesAccess obj)throws Exception {
		try {
			dao.createNotes(obj);
			con.commit();
			
		
		} catch (Exception e) {
			
			
			try {
				con.rollback();
			} catch (Exception e2) {
				System.out.println("ERROR  DAOFactoryMyNotes createNotes cannot rollback :"+e2);  
			}
			System.out.println("ERROR  DAOFactoryMyNotes createNotes :"+e);  
			throw new Exception ("ERROR  DAOFactoryMyNotes createNotes :"+e);	
		
		}
	
	}
	
	public ArrayList<MyNotesAccess> getNotesbyDate(String date,int mode)throws Exception {
		return dao.getNotesbyDate(date, mode);
	}
	
	
	
	public ArrayList<MyNotesAccess> getAllNotesbyCode(String code)throws Exception  {
		return dao.getAllNotesbyCode(code);
	}
		
		
		
		
//	public ArrayList<MyNotesAccess> getNotesbyWeek(String date,int mode)throws Exception {
	public ArrayList<MyNotesAccess> getNotesbyWeek(int mode)throws Exception {
			
		    
		//LocalDate week = LocalDate.parse(date);
	//	WeekFields weekFields = WeekFields.of(Locale.getDefault()); 
	//	int weekNumber = week.get(weekFields.weekOfWeekBasedYear());
		
		//return dao.getNotesbyWeek(weekNumber, mode);
		return dao.getNotesbyWeek( mode);
		
		
		
	}
	
	public void updateNotes(MyNotesAccess obj)throws Exception {
		try {
			dao.updateNotes(obj);
			con.commit();
			
		
		} catch (Exception e) {
			
			
			try {
				con.rollback();
			} catch (Exception e2) {
				System.out.println("ERROR  DAOFactoryMyNotes updateNotes cannot rollback :"+e2);  
			}
			System.out.println("ERROR  DAOFactoryMyNotes updateNotes :"+e);  
			throw new Exception ("ERROR  DAOFactoryMyNotes updateNotes :"+e);	
		
		}
		
		
		
	}	
	
}
