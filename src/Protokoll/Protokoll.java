package Protokoll;
/**
 * Diese Zeichenketten werden zwischen Client und Server ausgetauscht.
 * 
 * @author Erik 
 * @version 15DEC17
 */
public class Protokoll {
	
	//-----------------------------------------General-----------------------------------------
	
	public static final String TRENNER = ":"; // wird benutzt um Informationen zu trennen
	
	public static final String CONVERT = "!"; // wird benutzt um etwas umzukehren
	
	//-----------------------------------------Client zum Server-----------------------------------------
	
	public static final String CS_STARTGAME = "SG"; // der Client fragt an das Spiel zu starten
	
	public static final String CS_HIT = "H"; // der Client will eine Karte ziehen
	
	public static final String CS_STAND = "S"; // der Client will seinen Zug beenden
	
	public static final String CS_SPLIT = "SP"; // der Client will splitten
	
	public static final String CS_DOUBLEDOWN = "D"; // der Client will seinen Einsatz verdoppeln (funktioniert noch nicht)
	
	public static final String CS_PAY = "P"; // mit Trenner wird ein Zahlenwert angeh�ngt
	

	//-----------------------------------------Server zum Client-----------------------------------------
	
	public static final String SC_PAY = "P"; // schickt der Server wenn Wette geklappt hat (ein converter davor besagt, dass es nocht geklappt hat)
	
	public static final String SC_ERROR = "E"; // schickt einen Error zur�ck
	
	public static final String SC_CARD = "C"; // mit dem Trenner wird der Kartenwert und Spieler angeh�ngt
	
	public static final String SC_GAMESTART = "G"; // der Startcredit und die Karten  werden f�r alle Clients bekanntgegeben, als letztes wird die erste Karte des Dealers bekann gegeben
	
	public static final String SC_WIN = "W"; // dahinter wird der Spieler und der Gewinn angeh�ngt
	
	public static final String SC_LOSE = "L"; // wird hinter den Stand-Befehl gehafftet wenn der Spieler verloren hat
	
	public static final String SC_STAND = "S"; // es wird die Nummer des Spielers hinten angeh�ngt
	
	public static final String SC_SPLIT = "T"; // Wenn ein Split m�glich ist dann werden die Karten 
	
	public static final String SC_DEALERWIN = "M"; // wird hinter SC_STAND geh�ngt, wenn der Dealer einen Blackjack hat
	
	public static final String SC_DOUBLEDOWN = "D"; // best�tigt die Anfrage, ob der Client sein Einsatz verdoppeln kann
}
