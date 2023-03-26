package notebook;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Note {
    private LocalDate date;
    private String note;
    private String comment;

    public Note(LocalDate date, String note, String comment) {
        this.date = date;
        this.note = note;
        this.comment = comment;
    }

    public String getNote(){
        return this.note;
    }

    public String getComment(){
        return this.comment;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formatDate = this.date.format(formatter);
        return String.format("%s| %s %s", formatDate, note, comment);
    }
}
