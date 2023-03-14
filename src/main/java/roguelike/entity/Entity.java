package roguelike.entity;

import java.awt.Color;
import roguelike.world.World;
public class Entity {
    private World world;
    public int x;
    public int y;
    private char symbol;
    public char symbol() {
        return symbol;
    }
    private Color color;
    public Color color() {
        return color;
    }


    public Entity(World world, char symbol, Color color) {
        this.world = world;
        this.symbol = symbol;
        this.color = color;
    }
    private EntityAi ai;
    public void setEntityAi(EntityAi ai) {
        this.ai = ai;
    }

    public void dig(int wx, int wy) {
        world.dig(wx, wy);
    }
}
