package ua.teamdev.drozdov.vadim.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.teamdev.drozdov.vadim.*;

public class EndOfExpressionParser implements MathExpressionParser {
    private final Logger logger = LoggerFactory.getLogger(EndOfExpressionParser.class);

    @Override
    public EvaluationCommand parse(EvaluationContext context) {
        if (logger.isInfoEnabled()) {
            logger.info("Parsing end of expression");
        }
        final ExpressionReader reader = context.getExpressionReader();

        if (!reader.endOfExpression()) {
            return null;
        }

        return new EvaluationCommand() {
            @Override
            public void evaluate(EvaluationStack stack) throws EvaluationException {

                if (!stack.getBracketStack().isEmpty()) {
                    throw new EvaluationException("Closing bracket expected.", reader.getIndex());
                }

                stack.popAllOperators();
            }
        };
    }
}