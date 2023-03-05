package roguelike.screens;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class WinScreen implements Screen {
    public void screenOutput(AsciiPanel terminal) {
        terminal.write("You're Winner!", 1, 1);
        terminal.writeCenter("-- press [enter] to experience samsara, or [escape] to break the cycle --", 22);
    }

    public Screen respondToUserInput(KeyEvent key) {
        return switch (key.getKeyCode()) {
            case KeyEvent.VK_ENTER -> new PlayScreen();
            case KeyEvent.VK_ESCAPE -> new LoseScreen();
            default -> this;
        };
    }
}
