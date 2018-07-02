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
	private Player [] player = new Player[6];

	public Table(Dealer pDealer) {
		PlaceDealer = pDealer;
		
	}

	/**
	 * gibt die Anzahl der Spieler am Tisch zurück
	 * 
	 * @return PlayerCount
	 */
	public int getPlayerCount() {
		return PlayerCount;
	}
	
	/**
	 * 
	 * @param pPlayerCount
	 */
	public void addPlayerCount(int pPlayerCount) {
		PlayerCount += pPlayerCount;
	}

	/**
	 * der Platz eines Spielers wird zurück gegeben
	 * 
	 * @param placeNumber
	 * @return PlaceOne || PlaceTwo || PlaceThree || PlaceFour || PlaceFive || PlaceSix
	 */
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
	 * gibt den Dealer zurueck
	 * 
	 * @return PlaceDealer
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
		player[0]=PlaceOne;
	}

	/**
	 * setzt einen Spieler auf den zweiten Platz
	 * 
	 * @param pPlayer
	 */
	public void setPlaceTwo(Player pPlayer) {
		PlaceTwo = pPlayer;
		player[1]=PlaceTwo;
	}

	/**
	 * setzt einen Spieler auf den dritten Platz
	 * 
	 * @param pPlayer
	 */
	public void setPlaceThree(Player pPlayer) {
		PlaceThree = pPlayer;
		player[2]=PlaceThree;
	}

	/**
	 * setzt einen Spieler auf den vierten Platz
	 * 
	 * @param pPlayer
	 */
	public void setPlaceFour(Player pPlayer) {
		PlaceFour = pPlayer;
		player[3]=PlaceFour;
	}

	/**
	 * setzt einen Spieler auf den fÃ¼nften Platz
	 * 
	 * @param pPlayer
	 */
	public void setPlaceFive(Player pPlayer) {
		PlaceFive = pPlayer;
		player[4]=PlaceFive;
	}

	/**
	 * setzt einen Spieler auf den sechsten Platz
	 * 
	 * @param pPlayer
	 */
	public void setPlaceSix(Player pPlayer) {
		PlaceSix = pPlayer;
		player[5]=PlaceSix;
	}

	/**
	 * setzt einen Dealer auf seinen Platz
	 * 
	 * @param pDealer
	 */
	public void setPlaceDealer(Dealer pDealer) {
		PlaceDealer = pDealer;
	}
	
	/**
	 * Der Gewinner kriegt den Inhalt des Pots gutgeschrieben
	 * @param winningPlayer
	 * @param potAmount
	 */
	public void getPaid(Player winningPlayer, int potAmount) {
		winningPlayer.getPaid(potAmount);
	}
	
	/**
	 * gibt den Spieler eines Platzes zurück
	 * 
	 * @param place
	 * @return Player
	 */
	public Player getPlayer(int place) {
		return player[place];
	}
}
