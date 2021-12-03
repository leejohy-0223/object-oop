package chap05.movie.step3;


import chap05.money.Money;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public abstract class Movie {
    private String titie;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    protected Money getFee() {
        return fee;
    }

    public Movie(String titie, Duration runningTime, Money fee, DiscountCondition ... discountConditions) {
        this.titie = titie;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountConditions = Arrays.asList(discountConditions);
    }

    public Money calculateMovieFee(Screening screening) {
        if (isDiscountable(screening)) { // 할인 여부는 여기에서 모두 검증되므로, 추가적인 DiscountCondition이 추가되어도 문제없다!!!
            return fee.minus(calculateDiscountAmount());
        }

        return fee;
    }

    private boolean isDiscountable(Screening screening) {
        return discountConditions.stream()
                .anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    abstract protected Money calculateDiscountAmount();

}
