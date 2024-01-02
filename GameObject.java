
/**
 * [GameObject.java]
 *
 * @author: Jillian and Ellie
 * @version: June 2022
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.awt.Color;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
// possible exceptions
import java.io.IOException;

abstract class GameObject implements Collidable {

    private int x;
    private int y;
    private int width;
    private int height;
    private double angle;
    private BufferedImage original;
    private BufferedImage picture;
    private Rectangle box;
//------------------------------------------------------------------------------    

    GameObject(int x, int y, String picName) {
        this.x = x;
        this.y = y;
        try {
            original = ImageIO.read(new File(picName));
        } catch (IOException ex) {
        }
        this.picture = copyImage(original);
        this.width = picture.getWidth();
        this.height = picture.getHeight();
        this.box = new Rectangle(this.x, this.y, this.width, this.height);
    }

//------------------------------------------------------------------------------
    private BufferedImage copyImage(BufferedImage image) {
        BufferedImage copiedImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        Graphics2D g2d = copiedImage.createGraphics();
        g2d.drawImage(image, null, 0, 0);
        g2d.dispose();
        return copiedImage;
    }

    private BufferedImage rotateImage(BufferedImage image, double angle) {
        BufferedImage rotatedImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        Graphics2D g2d = rotatedImage.createGraphics();
        g2d.rotate(Math.toRadians(-this.angle), image.getWidth() / 2, image.getHeight() / 2);
        g2d.drawImage(image, null, 0, 0);
        g2d.dispose();
        return rotatedImage;
    }
//------------------------------------------------------------------------------

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getW() {
        return this.width;
    }

    public int getH() {
        return this.height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setBox() {
        this.box.setLocation(this.x, this.y);
    }

    public Rectangle getBox() {
        return this.box;
    }

    public double calculateAngle(int targetX, int targetY) {
        int weaponX = this.getX();
        int weaponY = this.getY();
        double angle = -Math.toDegrees(Math.atan2(targetY - weaponY, targetX - weaponX));
        this.setAngle(angle);
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double getAngle() {
        return this.angle;
    }

    public BufferedImage getPicture() {
        return this.picture;
    }

    public void rotatePicture() {
        this.picture = rotateImage(this.original, this.angle);
    }

// -------------------------------------------------------------------------------
    public void moveUp() {
        this.setY(this.getY() - Const.STEP / 2);
        this.setBox();
    }

    public void moveDown() {
        this.setY(this.getY() + Const.STEP / 2);
        this.setBox();
    }

    public void moveLeft() {
        this.setX(this.getX() - Const.STEP / 2);
        this.setBox();
    }

    public void moveRight() {
        this.setX(this.getX() + Const.STEP / 2);
        this.setBox();
    }
//------------------------------------------------------------------------------    

    public void draw(Graphics g) {
        g.drawImage(this.picture, this.getX(), this.getY(), null);
    }

    @Override
    public boolean collides(Character other) {
        return this.getBox().intersects(other.getBox());
    }

    @Override
    public boolean collides(GameObject other) {
        return this.getBox().intersects(other.getBox());
    }
}
