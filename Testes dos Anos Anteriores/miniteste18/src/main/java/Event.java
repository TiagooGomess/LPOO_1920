import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Event {
    private String title, description, date;
    private List<Person> persons;
    Event(String title) {
        this.title = title;
        this.date = "";
        this.description = "";
        this.persons = new ArrayList<Person>();
    }
    Event(String title, String date) {
        this.title = title;
        this.date = date;
        this.description = "";
        this.persons = new ArrayList<Person>();
    }
    Event(String title, String date, String description) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.persons = new ArrayList<Person>();
    }
    Event(Event event) {
        this.title = event.getTitle();
        this.date = event.getDate();
        this.description = event.getDescription();
        this.persons = new ArrayList<Person>();
    }
    public String getTitle() {
        return this.title;
    }

    public String getDate() {
        return this.date;
    }

    public String getDescription() {
        return this.description;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return this.title + " is a " + this.description + " and will be held at " + this.date + ".";
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Event event = (Event) object;
        return (this.title == event.title) && (this.date == event.getDate()) && (this.description == event.getDescription());
    }
    public void addPerson(Person person) {
        boolean existePessoa = false;
        Iterator itr = persons.iterator();
        while (itr.hasNext()) {
            Person p = (Person) itr.next();
            if (p.equals(person)) {
                existePessoa = true;
                break;
            }
        }
        if (!existePessoa)
            this.persons.add(person);

    }
    public int getAudienceCount() {
        return this.persons.size();
    }

    public List<Person> getPersons() {
        return this.persons;
    }

}