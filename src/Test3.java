import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filepath ="C:\\Users\\rowan\\Desktop\\Prospects.xlsx";
		FileInputStream file;
		  XSSFWorkbook workbook;

		
		try{
			 file = new FileInputStream(new File(filepath));
			   workbook = new XSSFWorkbook(file);
			   System.out.println("file:"+workbook.getProperties().getCoreProperties().getModified()  );
			   Date date = workbook.getProperties().getCoreProperties().getModified() ;
				XSSFSheet sheet = workbook.getSheetAt(2);
			   
			   file.close();
			   System.out.println("date:"+date.before(new Date()));
		}catch(Exception e){
			System.out.println("Error:"+e);
		}

	}

}
