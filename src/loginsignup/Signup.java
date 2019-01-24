package loginsignup;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Signup extends JFrame {

    private Container container;
    private JPanel logoPanel, textPanel;
    private JLabel imageLogo, comName, signUpLabel;
    private JTextField accTV, dobTF, contactTF, emailTF;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JRadioButton maleButton, femaleButton;
    private ButtonGroup genderButtonGroup;


    Signup(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Sign Up");
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
        imageLogo.setIcon(new ImageIcon(getClass().getResource("litle_idea.png")));
        imageLogo.setBounds(50, 10, 50, 50);
        imageLogo.setSize(new Dimension(50, 50));
        textPanel.add(imageLogo);

        comName = new JLabel("Welcome to ZAD,");
        comName.setFont(new Font("monospace", NORMAL, 20));
        comName.setForeground(Color.BLACK);
        comName.setBounds(50, 55, 200, 40);
        textPanel.add(comName);

        comName = new JLabel("Sign up to enjoy the Banking!");
        comName.setFont(new Font("monospace", NORMAL, 12));
        comName.setForeground(Color.gray);
        comName.setBounds(50, 80, 200, 40);
        textPanel.add(comName);

        comName = new JLabel("New user name");
        comName.setFont(new Font("monospace", Font.BOLD, 12));
        comName.setForeground(Color.GRAY);
        comName.setBounds(50, 120, 200, 40);
        textPanel.add(comName);

        accTV = new JTextField();
        Border textFieldBorder = BorderFactory.createLineBorder(Color.decode("#304FFE"), 2);
        accTV.setBorder(textFieldBorder);
        accTV.setFont(new Font("monospace", NORMAL, 13));
        accTV.setBounds(50, 150, 200, 30);
        textPanel.add(accTV);

        comName = new JLabel("New Password");
        comName.setFont(new Font("monospace", Font.BOLD, 12));
        comName.setForeground(Color.GRAY);
        comName.setBounds(50, 180, 200, 40);
        textPanel.add(comName);

        passwordField = new JPasswordField();
        passwordField.setBorder(textFieldBorder);
        passwordField.setFont(new Font("monospace", NORMAL, 13));
        passwordField.setBounds(50, 210, 200, 30);
        textPanel.add(passwordField);

        comName = new JLabel("Gender");
        comName.setFont(new Font("monospace", Font.BOLD, 12));
        comName.setForeground(Color.GRAY);
        comName.setBounds(50, 240, 200, 40);
        textPanel.add(comName);

        maleButton = new JRadioButton("Male");
        maleButton.setSelected(true);
        maleButton.setBounds(110, 245, 70, 30);
        textPanel.add(maleButton);

        femaleButton = new JRadioButton("Female");
        femaleButton.setSelected(true);
        femaleButton.setBounds(180, 245, 80, 30);
        textPanel.add(femaleButton);

        genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(maleButton);
        genderButtonGroup.add(femaleButton);

        comName = new JLabel("Contact No.");
        comName.setFont(new Font("monospace", Font.BOLD, 12));
        comName.setForeground(Color.GRAY);
        comName.setBounds(50, 270, 200, 40);
        textPanel.add(comName);

        contactTF = new JTextField();
        contactTF.setBorder(textFieldBorder);
        contactTF.setFont(new Font("monospace", NORMAL, 13));
        contactTF.setBounds(50, 300, 200, 30);
        textPanel.add(contactTF);

        comName = new JLabel("E-mail");
        comName.setFont(new Font("monospace", Font.BOLD, 12));
        comName.setForeground(Color.GRAY);
        comName.setBounds(50, 330, 200, 40);
        textPanel.add(comName);

        emailTF = new JTextField();
        emailTF.setBorder(textFieldBorder);
        emailTF.setFont(new Font("monospace", NORMAL, 13));
        emailTF.setBounds(50, 360, 200, 30);
        textPanel.add(emailTF);

        loginButton = new JButton("Signup");
        loginButton.setBackground(Color.decode("#6747CD"));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("roboto", Font.BOLD, 15 ));
        loginButton.setBounds(50, 400, 200, 35);
        textPanel.add(loginButton);

        comName = new JLabel("Already member?");
        comName.setFont(new Font("monospace", Font.BOLD, 12));
        comName.setForeground(Color.GRAY);
        comName.setBounds(60, 440, 130, 20);
        textPanel.add(comName);

        signUpLabel = new JLabel(" Sign in");
        signUpLabel.setBounds(180,440, 130, 20);
        signUpLabel.setForeground(Color.decode("#6747CD"));
        textPanel.add(signUpLabel);

        signUpLabel.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                Login login = new Login();
                login.setVisible(true);
                dispose();
            }
        });

        container.add(logoPanel);
        container.add(textPanel);
    }
}
