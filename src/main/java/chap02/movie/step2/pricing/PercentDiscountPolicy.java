package chap02.movie.step2.pricing;

import chap02.money.Money;
import chap02.movie.step2.DefaultDiscountPolicy;
import chap02.movie.step2.DiscountCondition;
import chap02.movie.step2.Screening;

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
