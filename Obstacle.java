/**
 * [Obstacle.java]
 * @author: Jillian and Ellie
 * @version: June 2022
 */
import java.awt.Graphics;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
// possible exceptions
import java.io.IOException;
import java.awt.Rectangle;

public class Obstacle extends GameObject{
//------------------------------------------------------------------------------    
//        private BufferedImage obsPic;
//------------------------------------------------------------------------------    
  Obstacle(int x, int y, String picName){ 
    super(x, y, picName);      
  }   
}