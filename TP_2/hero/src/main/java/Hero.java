import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

public class Hero {
    private Position position;
    Hero(int x, int y) {
        position = new Position(x,y);
    }
    public int getX() {
        return position.getX();
    }
    public int getY() {
        return position.getY();
    }
    public void setX(int x) {
        position.setX(x);
    }
    public void setY(int y) {
        position.setY(y);
    }
    public Position moveUp() {
        return new Position(this.position.getX(), this.position.getY()-1);
    }
    public Position moveDown() {
        return new Position(this.position.getX(), this.position.getY()+1);
    }
    public Position moveRight() {
        return new Position(this.position.getX()+1, this.position.getY());
    }
    public Position moveLeft() {
        return new Position(this.position.getX()-1, this.position.getY());
    }
    public void draw(Screen screen) {
        screen.setCharacter(position.getX(), position.getY(), new TextCharacter('X'));
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    public void moveHero(Position position) {
        this.setPosition(position);
    }
}
