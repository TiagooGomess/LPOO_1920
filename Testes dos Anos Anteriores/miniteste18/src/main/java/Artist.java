public class Artist extends Person {
    Artist(String name) {
        super(name);
    }
    Artist(String name, int age) {
        super(name, age);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Artist " + super.getName();
    }

}