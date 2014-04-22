package config;

import java.util.ArrayList;

public class SuffixConfig implements ConfigInfo {

	private String name;
	private ArrayList<PartConfig> skins = new ArrayList<PartConfig>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void addSkin(PartConfig skin) {
		skins.add(skin);
	}
	public void removeSkin(PartConfig skin) {
		skins.remove(skin);
	}
	public ArrayList<PartConfig> getSkins() {
		return skins;
	}
	public void setSkins(ArrayList<PartConfig> skins) {
		this.skins = skins;
	}
	
	public String toString() {
		return name;
	}
}
