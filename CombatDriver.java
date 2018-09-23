import java.util.*;
import java.lang.*;
public class CombatDriver implements Runnable
{
	private Character player;
	private Character enemy;
	//Needed to call the sleep function
	Thread t;

	//Constructor for the CombatDriver class
	//@param combatants: two Characters. The player, then the enemy.
	//@return a new CombatDriver object
	public CombatDriver(Character player, Character enemy)
	{
		this.player = player;	
		this.enemy = enemy;
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

	//this is the main block of combat information that will be displayed every turn
	private void displayInformation()
	{
		//Display information for user
		System.out.printf("Enemy %s:\n",enemy.getName());
		System.out.printf("Health: %d\n",enemy.getHealth());

		this.printFiveLines();
		
		System.out.printf("%s:\n",player.getName());
		System.out.printf("Health: %d\n",player.getHealth());
	}

	//Makes the Characters contained in combatants array fight each other
	public void engageCombat()
	{
		Scanner input = new Scanner(System.in);
	
		int userInput;

		//This will be used to keep track of whose turn it is. When 1 = 0, it's the player's turn. When i = 1, it's the enemy's.
		int i = 0;

		//While neither Character is dead
		while (player.getHealth() > 0 && enemy.getHealth() > 0)
		{
			//If it's the player's turn
			if (i == 0)
			{
				//Player's turn, need input
				
				this.clearTerminal();	

				System.out.printf("%s's turn.\n",player.getName());
				
				this.displayInformation();

				this.printFiveLines();
			
				System.out.printf("What will %s do?\n",player.getName());	

				this.printFiveLines();

				System.out.printf("1. Attack\n");
				System.out.printf("2. Use Item\n");
				System.out.printf("3. Run Away\n");

				this.printFiveLines();
					
				userInput = input.nextInt();

				//sleep function held together by duct tape
				try
				{
					Thread.sleep(2000);
				}
				catch(Exception e)
				{
					System.out.println("SLEEP ERROR");
				}
				//end sleep function held together by duct tape

				this.clearTerminal();

				this.displayInformation();

				this.printFiveLines();

				switch(userInput)
				{
					//User wants to attack
					case 1:
					{
						//calculate the damage
						int damage = player.getEquippedWeapon().getDamage();

						//debug
						System.out.printf("Dealing %d damage to enemy %d\n",damage,userInput);

						//sleep function held together by duct tape
						try
						{
							Thread.sleep(2000);
						}
						catch(Exception e)
						{
							System.out.println("SLEEP ERROR");
						}
						//end sleep function held together by duct tape

						//adjust the health of the target
						enemy.takeDamage(damage);
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
				
				//End the player's turn by switching i to 1
				i = 1;
			}

			//if it's the enemy's turn
			else if (i == 1)
			{
				this.clearTerminal();
				System.out.printf("%s's turn.\n",enemy.getName());
				this.displayInformation();

				//sleep function held together by duct tape
				try
				{
					Thread.sleep(2000);
				}
				catch(Exception e)
				{
					System.out.println("SLEEP ERROR");
				}
				//end sleep function held together by duct tape

				System.out.printf("The %s swings its %s at you!\n",enemy.getName(),enemy.getEquippedWeapon().getName());
				
				//sleep function held together by duct tape
				try
				{
					Thread.sleep(2000);
				}
				catch(Exception e)
				{
					System.out.println("SLEEP ERROR");
				}
				//end sleep function held together by duct tape
				
				//calculate the damage
				int damage = enemy.getEquippedWeapon().getDamage();

				System.out.printf("You take %d damage.\n", damage);

				player.takeDamage(damage);

				//sleep function held together by duct tape
				try
				{
					Thread.sleep(2000);
				}
				catch(Exception e)
				{
					System.out.println("SLEEP ERROR");
				}
				//end sleep function held together by duct tape

				//end the enemy's turn by setting i to 0, making it the player's turn 
				i = 0;
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
		Character player = new Character();
		ComparablePhrases whatever = new ComparablePhrases();
		Weapon testWeapon = new Weapon("A test weapon", "sword", whatever, whatever, 5, 10);
		Character enemy = new Character();
		player.setEquippedWeapon(testWeapon);
		enemy.setEquippedWeapon(testWeapon);
		CombatDriver driver = new CombatDriver(player, enemy);
		driver.engageCombat();
	}
}
