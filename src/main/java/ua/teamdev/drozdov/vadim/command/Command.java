package ua.teamdev.drozdov.vadim.command;

import ua.teamdev.drozdov.vadim.MathExpressionException;

public interface Command extends Comparable<Command>{

    double calculate(Double leftOperand, Double rightOperand) throws MathExpressionException;
}
