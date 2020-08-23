package DungeonSource.Obstalces;
/*@Kaylene
 *06/02/2019
 *Obstacle class for obstacles that can be found in the rooms
 *Generates damage that will be dealt to the hero. The number
 *generated is random and between the low and high damage variables.
*/
import java.util.Random;

import DungeonSource.DungeonCharacters.Hero;

public abstract class Obstacle {
    private int damage;//damage the obstacle does
    private Random rand;
    private int damageLow;//lowest damage the obstacle does
    private int damageHigh;//highest damage the osbtacle does
    private String name;//name of the obstacle

    //initializes the obstacle state
    Obstacle(int damageLow, int damageHigh, String name){
        this.rand = new Random();
        this.setDamageLow(damageLow);
        this.setDamageHigh(damageHigh);
        this.name = name;
        this.generateDamage();
    }
    
    //obstacle deals damage to the hero 
    public void dealDamage(Hero hero){
        System.out.println(hero.getName()+" has encoutered "+ getName());
        hero.subtractHealthPoints(damage);
    }
    
    //sets the lowest damage dealt
    public void setDamageLow(int damageLow){
        if(damageLow<0){
            throw new IllegalArgumentException("Damage must be positive");
        }
        this.damageLow = damageLow;
    }
    
    //sets the highest damage dealt
    public void setDamageHigh(int damageHigh){
        if(damageHigh<0){
            throw new IllegalArgumentException("Damage must be positive");
        }
        this.damageHigh = damageHigh;
    }

    //generates the damage that obstacle will deal
    public void generateDamage(){
        this.damage = rand.nextInt(damageHigh-damageLow) + damageLow;
    }
    
    //gets the name of the obstalce
    public String getName(){
        return this.name;
    }
    
    //gets the damage dealt
    public int getDamage(){
        return this.damage;
    }
}
