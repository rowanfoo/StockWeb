package access;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class TechStrAccess extends AccessObject{

	int mode;
	double close;
	double fifty;
	double fiftychg;
	long volume;
	double AvgVol;
	double changePercent;
	String seen;
	String OK;
	String Notes;
	String name;
	String calc;
	String lowlow;
	int fiftycount;
	StockAccess stock;
	double sixMonthPrice;
	double twohundredchg;
	double open;
	
	
	public double getOpen() {
		return open;
	}

	public void setOpen(double open) {
		this.open = open;
	}

	public double getTwohundredchg() {
		return twohundredchg;
	}

	public void setTwohundredchg(double twohundredchg) {
		this.twohundredchg = twohundredchg;
	}

	public double getSixMonthPrice() {
		return sixMonthPrice;
	}

	public void setSixMonthPrice(double sixMonthPrice) {
		this.sixMonthPrice = sixMonthPrice;
	}

	public StockAccess getStock() {
		return stock;
	}

	public void setStock(StockAccess stock) {
		this.stock = stock;
	}

	
	
	public String getLowLow() {
		return lowlow;
	}

	public void setLowLow(String lowLow) {
		this.lowlow = lowLow;
	}

	public TechStrAccess(String mycode,Date mydate){
		code=mycode	;
		date=mydate;
	}

	public TechStrAccess(String code,String mydate)throws Exception{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 date=dateFormat.parse(mydate);
	}

	public int getFiftycount() {
		int week = fiftycount/5;
		
		return week/4;
	}

	public void setFiftycount(int fiftycount) {
		this.fiftycount = fiftycount;
	}

	
	
	public TechStrAccess(String mycode,String mydate,int mmode,double mclose,double mfifty,double mfiftychg,long mvolume,double mAvgVol,double mchangePercent,String mseen,String mOK,String mNotes,int fiftycount,String lowLow,double sixMonthPrice,double twohundredchg,double open)throws Exception{
		code=mycode	;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		date=dateFormat.parse(mydate);;
		 mode=mmode;
		close=mclose;
		fifty=mfifty;
		fiftychg=mfiftychg;
		volume=mvolume;
		 AvgVol=mAvgVol;
		 changePercent=mchangePercent;
		 seen=mseen;
		 OK=mOK;
		Notes=mNotes;
		this.fiftycount=fiftycount;
		this.lowlow=lowLow;
		this. sixMonthPrice= sixMonthPrice;
		this.twohundredchg=twohundredchg;
		this.open=open;
		
		
	}
	public TechStrAccess(String mycode,Date mydate,int mmode,double mclose,double mfifty,double mfiftychg,long mvolume,double mAvgVol,double mchangePercent,String mseen,String mOK,String mNotes,int fiftycount,String lowLow,double sixMonthPrice,double twohundredchg,double open){
		code=mycode	;
		
		date=mydate;
		 mode=mmode;
		close=mclose;
		fifty=mfifty;
		fiftychg=mfiftychg;
		volume=mvolume;
		 AvgVol=mAvgVol;
		 changePercent=mchangePercent;
		 seen=mseen;
		 OK=mOK;
		Notes=mNotes;
		this.fiftycount=fiftycount;
		this.lowlow=lowLow;
		this. sixMonthPrice= sixMonthPrice;
		this.twohundredchg=twohundredchg;
		this.open=open;
		
		
	}
	public TechStrAccess(String mycode,Date mydate,String myname, int mmode,double mclose,double mfifty,double mfiftychg,long mvolume,double mAvgVol,double mchangePercent,String mseen,String mOK,String mNotes,int fiftycount,String lowLow,double sixMonthPrice,double twohundredchg,double open){
		code=mycode	;
		
		date=mydate;
		 mode=mmode;
		close=mclose;
		fifty=mfifty;
		fiftychg=mfiftychg;
		volume=mvolume;
		 AvgVol=mAvgVol;
		 changePercent=mchangePercent;
		 seen=mseen;
		 OK=mOK;
		Notes=mNotes;
		name=myname;
		this.lowlow=lowLow;
		this.fiftycount=fiftycount;
		this. sixMonthPrice= sixMonthPrice;
		this.twohundredchg=twohundredchg;
		this.open=open;
		
		
	}
	
	
	public String getCalc() {
		switch (mode) {
        case 1:  return  "Current 50ma:  "+fifty   + "below 50MA by 50% : "+fiftychg+"%";
        case 2:  return "Greater than 3 years below 50ma:"+fiftychg+"%";
        case 3:  return "Double the 3mth Avg   3mth Avg volume:"+AvgVol;
        case 4:  return "Up greater than 4% TODAY ";
        case 5:  return "20% from 50d";
        case 6:  return "3 day down";
        case 7:  return "> 5% but on small volume 50% avg3mth volume :"+volume ;
        case 8:  return "Fall for 3 month in a row .";
        case 9:  return "Down >4% today.  :drop : "+changePercent +"%" ;
        case 10:  return "Below 60d for greater than 6 months days : "+ getFiftycount()   +" months" ;
        
		}
		return "";
		
	}



	public String getModeUsefullNumber(){
		switch (mode) {
        case 1:  return  "Current 50ma:  "+fifty   + "$ below 50MA by 50% : "+fiftychg+"%";
        case 2:  return "Greater than 3 years below 50ma: "+fiftychg+"%";
        case 3:  return "Double the 3mth Avg   3mth Avg volume by: "+Math.round(  ( (volume/AvgVol)*100 ))  + " %" +":"+Math.round((changePercent*100))+"%" ;
        case 4:  return "Up greater than 4% TODAY ";
        case 5:  return "20% from 50d";
        case 6:  return "fallen for"+close+"day down max price:$"+fifty+ " low:$ "+fiftychg+ ": "+Math.round(( ((fifty-fiftychg)/fifty)*100 ) )+ " %"  ;
        case 7:  return "> 5% but on small volume 50% avg3mth volume : Price "+changePercent+": vs: volume " + Math.round(( (volume/AvgVol)*100 ) )+ " %" ; 
        case 8:  return "Fall for 3 month in a row .";
        case 9:  return "Down >4% today.  :drop : "+changePercent +"%" ;
        case 10:  return "Below 60d for greater than 6 months days : "+ getFiftycount()   +" months" ;
        case 11:  return "Day reversal  : low $"+ lowlow   +" vs close: $ "+close ;
        case 12:  return "Higher and higher low for 6 months: "+  this.lowlow   ;
        case 13:  return "Break  6 months low : six month low $"+sixMonthPrice+ " vs close price :$"+close     ;
        case 14:  return "Break  6 months high : six month high $"+sixMonthPrice+ " vs close price :$"+close     ;
        case 15:  return "Tigger Normandy price activated: $"+sixMonthPrice+ " vs close price :$"+close     ;
        case 16:  return "Price too far from 50d > 20%: $"+sixMonthPrice+ " vs close price :$"+close     ;
        case 17:  return "Tigger buy price activated: $"+close+ " 50d:$"+fifty+" : %"+ Math.round( (fiftychg)*100 )     ;
        case 18:  return "Lower and Lower volatility : "+lowlow     ;
        case 19:  return "Above 10month Average  close: $"+close +" :10 month change : "+ Math.round((twohundredchg*100))+"%"   ;
        case 20:  return "Break above 1$:"+close; 
        case 21:  return "Break below 1$:"+close; 
        case 22:  return "Break above 2$:"+close; 
        case 23:  return "Break round number : today close : $"+close +" vs Yesterday: $"+open; 
        case 24:  return "RSI oversold: $"+changePercent; 
        case 25:  return "RSI volume  > 70%: $"; 
        case 26:  return "CLOSE vol > 30%: $"+ (((long)fiftycount)/volume)*100 +"%"   ; 
        case 27:  return "RSI conseq down > 6 days :"+Notes   ; 
        case 28:  return "Down >40% in 8 mths: "+Notes   ; 
        case 29:  return "Above 20day Moving Average  close: "+close +" :20 day Moving average change : "+ Math.round((twohundredchg*100))+"%"   ;
        case 30:  return "20d cross 40d : %"+twohundredchg   ;
        case 31:  return "Above 150d: "+ Math.round((twohundredchg*100))+"%"   ;
        case 32:  return "200d cross 400d: %"+ Math.round((twohundredchg))+"%"      ;
        case 100:  return Notes   ; 
        case 101:  return "Fallen > 5 days and RSI <25"   ; 
		}
		return "";
		
	}
	
	
	public static String getModeString(int mode){
		switch (mode) {
        case 1:  return  "Smaller 5% from 50d";
        case 2:  return "Smaller 3 year average away from 50d";
        case 3:  return "Vol > 40% 3mth Avg  ";
        case 4:  return "Up  4% TODAY ";
        case 5:  return "20% from 50d";
        case 6:  return "3 consequtive day down";
        case 7:  return "Large fall .5% but on small volume 50% avg3mth vol";
        case 8:  return "Fall for 3 month in a row .";
        case 9:  return "Down 4% today";
        case 10:  return "Below 50d for greater than 6 months days : ";
        case 11:  return "Day reversal , with volume";
        case 12:  return "6 month , higher and higher low.";
        case 13:  return "Break 6 month low";
        case 14:  return "Break 6 month high";
        case 15:  return "Trigger Normandy  price Activated";
        case 16:  return " Trigger buy price Activated";
        case 17:  return "Price rally too far from 50d, >20%";
        case 18:  return "Leser and lesser volatility ";
        case 19:  return " Break 10 month Average <5%(just break) or >5%";
        case 20:  return "Break 1$ ";
        case 21:  return "Break below 1$";
        case 22:  return "Break above 2$";
        case 23:  return "Break round no";
        case 24:  return "RSI oversold <25";
        case 25:  return "RSI volume  > 70%"; 
        case 26:  return "CLOSE vol > 30%: "   ; 
        case 27:  return "RSI conseq 6 days :"   ; 
        case 28:  return "Down >40% in 8 mths: "   ; 
        case 29:  return "Above 20day Moving Average  close: $"   ;
        case 30:  return "20d cross 40d  :"    ;
        case 31:  return "Above 150d"   ;
        case 32:  return "200d cross 400d: ";
		}
		return "";
		
	} 
	
	
	
	

	@Override
	public String toString() {
		return "TechStrAccess [code=" + code + ", date=" + date + ", mode=" + mode + ", close=" + close + ", fifty="
				+ fifty + ", fiftychg=" + fiftychg + ", volume=" + volume + ", AvgVol=" + AvgVol + ", changePercent="
				+ changePercent + ", seen=" + seen + ", OK=" + OK + ", Notes=" + Notes + ", name=" + name + "]";
	}

	

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	public int getMode() {
		return mode;
	}
	public void setMode(int mode) {
		this.mode = mode;
	}
	public double getClose() {
		return close;
	}
	public void setClose(double close) {
		this.close = close;
	}
	public double getFifty() {
		return fifty;
	}
	public void setFifty(double fifty) {
		this.fifty = fifty;
	}
	public double getFiftychg() {
		return fiftychg;
	}
	public void setFiftychg(double fiftychg) {
		this.fiftychg = fiftychg;
	}
	public long getVolume() {
		return volume;
	}
	public void setVolume(long volume) {
		this.volume = volume;
	}
	public double getAvgVol() {
		return AvgVol;
	}
	public void setAvgVol(double avgVol) {
		AvgVol = avgVol;
	}
	public double getChangePercent() {
		return changePercent;
	}
	public void setChangePercent(double changePercent) {
		this.changePercent = changePercent;
	}
	public String getSeen() {
		return seen;
	}
	public void setSeen(String seen) {
		this.seen = seen;
	}
	public String getOK() {
		return OK;
	}
	public void setOK(String oK) {
		OK = oK;
	}
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		Notes = notes;
	}
	
	
	
	
	
	
	
	
}
