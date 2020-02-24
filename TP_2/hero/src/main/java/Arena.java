import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arena {
    private int width;
    private int height;
    private Hero hero;
    private List<Wall> walls;

    Arena(int width, int height) {
        this.width = width;
        this.height = height;
        hero = new Hero(10, 10);
        this.walls = createWalls();

    }

    public int processKey(com.googlecode.lanterna.input.KeyStroke key) throws IOException {
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
        if (position.getX() + 1 > width - 1 || position.getX() - 1 < -1 + 1 || position.getY() + 1 > height - 1 || position.getY() - 1 < -1 + 1)
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
        for (Wall wall: walls)
            wall.draw(graphics);
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height -1 ; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }
}
