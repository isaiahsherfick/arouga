import java.util.*;
public class Character
{
	
	private int health;
	private int maxHealth;
	private boolean isAlive;
	private ArrayList<Item> inventory;
	private ComparablePhrases identifiablePhrases;
	private String name;
	private Weapon equippedWeapon;
		
	public Character(int health, int maxHealth, ArrayList<Item> inventory, ComparablePhrases identifiablePhrases, String name, Weapon equippedWeapon)
	{
		this.health = health;
		this.maxHealth = maxHealth;
		this.inventory = inventory;
		this.identifiablePhrases = identifiablePhrases;
		this.name = name;
		this.equippedWeapon = equippedWeapon;
	}

	public Character(int health, int maxHealth, String name, Weapon equippedWeapon)
	{
		this.health = health;
		this.maxHealth = maxHealth;
		this.inventory = new ArrayList<Item>();
		this.identifiablePhrases = new ComparablePhrases();
		this.name = name;
		this.equippedWeapon = equippedWeapon;
	}

	//Default constructor just for test environments
	public Character()
	{
		this.health = 100;
		this.maxHealth = 100;
		this.identifiablePhrases = new ComparablePhrases();
		this.name = "Test Character";
		this.equippedWeapon = null;
	}
	
	public int getHealth()
	{
		return this.health;
	}

	public void setHealth(int health)
	{
		this.health = health;
	}

	public void takeDamage(int amount)
	{
		if (this.isAlive)
		{
			this.health -= amount;
		}
	}

	public void heal(int amount)
	{
		if (this.isAlive)
		{
			this.health += amount;
		}
	}

	public void resetHealth()
	{
		if (this.isAlive)
		{
			this.health = this.maxHealth;
		}
	}

	public int getMaxHealth()
	{
		return this.maxHealth;
	}

	public void setMaxHealth(int maxHealth)
	{
		this.maxHealth = maxHealth;
	}

	public ArrayList<Item> getInventory()
	{
		return this.inventory;
	}

	public void addToInventory(Item newItem)
	{
		this.inventory.add(newItem);
	}

	public Item getFromInventory(int index)
	{
		if (this.inventory.size() > index)
		{
			return this.inventory.get(index);
		}
		else
		{
			return null;
		}
	}

	public ComparablePhrases getIdentifiablePhrases()
	{
		return this.identifiablePhrases;
	}

	public void setComparablePhrases(ComparablePhrases identifiablePhrases)
	{
		this.identifiablePhrases = identifiablePhrases;
	}
	 
	public Weapon getEquippedWeapon()
	{
		return this.equippedWeapon;
	}

	//Need an attack function after other classes are finished

	public void setEquippedWeapon(Weapon equippedWeapon)
	{
		this.equippedWeapon = equippedWeapon;
	}

	public void equip(Weapon weapon)
	{
		this.equippedWeapon = weapon;
	}
}
