package config;

import java.util.ArrayList;

public class Config {

	private String name;
	
	private ArrayList<TeamConfig> teamConfigs = new ArrayList<TeamConfig>();
	
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
	public void setTeamConfigs(ArrayList<TeamConfig> teamConfigs) {
		this.teamConfigs = teamConfigs;
	}
}
