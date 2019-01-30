package loginsignup;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login extends JFrame {

    //database Connection
    Connection connect = SqliteConnection.dbConnector();
    Statement statement;

    //Queries for database
    {
        try {
            statement = connect.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Container container;
    private JPanel logoPanel, textPanel;
    private JLabel imageLogo, comName, signUpLabel;
    private JTextField accTV;
    private JPasswordField passwordField;
    private JButton loginButton;


    Login(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Login");
        ImageIcon image = new ImageIcon(getClass().getResource("idea.png"));
        setIconImage(image.getImage());
        setBounds(100, 100, 600, 500);
        setResizable(false);

        initsComponents();
    }

    void initsComponents(){
        container = this.getContentPane();
        container.setLayout(null);

        logoPanel = new JPanel();
        logoPanel.setLayout(null);
        logoPanel.setBounds(0, 0, 300, 500);
        logoPanel.setBackground(Color.decode("#6747CD"));

        imageLogo = new JLabel();
        imageLogo.setIcon(new ImageIcon(getClass().getResource("idea.png")));
        imageLogo.setBounds(90, 120, 200, 200);
        imageLogo.setSize(new Dimension(120, 120));
        logoPanel.add(imageLogo);

        comName = new JLabel("WELCOME TO");
        comName.setFont(new Font("monospace", Font.BOLD, 12));
        comName.setForeground(Color.WHITE);
        comName.setBounds(102, 250, 200, 40);
        logoPanel.add(comName);

        comName = new JLabel("ZAD");
        comName.setFont(new Font("monospace", Font.BOLD, 25));
        comName.setForeground(Color.WHITE);
        comName.setBounds(120, 275, 200, 40);
        logoPanel.add(comName);

        textPanel = new JPanel();
        textPanel.setLayout(null);
        textPanel.setBounds(300, 0, 300, 500);

        imageLogo = new JLabel();
        imageLogo.setIcon(new ImageIcon(getClass().getResource("idea_gey.png")));
        imageLogo.setBounds(50, 10, 200, 200);
        imageLogo.setSize(new Dimension(100, 100));
        textPanel.add(imageLogo);

        comName = new JLabel("Welcome Back,");
        comName.setFont(new Font("monospace", NORMAL, 20));
        comName.setForeground(Color.BLACK);
        comName.setBounds(50, 100, 200, 40);
        textPanel.add(comName);

        comName = new JLabel("Sign in to continue");
        comName.setFont(new Font("monospace", NORMAL, 12));
        comName.setForeground(Color.gray);
        comName.setBounds(50, 125, 200, 40);
        textPanel.add(comName);

        comName = new JLabel("Account Number");
        comName.setFont(new Font("monospace", Font.BOLD, 12));
        comName.setForeground(Color.GRAY);
        comName.setBounds(50, 180, 200, 40);
        textPanel.add(comName);

        accTV = new JTextField();
        Border textFieldBorder = BorderFactory.createLineBorder(Color.decode("#304FFE"), 2);
        accTV.setBorder(textFieldBorder);
        accTV.setFont(new Font("monospace", NORMAL, 13));
        accTV.setBounds(50, 215, 200, 30);
        textPanel.add(accTV);

        comName = new JLabel("Password");
        comName.setFont(new Font("monospace", Font.BOLD, 12));
        comName.setForeground(Color.GRAY);
        comName.setBounds(50, 250, 200, 40);
        textPanel.add(comName);

        passwordField = new JPasswordField();
        passwordField.setBorder(textFieldBorder);
        passwordField.setFont(new Font("monospace", NORMAL, 13));
        passwordField.setBounds(50, 285, 200, 30);
        textPanel.add(passwordField);

        loginButton = new JButton("Sign in");
        loginButton.setBackground(Color.decode("#6747CD"));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("roboto", Font.BOLD, 15 ));
        loginButton.setBounds(50, 350, 200, 40);
        textPanel.add(loginButton);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("clicked");
                int userID = Integer.parseInt(accTV.getText().trim());
                String userPass = passwordField.getText();
                try {
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM bank WHERE acc_number="+userID+" AND password='"+userPass+"';");
                    while (resultSet.next()){
                        User user ;
                        int accountNumber = resultSet.getInt("acc_number");
                        int contact = resultSet.getInt(5);
                        int balance = resultSet.getInt(6);
                        String name = resultSet.getString(2);
                        String dob = resultSet.getString(3);
                        String email = resultSet.getString(4);
                        String pass = resultSet.getString(7);
                        dispose();
                        new UserDashboard(new User(accountNumber, name, pass, dob, balance, contact, email)).setVisible(true);
                    }
                } catch (SQLException e1) {
                    passwordField.setText("");
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "UserName/Password Incorrect\nPlease Try Again");
                }

            }
        });

        comName = new JLabel("New User?");
        comName.setFont(new Font("monospace", Font.BOLD, 12));
        comName.setForeground(Color.GRAY);
        comName.setBounds(85, 400, 80, 20);
        textPanel.add(comName);

        signUpLabel = new JLabel(" Signup");
        signUpLabel.setBounds(160,400, 130, 20);
        signUpLabel.setForeground(Color.decode("#6747CD"));
        textPanel.add(signUpLabel);

        signUpLabel.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                Signup s = new Signup();
                s.setVisible(true);
                dispose();
            }
        });

        container.add(logoPanel);
        container.add(textPanel);
    }

    public static void main(String[] args) {
        Login login = new Login();
        login.setVisible(true);
    }
}
