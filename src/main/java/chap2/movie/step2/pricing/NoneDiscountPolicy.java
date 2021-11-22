package chap2.movie.step2.pricing;

import chap2.money.Money;
import chap2.movie.step2.DiscountPolicy;
import chap2.movie.step2.Screening;

public class NoneDiscountPolicy implements DiscountPolicy {
    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
