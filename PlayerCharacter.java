import java.util.*;
public class PlayerCharacter extends Character
{
	private ArrayList<Room> exploredRooms;

	public PlayerCharacter(int health, ArrayList<Item> inventory, String name, Weapon equippedWeapon, ComparablePhrases identifiablePhrases, ArrayList<Room> exploredRooms)
	{
		super(health, inventory, name, equippedWeapon, identifiablePhrases);
		this.exploredRooms = exploredRooms;
	}

	public ArrayList<Room> getExploredRooms()
	{
		return this.exploredRooms;
	}

	public void addRoomToExploredRooms(Room room)
	{
		this.exploredRooms.add(room);	
	}
}
