package node;


public abstract class AbstractNode {
	
	protected String name;
	
	protected String comment;
	
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

