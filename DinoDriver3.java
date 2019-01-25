
/**
 * Write a description of class DinoDriver3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.ArrayList;

public class DinoDriver3
{
    public static void main(String[] args)
    {
        ArrayList<Dinosaur> myPop = new ArrayList();
        
        System.out.print("How many dinos would you like? ");
        Scanner scan = new Scanner(System.in);
        int numPop = scan.nextInt();
        
        for(int i = 0; i < numPop; i++) //the arraylist is randomly filled with 3 types of dinosaurs one at a time
        {
            double randNum = Math.random();           
            if(randNum>0.66)
            {                
                myPop.add(new TRex());
            }            
            else if(randNum>0.33)
            {                
                myPop.add(new Stegosaurus());
            }               
            else
            {               
                myPop.add(new Brontosaurus());
            }
        }
        
        for(Dinosaur d : myPop) //each dinosaur is given a random age and corresponding health
        {
            int randAge =(int)(Math.random()*30);
            for(int j = 0; j < randAge; j++)
                {
                    d.ageUp();
                }
        }
        
        for(Dinosaur d : myPop) //each dinosaur in arraylist attacks one other dinosaur
        {
            int index = DinoDriver3.getDefender(myPop, d); 
            d.attack(myPop.get(index));
            DinoDriver3.removeDeadDinosaur(myPop);
        }
                
        for(Dinosaur d : myPop) //each dinosaur is output
        {
            System.out.println(d);
        }
    }
    
        
    public static int getLivingDinoCount( ArrayList<Dinosaur> p )
    {
        int living = 0;
        
        for (Dinosaur d : p) //the number of living dinosaurs is found
        {
            if (d.getIsAlive()==true)
                living++;           
        }
                
        return living;
    }
    
    
    public static int getDefender( ArrayList<Dinosaur> p, Dinosaur attacker )
    {
        //gets a random dino from p that is not the attacker and is alive
        Dinosaur def = attacker;
        int index = -1;
        
        do //continues the loop until the defender is alive AND isn't the same as the attacker
        {
            index = (int)(Math.random()*p.size());
            def = p.get(index);
        }
        while ( def == attacker  ||  !def.getIsAlive() );
        
        return index;
    }
    
    
    public static void removeDeadDinosaur( ArrayList<Dinosaur> p )
    {
        for( int i = p.size() - 1; i > -1; i--)
        {
            if(!p.get(i).getIsAlive())
            {
                p.remove(i);
            }
        }
    }
}
