package ua.teamdev.drozdov.vadim;

public class MathExpressionException extends Exception {

    public String mathError;

    public MathExpressionException( String mathError) {

        this.mathError = mathError;
    }
}
