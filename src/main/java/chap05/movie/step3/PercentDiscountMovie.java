package chap05.movie.step3;

import chap05.money.Money;

import java.time.Duration;

public class PercentDiscountMovie extends Movie {
    private double percent;

    public PercentDiscountMovie(String titie, Duration runningTime, Money fee, double percent, DiscountCondition... discountConditions) {
        super(titie, runningTime, fee, discountConditions);
        this.percent = percent;
    }

    @Override
    protected Money calculateDiscountAmount() {
        return getFee().times(percent);
    }
}
