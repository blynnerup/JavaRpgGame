package player;

import java.util.ArrayList;

import consumables.GenericConsumable;
import weapons.GenericWeapon;

public class Inventory {

	public ArrayList<GenericWeapon> weaponsInInventory;
	public ArrayList<GenericConsumable> consumablesInInventory;
	
	public Inventory() {
		weaponsInInventory = new ArrayList<GenericWeapon>();
		consumablesInInventory = new ArrayList<GenericConsumable>();
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

}
