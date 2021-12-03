package chap10.billing.step7;

import java.util.ArrayList;
import java.util.List;

import chap05.money.Money;

public abstract class Phone {

    /*
     * step 7 : 추상 클래스 사용할 경우, 요구 사항 변경(세금 계산 추가)
     */
    private double taxRate;
    private List<Call> calls = new ArrayList<>();

    public Phone(double taxRate) {
        this.taxRate = taxRate;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            // 심야 요금제와 따로 계산이 필요해진다.
            result = result.plus(calculateCallFee(call)); // 부모에서도 자신의 추상 메서드를 호출 = 추상화에 의존하게 된다.
        }

        return result.plus(result.times(taxRate));
    }

    protected abstract Money calculateCallFee(Call call);


}
