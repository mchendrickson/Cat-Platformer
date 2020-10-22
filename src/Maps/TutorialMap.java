package Maps;

import java.util.ArrayList;

import Level.Map;
import Level.NPC;
import Level.Tileset;
import NPCs.Walrus;
import Tilesets.CommonTileset;
import Utils.Point;

public class TutorialMap extends Map{

	public TutorialMap() {
		super("tutorial_map.txt", new CommonTileset(), new Point(1, 9));
		// TODO Auto-generated constructor stub
	}
	
	   @Override
	    public ArrayList<NPC> loadNPCs() {
	        ArrayList<NPC> npcs = new ArrayList<>();
	        Walrus firstWalrus = new Walrus(getPositionByTileIndex(10, 10).subtract(new Point(1, 9)), this);
	        firstWalrus.setMessage("Eat shit and die bitch");
	        npcs.add(firstWalrus);

	        return npcs;
	    }
}
