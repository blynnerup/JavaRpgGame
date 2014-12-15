package consumables;

public class ManaPotion extends GenericConsumable {

	public ManaPotion() {
		this.setBasicCost(0);
		this.setInstantHealthRegain(0);
		this.setInstantManaRegain(5);
		this.setLevel(1);
		this.setName("Mana Potion");
	}
	
	@Override
	public String toString(){
		return "mana potion";
	}

}
