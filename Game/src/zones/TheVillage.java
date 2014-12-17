package zones;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import npcs.VillageTrader;
import player.Hero;
import weapons.GenericWeapon;

// First instance to go to.. Mainly for testing out basic stuff
public class TheVillage {

	Hero h;
	Scanner scan = new Scanner(System.in);
	Boolean validSelection = false;

	public TheVillage(Hero hero) {
		System.out
				.println("You stand in the center of the market in the village Hout, what do you want to do?");
		h = hero;
	}

	/*
	 * The village market, default return place in the village.
	 */
	public void villageMarket() {
		System.out.println("1. Buy or sell goods.\n2. Look for adventure.\n3. Equip items");
		while (!validSelection) {
			int selection = 0;
			try {
				selection = scan.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid key pressed.");
			}
			scan.nextLine();

			switch (selection) {
			case 1:
				System.out.println("You go to the local merchant.");
				validSelection = true;
				goTrade(h);
				break;
			case 2:
				// TODO Create looking for adventure post
				System.out.println("You go looking for adventure.");
				validSelection = true;
				break;
			case 3:
				equipWeapon();
				validSelection = true;
				break;
			default:
				System.out.println("Not a valid number!");
				break;
			}
		}
	}
	
	private void goTrade(Hero hero){
		VillageTrader trader = new VillageTrader(hero);
		trader.Greeting();
	}
	
	//TODO Redo this so that equipping items is done correctly..
	private void equipWeapon(){
		ArrayList<GenericWeapon> weapons = new ArrayList<GenericWeapon>();
		weapons = h.inventory.weaponsInInventory;
		h.equipWeapon(weapons.get(0));
	}
}
