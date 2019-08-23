package ua.teamdev.drozdov.vadim.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.teamdev.drozdov.vadim.*;
import ua.teamdev.drozdov.vadim.command.Command;

public class CommandParser implements MathExpressionParser {

    private final Logger logger = LoggerFactory.getLogger(CommandParser.class);

    @Override
    public EvaluationCommand parse(EvaluationContext context) {
        if (logger.isInfoEnabled()) {
            logger.info("Parsing binary operator");
        }

        final ExpressionReader expressionReader = context.getExpressionReader();
        final CommandFactory factory = context.getBinaryOperatorFactory();

        final String remainingExpression = expressionReader.getRemainingExpression();
        for (String presentation : factory.getAvailableOperatorPresentations()) {
            if (remainingExpression.startsWith(presentation)) {

                expressionReader.incrementIndex(presentation.length());

                final Command binaryOperator = factory.create(presentation);

                return new EvaluationCommand() {
                    @Override
                    public void evaluate(EvaluationStack stack) {
                        stack.pushOperator(binaryOperator);
                    }
                };
            }
        }

        return null;
    }
}
