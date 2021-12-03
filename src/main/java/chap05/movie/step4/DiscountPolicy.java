package chap05.movie.step4;

import chap05.money.Money;

import java.util.Arrays;
import java.util.List;

public abstract class DiscountPolicy {

    private List<DiscountCondition> discountConditions;

    protected DiscountPolicy(DiscountCondition ... discountConditions) {
        this.discountConditions = Arrays.asList(discountConditions);
    }

    private boolean isDiscountable(Screening screening) {
        return discountConditions.stream()
                .anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    public Money calculateDiscountAmount(Screening screening) {
        if (isDiscountable(screening)) {
            return getDiscountAmount(screening);
        }
        return Money.ZERO;
    }

    public abstract Money getDiscountAmount(Screening screening);
}
