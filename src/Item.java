public abstract class Item
{
    private int id;
    private String name;

    public abstract void use();
    public Item(int id, String name)
    {
        this.id = id;
        this.name = name;

    }
    public int getId()
    {
        return id;
    }
}
