package dao;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import access.TechStrAccess;
import factory.DAOFactoryTechStr;
import util.ExcelConfig;
import util.ExcelLogger;

import java.util.*;
import java.sql.ResultSet;
import java.util.logging.*;


public class TechStrXLS  extends DAO {
	ArrayList<File> files;
	HashSet<String> hashdown;
	HashSet<String> hashvol;	

	 public TechStrXLS(){
			
			
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
	
 
 
 
 
 
 
	public ArrayList <TechStrAccess>   getTechStrListByMode(int mode)throws Exception{
		ArrayList <TechStrAccess> arr = new ArrayList <TechStrAccess>();
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
		hashvol= new HashSet<String>();
		
		for(File f: files ){
			//System.out.println("ok01    "+f.getAbsolutePath());	
			workbook = new XSSFWorkbook(f);
		//	System.out.println("ok1    ");	
			XSSFSheet sheet = workbook.getSheetAt(0);
			//System.out.println("ok2    ");	
				
			if(mode == 9){
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
				       	
				       		double chgPercent = Double.parseDouble(changePercent);
				       		double myvol = Double.parseDouble(vol);
				       		double avgVol = Double.parseDouble(avg3mthVol);
				       		if(chgPercent <= -0.03){
					       		
			       				if(! hashdown.contains(code)){
			       					TechStrAccess tech =new  TechStrAccess(code,new Date(),9,Double.parseDouble(close.trim()),Double.parseDouble(fiftydMA),Double.parseDouble( fiftyMAchg),(long)Double.parseDouble(vol),Double.parseDouble(avg3mthVol),
						       				Math.round(chgPercent*100),"","","",0,"",0,0,0);
				       		 		//System.out.println("obj is : "+tech)	;	       		
				       				tech.setName(name);
				       				arr.add(tech);
				       				hashdown.add(code);
				       				
			       				}
			       				
			       				
			       				
					       	}
				       		if(myvol > (avgVol*1.5)   ){
				       			
				       			if(! hashvol.contains(code)){
				       				TechStrAccess tech =new  TechStrAccess(code,new Date(),3,Double.parseDouble(close.trim()),Double.parseDouble(fiftydMA),Double.parseDouble( fiftyMAchg),(long)Double.parseDouble(vol),Double.parseDouble(avg3mthVol),
						       				Math.round(chgPercent*100),"","","",0,"",0,0,0);
				       		 		       		
				       				tech.setName(name);
				       				arr.add(tech);
				       				hashvol.add(code);
				       			
				       			}
				       			
				       			
				       		}
				       		
				       		
				       		
				       		
				        
				        }
				        
				        
				 }
				
				
				
				
					    	 	 
			    	  
			      }
			
			 workbook.close();
			
			 Collections.sort(arr, new Comparator<TechStrAccess>() {
			        @Override
			        public int compare(TechStrAccess fr2, TechStrAccess fr1)
			        {

			            return (int) (fr2.getChangePercent()- fr1.getChangePercent());

			        }
			    });
			
			
			
			
			
			
			
		}
		return arr;
	
	
	}
	
	public static double movingAverage(double arr[]) {
		if(arr.length < 1) {
		   return 0;
		  } 

		  double avg = 10;
		  for(int i = 1; i < arr.length; i++) {
		   avg = (avg * ((double)i/(i+1))) + (arr[i] * ((double)1/(i+1)));
		  }
		  
		  return avg;
		 }
	

	
	
	public static void main(String[] args) {

		
		try{
			
			String dp ="5.28";
			double d = Double.parseDouble(dp);
			System.out.println("dd :"+d); 
			
	
			//     String[] command = {"cmd.exe", "/C", "Start", "D:\\Java\\Excel\\bin\\testRun1.bat"};
		  //          Process p =  Runtime.getRuntime().exec(command);     
				double arr[]={1,2,3,4,5,6,7,8,9,10};
				double avg = movingAverage(arr);
				System.out.println("avg :"+avg); 
		
		} catch (Exception e) {
			System.out.println("ERROR :"+e);  
		}
				 
				   
			    
			    
			  
			  
			    
		
			        	
			        	
			        	
			        	
			   
			    
		

		
			
			
			  }
		
		

	

}
