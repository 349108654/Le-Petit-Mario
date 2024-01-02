/**
 * [Enemy.java]
 * @author: Jillian and Ellie
 * @version: June 2022
 */
abstract class Enemy extends Character{
  //Constructor
  Enemy(int x, int y, String picName, int rows, int columns,int hp,Weapon weapon1){
    super(x, y, picName, rows, columns, hp, false, weapon1);
  }
  abstract void move(int x, int y,boolean attacked);
  public abstract boolean attack(Character target, boolean attacked);
}