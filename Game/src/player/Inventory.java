package player;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import consumables.GenericConsumable;
import weapons.GenericWeapon;

public class Inventory {

	public ArrayList<GenericWeapon> weaponsInInventory;
	public ArrayList<GenericConsumable> consumablesInInventory;

	Scanner scan = new Scanner(System.in);

	public Inventory() {
		weaponsInInventory = new ArrayList<GenericWeapon>();
		consumablesInInventory = new ArrayList<GenericConsumable>();
	}

	public int inventoryMenu(){
		System.out.println("What do you want to do?\n1.Check your inventory.\n2.Equip item.\n3.Quit the inventory.");
		int selection = 0;
		boolean validSelection = false;
		while(!validSelection){
			try{
				selection = scan.nextInt();
			}
			catch(InputMismatchException e){
				System.out.println("Error getting user input!");
			}
			switch (selection) {
			case 1:
				String itemList = listInventoryItems();
				System.out.println(itemList);
				validSelection = true;
				break;
			case 2:
				validSelection = true;
				break;
			case 3:
				validSelection = true;
				break;
			 default:
				System.out.println("Bad input!");
				break;
			}
		}
		return selection;
	}

	public void addWeaponToInventory(GenericWeapon weap){
		weaponsInInventory.add(weap);
	}

	public void addConsumableToInventory(GenericConsumable cons){
		consumablesInInventory.add(cons);
	}

	public void removeWeaponFromInventory(GenericWeapon weap){
		weaponsInInventory.remove(weap);
	}

	public void removeConsumableFromInventory(GenericConsumable cons){
		consumablesInInventory.remove(cons);
	}

	public int sellWeapon(int index){
		GenericWeapon weap = weaponsInInventory.get(index);
		System.out.println("You have sold your " + weap.toString() + " for " + weap.getGoldValue() +" gold.");
		weaponsInInventory.remove(index);
		return weap.getGoldValue();
	}

	public int sellConsumable(int index){
		GenericConsumable cons = consumablesInInventory.get(index);
		System.out.println("You have sold your " + cons.toString() + " for " + cons.getGoldValue() + " gold.");
		consumablesInInventory.remove(index);
		return cons.getGoldValue();
	}

	/*
	 * Lists all items in the inventory.
	 * @returns Items in inventory.
	 */
	public String listInventoryItems(){
		String items = "";
		if(weaponsInInventory.size() == 0 && consumablesInInventory.size() == 0)
			return "Your inventory is empty.";
		if(weaponsInInventory.size() == 0){
			for(GenericConsumable cons : consumablesInInventory)
				items += "A " + cons.getName() + ". ";
			return items;			
		}
		if(consumablesInInventory.size() == 0){
			for(GenericWeapon weap : weaponsInInventory)
				items += "A " + weap.getName() + ". ";
			return items;
		}
		else{
			for(GenericConsumable cons: consumablesInInventory)
				items += "A " + cons.getName() + ". ";
			for(GenericWeapon weap : weaponsInInventory)
				items += "A " + weap.getName() + ". ";
			return items;
		}
	}

	public GenericWeapon selectWeaponFromInventory(){
		GenericWeapon weap = null;
		Boolean validSelection = false;
		int selection = 0;
		System.out.println("Select item.");
		for (int i = 0; i < weaponsInInventory.size(); i++){
			System.out.print((i + 1) +". " + weaponsInInventory.get(i).getName() + "\n");
		}
		if(weaponsInInventory.size() != 0){
			while(!validSelection){
				try{
					selection = scan.nextInt();
				}
				catch(InputMismatchException e){
					System.out.println("Error occured when selecting item!");
				}
				if(selection > 0  && selection <= weaponsInInventory.size()){
					weap = weaponsInInventory.get(selection - 1);
					validSelection = true;
				}
			}
		}
		return weap;
	}

}
