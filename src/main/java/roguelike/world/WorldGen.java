package roguelike.world;

public class WorldGen {
    private int width;
    private int height;
    private Tile[][] tiles;

    public WorldGen(int width, int height) {
       this.width = width;
       this.height = height;
       this.tiles = new Tile[width][height];
    }

    public World generate() {
        return new World(tiles);
    }

    private WorldGen tileGen() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x][y] = Math.random() < 0.5 ? Tile.FLOOR : Tile.WALL;
            }
        }
        return this;
    }

    private WorldGen smooth(int end) {
        Tile[][] tilesSmoothed = new Tile[width][height];
        for (int time = 0; time < end; time++) {
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    int floors = 0;
                    int rocks = 0;

                    for(int ox = -1; ox < 2; ox++) {
                        for (int oy = -1; oy < 2; oy++) {
                            if (x + ox < 0 || x + ox >= width || y + oy < 0
                                    || y + oy >= height)
                                continue;

                            if (tiles[x + ox][y + oy] == Tile.FLOOR)
                                floors++;
                            else
                                rocks++;
                        }
                    }
                    tilesSmoothed[x][y] = floors >= rocks ? Tile.FLOOR : Tile.WALL;
                }
            }
            tiles = tilesSmoothed;
        }
        return this;
    }

    public WorldGen caveGen() {
        return tileGen().smooth(8);
    }
}
