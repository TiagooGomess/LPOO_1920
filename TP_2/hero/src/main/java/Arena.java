import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;

public class Arena {
    private int width;
    private int height;
    Hero hero;
    Arena(int width, int height) {
        this.width = width;
        this.height = height;
        hero = new Hero(10, 10);

    }

    public int processKey(com.googlecode.lanterna.input.KeyStroke key) throws IOException {
        System.out.println("X: " + hero.getX() + "\nY: " + hero.getY() + "\n");
        switch (key.getKeyType()) {
            case ArrowUp:
                this.moveHero(hero.moveUp());
                break;
            case ArrowDown:
                this.moveHero(hero.moveDown());
                break;
            case ArrowRight:
                this.moveHero(hero.moveRight());
                break;
            case ArrowLeft:
                this.moveHero(hero.moveLeft());
                break;
            case Character:
                if (key.getCharacter() == 'q')
                    return 1;
        }
        return 0;
    }

    public Boolean canHeroMove(Position position) {
        if (position.getX() + 1 > width || position.getX() - 1 < -1 || position.getY() + 1 > height || position.getY() - 1 < -1)
            return false;
        else
            return true;
    }

    public void moveHero(Position position) {
        if (canHeroMove(position))
            hero.setPosition(position);
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        hero.draw(graphics);
    }
}
