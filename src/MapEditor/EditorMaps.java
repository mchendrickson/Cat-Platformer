package MapEditor;

import Level.Map;
import Maps.HillsMap;
import Maps.PlatformMap;
import Maps.TestMap;
import Maps.TitleScreenMap;
import Maps.TutorialMap;

import java.util.ArrayList;

public class EditorMaps {
    public static ArrayList<String> getMapNames() {
        return new ArrayList<String>() {{
            add("TestMap");
            add("TitleScreen");
            add("TutorialMap");
            add("PlatformMap");
            add("HillsMap");
        }};
    }

    public static Map getMapByName(String mapName) {
        switch(mapName) {
            case "TestMap":
                return new TestMap();
            case "TitleScreen":
                return new TitleScreenMap();
            case "TutorialMap":
            	return new TutorialMap();
            case "PlatformMap":
            	return new PlatformMap();
            case "HillsMap":
            	return new HillsMap();
            default:
                throw new RuntimeException("Unrecognized map name");
        }
    }
}
