import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Nave que dispara los proyectiles.
 * 
 * @author Andrés Chavarriaga
 * @email: andrescamilochg11@gmail.com
 * @version v0.1.2
 */
public class Cohetico extends Actor
{  
    public Cohetico(){
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 450, image.getHeight() - 450);
        setImage(image);
    }
    
    Boolean puedeDisparar = true;
    
    public void act()
    {
        movimiento();
        dispararProyectil();
    }
    
        public void movimiento()
    {
        if (Greenfoot.isKeyDown("D")){
            setLocation(getX()+3, getY());
            setRotation(90);
        }
        else if (Greenfoot.isKeyDown("A")){
            setLocation(getX()-3, getY());
            setRotation(270);
        }
        else if (Greenfoot.isKeyDown("W")){
            setLocation(getX(), getY()-3);
            setRotation(360);
        }
        else if (Greenfoot.isKeyDown("S")){
            setLocation(getX(), getY()+3);
            setRotation(180);
        }
    }
    
     public void dispararProyectil()
    {
        if(Greenfoot.isKeyDown("enter") && puedeDisparar == true){
            if (getRotation() == 360 || getRotation() == 0){
            getWorld().addObject(new Projectile(), getX(), getY()-30);
            puedeDisparar = false;
            }
            if (getRotation() == 180){
            getWorld().addObject(new Projectile(), getX(), getY()+30);
            puedeDisparar = false;
            }
            else if (getRotation() == 90){
            getWorld().addObject(new Projectile(), getX()+30, getY());
            puedeDisparar = false;
            }
            else if (getRotation() == 270){
            getWorld().addObject(new Projectile(), getX()-30, getY());
            puedeDisparar = false;
            }
            
        } else if(!Greenfoot.isKeyDown("enter")){
            puedeDisparar = true;   
        }

    }
}