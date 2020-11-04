package Maps;

import java.util.ArrayList;

import EnhancedMapTiles.EndLevelBox;
import Level.EnhancedMapTile;
import Level.Map;
import Tilesets.CommonTileset;
import Utils.Point;

public class TreesMap extends Map{
	public TreesMap() {
		super("trees_map.txt", new CommonTileset(), new Point(1, 24));
		// TODO Auto-generated constructor stub
	}
	
	@Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

        enhancedMapTiles.add(new EndLevelBox(
                getPositionByTileIndex(134, 1)
        ));

        return enhancedMapTiles;
    }
}
