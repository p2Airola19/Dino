
/**
 * Write a description of class DinoDriver1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DinoDriver1
{
    public static void main (String[] args)
    {
     
      
      Dinosaur d1 = new TRex();
      Dinosaur d2 = new Stegosaurus();
      d1.setHealth(100);
      d2.setHealth(100);

      int winCount = 0;
      
      
      for (int i = 0; i<100; i++)
      {          
              //if (d1.getIsAlive() && d2.getIsAlive())
              {
                  if(d1.attack(d2))
                  {
                      winCount++;                                   
                  }
                  System.out.println(d1.toString() + "*** " + d2.toString());
              }               
      }
      
      System.out.println("" + winCount + " out of " + d1.getBattleCount());
     }
          
      
      
      
      

}

