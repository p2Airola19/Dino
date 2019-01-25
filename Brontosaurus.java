
/**
 * Write a description of class Brontosaurus here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Brontosaurus extends Dinosaur
{
    public Brontosaurus()
    {
        super("Bronto");
    }
    
    public boolean attack(Dinosaur def)
    {
        
        
        if (def.getType().equals("Bronto"))
        {
            if (Math.random() < 0.55)
            {
                this.update(def,false);
                return false;                
            }
            else 
                return true;
        }
        else if (def.getType().equals("TRex"))
        {
            if (Math.random() < 0.10)
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
        else 
        {
            if (Math.random() < 0.50)
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
    }
}
