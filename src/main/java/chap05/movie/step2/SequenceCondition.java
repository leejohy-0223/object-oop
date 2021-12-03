package chap05.movie.step2;

public class SequenceCondition {

    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    public boolean isSatisfied(Screening screening) {
        return screening.getSequence() == sequence;
    }

}
