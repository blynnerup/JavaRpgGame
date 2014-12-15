package gameLogic;

import monsters.GenericMonster;
import player.Hero;
import weapons.GenericWeapon;

public class CalculateDefence {
	GenericWeapon weap;
	Hero h;
	GenericMonster m;
	// Calculate defense for attacks against the hero..
	public CalculateDefence(GenericWeapon weapon, Hero hero) {
		weap = weapon;
		h = hero;
	}
	
	// Calculate defense for attacks against a monster
	public CalculateDefence(GenericWeapon weapon, GenericMonster monster){
		weap = weapon;
		m = monster;
	}
	
	/*
	 * Get the defense value of the hero, for the specific type of attack
	 */
	public int getHeroDefense(){
		int def = 0;
		if(weap.getDamageType().equals("physical"))
			def = h.getArmor();
		if(weap.getDamageType().equals("fire"))
			def = h.getFireResistance();
		return def;
	}
	/*
	 * Get the defense value of the monster, for the specific type of attack.
	 */
	public int getMonsterDefense(){
		int def = 0;
		if(weap.getDamageType().equals("physical"))
			def = m.getArmor();
		if(weap.getDamageType().equals("fire"))
			def = m.getFireResistance();
		System.out.println("Monster def: " + def + " and is of type: " + weap.getDamageType());
		return def;
	}

}
