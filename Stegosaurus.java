
/**
 * Write a description of class Stegosaurus here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Stegosaurus extends Dinosaur
{
    public Stegosaurus()
    {
        super("Stego");
    }
    
    public boolean attack(Dinosaur def)
    {
        
        
        if (def.getType().equals("Stego"))
        {
            if (Math.random() < 0.55)
            {
                this.update(def,false);
                return false;               
            }
            else 
            {
                this.update(def,true);
                return true;
            }
        }
        else if (def.getType().equals("TRex"))
        {
            if (Math.random() < 0.45)
            {
                this.update(def,true);
                return true;
            }
            else 
            {
                this.update(def,false);
                return false;
            }
        }
        else if (def.getType().equals("Bronto"))
        {
            if (Math.random() < 0.75)
            {
                this.update(def,true);
                return true;
            }
            else 
            {
                this.update(def,false);
                return false;
            }
        }
        else if (def.getType().equals("Pterodactyl"))
        {
             if (Math.random() < 0.65)
                return true;
            else 
                return false;
        }
        else return false;
        
    }
}
