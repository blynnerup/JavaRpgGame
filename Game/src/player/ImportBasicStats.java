package player;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import weapons.BasicFireWand;
import weapons.GenericWeapon;
import weapons.RustySword;
import weapons.WornMace;

public class ImportBasicStats {

	public Hero importStats(Hero hero, String selection) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("classes.xml");
			NodeList classList = doc.getElementsByTagName("class");
			for (int i = 0; i < classList.getLength(); i++) {
				Node c = classList.item(i);
				if (c.getNodeType() == Node.ELEMENT_NODE) {
					Element cls = (Element) c;
					String className = cls.getAttribute("id");
					if (className.equals(selection)) {
						NodeList statsList = cls.getChildNodes();
						for (int x = 0; x < statsList.getLength(); x++) {
							Node n = statsList.item(x);
							if (n.getNodeType() == Node.ELEMENT_NODE) {
								Element stat = (Element) n;
								switch (stat.getTagName()) {
								case "strength":
									hero.setStrength(Integer.parseInt(stat.getTextContent()));									
									break;
								case "intelligence":
									hero.setIntelligence(Integer.parseInt(stat.getTextContent()));
									break;
								case "wisdom":
									hero.setWisdom(Integer.parseInt(stat.getTextContent()));
									break;
								case "dexterity":
									hero.setDexterity(Integer.parseInt(stat.getTextContent()));
									break;
								case "charisma":
									hero.setDexterity(Integer.parseInt(stat.getTextContent()));
									break;
								case "hitPoints":
									hero.setHitPoints(Integer.parseInt(stat.getTextContent()));
									hero.maxHitPoints = hero.getHitPoints();
									break;
								case "stamina":
									hero.setStamina(Integer.parseInt(stat.getTextContent()));
									break;
								case "willpower":
									hero.setWillpower(Integer.parseInt(stat.getTextContent()));
									break;
								default:
									System.out.println("Error creating player stats! " + stat.getTagName());
									throw new Exception();									
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return hero;
	}
	
	public Hero equipBasicGear(Hero hero, String selection){
		GenericWeapon weapon;
		switch (selection) {
		case "Warrior":		
			weapon = new RustySword();
			hero.equipWeapon(weapon);
			break;
		case "Priest":
			weapon = new WornMace();
			hero.equipWeapon(weapon);
			break;
		case "Mage":
			weapon = new BasicFireWand();
			hero.equipWeapon(weapon);
			break;
		case "Rogue":
			weapon = new RustySword();
			hero.equipWeapon(weapon);
		default:
			System.out.println("Could not find the correct gear for this class?");
			break;
		}
		
		return hero;
	}

}