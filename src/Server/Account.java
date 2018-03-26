package Server;

public class Account {
	private String clientIP;
	private int clientPort;
	private int player;
	private int blackJacks;

	public Account(String pClientIP, int pClientPort, int pPlayer, int pBlackJacks) {
		clientIP = pClientIP;
		clientPort = pClientPort;
		player = pPlayer;
		blackJacks = pBlackJacks;
	}

	/**
	 * gibt die clientIP zur�ck
	 * 
	 * @return clientIP
	 */
	public String getClientIP() {
		return clientIP;
	}

	/**
	 * gibt den clientPort zur�ck
	 * 
	 * @return clientPort
	 */
	public int getClientPort() {
		return clientPort;
	}

	public int getPlayer() {
		return player;
	}
	
	public int getBlackJacks() {
		return blackJacks;
	}
	
	public void setPlayer(int p) {
		player = p;
	}
}
