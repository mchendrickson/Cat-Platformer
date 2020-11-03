package Maps;

import java.util.ArrayList;

import Engine.ImageLoader;
import EnhancedMapTiles.EndLevelBox;
import EnhancedMapTiles.HorizontalMovingPlatform;
import GameObject.Rectangle;
import Level.EnhancedMapTile;
import Level.Map;
import Level.TileType;
import Level.Tileset;
import Tilesets.CommonTileset;
import Utils.Direction;
import Utils.Point;

public class PlatformMap extends Map{

	public PlatformMap() {
		super("platform_map.txt", new CommonTileset(), new Point(5, 4));
		// TODO Auto-generated constructor stub
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
}
