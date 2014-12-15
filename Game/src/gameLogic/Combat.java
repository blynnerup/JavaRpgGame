package gameLogic;

import java.io.IOException;

import consumables.GenericConsumable;
import player.Hero;
import weapons.GenericWeapon;
import monsters.GenericMonster;

// Basic class to handle basic combat
public class Combat {
	//TODO finish this....
	Hero hero;
	GenericMonster monster;
	private Boolean heroWon = true;
	CalculateDefence calcDef;
	
	private String hResistance;
	private int hResistanceValue;
	private String mResistance;
	private int mResistanceValue;
	
	private int hDmg = 0;
	private int mDmg = 0;
	
	public Combat (Hero h, GenericMonster m){
		hero = h;
		monster  = m;
		System.out.println("Entering combat");
		slaying();
	}
	
	private void slaying(){
		try {
			System.in.read();
		} catch (IOException e1) {			
			e1.printStackTrace();
		}
		Boolean dead = false;
		int monsterHit = monster.getHitPoints();
		while(!dead)
		{
			int hDmgDone = calculateHeroDamageDone(hero, monster);
			int mDmgDone = calculateMonsterDamageDone(monster, hero);
			
			System.out.println("You hit the monster for: " + hDmg + " damage with your " + hero.getWeapon().toString() + ". The monster blocks " 
			+ mResistanceValue + " damage. And suffers " + hDmgDone + " damage");
			System.out.println("The monster hits you for: " + mDmg + " with its' " + monster.getEquipment() + ". You block " + hResistanceValue + " damage. You suffer "
					+ mDmgDone + " damage.");
			monster.setHitPoints(monsterHit - hDmgDone);
			monsterHit = monster.getHitPoints();
			if(monsterHit > 0)
				System.out.println(monster.status());
			try {
				System.in.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(hero.getHitPoints() <= 0){
				System.out.println("You've died");
				heroWon = false;
				dead = true;
			}				
			if(monster.getHitPoints() <= 0)
			{
				System.out.println(monster.death());
				heroWon = true;
				dead = true;
				endOfCombat(monster);
			}
		}
	}
	
	//TODO create to hit methods, magic, ranged and melee...
	
	
	private int calculateHeroDamageDone(Hero h, GenericMonster m){
		// Take into account armor, magic resist, thoughness, that kinda of thing..
		hDmg = h.getWeapon().calculateDamageDelt();
		calcDef = new CalculateDefence(h.getWeapon(), m);
		int def = calcDef.getMonsterDefense();
		// Getting the defense value and type
		mResistance = calcDef.getMonsterDefType();
		mResistanceValue = calcDef.getMonsterDefValue();
		return (hDmg - def);
	}
	
	private int calculateMonsterDamageDone(GenericMonster m, Hero h){
		mDmg = m.getEquipment().calculateDamageDelt();
		calcDef = new CalculateDefence(m.getEquipment(), h);
		int def = calcDef.getHeroDefense();
		// Getting the defense value and stype
		hResistance = calcDef.getHeroDefType();
		hResistanceValue = calcDef.getHeroDefValue();
		return (mDmg - def);
	}

	public Boolean getHeroWon() {
		return heroWon;
	}

	public void setHeroWon(Boolean heroWon) {
		this.heroWon = heroWon;
	}
	
	public void endOfCombat(GenericMonster monster){
		String printLootText = "";
		int gold = monster.goldLoot();
		GenericConsumable consumable = monster.consumableLoot();
		GenericWeapon weapon = monster.weaponLoot();
		if(consumable == null)
			printLootText += "No consumables dropped. ";
		else
			printLootText += "The " + monster.toString() + " dropped a " + consumable.getName() +". ";
		if(weapon == null)
			printLootText += "No weapons dropped. ";
		else
			printLootText += "The " + monster.toString() + " dropped a " + weapon.getName() + ". ";
		printLootText += " And " + gold + " gold.";
		
		if(consumable != null)
			hero.inventory.addConsumableToInventory(consumable);
		if(weapon != null)
			hero.inventory.addWeaponToInventory(weapon);
		hero.setGold(gold);
		System.out.println("Hero gold: " + hero.getGold());
		System.out.println(printLootText);
	}
}
