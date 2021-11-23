package chap5.movie.step2;


import chap5.money.Money;

import java.time.Duration;
import java.util.List;

public class Movie {
    private String titie;
    private Duration runningTime;
    private Money fee;

    private List<PeriodCondition> periodConditions;
    private List<SequenceCondition> sequenceConditions;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    public Money calculateMovieFee(Screening screening) {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }

        return fee;
    }

    private Money calculateDiscountAmount() {
        switch (movieType) {
            case AMOUNT_DISCOUNT:
                return calculateAmountDiscount();
            case PERCENT_DISCOUNT:
                return calculatePercentDiscount();
            case NONE_DISCOUNT:
                return calculateNonDiscount();
        }

        throw new IllegalStateException();
    }

    private Money calculateNonDiscount() {
        return Money.ZERO;
    }

    private Money calculatePercentDiscount() {
        return fee.times(discountPercent);
    }

    private Money calculateAmountDiscount() {
        return discountAmount;
    }

    private boolean isDiscountable(Screening screening) {
        return checkPeriodConditions(screening) || checkSequenceConditions(screening);
    }

    private boolean checkSequenceConditions(Screening screening) {
        return sequenceConditions.stream()
                .anyMatch(condition -> condition.isSatisfied(screening));
    }

    private boolean checkPeriodConditions(Screening screening) {
        return periodConditions.stream()
                .anyMatch(condition -> condition.isSatisfiedBy(screening));
    }
}
