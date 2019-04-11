package fr.tangv.jeux2diso.tools;

import java.io.IOException;
import java.util.Map;

import org.newdawn.slick.util.ResourceLoader;
import org.simpleyaml.configuration.file.YamlFile;
import org.simpleyaml.configuration.serialization.ConfigurationSerializable;
import org.simpleyaml.exceptions.InvalidConfigurationException;

import fr.tangv.jeux2diso.game.Main;

public class Parametre implements Loading, ConfigurationSerializable {
	
	public static final Parametre parametre = new Parametre();
	
	private YamlFile yfile = new YamlFile(Main.repparametre);
	
	@Override
	public Map<String, Object> serialize() {
		
		return null;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void ini() {
		try {
			if (yfile.exists()) {
				yfile.load();
			} else {
				yfile.load(ResourceLoader.getResourceAsStream("res/para/para"));
				yfile.createNewFile(true);
			}
		} catch (InvalidConfigurationException | IOException e) {
			e.printStackTrace();
		}
	}

}
