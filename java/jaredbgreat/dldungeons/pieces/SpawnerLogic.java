package jaredbgreat.dldungeons.pieces;

import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.world.World;


/* 
 * This mod is the creation and copyright (c) 2015 
 * of Jared Blackburn (JaredBGreat).
 * 
 * It is licensed under the creative commons 4.0 attribution license: * 
 * https://creativecommons.org/licenses/by/4.0/legalcode
*/		


/**  
 * This is far from done, if it ever will be; does nothing, DO NOT USE!
 * 
 *(In theory, it should replace the vanilla logic to create "hardcore" spawners that ignore the normal 
 * spanwing rules -- i.e., getCanSpawnHere() should be the most basic version, only testing block collisions.)
 */
public class SpawnerLogic extends MobSpawnerBaseLogic {
	private World spawnerWord;
	private int x;
	private int y;
	private int z;
	private String mob;

	
	@Override
	public void func_98267_a(int p_98267_1_) {
		// TODO Auto-generated method stub		
		
	}

	
	@Override
	public World getSpawnerWorld() {		
		return spawnerWord;
	}

	
	@Override
	public int getSpawnerX() {
		return x;
	}

	
	@Override
	public int getSpawnerY() {
		return y;
	}

	
	@Override
	public int getSpawnerZ() {
		return z;
	}
	
	
	@Override
    public void updateSpawner() {
		
	}
	
}
