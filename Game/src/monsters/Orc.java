package monsters;

import java.util.Random;

import consumables.GenericConsumable;
import consumables.HealthPotion;
import consumables.ManaPotion;
import weapons.BasicFireWand;
import weapons.DullDagger;
import weapons.GenericWeapon;
import weapons.RustySword;

public class Orc extends GenericMonster {
	
	Random rand = new Random();

	public Orc() {
		// Set basic stats
		this.setStrength(12);
		this.setIntelligence(2);
		this.setWisdom(3);
		this.setDexterity(6);
		this.setCharisma(2);
		this.setHitPoints(12);
		this.setStamina(11);
		this.setWillpower(6);
		
		// Set basic resistances
		this.setArmor(2);
		this.setFireResistance(1);
		
		this.setBasisLevel(2);
		
		// Set equipment
		GenericWeapon dagger = new DullDagger();
		equipWeapon(dagger);
		calculateXpValue();
	}
	
	private void calculateXpValue(){
		int weaponLevel = this.getEquipment().getLevel();
		this.setXpValue(weaponLevel * this.getBasisLevel()); 
	}
	
	@Override 
	public void equipWeapon(GenericWeapon weapon){
		this.setEquipment(weapon);
		weapon.damageModifier(getStrength());
	}
	
	@Override
	public String death() {
		super.death();
		return "\"Arrr.....\" The orc drops dead on the ground.";
	}
	
	@Override
	public String status(){
		if((getHitPoints() / 2) < 3)
			return " The orc looks badly injured.";
		else
			return " The orc looks fine.";
	}
	
	@Override
	public String toString()
	{
		return "orc";
	}
	
	@Override
	public int goldLoot(){
		return rand.nextInt(8) + 2;
	}
	
	@Override
	public GenericWeapon weaponLoot(){
		GenericWeapon weapon = null;
		int selection = rand.nextInt(4);
		if(selection < 2)
			selection = 0;
		switch (selection) {
		case 0:
			weapon = null;
			break;
		case 2:
			weapon = new DullDagger();
			break;
		case 3:
			weapon = new BasicFireWand();
			break;
		case 4:
			weapon = new RustySword();
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
			System.out.println("getting consumable went sour!");
			break;
		}
		return cons;
	}

}
