import java.io.Serializable;

public class Item implements Serializable{
String name;
String descr;
	public Item(String aName, String aDesc) {
		name = aName;
		descr = aDesc;
	}
	
	public String getName()
	{
		return name;
	}
	public String getDescr()
	{
		return descr;
	}
}
