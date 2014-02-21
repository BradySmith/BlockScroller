/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockscroller;

import java.awt.Color;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
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

    @Override
    public synchronized Player join() {
        for (Color nextColor : playableColors) {
            if (!playerList.containsKey(nextColor)) {
                return new Player(nextColor);
            }
        }
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
    public Collection<Player> getPlayers() {
        return this.playerList.values();
    }

}
