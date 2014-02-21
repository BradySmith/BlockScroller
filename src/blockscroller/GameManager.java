/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockscroller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.rmi.registry.Registry;
import java.util.Collection;
import javax.swing.JPanel;

/**
 *
 * @author bradysmith
 */
public class GameManager extends JPanel implements Runnable, KeyListener {

    Game game;
    Player me;
    Collection<Player> players;

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
                System.out.println("up");
                break;
            case KeyEvent.VK_DOWN:
                me.moveDown();
                System.out.println("down");
                break;
            case KeyEvent.VK_LEFT:
                me.moveLeft();
                System.out.println("left");
                break;
            case KeyEvent.VK_RIGHT:
                me.moveRight();
                System.out.println("right");
                break;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (players == null) {} 
        else {
            for (Player p : players) {
                g.setColor(p.getMyColor());
                g.fillOval((int) p.getX(), (int) p.getY(), (int) p.getSize(), (int) p.getSize());
            }
        }
    }

    @Override
    public void run() {
        try {
            this.setBackground(Color.BLACK);
            while (true) {
                game.updatePlayer(me);
                players = game.getPlayers();
                repaint();
            }

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
