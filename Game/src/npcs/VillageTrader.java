package npcs;

import java.util.ArrayList;
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
	ArrayList<String> fullListOfItems;
	ArrayList<GenericWeapon> weaponsInInventory;
	ArrayList<GenericConsumable> consumablesInInventory;

	public VillageTrader(Hero hero){
		gold = 50;
		h = hero;
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
			System.out.println("1.Buy items.\n2.Sell items.\n3.Open your inventory\n4.Leave the shop.");
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
				populateItemLists();
				sellItemFromInventory();
				break;
			case 3:
				System.out.println(h.inventory.listInventoryItems());
				break;
			case 4:
				trading = false;
				break;
			default:
				System.out.println("Invalid selection.");
				break;
			}
		}
	}

	private void populateItemLists(){
		weaponsInInventory = new ArrayList<GenericWeapon>();
		consumablesInInventory = new ArrayList<GenericConsumable>();
		fullListOfItems = new ArrayList<String>();
		weaponsInInventory = h.inventory.weaponsInInventory;
		consumablesInInventory = h.inventory.consumablesInInventory;

		for(GenericWeapon weap : weaponsInInventory){
			fullListOfItems.add(weap.getName());
		}
		for(GenericConsumable cons : consumablesInInventory){
			fullListOfItems.add(cons.getName());
		}

		printSellableItems(fullListOfItems);
	}

	private void printSellableItems(ArrayList<String> items){
		for(int i = 0; i< items.size(); i++){
			System.out.println(i+1 + ". " + items.get(i));
		}		
	}

	private void sellItemFromInventory(){
		int indexes = 0;
		indexes = weaponsInInventory.size() + consumablesInInventory.size();
		if(indexes == 0){
			System.out.println("Nothing to sell.");
		}
		else{
			System.out.println("What item would you like to sell?");
			Boolean validSelection = false;
			int selection = 0;
			try{
				selection = scan.nextInt();
			}
			catch(InputMismatchException e){
				System.out.println("Invalid input.");
			}
			scan.nextLine();
			while(!validSelection){
				if(selection > 0 && selection <= indexes){
					if((selection) <= weaponsInInventory.size()){
						h.inventory.sellWeapon(selection - 1); 
						validSelection = true;
					}
					else{
						h.inventory.sellConsumable(selection - 1);
						validSelection = true;
					}
				}
			}
		}
	}

}
