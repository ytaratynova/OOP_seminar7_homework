package presenter;

import notebook.Note;
import notebook.Notebook;
import ui.View;

import java.time.LocalDate;
import java.util.ArrayList;

public class Presenter {
    private View view;
    private final Notebook notebook;


    public Presenter(View view, Notebook notebook) {
        this.view = view;
        this.notebook = notebook;
        view.setPresenter(this);
    }

    public void addNote(ArrayList<String> newNote) {
        Note newNotebookNote = new Note(LocalDate.now(), newNote.get(0), newNote.get(1));
        notebook.addNote(newNotebookNote);
    }

    public void removeNote(Integer index) {
        notebook.removeNote(index);
    }

    public void changeNote(Integer index, ArrayList<String> changes){
        Note changeNote = new Note(LocalDate.now(), changes.get(0), changes.get(1));
        notebook.changeNote(index, changeNote);
    }

    public ArrayList<String> getNote(Integer index){
        Note note = notebook.getNote(index);
        ArrayList<String> noteParse = new ArrayList<>();
        noteParse.set(0, note.getNote() );
        noteParse.set(1, note.getComment());
        return noteParse;
    }

    public Integer getNotebookSize(){
        return notebook.getSize();
    }

    public String print(){
        return notebook.toString();
    }



}
