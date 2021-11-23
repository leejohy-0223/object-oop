package chap5.movie.step3;

import chap5.money.Money;

import java.time.Duration;

public class AmountDiscountMovie extends Movie {
    private Money discountAmount;

    public AmountDiscountMovie(String titie, Duration runningTime, Money fee, Money discountAmount, DiscountCondition... discountConditions) {
        super(titie, runningTime, fee, discountConditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money calculateDiscountAmount() {
        return discountAmount;
    }
}
