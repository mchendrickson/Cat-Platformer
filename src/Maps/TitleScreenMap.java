package Maps;

import java.util.ArrayList;

import Collectables.Coin;
import Level.Collectable;
import Level.Map;
import Tilesets.CommonTileset;
import Utils.Point;

// Represents the map that is used as a background for the main menu and credits menu screen
public class TitleScreenMap extends Map {

    public TitleScreenMap() {
        super("title_screen_map.txt", new CommonTileset(), new Point(1, 9));
    }
    
    @Override
    public ArrayList<Collectable> loadCollectables() {
    	ArrayList<Collectable> collectables = new ArrayList<>();
    	collectables.add(new Coin(150, 360));
    	collectables.add(new Coin(300, 270));
    	collectables.add(new Coin(500, 360));
    	return collectables;
    }

}
