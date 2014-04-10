package config;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class Config implements ConfigInfo {

	private String name;
	
	private ArrayList<TeamConfig> teamConfigs = new ArrayList<TeamConfig>();
	private ArrayList<WeaponConfig> weaponConfigs = new ArrayList<WeaponConfig>();
	
	private transient PropertyChangeSupport pcs;
	
	
	public Config() {
		this.pcs = new PropertyChangeSupport(this);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// TeamConfig
	public void addTeamConfig(TeamConfig teamConfig) {
		teamConfigs.add(teamConfig);
		pcs.firePropertyChange("addTeamConfig", null, teamConfig);
		System.out.println("add team");
	}
	public void removeTeamConfig(TeamConfig teamConfig) {
		teamConfigs.remove(teamConfig);
		pcs.firePropertyChange("removeTeamConfig", teamConfig, null);
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
	
	// PropertyChangeSupport
	public void setPropertyChangeSupport() {
		this.pcs = new PropertyChangeSupport(this);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
		System.out.println("add listener");
	}
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}
}
