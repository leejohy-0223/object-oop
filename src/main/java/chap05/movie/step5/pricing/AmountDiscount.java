package chap05.movie.step5.pricing;

import chap05.money.Money;
import chap05.movie.step5.DiscountCondition;
import chap05.movie.step5.DiscountPolicy;
import chap05.movie.step5.Screening;

public class AmountDiscount extends DiscountPolicy {

    private Money discountAmount;

    public AmountDiscount(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money calculateDiscountFee(Screening screening) {
        return discountAmount;
    }
}
