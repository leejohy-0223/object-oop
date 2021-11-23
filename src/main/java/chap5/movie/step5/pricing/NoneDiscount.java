package chap5.movie.step5.pricing;

import chap5.money.Money;
import chap5.movie.step5.DiscountPolicy;
import chap5.movie.step5.Screening;

public class NoneDiscount extends DiscountPolicy {
    @Override
    protected Money calculateDiscountFee(Screening screening) {
        return Money.ZERO;
    }
}
