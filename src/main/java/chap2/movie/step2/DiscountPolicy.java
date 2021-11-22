package chap2.movie.step2;

import chap2.money.Money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
