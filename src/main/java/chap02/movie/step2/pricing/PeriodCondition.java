package chap02.movie.step2.pricing;

import chap02.movie.step2.DiscountCondition;
import chap02.movie.step2.Screening;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class PeriodCondition implements DiscountCondition {

    private DayOfWeek dayOfWeek; // 요일
    private LocalTime startTime;
    private LocalTime endTime;

    public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.getStartTime().getDayOfWeek().equals(dayOfWeek) &&
                startTime.compareTo(screening.getStartTime().toLocalTime()) <= 0 && // starttime이 더 앞설 경우, 0보다 작음
                endTime.compareTo(screening.getStartTime().toLocalTime()) >= 0; // endTime이 더 뒤일 경우, 0보다 큼
    }
}
