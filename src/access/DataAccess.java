package access;

import java.util.Date;


public class DataAccess extends AccessObject {
	private double open;
	private double high;
	private double low;
	private double close;
	private String closeVol;
	private double volume;
	private double changes;
	private double changePercent;
	private String previousClose;
	private double avg3mth;
	private double fifty;
	private double fiftychg;
	private double twohundred;
	private double twohundredchg;
	private double myAvg;
	private double  sevenfive;
	private double  sevenfivechg;
	private double  twenty;
	private double  twentychg;
	private double  relativeStrenght;
	private double  rsi;
	private double  rsivol;
	private double fourty;
	private double fourtychg;
	private double onehundredfifty;
	private double onehundredfiftychg;


	private double fourhundred;
	private double fourhundredchg;

	//'top0.5b'
	
	
	
	
	
	public  DataAccess (){
		
	}

	
	


	public double getFourhundred() {
		return fourhundred;
	}





	public void setFourhundred(double fourhundred) {
		this.fourhundred = fourhundred;
	}





	public double getFourhundredchg() {
		return fourhundredchg;
	}





	public void setFourhundredchg(double fourhundredchg) {
		this.fourhundredchg = fourhundredchg;
	}





	public double getRelativeStrenght() {
		return relativeStrenght;
	}


	public void setRelativeStrenght(double relativeStrenght) {
		this.relativeStrenght = relativeStrenght;
	}


	public double getSevenfive() {
		return sevenfive;
	}

	public void setSevenfive(double sevenfive) {
		this.sevenfive = sevenfive;
	}

	public double getSevenfivechg() {
		return sevenfivechg;
	}

	public void setSevenfivechg(double sevenfivechg) {
		this.sevenfivechg = sevenfivechg;
	}

	public double getTwenty() {
		return twenty;
	}

	public void setTwenty(double twenty) {
		this.twenty = twenty;
	}

	public double getTwentychg() {
		return twentychg;
	}

	public void setTwentychg(double twentychg) {
		this.twentychg = twentychg;
	}


	

	public double getMyAvg() {
		return myAvg;
	}

	public void setMyAvg(double myAvg) {
		this.myAvg = myAvg;
	}
	
	public DataAccess(double open, double high, double low, double close, String closeVol, double volume, double changes,
			double changePercent, String previousClose, double avg3mth, double fifty, double fiftychg,
			double twohundred, double twohundredchg,   String code, Date date) {
		super();
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.closeVol = closeVol;
		this.volume = volume;
		this.changes = changes;
		this.changePercent = changePercent;
		this.previousClose = previousClose;
		this.avg3mth = avg3mth;
		this.fifty = fifty;
		this.fiftychg = fiftychg;
		this.twohundred = twohundred;
		this.twohundredchg = twohundredchg;
		this.code = code;
		this.date = date;
	}
	
	//double fourty,double fourtychg,double onehundredfifty,double onehundredfiftychg
	
	
	
	public DataAccess(double open, double high, double low, double close, String closeVol, double volume, double changes,
			double changePercent, String previousClose, double avg3mth, double fifty, double fiftychg,
			double twohundred, double twohundredchg, String code, Date date,double relativeStrenght,double  rsi,double  rsivol) {
		super();
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.closeVol = closeVol;
		this.volume = volume;
		this.changes = changes;
		this.changePercent = changePercent;
		this.previousClose = previousClose;
		this.avg3mth = avg3mth;
		this.fifty = fifty;
		this.fiftychg = fiftychg;
		this.twohundred = twohundred;
		this.twohundredchg = twohundredchg;
		this.code = code;
		this.date = date;
		this.relativeStrenght=relativeStrenght;
		this.rsi=rsi;
		this.rsivol=rsivol;
		
	}

	
	
	
	public double getRsi() {
		return rsi;
	}


	public void setRsi(double rsi) {
		this.rsi = rsi;
	}


	public double getRsivol() {
		return rsivol;
	}


	public void setRsivol(double rsivol) {
		this.rsivol = rsivol;
	}


	public DataAccess(String code, Date date) {
		this.code = code;
		this.date = date;
	}

	public double getOpen() {
		return open;
	}

	public void setOpen(double open) {
		this.open = open;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getClose() {
		return close;
	}

	public void setClose(double close) {
		this.close = close;
	}

	public String getCloseVol() {
		return closeVol;
	}

	public void setCloseVol(String closeVol) {
		this.closeVol = closeVol;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getChanges() {
		return changes;
	}

	public void setChanges(double changes) {
		this.changes = changes;
	}

	public double getChangePercent() {
		return changePercent;
	}

	public void setChangePercent(double changePercent) {
		this.changePercent = changePercent;
	}

	public String getPreviousClose() {
		return previousClose;
	}

	public void setPreviousClose(String previousClose) {
		this.previousClose = previousClose;
	}

	public double getAvg3mth() {
		return avg3mth;
	}

	public void setAvg3mth(double avg3mth) {
		avg3mth = avg3mth;
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

	public double getTwohundred() {
		return twohundred;
	}

	public void setTwohundred(double twohundred) {
		this.twohundred = twohundred;
	}

	public double getTwohundredchg() {
		return twohundredchg;
	}

	public void setTwohundredchg(double twohundredchg) {
		this.twohundredchg = twohundredchg;
	}
	public double getFourty() {
		return fourty;
	}


	public void setFourty(double fourty) {
		this.fourty = fourty;
	}


	public double getFourtychg() {
		return fourtychg;
	}


	public void setFourtychg(double fourtychg) {
		this.fourtychg = fourtychg;
	}


	public double getOnehundredfifty() {
		return onehundredfifty;
	}


	public void setOnehundredfifty(double onehundredfifty) {
		this.onehundredfifty = onehundredfifty;
	}


	public double getOnehundredfiftychg() {
		return onehundredfiftychg;
	}


	public void setOnehundredfiftychg(double onehundredfiftychg) {
		this.onehundredfiftychg = onehundredfiftychg;
	}
	@Override
	public String toString() {
//		return "DataAccess [open=" + open + ", high=" + high + ", low=" + low + ", close=" + close + ", closeVol="
//				+ closeVol + ", volume=" + volume + ", changes=" + changes + ", changePercent=" + changePercent
//				+ ", previousClose=" + previousClose + ", Avg3mth=" + avg3mth + ", fifty=" + fifty + ", fiftychg="
//				+ fiftychg + ", twohundred=" + twohundred + ", twohundredchg=" + twohundredchg + ", myAvg=" + myAvg
//				+ ", sevenfive=" + sevenfive + ", sevenfivechg=" + sevenfivechg + ", twenty=" + twenty + ", twentychg="
//				+ twentychg + "]";
	return "DataAccess [ date ="+date+"]";
	}

	

}
