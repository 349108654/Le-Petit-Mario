/**
 * [Background.java]
 * @author: Jillian and Ellie
 * @version: June 2022
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Color;
// possible exceptions
import java.io.IOException;

public class Background{
    private int x; //x 
    private int y; //y
    private int width; //width of pic
    private int height; //height of pic
    private BufferedImage bckgPic;
//------------------------------------------------------------------------------    
    Background(String picName){
      //read image file
        try {                
            this.bckgPic = ImageIO.read(new File(picName));
        } catch (IOException ex){}
        this.width = bckgPic.getWidth();
        this.height = bckgPic.getHeight();
        this.x = 0;
        this.y = 0;
        
    }
//------------------------------------------------------------------------------      
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }    
    public int getWidth(){
        return this.width;
    }    
    public int getHeight(){
        return this.height;
    }
//------------------------------------------------------------------------------    
    
    public void draw(Graphics g){
        g.drawImage(this.bckgPic, this.x, this.y, null);
    }
    
    public void moveUp(){
        this.y -= PlayerConst.STEP/2;
    }
    public void moveDown(){
        this.y += PlayerConst.STEP/2;
    }
    public void moveLeft(){
        this.x -= PlayerConst.STEP/2;
    }
    public void moveRight(){
        this.x += PlayerConst.STEP/2;
    }
}