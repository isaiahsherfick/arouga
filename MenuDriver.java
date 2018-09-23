//Needed to call the sleep function
import java.lang.*;
import java.util.*;
public class MenuDriver implements Runnable
{
	//Needed to call sleep function
	Thread t;

	//Constructor
	//@return A new MenuDriver object
	public MenuDriver()
	{
		//nothing in here because there's no data to be stored
	}

	private void printFiveLines()
	{
		for (int i = 0; i<5; i++)
		{
			System.out.printf("\n");
		}
	}
	
	private void clearTerminal()
	{
		for (int i = 0; i<100; i++)
		{
			System.out.printf("\n");
		}
	}

	//Method that will be called at the start of the game
	//@return 1 if user wants to start a new game, 2 if user wants to load a saved game, 3 if user wants to view about, 4 if user wants to exit the game
	public int startGame()
	{

		while (true)
		{
			//Looks nice
			this.printFiveLines();
			//Print initial welcome message
			System.out.printf("\tWelcome to Arouga!\n");

			//Will be used to fetch user input
			Scanner input = new Scanner(System.in);	
			
			System.out.printf("\t1.\tNew Game\n");
			System.out.printf("\t2.\tLoad Game\n");
			System.out.printf("\t3.\tAbout\n");
			System.out.printf("\t4.\tExit Game\n");
			this.printFiveLines();

			int userInput = 0;
			
			try
			{
 				userInput = input.nextInt();
			}

			catch(Exception e)
			{
				//Need to do this to prevent an error
				input.next();
			}

			switch(userInput)
			{
				case(1):
					return 1;
				case(2):
					return 2;
				case(3):
					return 3;
				case(4):
					return 4;
				case(69):
					System.out.printf("Heh. Nice.\n");
					try
					{
						Thread.sleep(1000);
					}
					catch(Exception e)
					{
						System.out.println("e");
					}
				default:
			}
			this.clearTerminal();
		}
	}

	//Method that will be used to pause the game. 
	public int pauseGame()
	{
		Scanner input = new Scanner(System.in);

		while(true)
		{
			this.clearTerminal();
			System.out.printf("\tPause\n");
			this.printFiveLines();
			System.out.printf("\t1. Save Game\n");
			System.out.printf("\t2. Load Game\n");
			System.out.printf("\t3. Resume Game\n");
			System.out.printf("\t4. Save Game\n");
			this.printFiveLines();

			int userInput = 0;

			try
			{
 				userInput = input.nextInt();
			}

			catch(Exception e)
			{
				//Need to do this to prevent an error
				input.next();
			}

			switch(userInput)
			{
				case(1):
					return 1;
				case(2):
					return 2;
				case(3):
					return 3;
				case(4):
					return 4;
				case(69):
					System.out.printf("Heh. Nice.\n");
					try
					{
						Thread.sleep(1000);
					}
					catch(Exception e)
					{
						System.out.println("e");
					}
				default:
			}
			this.clearTerminal();
		}

	}

	//This just needs to be overriden to implement Runnable which is needed for the sleep function
	public void run()
	{

	}
	//Main just for bugtesting
	/*
	public static void main(String[] args)
	{
		MenuDriver menu = new MenuDriver();
		menu.pauseGame();
	}
	*/
}
