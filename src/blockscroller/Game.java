/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockscroller;

import java.awt.Color;
import java.rmi.Remote;

/**
 *
 * @author dylan
 */
public interface Game extends Remote {

    Player join();

    void leave(Player p);
}
