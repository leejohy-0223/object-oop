package chap6.event.step2;

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

class EventTest {

    Event event;

    @BeforeEach
    void init() {
        event = new Event("스프링 회의", LocalDateTime.of(2021, 11, 24, 10, 30), Duration.ofMinutes(30));
    }

    @ParameterizedTest
    @MethodSource("RecurringSource")
    @DisplayName("daysDistance 계산")
    void calculateDaysDistance(RecurringSchedule recurringSchedule, long result) {
        Assertions.assertThat(event.daysDistance(recurringSchedule)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("ResultLocalDateTimeSource")
    @DisplayName("reschedule 계산")
    void calculateReschedule(RecurringSchedule recurringSchedule, LocalDateTime result) {
        event.reschedule(recurringSchedule);
        Assertions.assertThat(event.getFrom()).isEqualTo(result);
    }

    private static Stream<Arguments> RecurringSource() {
        return Stream.of(
                Arguments.arguments(new RecurringSchedule("자유", DayOfWeek.TUESDAY, LocalTime.of(10, 30), Duration.ofMinutes(30)), -1),
                Arguments.arguments(new RecurringSchedule("자유", DayOfWeek.WEDNESDAY, LocalTime.of(10, 30), Duration.ofMinutes(30)), 0),
                Arguments.arguments(new RecurringSchedule("자유", DayOfWeek.FRIDAY, LocalTime.of(10, 30), Duration.ofMinutes(30)), 2)
        );
    }

    private static Stream<Arguments> ResultLocalDateTimeSource() {
        return Stream.of(
                Arguments.arguments(new RecurringSchedule("자유", DayOfWeek.TUESDAY, LocalTime.of(10, 30), Duration.ofMinutes(30)), LocalDateTime.of(2021, 11, 23, 10, 30)),
                Arguments.arguments(new RecurringSchedule("자유", DayOfWeek.WEDNESDAY, LocalTime.of(10, 30), Duration.ofMinutes(30)), LocalDateTime.of(2021, 11, 24, 10, 30)),
                Arguments.arguments(new RecurringSchedule("자유", DayOfWeek.FRIDAY, LocalTime.of(10, 30), Duration.ofMinutes(30)), LocalDateTime.of(2021, 11, 26, 10, 30))
        );
    }
}