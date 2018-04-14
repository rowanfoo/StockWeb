package access;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;




public class StockAccess extends AccessObject{


	String name;
	String descp;
	long shares;
	String marketCap;
	String category;
	String top;
	String notes1;
	String notes2;
	String reason;
	String moat;
	String fundNotes;
	double buyTrigger;
	String wishlist;
	String trend;
	double AlertPrice;
	double normandyPrice;
	String normandyNotes;
	String FYdate;
	String TechnicalNotes;
	String montlyNotes;
	String weeklyNotes;
	String DailyNotes;
	double stopLoss;
	String stopLossNotes;
	String whenBuy;
	double whenBuyPrice;
	String EasyChange;
	double keySupportPrice;
	String keySupportPriceNotes;
	
	String defendKeyNotes;
	double defendKeyPrice;
	
	String Nope;
	String news;	
	
	String chart;
	String subcategory;
	private long myMarketCap;
	String stageGrowth;
	DataAccess data;
	String research;
	String researchCat;
	
	String dailychart=null;
	String weeklychart=null;
	String monthlychart=null;
	
	String oneNotes;
	
	public static final String  top300cat="'50','100','200','300','top1b','top0.5b'";
	public static final String  topsmallcat="'top0.25b'";
	public static final String  topmidcapcat="'top0.5b'";
	
	
	
	
	
	
	public String getOneNotes() {
		return oneNotes;
	}
	public void setOneNotes(String oneNotes) {
		this.oneNotes = oneNotes;
	}
	
	public String getDailychart() {
		return dailychart;
	}
	public void setDailychart(String dailychart) {
		this.dailychart = dailychart;
	}
	public String getWeeklychart() {
		return weeklychart;
	}
	public void setWeeklychart(String weeklychart) {
		this.weeklychart = weeklychart;
	}
	public String getMonthlychart() {
		return monthlychart;
	}
	public void setMonthlychart(String monthlychart) {
		this.monthlychart = monthlychart;
	}
	public String getResearch() {
		return research;
	}
	public void setResearch(String research) {
		this.research = research;
	}
	public String getResearchCat() {
		return researchCat;
	}
	public void setResearchCat(String researchCat) {
		this.researchCat = researchCat;
	}
	public String getStageGrowth() {
		return stageGrowth;
	}
	public void setStageGrowth(String stageGrowth) {
		this.stageGrowth = stageGrowth;
	}
	public long getMyMarketCap() {
		return myMarketCap;
	}
	public void setMyMarketCap(long myMarketCap) {
		this.myMarketCap = myMarketCap;
	}
	

	public DataAccess getData() {
		return data;
	}


	public void setData(DataAccess data) {
		this.data = data;
	}


