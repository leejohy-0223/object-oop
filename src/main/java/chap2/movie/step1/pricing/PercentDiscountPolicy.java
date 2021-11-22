package chap2.movie.step1.pricing;

import chap2.money.Money;
import chap2.movie.step1.DiscountCondition;
import chap2.movie.step1.DiscountPolicy;
import chap2.movie.step1.Screening;

public class PercentDiscountPolicy extends DiscountPolicy {

    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
