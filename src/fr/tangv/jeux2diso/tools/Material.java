package fr.tangv.jeux2diso.tools;

public enum Material implements Loading{
	
	air(0, (byte)0, ResourceImage.air, "air", false),
	feriume_green(1, (byte)0, ResourceImage.feriumegreen, "feriume_green", true),
	feriume_orange(1, (byte)1, ResourceImage.feriumeorange, "feriume_orange", true),
	feriume_blue(1, (byte)2, ResourceImage.feriumeblue, "feriume_blue", true);
	
	public static Material getMaterial(int id, int data) {
		for (Material material : Material.values()) {
			if (material.getId() == id && material.getData() == data) {
				return material;
			}
		}
		return null;
	}
	
	public static Material getMaterial(String name) {
		for (Material material : Material.values()) {
			if (material.getName().equalsIgnoreCase(name)) {
				return material;
			}
		}
		return null;
	}
	
	private int id;
	private byte data;
	private ResourceImage img;
	private String name;
	private boolean solid;
	
	private Material(int id, byte data, ResourceImage img, String name, boolean solid) {
		this.img = img;
		this.id = id;
		this.data = data;
		this.name = name;
		this.solid = solid;
	}
	
	@Override
	public void ini() {}
	
	public boolean isSolid() {
		return solid;
	}
	
	public ResourceImage getResourceImage() {
		return img;
	}
	
	public int getId() {
		return id;
	}
	
	public byte getData() {
		return data;
	}
	
	public String getName() {
		return name;
	}
	
}
