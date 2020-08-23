package DungeonSource.DungeonCharacters;

/**
 * @Kaylene
 * 06/02/2020
 * Abstract base class for a hierarchy of monsters.  It is derived
 * from DungeonCharacter. Monsters have the ability to heal themselves
 * after taking opponent damage.
 */

public abstract class Monster extends DungeonCharacter
{
    private double chanceToHeal;
    private int minHeal, maxHeal;

//-----------------------------------------------------------------
    Monster(String name, int healthPoints, int attackSpeed, double chanceAttackWillLand, 
                    double chanceToHeal,int damageMin, int damageMax,int minHeal, int maxHeal)
    {
          super(name, healthPoints, attackSpeed, chanceAttackWillLand, damageMin, damageMax);
          this.chanceToHeal = chanceToHeal;
          this.maxHeal = maxHeal;
          this.minHeal = minHeal;

    }//end monster construcotr

    //calculates monsters chance to heal
    public void chanceToHeal()
    {
        boolean canHeal;
        int healPoints;
        canHeal = (Math.random() <= chanceToHeal) && (getHealthPoints() > 0);
        if (canHeal)
        {
            healPoints = (int)(Math.random() * (maxHeal - minHeal + 1)) + minHeal;
            addHealthPoints(healPoints);
            System.out.println(getName() + " healed itself for " + healPoints + " points.\n"
                                                    + "Total health points remaining are: " + getHealthPoints());
            System.out.println();
        }//end can heal
    }//end heal method

 //takes the opponents damage and calls chanceToHeal() to try and regenerate health
    public void takeOpponentDamage(int damageTaken)
    {
        subtractHealthPoints(damageTaken);
        chanceToHeal();
    }


}//end Monster class