package fr.tangv.jeux2diso.tools;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.simpleyaml.configuration.file.YamlFile;
import org.simpleyaml.exceptions.InvalidConfigurationException;

import fr.tangv.jeux2diso.game.Main;

public class Parametre {
	
	public static final Parametre parametre = new Parametre();
	public static Loading[] loading() {
		ArrayList<Loading> loading = new ArrayList<Loading>();
		loading.add(new Loading() {
			@Override public void ini() {
				try {
					Main.saveDefaultYamlFile(yfile, "res/para/para");
				} catch (InvalidConfigurationException | IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		Method[] methods = Parametre.class.getDeclaredMethods();
		for (Method method : methods) {
			if (method.getName().startsWith("get")) {
				loading.add(new Loading() {
					@Override public void ini() {
						try {
							method.invoke(parametre, new Object[] {});
						} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
							e.printStackTrace();
						}
					}
				});
			}
		}
		
		Loading[] load = new Loading[loading.size()];
		for (int i = 0; i < load.length; i++) {
			load[i] = loading.get(i);
		}
		return load;
	}
	
	private static final YamlFile yfile = new YamlFile(Main.repparametre);
	
	private boolean verif(String string) {
		if (yfile.contains(string)) {
			return true;
		} else {
			try {
				yfile.set(string, "---");
				yfile.save();
				Main.sendConsol("Paramtre dont exists "+string);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
		}
	}
	
	public String getLangue() {
		if (verif("langue")) {
			return yfile.getString("langue");
		} else {
			return null;
		}
	}
	
	public void setLangue(String langue) {
		yfile.set("langue", langue);
		try {
			yfile.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getForWard() {
		if (verif("forward")) {
			return yfile.getInt("forward");
		} else {
			return 0;
		}
	}
	
	public void setForWard(int key) {
		yfile.set("forward", key);
		try {
			yfile.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
