package chap10.billing.step4;

import java.time.Duration;

import chap5.money.Money;

public class NightlyDiscountPhone extends Phone {

    private static final int LATE_NIGHT_HOUR = 22;

    private Money nightlyAmount;

    public NightlyDiscountPhone(Money regularAmount, Duration seconds, Money nightlyAmount) {
        super(regularAmount, seconds); // 부모에는 regularAmount를 전달한다.
        this.nightlyAmount = nightlyAmount;
    }

    /**
     * step4 : 상속을 이용한 중복코드 제거
     *
     * @return
     * super 참조를 통해 부모의 calculateFee로 일반 요금제의 요금을 계산한 후, nightlyFee를 별도로 빼줘야 한다.
     *
     */

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

        return result.minus(nightlyFee);
    }
}
