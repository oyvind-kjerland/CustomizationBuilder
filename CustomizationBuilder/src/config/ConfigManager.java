package config;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ConfigManager {

	
	public void writeConfig(Config config, String filename) throws IOException {
		FileOutputStream out = new FileOutputStream(filename);
		BufferedOutputStream bufferedOut = new BufferedOutputStream(out);
		XMLEncoder encoder = new XMLEncoder(bufferedOut);
		encoder.writeObject(config);
		encoder.close();
		bufferedOut.close();
		out.close();
	}
	
	public Config readConfig(String filename) throws IOException {
		FileInputStream in = new FileInputStream(filename);
		BufferedInputStream bufferedIn = new BufferedInputStream(in);
		XMLDecoder decoder = new XMLDecoder(bufferedIn);
		Config config = (Config) decoder.readObject();
		decoder.close();
		bufferedIn.close();
		in.close();
		return config;
	}
	
}
