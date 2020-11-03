package Maps;

import Level.Map;
import Level.Tileset;
import Tilesets.CommonTileset;
import Utils.Point;

public class PlatformMap extends Map{

	public PlatformMap() {
		super("platform_map.txt", new CommonTileset(), new Point(5, 4));
		// TODO Auto-generated constructor stub
	}

}
