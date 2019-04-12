package fr.tangv.jeux2diso.game;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.ResourceLoader;
import org.simpleyaml.configuration.file.YamlFile;
import org.simpleyaml.exceptions.InvalidConfigurationException;

public class Main {
	
	//comencé le 08/04/2019
	public static byte first = 0;
	public static final String rep = System.getenv("APPDATA")+"\\.Myjeuxtest\\";
	public static String repparametre;
	public static String replangue;
	public static final String version = "bêta_1.2";
	public static final String namegame = "Jeux Iso 2D Test";
	public static boolean low = false;
	
	public static boolean saveDefaultYamlFile(YamlFile yfile, String ref) throws InvalidConfigurationException, IOException{
		if (yfile.exists()) {
			try {
				yfile.load();
			} catch (Exception e) {
				sendConsol("Error with fileconfiguration "+yfile.getFilePath());
				System.exit(0);
			}
			return false;
		} else {
			InputStream in = ResourceLoader.getResourceAsStream(ref);
			File file = yfile.getConfigurationFile();
			file.mkdirs();
			file.delete();
			file.createNewFile();
			OutputStream out = new FileOutputStream(file);
			int k;
			byte[] b = new byte[1024];
			while ((k = in.read(b)) > 0) {
				out.write(b, 0, k);
			}
			out.flush();
			out.close();
			in.close();
			try {
				yfile.load();
			} catch (Exception e) {
				sendConsol("Error with fileconfiguration resoucre "+ref);
				System.exit(0);
			}
			return true;
		}
	}
	
	public static void sendConsol(String string) {
		System.out.println("[Jeux2DIso] "+string);
	}
	
	public static void main(String args[]) {
		if (args.length >= 1 && args[0].equalsIgnoreCase("-low"))
			low = true;
		//-Dorg.lwjgl.opengl.Display.allowSoftwareOpenGL=true
		try {
			sendConsol("Low: "+low);
			sendConsol("Name: "+namegame);
			sendConsol("Version: "+version);
			sendConsol("Reptoire: "+rep);
			repparametre = rep+"\\para-"+version;
			replangue = rep+"\\langue-"+version+'-';
			new App(namegame+' '+version);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
}
