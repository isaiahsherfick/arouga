import java.lang.*;
import java.util.*;
public class ComparablePhrases implements Comparable
{
	private ArrayList<String> phrases;

	public ComparablePhrases(ArrayList<String> phrases)
	{
		this.phrases = phrases;
	}

	public ComparablePhrases()
	{
		this.phrases = new ArrayList<String>();
	}

	public ArrayList<String> getPhrases()
	{
		return this.phrases;
	}

	public void setPhrases(ArrayList<String> phrases)
	{
		this.phrases = phrases;
	}

	public void addPhrase(String phrase)
	{
		this.phrases.add(phrase);
	}

	@Override
	//Since this class really only needs to implement Comparable in order to be used in a map, it doesn't really matter if compareTo() actually does anything.
	public int compareTo(Object o)
	{
		return 0;
	}
}
