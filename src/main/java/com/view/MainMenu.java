package com.view;

import javax.swing.*;
import java.awt.*;


public class MainMenu extends JPanel {

    private MainFrame mainFrame;

    private JButton startBtn;
    private JButton settingsBtn;
    private JButton exitBtn;

    public MainMenu(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800, 600));
        setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        JLabel menuLabel = new JLabel("Main menu", SwingConstants.CENTER);
        menuLabel.setFont(new Font("arial", Font.BOLD, 26));
        menuLabel.setForeground(Color.RED);

        JLabel scoreLbl = new JLabel("Score: 0", SwingConstants.CENTER);
        scoreLbl.setFont(new Font("segoe print", Font.BOLD, 14));
        scoreLbl.setForeground(Color.BLUE);

        startBtn = new JButton("Start");
        settingsBtn = new JButton("Settings");
        exitBtn = new JButton("Exit");

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(5, 1, 50, 20));
        btnPanel.add(menuLabel);
        btnPanel.add(scoreLbl);
        btnPanel.add(startBtn);
        btnPanel.add(settingsBtn);
        btnPanel.add(exitBtn);
        add(btnPanel, "Center");

        exitBtn.addActionListener((event) -> mainFrame.dispose());
        startBtn.addActionListener((event) -> {
            mainFrame.startGame();
        });
    }


}
