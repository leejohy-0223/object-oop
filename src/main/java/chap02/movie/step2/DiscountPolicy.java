package chap02.movie.step2;

import chap02.money.Money;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
