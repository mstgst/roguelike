package roguelike.screens;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class LoseScreen implements Screen {
    public void screenOutput(AsciiPanel terminal) {
        terminal.write("You have been freed from the mortal coil", 1, 1);
        terminal.writeCenter("-- press [enter] to start anew, or [escape] to close --", 22);
    }

    public Screen respondToUserInput(KeyEvent key) {
        return switch (key.getKeyCode()) {
            case KeyEvent.VK_ENTER -> new PlayScreen();
            case KeyEvent.VK_ESCAPE -> new LoseScreen();
            default -> this;
        };
    }
}
