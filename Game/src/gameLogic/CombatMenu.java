package gameLogic;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CombatMenu {

	Scanner scan = new Scanner(System.in);
	public CombatMenu() {
	}
	
	public int menu(){
		int selection = 0;
		Boolean validAction = false;
		System.out.println("Action?");
		System.out.println("1.Fight\n2.Magic\n3.Inventory\n4.Run");
		while(!validAction){
			try{
				selection = scan.nextInt();
			}
			catch(InputMismatchException e)
			{
				System.out.println("Invalid input!");
			}
			scan.nextLine();
			
			switch (selection) {
			case 1:
				selection = 1;
				validAction = true;
				break;
			case 2:
				selection = 2;
				validAction = true;
				break;
			case 3:
				selection = 3;
				validAction = true;
				break;
			case 4:
				selection = 4;
				validAction = true;
				break;
			default:
				System.out.println("Invalid seletion!");
				break;
			}
		}
		return selection;
	}

}
