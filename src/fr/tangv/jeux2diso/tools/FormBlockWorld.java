package fr.tangv.jeux2diso.tools;

import fr.tangv.jeux2diso.objets.Block;
import fr.tangv.jeux2diso.objets.Location;
import fr.tangv.jeux2diso.objets.World;

public class FormBlockWorld {

	public static void setCube(Block block, Location location, Location tolocation) {
		World world = location.getWorld();
		
		int maxx = Math.max(location.getX(), tolocation.getX());
		int maxy = Math.max(location.getY(), tolocation.getY());
		int maxz = Math.max(location.getZ(), tolocation.getZ());
		
		int minx = Math.min(location.getX(), tolocation.getX());
		int miny = Math.min(location.getY(), tolocation.getY());
		int minz = Math.min(location.getZ(), tolocation.getZ());
		
		for (int x = minx; x <= maxx; x++) for (int z = minz; z <= maxz; z++) for (int y = miny; y <= maxy; y++) {
			world.setBlock(block, new Location(x, y, z, world));
		}
	}
	
	public static void setCubeArret(Block block, Location location, Location tolocation) {
		World world = location.getWorld();
		
		int maxx = Math.max(location.getX(), tolocation.getX());
		int maxy = Math.max(location.getY(), tolocation.getY());
		int maxz = Math.max(location.getZ(), tolocation.getZ());
		
		int minx = Math.min(location.getX(), tolocation.getX());
		int miny = Math.min(location.getY(), tolocation.getY());
		int minz = Math.min(location.getZ(), tolocation.getZ());
		
		for (int x = minx; x <= maxx; x++) {
			world.setBlock(block, new Location(x, maxy, maxz, world));
			world.setBlock(block, new Location(x, maxy, minz, world));
			world.setBlock(block, new Location(x, miny, minz, world));
			world.setBlock(block, new Location(x, miny, maxz, world));
		}
		
		for (int z = minz; z <= maxz; z++) {
			world.setBlock(block, new Location(maxx, miny, z, world));
			world.setBlock(block, new Location(maxx, maxy, z, world));
			world.setBlock(block, new Location(minx, maxy, z, world));
			world.setBlock(block, new Location(minx, miny, z, world));
		}
		
		for (int y = miny; y <= maxy; y++) {
			world.setBlock(block, new Location(maxx, y, maxz, world));
			world.setBlock(block, new Location(maxx, y, minz, world));
			world.setBlock(block, new Location(minx, y, minz, world));
			world.setBlock(block, new Location(minx, y, maxz, world));
		}
	}
	
}
