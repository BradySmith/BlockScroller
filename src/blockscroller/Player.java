/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blockscroller;

import java.awt.Color;

/**
 *
 * @author bradysmith
 */
public class Player {
    private Color myColor;
    private int x;
    private int y;
    
    Player(Color inColor){
        myColor = inColor;
        x = 30;
        y = 400;
    }

    /**
     * @return the myColor
     */
    public Color getMyColor() {
        return myColor;
    }

    /**
     * @param myColor the myColor to set
     */
    public void setMyColor(Color myColor) {
        this.myColor = myColor;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
    
}
