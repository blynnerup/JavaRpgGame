package player;

import java.util.InputMismatchException;
import java.util.Scanner;

import weapons.GenericWeapon;

public class Paperdoll {

	Scanner scan = new Scanner(System.in);

	Boolean mainHandEquipped = false;
	Boolean offHandEquipped = false;
	Boolean twoHandEquipped = false;

	private GenericWeapon mHand;
	private GenericWeapon oHand;
	private GenericWeapon tHand;

	//TODO create methods for armour and other parts..
	public Paperdoll() {
		mHand = null;
		oHand = null;
		tHand = null;
	}

	public Boolean equipWeapon(GenericWeapon weapon, Inventory inv){
		Boolean weaponEquipped = false;
		if(weapon.getMainHand() && weapon.getOffHand()){
			System.out.println("The " + weapon.toString() + " can go in both hands, where would you like to equip it?");
			Boolean validSelection = false;
			int selection = 0;
			while(!validSelection){
				try{
					selection = scan.nextInt();
				}
				catch(InputMismatchException e){
					System.out.println("Not a valid selection!");
				}
				scan.nextLine();
				
				switch (selection) {
				case 1:
					if(!mainHandEquipped){
						mHand = weapon;
						mainHandEquipped = true;
						inv.removeWeaponFromInventory(weapon);
						validSelection = true;
						weaponEquipped = true;
					}
					else{
						System.out.println("You already have a " + mHand.toString() + " equipped in your offhand, would you like to replace it with " + weapon.toString() + " ? (y/n)");
						while(!scan.hasNext("[yn]")){
							System.out.println("Not a valid choice.");
							scan.next();
						}
						String stringselect = scan.next();
						if(stringselect.equals("y")){
							inv.addWeaponToInventory(mHand);
							mHand = weapon;
							inv.removeWeaponFromInventory(weapon);
							validSelection = true;
							weaponEquipped = true;
						}
						else{
							validSelection = true;
						}
					}
					break;
				case 2:
					if(!offHandEquipped){
						oHand = weapon;
						offHandEquipped = true;
						inv.removeWeaponFromInventory(weapon);
						validSelection = true;
						weaponEquipped = true;
					}
					else{
						System.out.println("You already have a " + oHand.toString() + " equipped in your offhand, would you like to replace it with " + weapon.toString() + " ? (y/n)");
						while(!scan.hasNext("[yn]")){
							System.out.println("Not a valid choice.");
							scan.next();
						}
						String stringselect = scan.next();
						if(stringselect.equals("y")){
							inv.addWeaponToInventory(oHand);
							oHand = weapon;
							inv.removeWeaponFromInventory(weapon);
							validSelection = true;
							weaponEquipped = true; 
						}
						else{
							validSelection = true;
						}
					}
					break;
				default:
					break;
				}
			}
		}
		else{
			if(weapon.getOffHand()){
				if(!offHandEquipped){
					oHand = weapon;
					offHandEquipped = true;
					inv.removeWeaponFromInventory(weapon);
					weaponEquipped = true;
				}
				else{
					System.out.println("You already have a " + oHand.toString() + " equipped in your offhand, would you like to replace it with " + weapon.toString() + " ? (y/n)");
					while(!scan.hasNext("[yn]")){
						System.out.println("Not a valid choice.");
						scan.next();
					}
					String selection = scan.next();
					if(selection.equals("y")){
						inv.addWeaponToInventory(oHand);
						oHand = weapon;
						inv.removeWeaponFromInventory(weapon);
						weaponEquipped = true;
					}
				}
			}
			if(weapon.getTwoHanded()){
				if(!twoHandEquipped){
					tHand = weapon;
					twoHandEquipped = true;
					inv.removeWeaponFromInventory(weapon);
					weaponEquipped = true;
				}
				else{
					System.out.println("You already have a " + tHand.toString() + " equipped in your offhand, would you like to replace it with " + weapon.toString() + " ? (y/n)");
					while(!scan.hasNext("[yn]")){
						System.out.println("Not a valid choice.");
						scan.next();
					}
					String selection = scan.next();
					if(selection.equals("y")){
						inv.addWeaponToInventory(tHand);
						tHand = weapon;
						inv.removeWeaponFromInventory(weapon);
						weaponEquipped = true;
					}
				}
			}
			else
				if(!mainHandEquipped){
					mHand = weapon;
					mainHandEquipped = true;
					inv.removeWeaponFromInventory(weapon);
					weaponEquipped = true;
				}
				else{
					System.out.println("You already have a " + mHand.toString() + " equipped in your offhand, would you like to replace it with " + weapon.toString() + " ? (y/n)");
					while(!scan.hasNext("[yn]")){
						System.out.println("Not a valid choice.");
						scan.next();
					}
					String selection = scan.next();
					if(selection.equals("y")){
						inv.addWeaponToInventory(tHand);
						mHand = weapon;
						inv.removeWeaponFromInventory(weapon);
						weaponEquipped = true;
					}
				}
		}
		return weaponEquipped;
	}
	
	// TODO Test method, remove.
	public void printEquipment(){
		System.out.println("In your main hand: " + mHand.getName());
	}
}


