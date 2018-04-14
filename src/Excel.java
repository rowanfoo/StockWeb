import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class   Excel {
	static String  filepath="C:\\Users\\rowan\\Desktop\\Prospects.xlsx";



int generalSheet=0;
int asxSheet=3;
int lowSheet=5;
int tolookSheet=3;
static XSSFWorkbook workbook;
static Excel myexcel;
static FileInputStream file;
int small = 6;
int mid = 7;
int large = 8;
int mega = 9;
int hugh = 10;
int toLook2sheet = 4;

	public  Excel()throws Exception {
	
		 file = new FileInputStream(new File("C:\\Users\\rowan\\Desktop\\Prospects.xlsx"));
		workbook=  new XSSFWorkbook(file);
		myexcel= this;
	
	}
	
	public static  Excel getExcel()throws Exception {
	
	 if ( myexcel == null ) {
		 myexcel = new Excel();
        }
        return myexcel;
	}
	
	public  void writeExceltoFile()throws Exception {
		file.close();
		FileOutputStream outFile =new FileOutputStream(new File(Excel.filepath));
		workbook.write(outFile);
		outFile.close();
	}
	
	
	public XSSFSheet getGeneralSheet(){
		 System.out.println("getGeneralSheet :"+generalSheet);
		return workbook.getSheetAt(generalSheet);
	}
	
	public XSSFSheet getAsxSheet(){
		return workbook.getSheetAt(asxSheet);
	}
	public XSSFSheet getlowSheet(){
		return workbook.getSheetAt(lowSheet);
	}
	public XSSFSheet getTolooklSheet(){
		return workbook.getSheetAt(tolookSheet);
	}
	public XSSFSheet getTolook2Sheet(){
		return workbook.getSheetAt(toLook2sheet);
	}
	public XSSFSheet getSheetIndex (int index){
		return workbook.getSheetAt(index);
	}
	/**
	 * 
	 * @param sheet
	 * @return
	 * @throws Exception
	 * find the next row
	 * sometime a next row is just an empty cell , means it used to have data but someone deleted it
	 * sometime it is so new that , that you have to create that row physically.
	 */
	public static   int getNextEmptyRow(XSSFSheet sheet)throws Exception {
		System.out.println("getNextEmptyRow total : "+sheet.getPhysicalNumberOfRows());
		int x =1;
		for (; x <sheet.getPhysicalNumberOfRows();x++){
			//System.out.println("getNextEmptyRow row : "+sheet.getRow(x));
			if(sheet.getRow(x)==null){
				//System.out.println("getNextEmptyRow null : "+x);
				break;	
			}
		//	System.out.println("getNextEmptyRow index now : "+x);
			if(isCellEmpty(sheet.getRow(x).getCell(1) )){
			//	System.out.println("getNextEmptyRow return index : ");
				return x;
			}
			
		}// loop and find ,until it reaches end , now go create a new row.
		//System.out.println("Create Empty Row : ");
		//createRowEmpty( sheet,++x );
		createRowEmpty( sheet,x );
		return x;
		//throw new Exception("Error cant find row");
		//if(sheet.getPhysicalNumberOfRows()<1){
			//return 1;
		//}else{ 
			//int x = sheet.getPhysicalNumberOfRows();
			//x++;
			//return ++x;
//why cant i just x++;
			//because even deleted empty cell returns sheet.getPhysicalNumberOfRows() , return a number
		//}
	}

	public static   boolean isCellEmpty(Cell cell){
		//System.out.println("isEmptyCEll : "+cell.getCellType()+":"+(cell.getCellType() == Cell.CELL_TYPE_STRING ));
		System.out.println("isEmptyCEll name : "+cell);
		 if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
		        return true;
		    }
		// System.out.println("isEmptyCEll name 2 : ");
		// System.out.println("isEmptyCEll name 2 Empty  : "+cell.getStringCellValue().isEmpty());
		    if (cell.getCellType() == Cell.CELL_TYPE_STRING && cell.getStringCellValue().isEmpty()) {
		        return true;
		    }

		    return false;
	}
	public static   void createRowEmpty(XSSFSheet sheet,int row ){
		//System.out.println("isEmptyCEll : "+cell.getCellType()+":"+(cell.getCellType() == Cell.CELL_TYPE_STRING ));
	//	System.out.println("isEmptyCEll name : "+cell);
		//XSSFRow rows = sheet.getRow(row);
		 if(sheet.getRow(row) == null){
			 System.out.println("Create Empty Row : "+row);
			sheet.createRow(row);
		 }
	
	}
		
	
	
	
	public static  Cell getCell(XSSFSheet sheet,int row , int colum ){
		System.out.println("getCell name : "+sheet.getSheetName());
		//System.out.println("getCell name : "+sheet.getRow(row));
	//	createRowEmpty( sheet, row );
	//	System.out.println("getCell name xx : "+sheet.getRow(row));
		Cell cell = sheet.getRow(row).getCell(colum);
		if (cell != null){
			return cell;
		}else{
			return sheet.getRow(row).createCell(colum);
		}
	}

}
