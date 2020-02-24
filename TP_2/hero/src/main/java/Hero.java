import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Hero {
    private int x = 10;
    private int y = 10;
    Hero(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void moveUp() {
        y--;
    }
    public void moveDown() {
        y++;
    }
    public void moveRight() {
        x++;
    }
    public void moveLeft() {
        x--;
    }
    public void draw(Screen screen) {
        screen.setCharacter(x, y, new TextCharacter('X'));
    }
}
