package consumables;

public class GenericConsumable {

	private int instantHealthRegain = 0;
	private int instantManaRegain = 0;
	private int basicCost = 0;
	private String name = "";
	private int level = 0;
	private int goldValue = 0;
	

	//TODO multiple uses? class limitations?..
	
	public GenericConsumable() {
	}

	public int getInstantHealthRegain() {
		return instantHealthRegain;
	}

	public void setInstantHealthRegain(int instantHealthRegain) {
		this.instantHealthRegain = instantHealthRegain;
	}

	public int getInstantManaRegain() {
		return instantManaRegain;
	}

	public void setInstantManaRegain(int instantManaRegain) {
		this.instantManaRegain = instantManaRegain;
	}

	public int getBasicCost() {
		return basicCost;
	}

	public void setBasicCost(int basicCost) {
		this.basicCost = basicCost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getGoldValue() {
		return goldValue;
	}

	public void setGoldValue(int goldValue) {
		this.goldValue = goldValue;
	}
}
