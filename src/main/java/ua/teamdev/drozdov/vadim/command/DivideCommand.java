package ua.teamdev.drozdov.vadim.command;

import ua.teamdev.drozdov.vadim.MathExpressionException;

public class DivideCommand extends AbstractCommand{

    @Override
    public double calculate(Double leftOperand, Double rightOperand) throws MathExpressionException {

        if(rightOperand.equals(new Double(0))){
            throw new MathExpressionException("Division by 0");
        }
        return leftOperand / rightOperand;
    }


    @Override
    protected Priority getPriority() {
        return Priority.MEDIUM;
    }
}
