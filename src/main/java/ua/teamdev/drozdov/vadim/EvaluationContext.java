package ua.teamdev.drozdov.vadim;

import ua.teamdev.drozdov.vadim.abstractFSM.StateAcceptor;
import ua.teamdev.drozdov.vadim.abstractFSM.StateMachineContext;
import ua.teamdev.drozdov.vadim.abstractFSM.TransitionMatrix;
import ua.teamdev.drozdov.vadim.command.Command;


public class EvaluationContext implements StateMachineContext<State,
        EvaluationContext, EvaluationException> {

    private final EvaluationMatrix matrix = new EvaluationMatrix();
    private final EvaluationService evaluationService = new EvaluationService();

    private final CommandFactory binaryOperatorFactory = new CommandFactory();

    private final EvaluationStack evaluationStack = new EvaluationStack();

    private final ExpressionReader expressionReader;

    public EvaluationContext(String mathExpression) {
        expressionReader = new ExpressionReader(mathExpression);
    }

    public ExpressionReader getExpressionReader() {
        return expressionReader;
    }

    public CommandFactory getBinaryOperatorFactory() {
        return binaryOperatorFactory;
    }

    public EvaluationStack getEvaluationStack() {
        return evaluationStack;
    }

    @Override
    public TransitionMatrix<State> getTransitionMatrix() {
        return matrix;
    }

    @Override
    public StateAcceptor<State, EvaluationContext, EvaluationException> getStateAcceptor() {
        return evaluationService;
    }
}

