
/**
 * Abstract class Dinosaur - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Dinosaur
{
    private String type;
    private int age;
    private String gender;
    private int wins;
    private int battleCount;
    private int health; // 0 is dead, 100 is perfectly healthy
    private boolean isAlive; 
    
    /**
     * Dinosaur constructor -- This is not a default constructor because
     * the type is not general for all dinosaurs, it must be passed from a
     * specific species.
     */
    
    public Dinosaur(String t)
    {
        this.type = t;
        this.age = 0;
        this.wins = 0;
        this.health = 10;
        this.battleCount = 0;
        this.isAlive = true;
        if (Math.random() > 0.5)        
            this.gender = "M";
        
        else       
            this.gender = "F"; 
        
            
        
    }

    /**
     * **************************** Getters *******************************
     */
    public String getType()
    {
        return this.type;
    }
    
    public int getAge()
    {
        return this.age;
    }
    
    public int getWins()
    {
        return this.wins;
    }
    
    public int getHealth()
    {
        return this.health;
    }
    
    public int getBattleCount()
    {
        return this.battleCount;
    }
    
    public String getGender()
    {
        return this.gender;
    }
    
    public boolean getIsAlive()
    {
        return this.isAlive;
    }
    
    /**
     * **************************** Setters *******************************
     */
    
    public void setAge(int a)
    {
        this.age = a;
    }
    
    public void setWins(int w)
    {
        this.wins = w;
    }
    
    public void setHealth(int h)
    {
        this.health = h; 
    }
    
    public void setBattleCount(int b)
    {
        this.battleCount = b;
    }
    
    public void setGender(String g)
    {
        this.gender = g; 
    }
    
    public void setIsAlive(boolean i)
    {
        this.isAlive = i;
    }
    
    /**
     * *************************** Methods *********************************
     */
    
    /**
     * Attack is abstract because the method is defined 
     * by the object calling it, and the result must change because two
     * different species have different attacking abilities.
     */
    
    public abstract boolean attack(Dinosaur def);
        
    public void ageUp()
    {
        this.setAge(this.getAge()+1);
        if (this.age < 10)
        {
            this.setHealth(this.getHealth()+15);
        }
        
        if (this.age > 30)
        {
            this.setHealth(this.getHealth() - 15);
        }        
        else if (this.age > 25)
        {
            this.setHealth(this.getHealth() - 10);
        }
        
        this.checkHealth();
        
    }
    
    public void checkHealth()
    {
        if (this.health <= 0)
        {
            // if(this.isAlive == true)
                // System.out.println( "This " + this.getType() + " has just died.");
            this.isAlive = false;
            this.health = 0;
        }
        else if (this.health >= 100)
        {
            this.health = 100;
        }
    }
     
    public void update(Dinosaur def, boolean winner)
    {
        this.battleCount++;
        def.setBattleCount(def.getBattleCount()+1);
        
        if (winner)
        {
            this.wins++;                         //increase win count of winning dino (attacker)
            def.setHealth(def.getHealth() - 20); //decrease health of losing dino (defender)
            def.checkHealth();                   //check health of losing dino (defender)
        }
        else
        {
            def.setWins(def.getWins()+1);       //increase win count of winning dino (defender)
            this.health -= 20;                  //decrease health of losing dino (attacker)
            this.checkHealth();                 //check health of losing dino (attacker)
        }
        
    }
    
    public String toString()
    {
      return this.type + this.gender + "  Age: " + this.age + "  " + "  Wins: " + this.wins + "  Health: " + this.health + "  Count: " + this.battleCount + "  ";
    }
    
    
}
