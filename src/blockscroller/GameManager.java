/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockscroller;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.rmi.registry.Registry;
import javax.swing.JPanel;

/**
 *
 * @author bradysmith
 */
public class GameManager extends JPanel implements Runnable {

    Game game;
    Player me;

    GameManager(Registry registry) {
        try {
            game = (Game) registry.lookup("Game");
            me = game.join();
            new Thread(this).start();
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
        }
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                me.moveUp();
                break;
            case KeyEvent.VK_DOWN:
                me.moveDown();
                break;
            case KeyEvent.VK_LEFT:
                me.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                me.moveRight();
                break;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (me == null) {
            System.out.println("Me is null again");
        } else {
            g.setColor(me.getMyColor());
            g.fillOval((int) me.getX(), (int) me.getY(), (int)me.getSize(), (int)me.getSize());
        }
    }

    @Override
    public void run() {
        this.setBackground(me.getMyColor());
        while (true) {
            if (me == null) {
                System.out.println("error me is null");
            } else {
                me.getX();
                me.getY();
                repaint();
            }
        }
    }

}
