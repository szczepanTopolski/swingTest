package com.example.swingTest;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class KeyEventDemo implements KeyListener {

    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JLabel msglabel;

    public KeyEventDemo(){
        prepareGUI();
    }

    static public void main(String args[]) {
        KeyEventDemo swingContainerDemo = new KeyEventDemo();
        swingContainerDemo.showKeyEventDemo();
    }

    private void prepareGUI(){
        mainFrame = new JFrame("Java Swing Examples");
        mainFrame.setSize(400,400);
        mainFrame.setLayout(new GridLayout(3, 1));

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("",JLabel.CENTER);
        statusLabel.setSize(350,100);

        msglabel = new JLabel("Press any button.", JLabel.CENTER);

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);

        mainFrame.addKeyListener(this); //Event listener

        mainFrame.setVisible(true);


    }

    private void showKeyEventDemo(){
        headerLabel.setText("Container in action: KeyEvent");
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(new FlowLayout());
        panel.add(msglabel);
        controlPanel.add(panel);
        mainFrame.setVisible(true);
    }
    @Override
    public void keyTyped(KeyEvent e) {
        msglabel.setText("keyTyped: "+e.getKeyCode()+", "+e.getKeyChar()+", "+e.getExtendedKeyCode());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        msglabel.setText("keyPressed: "+e.getKeyCode()+", "+e.getKeyChar()+", "+e.getExtendedKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        msglabel.setText("keyReleased: "+e.getKeyCode()+", "+e.getKeyChar()+", "+e.getExtendedKeyCode());
    }

}