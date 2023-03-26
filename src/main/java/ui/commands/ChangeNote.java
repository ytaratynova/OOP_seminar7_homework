package ui.commands;

import ui.Console;

public class ChangeNote extends Command implements Options{
    public ChangeNote(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Изменить запись";
    }

    @Override
    public void run() {
        getConsole().changeNote();
    }
}
