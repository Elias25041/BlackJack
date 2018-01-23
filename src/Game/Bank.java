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
		credit=1000000;
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
	 * Bank erhaelt den Inhalt des Pots, wenn der Dealer gewinnt.
	 */	
	public void getPaid() {
		
	}
}
