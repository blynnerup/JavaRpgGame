package weapons;

import java.util.Random;

public class BasicFireWand extends GenericWeapon {

	public BasicFireWand() {
		this.setBaseDamage("1d3");
		this.setDamageType("fire");
		this.setDescription("A wand from the magic academy.");
		this.setLevel(1);
		this.setName("Basic Fire Wand");
		this.setRanged(true);
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
	public void damageModifier(int intelligenceMod){
		 if (intelligenceMod > 9);
		 	dmgMod = 2;
	}
	
	@Override
	public String toString(){
		return "basic fire wand";
	}
}
