package chap1.theater.step3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketOffice {
    private Long amount;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketOffice(Long amount, Ticket... tickets) {
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    private Ticket getTickets() {
        return tickets.remove(0);
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
    }

    private void plusAmount(Long amount) {
        this.amount += amount;
    }

    // TicketOffice에 Audience에 대한 의존성이 추가되었다.
    // 따라서 TicketOffice의 자율성을 만족시킬건지, Audience에 대한 결합도를 낮출것인지를 결정해야 한다.
    public void sellTicketTo(Audience audience) {
        plusAmount(audience.buy(getTickets()));
    }
}
