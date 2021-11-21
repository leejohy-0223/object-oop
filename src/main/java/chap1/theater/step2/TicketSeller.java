package chap1.theater.step2;

public class TicketSeller {
    private TicketOffice ticketOffice; // 판매원은 office를 알고 있어야 한다.

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void sellTo(Audience audience) {
        ticketOffice.plusAmount(audience.buy(ticketOffice.getTickets()));
    }
}
