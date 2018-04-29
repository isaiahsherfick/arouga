import java.util.*;
public class Item
{
	private String description;
	private ComparablePhrases identifiablePhrases;
	private ComparablePhrases actionPhrases;

	public Item(String description, ComparablePhrases identifiablePhrases, ComparablePhrases actionPhrases)
	{
		this.description = description;
		this.identifiablePhrases = identifiablePhrases;
		this.actionPhrases = actionPhrases;
	}

	public Item(String description)
	{
		this.description = description;
		this.identifiablePhrases = new ComparablePhrases();
		this.actionPhrases = new ComparablePhrases();
	}

	public abstract void use() {}
	
	//This will call a specific method of child classes indended to be the default "use" method; swinging a sword, unlocking a door, drinking a potion, etc.

	public String getDescription()
	{
		return this.description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public ComparablePhrases getIdentifiablePhrases()
	{
		return this.identifiablePhrases;
	}

	public void setIdentifiablePhrases(ComparablePhrases identifiablePhrases) 
	{
		this.identifiablePhrases = identifiablePhrases;
	}

	public ComparablePhrases getActionPhrases()
	{
		return this.actionPhrases;
	}

	public void setActionPhrases(ComparablePhrases actionPhrases)
	{
		this.actionPhrases = actionPhrases;
	}
}
