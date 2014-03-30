package config;

import java.util.ArrayList;

public class KitConfig {

	private KitType type;
	private ArrayList<WeaponConfig> weaponConfigs = new ArrayList<WeaponConfig>();
	
	public KitType getType() {
		return type;
	}
	public void setType(KitType type) {
		this.type = type;
	}
	
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
