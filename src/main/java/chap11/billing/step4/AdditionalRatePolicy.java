package chap11.billing.step4;

import chap05.money.Money;

public abstract class AdditionalRatePolicy implements RatePolicy {

    private RatePolicy next; // 내부적으로 정책을 참조할 수 있어야 한다.

    public AdditionalRatePolicy(RatePolicy next) {
        this.next = next;
    }

    @Override
    public Money calculateFee(Phone phone) {
        Money fee = next.calculateFee(phone);
        return afterCalculated(fee); // 더해질지, 아니면 뺄지는 이를 구현한 부가 정책에서 구현한다.
    }

    protected abstract Money afterCalculated(Money fee);

}
