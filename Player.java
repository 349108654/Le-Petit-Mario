
/**
 * [Player.java]
 *
 * @author: Jillian and Ellie
 * @version: June 2022
 */
public class Player extends Character {

    final int MAX_HP = 6;

    //Constructor
    Player(int x, int y, String picName, int rows, int columns, int hp, int xp, int shield, Weapon weapon) {//Weapon weapon
        super(x, y, picName, rows, columns, hp, true, weapon);
    }
// Getters and Setters-----------------------------------------------------

    public int getMaxHP() {
        return this.MAX_HP;
    }

    @Override
    public void die() {
        this.setPlayableFalse();
        super.die();
    }

}
