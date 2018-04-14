import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Locale;

public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1");
		 LocalDate date = LocalDate.now();
		    WeekFields weekFields = WeekFields.of(Locale.getDefault());
		    System.out.println(weekFields.weekOfWeekBasedYear());
		    
		    System.out.println(Calendar.getInstance().get(Calendar.WEEK_OF_YEAR) );
		    
		    
		    
	}
}
