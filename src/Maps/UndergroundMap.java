package Maps;

import java.util.ArrayList;

import Collectables.Coin;
import Enemies.BugEnemy;
import Enemies.DinosaurEnemy;
import Enemies.DragonEnemy;
import Enemies.SkullEnemy;
import Engine.ImageLoader;
import EnhancedMapTiles.EndLevelBox;
import EnhancedMapTiles.HorizontalMovingPlatform;
import GameObject.Rectangle;
import Level.Collectable;
import Level.Enemy;
import Level.EnhancedMapTile;
import Level.Map;
import Level.NPC;
import Level.TileType;
import Level.Tileset;
import NPCs.Walrus;
import Tilesets.CommonTileset;
import Utils.Direction;
import Utils.Point;

public class UndergroundMap extends Map{

	public UndergroundMap() {
		super("underground_map.txt", new CommonTileset(), new Point(1, 5));
		// TODO Auto-generated constructor stub
	}
	
	@Override
    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new BugEnemy(getPositionByTileIndex(20, 14), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(10, 14), Direction.RIGHT));
        enemies.add(new DragonEnemy(getPositionByTileIndex(56, 14), Direction.RIGHT));
        enemies.add(new DragonEnemy(getPositionByTileIndex(60, 14), Direction.LEFT));
        enemies.add(new SkullEnemy(getPositionByTileIndex(75, 11), Direction.LEFT));
        enemies.add(new SkullEnemy(getPositionByTileIndex(72, 11), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(48, 8).addY(2), getPositionByTileIndex(52, 8).addY(2), Direction.RIGHT));
        return enemies;
    }
	 @Override
	    public ArrayList<NPC> loadNPCs() {
	        ArrayList<NPC> npcs = new ArrayList<>();
	        Walrus firstWalrus = new Walrus(getPositionByTileIndex(3, 6).subtract(new Point(1, 9)), this);
	        firstWalrus.setMessage("You got to go down below!");
	        firstWalrus.setTextLength(185);
	        npcs.add(firstWalrus);
	        
	       

	        return npcs;
	    }
	@Override
	    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
	        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

	        enhancedMapTiles.add(new HorizontalMovingPlatform(
	                ImageLoader.load("GreenPlatform.png"),
	               getPositionByTileIndex(28, 12),
	                getPositionByTileIndex(33, 12),
	                TileType.JUMP_THROUGH_PLATFORM,
	                3,
	                new Rectangle(0, 6,16,4),
	                Direction.RIGHT
	        ));
	   
	        
	        enhancedMapTiles.add(new EndLevelBox(getPositionByTileIndex(77, 10)));

	        return enhancedMapTiles;
	    }
	@Override
    public ArrayList<Collectable> loadCollectables() {
    	ArrayList<Collectable> collectables = new ArrayList<>();
   	    collectables.add(new Coin(getPositionByTileIndex(13, 9)));
     	collectables.add(new Coin(getPositionByTileIndex(30, 8)));
     	collectables.add(new Coin(getPositionByTileIndex(48, 7)));
     	collectables.add(new Coin(getPositionByTileIndex(65, 8)));
    	return collectables;
    }
}


