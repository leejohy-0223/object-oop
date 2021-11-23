package chap5.movie.step5;

import chap5.money.Money;
import chap5.movie.step5.pricing.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class DiscountPolicyTest {

    public Screening screening;
    public Movie movie;
    public DiscountPolicy discountPolicy;

    @ParameterizedTest
    @DisplayName("DiscountPolicy test - 3가지, condition 모두 충족한다고 가정한다.")
    @MethodSource("changePolicy")
    void calculateDiscountFee(DiscountPolicy policy, Money result) {
        discountPolicy = policy;
        movie = new Movie("avengers", Duration.ofHours(1), Money.wons(10000), policy);
        screening = new Screening(movie, 3, LocalDateTime.now());

        Assertions.assertThat(discountPolicy.calculate(screening)).isEqualTo(result);
    }

    private static Stream<Arguments> changePolicy() {
        return Stream.of(
                arguments(new AmountDiscount(Money.wons(1000), new DiscountSequenceCondition(3)), Money.wons(1000)), // 금액 할인
                arguments(new PercentDiscount(0.2, new DiscountSequenceCondition(3)), Money.wons(2000)), // 정률 할인
                arguments(new NoneDiscount(), Money.wons(0))); // 할인 없음
    }

}