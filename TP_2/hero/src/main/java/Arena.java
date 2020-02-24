import sun.awt.X11.Screen;

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
            case Character:
                if (key.getCharacter() == 'q')
                    return 1;
        }
        return 0;
    }

    public void draw(com.googlecode.lanterna.screen.Screen screen) {
        hero.draw(screen);
    }
}
