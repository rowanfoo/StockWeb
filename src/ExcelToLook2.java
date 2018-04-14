import java.util.Calendar;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
public class ExcelToLook2 {

	
	
	public void addRecord (String code,String preComment)throws Exception {
		
		try{
			XSSFSheet sheet = Excel.getExcel().getTolook2Sheet();
			System.out.println("addRecord ExcelToLook2 :"+code);
			System.out.println("addRecord :"+sheet.getSheetName());
			int nextRow = Excel.getNextEmptyRow(sheet);
			System.out.println("addRecord : Row Index :"+nextRow);
			
			
			Cell cell =  Excel.getCell(sheet, nextRow, 0);    
			System.out.println("addRecord : ok");
			cell.setCellValue( Calendar .getInstance());
			Excel.getCell(sheet, nextRow, 1).setCellValue(code);
			Excel.getCell(sheet, nextRow, 2).setCellValue(preComment);
			Excel.getExcel().writeExceltoFile();
			
		}catch (Exception e){
			System.out.println("Error trying to add record ExcelToLook2 :"+e);
			throw new Exception ("Error trying to add record  ExcelToLook2  :"+e);
		}
		
	
	}
	
}
