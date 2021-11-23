package chap5.movie.step4;


import chap5.money.Money;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Movie {
    private String titie;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Money getFee() {
        return fee;
    }

    public Movie(String titie, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.titie = titie;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }


}
