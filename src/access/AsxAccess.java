package access;

import java.util.Date;

public class AsxAccess extends AccessObject{



String category;
String name;

String notes;
String ok;
int id;
final int  total=2914;






public AsxAccess(String code,Date date, String category, String name,  String notes, String ok,int id) {
	super();
	this.category = category;
	this.name = name;
	this.code = code;
	this.notes = notes;
	this.ok = ok;
	this.date=date;
	this.id=id;
}

public int getPercent() {
	return (id/total)*100;
}

public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}

public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}


public String getNotes() {
	return notes;
}
public void setNotes(String notes) {
	this.notes = notes;
}
public String getOk() {
	return ok;
}
public void setOk(String ok) {
	this.ok = ok;
}


@Override
public String toString() {
	return "AsxAccess [category=" + category + ", name=" + name + ", notes=" + notes + ", ok=" + ok + ", code=" + code
			+ ", date=" + date + "]";
}





}
