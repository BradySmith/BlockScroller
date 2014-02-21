/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockscroller;

/**
 *
 * @author dylan
 */
import java.awt.Color;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JFrame;

public class Client {

    private Client() {
    }

    public static void main(String[] args) {

        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            GameManager game = new GameManager(registry);

            JFrame frame = new JFrame("BlockScroller");
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            game.addKeyListener(game);
            game.setFocusable(true);
            frame.add(game);
            frame.setVisible(true);



        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
