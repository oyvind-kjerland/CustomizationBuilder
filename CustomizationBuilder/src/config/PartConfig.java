package config;

public class PartConfig implements ConfigInfo {

	private String name;
	private PartType type;
	private boolean useImage;
	
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
	
	public boolean getUseImage() {
		return useImage;
	}
	public void setUseImage(boolean useImage) {
		this.useImage = useImage;
	}
	
	public String toString() {
		return getName();
	}
}
