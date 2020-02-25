import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Hero extends Element {
    Hero(int x, int y) {
        super(x, y);
    }
    public Position moveUp() {
        return new Position(super.getX(), super.getY()-1);
    }
    public Position moveDown() {
        return new Position(super.getX(), super.getY()+1);
    }
    public Position moveRight() {
        return new Position(super.getX()+1, super.getY());
    }
    public Position moveLeft() {
        return new Position(super.getX()-1, super.getY());
    }
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(super.getX(), super.getY()), "X");
    }
}