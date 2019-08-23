package ua.teamdev.drozdov.vadim;

public interface EvaluationCommand {
    void evaluate(EvaluationStack stack) throws EvaluationException;
}
