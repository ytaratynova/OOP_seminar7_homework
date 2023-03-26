package ui;

public class Validator {
    public Boolean checkInput(Integer userChoice, int size) {
        try {
            if (userChoice >= 1 && userChoice <= size) {
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return false;
    }
}
