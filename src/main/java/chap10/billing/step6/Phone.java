package chap10.billing.step6;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import chap5.money.Money;

public class Phone extends AbstractPhone {

    private Money amount;
    private Duration seconds;

    /**
     * 요구 사항에 따라서, 사용자별로 taxRate를 추가로 가지게 된다.
     * 따라서 생성자 및 calculateFee의 변경이 필요하다.
     */

    public Phone(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }


    public Money getAmount() {
        return amount;
    }

    public Duration getSeconds() {
        return seconds;
    }

    @Override
    protected Money calculateCallFee(Call call) {
        return amount.times((double)(call.getDuration().getSeconds() / seconds.getSeconds()));
    }
}
