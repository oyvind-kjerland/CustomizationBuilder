package config;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ConfigManager {

	
	public final String ConfigPath = "config/%.xml";
	
	public void writeConfig(Config config, File file) throws IOException {
		FileOutputStream out = new FileOutputStream(file);
		BufferedOutputStream bufferedOut = new BufferedOutputStream(out);
		XMLEncoder encoder = new XMLEncoder(bufferedOut);
		encoder.writeObject(config);
		encoder.close();
		bufferedOut.close();
		out.close();
	}
	
	public Config readConfig(File file) throws IOException {
		FileInputStream in = new FileInputStream(file);
		BufferedInputStream bufferedIn = new BufferedInputStream(in);
		XMLDecoder decoder = new XMLDecoder(bufferedIn);
		Config config = (Config) decoder.readObject();
		decoder.close();
		bufferedIn.close();
		in.close();
		return config;
	}
	
	
	public void exportConfig(Config config, File configFile) {
		
		
		ScriptWriter sw = new ScriptWriter();
		
		sw.append("c = {");
		sw.newLine();
		sw.indent();
		sw.newLine();
		
		sw.append("[");
		
		for (TeamConfig teamConfig : config.getTeamConfigs()) {
			sw.append("'"+teamConfig.getName() + "',");
		}
		
		sw.append("],");
		
		sw.newLine();
		sw.newLine();
		
		sw.append("'kits':{");
		sw.indent();
		sw.newLine();
		
		for (TeamConfig teamConfig : config.getTeamConfigs()) {
			sw.append("'"+teamConfig.getName()+"':{");
			sw.indent();
			sw.newLine();
			
			for (KitConfig kitConfig : teamConfig.getKitConfigs()) {
				int typeId = kitConfig.getType().ordinal();
				
				sw.append("'"+typeId+"':{");
				sw.indent();
				sw.newLine();
				
				
				// Name
				sw.append("'name':'"+kitConfig.getName().toLowerCase()+"',");
				sw.newLine();
				// Image
				sw.append("'image':None,");
				sw.newLine();
				// Weapon
				sw.append("'weapon':{");
				sw.indent();
				sw.newLine();
				
				int i = 0;
				for (WeaponConfig weaponConfig : kitConfig.getWeaponConfigs()) {
					i++;
					if (i==4) break;
					sw.append("'weapon_"+i+"':{");
					sw.indent();
					sw.newLine();
					
					sw.append("'name':'"+weaponConfig.getName().toLowerCase()+"',");
					sw.newLine();
					
					// Sights
					sw.append("'sight':[");
					for (PartConfig sightConfig : weaponConfig.getPartsOfType(PartType.SIGHT)) {
						sw.append("'"+sightConfig.getName().toLowerCase());
						if (!sightConfig.getUseImage()) {
							sw.append("#N");
						}
						sw.append("',");
					}
					sw.append("],");
					sw.newLine();
					
					
					sw.append("'default_sight':'"+weaponConfig.getPartsOfType(PartType.SIGHT).get(0).toString().toLowerCase()+"',");
					sw.newLine();
					
					// Attachment
					sw.append("'attachment':[");
					for (PartConfig attachmentConfig : weaponConfig.getPartsOfType(PartType.ATTACHMENT)) {
						sw.append("'"+attachmentConfig.getName().toLowerCase());
						if (!attachmentConfig.getUseImage()) {
							sw.append("#N");
						}
						sw.append("',");
					}
					sw.append("],");
					sw.newLine();
					
					// Skin
					sw.append("'skin':[");
					for (PartConfig skinConfig : weaponConfig.getPartsOfType(PartType.SKIN)) {
						sw.append("'"+skinConfig.getName().toLowerCase()+"',");
					}
					sw.append("],");
					sw.newLine();
					
					sw.append("'camo':{");
					sw.indent();
					sw.newLine();
					
					
					for (PartConfig skinConfig : weaponConfig.getPartsOfType(PartType.SKIN)) {
						ArrayList<SuffixConfig> suffixes = new ArrayList<SuffixConfig>();
						
						for (SuffixConfig suffixConfig : config.getSuffixConfigs()) {
							if (suffixConfig.getSkins().contains(skinConfig)) {
								suffixes.add(suffixConfig);
							}
						}
						
						if (suffixes.size() == 0) {
							continue;
						}
						
						sw.append("'"+skinConfig.getName().toLowerCase()+"':[");
						
						for (SuffixConfig suffixConfig : suffixes) {
							sw.append("'"+suffixConfig.getName().toLowerCase()+"',");
						}
						
						sw.append("],");
						sw.newLine();
					}
					
					sw.deindent();
					sw.newLine();
					sw.append("},");
					sw.newLine();
					
					sw.deindent();
					sw.newLine();
					sw.append("},");
					sw.newLine();
				}
				
				for (int x=i+1; x<4; x++) {
					sw.append("'weapon_"+x+"':None,");
					sw.newLine();
				}
				
				
				sw.deindent();
				sw.newLine();
				sw.append("},");
				
				sw.deindent();
				sw.newLine();
				sw.append("},");
				sw.newLine();
				
			}
			
			sw.deindent();
			sw.newLine();
			sw.append("},");
			sw.newLine();
		}
		
		
		
		
		
		
		
		
		
		try {
			FileOutputStream out = new FileOutputStream(configFile);
			BufferedOutputStream bufferedOut = new BufferedOutputStream(out);
			byte[] byteArr = sw.getScript().getBytes();
			bufferedOut.write(byteArr);
			bufferedOut.close();
			out.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
