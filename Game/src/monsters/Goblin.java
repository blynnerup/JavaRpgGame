package monsters;

import java.util.Random;

import consumables.GenericConsumable;
import consumables.HealthPotion;
import consumables.ManaPotion;
import weapons.DullDagger;
import weapons.GenericWeapon;
import weapons.WornMace;

public class Goblin extends GenericMonster {

	Random rand = new Random();
	
	public Goblin() {
		this.setStrength(6);
		this.setIntelligence(5);
		this.setWisdom(4);
		this.setDexterity(7);
		this.setCharisma(3);
		this.setHitPoints(6);
		this.setStamina(5);
		this.setWillpower(6);
		
		// Set basic resistances
		this.setArmor(1);
		this.setFireResistance(1);
		
		// Set equipment
		GenericWeapon dagger = new DullDagger();
		equipWeapon(dagger);
	}
	
	@Override
	public void equipWeapon(GenericWeapon weapon){
		this.setEquipment(weapon);
		weapon.damageModifier(getStrength());
	}
	
	@Override
	public String death(){
		return "Ugh..stupid..";
	}
	
	 @Override
	 public String status(){
		 if(getHitPoints() /2 < 3)
			 return "The goblin looks shaken, and badly wounded.";
		 else
			 return "The goblin looks fine.";
	 }
	 
	 @Override 
	 public String toString(){
		 return "goblin";
	 }
	 
	 @Override
	 public int goldLoot(){
		 return rand.nextInt(4) + 1;
	 }
	 
	 @Override
	 public GenericWeapon weaponLoot(){
		 GenericWeapon weapon = null;
		 int selection = rand.nextInt(4);
		 if (selection < 3)
			 selection = 0;
		 switch (selection) {
		case 0:
			weapon = null;
			break;
		case 3:
			weapon = new DullDagger();
			break;
		case 4:
			weapon = new WornMace();
			break;
		default:
			System.out.println("getting weapon loot went sour!");
			break;
		}
		 return weapon;
	 }
	 
	 @Override
	 public GenericConsumable consumableLoot(){
		 GenericConsumable cons = null;
		 int selection = rand.nextInt(4);
		 if(selection < 3)
			 selection = 0;
		 switch (selection) {
		case 0:
			cons = null;
			break;
		case 3:
			cons = new HealthPotion();
			break;
		case 4:
			cons = new ManaPotion();
			break;
		default:
			System.out.println("getting consumable loot went sour!");
			break;
		}
		 return cons;
	 }

}
