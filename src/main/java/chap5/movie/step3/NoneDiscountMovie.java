package chap5.movie.step3;

import chap5.money.Money;

import java.time.Duration;

public class NoneDiscountMovie extends Movie{

    public NoneDiscountMovie(String titie, Duration runningTime, Money fee) {
        super(titie, runningTime, fee); // list 안넣어도 됨
    }

    @Override
    protected Money calculateDiscountAmount() {
        return Money.ZERO;
    }
}
