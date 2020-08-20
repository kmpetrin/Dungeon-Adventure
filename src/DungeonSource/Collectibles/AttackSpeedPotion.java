package DungeonSource.Collectibles;

import DungeonSource.DungeonCharacters.Hero;
//Attack speed potion that increases the heros attack speed by 1-2 points
public class AttackSpeedPotion extends PotionIncreaseStats {

	AttackSpeedPotion(){
		super(1,2, "Attack Speed Potion");
	}
	
	//returns what the attack speed does and how much it increases attack speed by
	public String toString(){
		return "Attack Speed Potion. It increases attack speed by " +getStatIncrease()+" points";
	}
	
	//hero drinks the potion and increases attack speed
	public void drink(Hero hero){
		int newAttackSpeed = hero.getAttackSpeed()+getStatIncrease();
		hero.setAttackSpeed(newAttackSpeed);
		System.out.println(hero.getName()+" has added "+ getStatIncrease() +" attack points");
		System.out.println("Total attack speed " + hero.getAttackSpeed());
	}
	
	//calls the drink method
	public void use(Hero hero) {
		drink(hero);
	}
	

}
