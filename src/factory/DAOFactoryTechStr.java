package factory;

import java.time.LocalDate;
import java.util.ArrayList;

import access.DataAccess;
import access.TechStrAccess;
import dao.TechStrDAO;
import dao.TechStrXLS;

public class DAOFactoryTechStr extends DAOFactoryBase{


	
	TechStrDAO dao=null;   
	
	public DAOFactoryTechStr(){

		try {
		
			 dao= new TechStrDAO(con);
		} catch (Exception e) {
			System.out.println("Error initialize DAOFactoryTechStr "+e);
			 logger.severe("DAOFactoryTechStr Error initialize:"+e);	 
			
		}
	}

	
	

	public ArrayList <TechStrAccess>   getTechStrListByMonthMode(int month){
	
		try {
			return dao.getTechStrListByMonthMode(month);
		} catch (Exception e) {
			System.out.println("ERROR  DAOFactoryTechStr getTechStrListByMonthMode :"+e);  
		}
		
		return null;
		
		
		
	}
	public ArrayList <TechStrAccess>   getTechStrListBySql(String sql,int mode)throws Exception{
	
		return dao.getTechStrListBySql( sql,mode);
	}
	
	public ArrayList <TechStrAccess>   getTechStrList(String code,String date){
	try {
			return dao.getTechStrListByDate(code, date);
		} catch (Exception e) {
			System.out.println("ERROR  DAOFactoryTechStr getTechStrList :"+e);  
		}
		/*
		finally {
			try {
				System.out.println("AM I EVER CLOSE :");  
				
				con.close();
			} catch (Exception e2) {
				System.out.println("ERROR  DAOFactoryTechStr Cannot Close :"+e2);  
			}
				
		}*/
		
		return null;
		
		
		
	}
	
	public ArrayList <TechStrAccess>   getTechStrListByMonth(int month)throws Exception{
		return dao. getTechStrListByMonth(month);
	}
	
	public ArrayList <TechStrAccess>  getTechStrListByTop300ByDate(String mode,String date){
		try {
			return dao.getTechStrListByTop300ByDate(mode,date);
		} catch (Exception e) {
			System.out.println("ERROR  DAOFactoryTechStr getTechStrListByTopByDate :"+e);  
		}
		return null;
	}
	
	
	public ArrayList<TechStrAccess> getTechStrListByWeek(int weekno)throws Exception {
			return dao.getTechStrListByWeek(weekno);
	}	
		
	public ArrayList <TechStrAccess>  getTechStrListByPanic(){
		try {
			return dao.getTechStrListByPanic();
		} catch (Exception e) {
			System.out.println("ERROR  DAOFactoryTechStr getTechStrListByTopByDate :"+e);  
		}
		return null;
	}
	
	
	
