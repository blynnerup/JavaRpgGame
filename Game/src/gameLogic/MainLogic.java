package gameLogic;

import java.io.IOException;

import monsters.GenericMonster;
import monsters.Goblin;
import player.Hero;
import zones.TheVillage;

public class MainLogic {
	
	// While this is running the game is running, when set to false, the game exits to the main menu.
	public Boolean gameRunning = true;
	Hero h;
	
	/*
	 * Begins a new game
	 * @param hero The main antagonist of the game!
	 */
	public void beginNewGame(Hero hero){
		h = hero;
		while(gameRunning){
			firstEncounter();
		}
	}
	
	/*
	 * Continues the game from a saved state.
	 * @param hero The main antagonist of the game!
	 */
	public void continueSavedGame(Hero hero){
		h = hero;
		
		while(gameRunning){
			
		}
	}
	
	public void firstEncounter(){
		h.paperDoll.printEquipment();
		System.out.println("Headed out from your hometown towards the near village of Hout, you travel along the main road, when in the distance you see a small creature chasing a woman." + 
	"\nYou ready your " + h.getWeapon().toString() + " and charge ahead. As you get closer you see the creature is a goblin. The woman screams for help, and you rush in");
		GenericMonster gobbo = new Goblin();
		try {
			System.in.read();
		} catch (IOException e) {
			System.out.println("Something went bad when reading input.");
			e.printStackTrace();
		}
		 Combat cmb = new Combat(h, gobbo);
		 if(cmb.getHeroWon()){
			 System.out.println("The woman thanks you for aiding her and takes you to the village market.");
			 System.out.println("She gives you something to eat and you rest for a while.");
			 h.regainMaxHitPoints();
			 TheVillage village = new TheVillage(h);
			 village.villageMarket();			 
		 }
		 else{
			 gameRunning = false;
			 System.out.println("The goblin mocks you as you sink to the ground. Your adventure ends here.");
		 }
		
	}
	

}
