package roguelike.screens;

import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;

public interface Screen {
    void screenOutput(AsciiPanel terminal);
    Screen respondToUserInput(KeyEvent key);
}
