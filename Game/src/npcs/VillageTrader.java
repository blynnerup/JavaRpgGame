package npcs;

import weapons.GenericWeapon;
import consumables.GenericConsumable;
import consumables.HealthPotion;

public class VillageTrader {

	private int gold = 0;
	
	public VillageTrader() {
		gold = 50;
	}
	
	
	//TODO should be modified by standing?
	public int sellWeapon(GenericWeapon weapon){
		return weapon.getGoldValue();
	}
	
	//TODO should be modified by standing?
	public int sellConsumable(GenericConsumable cons){
		return cons.getGoldValue();
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}
	

}
