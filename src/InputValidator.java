/*
    This class validates a given string parameter on whether it is a non-zero, positive number.
 */

import javax.swing.*;

public class InputValidator {
    private final BankApp app;
    public InputValidator(BankApp application){
        app = application;
    }

    public boolean validateInput(String input){
        boolean result = false;

        try{
            if (Double.parseDouble(input) > 0){
                result = true;
            } else if (Double.parseDouble(input) == 0){
                JOptionPane.showMessageDialog(app, "Please enter a number greater than zero.");
            } else {
                JOptionPane.showMessageDialog(app, "Please enter in only positive numbers.");
            }
        }
        catch (NumberFormatException e){
            JOptionPane.showMessageDialog(app, ("Please enter in only numbers."));
        }

        return result;
    }
}