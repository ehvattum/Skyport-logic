enum TileType {
    GRASS, ROCK, SPAWN, VOID, RUBIDIUM, EXPLOSIUM, SCRAP
}
public class Tile {
    static int grassTiles = 0;
    static int rockTiles = 0;
    static int voidTiles = 0;
    static int spawnTiles = 0;
    static int explosiumTiles = 0;
    static int rubidiumTiles = 0;
    static int scrapTiles = 0;
    static int totalTiles = 0;
    
    public Tile up = null;
    public Tile down = null;
    public Tile rightUp = null;
    public Tile rightDown = null;
    public Tile leftUp = null;
    public Tile leftDown = null;
    public int resources = 0;
    public TileType tileType;
    public String id = null;
    public Coordinate coords;
    public AIConnection playerOnTile = null;

    public Tile(String type){
	id = type;
	if(type.equals("G")){
	    tileType = TileType.GRASS;
	    grassTiles++;
	}
	else if(type.equals("V")){
	    tileType = TileType.VOID;
	    voidTiles++;
	}
	else if(type.equals("S")){
	    tileType = TileType.SPAWN;
	    spawnTiles++;
	}
	else if(type.equals("E")){
	    tileType = TileType.EXPLOSIUM;
	    resources = 2;
	    explosiumTiles++;
	}
	else if(type.equals("R")){
	    tileType = TileType.RUBIDIUM;
	    resources = 2;
	    rubidiumTiles++;
	}
	else if(type.equals("C")){
	    tileType = TileType.SCRAP;
	    resources = 2;
	    scrapTiles++;
	}
	else if(type.equals("O")){
	    tileType = TileType.ROCK;
	    rockTiles++;
	}
	else {
	    System.out.println("Error: Unknown tile type '" + type + "'");
	    System.exit(1);
	}
	totalTiles++;
    }
    public boolean isAccessible(){
	// rock, void and spawn are not accessible.
	// grass, rubidium, explosium, scrap are accessible.
	if(tileType == TileType.GRASS || tileType == TileType.RUBIDIUM
	   || tileType == TileType.EXPLOSIUM ||tileType == TileType.SCRAP){
	    return true;
	}
	else {
	    return false;
	}
    }
    public void damageTile(int hitpoints, AIConnection dealingPlayer){
	if(playerOnTile == null){
	    System.out.println("Tile absorbed damage.");
	    return;
	}
	else {
	    if(tileType == TileType.SPAWN){
	    	System.out.println("Hit spawn tile! No damage received.");
	    }
	    else {
		playerOnTile.damagePlayer(hitpoints, dealingPlayer);
	    }
	}
    }
}
