package Protokoll;
/**
 * Diese Zeichenketten werden zwischen Client und Server ausgetauscht.
 * 
 * @author Erik 
 * @version 15DEC17
 */
public class Protokoll {
	
	//-----------------------------------------General-----------------------------------------
	
	public static final String TRENNER = ":";
	
	//-----------------------------------------Client zum Server-----------------------------------------
	public static final String CS_STARTGAME = "SG";
	
	public static final String CS_HIT = "H";
	
	public static final String CS_STAND = "S";
	
	public static final String CS_SPLIT = "SP";
	
	public static final String CS_DOUBLEDOWN = "D";
	
	public static final String CS_PAY = "P"; // mit Trenner wird ein Zahlenwert angeh�ngt
	

	//-----------------------------------------Server zum Client-----------------------------------------
	public static final String SC_PAY = "P";
	
	public static final String SC_ERROR = "E";
	
	public static final String SC_CARD = "C"; // mit dem Trenner wird der Kartenwert angeh�ngt
	
	public static final String SC_GAMESTART = "GS"; //
	
	public static final String SC_WIN = "W";
	
	public static final String SC_LOSE = "L";
	
	public static final String SC_STAND = "S";
	
	public static final String SC_SPLIT = "SP"; // best�tigung das man einen Split machen kann
	
	public static final String SC_DEALERWIN = "DW"; // wird hinter SC_STAND geh�ngt, wenn der Dealer einen Blackjack hat
}
