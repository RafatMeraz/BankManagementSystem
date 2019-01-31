package loginsignup;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UserDashboard extends JFrame implements ActionListener {

    //database Connection
    Connection connect = SqliteConnection.dbConnector();
    Statement statement;
    PreparedStatement ps;

    //Queries for database
    {
        try {
            statement = connect.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int acc_num ;
    private User user;
    private Container container;
    private JPanel menuPanel, screenPanel, homePanel, withdrawPanel, transferPanel, editPanel;
    private JLabel iconLabel, comLabel, userNameLabel, userEmailLabel, dobLabel, contactLabel, accNumberLabel, totalBalaceLabel;
    private JButton homeButton, withdrawButton, transferButton, editButton, signoutButton, resetButton, cashWithButton,
                    transferResetButton, transferMoneyButton;
    private JTextField amountOfBalanceTF, bankAcountNumberTF, transferAmountOfMoneyTF;
    private JPasswordField passwordTF, transferPassField;

    UserDashboard(User user) throws SQLException {
        this.user = user;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("DashBoard");
        ImageIcon image = new ImageIcon(getClass().getResource("idea.png"));
        setIconImage(image.getImage());
        setBounds(100, 100, 600, 404);
        setResizable(false);

        initsComponents();
    }

    void initsComponents() throws SQLException {
        container = getContentPane();
        container.setLayout(null);

        menuPanel = new JPanel();
        menuPanel.setLayout(null);
        menuPanel.setBounds(0, 0 , 220, 500);
        menuPanel.setBackground(Color.gray);

        screenPanel = new JPanel();
        screenPanel.setLayout(new CardLayout());
        screenPanel.setBounds(220, 0, 380, 500);

        iconLabel = new JLabel();
        iconLabel.setIcon(new ImageIcon(getClass().getResource("idea_gey.png")));
        iconLabel.setBounds(70, 10, 100, 100);
        menuPanel.add(iconLabel);

        comLabel = new JLabel("ZAD");
        comLabel.setFont(new Font("monospace", Font.BOLD, 20));
        comLabel.setBounds(80, 70, 100, 100);
        comLabel.setForeground(Color.WHITE);
        menuPanel.add(comLabel);

        comLabel = new JLabel("Enjoy your banking!");
        comLabel.setFont(new Font("monospace", NORMAL, 13));
        comLabel.setBounds(50, 90, 150, 100);
        comLabel.setForeground(Color.WHITE);
        menuPanel.add(comLabel);

        homeButton = new JButton("HOME");
        homeButton.setBounds(0, 175, 220, 40);
        homeButton.setFont(new Font("roboto", Font.BOLD, 14));
        homeButton.setForeground(Color.WHITE);
        homeButton.setBackground(Color.decode("#424242"));
        homeButton.setBorder(null);
        homeButton.addActionListener(this);
        menuPanel.add(homeButton);

        withdrawButton = new JButton("WITHDRAW");
        withdrawButton.setBounds(0, 216, 220, 40);
        withdrawButton.setFont(new Font("roboto", Font.BOLD, 14));
        withdrawButton.setForeground(Color.WHITE);
        withdrawButton.setBackground(Color.decode("#424242"));
        withdrawButton.setBorder(null);
        withdrawButton.addActionListener(this);
        menuPanel.add(withdrawButton);

        transferButton = new JButton("TRANSFER");
        transferButton.setBounds(0, 257, 220, 40);
        transferButton.setFont(new Font("roboto", Font.BOLD, 14));
        transferButton.setForeground(Color.WHITE);
        transferButton.setBackground(Color.decode("#424242"));
        transferButton.setBorder(null);
        transferButton.addActionListener(this);
        menuPanel.add(transferButton);

        editButton = new JButton("EDIT PROFILE");
        editButton.setBounds(0, 298, 220, 40);
        editButton.setFont(new Font("roboto", Font.BOLD, 14));
        editButton.setForeground(Color.WHITE);
        editButton.setBackground(Color.decode("#424242"));
        editButton.setBorder(null);
        editButton.addActionListener(this);
        menuPanel.add(editButton);

        signoutButton = new JButton("SIGN OUT");
        signoutButton.setBounds(0, 339, 220, 40);
        signoutButton.setFont(new Font("roboto", Font.BOLD, 14));
        signoutButton.setForeground(Color.WHITE);
        signoutButton.setBackground(Color.decode("#424242"));
        signoutButton.setBorder(null);
        signoutButton.addActionListener(this);
        menuPanel.add(signoutButton);


        //Panels for different layout
        homePanel = new JPanel();
        homePanel.setBounds(0, 0 , 380, 500);
        homePanel.setLayout(null);

        //withdraw Panel
        withdrawPanel = new JPanel();
        withdrawPanel.setLayout(null);
        withdrawPanel.setBounds(0, 0 , 380, 500);

        comLabel = new JLabel();
        comLabel.setIcon(new ImageIcon(getClass().getResource("idea_gey.png")));
        comLabel.setBounds(50, 10, 200, 200);
        comLabel.setSize(new Dimension(100, 100));
        withdrawPanel.add(comLabel);

        comLabel = new JLabel("Withdraw your money");
        comLabel.setFont(new Font("monospace", NORMAL, 15));
        comLabel.setForeground(Color.BLACK);
        comLabel.setBounds(50, 100, 200, 40);
        withdrawPanel.add(comLabel);

        comLabel = new JLabel("AMOUNT OF BALANCE :");
        comLabel.setFont(new Font("monospace", Font.BOLD, 12));
        comLabel.setForeground(Color.GRAY);
        comLabel.setBounds(50, 140, 250, 40);
        withdrawPanel.add(comLabel);

        Border textFieldBorder = BorderFactory.createLineBorder(Color.GRAY, 2);

        amountOfBalanceTF = new JTextField();
        amountOfBalanceTF.setBorder(textFieldBorder);
        amountOfBalanceTF.setFont(new Font("monospace", NORMAL, 13));
        amountOfBalanceTF.setBounds(50, 175, 250, 30);
        withdrawPanel.add(amountOfBalanceTF);

        comLabel = new JLabel("PASSWORD :");
        comLabel.setFont(new Font("monospace", Font.BOLD, 12));
        comLabel.setForeground(Color.GRAY);
        comLabel.setBounds(50, 205, 250, 40);
        withdrawPanel.add(comLabel);

        passwordTF = new JPasswordField();
        passwordTF.setBorder(textFieldBorder);
        passwordTF.setFont(new Font("monospace", NORMAL, 13));
        passwordTF.setBounds(50, 240, 250, 30);
        withdrawPanel.add(passwordTF);

        resetButton = new JButton("RESET");
        resetButton.setForeground(Color.white);
        resetButton.setBackground(Color.GRAY);
        resetButton.setBounds(50, 290, 100, 30);
        resetButton.addActionListener(this);
        withdrawPanel.add(resetButton);

        cashWithButton = new JButton("WITHDRAW");
        cashWithButton.setForeground(Color.white);
        cashWithButton.setBackground(Color.GRAY);
        cashWithButton.setBounds(180, 290, 120, 30);
        cashWithButton.addActionListener(this);
        withdrawPanel.add(cashWithButton);

        //Transfer your Balance Panel

        //Edit profile panel

        editPanel = new JPanel();
        editPanel.setBounds(0, 0 , 380, 500);
        editPanel.setLayout(null);

        iconLabel = new JLabel();
        iconLabel.setIcon(new ImageIcon(getClass().getResource("user.png")));
        iconLabel.setBounds(130, 10, 130, 130);
        editPanel.add(iconLabel);

        comLabel = new JLabel("Full Name: ");
        comLabel.setFont(new Font("monospace", Font.BOLD, 12));
        comLabel.setForeground(Color.GRAY);
        comLabel.setBounds(50, 150, 250, 40);
        editPanel.add(comLabel);

        userNameLabel = new JLabel("Dummy Name");
        userNameLabel.setFont(new Font("monospace", NORMAL, 13));
        userNameLabel.setForeground(Color.GRAY);
        userNameLabel.setBounds(170, 150, 350, 40);
        editPanel.add(userNameLabel);

        comLabel = new JLabel("Account No. : ");
        comLabel.setFont(new Font("monospace", Font.BOLD, 12));
        comLabel.setForeground(Color.GRAY);
        comLabel.setBounds(50, 180, 250, 40);
        editPanel.add(comLabel);

        accNumberLabel = new JLabel("Dummy email");
        accNumberLabel.setFont(new Font("monospace", NORMAL, 13));
        accNumberLabel.setForeground(Color.GRAY);
        accNumberLabel.setBounds(170, 180, 350, 40);
        editPanel.add(accNumberLabel);

        comLabel = new JLabel("Date Of Birth: ");
        comLabel.setFont(new Font("monospace", Font.BOLD, 12));
        comLabel.setForeground(Color.GRAY);
        comLabel.setBounds(50, 210, 250, 40);
        editPanel.add(comLabel);

        dobLabel = new JLabel("Dummy Date");
        dobLabel.setFont(new Font("monospace", NORMAL, 13));
        dobLabel.setForeground(Color.GRAY);
        dobLabel.setBounds(170, 210, 350, 40);
        editPanel.add(dobLabel);

        comLabel = new JLabel("Email : ");
        comLabel.setFont(new Font("monospace", Font.BOLD, 12));
        comLabel.setForeground(Color.GRAY);
        comLabel.setBounds(50, 240, 250, 40);
        editPanel.add(comLabel);

        userEmailLabel = new JLabel("Dummy email");
        userEmailLabel.setFont(new Font("monospace", NORMAL, 13));
        userEmailLabel.setForeground(Color.GRAY);
        userEmailLabel.setBounds(170, 240, 350, 40);
        editPanel.add(userEmailLabel);

        comLabel = new JLabel("Contact : ");
        comLabel.setFont(new Font("monospace", Font.BOLD, 12));
        comLabel.setForeground(Color.GRAY);
        comLabel.setBounds(50, 270, 250, 40);
        editPanel.add(comLabel);

        contactLabel = new JLabel("0154445454");
        contactLabel.setFont(new Font("monospace", NORMAL, 13));
        contactLabel.setForeground(Color.GRAY);
        contactLabel.setBounds(170, 270, 350, 40);
        editPanel.add(contactLabel);



        screenPanel.add(HomePanel());
        container.add(screenPanel);
        container.add(menuPanel);
    }


    //Action Listener methods

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signoutButton){
            try {
                connect.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            this.dispose();
            new Login().setVisible(true);
        } else if (e.getSource() == homeButton){

            try {
                screenPanel.removeAll();
                screenPanel.add(HomePanel());
                screenPanel.repaint();
                screenPanel.revalidate();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        } else if (e.getSource() == withdrawButton){
            screenPanel.removeAll();
            screenPanel.add(withdrawPanel);
            screenPanel.repaint();
            screenPanel.revalidate();
        } else if (e.getSource() == resetButton){
            amountOfBalanceTF.setText("");
            passwordTF.setText("");
        } else if(e.getSource() == cashWithButton){
            try {
                ResultSet rs = statement.executeQuery("SELECT * FROM bank WHERE acc_number="+user.getAccountNumber());
                if (passwordTF.getText().equals(rs.getString("password"))){
                    while (rs.next()){
                        int amount = Integer.parseInt(amountOfBalanceTF.getText());
                        int current_balance = rs.getInt("balance");
                        System.out.println(current_balance);
                        if (current_balance>=amount){
                            current_balance = current_balance-amount;
                            String sql = "UPDATE bank " +
                                    "SET balance = "+current_balance+" WHERE acc_number = "+user.getAccountNumber();
                            statement.executeUpdate(sql);

                            JOptionPane.showMessageDialog(null, "Withdraw Successful!");
                            amountOfBalanceTF.setText("");
                            passwordTF.setText("");

                        } else {
                            JOptionPane.showMessageDialog(null, "Your current balance is "+current_balance);
                        }
                        System.out.println(current_balance);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Password is incorrect");
                    passwordTF.setText("");
                }

            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        } else if (e.getSource() == transferButton){
            screenPanel.removeAll();
            try {
                screenPanel.add(transferPanel());
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            screenPanel.repaint();
            screenPanel.revalidate();

        } else if (e.getSource() == transferResetButton){
            transferAmountOfMoneyTF.setText("");
            bankAcountNumberTF.setText("");
            transferPassField.setText("");
        } else if (e.getSource() == transferMoneyButton){

            int transferAccNum = Integer.parseInt(bankAcountNumberTF.getText());
            int transferAmount = Integer.parseInt(transferAmountOfMoneyTF.getText());
            String transferPass = transferPassField.getText();

            try {
                ResultSet rs = statement.executeQuery("SELECT * FROM bank WHERE acc_number="+user.getAccountNumber());
                ResultSet tRs = statement.executeQuery("SELECT *FROM bank WHERE acc_number="+transferAccNum);
                while (rs.next()){
                    String userPass = rs.getString("password");
                    int currentBalance = rs.getInt("balance");
                    if (transferPassField.getText().equals(user.getPassword())){
                        if (currentBalance >= transferAmount) {
                            while (tRs.next()) {
                                int tCurrentBalance = tRs.getInt("balance");
                                String sql = "UPDATE bank " +
                                        "SET balance = " + (tCurrentBalance + transferAmount) + " WHERE acc_number = " + transferAccNum;
                                statement.executeUpdate(sql);
                            }
                            String sql = "UPDATE bank " +
                                    "SET balance = " + (currentBalance - transferAmount) + " WHERE acc_number = " + user.getAccountNumber();
                            statement.executeUpdate(sql);
                        } else {
                            JOptionPane.showMessageDialog(null, "Your current balance is "+currentBalance);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Password incorrect");
                        transferPassField.setText("");
                    }
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }


        } else if (e.getSource() == editButton){
            screenPanel.removeAll();
            screenPanel.add(editPanel);
            screenPanel.repaint();
            screenPanel.revalidate();
        }
    }

    public JPanel HomePanel() throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM bank WHERE acc_number="+user.getAccountNumber());

        iconLabel = new JLabel();
        iconLabel.setIcon(new ImageIcon(getClass().getResource("user.png")));
        iconLabel.setBounds(130, 10, 130, 130);
        homePanel.add(iconLabel);

        comLabel = new JLabel("Full Name: ");
        comLabel.setFont(new Font("monospace", Font.BOLD, 12));
        comLabel.setForeground(Color.GRAY);
        comLabel.setBounds(50, 150, 250, 40);
        homePanel.add(comLabel);

        userNameLabel = new JLabel(rs.getString("name"));
        userNameLabel.setFont(new Font("monospace", NORMAL, 13));
        userNameLabel.setForeground(Color.GRAY);
        userNameLabel.setBounds(170, 150, 350, 40);
        homePanel.add(userNameLabel);

        comLabel = new JLabel("Account No. : ");
        comLabel.setFont(new Font("monospace", Font.BOLD, 12));
        comLabel.setForeground(Color.GRAY);
        comLabel.setBounds(50, 180, 250, 40);
        homePanel.add(comLabel);

        accNumberLabel = new JLabel(rs.getString("acc_number"));
        accNumberLabel.setFont(new Font("monospace", NORMAL, 13));
        accNumberLabel.setForeground(Color.GRAY);
        accNumberLabel.setBounds(170, 180, 350, 40);
        homePanel.add(accNumberLabel);

        comLabel = new JLabel("Date Of Birth: ");
        comLabel.setFont(new Font("monospace", Font.BOLD, 12));
        comLabel.setForeground(Color.GRAY);
        comLabel.setBounds(50, 210, 250, 40);
        homePanel.add(comLabel);

        dobLabel = new JLabel(rs.getString("dob"));
        dobLabel.setFont(new Font("monospace", NORMAL, 13));
        dobLabel.setForeground(Color.GRAY);
        dobLabel.setBounds(170, 210, 350, 40);
        homePanel.add(dobLabel);

        comLabel = new JLabel("Email : ");
        comLabel.setFont(new Font("monospace", Font.BOLD, 12));
        comLabel.setForeground(Color.GRAY);
        comLabel.setBounds(50, 240, 250, 40);
        homePanel.add(comLabel);

        userEmailLabel = new JLabel(rs.getString("email"));
        userEmailLabel.setFont(new Font("monospace", NORMAL, 13));
        userEmailLabel.setForeground(Color.GRAY);
        userEmailLabel.setBounds(170, 240, 350, 40);
        homePanel.add(userEmailLabel);

        comLabel = new JLabel("Contact : ");
        comLabel.setFont(new Font("monospace", Font.BOLD, 12));
        comLabel.setForeground(Color.GRAY);
        comLabel.setBounds(50, 270, 250, 40);
        homePanel.add(comLabel);

        contactLabel = new JLabel(rs.getString("contact"));
        contactLabel.setFont(new Font("monospace", NORMAL, 13));
        contactLabel.setForeground(Color.GRAY);
        contactLabel.setBounds(170, 270, 350, 40);
        homePanel.add(contactLabel);

        comLabel = new JLabel("Total Balance : ");
        comLabel.setFont(new Font("monospace", Font.BOLD, 12));
        comLabel.setForeground(Color.GRAY);
        comLabel.setBounds(50, 300, 250, 40);
        homePanel.add(comLabel);

        contactLabel = new JLabel(rs.getString("balance")+"$");
        contactLabel.setFont(new Font("monospace", NORMAL, 13));
        contactLabel.setForeground(Color.GRAY);
        contactLabel.setBounds(170, 300, 350, 40);
        homePanel.add(contactLabel);

        return homePanel;
    }

    public JPanel transferPanel() throws SQLException{



        Border textFieldBorder = BorderFactory.createLineBorder(Color.GRAY, 2);

        transferPanel = new JPanel();
        transferPanel.setLayout(null);
        transferPanel.setBounds(0,0, 380, 500);

        comLabel = new JLabel();
        comLabel.setIcon(new ImageIcon(getClass().getResource("idea_gey.png")));
        comLabel.setBounds(50, 10, 200, 200);
        comLabel.setSize(new Dimension(100, 100));
        transferPanel.add(comLabel);

        comLabel = new JLabel("Transfer your money");
        comLabel.setFont(new Font("monospace", NORMAL, 15));
        comLabel.setForeground(Color.BLACK);
        comLabel.setBounds(50, 100, 200, 40);
        transferPanel.add(comLabel);

        comLabel = new JLabel("ACCOUNT NO. :");
        comLabel.setFont(new Font("monospace", Font.BOLD, 12));
        comLabel.setForeground(Color.GRAY);
        comLabel.setBounds(50, 130, 250, 40);
        transferPanel.add(comLabel);

        bankAcountNumberTF = new JTextField();
        bankAcountNumberTF.setBorder(textFieldBorder);
        bankAcountNumberTF.setFont(new Font("monospace", NORMAL, 13));
        bankAcountNumberTF.setBounds(50, 160, 250, 30);
        transferPanel.add(bankAcountNumberTF);

        comLabel = new JLabel("AMOUNT OF BALANCE :");
        comLabel.setFont(new Font("monospace", Font.BOLD, 12));
        comLabel.setForeground(Color.GRAY);
        comLabel.setBounds(50, 190, 250, 40);
        transferPanel.add(comLabel);

        transferAmountOfMoneyTF = new JTextField();
        transferAmountOfMoneyTF.setBorder(textFieldBorder);
        transferAmountOfMoneyTF.setFont(new Font("monospace", NORMAL, 13));
        transferAmountOfMoneyTF.setBounds(50, 220, 250, 30);
        transferPanel.add(transferAmountOfMoneyTF);

        comLabel = new JLabel("PASSWORD :");
        comLabel.setFont(new Font("monospace", Font.BOLD, 12));
        comLabel.setForeground(Color.GRAY);
        comLabel.setBounds(50, 250, 250, 40);
        transferPanel.add(comLabel);

        transferPassField = new JPasswordField();
        transferPassField.setBorder(textFieldBorder);
        transferPassField.setFont(new Font("monospace", NORMAL, 13));
        transferPassField.setBounds(50, 280, 250, 30);
        transferPanel.add(transferPassField);

        transferResetButton = new JButton("RESET");
        transferResetButton.setForeground(Color.white);
        transferResetButton.setBackground(Color.GRAY);
        transferResetButton.setBounds(50, 320, 100, 30);
        transferResetButton.addActionListener(this);
        transferPanel.add(transferResetButton);

        transferMoneyButton = new JButton("TRANSFER");
        transferMoneyButton.setForeground(Color.white);
        transferMoneyButton.setBackground(Color.GRAY);
        transferMoneyButton.setBounds(180, 320, 120, 30);
        transferMoneyButton.addActionListener(this);
        transferPanel.add(transferMoneyButton);

        return transferPanel;
    }
}

