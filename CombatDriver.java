import java.util.*;
import java.lang.*;
public class CombatDriver implements Runnable
{
	private ArrayList<Character> combatants;

	//Constructor for the CombatDriver class
	//@param combatants: an ArrayList containing characters, with the PlayerCharacter in the cell at index 0.
	//@return a new CombatDriver object
	public CombatDriver(ArrayList<Character> combatants)
	{
		this.combatants = combatants;	
	}

	//Just looks nice
	private void clearTerminal()
	{
		for (int i = 0; i < 100; i++)
		{
			System.out.printf("\n");
		}
	}

	//Same thing here
	private void printFiveLines()
	{
		for (int i = 0; i< 5; i++)
		{
			System.out.printf("\n");
		}
	}

	//Makes the Characters contained in combatants array fight each other
	public void engageCombat()
	{
		int numberOfCombatants = combatants.size();

		Scanner input = new Scanner(System.in);
	
		int userInput;

		while (numberOfCombatants > 1)
		{
			for (int i = 0; i < combatants.size(); i++)
			{
				//If it's the player's turn
				if (i == 0)
				{
					//Player's turn, need input
					
					this.clearTerminal();
					
					//Display information for user
					System.out.printf("Enemies:\n");

					//Start loop at 1 because we want to print the player's stats at the bottom
					for (int j = 1; j < combatants.size(); j++)
					{
						System.out.printf("%d: %s\tHealth: %d\n",j,combatants.get(i),combatants.get(i).getHealth());
					}	

					this.printFiveLines();
					System.out.printf("What would you like to do?\n");
					System.out.printf("1. Attack\n");
					System.out.printf("2. Use an item\n");
					System.out.printf("3. Run away\n");
					
					userInput = input.nextInt();

					System.out.printf("%d",userInput);

					this.printFiveLines();
					switch(userInput)
					{
						//User wants to attack
						case 1:
						{
							System.out.printf("Which enemy would you like to attack?\n");
							userInput = input.nextInt();
							boolean validInput = false;

							while (!validInput)
							{
								//User enters a value outside of the range of the array or their index in the array
								if (userInput < combatants.size() - 1 || userInput == 0)
								{
									System.out.printf("Please input the number to the left of the enemy you would like to attack.\n");
								}
								else if (combatants.get(userInput).getHealth() <= 0)
								{
									System.out.printf("Please input the number to the left of the enemy you would like to attack.\n");
								}
								else
								{
									validInput = true;
								}
							}

							//make the player's equipped weapon deal its damage to the enemy the user picked
							combatants.get(0).getEquippedWeapon().dealDamage(combatants.get(userInput));
							break;
						}

						//User wants to use an item
						case 2:
						{
							System.out.printf("2\n");
							break;
						}

						//User wants to run away
						case 3:
						{
							System.out.printf("3\n");
							break;
						}

					}

				}
				else
				{
					//Make sure the enemy isn't already dead
					if (combatants.get(i).getHealth() > 0)
					{
						//Enemy's turn, no input required
					}
				}
			}
		}
	}

	//needs to be overriden to implement Runnable
	public void run()
	{
	
	}

	//Main just for bugtesting
	public static void main(String[] args)
	{
		Character testCharacter = new Character();
		Character testCharacter2 = new Character();
		ArrayList<Character> combatants = new ArrayList<Character>();
		combatants.add(testCharacter);
		combatants.add(testCharacter2);
		CombatDriver driver = new CombatDriver(combatants);
		driver.engageCombat();
	}
}
