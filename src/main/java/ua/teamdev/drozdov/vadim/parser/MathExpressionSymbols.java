package ua.teamdev.drozdov.vadim.parser;

public enum MathExpressionSymbols {
    OPENING_BRACKET('('),
    CLOSING_BRACKET(')'),
    COMMA(',');

    private final char symbol;

    MathExpressionSymbols(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
