package Maps;

import java.util.ArrayList;

import Collectables.Coin;
import Enemies.BugEnemy;
import Enemies.DinosaurEnemy;
import Enemies.DragonEnemy;
import Enemies.SkullEnemy;
import EnhancedMapTiles.EndLevelBox;
import Level.Collectable;
import Level.Enemy;
import Level.EnhancedMapTile;
import Level.Map;
import Level.Tileset;
import Tilesets.CommonTileset;
import Utils.Direction;
import Utils.Point;

public class HillsMap extends Map{

	public HillsMap() {
		super("hills_map.txt", new CommonTileset(), new Point(1, 9));
		// TODO Auto-generated constructor stub
	}
	
	@Override
    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(16, 18), getPositionByTileIndex(20,18), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(12, 22), Direction.LEFT));    
        enemies.add(new BugEnemy(getPositionByTileIndex(9, 22), Direction.LEFT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(73, 21), getPositionByTileIndex(76,21), Direction.RIGHT));
        enemies.add(new DragonEnemy(getPositionByTileIndex(46, 16), Direction.RIGHT));
        enemies.add(new SkullEnemy(getPositionByTileIndex(90, 19), Direction.RIGHT));
        enemies.add(new SkullEnemy(getPositionByTileIndex(80, 19), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(112, 6), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(106, 9), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(102, 11), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(94, 15), Direction.LEFT));
        return enemies;
    }
   
   @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

        enhancedMapTiles.add(new EndLevelBox(
                getPositionByTileIndex(118, 2)
        ));

        return enhancedMapTiles;
    }
   
   @Override
    public ArrayList<Collectable> loadCollectables() {
    	ArrayList<Collectable> collectables = new ArrayList<>();
    	collectables.add(new Coin(getPositionByTileIndex(17, 15)));
    	collectables.add(new Coin(getPositionByTileIndex(49, 10)));
    	collectables.add(new Coin(getPositionByTileIndex(40, 15)));
    	collectables.add(new Coin(getPositionByTileIndex(67, 20)));
    	collectables.add(new Coin(getPositionByTileIndex(85, 15)));
    	return collectables;
    }

}
