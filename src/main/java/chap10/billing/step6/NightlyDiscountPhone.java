package chap10.billing.step6;

import java.time.Duration;

import chap05.money.Money;

public class NightlyDiscountPhone extends AbstractPhone {
    private static final int LATE_NIGHT_HOUR = 22;

    private Money nightlyAmount;
    private Money regularAmount;
    private Duration seconds;

    public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds) {
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
    }

    @Override
    protected Money calculateCallFee(Call call) {
        if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
            return nightlyAmount.times((double)(call.getDuration().getSeconds() / seconds.getSeconds()));
        } else {
            return regularAmount.times((double)(call.getDuration().getSeconds() / seconds.getSeconds()));
        }
    }
}
