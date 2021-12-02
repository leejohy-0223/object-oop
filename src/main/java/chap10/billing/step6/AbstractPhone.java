package chap10.billing.step6;

import java.util.ArrayList;
import java.util.List;

import chap5.money.Money;

public abstract class AbstractPhone {

    private List<Call> calls = new ArrayList<>();


    /*
     * 1. 공통적인 부분은 추상 클래스로 올려라.
     */
    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            // 심야 요금제와 따로 계산이 필요해진다.
            result = result.plus(calculateCallFee(call)); // 부모에서도 자신의 추상 메서드를 호출 = 추상화에 의존하게 된다.
        }

        return result;
    }

    /*
     * 차이점은 메서드로 추출 후, 추상 메서드로 올려라
     */
    protected abstract Money calculateCallFee(Call call);


}
