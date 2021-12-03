package chap10.billing.step5;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import chap05.money.Money;

/**
 * step 5 : Phone을 NightlyDiscountPhone에서 상속받는 상태에서, 세금 계산 요구가 들어왔을 경우를 가정하자.
 * Phone에스는 이전과 동일하게 taxRate를 추가, 생성자 및 calculateFee를 수정한다.
 */

public class Phone {
    private Money amount;
    private Duration seconds;
    private List<Call> calls = new ArrayList<>();

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

    public double getTaxRate() {
        return taxRate;
    }
}
