/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockscroller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

/**
 *
 * @author dylan
 */
public interface Game extends Remote {

    Player join() throws RemoteException;

    void leave(Player p) throws RemoteException;

    void updatePlayer(Player p);

    Collection<Player> getPlayers();
}
