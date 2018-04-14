
package factory;

import access.MovingAverageAccess;
import dao.MovingAverageDAO;

public class DAOFactoryMovingAverage extends DAOFactoryBase{
	
	MovingAverageDAO dao=null;   
	
	public DAOFactoryMovingAverage(){

		try {
		
			 dao= new MovingAverageDAO(con);
		} catch (Exception e) {
			System.out.println("Error initialize DAOFactoryStock "+e);
			 logger.severe("DAOFactoryStock Error initialize:"+e);	 
			
		}
	}
	public MovingAverageAccess getStockMovingAverage(String code)throws Exception {
		return dao.getStockMovingAverage(code);
	}
	

}
