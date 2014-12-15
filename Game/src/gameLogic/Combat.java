package gameLogic;

import java.io.IOException;

import player.Hero;
import monsters.GenericMonster;

// Basic class to handle basic combat
public class Combat {
	//TODO finish this....
	Hero hero;
	GenericMonster monster;
	private Boolean heroWon = true;
	CalculateDefence calcDef;
	
	public Combat (Hero h, GenericMonster m){
		hero = h;
		monster  = m;
		System.out.println("You fight the " + monster.toString());
		System.out.println("Pulling out your " + hero.getWeapon().toString());
		slaying();
	}
	
	private void slaying(){
		Boolean dead = false;
		int monsterHit = monster.getHitPoints();
		while(!dead)
		{
			int hDmgDone = calculateHeroDamageDone(hero, monster);
			int mDmgDone = calculateMonsterDamageDone(monster, hero);
			
			System.out.println("You hit the monster for: " + hDmgDone + " damage with your " + hero.getWeapon().toString());
			System.out.println("The monster hits you for: " + mDmgDone + " with its' " + monster.getEquipment());
			monster.setHitPoints(monsterHit - hDmgDone);
			monsterHit = monster.getHitPoints();
			if(monsterHit > 0)
				System.out.println(monster.status());
			try {
				System.in.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
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
			}
		}
	}
	
	//TODO create to hit methods, ranged and melee...
	
	
	private int calculateHeroDamageDone(Hero h, GenericMonster m){
		// Take into account armor, magic resist, thoughness, that kinda of thing..
		int dmg = h.getWeapon().calculateDamageDelt();
		calcDef = new CalculateDefence(h.getWeapon(), m);
		int def = calcDef.getMonsterDefense();
		return (dmg - def);
	}
	
	private int calculateMonsterDamageDone(GenericMonster m, Hero h){
		int dmg = m.getEquipment().calculateDamageDelt();
		calcDef = new CalculateDefence(m.getEquipment(), h);
		int def = calcDef.getHeroDefense();
		return (dmg - def);
	}

	public Boolean getHeroWon() {
		return heroWon;
	}

	public void setHeroWon(Boolean heroWon) {
		this.heroWon = heroWon;
	}
	
}
