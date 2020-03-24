import java.util.List;

public abstract class Bar {
    private boolean happHour;
    private List<BarObserver> observers;

    public Bar(List<BarObserver> observers) {
        this.observers = observers;
        this.happHour = false;
    }

    public boolean isHappyHour() {
        return this.happHour;
    }
    public void startHappyHour() {
        this.happHour = true;
        this.notifyObservers();
    }
    public void endHappyHour() {
        this.happHour = false;
        this.notifyObservers();
    }

    public void addObserver(BarObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(BarObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (BarObserver observer : observers)
            if (isHappyHour()) observer.happyHourStarted(this);
            else observer.happyHourEnded(this);
    }


}
