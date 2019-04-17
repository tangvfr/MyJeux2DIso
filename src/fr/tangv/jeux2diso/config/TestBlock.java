package fr.tangv.jeux2diso.config;

import java.util.HashMap;
import java.util.Map;

import org.simpleyaml.configuration.serialization.ConfigurationSerializable;

public class TestBlock implements ConfigurationSerializable {

	private String name;
	private double id;
	private float[] loc;
	
	public TestBlock(String name, float[] loc) {
		this.name = name;
		this.loc = loc;
		this.id = 12.25;
	}
	
	public String getName() {
		return name;
	}
	
	public double getId() {
		return id;
	}
	
	public float[] getLoc() {
		return loc;
	}
	
	@Override
	public Map<String, Object> serialize() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("id", id);
		map.put("loc", loc);
		return map;
	}

}
