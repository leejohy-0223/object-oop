package chap10.billing.step2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import chap5.money.Money;

public class NightlyDiscountPhone {
    private static final int LATE_NIGHT_HOUR = 22;

    private Money nightlyAmount;
    private Money regularAmount;
    private Duration seconds;
    private List<Call> calls = new ArrayList<>();

    /**
     * (일반)Phone과 마찬가지로, 세율 인자를 추가해줘야 한다.
     */
    private double taxRate;

    public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds, double taxRate) {
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
        this.taxRate = taxRate;
    }

    public void call(Call call) {
        calls.add(call);
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            // 심야 요금제와 따로 계산이 필요해진다.
            if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
                result = result.plus(nightlyAmount.times((double)(call.getDuration().getSeconds() / seconds.getSeconds())));
            } else {
                result = result.plus(regularAmount.times((double)(call.getDuration().getSeconds() / seconds.getSeconds())));
            }
        }

        return result.plus(result.times(taxRate));
    }
}
