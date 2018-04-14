package factory;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import access.DataReport;
import dao.DateReportDAO;

import java.util.Comparator;

import java.util.Collections;
import java.util.ListIterator;
import java.text.DecimalFormat;

public class DAOFactoryDataReport extends DAOFactoryBase{
	
	DateReportDAO dao;
	public DAOFactoryDataReport(){
		 dao = new DateReportDAO(con);
	}
	
	public ArrayList<DataReport>  getMonthAverageFromFiftyDayDownFourYears(String code)throws Exception {
		ArrayList <String> arr = new ArrayList();
		 dao = new DateReportDAO(con);
		
		return dao.getMonthAverageFromFiftyDayDownFourYears(code);
		

	
	}
	
	
	
	public ArrayList<DataReport>  getFiftyDayTwoYears(String code)throws Exception {
		ArrayList <String> arr = new ArrayList();
		 dao = new DateReportDAO(con);
		
		return dao.getFiftyDayTwoYears(code);
		

	
	}
	
		
	
	public ArrayList<DataReport>  getDownvsUpDayRatio(String code)throws Exception {
		ArrayList <String> arr = new ArrayList();
		 dao = new DateReportDAO(con);
		
		return dao.getDownvsUpDayRatio(code);
		

	
	}
	
	
	public ArrayList<DataReport>  getPriceVariance(String code)throws Exception {
		ArrayList <String> arr = new ArrayList();
		
		
		return dao.getPriceVariance(code);
		

	
	}
	public ArrayList <DataReport>   getTenMonthAvgHistory (String code)throws Exception{
		
		return dao.getTenMonthAvgHistory(code);
		
	}
	
	
	
	public ArrayList<DataReport>  getDownvsUpVolumeRatio(String code)throws Exception {
		ArrayList <String> arr = new ArrayList();
		 dao = new DateReportDAO(con);
		
		return dao.getDownvsUpVolumeRatio(code);
		

	
	}
	
	public static void main(String[] args) {

		
		try(DAOFactoryDataReport dao = new DAOFactoryDataReport()) {
			
			
			
			
			//ArrayList<DataReport> arr=dao.getMonthAverageFromFiftyDayDownFourYears();
			/*
			
			Collections.sort(arr, new Comparator() 
			{
			    public int compare(Object o1, Object o2) 
			    {
			    	DataReport p1 =(DataReport)o1;
			    	DataReport p2 =(DataReport)o2;
			    	
			    	
			    	if(p1.getda <  emp2.getSalary()) return -1;
			        if(emp1.getSalary() == emp2.getSalary()) return 0;
			        return 1;
			        
			    }
			});
			
			
		*/
			/*
			ListIterator<DataReport> listIter = arr.listIterator(arr.size()-1);

			while (listIter.hasPrevious()) {
			     DataReport  dr= listIter.previous();

			     System.out.println("['"+dr.getSdate()+"',"+dr.getMonthAvgfiftyRed()+"],"   );


			}
			*/
			/*
			//ArrayList<DataReport> arr=dao.getDownvsUpDayRatio("ofx.ax");
			ArrayList<DataReport> arr=dao.getDownvsUpVolumeRatio("tpm.ax");
			//ArrayList<DataReport> arr=dao.getMonthAverageFromFiftyDayDownFourYears("tpm.ax");
			
			
			//for(DataReport obj:arr  ){
				//System.out.println("arr:"+obj.getSdate());
			//}
			
			System.out.println("FINISH:---------------------------------");
			ListIterator<DataReport> listIter = arr.listIterator(arr.size());
			//ListIterator<DataReport> listIter = arr.listIterator();
			while (listIter.hasPrevious()) {
			     DataReport  dr= listIter.previous();
			  //   System.out.println("DR__"+dr.getSdate()+":ratio:"+  dr.getMonthAvgfiftyRed()          +"::" +dr.getDistanceMonthAvgfiftyRed())  ;
				    
			    //System.out.println("DR__"+dr.getSdate()+":ratio:"+dr.getDownvsupratioPrice()  );
			    
			    
			     
			     System.out.println("DR__"+dr.getSdate()+":ratio:"+ dr.getDownvsupratioVolumeFormated()  );
		
			  //   System.out.println("DR__"+dr.getSdate()+":ratio:"+ dr.getDownvsupratioPrice()  );
					
			}
			*/
			
				
			ArrayList<DataReport> rpt = dao.getTenMonthAvgHistory("tpm.ax");
			
			for(DataReport dt: rpt ){
				System.out.println("FINISH xxx :"+dt.getSdate()+"  ;: "+ dt.getTenmonthchgMax());
			}
			
				//System.out.println("FINISH xxx :"+dao.getTenMonthAvgHistory("tpm.ax"));

	
			
			System.out.println("FINISH 2");

			
			
			
		} catch (Exception e) {
			System.out.println("ERROR :"+e);  
		}
				 
				   
			    
			    
			  
			  
			    
		
			        	
			        	
			        	
			        	
			   
			    
		

		
			
			
	 }

}
