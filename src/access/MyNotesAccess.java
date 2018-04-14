package access;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class MyNotesAccess extends AccessObject{
String notes;
int mode ;
long id ;
	public static final int  MODE_NOTES=2;
	public static final int   MODE_TODO=1;
	

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getMode() {
		return mode;
	}
	public void setMode(int mode) {
		this.mode = mode;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	@Override
	public String toString() {
		return "MyNotesAccess [date=" + date + ", code=" + code + ", notes=" + notes + "]";
	}
	public MyNotesAccess(Date date, String code, String notes,int mode) {
		super();
		this.date = date;
		this.code = code;
		this.notes = notes;
		this.mode=mode;
	}
	
	public MyNotesAccess(String date, String code, String notes,int mode)throws Exception {
		super();
		this.date = changeDateToString(date);
		this.code = code;
		this.notes = notes;
		this.mode=mode;
	}
	final String modeString1="NOTE";
	final String modeString2="TODO";
	
	public int getModeInt(String s)throws Exception {
		if(s.equalsIgnoreCase(modeString1)  )return 1;
		else if(s.equalsIgnoreCase(modeString2)  )return 2;
		throw new Exception(" Unknown mode");
		
		
	

	}

	public String getModeString()throws Exception {
		switch (mode) {
        case 1:  return  modeString1;
        case 2:  return modeString2;
       
		}
		return "";
		
		
		

	

	}



}
