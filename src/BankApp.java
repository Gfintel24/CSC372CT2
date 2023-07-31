import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankApp extends JFrame implements ActionListener {
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

        account = new BankAccount(Double.parseDouble(JOptionPane.showInputDialog("Please input your initial bank account balance.")));
        bankBalance = new JLabel(String.format("Your bank account balance is: $%.2f", account.getBalance()));

        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 0;
        layoutConstraints.ipady = 10;
        layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
        layoutConstraints.gridwidth = 2;
        add(bankBalance, layoutConstraints);
        bankBalance.setHorizontalAlignment(SwingConstants.CENTER);
        System.out.println(javax.swing.UIManager.getDefaults().getFont("Label.font"));
        bankBalance.setFont(new Font("Dialog", Font.PLAIN, 20));

    }

    private void buildDepositPanelComponents(){
        depositLabel = new JLabel("PLease enter in the amount you would want to deposit to your account.");
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

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton sourceEvent = (JButton) e.getSource();

        if (sourceEvent == processDeposit){
            account.deposit(Double.parseDouble(depositField.getText()));
            depositField.setText("");
        }
        else if (sourceEvent == processWithdrawal){
            account.withdrawal(Double.parseDouble(withdrawalField.getText()));
            withdrawalField.setText("");
        }

        bankBalance.setText(String.format("Your bank account balance is: $%.2f", account.getBalance()));
    }


}
