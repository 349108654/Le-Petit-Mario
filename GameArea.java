
/**
 * [GameArea.java]
 *
 * @author: Jillian and Ellie
 * @version: June 2022
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameArea {

    JFrame gameWindow;
    GamePanel gamePanel;
    MyKeyListener keyListener;
    MyMouseListener mouseListener;

//------------------------------------------------------------------------------
    //instantiate game objects
    GameArea() {
        gameWindow = new JFrame("Game Window");
        gameWindow.setSize(Const.WIDTH, Const.HEIGHT);
        gameWindow.setResizable(false);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gamePanel = new GamePanel();
        gameWindow.add(gamePanel);

        keyListener = new MyKeyListener();
        mouseListener = new MyMouseListener();
        gamePanel.addKeyListener(keyListener);
        gamePanel.addMouseListener(mouseListener);

        gameWindow.setVisible(true);
    }
//------------------------------------------------------------------------------  
    //main game loop

    public void run() {
        while (true) {
            gameWindow.repaint();
            try {
                Thread.sleep(Const.FRAME_PERIOD);
            } catch (Exception e) {
            }

        }
    }
//------------------------------------------------------------------------------  
    //act upon key events

    public class MyKeyListener implements KeyListener {

        public void keyPressed(KeyEvent e) {
        }

        public void keyReleased(KeyEvent e) {
        }

        public void keyTyped(KeyEvent e) {
        }
    }
//------------------------------------------------------------------------------
    //Mouse Listener

    public class MyMouseListener implements MouseListener {

        public void mouseClicked(MouseEvent e) {   // moves the box at the mouse location
        }

        public void mousePressed(MouseEvent e) {   // MUST be implemented even if not used!
        }

        public void mouseReleased(MouseEvent e) {  // MUST be implemented even if not used!
        }

        public void mouseEntered(MouseEvent e) {   // MUST be implemented even if not used!
        }

        public void mouseExited(MouseEvent e) {    // MUST be implemented even if not used!
        }
    }

//------------------------------------------------------------------------------
    public class GamePanel extends JPanel {

        GamePanel() {
            setFocusable(true);
            requestFocusInWindow();
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g); //required
        }
    }
}
