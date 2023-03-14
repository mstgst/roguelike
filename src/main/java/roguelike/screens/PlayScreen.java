package roguelike.screens;

import asciiPanel.AsciiPanel;
import roguelike.world.World;
import roguelike.world.WorldGen;

import java.awt.event.KeyEvent;

public class PlayScreen implements Screen {

    private World world;
    private int centerX;
    private int centerY;
    private int screenWidth;
    private int screenHeight;

    public PlayScreen(){
        screenWidth = 80;
        screenHeight = 21;
        createWorld();
    }

    public int xGetScroll() {
        return Math.max(0, Math.min(centerX - screenWidth/2, world.width() - screenWidth));
    }

    public int yGetScroll() {
        return Math.max(0, Math.min(centerY - screenHeight/2, world.height() - screenHeight));
    }

    public void screenOutput(AsciiPanel terminal) {
        int left = xGetScroll();
        int top = yGetScroll();
        displayTiles(terminal, left, top);
        terminal.write('X', centerX - left, centerY - top);
        terminal.writeCenter("press [escape] to die or [enter] to win", 22);
    }

    private void scrollBy(int mx, int my) {
        centerX = Math.max(0, Math.min(centerX + mx, world.width() - 1));
        centerY = Math.max(0, Math.min(centerY + my, world.height() - 1));
    }

    public Screen respondToUserInput(KeyEvent key) {
        return switch (key.getKeyCode()) {
            case KeyEvent.VK_ENTER -> new WinScreen();
            case KeyEvent.VK_ESCAPE -> new LoseScreen();
            default -> this;
        };
    }

    private void displayTiles(AsciiPanel terminal, int left, int top) {
        for (int x = 0; x < screenWidth; x++) {
            for (int y = 0; y < screenHeight; y++) {
                int wx = x + left;
                int wy = y + top;

                terminal.write(world.symbol(wx, wy), x, y, world.color(wx, wy));
            }
        }
    }
    private void createWorld(){
        world = new WorldGen(90, 31)
                .caveGen()
                .generate();
    }
}
