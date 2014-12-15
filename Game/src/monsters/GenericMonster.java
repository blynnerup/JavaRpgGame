package monsters;

import consumables.GenericConsumable;
import weapons.GenericWeapon;

public class GenericMonster {

	// Basic stats
	private int strength = 0;
	private int intelligence = 0;
	private int wisdom = 0;
	private int dexterity = 0;
	private int charisma = 0;
	private int hitPoints = 0;
	private int stamina = 0;
	private int willpower = 0;
	
	// Basic resistances
	private int armor = 0;
	private int fireResistance = 0;
	
	//TODO Create xp gain value, level?
	
	// Basic gear
	private GenericWeapon equipment = null;
	
	public void equipWeapon(GenericWeapon weapon){
		
	}
	
	public int goldLoot(){
		return 0;
	}
	
	public GenericWeapon weaponLoot(){
		return null;
	}
	
	public GenericConsumable consumableLoot(){
		return null;
	}
	
	public int calculateDamageDelt(){
		return 0;
	}
	
	public String status(){
		return "feeling super!";
	}
		
	public String death(){
		return null;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getWisdom() {
		return wisdom;
	}

	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getCharisma() {
		return charisma;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public int getWillpower() {
		return willpower;
	}

	public void setWillpower(int willpower) {
		this.willpower = willpower;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getFireResistance() {
		return fireResistance;
	}

	public void setFireResistance(int fireResistance) {
		this.fireResistance = fireResistance;
	}

	public GenericWeapon getEquipment() {
		return equipment;
	}

	public void setEquipment(GenericWeapon equipment) {
		this.equipment = equipment;
	}
}
