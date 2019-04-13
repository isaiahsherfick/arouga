import java.util.Hashtable;
public abstract class Character
{
    private String name;
    private int maxHealth;
    private int health;
    private Hashtable<Integer,Item> inventory;
    public Character(String name, int maxHealth)
    {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.inventory = new Hashtable<>();
    }
    public void pickUp(Item item)
    {
        this.inventory.put(item.getId(),item);
    }


    //returns true if successful, false otherwise
    public boolean use(int id)
    {
        //Item actually is the item type we are attempting to use
        if (inventory.get(id).getId() == id)
        {
            inventory.get(id).use();
            return true;
        }
        return false;
    }

    public boolean use(int id,Item object)
    {
        if (inventory.get(id).getId() == id && object instanceof Targetable)
        {
            inventory.get(id).use(object);
            return true;
        }
        return false;
    }
}

class NonPlayerCharacter extends Character
{
    public NonPlayerCharacter(String name, int maxHealth)
    {
        super(name,maxHealth);
    }
}


class PlayerCharacter extends Character
{
    public PlayerCharacter(String name, int maxHealth)
    {
        super(name, maxHealth);
    }
}