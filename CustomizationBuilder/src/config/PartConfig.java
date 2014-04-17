package config;

public class PartConfig implements ConfigInfo {

	private String name;
	private PartType type;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public PartType getType() {
		return type;
	}
	public void setType(PartType type) {
		this.type = type;
	}
	
	
	public String toString() {
		return getName();
	}
}
