
import java.io.InputStream;
import java.util.Scanner;

/**
 * Creats the maps, and if no more map is found for a certain level, a
 * NoMoreMapsException is thrown
 */
public final class MapMaker {
	private MapMaker() {
	}

	public static GameMap makeMap(int level) throws NoMoreMapsException {
	GameMap gameMap = new GameMap();
	gameMap.setLevel(level);

	InputStream is = MapMaker.class.getResourceAsStream("Maps/Map" + level + ".td");
	if (is == null) {
	    throw new NoMoreMapsException();
	}
	try (Scanner scanner = new Scanner(is)) {
	    for (int y = 0; y < GameMap.GAMEMAPHEIGHT; y++) {
		for (int x = 0; x < GameMap.GAMEMAPWIDTH; x++) {
		    String s = scanner.next();
		   Area area;
		    switch (s) {
			case "b":
			    area = new BuildingArea(x * GameMap.BLOCKSIZE, y * GameMap.BLOCKSIZE, GameMap.BLOCKSIZE, GameMap.BLOCKSIZE);
			    break;
			case "m":
			    area = new MonsterArea(x * GameMap.BLOCKSIZE, y * GameMap.BLOCKSIZE, GameMap.BLOCKSIZE, GameMap.BLOCKSIZE);
			    break;
			default:
			       area = new MonsterArea(x * GameMap.BLOCKSIZE, y * GameMap.BLOCKSIZE, GameMap.BLOCKSIZE,
						      GameMap.BLOCKSIZE);
			       gameMap.addCheckpoint(new Checkpoint(x * GameMap.BLOCKSIZE, y * GameMap.BLOCKSIZE, Integer.parseInt(s)));
			       break;
			       
		    } gameMap.addArea(area);
		}
	    }
	}
	//gameMap.getCheckpoints().sort(new SequenceComparator());
	return gameMap;
    }
}
