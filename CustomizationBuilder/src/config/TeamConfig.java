package config;

import java.util.ArrayList;


public class TeamConfig {

	private String name;
	private ArrayList<KitConfig> kitConfigs = new ArrayList<KitConfig>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void addKitConfig(KitConfig kitConfig) {
		kitConfigs.add(kitConfig);
	}
	public void removeKitConfig(KitConfig kitConfig) {
		kitConfigs.remove(kitConfig);
	}
	public ArrayList<KitConfig> getKitConfigs() {
		return kitConfigs;
	}
	public void setKitConfigs(ArrayList<KitConfig> kitConfigs) {
		this.kitConfigs = kitConfigs;
	}
	
	public String toString() {
		return name;
	}
	
}
