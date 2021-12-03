package chap05.movie.step4;

import chap05.money.Money;

public class NoneDiscountPolicy extends DiscountPolicy {

    @Override
    public Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
