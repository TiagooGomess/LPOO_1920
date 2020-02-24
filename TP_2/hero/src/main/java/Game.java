import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;
    Hero hero;
    Game() {
        try {

            hero = new Hero(10, 10);

            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);   // we don't need a cursor
            screen.startScreen();             // screens must be started
            screen.doResizeIfNecessary();     // resize screen if necessary

            screen.clear();
            hero.draw(screen);
            screen.refresh();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void draw() {
        try {
            screen.clear();
            hero.draw(screen);
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
    private void processKey(com.googlecode.lanterna.input.KeyStroke key) throws IOException {
        System.out.println(key);
        switch (key.getKeyType()) {
            case ArrowUp:
                hero.moveHero(hero.moveUp());
                break;
            case ArrowDown:
                hero.moveHero(hero.moveDown());
                break;
            case ArrowRight:
                hero.moveHero(hero.moveRight());
                break;
            case ArrowLeft:
                hero.moveHero(hero.moveLeft());
                break;
            default:
                System.out.println("Not an arrow key!");
        }
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') {
            screen.close();
        }
    }
}