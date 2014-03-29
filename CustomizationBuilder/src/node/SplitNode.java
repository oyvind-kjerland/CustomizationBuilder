package node;

import java.util.ArrayList;

public class SplitNode extends AbstractNode {
	
	// Hierarchy
	protected ArrayList<AbstractNode> children = new ArrayList<AbstractNode>();
	
	public ArrayList<AbstractNode> getChildren() {
		return children;
	}
	public void addChild(AbstractNode child) {
		if (!children.contains(child)) {
			children.add(child);
		}
	}
	public void removeChild(AbstractNode child) {
		children.remove(child);
	}
}
