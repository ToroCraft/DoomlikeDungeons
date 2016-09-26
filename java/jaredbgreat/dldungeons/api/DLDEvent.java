package jaredbgreat.dldungeons.api;

import java.util.Random;

import jaredbgreat.dldungeons.builder.DBlock;
import jaredbgreat.dldungeons.planner.Dungeon;
import jaredbgreat.dldungeons.planner.mapping.MapMatrix;
import jaredbgreat.dldungeons.rooms.Room;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;

public class DLDEvent extends Event {

	public DLDEvent() {

	}

	@Cancelable
	public abstract static class Place extends DLDEvent {
		protected final World world;
		protected BlockPos pos;

		public Place(World world, BlockPos pos) {
			this.world = world;
			this.pos = pos;
		}

		public World getWorld() {
			return world;
		}

		public BlockPos getPos() {
			return pos;
		}

		public void setPos(BlockPos pos) {
			this.pos = pos;
		}

	}

	@Cancelable
	public static class PlaceDBlock extends Place {

		protected final DBlock block;

		public PlaceDBlock(World world, BlockPos pos, DBlock block) {
			super(world, pos);
			this.block = block;
		}

		public DBlock getBlock() {
			return block;
		}

	}

	@Cancelable
	public static class PlaceBlock extends Place {

		protected final Block block;

		public PlaceBlock(World world, BlockPos pos, Block block) {
			super(world, pos);
			this.block = block;
		}

		public Block getBlock() {
			return block;
		}

	}

	public static class DungeonRoom extends DLDEvent {
		protected final Dungeon dungeon;
		protected final Room room;

		public DungeonRoom(Dungeon dungeon, Room room) {
			this.dungeon = dungeon;
			this.room = room;
		}

		public Dungeon getDungeon() {
			return dungeon;
		}

		public Room getRoom() {
			return room;
		}

	}

	@Cancelable
	public static class AddChestBlocksToRoom extends DungeonRoom {
		public AddChestBlocksToRoom(Dungeon dungeon, Room room) {
			super(dungeon, room);
		}
	}

	@Cancelable
	public static class AddTileEntitiesToRoom extends DungeonRoom {
		public AddTileEntitiesToRoom(Dungeon dungeon, Room room) {
			super(dungeon, room);
		}
	}

	@Cancelable
	public static class AddEntrance extends DungeonRoom {
		public AddEntrance(Dungeon dungeon, Room room) {
			super(dungeon, room);
		}
	}

	public static class BeforeBuild extends DLDEvent {
		protected final MapMatrix mapMatrix;
		protected final int shiftX;
		protected final int shiftZ;
		protected final boolean flooded;

		public BeforeBuild(MapMatrix mapMatrix, int shiftX, int shiftZ, boolean flooded) {
			this.mapMatrix = mapMatrix;
			this.shiftX = shiftX;
			this.shiftZ = shiftZ;
			this.flooded = flooded;
		}

		public MapMatrix getMapMatrix() {
			return mapMatrix;
		}

		public int getShiftX() {
			return shiftX;
		}

		public int getShiftZ() {
			return shiftZ;
		}

		public boolean isFlooded() {
			return flooded;
		}

	}

	public static class AfterBuild extends BeforeBuild {
		public AfterBuild(MapMatrix mapMatrix, int shiftX, int shiftZ, boolean flooded) {
			super(mapMatrix, shiftX, shiftZ, flooded);
		}
	}

	@Cancelable
	public static class placeDungeon extends DLDEvent {

		protected final Random random;
		protected final int chunkX;
		protected final int chunkZ;
		protected final World world;

		public placeDungeon(Random random, int chunkX, int chunkZ, World world) {
			this.random = random;
			this.chunkX = chunkX;
			this.chunkZ = chunkZ;
			this.world = world;
		}

		public Random getRandom() {
			return random;
		}

		public int getChunkX() {
			return chunkX;
		}

		public int getChunkZ() {
			return chunkZ;
		}

		public World getWorld() {
			return world;
		}

	}

}