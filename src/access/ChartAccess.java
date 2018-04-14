package access;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

import util.ChartImage;

public class ChartAccess extends AccessObject {

	private String year10;
	private String year5;
	private String year3;
	private String year1;
	private String yearhalf;
	private String year10notes="";
	private String year5notes="";
	private String year3notes="";
	private String year1notes="";
	private String yearhalfnotes="";	
	private int  mode;
	
	public ChartAccess(String code, Date date, String year10, String year5,String year3,String year1, String yearhalf,
			String year10notes, String year5notes,String year3notes,String year1notes, String yearhalfnotes){
	
		this.code=code;
		this.date=date;
		this.year10=year10;
		this.year5=year5;
		this.year3=year3;
		this.year1=year1;
		this.yearhalf=yearhalf;
		this.year10notes=year10notes;
		this.year5notes=year5notes;
		this.year3notes=year3notes;
		this.year1notes=year1notes;
		this.yearhalfnotes=yearhalfnotes;


	}
	
	public ChartAccess(String code, Date date,int mode){
		this.code=code;
		this.date=date;
		this.mode=mode;
	}
	public ChartAccess(String code, Date date){
		this.code=code;
		this.date=date;
	}
	
	public ChartAccess(String code, int mode){
		this.code=code;
		this.mode=mode;
	}
	
		
	
	
	
	
	public String getYear10notes() {
		return year10notes;
	}






	public void setYear10notes(String year10notes) {
		this.year10notes = year10notes;
	}






	public String getYear5notes() {
		return year5notes;
	}






	public void setYear5notes(String year5notes) {
		this.year5notes = year5notes;
	}






	public String getYear3notes() {
		return year3notes;
	}






	public void setYear3notes(String year3notes) {
		this.year3notes = year3notes;
	}






	public String getYear1notes() {
		return year1notes;
	}






	public void setYear1notes(String year1notes) {
		this.year1notes = year1notes;
	}






	public String getYearhalfnotes() {
		return yearhalfnotes;
	}






	public void setYearhalfnotes(String yearhalfnotes) {
		this.yearhalfnotes = yearhalfnotes;
	}






	public String getYear10() {
		return year10;
	}
	public void setYear10(String year10) {
		this.year10 = year10;
	}
	public String getYear5() {
		return year5;
	}
	public void setYear5(String year5) {
		this.year5 = year5;
	}
	public String getYear3() {
		return year3;
	}
	public void setYear3(String year3) {
		this.year3 = year3;
	}
	public String getYear1() {
		return year1;
	}
	public void setYear1(String year1) {
		this.year1 = year1;
	}
	public String getYearhalf() {
		return yearhalf;
	}
	public void setYearhalf(String yearhalf) {
		this.yearhalf = yearhalf;
	}
	public void setDatabaseImage (){
		
	}
	public void setImage (){
		System.out.println("setImage:");  
		String url ="";
		try {
		switch (mode) {
        case 0: if(year10==null || year10.trim().isEmpty() ){
        		url =ChartImage.preurl+getPureCode()+ChartImage.year10 ;
        		year10=ChartImage.getImage(ChartImage.getImageTag( url ));
        		}	
                 break;
        case 1: if(year5==null|| year5.trim().isEmpty()){
        		url =ChartImage.preurl+getPureCode()+ChartImage.year5 ;
        		year5=ChartImage.getImage(ChartImage.getImageTag( url ));
        		} 
        		break;
        case 2:if(year3==null|| year3.trim().isEmpty()){
        		url =ChartImage.preurl+getPureCode()+ChartImage.year3 ;
        		year3=ChartImage.getImage(ChartImage.getImageTag( url ));
        		}	
        		break;
        case 3: if(year1==null|| year1.trim().isEmpty()){
        		url =ChartImage.preurl+getPureCode()+ChartImage.year1 ;
        		year1=ChartImage.getImage(ChartImage.getImageTag( url ));
        		}
        		break;
        case 4:if(yearhalf==null|| yearhalf.trim().isEmpty()){
        		url =ChartImage.preurl+getPureCode()+ChartImage.yearhalf ;
        		yearhalf=ChartImage.getImage(ChartImage.getImageTag( url ));
        		}
        		break;
       
		}
			System.out.println("setImage: get image done");  

		} catch (Exception e) {
			System.out.println("ERROR  setImage:"+e);  
		}
		
	}
	

	
	public void setYear(String s){
		System.out.println("setYear:"+s);  
		System.out.println("setYear year10notes:"+year10notes);  
		BinaryOperator<String> adder = (n1, n2) -> { if(n1==null)n1="";return n1+n2;      };
		
		/*
		switch (mode) {
        case 0: year10notes = year10notes+s;
                 break;
        case 1: year5notes = year5notes+s;
        		break;
        case 2:year3notes = year3notes+s;
        		break;
        case 3: year1notes = year1notes+s;
        		break;
        case 4:yearhalfnotes = yearhalfnotes+s;
        		break;
       
		}*/
		switch (mode) {
        case 0: year10notes = adder.apply(year10notes,s );
                 break;
        case 1: year5notes = adder.apply(year5notes,s );
        		break;
        case 2:year3notes = adder.apply(year3notes,s );
        		break;
        case 3: year1notes = adder.apply(year1notes,s );
        		break;
        case 4:yearhalfnotes = adder.apply(yearhalfnotes, s );
        		break;
       
		}

	}
	
	
	
	
	
	
	
