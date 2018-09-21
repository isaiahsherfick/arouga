import java.util.*;
import java.lang.*;
public class Weapon extends Item
{
	private int damage;
	private int durability;

	//Constructor for the weapon class
	//@param damage the damage the weapon will deal when used in an attack
	//@param durability unsure if this will actually matter
	//@return a new object of type weapon
	public Weapon(String description, String name, ComparablePhrases identifiablePhrases, ComparablePhrases actionPhrases, int damage, int durability)
	{
		super(description, name, identifiablePhrases, actionPhrases);
		this.damage = damage;
		this.durability = durability;
	}

	public void dealDamage(Character target)
	{
		System.out.printf("Dealt %d damage to %s!\n",this.damage,target);
		target.setHealth(target.getHealth() - this.damage);
	}

	public void use()
	{
		System.out.printf("Who would you like to use the %s on?\n", this.getName());
		Scanner input = new Scanner(System.in);
		String target = input.next();
		System.out.printf("Using the %s on %s", this.getName(), target);
	}
}
