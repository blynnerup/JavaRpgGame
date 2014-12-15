package gameLogic;

import java.util.InputMismatchException;
import java.util.Scanner;

import player.Hero;

public class MainMenu {
	
	private Boolean _validMainMenuSelection = false;
	Boolean mainRunning = true;
	
	/**
	 * Loads the main menu and runs it until a valid selection has been made.
	 */
	public void loadMainMenu(){
		Scanner scan = new Scanner(System.in);
		while (!_validMainMenuSelection)
		{
			System.out.println("What do you want to do (pick a number)?");
			System.out.println("1. Play a new game.");
			System.out.println("2. Load a saved game.");
			System.out.println("3. Quit the game.");
			int selection = 0;
			try{
				selection = scan.nextInt();
			}
			catch (InputMismatchException e)
			{
				System.out.println("Input not valid!");
			}
			scan.nextLine();
			switch(selection){
			case 1:
				newGame();
				_validMainMenuSelection = true;
				break;
			case 2:
				loadGame();
				break;
			case 3: 
				quitGame();
				_validMainMenuSelection = true;
				break;
			default:
				System.out.println("Please enter a valid number!");
				break;					
			}
			
		}
		scan.close();
	}
	
	/*
	 * Start a new game.
	 */
	private void newGame(){
		if(mainRunning){
			CreateNewHero cnh = new CreateNewHero();
			Hero hero = new Hero();
			hero = cnh.CreateHero();
			//TODO Handle the logic of returning from the game to the main menu ect.
			MainLogic main = new MainLogic();
			main.beginNewGame(hero);
		}			
		else
			System.out.println("Bye!");
	}
	
	/*
	 * Load a saved game.
	 */
	private void loadGame(){
		System.out.println("Game won't be loaded, this functionality isn't implemented!");
		//TODO implement this
		MainLogic main = new MainLogic();
		// load hero from save..
		Hero h = new Hero();
		main.continueSavedGame(h);
	}
	
	/*
	 * Quit the game. 	
	 */
	private void quitGame(){
		System.out.println("Quitting the game. . .");
		mainRunning = false;
		newGame();
	}
}
