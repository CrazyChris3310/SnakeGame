package com.exec;

import com.controllers.GameController;
import com.view.MainFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            GameController controller = new GameController(mainFrame);
            controller.start();
        });
    }
}
