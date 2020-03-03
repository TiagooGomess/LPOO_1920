import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Arena {
    private int width;
    private int height;
    private Hero hero;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;

    Arena(int width, int height) {
        this.width = width;
        this.height = height;
        hero = new Hero(10, 10);
        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters = createMonsters();

    }
    public int processKey(com.googlecode.lanterna.input.KeyStroke key) throws IOException {
        moveMonsters();
        if (verifyMonsterCollisions(hero.getPosition())) {
            hero.decrementEnergy();
            System.out.println("Energy: " + hero.getEnergy());
        }
        if (heroDied()) {
            System.out.println("You lost!");
            return 1; // end game
        }
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
    public Boolean wallCollision(Position position) {
        for (Wall wall: walls) {
            if (wall.getPosition().equals(position))
                return true;
        }
        return false;
    }
    public Boolean canHeroMove(Position position) {

        if (wallCollision(position))
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
        for (Coin coin: coins)
            coin.draw(graphics);
        retriveCoins();
        for (Monster monster: monsters)
            monster.draw(graphics);
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
    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            coins.add(new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return coins;
    }
    private void retriveCoins() {
        Iterator itr = coins.iterator();
        while (itr.hasNext()) {
            Coin coin = (Coin) itr.next();
            if (coin.getPosition().equals(hero.getPosition())) {
                itr.remove();
                break;
            }
        }
    }
    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            monsters.add(new Monster(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return monsters;
    }
    private void moveMonsters() {
        Random random = new Random();
        int randomNumber = random.nextInt(4); // 0, 1, 2 or 3
        for (Monster monster: monsters) {
            if (canMonsterMove(monster.move(randomNumber)))
                monster.setPosition(monster.move(randomNumber));
        }
    }
    private Boolean canMonsterMove(Position position) {
        if (wallCollision(position))
            return false;
        else
            return true;
    }
    public Boolean verifyMonsterCollisions(Position position) {
        for (Monster monster: monsters) {
            if (monster.getPosition().equals(position))
                return true;
        }
        return false;
    }
    public Boolean heroDied() {
        if (hero.getEnergy() == 0)
            return true;
        return false;
    }

}