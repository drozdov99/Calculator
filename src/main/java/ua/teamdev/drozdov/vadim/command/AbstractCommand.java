package ua.teamdev.drozdov.vadim.command;

abstract public class AbstractCommand implements Command{

    static enum  Priority{
        LOW,
        MEDIUM
    }

    protected abstract Priority getPriority();

    @Override
    public int compareTo(Command o) {
        AbstractCommand command = (AbstractCommand) o;
        return this.getPriority().compareTo(command.getPriority());
    }
}
