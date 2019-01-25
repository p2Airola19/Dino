
/**
 * Write a description of class DinoDriver2 here.
 *
 * @author (Bairola)
 * @version (a version number or a date)
 */
public class DinoDriver2
{
    public static void main(String[] args)
    {
        Dinosaur[] pop = new Dinosaur[100];
        
        
        for(int i = 0; i<33 ; i++)
        {
            pop[i] = new TRex();
        }
        
        for(int i = 33; i<66 ; i++)
        {
            pop[i] = new Stegosaurus();
        }
        
        for(int i = 66; i<pop.length ; i++)
        {
            pop[i] = new Brontosaurus();
        }
       
        for(int i = 0; i<pop.length ; i++)
        {
            int randage = (int)(Math.random()*25);
            for(int j = 0; j<=randage; j++)
            {
                pop[i].ageUp();
            }
        }
        
        int winCount = 0, battleCount = 0, roundCount = 0, deadBeforeRnd = 0, deadAfterRnd = 0, roundDeathCount = 0;
     
        while( DinoDriver2.getLivingDinoCount(pop) > 1)
        {           
            deadBeforeRnd = DinoDriver2.getDeadDinosaurCount(pop);
            for (Dinosaur a : pop)
            {
                if(a.getIsAlive() && DinoDriver2.getLivingDinoCount(pop) > 1)
                {
                    Dinosaur defend = DinoDriver2.getDefender(pop, a); 
                    a.attack(defend);
                    battleCount++;
                    a.ageUp();
                }
            }
            deadAfterRnd = DinoDriver2.getDeadDinosaurCount(pop);           
            roundCount++;
            System.out.println("End of round " + roundCount + " : Out of " + battleCount + " battles, " + (deadAfterRnd - deadBeforeRnd) + " dinos died.");
            battleCount = 0;
        }
        
        System.out.println("End of Rounds. Total living: " + DinoDriver2.getLivingDinoCount(pop));
        Dinosaur winner = new TRex(); //does this work?
        for (Dinosaur d : pop)
        {
            if (d.getIsAlive() == true)
                   winner = d;
        }
        System.out.println("THE WINNER IS: " + winner.toString());// does this work?
    }
    
    public static Dinosaur getDefender(Dinosaur[] p, Dinosaur attacker)
    {
        //write code that will get a random dino from p that is not the attacker
        Dinosaur def = attacker;
        boolean test = false;
        
        do
        {
            int randnum = (int)(Math.random()*(p.length));
            def = p[randnum];
        }
        while ( def==attacker  ||  !def.getIsAlive() );
        
        return def;
    }
    
    public static int getLivingDinoCount(Dinosaur[] p)
    {
        int living = 0;
        
        for (Dinosaur d : p)
        {
            if (d.getIsAlive()==true)
                living++;           
        }
                
        return living;
    }
    
    public static int getDeadDinosaurCount(Dinosaur[] p)
    {
        int dead = 0;
        
        for (Dinosaur d : p)
        {
            if (d.getIsAlive()!=true)
                dead++;           
        }
                
        return dead;        
    }
}
