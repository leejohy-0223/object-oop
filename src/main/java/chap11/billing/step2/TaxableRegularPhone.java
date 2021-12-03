package chap11.billing.step2;

import java.time.Duration;

import chap05.money.Money;

public class TaxableRegularPhone extends RegularPhone {

    private double taxRate;

    public TaxableRegularPhone(Money amount, Duration seconds, double taxRate) {
        super(amount, seconds);
        this.taxRate = taxRate;
    }

    @Override
    public Money calculateFee() {
        Money fee = super.calculateFee(); // super 호출로 인해 결합도 상승
        return fee.plus(fee.times(taxRate));
    }
}
