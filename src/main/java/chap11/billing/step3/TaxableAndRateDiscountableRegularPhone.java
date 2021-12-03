package chap11.billing.step3;

import java.time.Duration;

import chap05.money.Money;

public class TaxableAndRateDiscountableRegularPhone extends TaxableRegularPhone {

    private Money discountAmount;

    public TaxableAndRateDiscountableRegularPhone(Money amount, Duration seconds, double taxRate, Money discountAmount) {
        super(amount, seconds, taxRate);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return super.afterCalculated(fee).minus(discountAmount);
    }
}
