package access;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AccessObject {
	String code;
	Date date;
	
	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
 
	public String getPureCode(){
		if(code.startsWith("^"))return code;
		return code.substring(0, code.lastIndexOf("."));
	}
	
	
	public Date changeDateToString(String mydate)throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 return dateFormat.parse(mydate);
	}
	
	public String  changeStringToDate()throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 return dateFormat.format(date);
	}
	
	public int getYear(){
		
		Calendar cal = Calendar.getInstance();
	      cal.setTime(date);  
	      return cal.get(Calendar.YEAR);
	}
	
	public int getMonth(){
		
		Calendar cal = Calendar.getInstance();
	      cal.setTime(date);  
	      return cal.get(Calendar.MONTH);
	}
	
	public int getDay(){
		
		Calendar cal = Calendar.getInstance();
	      cal.setTime(date);  
	      return cal.get(Calendar.DAY_OF_MONTH );
	}
		

	
}
