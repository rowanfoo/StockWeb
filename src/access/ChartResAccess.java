package access;

import java.util.Date;

public class ChartResAccess extends ChartAccess {

	String category ;	
	public ChartResAccess(String code, Date date, String year10, String year5, String year3, String year1,
			String yearhalf, String year10notes, String year5notes, String year3notes, String year1notes,
			String yearhalfnotes,String category ) {
		super(code, date, year10, year5, year3, year1, yearhalf, year10notes, year5notes, year3notes, year1notes,
				yearhalfnotes);
		this.category=category ;
	}
	public ChartResAccess(String code, int mode,String category ) {
		super(code,mode);
		this.category=category ;
	}
	public ChartResAccess(String code, Date date,String category ) {
		super(code,date);
		this.category=category ;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	
}
