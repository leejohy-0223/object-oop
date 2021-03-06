package chap05.movie.step5.pricing;

import chap05.money.Money;
import chap05.movie.step5.DiscountCondition;
import chap05.movie.step5.DiscountPolicy;
import chap05.movie.step5.Screening;

public class PercentDiscount extends DiscountPolicy {

    private double discountPercent;

    public PercentDiscount(double discountPercent, DiscountCondition... conditions) {
        super(conditions);
        this.discountPercent = discountPercent;
    }

    @Override
    protected Money calculateDiscountFee(Screening screening) {
        return screening.getFee().times(discountPercent);
    }
}
