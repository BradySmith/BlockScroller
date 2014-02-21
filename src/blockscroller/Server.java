/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockscroller;

import java.awt.Color;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author dylan
 */
public class Server implements Game {

    final int MAX_PLAYERS = 4;
    ConcurrentHashMap<Color, Player> playerList = new ConcurrentHashMap<>(MAX_PLAYERS);
    final Color[] playableColors = new Color[]{Color.RED, Color.GREEN, Color.ORANGE, Color.BLUE};
    public Enemy enemy = new Enemy(Color.WHITE);

    public static void main(String args[]) {

        try {
            Server obj = new Server();
            Game game = (Game) UnicastRemoteObject.exportObject(obj, 0);
            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Game", game);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

    public Server() {
        new Thread(this.enemy).start();
    }

    @Override
    public synchronized Player join() {
        for (Color nextColor : playableColors) {
            if (!playerList.containsKey(nextColor)) {

                Player p = new Player(nextColor);
                playerList.put(nextColor, p);
                System.out.println("Player connected: " + p.getMyColor());
                return p;
            }
        }
        System.out.println("out of colors!");
        return null;
    }

    @Override
    public synchronized void leave(Player p) {
        this.playerList.remove(p.getMyColor());
    }

    @Override
    public synchronized void updatePlayer(Player p) {
        this.playerList.put(p.getMyColor(), p);
    }

    @Override
    public ArrayList<Player> getPlayers() {
        return new ArrayList(this.playerList.values());
    }

    @Override
    public Enemy getEnemy() throws RemoteException {
        return enemy;
    }

}
