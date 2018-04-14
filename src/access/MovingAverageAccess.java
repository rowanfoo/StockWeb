package access;

import java.util.Date;

public class MovingAverageAccess  extends AccessObject {

	
	public MovingAverageAccess  (String code , Date date){
		this.code=code;
		this.date=date;
	}
	
	private int nodayBelow50MAfor120d;
	private int nodayBelow50MAfor240d;
	private int nodayBelow20MAfor60d;
	
	public int getNodayBelow50MAfor120d() {
		return nodayBelow50MAfor120d;
	}
	public void setNodayBelow50MAfor120d(int nodayBelow50MAfor120d) {
		this.nodayBelow50MAfor120d = nodayBelow50MAfor120d;
	}
	public int getNodayBelow50MAfor240d() {
		return nodayBelow50MAfor240d;
	}
	public void setNodayBelow50MAfor240d(int nodayBelow50MAfor240d) {
		this.nodayBelow50MAfor240d = nodayBelow50MAfor240d;
	}
	public int getNodayBelow20MAfor60d() {
		return nodayBelow20MAfor60d;
	}
	public void setNodayBelow20MAfor60d(int nodayBelow20MAfor60d) {
		this.nodayBelow20MAfor60d = nodayBelow20MAfor60d;
	}
	
	
	
}
