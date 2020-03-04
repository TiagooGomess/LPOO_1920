public class Attendee extends Person {
    private boolean paid;
    Attendee(String name) {
        super(name);
        this.paid = false;
    }
    Attendee(String name, int age) {
        super(name, age);
    }
    public boolean hasPaid() {
        return this.paid;
    }

    @Override
    public String toString() {
        return "Attendee " + super.getName() + (this.hasPaid() ? " has":" hasn't") + " paid its registration.";
    }


}