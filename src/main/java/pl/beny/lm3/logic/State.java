package pl.beny.lm3.logic;

public class State {

    private String digit;
    private String nextState;
    private boolean toLeft;

    public State(String digit, String nextState, boolean toLeft) {
        this.digit = digit;
        this.nextState = nextState;
        this.toLeft = toLeft;
    }

    public String getDigit() {
        return digit;
    }

    public void setDigit(String digit) {
        this.digit = digit;
    }

    public String getNextState() {
        return nextState;
    }

    public void setNextState(String nextState) {
        this.nextState = nextState;
    }

    public boolean isToLeft() {
        return toLeft;
    }

    public void setToLeft(boolean toLeft) {
        this.toLeft = toLeft;
    }
}
