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
	 * @return PlayerCount
	 */
	public int getPlayerCount() {
		return PlayerCount;
	}

	/**
	 * gibt den ersten Sitzplatz zurück
	 * 
	 * @return placeOne
	 */
	public Player getPlaceOne() {
		return PlaceOne;
	}

	/**
	 * gibt den zweiten Sitzplatz zurück
	 * 
	 * @return PlaceTwo
	 */
	public Player getPlaceTwo() {
		return PlaceTwo;
	}

	/**
	 * gibt den dritten Sitzplatz zurück
	 * 
	 * @return PlaceThree
	 */
	public Player getPlaceThree() {
		return PlaceThree;
	}

	/**
	 * gibt den vierten Sitzplatz
	 * 
	 * @return PlaceFour
	 */
	public Player getPlaceFour() {
		return PlaceFour;
	}

	/**
	 * gibt den fünften Sitzplatz zurück
	 * 
	 * @return PlaceFive
	 */
	public Player getPlaceFive() {
		return PlaceFive;
	}

	/**
	 * gibt den sechsten Sitzplatz zurück
	 * 
	 * @return PlaceSix
	 */
	public Player getPlaceSix() {
		return PlaceSix;
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
		PlayerCount++;
	}

	/**
	 * setzt einen Spieler auf den zweiten Platz
	 * 
	 * @param pPlayer
	 */
	public void setPlaceTwo(Player pPlayer) {
		PlaceTwo = pPlayer;
		PlayerCount++;
	}

	/**
	 * setzt einen Spieler auf den dritten Platz
	 * 
	 * @param pPlayer
	 */
	public void setPlaceThree(Player pPlayer) {
		PlaceThree = pPlayer;
		PlayerCount++;
	}

	/**
	 * setzt einen Spieler auf den vierten Platz
	 * 
	 * @param pPlayer
	 */
	public void setPlaceFour(Player pPlayer) {
		PlaceFour = pPlayer;
		PlayerCount++;
	}

	/**
	 * setzt einen Spieler auf den fünften Platz
	 * 
	 * @param pPlayer
	 */
	public void setPlaceFive(Player pPlayer) {
		PlaceFive = pPlayer;
		PlayerCount++;
	}

	/**
	 * setzt einen Spieler auf den sechsten Platz
	 * 
	 * @param pPlayer
	 */
	public void setPlaceSix(Player pPlayer) {
		PlaceSix = pPlayer;
		PlayerCount++;
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
