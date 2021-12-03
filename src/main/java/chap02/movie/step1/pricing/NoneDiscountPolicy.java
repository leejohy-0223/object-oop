package chap02.movie.step1.pricing;

import chap02.money.Money;
import chap02.movie.step1.DiscountPolicy;
import chap02.movie.step1.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
