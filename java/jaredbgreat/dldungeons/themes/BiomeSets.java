package jaredbgreat.dldungeons.themes;


/* 
 * This mod is the creation and copyright (c) 2015 
 * of Jared Blackburn (JaredBGreat).
 * 
 * It is licensed under the creative commons 4.0 attribution license: * 
 * https://creativecommons.org/licenses/by/4.0/legalcode
*/	


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

/**
 * This handles the determination of which themes to use in 
 * each biome.
 * 
 * Included a HashSets for various Forge biome dictionary types, 
 * storing which dungeons should appear in each.  Additional sets 
 * are used to store with themes should never appear in each.
 * 
 * In a given biome the possible dungeon themes equate to the union 
 * of inclusion defining sets for types that describe it followed 
 * by the subtraction of the union of the sets of forbidden themes 
 * for those types.
 * 
 * @author Jared Blackburn
 *
 */
public class BiomeSets {
	
	/*
	 * FIXME?: Lots of set variables:
	 * 
	 * This should probably been handled with a collection, 
	 * most likely a HashMap between the sets and the enum 
	 * constants used (or else their string representation.
	 */
	
	// For old types
	static HashSet<Theme> forest    = new HashSet<Theme>();
	static HashSet<Theme> plains    = new HashSet<Theme>();
	static HashSet<Theme> mountain  = new HashSet<Theme>();
	static HashSet<Theme> hills     = new HashSet<Theme>();
	static HashSet<Theme> swamp     = new HashSet<Theme>();
	static HashSet<Theme> water     = new HashSet<Theme>();
	static HashSet<Theme> desert    = new HashSet<Theme>();
	static HashSet<Theme> frozen    = new HashSet<Theme>();
	static HashSet<Theme> jungle    = new HashSet<Theme>();
	static HashSet<Theme> wasteland = new HashSet<Theme>();
	static HashSet<Theme> nether    = new HashSet<Theme>();
	static HashSet<Theme> end       = new HashSet<Theme>();
	static HashSet<Theme> mushroom  = new HashSet<Theme>();
	static HashSet<Theme> magical   = new HashSet<Theme>();
	//for new types
	static HashSet<Theme> hot        = new HashSet<Theme>();
	static HashSet<Theme> cold       = new HashSet<Theme>();
	static HashSet<Theme> sparse     = new HashSet<Theme>();
	static HashSet<Theme> dense      = new HashSet<Theme>();
	static HashSet<Theme> wet        = new HashSet<Theme>();
	static HashSet<Theme> dry        = new HashSet<Theme>();
	static HashSet<Theme> savanna    = new HashSet<Theme>();
	static HashSet<Theme> coniferous = new HashSet<Theme>();
	static HashSet<Theme> spooky     = new HashSet<Theme>();
	static HashSet<Theme> dead       = new HashSet<Theme>();
	static HashSet<Theme> lush       = new HashSet<Theme>();
	static HashSet<Theme> mesa       = new HashSet<Theme>();
	static HashSet<Theme> ocean     = new HashSet<Theme>();
	static HashSet<Theme> sandy      = new HashSet<Theme>();
	static HashSet<Theme> snowy      = frozen;
	static HashSet<Theme> minigame  = new HashSet<Theme>();
	
