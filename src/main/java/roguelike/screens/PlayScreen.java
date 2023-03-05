package roguelike.screens;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class PlayScreen implements Screen {
    public void screenOutput(AsciiPanel terminal) {
        terminal.write("Let the great experiment begin!", 1, 1);
        terminal.writeCenter("-- press [escape] to die or [enter] to win --", 22);
    }

    public Screen respondToUserInput(KeyEvent key) {
        return switch (key.getKeyCode()) {
            case KeyEvent.VK_ENTER -> new WinScreen();
            case KeyEvent.VK_ESCAPE -> new LoseScreen();
            default -> this;
        };
    }
}
