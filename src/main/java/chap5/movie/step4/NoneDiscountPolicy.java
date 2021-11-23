package chap5.movie.step4;

import chap5.money.Money;

import java.time.Duration;

public class NoneDiscountPolicy extends DiscountPolicy {

    @Override
    public Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
