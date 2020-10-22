package Maps;

import java.util.ArrayList;

import Collectables.Coin;
import Enemies.BugEnemy;
import Enemies.DinosaurEnemy;
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

public class TutorialMap extends Map{

	public TutorialMap() {
		super("tutorial_map.txt", new CommonTileset(), new Point(1, 9));
		// TODO Auto-generated constructor stub
	}
	
	   @Override
	    public ArrayList<NPC> loadNPCs() {
	        ArrayList<NPC> npcs = new ArrayList<>();
	        Walrus firstWalrus = new Walrus(getPositionByTileIndex(3, 10).subtract(new Point(1, 9)), this);
	        firstWalrus.setMessage("Welcome! You can move with WASD or Arrow Keys.");
	        firstWalrus.setTextLength(280);
	        npcs.add(firstWalrus);
	        
	        Walrus secondWalrus = new Walrus(getPositionByTileIndex(20, 10).subtract(new Point(1, 9)), this);
	        secondWalrus.setMessage("Great job! Here's a coin to collect along your journey!");
	        secondWalrus.setTextLength(330);
	        npcs.add(secondWalrus);
	        
	        Walrus thirdWalrus = new Walrus(getPositionByTileIndex(32, 8).subtract(new Point(1, 9)), this);
	        thirdWalrus.setMessage("Make sure to avoid enemies, as I haven't had time to implement combat yet!!!!!!");
	        thirdWalrus.setTextLength(430);
	        npcs.add(thirdWalrus);
	        
	        Walrus fourthWalrus = new Walrus(getPositionByTileIndex(52, 9).subtract(new Point(1, 9)), this);
	        fourthWalrus.setMessage("That's it for now, touch the gold cube to finish the level!");
	        fourthWalrus.setTextLength(340);
	        npcs.add(fourthWalrus);

	        return npcs;
	    }
	   
	   @Override
	    public ArrayList<Enemy> loadEnemies() {
	        ArrayList<Enemy> enemies = new ArrayList<>();
	        enemies.add(new BugEnemy(getPositionByTileIndex(40, 10), Direction.RIGHT));
	        return enemies;
	    }
	   
	   @Override
	    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
	        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

	        enhancedMapTiles.add(new EndLevelBox(
	                getPositionByTileIndex(57, 7)
	        ));

	        return enhancedMapTiles;
	    }
	   
	   @Override
	    public ArrayList<Collectable> loadCollectables() {
	    	ArrayList<Collectable> collectables = new ArrayList<>();
	    	collectables.add(new Coin(1100, 460));
	    	return collectables;
	    }
}
