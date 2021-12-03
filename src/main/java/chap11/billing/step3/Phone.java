package chap11.billing.step3;

import java.util.ArrayList;
import java.util.List;

import chap05.money.Money;

public abstract class Phone {
    private List<Call> calls = new ArrayList<>();

    public Money calculateFee() {
        Money result = Money.ZERO;

        for(Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }

        return result;
    }

    protected Money afterCalculated(Money fee) {
        return fee; // 기본 정책이므로 요금 그대로 반환하면 된다.
    }

    abstract protected Money calculateCallFee(Call call);
}
