import java.util.List;
import java.util.ArrayList;

public class Band extends Act {
    List<Artist> artists;
    Band(String name, String country) {
        super(name, country);
        artists = new ArrayList<Artist>();
    }

    public void addArtist(Artist artist) {
        artists.add(artist);
    }

    public List<Artist> getArtists() {
        return this.artists;
    }

    public boolean containsArtist(Artist artist) {
        return this.artists.contains(artist);
    }

}
