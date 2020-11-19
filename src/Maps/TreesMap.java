package Maps;

import java.util.ArrayList;

import Enemies.BugEnemy;
import Enemies.DinosaurEnemy;
import Enemies.DragonEnemy;
import Enemies.SkullEnemy;
import EnhancedMapTiles.EndLevelBox;
import Level.Enemy;
import Level.EnhancedMapTile;
import Level.Map;
import Tilesets.CommonTileset;
import Utils.Direction;
import Utils.Point;

public class TreesMap extends Map{
	public TreesMap() {
		super("trees_map.txt", new CommonTileset(), new Point(1, 24));
		// TODO Auto-generated constructor stub
	}
	 public ArrayList<Enemy> loadEnemies() {
	        ArrayList<Enemy> enemies = new ArrayList<>();
	        enemies.add(new BugEnemy(getPositionByTileIndex(9, 15), Direction.RIGHT));
	        enemies.add(new DragonEnemy(getPositionByTileIndex(18, 20), Direction.RIGHT));
	        enemies.add(new SkullEnemy(getPositionByTileIndex(80, 15), Direction.LEFT));
	        enemies.add(new SkullEnemy(getPositionByTileIndex(81, 15), Direction.LEFT));
	        enemies.add(new SkullEnemy(getPositionByTileIndex(82, 15), Direction.LEFT));
	        enemies.add(new SkullEnemy(getPositionByTileIndex(83, 15), Direction.LEFT));
	        enemies.add(new SkullEnemy(getPositionByTileIndex(84, 15), Direction.LEFT));
	        enemies.add(new SkullEnemy(getPositionByTileIndex(85, 15), Direction.LEFT));
	        enemies.add(new SkullEnemy(getPositionByTileIndex(86, 15), Direction.LEFT));
	        enemies.add(new SkullEnemy(getPositionByTileIndex(87, 15), Direction.LEFT));
	        enemies.add(new SkullEnemy(getPositionByTileIndex(88, 15), Direction.LEFT));
	      //  enemies.add(new DinosaurEnemy(getPositionByTileIndex(11, 7).addY(2), getPositionByTileIndex(15, 6).addY(2), Direction.RIGHT));
	        return enemies;
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
