

package factory;

import java.util.ArrayList;
import java.util.Hashtable;

import access.DataAccess;
import access.StockAccess;
import access.TechStrAccess;
import dao.DataDAO;
import dao.DataXLS;
import dao.TechStrXLS;
import util.MovingAverage;

public class DAOFactoryData extends DAOFactoryBase{


	
	DataDAO dao=null;   
	
	public DAOFactoryData(){

		try {
		
			 dao= new DataDAO(con);
		} catch (Exception e) {
			System.out.println("Error initialize DAOFactoryStock "+e);
			 logger.severe("DAOFactoryStock Error initialize:"+e);	 
			
		}
	}

	public ArrayList <DataAccess>   getStockbyYear(String code, String year)throws Exception {
	//	ArrayList <TechStrAccess> arr = new ArrayList();
		
			return  dao.getStockbyYear(code,year);
	}
	
	

	public ArrayList <DataAccess>   getStock(String code)throws Exception {
	//	ArrayList <TechStrAccess> arr = new ArrayList();
		
			return  dao.getStock(code);
	}
	

	public ArrayList <DataAccess>   getDate(String date)throws Exception{
		return  dao.getDate(date);
	}	
	
	public   StockAccess getCode(String code)throws Exception {
		
			
				return dao.getStockCode(code);
		}
		
	
	
	public DataAccess   getLastData(String code)throws Exception{
		return dao. getLastData(code);
	}
	
	
	
