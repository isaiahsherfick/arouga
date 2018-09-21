import java.util.*;
import java.lang.*;
public class MainDriver
{
	public static void main(String[] args)
	{
		//Create menuDriver object to control the start menu and the pause menu
		MenuDriver menuDriver = new MenuDriver();

		//This starts the game and stores either 1, 2, 3, or 4 in startGame
		int startGame = menuDriver.startGame();

		switch(startGame)
		{
			case 1:
				//Start a new game
				System.out.printf("Starting a new game!\n");
				break;
			case 2:
				//Load a saved game
				System.out.printf("Loading a saved game!\n");
				break;
			case 3:
				//Display about information
				System.out.printf("About!\n");
				break;
			case 4:
				System.exit(1);
		}
	}
}
