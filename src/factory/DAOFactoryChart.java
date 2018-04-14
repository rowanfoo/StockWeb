
package factory;

import java.util.Date;

import access.ChartAccess;
import dao.ChartDAO;

public class DAOFactoryChart extends DAOFactoryBase{
	
	ChartDAO dao;
	public DAOFactoryChart(){
		 dao = new ChartDAO(con);
	}
	
	public void insertChartYear10(ChartAccess obj) throws Exception {
		dao.insertChartYear10(obj);
		con.commit();
	}	

	public void insertChartYear5(ChartAccess obj) throws Exception {
		dao.insertChartYear5(obj);
		con.commit();
	}	
	
	public void insertChartYear3(ChartAccess obj) throws Exception {
		dao.insertChartYear3(obj);
		con.commit();
	}	
	
	public void insertChartYear1(ChartAccess obj) throws Exception {
		dao.insertChartYear1(obj);
		con.commit();
	}	

	public void insertChartHalfYear(ChartAccess obj) throws Exception {
		dao.insertChartHalfYear(obj);
		con.commit();
	}	
	

	public ChartAccess getChart(String code) throws Exception {
		ChartAccess ac =  dao.getChart(code);
		if(ac==null){
			insertNewRecord(new ChartAccess(code,new Date()) ) ;
			ac =  dao.getChart(code);
		}
		return ac;
	}
		
	public void insertNewRecord(ChartAccess obj) throws Exception {
		dao.insertNewRecord(obj);
		con.commit();
	}	
	public void updateAll(ChartAccess obj) throws Exception {
		dao.updateAll(obj);
		con.commit();
	}

	public static void main(String[] args) {

			
	 }

}
