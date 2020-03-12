package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Window { //graphical stuff
    JFrame frame;
    JButton play,quit,QG;

    JLabel label;

    public Window(int width,int height,String title,Game game){

         frame = new JFrame(title);
        menu(game);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
       frame.add(game);

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);// box is in center
        frame.setVisible(true);

    }
    public void restart(){
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void menu(Game game) {
        play = new JButton("Play");
        play.setBounds(440,200,140, 40);
        frame.add(play);
        quit = new JButton("Quit");
        quit.setBounds(440,250,140, 40);
        frame.add(quit);
         label = new JLabel("Mafia Mania");
        label.setBounds(440, 100, 100, 100);
        frame.add(label);
        //////////////////////////////////////////////////////the pause menu below
        QG = new JButton("Quit Game");
        QG.setBounds(440,200,140, 40);
        QG.setVisible(false);
        frame.add(QG);
        frame.validate();
        /////////////////////////////////////////////////////
        play.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
               game.start();
               boolean done = false;

                   quit.setVisible(false);
                   play.setVisible(false);
                   label.setVisible(false);
                   frame.validate();


            }
        });
        quit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        QG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                restart();
            }
        });
    }
    public void psmenu(Game game){

        QG.setVisible(!QG.isVisible());
        frame.validate();
    }

}

