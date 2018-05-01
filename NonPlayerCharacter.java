import java.util.*;
public class NonPlayerCharacter extends Character
{
	private boolean friendly;
	private Queue<String> thingsToSay;
	private String finalThingToSay;

	public NonPlayerCharacter(int health, int maxHealth, ArrayList<Item> inventory, ComparablePhrases identifiablePhrases, String name, Weapon equippedWeapon, boolean friendly, Queue<String> thingsToSay)
	{
		super(health, maxHealth, inventory, identifiablePhrases, name, equippedWeapon);
		this.friendly = friendly;
		this.thingsToSay = thingsToSay;
		this.finalThingToSay = finalThingToSay;
	}

	public NonPlayerCharacter(int health, int maxHealth, String name, weapon equippedWeapon, boolean friendly, String finalThingToSay)
	{
		super(health, maxHealth, name, equippedWeapon);
		this.friendly = friendly;
		this.thingsToSay = new Queue<String>();
		this.finalThingToSay = finalThingToSay;
	}
	
	public isFriendly()
	{
		return this.friendly;
	}

	public makeHostile()
	{
		this.friendly = false;
	}

	public makeFriendly()
	{
		this.friendly = true;
	}

	public String talk()
	{
		if (this.thingsToSay.peek() != null)
		{
			return this.thingsToSay.poll();
		}
		else
		{
			return this.finalThingToSay;
		}
	}
}
