package zones;

import gameLogic.Combat;
import monsters.GenericMonster;
import monsters.Orc;
import player.Hero;

// First instance to go to.. Mainly for testing out basic stuff
public class TheVillage {
	
	
	public TheVillage(Hero hero)
	{
		System.out.println("After a long day of traveling you near the village Hout. From the village you can hear screaming, and you rush forward to investigate." +
				" From the village there is the sound people screaming and a growling voice that screams: \"Flee humans!\", no doubt an orc.." + 
				" You prepare yourself to face the orc and charge into the village.");
		
		beginCombat(hero);
	}
	
	private void beginCombat(Hero hero)
	{
		System.out.println("You charge into the orc head on..");
		GenericMonster orc = new Orc();
		Combat comb = new Combat(hero, orc);
		if(comb.getHeroWon())
			System.out.println("You have saved the village from this vicious orc!");
		else
			System.out.println("You have failed, as your life runs out, you hear the orc laugh at you..");
	}
}
