package chap02.movie.step2.pricing;

import chap02.money.Money;
import chap02.movie.step2.DiscountPolicy;
import chap02.movie.step2.Screening;

public class NoneDiscountPolicy implements DiscountPolicy {
    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
