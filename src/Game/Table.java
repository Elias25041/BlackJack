package Game;

/**
 * 
 * @author elias
 * @version 21DEZ17
 */
public class Table {

	private Player PlaceOne;
	private Player PlaceTwo;
	private Player PlaceThree;
	private Player PlaceFour;
	private Player PlaceFive;
	private Player PlaceSix;
	private Dealer PlaceDealer;
	private int PlayerCount;

	public Table(Dealer pDealer) {
		PlaceDealer = pDealer;
	}

	/**
	 * gibt die Anzahl der Spieler am Tisch zur�ck
	 * 
	 * @return PlayerCount
	 */
	public int getPlayerCount() {
		return PlayerCount;
	}
	
	public void addPlayerCount(int pPlayerCount) {
		PlayerCount += pPlayerCount;
		System.out.println("" + PlayerCount);
	}

	public Player getPlace(int placeNumber) {
		switch (placeNumber) {
		case 1:
			return PlaceOne;
		case 2:
			return PlaceTwo;
		case 3:
			return PlaceThree;
		case 4:
			return PlaceFour;
		case 5:
			return PlaceFive;
		case 6:
			return PlaceSix;
		default:
			return null;
		}
	}

	/**
	 * gibt den Dealer zurück
	 * 
	 * @return
	 */
	public Dealer getPlaceDealer() {
		return PlaceDealer;
	}

	/**
	 * setzt einen Spieler auf den ersten Platz
	 * 
	 * @param pPlayer
	 */
	public void setPlaceOne(Player pPlayer) {
		PlaceOne = pPlayer;
	}

	/**
	 * setzt einen Spieler auf den zweiten Platz
	 * 
	 * @param pPlayer
	 */
	public void setPlaceTwo(Player pPlayer) {
		PlaceTwo = pPlayer;
	}

	/**
	 * setzt einen Spieler auf den dritten Platz
	 * 
	 * @param pPlayer
	 */
	public void setPlaceThree(Player pPlayer) {
		PlaceThree = pPlayer;
	}

	/**
	 * setzt einen Spieler auf den vierten Platz
	 * 
	 * @param pPlayer
	 */
	public void setPlaceFour(Player pPlayer) {
		PlaceFour = pPlayer;
	}

	/**
	 * setzt einen Spieler auf den fünften Platz
	 * 
	 * @param pPlayer
	 */
	public void setPlaceFive(Player pPlayer) {
		PlaceFive = pPlayer;
	}

	/**
	 * setzt einen Spieler auf den sechsten Platz
	 * 
	 * @param pPlayer
	 */
	public void setPlaceSix(Player pPlayer) {
		PlaceSix = pPlayer;
	}

	/**
	 * setzt einen Dealer auf seinen Platz
	 * 
	 * @param pDealer
	 */
	public void setPlaceDealer(Dealer pDealer) {
		PlaceDealer = pDealer;
	}
}
