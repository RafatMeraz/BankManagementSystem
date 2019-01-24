package loginsignup;

import javax.swing.*;
import java.awt.*;
import java.text.Normalizer;

public class UserDashboard extends JFrame {

    private Container container;
    private JPanel menuPanel, screenPanel;
    private JLabel iconLabel, comLabel;

    UserDashboard(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("DashBoard");
        ImageIcon image = new ImageIcon(getClass().getResource("idea.png"));
        setIconImage(image.getImage());
        setBounds(100, 100, 600, 500);
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

        container.add(menuPanel);
    }

    public static void main(String[] args) {
        UserDashboard userDashboard = new UserDashboard();
        userDashboard.setVisible(true);
    }
}
