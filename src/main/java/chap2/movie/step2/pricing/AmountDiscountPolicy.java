package chap2.movie.step2.pricing;

import chap2.money.Money;
import chap2.movie.step2.DefaultDiscountPolicy;
import chap2.movie.step2.DiscountCondition;
import chap2.movie.step2.DiscountPolicy;
import chap2.movie.step2.Screening;

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
