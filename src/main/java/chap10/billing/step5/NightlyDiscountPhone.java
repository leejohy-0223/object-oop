package chap10.billing.step5;

import java.time.Duration;

import chap5.money.Money;

public class NightlyDiscountPhone extends Phone {

    private static final int LATE_NIGHT_HOUR = 22;

    private Money nightlyAmount;

    /**
     * 부모 생성자로 taxRate를, 자신의 생성자에서 받아서 넘겨야 한다.
     */
    public NightlyDiscountPhone(Money regularAmount, Duration seconds, Money nightlyAmount, double taxRate) {
        super(regularAmount, seconds, taxRate); // 부모에는 regularAmount를 전달한다.
        this.nightlyAmount = nightlyAmount;
    }

    @Override
    public Money calculateFee() {
        // 부모의 calculateFee 호출
        Money result = super.calculateFee();

        Money nightlyFee = Money.ZERO;

        for (Call call : getCalls()) {
            if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
                nightlyFee = nightlyFee.plus(
                    getAmount().minus(nightlyAmount).times(
                        call.getDuration().getSeconds() / getSeconds().getSeconds()));
            }
        }

        return result.minus(nightlyFee.plus(nightlyFee.times(getTaxRate()))); // nightlyFee도 세금계산을 해서 빼줘야 한다.
    }
}
