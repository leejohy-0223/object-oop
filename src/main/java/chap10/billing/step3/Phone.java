package chap10.billing.step3;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import chap05.money.Money;

public class Phone {

    private static final int LATE_NIGHT_HOUR = 22;
    enum PhoneType { REGULAR, NIGHTLY }

    private PhoneType phoneType;

    private Money amount;
    private Money nightlyAmount;
    private Money regularAmount;
    private Duration seconds;
    private List<Call> calls = new ArrayList<>();

    /**
     * step 3 : 하나의 타입으로 합치기
     * 한 클래스에 Phone, NightlyDiscountPhone 두 개를 합쳤다.
     * 생성자를 오버로딩해야 한다.
     */

    public Phone(Money amount, Duration seconds) {
        this(PhoneType.REGULAR, amount, Money.ZERO, Money.ZERO, seconds);
    }

    public Phone(Money nightlyAmount, Money regularAmount, Duration seconds) {
        this(PhoneType.NIGHTLY, Money.ZERO, nightlyAmount, regularAmount, seconds);
    }

    private Phone(PhoneType phoneType, Money amount, Money nightlyAmount, Money regularAmount, Duration seconds) {
        this.phoneType = phoneType;
        this.amount = amount;
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
    }


    public void call(Call call) {
        calls.add(call);
    }

    public List<Call> getCalls() {
        return calls;
    }

    public Money getAmount() {
        return amount;
    }

    public Duration getSeconds() {
        return seconds;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        if (phoneType == PhoneType.REGULAR) {
            // regular일 때 구현
        } else {
            // nightly일 때 구현
        }


        return result;
    }
}
