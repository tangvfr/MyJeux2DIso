package fr.tangv.jeux2diso.tools;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.simpleyaml.configuration.file.YamlFile;
import org.simpleyaml.exceptions.InvalidConfigurationException;

import fr.tangv.jeux2diso.main.Main;

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
	
	public int getKeyForWard() {
		if (verif("keyforward")) {
			return yfile.getInt("keyforward");
		} else {
			return 0;
		}
	}
	
	public void setKeyForWard(int key) {
		yfile.set("keyforward", key);
		try {
			yfile.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getKeyBack() {
		if (verif("keyback")) {
			return yfile.getInt("keyback");
		} else {
			return 0;
		}
	}
	
	public void setKeyBack(int key) {
		yfile.set("keyback", key);
		try {
			yfile.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getKeyLeft() {
		if (verif("keyleft")) {
			return yfile.getInt("keyleft");
		} else {
			return 0;
		}
	}
	
	public void setKeyLeft(int key) {
		yfile.set("keyleft", key);
		try {
			yfile.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getKeyRight() {
		if (verif("keyright")) {
			return yfile.getInt("keyright");
		} else {
			return 0;
		}
	}
	
	public void setKeyRight(int key) {
		yfile.set("keyright", key);
		try {
			yfile.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getKeyUp() {
		if (verif("keyup")) {
			return yfile.getInt("keyup");
		} else {
			return 0;
		}
	}
	
	public void setKeyUp(int key) {
		yfile.set("keyup", key);
		try {
			yfile.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getKeyDown() {
		if (verif("keydown")) {
			return yfile.getInt("keydown");
		} else {
			return 0;
		}
	}
	
	public void setKeyDown(int key) {
		yfile.set("keydown", key);
		try {
			yfile.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
