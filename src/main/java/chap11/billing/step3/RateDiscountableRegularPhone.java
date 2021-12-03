package chap11.billing.step3;

import java.time.Duration;

import chap05.money.Money;

public class RateDiscountableRegularPhone extends RegularPhone {

    private Money discountAmount;

    public RateDiscountableRegularPhone(Money amount, Duration seconds, Money discountAmount) {
        super(amount, seconds);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.minus(discountAmount);
    }
}
