package weapons;

public class GenericWeapon {

	private String name = "";
	private String damageType = "";
	private String baseDamage = "";
	private Boolean Ranged = false;
	private int level = 1;
	private Boolean twoHanded = false;
	private String Description = "";
	private int goldValue = 0;
	private Boolean offHand = false;
	private Boolean mainHand = false;
	
	//TODO durability? class limitations?...ect
	
	public GenericWeapon() {
	}
	
	public int calculateDamageDelt(){
		int damageDelt = 0;
		
		return damageDelt;
	}
	
	public void damageModifier(int strengthMod){
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDamageType() {
		return damageType;
	}

	public void setDamageType(String damageType) {
		this.damageType = damageType;
	}

	public String getBaseDamage() {
		return baseDamage;
	}

	public void setBaseDamage(String baseDamage) {
		this.baseDamage = baseDamage;
	}

	public Boolean getRanged() {
		return Ranged;
	}

	public void setRanged(Boolean ranged) {
		Ranged = ranged;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Boolean getTwoHanded() {
		return twoHanded;
	}

	public void setTwoHanded(Boolean twoHanded) {
		this.twoHanded = twoHanded;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public int getGoldValue() {
		return goldValue;
	}

	public void setGoldValue(int goldValue) {
		this.goldValue = goldValue;
	}

	public Boolean getOffHand() {
		return offHand;
	}

	public void setOffHand(Boolean offHand) {
		this.offHand = offHand;
	}

	public Boolean getMainHand() {
		return mainHand;
	}

	public void setMainHand(Boolean mainHand) {
		this.mainHand = mainHand;
	}
}
