package player;

import weapons.*;
public class Hero {
	
	private String name = "";
	private String heroClass = "";
	//TODO level up
	private int xp = 0;
	private int gold = 10;
	
	//Stats
	private int strength = 0;
	private int intelligence = 0;
	private int wisdom = 0;
	private int dexterity = 0;
	private int charisma = 0;
	private int hitPoints = 0;
	private int stamina = 0;
	private int willpower = 0;
	public int maxHitPoints = 0;
	
	// Resistances
	private int armor = 2;
	private int fireResistance = 0;
	
	private GenericWeapon weapon = null;
	public Inventory inventory = null;
	public Paperdoll paperDoll = null;
	
	public Hero(){
		inventory = new Inventory();
		paperDoll = new Paperdoll();
		GenericWeapon mace = new WornMace();
		inventory.addWeaponToInventory(mace);
	}
	
	public void equipWeapon(GenericWeapon weapon){
		this.setWeapon(weapon);
		weapon.damageModifier(getStrength());
	}
	
	public void regainMaxHitPoints(){
		System.out.println("Your health is replenished.");
		hitPoints = maxHitPoints;
	}
	
// Name get/set
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
// Hero Class get/set
	public String getHeroClass() {
		return heroClass;
	}

	public void setHeroClass(String heroClass) {
		this.heroClass = heroClass;
	}
// XP get/set
	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}
// Gold get/set
	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}
// Strength get/set
	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}
// Intelligence get/set
	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
// Wisdom get/set
	public int getWisdom() {
		return wisdom;
	}

	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}
// Dexterity get/set
	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}
// Charisma get/set
	public int getCharisma() {
		return charisma;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}
// Hit Points get/set
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

	public GenericWeapon getWeapon() {
		return weapon;
	}

	public void setWeapon(GenericWeapon weapon) {
		if(paperDoll.equipWeapon(weapon, inventory))
			this.weapon = weapon;
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

}
