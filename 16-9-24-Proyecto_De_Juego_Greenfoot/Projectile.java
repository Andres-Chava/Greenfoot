import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * El proyectil que se dispara.
 * 
 * @author Andrés Chavarriaga
 * @email: andrescamilochg11@gmail.com
 * @version v0.0.3
 */
class Projectile extends Actor
{

    public Projectile()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 1000, image.getHeight() - 1000);
        setImage(image);
    }

    
    
    public void act() 
    {
        movimientoProyectil();
        quitarDelMundo();
    } 

    public void movimientoProyectil()
    {
        if (getWorld().getObjects(Cohetico.class).get(0).getRotation() == 360 || getWorld().getObjects(Cohetico.class).get(0).getRotation() == 0){
        setLocation(getX(), getY()-10);
        }
        else if (getWorld().getObjects(Cohetico.class).get(0).getRotation() == 180){
        setLocation(getX(), getY()+10);
        }
        else if (getWorld().getObjects(Cohetico.class).get(0).getRotation() == 90){
        setLocation(getX()+10, getY());
        }
        else if (getWorld().getObjects(Cohetico.class).get(0).getRotation() == 270){
        setLocation(getX()-10, getY());
        }
    }

    public void quitarDelMundo()
    {
        if(getY() == 0 || getX() == 0 || getY() == -1 || getX() == -1)
        {
            getWorld().removeObject(this);
        }
    }
}