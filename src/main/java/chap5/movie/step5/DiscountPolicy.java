package chap5.movie.step5;

import chap5.money.Money;

import java.util.Arrays;
import java.util.List;

public abstract class DiscountPolicy {

    List<DiscountCondition> conditions;

    public DiscountPolicy(DiscountCondition ... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    public Money calculate(Screening screening) {

        for (DiscountCondition condition : conditions) {
            if (condition.isSatisfied(screening)) {
                return calculateDiscountFee(screening);
            }
        }
        return Money.ZERO;
    }

    protected abstract Money calculateDiscountFee(Screening screening);

}
