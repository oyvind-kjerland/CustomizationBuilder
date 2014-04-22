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
					sw.append("'weapon_"+i+"':{");
					sw.indent();
					sw.newLine();
					
					sw.append("'name':'"+weaponConfig.getName().toLowerCase()+"',");
					sw.newLine();
					
					// Sights
					sw.append("'sight':[");
					for (PartConfig sightConfig : weaponConfig.getPartsOfType(PartType.SIGHT)) {
						sw.append("'"+sightConfig.getName().toLowerCase()+"',");
					}
					sw.append("],");
					sw.newLine();
					
					
					sw.append("'default_sight':'"+weaponConfig.getPartsOfType(PartType.SIGHT).get(0)+"',");
					sw.newLine();
					
					// Attachment
					sw.append("'attachment':[");
					for (PartConfig attachmentConfig : weaponConfig.getPartsOfType(PartType.ATTACHMENT)) {
						sw.append("'"+attachmentConfig.getName().toLowerCase()+"',");
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
					
					sw.deindent();
					sw.newLine();
					sw.append("},");
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
