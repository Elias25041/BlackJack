package Game;

/**
 * 
 * @author tamlyn.brandau
 * @version 07DEZ17
 */
public class Bank {
	// das Guthaben der Bank
	private int credit;
	// der Wert der in der Mitte liegt
	private int pot;

	public Bank() {
		credit = 1000000;
	}

	/**
	 * Bank zahlt Gewinn aus.
	 */
	public int pay() {
		int i = pot;
		pot = 0;
		return i;
	}

	/**
	 * pot wird zurück gegeben
	 * 
	 * @return pot
	 */
	public int getPot() {
		return pot;
	}

	/**
	 * Bank erhaelt den Inhalt des Pots, wenn der Dealer gewinnt.
	 */
	public void getPaid() {
		credit = credit + pot;
		pot = 0;
	}

	/**
	 * es wird eine bestimmte Anzahl auf den Pot addiert
	 * 
	 * @param toAdd
	 */
	public void addPot(int toAdd) {
		pot += toAdd;
	}
}
