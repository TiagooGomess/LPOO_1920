public abstract class Person implements User {
    private String name;
    private int age;
    Person(String name) {
        this.name = name;
        this.age = 0;
    }
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public abstract String toString();

    public boolean equals(Object object) {
        if (this == object) return true;
        //if (object == null || getClass() != object.getClass()) return false;
        Person person = (Person) object;
        return this.name == person.name;
    }

    public int hashCode() {
        return (this.name).hashCode();
    }

    public String getUsername() {
        return this.name + this.age;
    }
}