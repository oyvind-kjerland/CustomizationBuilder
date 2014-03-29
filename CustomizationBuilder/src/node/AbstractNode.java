package node;

import java.util.ArrayList;

public abstract class AbstractNode {
	
	// Name
	protected String name;
	
	// Comment
	protected String comment;
	
	// ShowLogic
	protected String showLogic;
	

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getShowLogic() {
		return showLogic;
	}
	public void setShowLogic(String showLogic) {
		this.showLogic = showLogic;
	}
	

	
	
}

