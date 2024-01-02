/**
 * [Collidable.java]
 * @author: Jillian and Ellie
 * @version: June 2022
 */
import java.awt.Rectangle;
import java.awt.Graphics2D;

public interface Collidable {
  
  //whether the object collided with any other object
  public boolean collides(Character other);
  public boolean collides(GameObject other);
}