package chap2.movie.step2.pricing;

import chap2.money.Money;
import chap2.movie.step2.DefaultDiscountPolicy;
import chap2.movie.step2.DiscountCondition;
import chap2.movie.step2.DiscountPolicy;
import chap2.movie.step2.Screening;

public class PercentDiscountPolicy extends DefaultDiscountPolicy {

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
