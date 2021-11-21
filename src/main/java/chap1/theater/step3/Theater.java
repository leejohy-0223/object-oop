package chap1.theater.step3;

public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
        // 초대장이 있으면, 티켓을 공짜로 준다.
        ticketSeller.sellTo(audience);
    }
}
