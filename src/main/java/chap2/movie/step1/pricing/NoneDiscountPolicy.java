package chap2.movie.step1.pricing;

import chap2.money.Money;
import chap2.movie.step1.DiscountPolicy;
import chap2.movie.step1.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
