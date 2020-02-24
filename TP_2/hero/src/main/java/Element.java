import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {
    private Position position;
    Element(int x, int y) {
        position = new Position(x, y);
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
    public abstract void draw(TextGraphics graphics);

    public void setPosition(Position position) {
        this.position = position;
    }
    public Position getPosition() {
        return position;
    }
}