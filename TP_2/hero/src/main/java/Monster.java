import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Monster extends Element {
    Monster(int x, int y) {
        super(x, y);
    }
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#00ff00"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(super.getX(), super.getY()), "M");
    }
    public Position moveUp() { return new Position(super.getX(), super.getY()-1); }
    public Position moveDown() {
        return new Position(super.getX(), super.getY()+1);
    }
    public Position moveRight() {
        return new Position(super.getX()+1, super.getY());
    }
    public Position moveLeft() {
        return new Position(super.getX()-1, super.getY());
    }
    public Position move(int randomNumber) {
        switch (randomNumber) {
            case (0):
                return this.moveUp();
            case (1):
                return this.moveDown();
            case (2):
                return this.moveRight();
            case (3):
                return this.moveLeft();
            default:
                System.out.println("Something is wrong!!");
                return new Position(-1,-1);
        }
    }
}
