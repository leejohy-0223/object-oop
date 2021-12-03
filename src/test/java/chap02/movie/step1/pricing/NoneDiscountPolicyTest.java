package chap02.movie.step1.pricing;

import chap02.money.Money;
import chap02.movie.step1.Movie;
import chap02.movie.step1.Screening;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

class NoneDiscountPolicyTest {

    @DisplayName("NoneDiscountPolicy의 정책이 잘 반영되는가?")
    @Test
    void noneDiscountPolicy() {
        Movie starWars = new Movie("스타워즈",
                Duration.ofMinutes(210),
                Money.wons(10000),
                new NoneDiscountPolicy());

        Money money = starWars.calculateMovieFee(new Screening(starWars, 1, LocalDateTime.now()));
        Assertions.assertThat(money).isEqualTo(Money.wons(10000));
    }


}