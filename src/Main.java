import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main (String[] args) {
        BankApp app = new BankApp();

        app.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                JOptionPane.showMessageDialog(app, String.format("Your final account balance is: $%.2f", app.account.getBalance()));
            }
        });

        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        app.pack();
        app.setVisible(true);
    }

}
