package npcs;

import java.util.InputMismatchException;
import java.util.Scanner;

import player.Hero;
import weapons.GenericWeapon;
import consumables.GenericConsumable;

//TODO Create the trader..

public class VillageTrader {

	private int gold = 0;
	Scanner scan = new Scanner(System.in);
	Hero h;
	
	public VillageTrader(Hero hero){
		gold = 50;
		h = hero;
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
	
	public void Greeting(){
		Boolean trading = true;
		System.out.println("Hello hero, what would you like to do?");
		while(trading){
			System.out.println("1.Buy items.\n2. Sell items.\n3.Leave the shop.");
			int selection = 0;
			try{
				selection = scan.nextInt();
			}
			catch(InputMismatchException e){
				System.out.println("Invalid key pressed!");
			}
			scan.nextLine();
			
			switch (selection) {
			case 1:
				//BUY
				break;
			case 2:
				//SELL
				break;
			case 3:
				trading = false;
				break;
			default:
				System.out.println("Invalid selection.");
				break;
			}
		}
	}

}
