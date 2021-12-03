package chap10.billing.step2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import chap05.money.Money;

public class Phone {
    private Money amount;
    private Duration seconds;
    private List<Call> calls = new ArrayList<>();

    /**
     * 요구 사항에 따라서, 사용자별로 taxRate를 추가로 가지게 된다.
     * 따라서 생성자 및 calculateFee의 변경이 필요하다.
     */
    private double taxRate;

    public Phone(Money amount, Duration seconds, double taxRate) {
        this.amount = amount;
        this.seconds = seconds;
        this.taxRate = taxRate;
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

        for (Call call : calls) {
            result = result.plus(amount.times((double)(call.getDuration().getSeconds() / seconds.getSeconds())));
        }

        return result.plus(result.times(taxRate));
    }
}
