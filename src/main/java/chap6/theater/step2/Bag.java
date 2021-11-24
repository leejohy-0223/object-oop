package chap6.theater.step2;

public class Bag {
    private Long amount; // 보유 현금
    private Invitation invitation;
    private Ticket ticket;

    private boolean hasInvitation() {
        return invitation != null; // invitation이 null이 아니면 true 반환
    }

    public Long hold(Ticket ticket) {
        if (hasInvitation()) {
            this.ticket = ticket;
            return 0L;
        } else {
            // 초대장이 없으면, 돈을 받는다.
            this.ticket = ticket;
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }

    private void plusAmount(Long amount) {
        this.amount += amount;
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
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
