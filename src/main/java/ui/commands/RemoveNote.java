package ui.commands;

import ui.Console;

public class RemoveNote extends Command implements Options{
    public RemoveNote(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Удалить запись";
    }

    @Override
    public void run() {
        getConsole().removeNote();
    }
}
