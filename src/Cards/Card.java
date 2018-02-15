package Cards;
/**
 * Klasse repräsentiert die Karte des Decks mit jeweiligen Attributen
 * @author tamlyn.brandau / erik.meier / elias.grage
 * @version NOV2017
 */
public class Card {
	
	private String type = "";
	private String colour = "";
	
	public Card(String pColour, String pType) {
		colour = pColour;
		type = pType;
	}
//test
	/**
	 * gibt Typ zurück
	 * @return type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * gibt Farbe zurück
	 * @return colour
	 */
	public String getColour() {
		return colour;
	}
	
	/**
	 * setzt Farbe auf pColour
	 * @param pColour
	 */
	public void setColour(String pColour) {
		colour = pColour;
	}
	
	/**
	 * setzt Typ auf pType
	 * @param pType
	 */
	public void setType(String pType) {
		type = pType;
	}
	
	
}
