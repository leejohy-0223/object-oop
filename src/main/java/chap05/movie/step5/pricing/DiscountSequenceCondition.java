package chap05.movie.step5.pricing;

import chap05.movie.step5.DiscountCondition;
import chap05.movie.step5.Screening;

public class DiscountSequenceCondition implements DiscountCondition {
    private int sequence;

    public DiscountSequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfied(Screening screening) {
        return sequence == screening.getSequence();
    }
}
