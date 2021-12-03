package chap05.movie.step5;

import chap05.money.Money;
import chap05.movie.step5.pricing.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ConditionTest {

    public static Screening screening;
    public static Movie movie1, movie2;

    @BeforeEach
    void init() {
        movie1 = new Movie("avengers", Duration.ofHours(1), Money.wons(10000), new AmountDiscount(Money.wons(1000), new DiscountSequenceCondition(3)));
        movie2 = new Movie("infinityWar", Duration.ofHours(2), Money.wons(20000), new AmountDiscount(Money.wons(3000), new DiscountPeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(15, 0), LocalTime.of(16, 0))));
    }

    @ParameterizedTest
    @DisplayName("condition 만족 여부 test, AmountDiscount로 통일")
    @MethodSource("changeCondition")
    void calculateDiscountFee(DiscountCondition condition, Money result, Movie movie) {

        screening = new Screening(movie, 3, LocalDateTime.of(2021, 11, 23, 15, 0));

        Assertions.assertThat(condition.isSatisfied(screening)).isEqualTo(true);
    }

    private static Stream<Arguments> changeCondition() {
        return Stream.of(
                arguments(new DiscountSequenceCondition(3), Money.wons(1000), movie1),// sequenceCondition
                arguments(new DiscountPeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(15, 0), LocalTime.of(16, 0)), Money.wons(3000), movie2)); // periodCondition
    }
}
