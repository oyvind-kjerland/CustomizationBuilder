package config;

import java.util.ArrayList;

public class Config {

	private String name;
	
	private ArrayList<TeamConfig> teamConfigs = new ArrayList<TeamConfig>();
	private ArrayList<WeaponConfig> weaponConfigs = new ArrayList<WeaponConfig>();
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// TeamConfig
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
	
	// WeaponConfig
	public void addWeaponConfig(WeaponConfig weaponConfig) {
		weaponConfigs.add(weaponConfig);
	}
	public void removeWeaponConfig(WeaponConfig weaponConfig) {
		weaponConfigs.remove(weaponConfig);
	}
	public ArrayList<WeaponConfig> getWeaponConfigs() {
		return weaponConfigs;
	}
	public void setWeaponConfigs(ArrayList<WeaponConfig> weaponConfigs) {
		this.weaponConfigs = weaponConfigs;
	}
}
