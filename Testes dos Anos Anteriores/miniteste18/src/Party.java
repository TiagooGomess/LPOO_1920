import java.util.Iterator;
import java.util.List;

public class Party extends Event {
    Party(String title, String date, String description) {
        super(title, date, description);
    }
    public void addEvent(Event event) {
        List<Person> persons = event.getPersons();
        Iterator itr = persons.iterator();
        while (itr.hasNext()) {
            Person p = (Person) itr.next();
            super.addPerson(p);
        }
    }
}