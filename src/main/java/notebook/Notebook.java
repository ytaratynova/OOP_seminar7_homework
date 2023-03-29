package notebook;

import java.util.ArrayList;

public class Notebook{
    private ArrayList<Note> notebook;

    public Notebook(){
        notebook = new ArrayList<Note>();
    }

    public void addNote(Note note){
        this.notebook.add(note);
    }


    public void removeNote(int index) {
        notebook.remove(index);
    }


    public Note getNote(Integer index){
        return notebook.get(index);
    }


    public void changeNote(Integer index, Note note) {
        notebook.set(index, note);

    }

    public Integer getSize(){
        return this.notebook.size();
    }


    public String toString(){
        String string = "Список записей:\n";
        for (int i = 0; i < this.notebook.size(); i++){
            string += i+1 + ". " + this.notebook.get(i) + "\n";
        }
        return string;
    }
}
