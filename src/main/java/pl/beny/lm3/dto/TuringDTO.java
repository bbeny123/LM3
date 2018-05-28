package pl.beny.lm3.dto;

import pl.beny.lm3.logic.State;
import pl.beny.lm3.logic.TuringMachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TuringDTO {

    private String input;
    private String currentState = "q0";
    private String statesRoute = "-->q0";
    private String result;
    private int position = 0;
    private boolean start = true;
    private boolean movable = true;
    private boolean automatic = false;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public String getStatesRoute() {
        return statesRoute;
    }

    public void setStatesRoute(String statesRoute) {
        this.statesRoute = statesRoute;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public boolean isMovable() {
        return movable;
    }

    public void setMovable(boolean movable) {
        this.movable = movable;
    }

    public boolean isAutomatic() {
        return automatic && !isFinish();

    }

    public void setAutomatic(boolean automatic) {
        this.automatic = automatic;
    }

    public boolean isFinish() {
        return !movable || position >= getInput().length();
    }

    public List<String> getFormatedResultList() {
        return Arrays.asList(result.replaceAll("z", "\u0398").split(""));
    }

    public String getFormatedInput() {
        return input.replaceAll("z", "\u0398");
    }

    public List<String> getArrows() {
        List<String> arrows = new ArrayList<>();
        for(int i = input.length() - position - 1; i > 0; i--) {
            arrows.add("");
        }
        arrows.add("\u2193");
        return arrows;
    }

    public void run() {
        int digitIndex = result.length() - position;
        String digit = result.substring(digitIndex - 1, digitIndex);
        State state = TuringMachine.getNextState(currentState, digit);
        currentState = state.getNextState();
        movable = state.isToLeft();
        position = movable ? position + 1 : position;
        result = result.substring(0, digitIndex - 1) + state.getDigit() + result.substring(digitIndex, result.length());
        statesRoute += "-->" + currentState;
    }
}
