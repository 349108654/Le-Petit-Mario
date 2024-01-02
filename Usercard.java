/**
 * [Usercard.java]
 *
 * @author: Jillian and Ellie
 * @version: June 2022
 */
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JProgressBar;
import javax.swing.JFrame;

public class Usercard {

    Player player;
    CharacterDemo gameArea;
    final int U_WIDTH = 200;

    Usercard(CharacterDemo parentArea, Player player) {
        this.gameArea = parentArea;
        this.player = player;
    }

    public void showInfo(Graphics g) {

        int maxHp = player.getMaxHP();
        int w = (int) (U_WIDTH * (player.getHp() * 1.0 / maxHp));
        g.setColor(Color.gray);
        g.fillRect(0, 0, U_WIDTH, 50); //background
        g.setColor(Color.red);
        g.fillRect(0, 5, w, 20); //max health points, back of 1st rectangle hp

        g.setColor(Color.white);
        g.drawString("HP " + player.getHp() + "/" + maxHp, 10, 20);
        g.drawString("Countdown: " + gameArea.getRemainingTime() + " sec", 10, 40);
    }

}
