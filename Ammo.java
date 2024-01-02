/**
 * [Ammo.java]
 * @author: Jillian and Ellie
 * @version: June 2022
 */
import java.awt.Graphics;

public class Ammo implements Collidable{
    final int CARTRIDGE_SIZE = 100; //size of bullet   
    private Bullet[] bullets; //array of bullets
    private double angle; //turning
    private int bulletCount; //amount of bullets
    
    Ammo(){
        this.bullets = new Bullet[CARTRIDGE_SIZE];
    }
//------------------------------------------------------------------------------      
    public void drawBullets(Graphics g){
      //draw all bullets
        for (int i=0; i<this.bullets.length; i++){
            if (this.bullets[i] != null){ 
                this.bullets[i].draw(g);
            }
        }
    }
    
    public void moveBullets(){
        for (int i=0; i<this.bullets.length; i++){
            if (this.bullets[i] != null){
                this.bullets[i].move();
                if (this.bullets[i].getY() < 0){
                    this.removeBullet(i);
                }
            }
        }
    }
    public void setAngle(double angle){
      this.angle = angle;
    }
//------------------------------------------------------------------------------  
    public void addBullet(Weapon weapon){
        boolean added = false;
        for (int i=0; i<this.bullets.length; i++){
            if (this.bullets[i] == null && !added){
                int bulletX = weapon.getX();
                int bulletY = weapon.getY();
                this.bullets[i] = new Bullet(bulletX, bulletY, "images/bullet.jpg");
                this.bullets[i].setAngle(this.angle);
                this.bulletCount++;
                added = true;
            }
        }
    }
    public void removeBullet(int index){
        this.bullets[index] = null;
        this.bulletCount--;
    }    
    
    @Override
    public boolean collides(Character other){
      if (other.getIsDead()){
        return false;
      }
      for (int i=0; i<this.bulletCount; i++){
        if (this.bullets[i] != null){
          if (this.bullets[i].collides(other)){ 
          //if bullet collides with character
            this.removeBullet(i);
            return true;
          }
        }
      }
      return false;
    }
    
    @Override
    public boolean collides(GameObject other){
      for (int i=0; i<this.bulletCount; i++){
        if (this.bullets[i] != null){
          if (this.bullets[i].collides(other)){
            this.removeBullet(i);
            return true;
          }
        }
      }
      return false;
    }
}