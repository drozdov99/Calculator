package ua.teamdev.drozdov.vadim.command;

import ua.teamdev.drozdov.vadim.MathExpressionException;

public class SubtractCommand extends AbstractCommand {

    @Override
    protected Priority getPriority() {
        return Priority.LOW;
    }

    @Override
    public double calculate(Double leftOperand, Double rightOperand) throws MathExpressionException {
        return leftOperand - rightOperand;
    }
}
