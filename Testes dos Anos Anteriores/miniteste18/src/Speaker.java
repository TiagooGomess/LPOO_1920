public class Speaker extends Person {
    private int fee;
    Speaker(String name) {
        super(name);
        this.fee = 0;
    }
    Speaker(String name, int age) {
        super(name, age);
    }
    public int getFee() {
        return this.fee;
    }

    @Override
    public String toString() {
        return "Speaker " + super.getName() + " has a fee value of " + this.getFee() + ".";
    }


}