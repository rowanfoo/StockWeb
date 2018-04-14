package dao;



import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import access.DataAccess;
import util.ExcelConfig;
import util.ExcelLogger;
import util.FormatUtil;


public class DataXLS  extends DAO {
	ArrayList<File> files;
	HashSet<String> hashdown;
	HashSet<String> hashvol;	

	 public DataXLS(){
			
			
			try {
				files = new ArrayList<File> ();
				files.add(new File(ExcelConfig.excelDir+"FinanceSpreadsheet1001.xlsm"));
				files.add(new File(ExcelConfig.excelDir+"FinanceSpreadsheet2001.xlsm"));
				files.add(new File(ExcelConfig.excelDir+"FinanceSpreadsheet3001.xlsm"));
			
				logger = ExcelLogger.getLogger();
				
				System.out.println("Data rUN    ");	
				logger.info("Data");	
				
				
				    
					 logger.info("Data ok");	    
					
				
			} catch (Exception e) {
				System.out.println("TechStrXLS Error initialize "+e);
				 logger.severe("TechStrXLS Error initialize:"+e);	    
			}	
		}
	
 
 
 
 
 
 
	public ArrayList <DataAccess>   getDataList()throws Exception{
		ArrayList <DataAccess> arr = new ArrayList <DataAccess>();
		XSSFWorkbook workbook;
		String code;
		   
		 
		   String open;
		   String high;
		   String low;
		   String close;
		  
		   String  closeVol;
		   String vol;
		   String change;
		   String changePercent;
		  String previousClose;
		  
		   String  fiftydMA;
		   String fiftyMAchg;
		   String twohundreddMA;
		   String twohundredMAchg;
		  String avg3mthVol;
		String name;
		
		hashdown = new HashSet<String>();
		
		
		for(File f: files ){
			//System.out.println("ok01    "+f.getAbsolutePath());	
			workbook = new XSSFWorkbook(f);
		//	System.out.println("ok1    ");	
			XSSFSheet sheet = workbook.getSheetAt(0);
			//System.out.println("ok2    ");	
		
				//change percent >4
			
				 Iterator<Row> rowIterator = sheet.iterator();
				 
		//		 System.out.println("ok3    ");	
				 while(rowIterator.hasNext()) {
				        Row row = rowIterator.next();
				        
	//			        System.out.println("ok4    ");	
				        if(row.getCell(0) == null)break;
				        
				        code = (String)row.getCell(0).toString();
//				        System.out.println("ok5  code  "+code);	
				        if(code !=null & code.endsWith("AX")  ){
		
				        	name=row.getCell(2).toString();;
				    		
				        	open=row.getCell(3).toString();;
				       		//System.out.println("cell t2:    ");
				       		high=row.getCell(4).toString();;
				       		low=row.getCell(5).toString();
				       		close=row.getCell(6).toString();;
				       		
				       		vol=row.getCell(7).toString();;
				       		
				       		//System.out.println("cell t3:    ");
				       		change=row.getCell(8).toString();;
				       		//System.out.println("cell t4:    ");
				       		changePercent=row.getCell(9).toString();;
				       		previousClose	=row.getCell(10).toString();
				       		//System.out.println("cell t5:    ");
				       		avg3mthVol	=row.getCell(11).toString();
				       		fiftydMA=  row.getCell(12).toString();;
				       	//	System.out.println("cell t6:    ");
				       		fiftyMAchg=row.getCell(13).toString();;
				       		twohundreddMA=row.getCell(14).toString();
				       		//System.out.println("cell t7:    ");
				       		twohundredMAchg=row.getCell(15).toString();;
				       	//	System.out.println("cell t8:    ");
				       	
				       		double chgPercent = FormatUtil.convertNumberFormat(changePercent);
				       		double myvol = FormatUtil.convertNumberFormat(vol);
				       		double avgVol = FormatUtil.convertNumberFormat(avg3mthVol);
				       		double fifty = FormatUtil.convertNumberFormat(fiftydMA);
				       		double fiftychg = FormatUtil.convertNumberFormat(fiftyMAchg);
				       		double twohd = FormatUtil.convertNumberFormat(twohundreddMA);
				       		double twohdchg = FormatUtil.convertNumberFormat(twohundredMAchg);
				       		
				       		
				       		
					       		
			       				if(! hashdown.contains(code)){
			       				
				       				
				       				DataAccess dc =new  DataAccess(Double.parseDouble(open.trim()) ,Double.parseDouble(high.trim()) ,Double.parseDouble(low.trim()) ,  Double.parseDouble(close.trim()) ,
				       					 "0" , myvol , Double.parseDouble(change.trim()) ,
				       					chgPercent ,previousClose , avgVol ,fifty ,fiftychg ,
				       					twohd, twohdchg, code, new Date());
				       				
				       				
				       				
				       				arr.add(dc);
				       				hashdown.add(code);
				       				
			       				}
			       				
			       				
			       				
					       
				       		
				       		
				       		
				       		
				       		
				        
				        }
				        
				        
				 
				
				
				
				
					    	 	 
			    	  
			      }
			
			 workbook.close();
			
			
			
			
			
			
			
		}
	
		return arr;
	
	
	}
	

	
	
	public static void main(String[] args) {

		
		try{
			
			 new DataXLS().getDataList();
		} catch (Exception e) {
			System.out.println("ERROR :"+e);  
		}
				 
				   
			    
			    
			  
			  
			    
		
			        	
			        	
			        	
			        	
			   
			    
		

		
			
			
			  }
		
		

	

}
