package player;

import java.util.ArrayList;

import consumables.GenericConsumable;
import weapons.GenericWeapon;

public class Inventory {

	ArrayList<GenericWeapon> weaponsInInventory;
	ArrayList<GenericConsumable> consumablesInInventory;
	
	public Inventory() {
		weaponsInInventory = new ArrayList<GenericWeapon>();
		consumablesInInventory = new ArrayList<GenericConsumable>();
	}
	
	public void addWeaponToInventory(GenericWeapon weap){
		weaponsInInventory.add(weap);
		System.out.println("The " + weap.toString() + " has been placed in your inventory.");
	}
	
	public void addConsumableToInventory(GenericConsumable cons){
		consumablesInInventory.add(cons);
		System.out.println("The " + cons.toString() + " has been placed in your inventory.");
	}
	
	public int sellWeapon(GenericWeapon weap){
		System.out.println("You have sold your " + weap.toString() + " for " + weap.getGoldValue() +" gold.");
		weaponsInInventory.remove(weap);
		return weap.getGoldValue();
	}
	
	public int sellConsumable(GenericConsumable cons){
		System.out.println("You have sold your " + cons.toString() + " for " + cons.getGoldValue() + " gold.");
		consumablesInInventory.remove(cons);
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

}
