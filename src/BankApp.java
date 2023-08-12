/*
    This class holds all the functionality for building up the application window as well as handling ActionListeners
    for buttons.
 */
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankApp extends JFrame implements ActionListener {
    InputValidator bankTeller = new InputValidator(this);
    String initialBalance;
    BankAccount account;
    JLabel bankBalance;

    JPanel depositPanel;
    JLabel depositLabel = null;
    JTextField depositField = null;
    JButton processDeposit = null;

    JPanel withdrawalPanel;
    JLabel withdrawalLabel = null;
    JTextField withdrawalField = null;
    JButton processWithdrawal = null;

    GridBagConstraints layoutConstraints;
    Border blackLine = BorderFactory.createLineBorder(Color.BLACK);

    BankApp(){
        setTitle("My Bank Account");
        setLayout(new GridBagLayout());
        layoutConstraints = new GridBagConstraints();

        depositPanel = new JPanel();
        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 1;
        layoutConstraints.insets = new Insets(2, 10, 10, 2);
        add(depositPanel, layoutConstraints);
        depositPanel.setLayout(new GridBagLayout());
        depositPanel.setBorder(blackLine);

        buildDepositPanelComponents();

        withdrawalPanel = new JPanel();
        layoutConstraints.gridx = 1;
        layoutConstraints.gridy = 1;
        layoutConstraints.insets = new Insets(2, 2, 10, 10);
        add(withdrawalPanel, layoutConstraints);
        withdrawalPanel.setLayout(new GridBagLayout());
        withdrawalPanel.setBorder(blackLine);

        buildWithdrawalPanelComponents();

        do {
            initialBalance = JOptionPane.showInputDialog("Please input your initial bank account balance.");
        } while (!bankTeller.validateInput(initialBalance));

        account = new BankAccount(Double.parseDouble(initialBalance));
        bankBalance = new JLabel(String.format("Your bank account balance is: $%.2f", account.getBalance()));

        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 0;
        layoutConstraints.ipady = 10;
        layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
        layoutConstraints.gridwidth = 2;
        add(bankBalance, layoutConstraints);
        bankBalance.setHorizontalAlignment(SwingConstants.CENTER);
        bankBalance.setFont(new Font("Dialog", Font.PLAIN, 20));

    }

    //Felt it was better organized to split up the deposit panel and withdrawal panel components into their own methods.
    private void buildDepositPanelComponents(){
        depositLabel = new JLabel("Please enter in the amount you would want to deposit to your account.");
        depositField = new JTextField(6);
        processDeposit = new JButton("Process Deposit");

        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 0;
        layoutConstraints.insets = new Insets(2, 5, 2, 5);
        depositPanel.add(depositLabel, layoutConstraints);

        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 1;
        layoutConstraints.insets = new Insets(2, 5, 2, 5);
        depositPanel.add(depositField, layoutConstraints);

        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 2;
        layoutConstraints.insets = new Insets(2, 5, 2, 5);
        depositPanel.add(processDeposit, layoutConstraints);
        processDeposit.addActionListener(this);
    }

    private void buildWithdrawalPanelComponents(){
        withdrawalLabel = new JLabel("Please enter in the amount you would want to withdraw from your account.");
        withdrawalField = new JTextField(6);
        processWithdrawal = new JButton("Process Withdrawal");

        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 0;
        layoutConstraints.insets = new Insets(2, 5, 2, 5);
        withdrawalPanel.add(withdrawalLabel, layoutConstraints);

        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 1;
        layoutConstraints.insets = new Insets(2, 5, 2, 5);
        withdrawalPanel.add(withdrawalField, layoutConstraints);

        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 2;
        layoutConstraints.insets = new Insets(2, 5, 2, 5);
        withdrawalPanel.add(processWithdrawal, layoutConstraints);
        processWithdrawal.addActionListener(this);
    }

    // Contains the actions performed based on which button is pressed. Also contains validation for textField input.
    @Override
    public void actionPerformed(ActionEvent e) {
        InputValidator bankTeller = new InputValidator(this);
        JButton sourceEvent = (JButton) e.getSource();

        if (sourceEvent == processDeposit && bankTeller.validateInput(depositField.getText())){
            account.deposit(Double.parseDouble(depositField.getText()));
            depositField.setText("");
        }
        else if (sourceEvent == processWithdrawal && bankTeller.validateInput(withdrawalField.getText())){
            account.withdrawal(Double.parseDouble(withdrawalField.getText()));
            withdrawalField.setText("");
        }

        bankBalance.setText(String.format("Your bank account balance is: $%.2f", account.getBalance()));
    }
}
