
import notebook.Notebook;
import presenter.Presenter;
import ui.Console;
import ui.View;

public class Main {
    public static void main(String[] args){
        View view = new Console();
        Notebook notebook = new Notebook();
        new Presenter(view, notebook);

        view.start();

    }
}
