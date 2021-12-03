package chap02.movie.step2.pricing;

import chap02.money.Money;
import chap02.movie.step2.DefaultDiscountPolicy;
import chap02.movie.step2.DiscountCondition;
import chap02.movie.step2.Screening;

public class AmountDiscountPolicy extends DefaultDiscountPolicy {
    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