	// NEGATIONS	
	// For old types
	static HashSet<Theme> nforest    = new HashSet<Theme>();
	static HashSet<Theme> nplains    = new HashSet<Theme>();
	static HashSet<Theme> nmountain  = new HashSet<Theme>();
	static HashSet<Theme> nhills     = new HashSet<Theme>();
	static HashSet<Theme> nswamp     = new HashSet<Theme>();
	static HashSet<Theme> nwater     = new HashSet<Theme>();
	static HashSet<Theme> ndesert    = new HashSet<Theme>();
	static HashSet<Theme> nfrozen    = new HashSet<Theme>();
	static HashSet<Theme> njungle    = new HashSet<Theme>();
	static HashSet<Theme> nwasteland = new HashSet<Theme>();
	static HashSet<Theme> nnether    = new HashSet<Theme>();
	static HashSet<Theme> nend       = new HashSet<Theme>();
	static HashSet<Theme> nmushroom  = new HashSet<Theme>();
	static HashSet<Theme> nmagical   = new HashSet<Theme>();
	//for new types
	static HashSet<Theme> nhot        = new HashSet<Theme>();
	static HashSet<Theme> ncold       = new HashSet<Theme>();
	static HashSet<Theme> nsparse     = new HashSet<Theme>();
	static HashSet<Theme> ndense      = new HashSet<Theme>();
	static HashSet<Theme> nwet        = new HashSet<Theme>();
	static HashSet<Theme> ndry        = new HashSet<Theme>();
	static HashSet<Theme> nsavanna    = new HashSet<Theme>();
	static HashSet<Theme> nconiferous = new HashSet<Theme>();
	static HashSet<Theme> nspooky     = new HashSet<Theme>();
	static HashSet<Theme> ndead       = new HashSet<Theme>();
	static HashSet<Theme> nlush       = new HashSet<Theme>();
	static HashSet<Theme> nmesa       = new HashSet<Theme>();
	static HashSet<Theme> nocean      = new HashSet<Theme>();
	static HashSet<Theme> nsandy      = new HashSet<Theme>();
	static HashSet<Theme> nsnowy      = nfrozen;
	
    
	/**
	 * This will look at a themes biome type data and add it 
	 * to the proper sets for both inclusion in those type.
	 * 
	 * @param theme
	 */
    public static void registerTheme(Theme theme) {
		if(theme.biomes.contains(Type.END))       {
			end.add(theme);
		}
		if(theme.biomes.contains(Type.FOREST))    {
			forest.add(theme);
		}
		if(theme.biomes.contains(Type.SNOWY))    {
			frozen.add(theme);
		}
		if(theme.biomes.contains(Type.HILLS))     {
			hills.add(theme);
		}
		if(theme.biomes.contains(Type.JUNGLE))    {
			jungle.add(theme);
		}
		if(theme.biomes.contains(Type.MAGICAL))   {
			magical.add(theme);
		}
		if(theme.biomes.contains(Type.MOUNTAIN))  {
			mountain.add(theme);
		}
		if(theme.biomes.contains(Type.MUSHROOM))  {
			mushroom.add(theme);
		}
		if(theme.biomes.contains(Type.NETHER))    {
			nether.add(theme);
		}
		if(theme.biomes.contains(Type.PLAINS))    {
			plains.add(theme);
		}
		if(theme.biomes.contains(Type.SWAMP))     {
			swamp.add(theme);
		}
		if(theme.biomes.contains(Type.WASTELAND)) {
			wasteland.add(theme);
		}
		if(theme.biomes.contains(Type.WATER) || theme.biomes.contains(Type.BEACH)) {
			water.add(theme);  
		}
		if(theme.biomes.contains(Type.OCEAN)) {
			ocean.add(theme);  
		}
		if(theme.biomes.contains(Type.HOT))     {
			hot.add(theme);
		}
		if(theme.biomes.contains(Type.COLD))     {
			cold.add(theme);
		}
		if(theme.biomes.contains(Type.SPARSE))     {
			sparse.add(theme);
		}
		if(theme.biomes.contains(Type.DENSE))     {
			dense.add(theme);
		}
		if(theme.biomes.contains(Type.WET))     {
			wet.add(theme);
		}
		if(theme.biomes.contains(Type.DRY))     {
			dry.add(theme);
		}
		if(theme.biomes.contains(Type.SAVANNA))     {
			savanna.add(theme);
		}
		if(theme.biomes.contains(Type.CONIFEROUS))     {
			coniferous.add(theme);
		}
		if(theme.biomes.contains(Type.SPOOKY))     {
			spooky.add(theme);
		}
		if(theme.biomes.contains(Type.DEAD))     {
			dead.add(theme);
		}
		if(theme.biomes.contains(Type.LUSH))     {
			lush.add(theme);
		}
		if(theme.biomes.contains(Type.CONIFEROUS))     {
			coniferous.add(theme);
		}
		if(theme.biomes.contains(Type.MESA))     {
			mesa.add(theme);
		}
		if(theme.biomes.contains(Type.SANDY))     {
			sandy.add(theme);
		}
    }
	
    
    /**
     * This will use a themes biome data to added it 
     * to set for exclusion from appearing in biomes 
     * of a type.
     * 
     * @param theme
     */
    public static void removeTheme(Theme theme) {
		if(theme.notIn.contains(Type.END))       {
			nend.add(theme);
		}
		if(theme.notIn.contains(Type.FOREST))    {
			nforest.add(theme);
		}
		if(theme.notIn.contains(Type.SNOWY))    {
			nfrozen.add(theme);
		}
		if(theme.notIn.contains(Type.HILLS))     {
			nhills.add(theme);
		}
		if(theme.notIn.contains(Type.JUNGLE))    {
			njungle.add(theme);
		}
		if(theme.notIn.contains(Type.MAGICAL))   {
			nmagical.add(theme);
		}
		if(theme.notIn.contains(Type.MOUNTAIN))  {
			nmountain.add(theme);
		}
		if(theme.notIn.contains(Type.MUSHROOM))  {
			nmushroom.add(theme);
		}
		if(theme.notIn.contains(Type.NETHER))    {
			nnether.add(theme);
		}
		if(theme.notIn.contains(Type.PLAINS))    {
			nplains.add(theme);
		}
		if(theme.notIn.contains(Type.SWAMP))     {
			nswamp.add(theme);
		}
		if(theme.notIn.contains(Type.WASTELAND)) {
			nwasteland.add(theme);
		}
		if(theme.notIn.contains(Type.WATER) || theme.notIn.contains(Type.BEACH)) {
			nwater.add(theme);  	
		}
		if(theme.notIn.contains(Type.OCEAN)) {
			nocean.add(theme);  	
		}
		if(theme.notIn.contains(Type.HOT))     {
			nhot.add(theme);
		}
		if(theme.notIn.contains(Type.COLD))     {
			ncold.add(theme);
		}
		if(theme.notIn.contains(Type.SPARSE))     {
			nsparse.add(theme);
		}
		if(theme.notIn.contains(Type.DENSE))     {
			ndense.add(theme);
		}
		if(theme.notIn.contains(Type.WET))     {
			nwet.add(theme);
		}
		if(theme.notIn.contains(Type.DRY))     {
			ndry.add(theme);
		}
		if(theme.notIn.contains(Type.SAVANNA))     {
			nsavanna.add(theme);
		}
		if(theme.notIn.contains(Type.CONIFEROUS))     {
			nconiferous.add(theme);
		}
		if(theme.notIn.contains(Type.SPOOKY))     {
			nspooky.add(theme);
		}
		if(theme.notIn.contains(Type.DEAD))     {
			ndead.add(theme);
		}
		if(theme.notIn.contains(Type.LUSH))     {
			nlush.add(theme);
		}
		if(theme.notIn.contains(Type.CONIFEROUS))     {
			nconiferous.add(theme);
		}
		if(theme.notIn.contains(Type.MESA))     {
			nmesa.add(theme);
		}
		if(theme.notIn.contains(Type.SANDY))     {
			nsandy.add(theme);
		}
    }
    
    
    /**
     * This will perform the set logic to determine which 
     * themes are available in the given biome then randomly 
     * select one from that set. 
     * 
     * @param biome
     * @param random
     * @return
     */
    public static Theme getTheme(Biome biome, Random random) {
    	HashSet<Theme> set = new HashSet<Theme>();
    	ArrayList<Theme> use = new ArrayList<Theme>();
    	set.clear();
    	use.clear();
		if(BiomeDictionary.isBiomeOfType(biome, Type.END)) {
			set.addAll(end);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.FOREST)) {
			set.addAll(forest);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.SNOWY)) { 
			set.addAll(frozen);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.HILLS)) {
			set.addAll(hills);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.JUNGLE)) {
			set.addAll(jungle);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.MAGICAL)) {
			set.addAll(magical);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.MOUNTAIN)) {
			set.addAll(mountain);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.MUSHROOM)) {
			set.addAll(mushroom);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.NETHER)) {
			set.addAll(nether);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.PLAINS)) {
			set.addAll(plains);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.SWAMP)) {
			set.addAll(swamp);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.WASTELAND)) {
			set.addAll(wasteland);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.WATER) || 
				BiomeDictionary.isBiomeOfType(biome, Type.BEACH)) {
			set.addAll(water);
		}	
		if(BiomeDictionary.isBiomeOfType(biome, Type.HOT)) {
			set.addAll(hot);
		}	
		if(BiomeDictionary.isBiomeOfType(biome, Type.COLD)) {
			set.addAll(cold);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.DENSE)) {
			set.addAll(dense);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.SPARSE)) {
			set.addAll(sparse);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.DRY)) {
			set.addAll(dry);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.WET)) {
			set.addAll(wet);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.SAVANNA)) {
			set.addAll(savanna);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.CONIFEROUS)) {
			set.addAll(coniferous);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.SPOOKY)) {
			set.addAll(spooky);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.DEAD)) {
			set.addAll(dead);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.LUSH)) {
			set.addAll(lush);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.MESA)) {
			set.addAll(mesa);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.SANDY)) {
			set.addAll(sandy);
		}
		
		
		// REMOVAL CODE BELOW
		if(BiomeDictionary.isBiomeOfType(biome, Type.END)) {
			set.removeAll(nend);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.FOREST)) {
			set.removeAll(nforest);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.HILLS)) {
			set.removeAll(nhills);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.JUNGLE)) {
			set.removeAll(njungle);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.MAGICAL)) {
			set.removeAll(nmagical);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.MOUNTAIN)) {
			set.removeAll(nmountain);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.MUSHROOM)) {
			set.removeAll(nmushroom);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.NETHER)) {
			set.removeAll(nnether);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.PLAINS)) {
			set.removeAll(nplains);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.SWAMP)) {
			set.removeAll(nswamp);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.WASTELAND)) {
			set.removeAll(nwasteland);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.WATER) || 
				BiomeDictionary.isBiomeOfType(biome, Type.BEACH)) {
			set.removeAll(nwater);
		}	
		if(BiomeDictionary.isBiomeOfType(biome, Type.OCEAN)) {
			set.removeAll(nocean);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.HOT)) {
			set.removeAll(nhot);
		}	
		if(BiomeDictionary.isBiomeOfType(biome, Type.COLD)) {
			set.removeAll(ncold);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.DENSE)) {
			set.removeAll(ndense);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.SPARSE)) {
			set.removeAll(nsparse);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.DRY)) {
			set.removeAll(ndry);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.WET)) {
			set.removeAll(nwet);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.SAVANNA)) {
			set.removeAll(nsavanna);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.CONIFEROUS)) {
			set.removeAll(nconiferous);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.SPOOKY)) {
			set.removeAll(nspooky);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.DEAD)) {
			set.removeAll(ndead);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.LUSH)) {
			set.removeAll(nlush);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.MESA)) {
			set.removeAll(nmesa);
		}
		if(BiomeDictionary.isBiomeOfType(biome, Type.SANDY)) {
			set.removeAll(nsandy);
		}
		
    	if(set.isEmpty()) {
    		return null;
    	} else {
    		use.addAll(set);
    		for(Theme theme : use) {
    		}
    		Theme theme = use.get((random.nextInt(use.size())));
    		return theme;
    	}
    }
    
    
    /**
     * Clears and re-initializes all the set used by this class.
     * 
     * This is called by the /dldreload command to reload theme data.
     */
    public static void reset() {
    	forest.clear();
    	plains.clear();
    	mountain.clear();
    	hills.clear();
    	swamp.clear();
    	water.clear();
    	desert.clear();
    	frozen.clear();
    	jungle.clear();
    	wasteland.clear();
    	nether.clear();
    	end.clear();
    	mushroom.clear();
    	magical.clear();
    	hot.clear();
    	cold.clear();
    	sparse.clear();
    	dense.clear();
    	wet.clear();
    	dry.clear();
    	savanna.clear();
    	coniferous.clear();
    	spooky.clear();
    	dead.clear();
    	lush.clear();
    	mesa.clear();
    	ocean.clear();
    	sandy.clear();
    	snowy.clear();
    	nforest.clear();
    	nplains.clear();
    	nmountain.clear();
    	nhills.clear();
    	nswamp.clear();
    	nwater.clear();
    	ndesert.clear();
    	nfrozen.clear();
    	njungle.clear();
    	nwasteland.clear();
    	nnether.clear();
    	nend.clear();
    	nmushroom.clear();
    	nmagical.clear();
    	nhot.clear();
    	ncold.clear();
    	nsparse.clear();
    	ndense.clear();
    	nwet.clear();
    	ndry.clear();
    	nsavanna.clear();
    	nconiferous.clear();
    	nspooky.clear();
    	ndead.clear();
    	nlush.clear();
    	nmesa.clear();
    	nocean.clear();
    	nsandy.clear();
    	nsnowy.clear();
    	ThemeReader.readThemes();
    }
	
}
