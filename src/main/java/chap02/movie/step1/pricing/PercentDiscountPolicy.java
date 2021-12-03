package chap02.movie.step1.pricing;

import chap02.money.Money;
import chap02.movie.step1.DiscountCondition;
import chap02.movie.step1.DiscountPolicy;
import chap02.movie.step1.Screening;

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
