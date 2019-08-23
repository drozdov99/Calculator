package ua.teamdev.drozdov.vadim.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.teamdev.drozdov.vadim.*;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;

public class NumberParser implements MathExpressionParser {
    private final Logger logger = LoggerFactory.getLogger(NumberParser.class);

    private final NumberFormat numberFormat = DecimalFormat.getNumberInstance(Locale.ENGLISH);

    @Override
    public EvaluationCommand parse(EvaluationContext context) {
        if (logger.isInfoEnabled()) {
            logger.info("Parsing number");
        }

        final ExpressionReader expressionReader = context.getExpressionReader();
        final String mathExpression = expressionReader.getExpression();
        final int index = expressionReader.getIndex();

        final ParsePosition parsePosition = new ParsePosition(index);
        final Number number = numberFormat.parse(mathExpression, parsePosition);
        if (parsePosition.getErrorIndex() != -1) {
            return null;
        }

        expressionReader.setIndex(parsePosition.getIndex());

        return new EvaluationCommand() {
            @Override
            public void evaluate(EvaluationStack stack) {
                stack.getOperandStack().push(number.doubleValue());
            }
        };
    }
}