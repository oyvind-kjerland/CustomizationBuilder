package node;

public abstract class AbstractNode {

	// Comment
	protected String comment;
	
	// ShowLogic
	protected String showLogic;
	
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
	
	public void write() {
		
	}
}
