/**
 * [Sign.java]
 * @author: Jillian and Ellie
 * @version: June 2022
 */
import java.awt.Graphics;
import java.awt.Color;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
// possible exceptions
import java.io.IOException;
import java.awt.Rectangle;

public class Sign extends GameObject{
  private String message;
//------------------------------------------------------------------------------    
  Sign(int x, int y, String message){ 
    super(x, y, "images/sign.png");
    this.message = message;
  }
  //---------------------------------------------------------------------------    
  public void read(Graphics g){
    g.setColor(Color.white);
    g.drawString(this.message,this.getX(),this.getY());
  }
  
}