package weapons;

import java.util.Random;

public class DullDagger extends GenericWeapon {

	public DullDagger() {
		this.setBaseDamage("1d3");
		this.setDamageType("physical");
		this.setDescription("A dull old dagger");
		this.setLevel(1);
		this.setName("Dull Dagger");
		this.setRanged(false);
		this.setTwoHanded(false);
		this.setOffHand(true);
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
		 if (strengthMod > 9);
		 	dmgMod = 1;
	}
	
	@Override
	public String toString(){
		return "dull dagger";
	}
	

}
