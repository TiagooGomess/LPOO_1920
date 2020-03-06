import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Concert {
    private String city, country, date;
    private List<Act> acts;

    Concert(String city, String country, String date) {
        this.city = city;
        this.country = country;
        this.date = date;
        acts = new ArrayList<Act>();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void addAct(Act act) {
        acts.add(act);
    }

    public List<Act> getActs() {
        return this.acts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Concert concert = (Concert) o;
        return Objects.equals(city, concert.city) &&
                Objects.equals(country, concert.country) &&
                Objects.equals(date, concert.date) &&
                Objects.equals(acts, concert.acts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country, date, acts);
    }

    public boolean isValid(Ticket ticket) {
        return this.equals(ticket.getConcert());
    }

    public boolean participates(Artist artist) {
        for (Act act: acts) {
            if (act instanceof Band) {
                Band band = (Band) act;
                if (band.containsArtist(artist))
                    return true;
            }
            else if (act instanceof Artist) {
                Artist a = (Artist) act;
                if (a.equals(artist))
                    return true;
            }
        }
        return false;
    }
}
