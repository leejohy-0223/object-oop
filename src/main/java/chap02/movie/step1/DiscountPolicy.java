package chap02.movie.step1;

import chap02.money.Money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DiscountPolicy {
    private List<DiscountCondition> conditions = new ArrayList<>(); // 할인 조건을 가진다.

    public DiscountPolicy(DiscountCondition... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening); // 하위 클래스에 위임 : 템플릿 메서드 패턴
            }
        }

        return Money.ZERO; // none 처리를 위해 이 부분을 해결하자.
    }

    abstract protected Money getDiscountAmount(Screening screening);

}
