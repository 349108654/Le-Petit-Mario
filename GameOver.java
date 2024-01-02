/**
 * [GameOver.java]
 *
 * @author: Jillian and Ellie
 * @version: June 2022
 */
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JProgressBar;
import javax.swing.JFrame;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

public class GameOver {
    //images

    private BufferedImage gameOverText;
    private BufferedImage youWinText;
    private BufferedImage mainMenu; //exit
    private BufferedImage mainMenu2;
    private BufferedImage restartMenu;
    private BufferedImage restartMenu2;
    private boolean hoverMenu, win, hoverRestart = false;
    final int mainMenuX = (Const.WIDTH / 2) - 115, mainMenuY = (Const.HEIGHT / 2);
    final int restartMenuX = (Const.WIDTH / 2) - 115, restartMenuY = (Const.HEIGHT / 2 + 50);

    GameOver() {
        try {
            gameOverText = ImageIO.read(new File("images/gameOver.png"));
            youWinText = ImageIO.read(new File("images/youWin.png"));
            mainMenu = ImageIO.read(new File("images/mainMenu.png"));
            mainMenu2 = ImageIO.read(new File("images/mainMenu2.png"));
            restartMenu = ImageIO.read(new File("images/restart.png"));
            restartMenu2 = ImageIO.read(new File("images/restart2.png"));
        } catch (IOException ex) {
        }
    }

    public void draw(Graphics g) {
        g.fillRect(Const.WIDTH / 4 - 40, Const.HEIGHT / 4 - 20, Const.WIDTH / 2, Const.HEIGHT / 2);
        if (win) {
            g.drawImage(this.youWinText, Const.WIDTH / 2 - 150, Const.HEIGHT / 2 - 100, null);
        } else {
            g.drawImage(this.gameOverText, Const.WIDTH / 2 - 150, Const.HEIGHT / 2 - 100, null);
        }

        if (hoverMenu) {
            g.drawImage(this.mainMenu2, mainMenuX - 10, mainMenuY - 10, null);
        } else {
            g.drawImage(this.mainMenu, mainMenuX, mainMenuY, null);
        }

        if (hoverRestart) {
            g.drawImage(this.restartMenu2, restartMenuX - 10, restartMenuY - 10, null);
        } else {
            g.drawImage(this.restartMenu, restartMenuX, restartMenuY, null);
        }
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public boolean hoverMenu(int x, int y) {
        if ((x > mainMenuX) && (x < mainMenuX + this.mainMenu.getWidth()) && (y > mainMenuY) && (y < mainMenuY + mainMenu.getHeight())) {
            this.hoverMenu = true;
        } else {
            this.hoverMenu = false;
        }
        return this.hoverMenu;
    }

    public boolean hoverRestart(int x, int y) {
        if ((x > restartMenuX)
                && (x < restartMenuX + this.restartMenu.getWidth())
                && (y > restartMenuY)
                && (y < restartMenuY + restartMenu.getHeight())) {
            this.hoverRestart = true;
        } else {
            this.hoverRestart = false;
        }
        return this.hoverRestart;
    }
}
