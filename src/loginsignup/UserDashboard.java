package loginsignup;

import javax.swing.*;
import java.awt.*;

public class UserDashboard extends JFrame {

    private Container container;
    private JPanel menuPanel, screenPanel;
    private JLabel iconLabel, comLabel;
    private JButton homeButton, withdrawButton, transferButton, editButton, signoutButton;

    UserDashboard(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("DashBoard");
        ImageIcon image = new ImageIcon(getClass().getResource("idea.png"));
        setIconImage(image.getImage());
        setBounds(100, 100, 600, 404);
        setResizable(false);

        initsComponents();
    }

    void initsComponents(){
        container = getContentPane();
        container.setLayout(null);

        menuPanel = new JPanel();
        menuPanel.setLayout(null);
        menuPanel.setBounds(0, 0 , 220, 500);
        menuPanel.setBackground(Color.gray);

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
        menuPanel.add(homeButton);

        withdrawButton = new JButton("WITHDRAW");
        withdrawButton.setBounds(0, 216, 220, 40);
        withdrawButton.setFont(new Font("roboto", Font.BOLD, 14));
        withdrawButton.setForeground(Color.WHITE);
        withdrawButton.setBackground(Color.decode("#424242"));
        withdrawButton.setBorder(null);
        menuPanel.add(withdrawButton);

        transferButton = new JButton("TRANSFER");
        transferButton.setBounds(0, 257, 220, 40);
        transferButton.setFont(new Font("roboto", Font.BOLD, 14));
        transferButton.setForeground(Color.WHITE);
        transferButton.setBackground(Color.decode("#424242"));
        transferButton.setBorder(null);
        menuPanel.add(transferButton);

        editButton = new JButton("EDIT PROFILE");
        editButton.setBounds(0, 298, 220, 40);
        editButton.setFont(new Font("roboto", Font.BOLD, 14));
        editButton.setForeground(Color.WHITE);
        editButton.setBackground(Color.decode("#424242"));
        editButton.setBorder(null);
        menuPanel.add(editButton);

        signoutButton = new JButton("SIGN OUT");
        signoutButton.setBounds(0, 339, 220, 40);
        signoutButton.setFont(new Font("roboto", Font.BOLD, 14));
        signoutButton.setForeground(Color.WHITE);
        signoutButton.setBackground(Color.decode("#424242"));
        signoutButton.setBorder(null);
        menuPanel.add(signoutButton);

        container.add(menuPanel);
    }

    public static void main(String[] args) {
        UserDashboard userDashboard = new UserDashboard();
        userDashboard.setVisible(true);
    }
}
