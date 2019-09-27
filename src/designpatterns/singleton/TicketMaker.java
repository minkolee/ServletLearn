package designpatterns.singleton;

public class TicketMaker {

    private int ticket = 1000;

    public int getNextTicketNumber() {
        return ticket++;
    }

    private TicketMaker() {

    }

    private static TicketMaker ticketMaker = new TicketMaker();

    private static TicketMaker getInstance() {
        return ticketMaker;
    }

    public static void main(String[] args) {

        TicketMaker t1 = TicketMaker.getInstance();
        System.out.println(t1.getNextTicketNumber());
        TicketMaker t2 = TicketMaker.getInstance();
        System.out.println(t2.getNextTicketNumber());
        System.out.println(t2.getNextTicketNumber());
        TicketMaker t3 = TicketMaker.getInstance();
        System.out.println(t3.getNextTicketNumber());
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
    }
}
