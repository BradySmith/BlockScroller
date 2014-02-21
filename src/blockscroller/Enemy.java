/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockscroller;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author bradysmith
 */
public class Enemy extends Player implements Runnable {

    public Enemy(Color inColor) {
        super(inColor);
    }

    @Override
    public void run() {
        Random rng = new Random();
        while (true) {
            int num = rng.nextInt(4);
            switch (num) {
                case 0:
                    this.moveDown();
                    break;
                case 1:
                    this.moveUp();
                    break;
                case 2:
                    this.moveLeft();
                    break;
                case 3:
                    this.moveRight();
                    break;
            }
        }
    }

}
