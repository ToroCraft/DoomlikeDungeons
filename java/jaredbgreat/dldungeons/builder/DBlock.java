package jaredbgreat.dldungeons.builder;

/* 
 * This mod is the creation and copyright (c) 2015 
 * of Jared Blackburn (JaredBGreat).
 * 
 * It is licensed under the creative commons 4.0 attribution license: * 
 * https://creativecommons.org/licenses/by/4.0/legalcode
*/	

import jaredbgreat.dldungeons.debug.Logging;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;

public final class DBlock {
	private final String id;   // The name
	private final Block block; // The Minecraft block
	private final int meta;	   // The blocks meta-data
	
	public static final Block spawner = Blocks.mob_spawner;
	public static final Block chest   = Blocks.chest;
	public static final Block portal1 = Blocks.end_portal_frame;
	public static final Block portal2 = Blocks.end_portal;
	public static final Block quartz  = Blocks.quartz_block;
	public static final Block lapis   = Blocks.lapis_block;
	public static final Block water   = Blocks.water;
	public static final Block air     = Blocks.air;
	
	public static final ArrayList<DBlock> registry = new ArrayList<DBlock>();
	
	
	private DBlock(String id) {
		this.id = id;
		StringTokenizer nums = new StringTokenizer(id, "({[]})");
		block = (Block)Block.getBlockFromName(nums.nextToken());
		if(block == null) {
			Logging.LogError("[DLDUNGEONS] ERROR! Block read as \"" + id 
					+ "\" was was not in registry (returned null).");
		}
		if(nums.hasMoreElements()) meta = Integer.parseInt(nums.nextToken());
		else meta  = 0;
	}
	
	
	private DBlock(String id, float version) throws NoSuchElementException {
		//System.out.println("[DLDUNGEONS] Loading block " + id + " as " + version);
		this.id = id;
		if(version < 1.7) {
			StringTokenizer nums = new StringTokenizer(id, "({[]})");
			block = (Block)Block.getBlockFromName(nums.nextToken());
			if(nums.hasMoreElements()) meta = Integer.parseInt(nums.nextToken());
			else meta = 0;
		} else {
			StringTokenizer nums = new StringTokenizer(id, ":({[]})");
			block = GameRegistry.findBlock(nums.nextToken(), nums.nextToken());
			if(nums.hasMoreElements()) meta = Integer.parseInt(nums.nextToken());
			else meta = 0;
		}
		if(block == null) {
			String error = "[DLDUNGEONS] ERROR! Block read as \"" + id 
					+ "\" was was not in registry (returned null).";
			Logging.LogError(error);
			throw new NoSuchElementException(error);
		}
	}
	
	
	public void placeNoMeta(World world, int x, int y, int z) {
		// This wrapper is a protection against possible changes in block representation,
		// e.g., abandoning the ID system, allowing any needed changes to be made here
		// instead of elsewhere. 
		if(!isProtectedBlock(world, x, y, z)) 
			world.setBlock(x, y, z, block);
	}
	
	
	public void place(World world, int x, int y, int z) {
		// This wrapper is a protection against possible changes in block representation,
		// e.g., abandoning the ID system, allowing any needed changes to be made here
		// instead of elsewhere. 
		if(!isProtectedBlock(world, x, y, z)) 
			world.setBlock(x, y, z, block, meta, 2);
	}
	
	
	/************************************************************************************/
	/*                STATIC UTILITIES BELOW (non-static methods above)                 */
	/************************************************************************************/
	
	
	public static void place(World world, int x, int y, int z, int block) {
		if(!isProtectedBlock(world, x, y, z)) 
				registry.get(block).place(world, x, y, z);
	}
	
	
	public static int add(String id) {
		DBlock block = new DBlock(id);
		if(!registry.contains(block)) {
			registry.add(block);
		}
		return registry.indexOf(block);
	}	
	
	
	public static int add(String id, float version) throws NoSuchElementException {
		DBlock block = new DBlock(id, version);
		if(!registry.contains(block)) {
			registry.add(block);
		}
		return registry.indexOf(block);
	}

	
	public static void placeBlock(World world, int x, int y, int z, Block block) {
		// This wrapper is a protection against possible changes in block representation,
		// e.g., abandoning the ID system, allowing any needed changes to be made here
		// instead of elsewhere. 
		if(!isProtectedBlock(world, x, y, z)) 
				world.setBlock(x, y, z, block);
	}
	
	
	public static void placeBlock(World world, int x, int y, int z, Block block, int a, int b) {
		// This wrapper is a protection against possible changes in block representation,
		// e.g., abandoning the ID system, allowing any needed changes to be made here
		// instead of elsewhere.
		if(!isProtectedBlock(world, x, y, z)) 
				world.setBlock(x, y, z, block, a, b);
	}
	
	
	public static void deleteBlock(World world, int x, int y, int z) {
		// This wrapper is a protection against possible changes in block representation,
		// e.g., abandoning the ID system, allowing any needed changes to be made here
		// instead of elsewere. 
		// world.setBlock(x, y, z, 0);
		if(!isProtectedBlock(world, x, y, z)) 
				world.setBlockToAir(x, y, z);
	}
	
	
	public static void deleteBlock(World world, int x, int y, int z, boolean flooded) {
		// This wrapper is a protection against possible changes in block representation,
		// e.g., abandoning the ID system, allowing any needed changes to be made here
		// instead of elsewere. 
		// world.setBlock(x, y, z, 0);
		if(isProtectedBlock(world, x, y, z)) return;
		if(flooded) world.setBlock(x, y, z, water); 
		else world.setBlockToAir(x, y, z);
	}
	
	
	public static void placeChest(World world, int x, int y, int z) {
		if(!isProtectedBlock(world, x, y, z))
			world.setBlock(x, y, z, chest, 0, 2);		
	}
	
	
	public static void placeSpawner(World world, int x, int y, int z, String mob) {
		if(isProtectedBlock(world, x, y, z)) return;
		placeBlock(world, x, y, z, spawner);
		TileEntityMobSpawner theSpawner = (TileEntityMobSpawner)world.getTileEntity(x, y, z);
		theSpawner.func_145881_a().setEntityName(mob);
		//world.setBlockMetadataWithNotify(x, y, z, 15, 7);
	}
	
	
	public static boolean isGroundBlock(World world, int x, int y, int z) {
		Material mat = ((Block)world.getBlock(x, y, z)).getMaterial();
		return 	   (mat == Material.grass) 
				|| (mat == Material.iron) 
				|| (mat == Material.ground) 
				|| (mat == Material.sand) 
				|| (mat == Material.rock) 
				|| (mat == Material.clay)
				|| (mat == Material.coral);
	}
	
	
	public static boolean isProtectedBlock(World world, int x, int y, int z) {
		Block block = world.getBlock(x, y, z);
		return (block == chest || block == spawner || 
				block == portal1 || block == portal2 || 
				block instanceof net.minecraft.block.BlockChest ||
				block instanceof net.minecraft.block.BlockEndPortalFrame ||
				block instanceof net.minecraft.block.BlockMobSpawner);
	}
	
	
	/************************************************************************************/
	/*                         BASIC OVERIDEN METHODS FROM OBJECT                       */
	/************************************************************************************/
	
	
	@Override
	public boolean equals(Object other) {
		if(!(other instanceof DBlock)) return false; 
		return ((id.hashCode() == ((DBlock)other).id.hashCode()));
	}
	
	
	@Override
	public int hashCode() {
		int a = Block.getIdFromBlock(block);
		a = (a << 4) + meta;
		a += (a << 16);
		return a;
	}
}
