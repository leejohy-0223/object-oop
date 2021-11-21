package chap1.theater.step3;


public class Bag {
    private Long amount; // 보유 현금
    private Invitation invitation;
    private Ticket ticket;

    private boolean hasInvitation() {
        return invitation != null; // invitation이 null이 아니면 true 반환
    }

    private boolean hasTicket() {
        return ticket != null;
    }

    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    private void plusAmount(Long amount) {
        this.amount += amount;
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public Long hold(Ticket ticket) {
        setTicket(ticket);
        if (!hasTicket()) {
            amount -= ticket.getFee();
            return ticket.getFee();
        }
        return 0L;
    }

    // 초대장을 가진 사람을 위한 생성자
    public Bag(Invitation invitation, Long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }

    // 초대장을 가지지 않은 사람을 위한 생성자
    public Bag(Long amount) {
        this(null, amount);
    }
}
