package ua.teamdev.drozdov.vadim;

public class EvaluationException extends Exception {

    private int errorIndex;


    public EvaluationException(String message, int errorIndex) {
        super(message);
        this.errorIndex = errorIndex;

    }

    public int getErrorIndex() {
        return errorIndex;
    }


}
