package chap05.movie.step1;


import chap05.money.Money;

import java.time.Duration;
import java.util.List;

public class Movie {
    private String titie;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

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
        return discountConditions.stream()
                .anyMatch(condition -> condition.isSatisfiedBy(screening));
    }
}
