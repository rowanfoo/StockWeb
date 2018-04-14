package access;

public class CategoryAccess extends AccessObject{



Long id;
String category;
//could be category or TOP
String type;

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}

public CategoryAccess(Long id, String category) {
	super();
	this.id = id;
	this.category = category;
}



}
