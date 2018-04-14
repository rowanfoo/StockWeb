package access;

import java.util.ArrayList;
import java.util.Date;

public class NewsAccess extends AccessObject{
	
	private String link;
	
	private String title;
	private String seen;
	private String ok;
	private String notes;
	private String yes;
	private String yesNotes;
	private ArrayList<NewsAccess> newsCollection;
	
	public NewsAccess(String code , Date date ,String link, String title, String seen, String ok, String notes, String yes, String yesNotes) {
		super();
		this.code=code ;
		this.date=date; 
		this.link = link;
		this.title = title;
		this.seen = seen;
		this.ok = ok;
		this.notes = notes;
		this.yes = yes;
		this.yesNotes = yesNotes;
	}
	public NewsAccess(String code , Date date ,String link, String title) {
		super();
		this.code=code ;
		this.date=date; 
		this.link = link;
		this.title = title;
		this.seen = "";
		this.ok = "";
		this.notes = "";
		this.yes = "";
		this.yesNotes = "";
	}
	
	
	
	public void addNewsCollection (NewsAccess obj){
		if(newsCollection==null )newsCollection = new ArrayList<NewsAccess>();
		newsCollection.add(obj);
	}

	public ArrayList<NewsAccess> getNewsCollection (){
		if(newsCollection==null )newsCollection = new ArrayList<NewsAccess>();
		
		if(!newsCollection.contains(this ))newsCollection.add(this);
		return newsCollection;
	}

	
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSeen() {
		return seen;
	}
	public void setSeen(String seen) {
		this.seen = seen;
	}
	public String getOk() {
		return ok;
	}
	public void setOk(String ok) {
		this.ok = ok;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getYes() {
		return yes;
	}
	public void setYes(String yes) {
		this.yes = yes;
	}
	public String getYesNotes() {
		return yesNotes;
	}
	public void setYesNotes(String yesNotes) {
		this.yesNotes = yesNotes;
	}

	
	@Override
	public String toString() {
		return "NewsAccess [link=" + link + ", title=" + title + ", seen=" + seen + ", ok=" + ok + ", notes=" + notes
				+ ", yes=" + yes + ", yesNotes=" + yesNotes + ", code=" + code + ", date=" + date + "]";
	}

	
	
	
	
	

}
