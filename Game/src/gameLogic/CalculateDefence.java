package gameLogic;

import monsters.GenericMonster;
import player.Hero;
import weapons.GenericWeapon;

public class CalculateDefence {
	GenericWeapon weap;
	Hero h;
	GenericMonster m;
	
	private String heroDefType = "";
	private int heroDefValue = 0;
	private String monsterDefType = "";
	private int monsterDefValue = 0;
	
	
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
		if(weap.getDamageType().equals("physical")){
			def = h.getArmor();
			heroDefType = weap.getDamageType();
			heroDefValue = def;
		}
		if(weap.getDamageType().equals("fire")){
			def = h.getFireResistance();
			heroDefType = weap.getDamageType();
			heroDefValue = def;
		}
		return def;
	}
	/*
	 * Get the defense value of the monster, for the specific type of attack.
	 */
	public int getMonsterDefense(){
		int def = 0;
		if(weap.getDamageType().equals("physical")){
			def = m.getArmor();
			monsterDefType = weap.getDamageType();
			monsterDefValue = def;
		}
		if(weap.getDamageType().equals("fire")){
			def = m.getFireResistance();
			monsterDefType = weap.getDamageType();
			monsterDefValue = def;
		}
		return def;
	}

	public String getHeroDefType() {
		return heroDefType;
	}

	public void setHeroDefType(String heroDefType) {
		this.heroDefType = heroDefType;
	}

	public int getHeroDefValue() {
		return heroDefValue;
	}

	public void setHeroDefValue(int heroDefValue) {
		this.heroDefValue = heroDefValue;
	}

	public String getMonsterDefType() {
		return monsterDefType;
	}

	public void setMonsterDefType(String monsterDefType) {
		this.monsterDefType = monsterDefType;
	}

	public int getMonsterDefValue() {
		return monsterDefValue;
	}

	public void setMonsterDefValue(int monsterDefValue) {
		this.monsterDefValue = monsterDefValue;
	}

}
