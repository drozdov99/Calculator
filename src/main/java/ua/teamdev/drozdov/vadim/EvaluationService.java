package ua.teamdev.drozdov.vadim;

import ua.teamdev.drozdov.vadim.abstractFSM.StateAcceptor;

import ua.teamdev.drozdov.vadim.parser.*;

import java.util.HashMap;
import java.util.Map;

public class EvaluationService implements StateAcceptor<State, EvaluationContext, EvaluationException> {

    private final Map<State, MathExpressionParser> parsers =
            new HashMap<State, MathExpressionParser>() {{
                put(State.NUMBER,
                        new NumberParser());
                put(State.COMMAND,
                        new CommandParser());
                put(State.OPENING_BRACKET,
                        new OpeningBracketParser());
                put(State.CLOSING_BRACKET,
                        new ClosingBracketParser());
                put(State.FINISH,
                        new EndOfExpressionParser());
            }};


    @Override
    public boolean acceptState(EvaluationContext context, State possibleState) throws EvaluationException {

        final MathExpressionParser parser = parsers.get(possibleState);

        if (parser == null) {
            throw new IllegalStateException("Parser not found for state: " + possibleState);
        }

        context.getExpressionReader().skipWhitespaces();

        final EvaluationCommand evaluationCommand = parser.parse(context);
        if (evaluationCommand == null) {
            return false;
        }

        evaluationCommand.evaluate(context.getEvaluationStack());

        return true;
    }
}

