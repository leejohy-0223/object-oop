package chap11.billing.step4;

import chap05.money.Money;

public class RateDiscountablePolicy extends AdditionalRatePolicy {

    private Money discountAmount;

    public RateDiscountablePolicy(RatePolicy next, Money discountAmount) {
        super(next);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.minus(discountAmount);
    }
}
