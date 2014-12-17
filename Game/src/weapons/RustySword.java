package weapons;

import java.util.Random;

public class RustySword extends GenericWeapon {

	public RustySword() {
		this.setBaseDamage("1d4 + 3");
		this.setDamageType("physical");
		this.setDescription("Old rusty sword, basic gear.");
		this.setLevel(1);
		this.setName("Rusty Sword");
		this.setRanged(false);
		this.setTwoHanded(false);
		this.setOffHand(false);
		this.setMainHand(true);
		
		this.setGoldValue(5);
	}
	
	private int dmgMod = 0;
	
	@Override
	public int calculateDamageDelt(){
		int damage = 0;
		Random rand = new Random();
		
		int dieRoll = rand.nextInt(4) + 1;
		damage = dieRoll + 3;
		return damage + dmgMod;
	}
	
	@Override
	public String toString(){
		return "rusty sword";
	}

	@Override
	public void damageModifier(int strengthMod) {
		if(strengthMod < 6)
			dmgMod = -1;
		if(strengthMod > 5 && strengthMod < 9)
			dmgMod = 0;
		if(strengthMod > 8)
			dmgMod = strengthMod / 4;
	}

}