	public ArrayList <TechStrAccess>   getTechStrList(String code,String date,int mode){
	//	ArrayList <TechStrAccess> arr = new ArrayList();
		try {
			return dao.getTechStrListByDate(code, date,mode);
		} catch (Exception e) {
			System.out.println("ERROR  DAOFactoryTechStr getTechStrList :"+e);  
		}
		/*
		finally {
			try {
				System.out.println("AM I EVER CLOSE :");  
				
				con.close();
			} catch (Exception e2) {
				System.out.println("ERROR  DAOFactoryTechStr Cannot Close :"+e2);  
			}
				
		}*/
		
		return null;
		
		
		
	}
	
	
	public  ArrayList <TechStrAccess>   getTechStrListByMode(int mode){
		try {
			return dao.getTechStrListByMode(mode);
		} catch (Exception e) {
			System.out.println("ERROR  DAOFactoryTechStr getTechStrList :"+e);  
		}
		return null;
	}
	
	
	public void  UpdateTechStr(TechStrAccess obj)throws Exception {
		try {
			dao.updateTechStr(obj);
			con.commit();
			
		
		} catch (Exception e) {
			
			
			try {
				con.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			System.out.println("ERROR  DAOFactoryTechStr getTechStrList :"+e);  
			throw new Exception ("ERROR  DAOFactoryTechStr getTechStrList :"+e);	
		
		}
		/*
		finally {
			try {
				System.out.println("AM I EVER CLOSE :");  

				con.close();
			} catch (Exception e2) {
				System.out.println("ERROR  DAOFactoryTechStr Cannot Close :"+e2);  
			}
				
		}*/
		
		
		
		
	}
	
	
	public void deleteThisMonthTechStrListByMonthMode() throws Exception {
	
		
	
		try {
			dao.deleteThisMonthTechStrListByMonthMode();
			con.commit();
			
		
		} catch (Exception e) {
			
			
			try {
				con.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			System.out.println("ERROR  DAOFactoryTechStr deleteThisMonthTechStrListByMonthMode :"+e);  
			throw new Exception ("ERROR  DAOFactoryTechStr deleteThisMonthTechStrListByMonthMode :"+e);	
		
		}
	
	
	
	}

	
	
	public void deleteTodayDate() throws Exception {
		
		
		
		try {
			dao.deleteTodayDate();
			con.commit();
			
		
		} catch (Exception e) {
			
			
			try {
				con.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			System.out.println("ERROR  DAOFactoryTechStr deleteTodayDate :"+e);  
			throw new Exception ("ERROR  DAOFactoryTechStr deleteTodayDate :"+e);	
		
		}
	
	
	
	}

	
	
	public ArrayList <TechStrAccess>   getTechStrListXLS(){
	//	ArrayList <TechStrAccess> arr = new ArrayList();
		try {
			return    new TechStrXLS().getTechStrListByMode(9);         
		} catch (Exception e) {
			System.out.println("ERROR  DAOFactoryTechStr getTechStrList :"+e);  
		}
		/*
		finally {
			try {
				System.out.println("AM I EVER CLOSE :");  
				
				con.close();
			} catch (Exception e2) {
				System.out.println("ERROR  DAOFactoryTechStr Cannot Close :"+e2);  
			}
				
		}*/
		
		return null;
		
		
		
	}
	/*
	public ArrayList <TechStrAccess>   getTodayTechStrList( ArrayList<DataAccess>  arr  ){
	//	ArrayList <TechStrAccess> arr = new ArrayList();
		try {
			return    new TechStrXLS().getTechStrListByMode(9);         
		} catch (Exception e) {
			System.out.println("ERROR  DAOFactoryTechStr getTechStrList :"+e);  
		}
		/*
		finally {
			try {
				System.out.println("AM I EVER CLOSE :");  
				
				con.close();
			} catch (Exception e2) {
				System.out.println("ERROR  DAOFactoryTechStr Cannot Close :"+e2);  
			}
				
		}*/
		
	//	return null;
		
		
		
//	}

	
public static void main(String[] args) {

		
	try(DAOFactoryTechStr dao = new DAOFactoryTechStr()) {
		
		
		
		
		//ArrayList <TechStrAccess>  arr = dao.getTechStrList("","2016-10-26");
	//	for(TechStrAccess obj :  dao.getTechStrList(null,"2016-10-25")){
			//System.out.println(tech);
		//String code = obj.getCode();	
		//int mode = obj.getMode();	
	//	System.out.println("my mode:"+mode);
	//	System.out.println("code:"+code);
		//System.out.println("code chg :"+code.replaceAll("^.AX", ""));
		//System.out.println("code chg :"+code.substring(0, code.lastIndexOf(".")) );
		
			

		//}
		
		
		System.out.println(dao.getTechStrListByWeek(13).size()  );
		
		LocalDate mydate = LocalDate.parse("2016-11-30");

		System.out.println("date:"+mydate.getMonthValue());
			
		
		
		System.out.println("FINISH");
		
	} catch (Exception e) {
		System.out.println("ERROR :"+e);  
	}
			 
			   
		    
		    
		  
		  
		    
	
		        	
		        	
		        	
		        	
		   
		    
	

	
		
		
		  }
	
	
	
	


}
