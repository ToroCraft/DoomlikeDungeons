package jaredbgreat.dldungeons.pieces.chests;

/* 
 * This mod is the creation and copyright (c) 2015 
 * of Jared Blackburn (JaredBGreat).
 * 
 * It is licensed under the creative commons 4.0 attribution license: * 
 * https://creativecommons.org/licenses/by/4.0/legalcode
*/	

import jaredbgreat.dldungeons.ConfigHandler;
import jaredbgreat.dldungeons.builder.DBlock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraftforge.common.ChestGenHooks;

/**
 * This represents the treasure chests found in destination nodes
 * (a.k.a., "boss rooms").  Each should have some of all three loot
 * types, generally of a high level. 
 * 
 * @author Jared Blackburn
 *
 */
public class TreasureChest extends BasicChest {
	
	static ArrayList<Integer> slots = new ArrayList();	
	int slot;
	
	public TreasureChest(int x, int y, int z, int level) {
		super(x, y, z, level);
	}
	

	/**
	 * This will place some loot of every each type, being sure to use
	 *  a separate random slot for each item so that none are overwritten. 
	 */
	@Override
	public void place(World world, int x, int y, int z, Random random) {
		Collections.shuffle(slots, random);
		slot = 0;
		level += random.nextInt(2);
		if(level >= LootCategory.LEVELS) level = LootCategory.LEVELS - 1;
		ItemStack treasure;
		DBlock.placeChest(world, x, y, z);
		if(world.getBlock(x, y, z) != DBlock.chest) return;
		TileEntityChest contents = (TileEntityChest)world.getTileEntity(x, y, z);
		if(ConfigHandler.vanillaLoot) vanillaChest(contents, random);
		int num;
		num = random.nextInt(3 + (level / 3)) + 2;
		for(int i = 0; i < num; i++) {
			treasure = LootCategory.getLoot(LootType.HEAL, level, random);
			contents.setInventorySlotContents(slots.get(slot).intValue(), treasure);
			slot++;
		}
		num = random.nextInt(3 + (level / 3)) + 2;
		for(int i = 0; i < num; i++) {
			treasure = LootCategory.getLoot(LootType.GEAR, level, random);
			contents.setInventorySlotContents(slots.get(slot).intValue(), treasure);
			slot++;
		}
		if(ConfigHandler.stingyLoot) num = random.nextInt(3 + (level / 3)) + 2;
		else num = random.nextInt(3 + (level / 2)) + 2;
		for(int i = 0; i < num; i++) {
			treasure = LootCategory.getLoot(LootType.LOOT, level, random);
			contents.setInventorySlotContents(slots.get(slot).intValue(), treasure);
			slot++;
		}
		if(random.nextInt(7) < level) {
			if(level >= 6) {
				treasure = LootList.special.getLoot(random).getStack(random);
			}
			else treasure = LootList.discs.getLoot(random).getStack(random);
			contents.setInventorySlotContents(slots.get(slot).intValue(), treasure);
			slot++;
		}
	}
	
	
	private void vanillaChest(TileEntityChest chest, Random random) {
		int which = random.nextInt(4);
		ChestGenHooks chinf;
		switch (which) {
		case 0:
			chinf = ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST);
			break;
		case 1:
			chinf = ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST);
			break;
		default:
			chinf = ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST);
			break;
		}		
        WeightedRandomChestContent.generateChestContents(random, 
        		chinf.getItems(random), chest, chinf.getCount(random));
	}
	
	
	/**
	 * Returns true if a the slot is a valid part of a chests inventory.
	 * 
	 * @param slot
	 * @return
	 */
	private boolean validSlot(int slot) {
		return ((slot >= 0) && (slot < 27));
	}
	
	
	/**
	 * Initializes the slots list, which is shuffled to randomize item location in
	 * the chest without the risk of over writing one item with the another.  Called
	 * nut LootList.addDefaultLoot to populate the list.
	 */
	public static void initSlots() {
		// Overkill fix for previous bug; the first and last slot
		for(int i = 0; i < 27; i++) slots.add(new Integer(i));
	}
}