	public String  getImage (){
		switch (mode) {
        case 0: return year10 ;
        case 1: return year5 ;
        case 2: return year3 ;
        case 3: return year1 ;
        case 4: return yearhalf ;
       
		}
		return "";
	}
	public String  getNotes (){
		switch (mode) {
        case 0: return year10notes ;
        case 1: return year5notes ;
        case 2: return year3notes ;
        case 3: return year1notes ;
        case 4: return yearhalfnotes ;
       
		}
		return "";
	}

	public ArrayList<String> getAllImages(){
		ArrayList <String> images = new ArrayList<>();
		if(getYear10() !=null ) images.add(getYear10() );
		if(getYear5() !=null ) images.add(getYear5() );
		if(getYear3() !=null ) images.add(getYear3() );
		if(getYear1() !=null ) images.add(getYear1() );
		if(getYearhalf() !=null ) images.add(getYearhalf() );
		return images;
	}
	public ArrayList<String> getAllNotes(){
		ArrayList <String> notes = new ArrayList<>();
		notes.add(getYear10notes() );
		notes.add(getYear5notes() );
		notes.add(getYear3notes() );
		notes.add(getYear1notes() );
		notes.add(getYearhalfnotes() );
		return notes;
	}

	public HashMap<String,String> getAllNotesAndImages(){
		HashMap<String,String> all= new HashMap<>();
		setNotesImages(all, getYear10notes(),getYear10() );
		setNotesImages(all,getYear5notes(),getYear5() );
		setNotesImages(all,getYear3notes(),getYear3() );
		setNotesImages(all,getYear1notes(),getYear1() );
		setNotesImages(all,getYearhalfnotes(),getYearhalf() );
		
	
		return all;
	}
	private void setNotesImages(HashMap<String,String> all,String b,String c){
		if(c !=null && !c.equals("")){
			all.put(b,c);
		}
	}

	public void setImageInput (String imagess ){
		System.out.println("setImageInput:");  
		System.out.println("setImageInput year100:"+year10);  
		
		switch (mode) {
        case 0: year10=imagess;
                 break;
        case 1: year5=imagess ;
                 break;
        case 2: year3=imagess;
                 break;
        case 3:  year1=imagess ;
                 break;
        case 4:  yearhalf=imagess;
                 break;
       
		}
	
		System.out.println("setImageInput year10:"+year10);  
	}
	
	
	
	



	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	@Override
	public String toString() {
		return "ChartAccess [year10=" + year10 + ", year5=" + year5 + ", year3=" + year3 + ", year1=" + year1
				+ ", yearhalf=" + yearhalf + ", year10notes=" + year10notes + ", year5notes=" + year5notes
				+ ", year3notes=" + year3notes + ", year1notes=" + year1notes + ", yearhalfnotes=" + yearhalfnotes
				+ ", code=" + code + "]";
	}

	
	
	
	
	



}
