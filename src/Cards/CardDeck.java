package Cards;

import java.util.ArrayList;

/**
 * Ein Karten-deck besteht aus 52 Karten aus französischen Spielkarten von 2 bis
 * Ass
 * 
 * @author tamlyn.brandau / erik.meier / elias.grage
 * @version NOV2017
 */
public class CardDeck {

	ArrayList<Card> deck;

	/**
	 * Es wird eine ArrayList initialisiert, vom Typ Card, die 52 Objekte
	 * beinhalted.
	 */
	public CardDeck() {
		deck = new ArrayList<Card>();
		this.fillDeck();
	}

	/**
	 * Das Deck wird mit 52 karten aufgefüllt.
	 */
	public void fillDeck() {
		String[] lType = new String[13];
		lType[0] = "Zwei";
		lType[1] = "Drei";
		lType[2] = "Vier";
		lType[3] = "Fuenf";
		lType[4] = "Sechs";
		lType[5] = "Sieben";
		lType[6] = "Acht";
		lType[7] = "Neun";
		lType[8] = "Zehn";
		lType[9] = "Bube";
		lType[10] = "Dame";
		lType[11] = "Koenig";
		lType[12] = "Ass";

		String[] lColour = new String[4];
		lColour[0] = "Kreuz";
		lColour[1] = "Pik";
		lColour[2] = "Herz";
		lColour[3] = "Karo";

		for (int i = 0; i < lType.length; i++) {
			for (int j = 0; j < lColour.length; j++) {
				deck.add(new Card(lColour[j], lType[i]));
			}
		}
	}
	
	/**
	 * gibt das Deck zurück
	 * @return deck
	 */
	public ArrayList<Card> getDeck() {
		return deck;
	}

}
