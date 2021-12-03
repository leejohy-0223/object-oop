package chap06.event.step2;

import java.time.Duration;
import java.time.LocalDateTime;

public class Event {
    private String subject;
    private LocalDateTime from;
    private Duration duration;

    public Event(String subject, LocalDateTime from, Duration duration) {
        this.subject = subject;
        this.from = from;
        this.duration = duration;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public boolean isSatisfied(RecurringSchedule schedule) {
        return from.getDayOfWeek() == schedule.getDayOfWeek() && from.toLocalTime().equals(schedule.getFrom()) && duration.equals(schedule.getDuration());
    }

    public void reschedule(RecurringSchedule schedule) {
        from = LocalDateTime.of(from.toLocalDate().plusDays(daysDistance(schedule)), schedule.getFrom()); // localDate와 LocalTime을 각각 받는다. Date의 경우 daysDistance를 통해 타겟까지 plus 혹은 마이너스를 한다.
        duration = schedule.getDuration();
    }

    public long daysDistance(RecurringSchedule schedule) {
        return schedule.getDayOfWeek().getValue() - from.getDayOfWeek().getValue();
    }
}
