package fr.tangv.jeux2diso.tools;

import java.io.IOException;

import org.simpleyaml.configuration.file.YamlFile;
import org.simpleyaml.exceptions.InvalidConfigurationException;

import fr.tangv.jeux2diso.main.Main;

public enum ResourceLangue implements Loading {
	
	ini("ini"),
	buttonmenustartgame("buttonmenustartgame"),
	buttonmenuquit("buttonmenuquit");

	private String string;
	private String path;
	
	private boolean verif(String string) {
		if (yfilelangue.contains(string)) {
			return true;
		} else {
			try {
				yfilelangue.set(string, "---");
				yfilelangue.save();
				Main.sendConsol("Langue "+Parametre.parametre.getLangue()+" dont exists "+string);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
		}
	}
	
	private ResourceLangue(String path) {
		this.path = path;
	}
	
	public String getString() {
		return string;
	}

	private static YamlFile yfilelangue;
	
	@Override
	public void ini() {
		if (path.equalsIgnoreCase("ini")) {
			try {
				YamlFile yfilelanguefr = new YamlFile(Main.replangue+"fr");
				Main.saveDefaultYamlFile(yfilelanguefr, "res/langue/fr");
				yfilelangue = new YamlFile(Main.replangue+Parametre.parametre.getLangue());
				Main.saveDefaultYamlFile(yfilelangue, "res/langue/en");
			} catch (InvalidConfigurationException | IOException e) {
				e.printStackTrace();
			}
		} else {
			if (verif(path)) {
				string = yfilelangue.getString(path);
			} else {
				string = null;
			}
		}
	}
	
}
