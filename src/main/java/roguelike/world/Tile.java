package roguelike.world;

import java.awt.Color;
import asciiPanel.AsciiPanel;
public enum Tile {
    FLOOR((char)250, AsciiPanel.green),
    WALL((char)177, AsciiPanel.green),
    BOUNDS('x', AsciiPanel.brightBlack);

    private char symbol;
    public char symbol() {
        return symbol;
    }

    private Color color;
    public Color color() {
        return color;
    }

    Tile(char symbol, Color color) {
        this.symbol = symbol;
        this.color = color;
    }

    public boolean isDiggable() {
        return this == Tile.WALL;
    }
}
