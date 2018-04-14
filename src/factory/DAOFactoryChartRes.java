

package factory;

import java.util.ArrayList;
import java.util.Date;

import access.ChartAccess;
import access.ChartResAccess;
import dao.ChartResDAO;

public class DAOFactoryChartRes extends DAOFactoryBase{
	
	ChartResDAO dao;
	public DAOFactoryChartRes(){
		 dao = new ChartResDAO(con);
	}
	


	public ChartResAccess  getChart(String code,String category) throws Exception {
		ChartResAccess ac =  dao.getChart(code,category);
		if(ac==null){
			insertNewRecord(new ChartResAccess(code,new Date(),category) ) ;
			ac =  dao.getChart(code,category);
		}
		return ac;
	}
		
	public  ArrayList<ChartResAccess>  getCategory(String category) throws Exception {
		return dao. getCategory(category);
	}
	
	public  ArrayList<ChartResAccess>  getChartbyCode(String code) throws Exception {
		return dao. getChartbyCode(code);
	}
	
	
	public void insertNewRecord(ChartResAccess obj) throws Exception {
		dao.insertNewRecord(obj);
		con.commit();
	}	
	public void updateAll(ChartResAccess obj) throws Exception {
		dao.updateAll(obj);
		con.commit();
	}

	public static void main(String[] args) {

			
	 }

}
