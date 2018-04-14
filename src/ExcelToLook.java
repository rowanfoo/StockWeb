import java.util.Calendar;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class ExcelToLook {
	//XSSFWorkbook workbook;
	//public static ExcelToLook myExcelToLook;
	//XSSFSheet sheet;
	//FileInputStream file;
	
	
	
	public  ExcelToLook()throws Exception {
		
		// file = new FileInputStream(new File(Excel.filepath ));
		//workbook=  new XSSFWorkbook(file);
		 //sheet = workbook.getSheetAt(4);
	
	
	}
	//public static ExcelToLook getExcelToLook()throws Exception {
		
		// if ( myExcelToLook == null ) {
			// myExcelToLook = new ExcelToLook();
	       // }
	       // return myExcelToLook;
//	}
	
	 
	
	public void addRecord (String code,String source,String preComment)throws Exception {
		
		try{
			XSSFSheet sheet = Excel.getExcel().getTolooklSheet();
			System.out.println("addRecord :"+code);
			System.out.println("addRecord :"+sheet.getSheetName());
			int nextRow = Excel.getNextEmptyRow(sheet);
			System.out.println("addRecord : Row Index :"+nextRow);
			
			
			Cell cell =  Excel.getCell(sheet, nextRow, 0);    
			System.out.println("addRecord : ok");
			cell.setCellValue( Calendar .getInstance());
			Excel.getCell(sheet, nextRow, 1).setCellValue(code);
			Excel.getCell(sheet, nextRow, 5).setCellValue(source);
			Excel.getCell(sheet, nextRow, 6).setCellValue(preComment);
		//	file.close();
			//FileOutputStream outFile =new FileOutputStream(new File(Excel.filepath));
		//	workbook.write(outFile);
			//outFile.close();
			 //myExcelToLook = new ExcelToLook();
			Excel.getExcel().writeExceltoFile();
			
		}catch (Exception e){
			System.out.println("Error trying to add record :"+e);
			throw new Exception ("Error trying to add record :"+e);
		}
		
	
	}
	
	
	
	
}
