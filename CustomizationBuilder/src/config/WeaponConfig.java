package config;

import java.util.ArrayList;

public class WeaponConfig implements ConfigInfo {

	
	private String name;
	private ArrayList<PartConfig> parts = new ArrayList<PartConfig>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public void addPartConfig(PartConfig partConfig) {
		parts.add(partConfig);
	}
	
	public void removePartConfig(PartConfig partConfig) {
		parts.remove(partConfig);
	}
	public ArrayList<PartConfig> getPartConfigs() {
		return parts;
	}
	
	public ArrayList<PartConfig> getPartsOfType(PartType type) {
		ArrayList<PartConfig> partsOfType = new ArrayList<PartConfig>();
		for (PartConfig part : parts) {
			if (part.getType() == type) {
				partsOfType.add(part);
			}
		}
		return partsOfType;
	}
	
	public void setPartConfigs(ArrayList<PartConfig> parts) {
		this.parts = parts;
	}
	
	public String toString() {
		return name;
	}
}
