package config;

import java.io.Serializable;
import java.util.ArrayList;

public class Config implements Serializable {

	private String name;
	
	private ArrayList<TeamConfig> teamConfigs;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void addTeamConfig(TeamConfig teamConfig) {
		teamConfigs.add(teamConfig);
	}
	public void removeTeamConfig(TeamConfig teamConfig) {
		teamConfigs.remove(teamConfig);
	}
	public ArrayList<TeamConfig> getTeamConfigs() {
		return teamConfigs;
	}
}
