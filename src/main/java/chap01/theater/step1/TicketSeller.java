package chap01.theater.step1;

public class TicketSeller {
    private TicketOffice ticketOffice; // 판매원은 office를 알고 있어야 한다.

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public TicketOffice getTicketOffice() {
        return ticketOffice;
    }
}
