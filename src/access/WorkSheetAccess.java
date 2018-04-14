package access;

import java.sql.Connection;
import java.util.Date;

import dao.DAO;

public class WorkSheetAccess extends AccessObject {
	
	String time;
	
	double buy;
	
	double stopLoss;
	String edate;
	String trend;
	String volatiles;
	String panic;
	String discounted;
	String multiMonth;
	String majorSupport;
	String meanRevision;
	String changeTrend;
	String sellergain;
	String reason;
	String Yes;
	
	public WorkSheetAccess( ){
		
	}



	public WorkSheetAccess(String code ,Date date, String time,String reason, double buy, double stopLoss, String edate, String trend, String volatiles,
			String panic, String discounted, String multiMonth, String majorSupport, String meanRevision,
			String changeTrend, String sellergain,String Yes) {
		super();
		this.code = code;
		this.date = date;
		this.time = time;
		this.reason= reason;
		this.buy = buy;
		this.stopLoss = stopLoss;
		this.edate = edate;
		this.trend = trend;
		this.volatiles = volatiles;
		this.panic = panic;
		this.discounted = discounted;
		this.multiMonth = multiMonth;
		this.majorSupport = majorSupport;
		this.meanRevision = meanRevision;
		this.changeTrend = changeTrend;
		this.sellergain = sellergain;
		this.Yes=Yes;
	}
	public WorkSheetAccess(String code ,String  date, String time,String reason, double buy, double stopLoss, String edate, String trend, String volatiles,
			String panic, String discounted, String multiMonth, String majorSupport, String meanRevision,
			String changeTrend, String sellergain,String Yes) {
		super();
		this.code = code;
		try {
			this.date = changeDateToString(date);
			
		} catch (Exception e) {
			System.out.println("Error converting date WorkSheetAccess :"+e );
		}
		
		this.time = time;
		this.reason= reason;
		this.buy = buy;
		this.stopLoss = stopLoss;
		this.edate = edate;
		this.trend = trend;
		this.volatiles = volatiles;
		this.panic = panic;
		this.discounted = discounted;
		this.multiMonth = multiMonth;
		this.majorSupport = majorSupport;
		this.meanRevision = meanRevision;
		this.changeTrend = changeTrend;
		this.sellergain = sellergain;
		this.Yes=Yes;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getBuy() {
		return buy;
	}

	public void setBuy(double buy) {
		this.buy = buy;
	}

	public double getStopLoss() {
		return stopLoss;
	}

	public void setStopLoss(double stopLoss) {
		this.stopLoss = stopLoss;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}

	public String getTrend() {
		return trend;
	}

	public void setTrend(String trend) {
		this.trend = trend;
	}

	public String getVolatiles() {
		return volatiles;
	}

	public void setVolatiles(String volatiles) {
		this.volatiles = volatiles;
	}

	public String getPanic() {
		return panic;
	}

	public void setPanic(String panic) {
		this.panic = panic;
	}

	public String getDiscounted() {
		return discounted;
	}

	public void setDiscounted(String discounted) {
		this.discounted = discounted;
	}

	public String getMultiMonth() {
		return multiMonth;
	}

	public void setMultiMonth(String multiMonth) {
		this.multiMonth = multiMonth;
	}

	public String getMajorSupport() {
		return majorSupport;
	}

	public void setMajorSupport(String majorSupport) {
		this.majorSupport = majorSupport;
	}

	public String getMeanRevision() {
		return meanRevision;
	}

	public void setMeanRevision(String meanRevision) {
		this.meanRevision = meanRevision;
	}

	public String getChangeTrend() {
		return changeTrend;
	}

	public void setChangeTrend(String changeTrend) {
		this.changeTrend = changeTrend;
	}

	public String getSellergain() {
		return sellergain;
	}

	public void setSellergain(String sellergain) {
		this.sellergain = sellergain;
	}
	public String getYes() {
		return Yes;
	}

	public void setYes(String yes) {
		Yes = yes;
	}
	@Override
	public String toString() {
		return "WorkSheetAccess [time=" + time + ", buy=" + buy + ", stopLoss=" + stopLoss + ", edate=" + edate
				+ ", trend=" + trend + ", volatiles=" + volatiles + ", panic=" + panic + ", discounted=" + discounted
				+ ", multiMonth=" + multiMonth + ", majorSupport=" + majorSupport + ", meanRevision=" + meanRevision
				+ ", changeTrend=" + changeTrend + ", sellergain=" + sellergain + ", code=" + code + ", date=" + date
				+ "]";
	}

	
	
	
	
}
