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
import Level.NPC;
import NPCs.Walrus;
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
	        enemies.add(new DinosaurEnemy(getPositionByTileIndex(26, 17).addY(2), getPositionByTileIndex(29, 17).addY(2), Direction.RIGHT));
	        enemies.add(new SkullEnemy(getPositionByTileIndex(40,27), Direction.LEFT));
	        enemies.add(new DinosaurEnemy(getPositionByTileIndex(71, 9).addY(2), getPositionByTileIndex(74, 9 ).addY(2), Direction.RIGHT));
	        enemies.add(new BugEnemy(getPositionByTileIndex(92, 15), Direction.LEFT));
	        enemies.add(new DinosaurEnemy(getPositionByTileIndex(113, 5).addY(2), getPositionByTileIndex(116, 5).addY(2), Direction.RIGHT));
	        return enemies;
	    }
	 @Override
	    public ArrayList<NPC> loadNPCs() {
	        ArrayList<NPC> npcs = new ArrayList<>();
	        Walrus firstWalrus = new Walrus(getPositionByTileIndex(62, 24 ).subtract(new Point(1, 9)), this);
	        firstWalrus.setMessage("Tired of climbing yet?");
	        firstWalrus.setTextLength(185);
	        npcs.add(firstWalrus);
	        
	        Walrus secondWalrus = new Walrus(getPositionByTileIndex(130, 3).subtract(new Point(1, 9)), this);
	        secondWalrus.setMessage("What took you so long?");
	        secondWalrus.setTextLength(185);
	        npcs.add(secondWalrus);
	        
	        
	       

	        return npcs;
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
