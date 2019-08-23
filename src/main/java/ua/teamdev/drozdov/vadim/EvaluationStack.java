package ua.teamdev.drozdov.vadim;

import ua.teamdev.drozdov.vadim.command.Command;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.BinaryOperator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EvaluationStack {
    private final Logger logger = LoggerFactory.getLogger(EvaluationStack.class);

    private final Deque<Double> operandStack = new ArrayDeque<Double>();
    private final Deque<Command> operatorStack = new ArrayDeque<Command>();
    private final Deque<Integer> bracketStack = new ArrayDeque<Integer>();
    private final Deque<Double> functionArgumentStack = new ArrayDeque<Double>();


    public Deque<Double> getOperandStack() {
        return operandStack;
    }

    public Deque<Integer> getBracketStack() {
        return bracketStack;
    }

    public void pushOperator(Command operator) {
        if (logger.isInfoEnabled()) {
            logger.info("pushing operator");
        }


        while (!operatorStack.isEmpty() && operatorStack.peek().compareTo(operator) > -1
                 && bracketStack.isEmpty()) {
            executeTopOperator();
        }

        operatorStack.push(operator);
    }

    public void executeTopOperator() {
        if (logger.isInfoEnabled()) {
            logger.info("executing top operator");
        }

        final Double rightOperand = operandStack.pop();
        final Double leftOperand = operandStack.pop();
        final Command operator = operatorStack.pop();
        try {
            final double result = operator.calculate(leftOperand, rightOperand);
            operandStack.push(result);
        } catch (MathExpressionException e) {
            e.printStackTrace();
        }
    }

    public void popAllOperators() {
        if (logger.isInfoEnabled()) {
            logger.info("pop all operators");
        }

        while (!operatorStack.isEmpty()) {
            executeTopOperator();
        }
    }

    public void pushOpeningBracket() {
        if (logger.isInfoEnabled()) {
            logger.info("opening bracket");
        }
            bracketStack.push(operatorStack.size());

    }

    public void pushClosingBracket() {
        if (logger.isInfoEnabled()) {
            logger.info("closing bracket");
        }
        final Integer operatorStackSize = bracketStack.pop();
        while (operatorStack.size() > operatorStackSize) {
            executeTopOperator();
        }

    }
}
