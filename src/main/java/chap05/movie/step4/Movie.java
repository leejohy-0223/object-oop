package chap05.movie.step4;


import chap05.money.Money;

import java.time.Duration;

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
