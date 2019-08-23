package ua.teamdev.drozdov.vadim;

public class ExpressionReader {

    private final String expression;
    private int index = 0;

    public ExpressionReader(String expression) { this.expression = expression; }

    public String getExpression() {
        return expression;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public char currentChar() {
        return expression.charAt(index);
    }

    public void incrementIndex(int value) {
        index += value;
    }

    public String getRemainingExpression() {
        return expression.substring(index);
    }

    public boolean endOfExpression() {
        return index >= expression.length();
    }

    public void skipWhitespaces() {
        while (!endOfExpression() && Character.isWhitespace(expression.charAt(index))) {
            index++;
        }
    }
}
