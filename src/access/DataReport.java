package access;
import java.text.DecimalFormat;
public class DataReport extends AccessObject{

	double yearHigh;
	double yearBottom;
	double monthHigh;
	double monthBottom;
	double weakHigh;
	double weakBottom;
	
	
	double yearAvgChangePercentGreen;
	double yearAvgChangePercentRed;

	double monthAvgChangePercentGreen;
	double monthAvgChangePercentRed;
	double monthAvgfiftyGreen;
	
	double monthAvgfiftyRed;
	double avgMonthAvgfiftyRed;
	double distanceMonthAvgfiftyRed;
	double priceVariance;
	int  monthVariance;
	
	
	
	String dateFY;
	double earning;
	double monthLowFY;
	double pe;
	String sdate;
	double downvsupratioPrice;
	
	double downvsupratioVolume ;
	
	double tenmonthchgMax;
	double tenmonthchgMin;
	
	//s
	
	
	
	
	public double getTenmonthchgMax() {
		return  Math.round(tenmonthchgMax*100);
	}
	public void setTenmonthchgMax(double tenmonthchgMax) {
		this.tenmonthchgMax = tenmonthchgMax;
	}
	public double getTenmonthchgMin() {
		return  Math.round(tenmonthchgMin*100);
	}
	public void setTenmonthchgMin(double tenmonthchgMin) {
		this.tenmonthchgMin = tenmonthchgMin;
	}
	public double getPriceVariance() {
		return priceVariance;
	}
	public void setPriceVariance(double priceVariance) {
		this.priceVariance = priceVariance;
	}
	public int getMonthVariance() {
		return monthVariance;
	}
	public void setMonthVariance(int monthVariance) {
		this.monthVariance = monthVariance;
	}
	public double getAvgMonthAvgfiftyRed() {
		return avgMonthAvgfiftyRed;
	}
	public void setAvgMonthAvgfiftyRed(double avgMonthAvgfiftyRed) {
		this.avgMonthAvgfiftyRed = avgMonthAvgfiftyRed;
	}
	public double getDistanceMonthAvgfiftyRed() {
		return avgMonthAvgfiftyRed-monthAvgfiftyRed;
	}
	

	public double getDownvsupratioPrice() {
		return downvsupratioPrice;
	}
	public void setDownvsupratioPrice(double downvsupratioPrice) {
		this.downvsupratioPrice = downvsupratioPrice;
	}
	public double getDownvsupratioVolume() {
		return downvsupratioVolume;
	}
	public String  getDownvsupratioVolumeFormated() {
		 DecimalFormat df = new DecimalFormat("#.###");
		 return df.format( downvsupratioVolume);
		
	}
	
	public void setDownvsupratioVolume(double downvsupratioVolume) {
		this.downvsupratioVolume = downvsupratioVolume;
	}
	
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public double getYearHigh() {
		return yearHigh;
	}
	public void setYearHigh(double yearHigh) {
		this.yearHigh = yearHigh;
	}
	public double getYearBottom() {
		return yearBottom;
	}
	public void setYearBottom(double yearBottom) {
		this.yearBottom = yearBottom;
	}
	public double getMonthHigh() {
		return monthHigh;
	}
	public void setMonthHigh(double monthHigh) {
		this.monthHigh = monthHigh;
	}
	public double getMonthBottom() {
		return monthBottom;
	}
	public void setMonthBottom(double monthBottom) {
		this.monthBottom = monthBottom;
	}
	public double getWeakHigh() {
		return weakHigh;
	}
	public void setWeakHigh(double weakHigh) {
		this.weakHigh = weakHigh;
	}
	public double getWeakBottom() {
		return weakBottom;
	}
	public void setWeakBottom(double weakBottom) {
		this.weakBottom = weakBottom;
	}
	public double getYearAvgChangePercentGreen() {
		return yearAvgChangePercentGreen;
	}
	public void setYearAvgChangePercentGreen(double yearAvgChangePercentGreen) {
		this.yearAvgChangePercentGreen = yearAvgChangePercentGreen;
	}
	public double getYearAvgChangePercentRed() {
		return yearAvgChangePercentRed;
	}
	public void setYearAvgChangePercentRed(double yearAvgChangePercentRed) {
		this.yearAvgChangePercentRed = yearAvgChangePercentRed;
	}
	public double getMonthAvgChangePercentGreen() {
		return monthAvgChangePercentGreen;
	}
	public void setMonthAvgChangePercentGreen(double monthAvgChangePercentGreen) {
		this.monthAvgChangePercentGreen = monthAvgChangePercentGreen;
	}
	public double getMonthAvgChangePercentRed() {
		return monthAvgChangePercentRed;
	}
	public void setMonthAvgChangePercentRed(double monthAvgChangePercentRed) {
		this.monthAvgChangePercentRed = monthAvgChangePercentRed;
	}
	public double getMonthAvgfiftyGreen() {
		return monthAvgfiftyGreen;
	}
	public void setMonthAvgfiftyGreen(double monthAvgfiftyGreen) {
		this.monthAvgfiftyGreen = monthAvgfiftyGreen;
	}
	public double getMonthAvgfiftyRed() {
		return monthAvgfiftyRed;
	}
	public void setMonthAvgfiftyRed(double monthAvgfiftyRed) {
		this.monthAvgfiftyRed = monthAvgfiftyRed;
	}
	public String getDateFY() {
		return dateFY;
	}
	public void setDateFY(String dateFY) {
		this.dateFY = dateFY;
	}
	public double getEarning() {
		return earning;
	}
	public void setEarning(double earning) {
		this.earning = earning;
	}
	public double getMonthLowFY() {
		return monthLowFY;
	}
	public void setMonthLowFY(double monthLowFY) {
		this.monthLowFY = monthLowFY;
	}
	public double getPe() {
		return pe;
	}
	public void setPe(double pe) {
		this.pe = pe;
	}

	
	
	
	
	
	
	 
	
	
}
