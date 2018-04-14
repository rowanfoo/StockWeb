
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
import access.WorkSheetAccess;
import dao.MyNotesDAO;
import dao.WorkSheetDAO;

import java.util.ArrayList;

import java.util.Hashtable;
import java.util.Locale;
public class DAOFactoryWorkSheet extends DAOFactoryBase{
	WorkSheetDAO dao=null;   
	
	public DAOFactoryWorkSheet(){

		try {
		
			 dao= new WorkSheetDAO(con);
		} catch (Exception e) {
			System.out.println("Error initialize DAOFactoryStock "+e);
			 logger.severe("DAOFactoryWorkSheet Error initialize:"+e);	 
			
		}
	}

	
	

	public void  createWorkSheet(WorkSheetAccess obj) throws Exception {
		try {
			dao.createWorkSheet(obj);
			con.commit();
			
		
		} catch (Exception e) {
			
			
			try {
				con.rollback();
			} catch (Exception e2) {
				System.out.println("ERROR  DAOFactoryWorkSheet createWorkSheet cannot rollback :"+e2);  
			}
			System.out.println("ERROR  DAOFactoryWorkSheet createWorkSheet :"+e);  
			throw new Exception ("ERROR  DAOFactoryWorkSheet createWorkSheet :"+e);	
		
		}
	
	}
	

	public ArrayList<WorkSheetAccess> getWorkSheetByDate(String date) throws Exception {
		return dao. getWorkSheetByDate( date);
		
	}
	

	public ArrayList<WorkSheetAccess> getWorkSheetByWeek(String date)throws Exception {
		
		
		LocalDate week = LocalDate.parse(date);
		WeekFields weekFields = WeekFields.of(Locale.getDefault()); 
		int weekNumber = week.get(weekFields.weekOfWeekBasedYear());
		
		return dao.getWorkSheetByWeek(weekNumber);
	}
	
	public void updateWorkSheet(WorkSheetAccess obj) throws Exception {
		try {
			dao.updateWorkSheet(obj);
			con.commit();

		} catch (Exception e) {

			try {
				con.rollback();
			} catch (Exception e2) {
				System.out.println("ERROR  DAOFactoryWorkSheet updateWorkSheet cannot rollback :" + e2);
			}
			System.out.println("ERROR  DAOFactoryWorkSheet updateWorkSheet :" + e);
			throw new Exception("ERROR  DAOFactoryWorkSheet updateWorkSheet :" + e);

		}

	}
	
}
