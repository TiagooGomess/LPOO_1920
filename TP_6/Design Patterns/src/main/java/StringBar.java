import java.util.ArrayList;
import java.util.List;

public class StringBar extends Bar {
    private Boolean happyHour = false;

    public StringBar(List<BarObserver> observers, Boolean happyHour) {
        super(observers);
        this.happyHour = happyHour;
    }

    public StringBar() {
        super(new ArrayList<BarObserver>());
    }

    @Override
    public boolean isHappyHour() {
        return this.happyHour;
    }

    @Override
    public void startHappyHour() {
        this.happyHour = true;
        super.notifyObservers();
    }

    @Override
    public void endHappyHour() {
        this.happyHour = false;
        super.notifyObservers();
    }
}
