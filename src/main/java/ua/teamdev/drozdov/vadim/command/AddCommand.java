package ua.teamdev.drozdov.vadim.command;

public class AddCommand extends AbstractCommand {

    @Override
    protected Priority getPriority() {
        return Priority.LOW;
    }

    @Override
    public double calculate(Double leftOperand, Double rightOperand) {
        return leftOperand + rightOperand;
    }
}
