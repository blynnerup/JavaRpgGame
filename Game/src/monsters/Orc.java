package monsters;

import weapons.DullDagger;
import weapons.GenericWeapon;

public class Orc extends GenericMonster {

	public Orc() {
		// Set basic stats
		this.setStrength(12);
		this.setIntelligence(2);
		this.setWisdom(3);
		this.setDexterity(6);
		this.setCharisma(2);
		this.setHitPoints(80);
		this.setStamina(11);
		this.setWillpower(6);
		
		// Set basic resistances
		this.setArmor(2);
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
	public int calculateDamageDelt(){
		
		
		
		return 1;
	}
	
	@Override
	public String toString()
	{
		return "orc";
	}

}
