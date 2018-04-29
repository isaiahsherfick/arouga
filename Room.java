import java.util.*;
public class Room
{

	private String description;
	private int[] location;
	//size 2 array
	private boolean locked;
	//These maps contain ComparablePhrases which are just comparable String arrays
	//In order for the user to be able to interact with Objects
	//Using multiple phrases that might be the player trying to reference them
	//I.E player inputs "pick up blade" in reference to a sword
	private TreeMap<ComparablePhrases, Character> inhabitants;
	private TreeMap<ComparablePhrases, Item> contents;

	public Room(String description, int[] location, boolean locked; TreeMap<ComparablePhrases, Character> inhabitants, TreeMap<ComparablePhrases, Item> contents)
	{
		this.description = description;
		this.locked = locked;
		this.inhabitants = inhabitants;
		this.contents = contents;
	}

	public String getDescription()
	{
		return this.description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public int[] getLocation()
	{
		return this.location;
	}

	public int getX()
	{
		return this.location[0];
	}

	public int getY()
	{
		return this.location[1];
	}

	public void setLocation(int[] location)
	{
		this.location = location;
	}

	public void setX(int x)
	{
		this.location[0] = x;
	}

	public void setY(int y)
	{
		this.location[1] = y;
	}

	public boolean isLocked()
	{
		return this.locked;
	}

	public void unlock()
	{
		this.locked = false;
	}

	public void lock()
	{
		this.locked = true;
	}

	public Character getInhabitantByPhrase(String phrase)
	{
		for (Map.Entry<ComparablePhrases, Character> entry : this.inhabitants.entrySet())
			//For every ComparablePhrases key in the inhabitants map
		{
			ComparablePhrases currentComparablePhrases = entry.getKey();
			for (String s : currentComparablePhrases)
			{
				if (phrase.toLowerCase().equals(s.toLowerCase()))
				{
					return entry.getValue();
				}
			}
			return null;
		}
	}

	public Item getItemByPhrase(String phrase)
	{
		for (Map.Entry<ComparablePhrases, Item> entry : this.contents.entrySet())
			//for every ComparablePhrases key in the contents map
		{
			ComparablePhrases currentComparablePhrases = entry.getKey();
			for (String s : currentComparablePhrases)
			{
				if (phrase.toLowerCase().equals(s.toLowerCase()))
				{
					return entry.getValue();
				}
			}
			return null;
		}
	}
}
