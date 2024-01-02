/**
 * [Bullet.java]
 * @author: Jillian and Ellie
 * @version: June 2022
 */
import java.awt.Graphics;
import java.awt.Color;

public class Bullet extends GameObject {
    private int radius;
    private double velocity;
    private int rotationStep;
//------------------------------------------------------------------------------    
    Bullet(int x, int y, String picName){
        super(x, y, picName);
        this.radius = 5;
        this.velocity = 10;
        this.rotationStep = BulletConst.ROTATION_STEP;
        
    }
//------------------------------------------------------------------------------    
    
    public void move(){
      int vectorX = (int)(Math.round(this.velocity*Math.cos(Math.toRadians(-this.getAngle()))));
      int vectorY = (int)(Math.round(this.velocity*Math.sin(Math.toRadians(-this.getAngle()))));   
      this.setX(super.getX() + vectorX);
      this.setY(super.getY() + vectorY);
      this.setBox();
    }
}