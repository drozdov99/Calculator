package ua.teamdev.drozdov.vadim.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.teamdev.drozdov.vadim.*;

import static ua.teamdev.drozdov.vadim.parser.MathExpressionSymbols.OPENING_BRACKET;

public class OpeningBracketParser implements MathExpressionParser {
    private final Logger logger = LoggerFactory.getLogger(OpeningBracketParser.class);

    @Override
    public EvaluationCommand parse(EvaluationContext context) {
        if (logger.isInfoEnabled()) {
            logger.info("Parsing opening bracket");
        }

        final ExpressionReader expressionReader = context.getExpressionReader();

        if (expressionReader.currentChar() == OPENING_BRACKET.getSymbol()) {

            expressionReader.incrementIndex(1);

            return new EvaluationCommand() {
                @Override
                public void evaluate(EvaluationStack stack) {
                    stack.pushOpeningBracket();
                }
            };
        }

        return null;
    }
}
