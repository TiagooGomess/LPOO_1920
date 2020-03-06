import java.util.ArrayList;
import java.util.List;

public class BoxOffice {
    static int numT = 0;
    public static List<Ticket> buy(Concert concert, int numTickets) throws InvalidTicket {
        List<Ticket> tickets = new ArrayList<Ticket>();
        int i;
        for (i = 1; i <= numTickets; i++) {
            tickets.add(new Ticket(i + numT, concert));
        }
        numT = i - 1;
        return tickets;
    }
}