	public String getSubcategory() {
		return subcategory;
	}


	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}


	public StockAccess(){
		
	}


	public String getChart() {
		return chart;
	}




	public void setChart(String chart) {
		this.chart = chart;
	}




	public String getNews() {
		return news;
	}




	public void setNews(String news) {
		this.news = news;
	}




	public String getNope() {
		return Nope;
	}




	public void setNope(String nope) {
		Nope = nope;
	}




	public String getDefendKeyNotes() {
		return defendKeyNotes;
	}




	public void setDefendKeyNotes(String defendKeyNotes) {
		this.defendKeyNotes = defendKeyNotes;
	}




	public double getDefendKeyPrice() {
		return defendKeyPrice;
	}




	public void setDefendKeyPrice(double defendKeyPrice) {
		this.defendKeyPrice = defendKeyPrice;
	}




	public StockAccess(String code, Date date, String name, String descp, long shares, String marketCap,
			String category, String top, String notes1, String notes2, String reason, String moat, String fundNotes,
			double buyTrigger, String wishlist, String trend, double alertPrice, double normandyPrice,
			String normandyNotes, String fYdate, String technicalNotes, String montlyNotes, String weeklyNotes,
			String dailyNotes, double stopLoss, String stopLossNotes, String whenBuy, double whenBuyPrice,
			String easyChange, double keySupportPrice, String keySupportPriceNotes,double defendKeyPrice, String defendKeyNotes,String Nope,String news,String chart,String stageGrowth,String research,String researchCat,String oneNotes
	) {
		super();
		this.code = code;
		this.date = date;
		this.name = name;
		this.descp = descp;
		this.shares = shares;
		this.marketCap = marketCap;
		this.category = category;
		this.top = top;
		this.notes1 = notes1;
		this.notes2 = notes2;
		this.reason = reason;
		this.moat = moat;
		this.fundNotes = fundNotes;
		this.buyTrigger = buyTrigger;
		this.wishlist = wishlist;
		this.trend = trend;
		AlertPrice = alertPrice;
		this.normandyPrice = normandyPrice;
		this.normandyNotes = normandyNotes;
		FYdate = fYdate;
		TechnicalNotes = technicalNotes;
		this.montlyNotes = montlyNotes;
		this.weeklyNotes = weeklyNotes;
		DailyNotes = dailyNotes;
		this.stopLoss = stopLoss;
		this.stopLossNotes = stopLossNotes;
		this.whenBuy = whenBuy;
		this.whenBuyPrice = whenBuyPrice;
		EasyChange = easyChange;
		this.keySupportPrice = keySupportPrice;
		this.keySupportPriceNotes = keySupportPriceNotes;
		this.defendKeyNotes=defendKeyNotes;
		this.defendKeyPrice=defendKeyPrice;
		this.Nope=Nope;
		this.news=news;
		this.chart=chart;
		this.stageGrowth=stageGrowth;
		this.research=research;
		this.researchCat=researchCat;
		this.oneNotes=oneNotes;
		
		
	}


	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescp() {
		return descp;
	}


	public void setDescp(String descp) {
		this.descp = descp;
	}


	public long getShares() {
		
		return shares;
	}


	public void setShares(long shares) {
		this.shares = shares;
	}


	public String getMarketCap() {
		return marketCap;
	}


	public void setMarketCap(String marketCap) {
		this.marketCap = marketCap;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getTop() {
		return top;
	}


	public void setTop(String top) {
		this.top = top;
	}


	public String getNotes1() {
		return notes1;
	}


	public void setNotes1(String notes1) {
		this.notes1 = notes1;
	}


	public String getNotes2() {
		return notes2;
	}


	public void setNotes2(String notes2) {
		this.notes2 = notes2;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public String getMoat() {
		return moat;
	}


	public void setMoat(String moat) {
		this.moat = moat;
	}


	public String getFundNotes() {
		return fundNotes;
	}


	public void setFundNotes(String fundNotes) {
		this.fundNotes = fundNotes;
	}


	public double getBuyTrigger() {
		return buyTrigger;
	}


	public void setBuyTrigger(double buyTrigger) {
		this.buyTrigger = buyTrigger;
	}


	public String getWishlist() {
		return wishlist;
	}


	public void setWishlist(String wishlist) {
		this.wishlist = wishlist;
	}


	public String getTrend() {
		return trend;
	}


	public void setTrend(String trend) {
		this.trend = trend;
	}


	public double getAlertPrice() {
		return AlertPrice;
	}


	public void setAlertPrice(double alertPrice) {
		AlertPrice = alertPrice;
	}


	public double getNormandyPt() {
		return normandyPrice;
	}


	public void setNormandyPt(double normandyPt) {
		this.normandyPrice = normandyPt;
	}


	public String getNormandyNotes() {
		return normandyNotes;
	}


	public void setNormandyNotes(String normandyNotes) {
		this.normandyNotes = normandyNotes;
	}


	public String getFYdate() {
		return FYdate;
	}


	public void setFYdate(String fYdate) {
		FYdate = fYdate;
	}


	public String getTechnicalNotes() {
		return TechnicalNotes;
	}


	public void setTechnicalNotes(String technicalNotes) {
		TechnicalNotes = technicalNotes;
	}


	public String getMontlyNotes() {
		return montlyNotes;
	}


	public void setMontlyNotes(String montlyNotes) {
		this.montlyNotes = montlyNotes;
	}


	public String getWeeklyNotes() {
		return weeklyNotes;
	}


	public void setWeeklyNotes(String weeklyNotes) {
		this.weeklyNotes = weeklyNotes;
	}


	public String getDailyNotes() {
		return DailyNotes;
	}


	public void setDailyNotes(String dailyNotes) {
		DailyNotes = dailyNotes;
	}


	public double getStopLoss() {
		return stopLoss;
	}


	public void setStopLoss(double stopLoss) {
		this.stopLoss = stopLoss;
	}


	public String getStopLossNotes() {
		return stopLossNotes;
	}


	public void setStopLossNotes(String stopLossNotes) {
		this.stopLossNotes = stopLossNotes;
	}


	public String getWhenBuy() {
		return whenBuy;
	}


	public void setWhenBuy(String whenBuy) {
		this.whenBuy = whenBuy;
	}


	public double getWhenBuyPrice() {
		return whenBuyPrice;
	}


	public void setWhenBuyPrice(double whenBuyPrice) {
		this.whenBuyPrice = whenBuyPrice;
	}


	public String getEasyChange() {
		return EasyChange;
	}


	public void setEasyChange(String easyChange) {
		EasyChange = easyChange;
	}


	public double getKeySupportPrice() {
		return keySupportPrice;
	}


	public void setKeySupportPrice(double keySupportPrice) {
		this.keySupportPrice = keySupportPrice;
	}


	public String getKeySupportPriceNotes() {
		return keySupportPriceNotes;
	}


	public void setKeySupportPriceNotes(String keySupportPriceNotes) {
		this.keySupportPriceNotes = keySupportPriceNotes;
	}



	
	





	








	@Override
	public String toString() {
		return "StockAccess [name=" + name + ", descp=" + descp + ", shares=" + shares + ", marketCap=" + marketCap
				+ ", category=" + category + ", top=" + top + ", notes1=" + notes1 + ", notes2=" + notes2 + ", reason="
				+ reason + ", moat=" + moat + ", fundNotes=" + fundNotes + ", buyTrigger=" + buyTrigger + ", wishlist="
				+ wishlist + ", trend=" + trend + ", AlertPrice=" + AlertPrice + ", normandyPrice=" + normandyPrice
				+ ", normandyNotes=" + normandyNotes + ", FYdate=" + FYdate + ", TechnicalNotes=" + TechnicalNotes
				+ ", montlyNotes=" + montlyNotes + ", weeklyNotes=" + weeklyNotes + ", DailyNotes=" + DailyNotes
				+ ", stopLoss=" + stopLoss + ", stopLossNotes=" + stopLossNotes + ", whenBuy=" + whenBuy
				+ ", whenBuyPrice=" + whenBuyPrice + ", EasyChange=" + EasyChange + ", keySupportPrice="
				+ keySupportPrice + ", keySupportPriceNotes=" + keySupportPriceNotes + ", defendKeyNotes="
				+ defendKeyNotes + ", defendKeyPrice=" + defendKeyPrice + ", Nope=" + Nope + ", news=" + news
				+ ", chart=" + chart + "]";
	}




	public StockAccess(String code, String  date, String name, String descp, long shares, String marketCap,
			String category, String top, String notes1, String notes2, String reason, String moat, String fundNotes,
			double buyTrigger, String wishlist, String trend, double alertPrice, double  normandyPrice,
			String normandyNotes, String fYdate, String technicalNotes, String montlyNotes, String weeklyNotes,
			String dailyNotes, double stopLoss, String stopLossNotes, String whenBuy, double whenBuyPrice,
			String easyChange, double keySupportPrice, String keySupportPriceNotes, double defendKeyPrice, String defendKeyNotes,String Nope,String news,String chart,String stageGrowth,String research,String researchCat,String oneNotes)throws Exception  {
		super();
		this.code = code;
		this.date = changeDateToString(date);
		this.name = name;
		this.descp = descp;
		this.shares = shares;
		this.marketCap = marketCap;
		this.category = category;
		this.top = top;
		this.notes1 = notes1;
		this.notes2 = notes2;
		this.reason = reason;
		this.moat = moat;
		this.fundNotes = fundNotes;
		this.buyTrigger = buyTrigger;
		this.wishlist = wishlist;
		this.trend = trend;
		AlertPrice = alertPrice;
		this.normandyPrice = normandyPrice;
		this.normandyNotes = normandyNotes;
		FYdate = fYdate;
		TechnicalNotes = technicalNotes;
		this.montlyNotes = montlyNotes;
		this.weeklyNotes = weeklyNotes;
		DailyNotes = dailyNotes;
		this.stopLoss = stopLoss;
		this.stopLossNotes = stopLossNotes;
		this.whenBuy = whenBuy;
		this.whenBuyPrice = whenBuyPrice;
		EasyChange = easyChange;
		this.keySupportPrice = keySupportPrice;
		this.keySupportPriceNotes = keySupportPriceNotes;
		this.defendKeyNotes=defendKeyNotes;
		this.defendKeyPrice=defendKeyPrice;
		this.Nope=Nope;
		this.news=news;
		this.chart=chart;
		this.stageGrowth=stageGrowth;
		this.research=research;
		this.researchCat=researchCat;
		this.oneNotes=oneNotes;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
