import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;
    Arena arena;
    TextGraphics graphics;

    Game() {
        try {
            arena = new Arena(80, 24);

            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);

            graphics = screen.newTextGraphics();

            screen.setCursorPosition(null);   // we don't need a cursor
            screen.startScreen();             // screens must be started
            screen.doResizeIfNecessary();     // resize screen if necessary

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void draw() {
        try {
            screen.clear();
            arena.draw(screen.newTextGraphics());
            screen.refresh();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void run() {
        try {
            while (true) {
                draw();
                com.googlecode.lanterna.input.KeyStroke key = screen.readInput();
                processKey(key);
                if (key.getKeyType() == KeyType.EOF) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void processKey(KeyStroke key) throws IOException {
        if (arena.processKey(key) == 1)
            screen.close();
    }
}