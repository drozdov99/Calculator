package ua.teamdev.drozdov.vadim;

import ua.teamdev.drozdov.vadim.abstractFSM.FiniteStateMachine;

public class StateMachineCalculator extends FiniteStateMachine<
        State, EvaluationContext, Double, EvaluationException>
        implements MathExpressionCalculator {

    @Override
    public double evaluate(String mathExpression) throws EvaluationException {
        return run(new EvaluationContext(mathExpression));
    }

    @Override
    protected void deadlock(EvaluationContext context, State currentState) throws EvaluationException {
        throw new EvaluationException("Incorrect expression format.",
                context.getExpressionReader().getIndex());
    }

    @Override
    protected Double finish(EvaluationContext context) {
        return context.getEvaluationStack().getOperandStack().pop();
    }



}
