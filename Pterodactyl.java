
/**
 * Write a description of class Pterodactyl here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Pterodactyl extends Dinosaur
{
    public Pterodactyl()
    {
        super("Ptero");
    }
    
    public boolean attack(Dinosaur def)
    {
        
        
        if (def.getType().equals("Ptero"))
        {
            if (Math.random() < 0.55)
                return true;
            else 
                return false;
        }
        else if (def.getType().equals("TRex"))
        {
            return false;
        }
        else if (def.getType().equals("Bronto"))
        {
            if (Math.random() < 0.30)
                return true;
            else 
                return false;
        }
        else if (def.getType().equals("Stegoaurus"))
        {
             if (Math.random() < 0.45)
                return true;
            else 
                return false;
        }
        else return false;
        
    }
}
