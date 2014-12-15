package gameLogic;

import player.Hero;
import player.ImportBasicStats;

import java.util.InputMismatchException;
import java.util.Scanner;

//Creates a new hero!
public class CreateNewHero {
	Scanner scan = new Scanner(System.in);
	public Hero CreateHero(){
		Hero hero = new Hero();
		hero = nameHero(hero);
		return hero;
	}
	
	private Hero nameHero(Hero h){
		System.out.println("What is your name hero?");
		h.setName(scan.next());
		selectClass(h);
		return h;
	}
	
	private Hero selectClass(Hero h){
		System.out.println("What class are you hero?");
		Boolean validSelection = false;
		int selection = 0;
		System.out.println("1. Warrior\n2. Priest\n3. Mage\n4. Rogue");
		while(!validSelection){
			try{
				selection = scan.nextInt();
			}
			catch(InputMismatchException e)
			{
				System.out.println("Not a valid input!\n Please try again.");
			}
			scan.nextLine();
			
			switch (selection) {
			case 1:
				h.setHeroClass("Warrior");
				validSelection = true;
				break;
			case 2:
				h.setHeroClass("Priest");
				validSelection = true;
				break;
			case 3:
				h.setHeroClass("Mage");
				validSelection = true;
				break;
			case 4:
				h.setHeroClass("Rogue");
				validSelection = true;
				break;
			default:
				System.out.println("Something went terribly wrong in creating a class...");
				break;
			}
		}
		ImportBasicStats importStats = new ImportBasicStats();
		importStats.importStats(h, h.getHeroClass());
		importStats.equipBasicGear(h, h.getHeroClass());
		return h;
	}
}
