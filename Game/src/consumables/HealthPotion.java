package consumables;

public class HealthPotion extends GenericConsumable {

	public HealthPotion() {
		this.setName("Health Potion");
		this.setBasicCost(0);
		this.setInstantHealthRegain(5);
		this.setInstantManaRegain(0);
		this.setLevel(1);
	}
	
	@Override
	public String toString(){
		return "health potion";
	}

}
