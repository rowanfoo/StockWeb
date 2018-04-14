package util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public  class FormatUtil {

	
	public static double formatDouble(double value , double position){
		
		BigDecimal bigDecimal = new BigDecimal(value);
	    bigDecimal = bigDecimal.setScale(2,
	            BigDecimal.ROUND_HALF_UP);
		return bigDecimal.doubleValue();
		
	}
	
	
	
	
	public static boolean isNumeric(String s) {  
	    return s.matches("[-+]?\\d*\\.?\\d+");  
	}  
	
	public static  double convertNumberFormat(String s) {  
		if( isNumeric(s)){
			

			return Double.parseDouble(s.trim());
		}
		return 0;
	
	}  
	
	public static String convertDateToString(Date date   ){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 return dateFormat.format(date);

	}

	public static LocalDate convertStringToDate(String mdate   ){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    try {
	    	return LocalDate.parse(mdate, dtf);
	    } catch (Exception e) {
	    	System.out.println("error convertStringToDate:"+e);
	    }
	    return null;
	}
		
	
	public static String getTodayDateToString(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 return dateFormat.format(new Date());

	}
	
	public static LocalDate getWorkDay(LocalDate date, int workdays) {
	 
		if (workdays < 1) {
	        return date;
	    }
	    LocalDate result = date;
	    int addedDays = 0;
	    while (addedDays <= workdays) {
	       
	    	result = result.minusDays(1);
	        if ((result.getDayOfWeek() == DayOfWeek.SATURDAY ||
	              result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
	        	 result = result.minusDays(1);
	        	
	        }
	        addedDays++;
	    }
	    return result;
	}
	

	public static void main(String[] args) {

		
		
		
	    System.out.println(convertStringToDate("2017-04-01").getMonthValue() );
			
    }
		
		
		
	
	  	  
	
}
