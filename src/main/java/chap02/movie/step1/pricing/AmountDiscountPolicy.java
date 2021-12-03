package chap02.movie.step1.pricing;

import chap02.money.Money;
import chap02.movie.step1.DiscountCondition;
import chap02.movie.step1.DiscountPolicy;
import chap02.movie.step1.Screening;

public class AmountDiscountPolicy extends DiscountPolicy {
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
