package Maps;

import java.util.ArrayList;

import Collectables.Coin;
import EnhancedMapTiles.EndLevelBox;
import Level.Collectable;
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
	
	  @Override
	    public ArrayList<Collectable> loadCollectables() {
	    	ArrayList<Collectable> collectables = new ArrayList<>();
	    	collectables.add(new Coin(150, 760));
	    	collectables.add(new Coin(400, 760));
	    	collectables.add(new Coin(300, 670));
	    	collectables.add(new Coin(500, 760));
	    	collectables.add(new Coin(700, 760));
	    	collectables.add(new Coin(900, 760));
	    	return collectables;
	    }
}
