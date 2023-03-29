package ui;

import presenter.Presenter;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Console implements View{

    private Presenter presenter;
    private Scanner scanner;
    private Boolean Flag;
    private Menu menu;

    private Validator validator = new Validator();

    public Console() {
        scanner = new Scanner(System.in);
    }


    @Override
    public void setPresenter(Presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void start(){
        menu = new Menu(this);
        Flag = true;
        while (Flag) {
            System.out.println("Выберите действие из списка: ");
            System.out.println(menu.printMenu());
            Integer choice = scanner.nextInt();
            if (validator.checkInput(choice, menu.menuSize())) {
                menu.run(choice);
            } else {
                System.out.println("Необходимо ввести корректные данные");
            }
        }
        }





    public void addNote(){
        ArrayList<String> newNote = new ArrayList<String>();
        System.out.println("\nВведите запись:");
        scanner.nextLine();
        String text = scanner.nextLine();
        newNote.add(text);
        System.out.println("\nВведите комментарий:");
        String comment= scanner.nextLine();
        newNote.add(comment);
        presenter.addNote(newNote);
    }

    public void removeNote(){
        System.out.println("\nКакую запись хотите удалить:");
        Integer indexNote = scanner.nextInt();
        if (validator.checkInput(indexNote, presenter.getNotebookSize())) {
            presenter.removeNote(indexNote - 1);
            System.out.println("Запись была удалена!");
        }
        else {System.out.println("Записи под таким номером не существет");}
        System.out.println();

    }

    public void changeNote(){
        System.out.println("\nКакую запись хотите изменить:");
        Integer indexNote = scanner.nextInt();
        if (validator.checkInput(indexNote, presenter.getNotebookSize())) {
            ArrayList<String> changes = new ArrayList<String>();
            System.out.println("\nХотите изменить заметку? (y/n)");
            scanner.nextLine();
            String answer = scanner.nextLine();
            if (answer.equals("n")) {
                changes.add(getNote(indexNote - 1).get(0));
            } else {
                System.out.println("Введите новую заметку:");
                changes.add(scanner.nextLine());
            }

            System.out.println("\nХотите изменить комментарий? (y/n)");
            String answerCom = scanner.nextLine();
            if (answerCom.equals("n")) {
                changes.add(getNote(indexNote - 1).get(1));
            } else {
                System.out.println("Введите новый комментарий");
                changes.add(scanner.nextLine());
            }

            presenter.changeNote(indexNote - 1, changes);
            System.out.println("Запись была изменена");
        } else
        {System.out.println("Записи под таким номером не существует");}
        System.out.println();
}




    public ArrayList<String> getNote(Integer index){
        ArrayList<String> noteForChange = presenter.getNote(index);
        return noteForChange;
    }

    public void print(){
        System.out.println(presenter.print());
    }

}
