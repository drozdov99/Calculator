package ua.teamdev.drozdov.vadim;

import ua.teamdev.drozdov.vadim.abstractFSM.TransitionMatrix;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EvaluationMatrix implements TransitionMatrix<State> {

    private final Map<State, Set<State>> matrix = new HashMap<State, Set<State>>() {{
        put(State.START,
                EnumSet.of(State.NUMBER, State.OPENING_BRACKET));
        put(State.NUMBER,
                EnumSet.of(State.COMMAND, State.CLOSING_BRACKET, State.FINISH));
        put(State.COMMAND,
                EnumSet.of(State.NUMBER, State.OPENING_BRACKET));
        put(State.OPENING_BRACKET,
                EnumSet.of(State.NUMBER, State.OPENING_BRACKET));
        put(State.CLOSING_BRACKET,
                EnumSet.of(State.COMMAND, State.CLOSING_BRACKET, State.FINISH));
        put(State.FINISH,
                EnumSet.noneOf(State.class));
    }};

    @Override
    public State getStartState() {
        return State.START;
    }

    @Override
    public State getFinishState() {
        return State.FINISH;
    }

    @Override
    public Set<State> getPossibleStates(State state) {
        return matrix.get(state);
    }
}
