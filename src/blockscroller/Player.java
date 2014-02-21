/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blockscroller;

import java.awt.Color;
import java.io.Serializable;

/**
 *
 * @author bradysmith
 */
public class Player implements Serializable {
    private Color myColor;
    private float speed;
    private int size;
    private float x;
    private float y;
    
    Player(Color inColor){
        myColor = inColor;
        x = 30;
        y = 400;
        speed = 1.0f;
        size = 5;
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
    public float getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.setX(x);
    }

    /**
     * @return the y
     */
    public float getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.setY(y);
    }

    void moveUp() {
        this.setY(getY() + getSpeed());
    }

    void moveDown() {
        this.setY(getY() - getSpeed());
    }

    void moveLeft() {
        this.setX(getX() - getSpeed());
    }

    void moveRight() {
        this.setX(getX() + getSpeed());
    }

    /**
     * @return the speed
     */
    public float getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @param x the x to set
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * @param y the y to set
     */
    public void setY(float y) {
        this.y = y;
    }
    
}
