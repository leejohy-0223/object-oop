package chap01.theater.step2;


public class Bag {
    private Long amount; // 보유 현금
    private Invitation invitation;
    private Ticket ticket;

    public boolean hasInvitation() {
        return invitation != null; // invitation이 null이 아니면 true 반환
    }

    public boolean hasTicket() {
        return ticket != null;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }

    public void minusAmount(Long amount) {
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
