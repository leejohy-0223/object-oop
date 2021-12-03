package chap05.movie.step5.pricing;

import chap05.money.Money;
import chap05.movie.step5.DiscountPolicy;
import chap05.movie.step5.Screening;

public class NoneDiscount extends DiscountPolicy {
    @Override
    protected Money calculateDiscountFee(Screening screening) {
        return Money.ZERO;
    }
}
