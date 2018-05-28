package pl.beny.lm3.logic;

import java.util.HashMap;
import java.util.Map;

public class TuringMachine {

    public static State getNextState(String state, String digit) {
        return getTuringMachine().get(state).get(digit);
    }

    private static Map<String, Map<String, State>> getTuringMachine() {
        Map<String, Map<String, State>> transitions = new HashMap<>();
        Map<String, State> transition = new HashMap<>();
        transition.put(DIGITS.D0, new State(DIGITS.D1, STATES.Q1, true));
        transition.put(DIGITS.D1, new State(DIGITS.D0, STATES.Q2, true));
        transition.put(DIGITS.DZ, new State(DIGITS.D1, STATES.Q1, true));
        transitions.put(STATES.Q0, transition);

        transition = new HashMap<>();
        transition.put(DIGITS.D0, new State(DIGITS.D1, STATES.Q3, true));
        transition.put(DIGITS.D1, new State(DIGITS.D0, STATES.Q4, true));
        transition.put(DIGITS.DZ, new State(DIGITS.D1, STATES.Q3, false));
        transitions.put(STATES.Q1, transition);

        transition = new HashMap<>();
        transition.put(DIGITS.D0, new State(DIGITS.D0, STATES.Q4, true));
        transition.put(DIGITS.D1, new State(DIGITS.D1, STATES.Q4, true));
        transition.put(DIGITS.DZ, new State(DIGITS.D0, STATES.Q4, true));
        transitions.put(STATES.Q2, transition);

        transition = new HashMap<>();
        transition.put(DIGITS.D0, new State(DIGITS.D0, STATES.Q3, true));
        transition.put(DIGITS.D1, new State(DIGITS.D1, STATES.Q3, true));
        transition.put(DIGITS.DZ, new State(DIGITS.DZ, STATES.Q3, false));
        transitions.put(STATES.Q3, transition);

        transition = new HashMap<>();
        transition.put(DIGITS.D0, new State(DIGITS.D1, STATES.Q3, true));
        transition.put(DIGITS.D1, new State(DIGITS.D0, STATES.Q4, true));
        transition.put(DIGITS.DZ, new State(DIGITS.D1, STATES.Q3, false));
        transitions.put(STATES.Q4, transition);
        return transitions;
    }

    private interface DIGITS {
        String D0 = "0";
        String D1 = "1";
        String DZ = "z";
    }

    private interface STATES {
        String Q0 = "q0";
        String Q1 = "q1";
        String Q2 = "q2";
        String Q3 = "q3";
        String Q4 = "q4";
    }
}