	public void  updateData50d(DataAccess obj)throws Exception {
		try {
			dao.updateData50d(obj);
			con.commit();
			System.out.println("  DAOFactoryStock updateStockTechnical : OK !!");  
		
		} catch (Exception e) {
			
			
			try {
				con.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			System.out.println("ERROR  DAOFactoryStock updateStockTechnical :"+e);  
			throw new Exception ("ERROR  DAOFactoryStock updateStockTechnical :"+e);	
		
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
	
	
	
	
	
	public void  updateData200d(DataAccess obj)throws Exception {
		try {
			dao.updateData200d(obj);
			con.commit();
			System.out.println("  DAOFactoryStock updateStockTechnical : OK !!");  
		
		} catch (Exception e) {
			
			
			try {
				con.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			System.out.println("ERROR  DAOFactoryStock updateStockTechnical :"+e);  
			throw new Exception ("ERROR  DAOFactoryStock updateStockTechnical :"+e);	
		
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
	
	
	public void  updateDataNewAveragesImportNew(ArrayList<DataAccess>arr)throws Exception {
		try {

			

			
		
			dao.updateDataNewAveragesImportNew(arr);
			
			con.commit();

			System.out.println("  DAOFactoryStock updateDataNewAveragesImportNew : OK !!");

		} catch (Exception e) {

			try {
				con.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			System.out.println("ERROR  DAOFactoryStock updateDataNewAveragesImportNew :" + e);
			throw new Exception("ERROR  DAOFactoryStock updateDataNewAveragesImportNew :" + e);

		}
		
	}
	
	
	
	public void  updateDataNewAveragesImport400(ArrayList<DataAccess>arr)throws Exception {
		try {

			

			
		
			dao.updateDataNewAveragesImport400(arr);
			
			con.commit();

			System.out.println("  DAOFactoryStock updateDataNewAveragesImport400 : OK !!");

		} catch (Exception e) {

			try {
				con.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			System.out.println("ERROR  DAOFactoryStock updateDataNewAveragesImport200 :" + e);
			throw new Exception("ERROR  DAOFactoryStock updateDataNewAveragesImport200 :" + e);

		}
		
	}
	
	
	
	
	public void  updateDataNewAverages(ArrayList<DataAccess>arr)throws Exception {
		try {

			

			
		
			dao.updateDataNewAverages(arr);
			
			con.commit();

			System.out.println("  DAOFactoryStock updateDataAverages : OK !!");

		} catch (Exception e) {

			try {
				con.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			System.out.println("ERROR  DAOFactoryStock updateDataAverages :" + e);
			throw new Exception("ERROR  DAOFactoryStock updateDataAverages :" + e);

		}
		
	}
	
	

	public void  updateDataNewAveragesImport(ArrayList<DataAccess>arr)throws Exception {
		try {

			

			
		
			dao.updateDataNewAveragesImport(arr);
			
			con.commit();

			System.out.println("  DAOFactoryStock updateDataAverages : OK !!");

		} catch (Exception e) {

			try {
				con.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			System.out.println("ERROR  DAOFactoryStock updateDataAverages :" + e);
			throw new Exception("ERROR  DAOFactoryStock updateDataAverages :" + e);

		}
		
	}
	
	
	

	
	
	public void  updateDataAveragesImport(ArrayList<DataAccess>arr )throws Exception {
		try {

			dao.updateDataAveragesImport(arr);

			con.commit();

			System.out.println("  DAOFactoryStock updateDataAverages : OK !!");

		} catch (Exception e) {

			try {
				con.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			System.out.println("ERROR  DAOFactoryStock updateDataAverages :" + e);
			throw new Exception("ERROR  DAOFactoryStock updateDataAverages :" + e);

		}

	}

	public void updateDataAvgVol(DataAccess obj) throws Exception {
		try {
			dao.updateData200d(obj);
			con.commit();
			System.out.println("  DAOFactoryStock updateStockTechnical : OK !!");

		} catch (Exception e) {

			try {
				con.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			System.out.println("ERROR  DAOFactoryStock updateStockTechnical :" + e);
			throw new Exception("ERROR  DAOFactoryStock updateStockTechnical :" + e);

		}
	}
	
	
	
	
	
	
	
	public void  updateStockFundamental(StockAccess obj)throws Exception {
		try {
			dao.updateStockFundamental(obj);
			con.commit();
			System.out.println("  DAOFactoryStock updateStockFundamental : OK !!");  
		
		} catch (Exception e) {
			
			
			try {
				con.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			System.out.println("ERROR  DAOFactoryStock updateStockFundamental :"+e);  
			throw new Exception ("ERROR  DAOFactoryStock updateStockFundamental :"+e);	
		
		}
	
		
		
	}

	
	public void  deleteTodayDate()throws Exception {
		try {
			dao.deleteTodayDate();
			con.commit();
			System.out.println("  DAOFactoryStock deleteTodayDate : OK !!");  
		
		} catch (Exception e) {
			
			
			try {
				con.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			System.out.println("ERROR  DAOFactoryStock deleteTodayDate :"+e);  
			throw new Exception ("ERROR  DAOFactoryStock deleteTodayDate :"+e);	
		
		}
	
		
		
	}
	
	
	
	
	public ArrayList <StockAccess>     getDataListXLSbyCategory(  ArrayList <StockAccess>  arr,String category   ){
		 ArrayList <StockAccess> truedt = new  ArrayList <StockAccess>();
			try {
				ArrayList <DataAccess>  datarr=    new DataXLS().getDataList();       
				System.out.println("getDataList :datarr"+datarr.size());
				System.out.println("getDataList :arr"+arr.size());
				
				for(StockAccess stock:arr){
				String code = stock.getCode();
				String mycategory  = stock.getCategory();
				if(mycategory!=null){	 
				
					for(DataAccess data:datarr ){
						
						if(code.equals(data.getCode().trim()   )   ){
							
							if(mycategory.equals(category) ){
								stock.setData(data);
								truedt.add(stock);
							}
							
							
						}
					
					
					}
				
				}
				}
				
				
			} catch (Exception e) {
				System.out.println("ERROR  DAOFactoryTechStr getTechStrList :"+e);  
			}
			
			
			return truedt;
			
			
			
		}
		
	
	
	
public static void main(String[] args) {

		
	try(DAOFactoryData dao = new DAOFactoryData()) {
		
		
		 ArrayList <DataAccess> arr= dao.getStock("BHP.AX");
		 
				
		// System.out.println("DAOFactoryData arr :"+arr);		
				
		 new  MovingAverage(60,   arr).run() ;
			
		 for (DataAccess x : arr) {
				System.out.println("DAOFactoryData arr :"+x.getDate()+"::::"+x.getAvg3mth() );		
               
       }			 
		  
		 
		System.out.println("DAOFactoryData FINISH");
		
		
		
		
		
		
		
	} catch (Exception e) {
		System.out.println("ERROR :"+e);  
	}
			 
			   
		    
		    
		  
		  
		    
	
		        	
		        	
		        	
		        	
		   
		    
	

	
		
		
		  }
	
	
	
	


}
