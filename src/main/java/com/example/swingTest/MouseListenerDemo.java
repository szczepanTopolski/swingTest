package com.example.swingTest;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseListenerDemo {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public MouseListenerDemo(){
        prepareGUI();
    }
    public static void main(String[] args){
        MouseListenerDemo swingListenerDemo = new MouseListenerDemo();
        swingListenerDemo.showMouseListenerDemo();
    }
    private void prepareGUI(){
        mainFrame = new JFrame("Java SWING Examples");
        mainFrame.setSize(400,400);
        mainFrame.setLayout(new GridLayout(3, 1));

        headerLabel = new JLabel("",JLabel.CENTER );
        statusLabel = new JLabel("",JLabel.CENTER);
        statusLabel.setSize(350,100);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }
    private void showMouseListenerDemo(){
        headerLabel.setText("Listener in action: MouseListener");

        JPanel panel = new JPanel();
        panel.setBackground(Color.magenta);
        panel.setLayout(new FlowLayout());
        panel.addMouseListener(new CustomMouseListener());

        JLabel msglabel =
                new JLabel("Welcome to TutorialsPoint SWING Tutorial.",JLabel.CENTER);
        panel.add(msglabel);

        msglabel.addMouseListener(new CustomMouseListener());
        panel.add(msglabel);

        controlPanel.add(panel);
        mainFrame.setVisible(true);
    }
    class CustomMouseListener implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            statusLabel.setText("Mouse Clicked: ("+e.getX()+", "+e.getY() +")");
        }
        public void mousePressed(MouseEvent e) {
            statusLabel.setText("Mouse Pressed: ("+e.getX()+", "+e.getY() +")");
        }
        public void mouseReleased(MouseEvent e) {
            statusLabel.setText("Mouse Released: ("+e.getX()+", "+e.getY() +")");
        }
        public void mouseEntered(MouseEvent e) {
            statusLabel.setText("Mouse Entered: ("+e.getX()+", "+e.getY() +")");
        }
        public void mouseExited(MouseEvent e) {
            statusLabel.setText("Mouse Existed: ("+e.getX()+", "+e.getY() +")");
        }
    }
}
