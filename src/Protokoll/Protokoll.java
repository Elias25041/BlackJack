package Protokoll;
/**
 * Diese Zeichenketten werden zwischen Client und Server ausgetauscht.
 * 
 * @author Erik 
 * @version 15DEC17
 */
public class Protokoll {
	
	//-----------------------------------------Client zum Server-----------------------------------------
	public static final String CS_HIT = "H";
	
	public static final String CS_STAND = "S";
	
	public static final String CS_SPLIT = "SP";
	
	public static final String CS_DOUBLEDOWN = "D";
	
	public static final String CS_PAY = "P"; // mit Trenner wird ein Zahlenwert angehängt
	

	//-----------------------------------------Server zum Client-----------------------------------------
	public static final String SC_PAY = "P";
	
	public static final String SC_ERROR = "E";
	
	public static final String SC_CARD = "C"; // mit dem Trenner wird der Kartenwert angehängt
	
	public static final String TRENNER = ":";
}
