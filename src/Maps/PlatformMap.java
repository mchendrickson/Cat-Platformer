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
import Level.TileType;
import Level.Tileset;
import Tilesets.CommonTileset;
import Utils.Direction;
import Utils.Point;

public class PlatformMap extends Map{

	public PlatformMap() {
		super("platform_map.txt", new CommonTileset(), new Point(1, 5));
		// TODO Auto-generated constructor stub
	}
	
	@Override
    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new BugEnemy(getPositionByTileIndex(20, 10), Direction.RIGHT));
        enemies.add(new DragonEnemy(getPositionByTileIndex(42, 9), Direction.RIGHT));
        enemies.add(new SkullEnemy(getPositionByTileIndex(54, 8), Direction.LEFT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(11, 7).addY(2), getPositionByTileIndex(15, 6).addY(2), Direction.RIGHT));
        return enemies;
    }
	@Override
	    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
	        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

	        enhancedMapTiles.add(new HorizontalMovingPlatform(
	                ImageLoader.load("GreenPlatform.png"),
	                getPositionByTileIndex(55, 7),
	                getPositionByTileIndex(60, 7),
	                TileType.JUMP_THROUGH_PLATFORM,
	                3,
	                new Rectangle(0, 6,16,4),
	                Direction.RIGHT
	        ));
	        
	        enhancedMapTiles.add(new HorizontalMovingPlatform(
	                ImageLoader.load("GreenPlatform.png"),
	                getPositionByTileIndex(65, 8),
	                getPositionByTileIndex(70, 8),
	                TileType.JUMP_THROUGH_PLATFORM,
	                3,
	                new Rectangle(0, 6,16,4),
	                Direction.RIGHT
	        ));
	        
	        enhancedMapTiles.add(new HorizontalMovingPlatform(
	                ImageLoader.load("GreenPlatform.png"),
	                getPositionByTileIndex(67, 5),
	                getPositionByTileIndex(70, 5),
	                TileType.JUMP_THROUGH_PLATFORM,
	                3,
	                new Rectangle(0, 6,16,4),
	                Direction.RIGHT
	        ));
	        
	        
	        
	        enhancedMapTiles.add(new EndLevelBox(getPositionByTileIndex(77, 1)));

	        return enhancedMapTiles;
	    }
	@Override
    public ArrayList<Collectable> loadCollectables() {
    	ArrayList<Collectable> collectables = new ArrayList<>();
    	collectables.add(new Coin(getPositionByTileIndex(35, 4)));
    	collectables.add(new Coin(getPositionByTileIndex(65, 1)));
    	return collectables;
    }
}
