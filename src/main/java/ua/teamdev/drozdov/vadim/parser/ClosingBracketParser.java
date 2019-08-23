package ua.teamdev.drozdov.vadim.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.teamdev.drozdov.vadim.*;

import static ua.teamdev.drozdov.vadim.parser.MathExpressionSymbols.CLOSING_BRACKET;

public class ClosingBracketParser implements MathExpressionParser {
    private final Logger logger = LoggerFactory.getLogger(ClosingBracketParser.class);

    @Override
    public EvaluationCommand parse(EvaluationContext context) {
        if (logger.isInfoEnabled()) {
            logger.info("Parsing closing bracket");
        }
        final ExpressionReader expressionReader = context.getExpressionReader();

        if (expressionReader.endOfExpression()) {
            return null;
        }

        if (expressionReader.currentChar() == CLOSING_BRACKET.getSymbol()) {

            expressionReader.incrementIndex(1);

            return new EvaluationCommand() {
                @Override
                public void evaluate(EvaluationStack stack) throws EvaluationException {

                    if (stack.getBracketStack().isEmpty()) {
                        throw new EvaluationException("Opening bracket expected.",
                                expressionReader.getIndex());
                    }

                    stack.pushClosingBracket();
                }
            };
        }

        return null;
    }
}
