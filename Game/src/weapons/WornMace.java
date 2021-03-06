package weapons;

import java.util.Random;

public class WornMace extends GenericWeapon {

	public WornMace() {	
	this.setBaseDamage("1d4");
	this.setDamageType("physical");
	this.setDescription("A worn mace.");
	this.setLevel(1);
	this.setName("Worn Mace");
	this.setRanged(false);
	this.setTwoHanded(false);
	this.setOffHand(false);
	this.setMainHand(true);
	
	this.setGoldValue(5);
}

private int dmgMod = 0;

@Override
public int calculateDamageDelt() {
	Random rand = new Random();
	int dieRoll = rand.nextInt(3) + 1;
	return dieRoll + dmgMod;
}

@Override
public void damageModifier(int strengthMod){
	 if (strengthMod > 8);
	 	dmgMod = strengthMod / 4;
}

@Override
public String toString(){
	return "worn mace";
}

}
