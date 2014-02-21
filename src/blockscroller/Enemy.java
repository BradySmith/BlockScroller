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

    Random rng = new Random();

    public Enemy(Color inColor) {
        super(inColor);
        this.setX(0);
        this.setY(rng.nextInt(600));
        this.setSpeed(0.00001f);
    }

    @Override
    public void run() {
        while (true) {
            if (!this.moveRight()) {
                this.setX(0);
                this.setY(rng.nextInt(600));
                System.out.println("Enemy died");
            }
        }
    }

}
