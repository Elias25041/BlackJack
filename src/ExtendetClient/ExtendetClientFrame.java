package ExtendetClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import AbiturKlassen.Client;


import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class ExtendetClientFrame extends JFrame{

	private JPanel contentPane;
	private JTextField ip;
	private JTextField port;
	private JTextField txtSend;
	
	private ExtendetClient bc;
	private JPanel panel;
	private JLabel cardWorth;
	private JButton btnHit;
	private JButton btnStand;
	private JButton btnStartgame;
	private JTextArea output;
	private JScrollPane scrollPane;
	private JPanel panel_1;
	private JLabel card1;
	private JLabel card2;
	private JLabel card3;
	private Icon icon1;
	private JPanel playerPanel2;
	private JPanel playerPanel1;
	private JPanel playerPanel3;
	private JPanel playerPanel4;
	private JPanel playerPanel5;
	private JPanel playerPanel6;
	private JPanel dealerPanel;
	private JLabel p1c1;
	private JLabel p1c2;
	private JLabel p1c3;
	private JLabel p1c4;
	private JLabel p1c5;
	private JLabel p2c1;
	private JLabel p2c2;
	private JLabel p2c3;
	private JLabel p2c4;
	private JLabel p2c5;
	private JLabel p3c1;
	private JLabel p3c2;
	private JLabel p3c3;
	private JTextField player1;
	private JTextField player2;
	private JLabel p3c4;
	private JLabel p3c5;
	private JTextField player3;
	private JLabel p4c1;
	private JLabel p4c2;
	private JLabel p4c3;
	private JLabel p4c4;
	private JLabel p4c5;
	private JTextField player4;
	private JLabel p5c1;
	private JLabel p5c2;
	private JLabel p5c3;
	private JLabel p5c4;
	private JLabel p5c5;
	private JTextField player5;
	private JLabel p6c1;
	private JLabel p6c2;
	private JLabel p6c3;
	private JLabel p6c4;
	private JLabel p6c5;
	private JTextField player6;
	private JLabel d1;
	private JLabel d2;
	private JLabel d3;
	private JLabel d4;
	private JLabel d5;
	private JTextField dealer;
	
	ArrayList<ImageIcon> images1 = new ArrayList<ImageIcon>();
	ArrayList<ImageIcon> images2 = new ArrayList<ImageIcon>();
	ArrayList<ImageIcon> images3 = new ArrayList<ImageIcon>();
	ArrayList<ImageIcon> images4 = new ArrayList<ImageIcon>();
	ArrayList<ImageIcon> images5 = new ArrayList<ImageIcon>();
	ArrayList<ImageIcon> images6 = new ArrayList<ImageIcon>();
	
	
	ImageIcon herz2 = new ImageIcon(getClass().getResource("Herz_Zwei.jpg"));
	ImageIcon herz3 = new ImageIcon(getClass().getResource("Herz_Drei.jpg"));
	ImageIcon herz4 = new ImageIcon(getClass().getResource("Herz_Vier.jpg"));
	ImageIcon herz5 = new ImageIcon(getClass().getResource("Herz_F�nf.jpg"));
	ImageIcon herz6 = new ImageIcon(getClass().getResource("Herz_Sechs.jpg"));
	ImageIcon herz7 = new ImageIcon(getClass().getResource("Herz_Sieben.jpg"));
	ImageIcon herz8 = new ImageIcon(getClass().getResource("Herz_Acht.jpg"));
	ImageIcon herz9 = new ImageIcon(getClass().getResource("Herz_Neun.jpg"));
	ImageIcon herz10 = new ImageIcon(getClass().getResource("Herz_Zehn.jpg"));
	ImageIcon herzB= new ImageIcon(getClass().getResource("Herz_Bube.jpg"));
	ImageIcon herzD = new ImageIcon(getClass().getResource("Herz_Dame.jpg"));
	ImageIcon herzK = new ImageIcon(getClass().getResource("Herz_Koenig.jpg"));
	ImageIcon herzA = new ImageIcon(getClass().getResource("Herz_Ass.jpg"));

	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExtendetClientFrame frame = new ExtendetClientFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 */
	public ExtendetClientFrame() {
		setBackground(Color.GREEN);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel top = new JPanel();
		contentPane.add(top, BorderLayout.NORTH);
		top.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		ip = new JTextField();
		ip.setText("localhost");
		top.add(ip);
		ip.setColumns(10);
		
		port = new JTextField();
		port.setToolTipText("");
		port.setText("4444");
		top.add(port);
		port.setColumns(10);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ip.getText().equals("") || port.getText().equals("")) {
					ausgeben("Please enter IP and Port!");
				}else {
					connect();
				}
			}
		});
		top.add(btnConnect);
		
		JPanel buttom = new JPanel();
		contentPane.add(buttom, BorderLayout.SOUTH);
		
		JButton btnServer = new JButton("-> Server");
		btnServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				send();
			}
		});
		
		btnStartgame = new JButton("StartGame");
		btnStartgame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bc.send("SG");
				btnStartgame.setVisible(false);
			}
		});
		buttom.setLayout(new BoxLayout(buttom, BoxLayout.X_AXIS));
		buttom.add(btnStartgame);
		
		
		
		btnHit = new JButton("Hit");
		buttom.add(btnHit);
		btnHit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bc.send("H");
			}
		});
		
		btnStand = new JButton("Stand");
		buttom.add(btnStand);
		
		
		btnStand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bc.send("S");
			}
		});
		
		txtSend = new JTextField();
		buttom.add(txtSend);
		txtSend.setColumns(10);
		buttom.add(btnServer);
		
		panel = new JPanel();
		panel.setBackground(Color.GREEN);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.NORTH);
		
		output = new JTextArea();
		panel.add(output, BorderLayout.SOUTH);
		
		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		playerPanel1 = new JPanel();
		panel_1.add(playerPanel1);
		
		player1 = new JTextField();
		player1.setText("Player 1");
		playerPanel1.add(player1);
		player1.setColumns(10);
		
		p1c1 = new JLabel("New Lable");
		playerPanel1.add(p1c1);
		
		p1c2 = new JLabel("New label");
		playerPanel1.add(p1c2);
		
		playerPanel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		
		p1c3 = new JLabel("New label");
		playerPanel1.add(p1c3);
		
		p1c4 = new JLabel("New label");
		playerPanel1.add(p1c4);
		
		p1c5 = new JLabel("New label");
		playerPanel1.add(p1c5);
		
		playerPanel2 = new JPanel();
		panel_1.add(playerPanel2);
		
		player2 = new JTextField();
		player2.setText("Player 2");
		playerPanel2.add(player2);
		player2.setColumns(10);
		
		p2c1 = new JLabel("New label");
		playerPanel2.add(p2c1);
		
		p2c2 = new JLabel("New label");
		playerPanel2.add(p2c2);
		
		p2c3 = new JLabel("New label");
		playerPanel2.add(p2c3);
		
		p2c4 = new JLabel("New label");
		playerPanel2.add(p2c4);
		
		p2c5 = new JLabel("New label");
		playerPanel2.add(p2c5);
		
		playerPanel3 = new JPanel();
		panel_1.add(playerPanel3);
		
		player3 = new JTextField();
		player3.setText("Player 3");
		playerPanel3.add(player3);
		player3.setColumns(10);
		
		p3c1 = new JLabel("New label");
		playerPanel3.add(p3c1);
		
		p3c2 = new JLabel("New label");
		playerPanel3.add(p3c2);
		
		p3c3 = new JLabel("New label");
		playerPanel3.add(p3c3);
		
		p3c4 = new JLabel("New label");
		playerPanel3.add(p3c4);
		
		p3c5 = new JLabel("New label");
		playerPanel3.add(p3c5);
		
		playerPanel4 = new JPanel();
		panel_1.add(playerPanel4);
		
		player4 = new JTextField();
		player4.setText("Player 4");
		player4.setColumns(10);
		playerPanel4.add(player4);
		
		p4c1 = new JLabel("New label");
		playerPanel4.add(p4c1);
		
		p4c2 = new JLabel("New label");
		playerPanel4.add(p4c2);
		
		p4c3 = new JLabel("New label");
		playerPanel4.add(p4c3);
		
		p4c4 = new JLabel("New label");
		playerPanel4.add(p4c4);
		
		p4c5 = new JLabel("New label");
		playerPanel4.add(p4c5);
		
		playerPanel5 = new JPanel();
		panel_1.add(playerPanel5);
		
		player5 = new JTextField();
		player5.setText("Player 5");
		player5.setColumns(10);
		playerPanel5.add(player5);
		
		p5c1 = new JLabel("New label");
		playerPanel5.add(p5c1);
		
		p5c2 = new JLabel("New label");
		playerPanel5.add(p5c2);
		
		p5c3 = new JLabel("New label");
		playerPanel5.add(p5c3);
		
		p5c4 = new JLabel("New label");
		playerPanel5.add(p5c4);
		
		p5c5 = new JLabel("New label");
		playerPanel5.add(p5c5);
		
		playerPanel6 = new JPanel();
		panel_1.add(playerPanel6);
		
		player6 = new JTextField();
		player6.setText("Player 6");
		player6.setColumns(10);
		playerPanel6.add(player6);
		
		p6c1 = new JLabel("New label");
		playerPanel6.add(p6c1);
		
		p6c2 = new JLabel("New label");
		playerPanel6.add(p6c2);
		
		p6c3 = new JLabel("New label");
		playerPanel6.add(p6c3);
		
		p6c4 = new JLabel("New label");
		playerPanel6.add(p6c4);
		
		p6c5 = new JLabel("New label");
		playerPanel6.add(p6c5);
		
		dealerPanel = new JPanel();
		panel_1.add(dealerPanel);
		
		dealer = new JTextField();
		dealer.setText("Dealer");
		dealer.setColumns(10);
		dealerPanel.add(dealer);
		
		d1 = new JLabel("New label");
		dealerPanel.add(d1);
		
		d2 = new JLabel("New label");
		dealerPanel.add(d2);
		
		d3 = new JLabel("New label");
		dealerPanel.add(d3);
		
		d4 = new JLabel("New label");
		dealerPanel.add(d4);
		
		d5 = new JLabel("New label");
		dealerPanel.add(d5);
		
		
		
		
		ausgeben("Weitere Meldungen");
		
		
	}
	
	private void connect() {
		this.bc = new ExtendetClient(ip.getText(), Integer.valueOf(port.getText()), this);
	}
	
	private ImageIcon returnPic(String card) {
		switch(card) {
			case "Herz_Zwei":
				return herz2;
			case "Herz_Drei":
				return herz3;
			case "Herz_Vier":
				return herz4;
			case "Herz_F�nf":
				return herz5;
			case "Herz_Sechs":
				return herz6;
			case "Herz_Sieben":
				return herz7;
			case "Herz_Acht":
				return herz8;
			case "Herz_Neun":
				return herz9;
			case "Herz_Zehn":
				return herz10;
			case "Herz_Bube":
				return herzB;
			case "Herz_Dame":
				return herzD;
			case "Herz_Koenig":
				return herzK;
			case "Herz_Ass":
				return herzA;
	
		}
		return null;
	}
	
	public ArrayList<ImageIcon> returnImages(ArrayList<String> cs){
		
		if(cs.equals("player1")) {
			for(int i=0; i<cs.size(); i++) {
				images1.add(returnPic(cs.get(i)));
				return images1;
			}
		}else if(cs.equals("player2")) {
			for(int i=0; i<cs.size(); i++) {
				images2.add(returnPic(cs.get(i)));
				return images2;
			}
		}else if(cs.equals("player3")) {
			for(int i=0; i<cs.size();) {
				images3.add(returnPic(cs.get(i)));
				return images3;
			}
		}else if(cs.equals("player3")) {
			for(int i=0; i<cs.size(); i++) {
				images4.add(returnPic(cs.get(i)));
				return images4;
			}
		}else if(cs.equals("player4")) {
			for(int i=0; i<cs.size(); i++) {
				images5.add(returnPic(cs.get(i)));
				return images5;
			}
		}
		return null;
	}
	
	public void setImagesToGUI(ArrayList<ImageIcon> c) {
		if(c.equals("playerCard2")) {
			p1c1.setIcon(c.get(0));
			p1c2.setIcon(c.get(1));
			p1c3.setIcon(c.get(2));
			p1c4.setIcon(c.get(3));
			p1c5.setIcon(c.get(4));
		}else if(c.equals("playerCard2")) {
			p2c1.setIcon(c.get(0));
			p2c2.setIcon(c.get(1));
			p2c3.setIcon(c.get(2));
			p2c4.setIcon(c.get(3));
			p2c5.setIcon(c.get(4));
		}else if(c.equals("playerCard3")) {
			p3c1.setIcon(c.get(0));
			p3c2.setIcon(c.get(1));
			p3c3.setIcon(c.get(2));
			p3c4.setIcon(c.get(3));
			p3c5.setIcon(c.get(4));
		}
	}
	
	

	
	
	
	public void ausgeben(String message) {
		String bisher = this.output.getText();
		bisher = message + "\n" + bisher;
		this.output.setText(bisher);
	}
	
	public void cardOutput() {}
	
	public void send() {
		if(txtSend.getText().equals("")) {
			ausgeben("Please enter text");
		}else {
			bc.send(txtSend.getText());
		}
	}
	
	
	

}
