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
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField player1;
	private JTextField player2;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JTextField player3;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JTextField player4;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_13;
	private JLabel label_14;
	private JTextField player5;
	private JLabel label_15;
	private JLabel label_16;
	private JLabel label_17;
	private JLabel label_18;
	private JLabel label_19;
	private JTextField player6;
	private JLabel label_20;
	private JLabel label_21;
	private JLabel label_22;
	private JLabel label_23;
	private JLabel label_24;
	private JTextField dealer;

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
		
		p1c1 = new JLabel("New label");
		
		p1c2 = new JLabel("New label");
		playerPanel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		player1 = new JTextField();
		player1.setText("Player 1");
		playerPanel1.add(player1);
		player1.setColumns(10);
		playerPanel1.add(p1c1);
		playerPanel1.add(p1c2);
		
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
		
		lblNewLabel_5 = new JLabel("New label");
		playerPanel3.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("New label");
		playerPanel3.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("New label");
		playerPanel3.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("New label");
		playerPanel3.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("New label");
		playerPanel3.add(lblNewLabel_9);
		
		playerPanel4 = new JPanel();
		panel_1.add(playerPanel4);
		
		player4 = new JTextField();
		player4.setText("Player 4");
		player4.setColumns(10);
		playerPanel4.add(player4);
		
		label_5 = new JLabel("New label");
		playerPanel4.add(label_5);
		
		label_6 = new JLabel("New label");
		playerPanel4.add(label_6);
		
		label_7 = new JLabel("New label");
		playerPanel4.add(label_7);
		
		label_8 = new JLabel("New label");
		playerPanel4.add(label_8);
		
		label_9 = new JLabel("New label");
		playerPanel4.add(label_9);
		
		playerPanel5 = new JPanel();
		panel_1.add(playerPanel5);
		
		player5 = new JTextField();
		player5.setText("Player 5");
		player5.setColumns(10);
		playerPanel5.add(player5);
		
		label_10 = new JLabel("New label");
		playerPanel5.add(label_10);
		
		label_11 = new JLabel("New label");
		playerPanel5.add(label_11);
		
		label_12 = new JLabel("New label");
		playerPanel5.add(label_12);
		
		label_13 = new JLabel("New label");
		playerPanel5.add(label_13);
		
		label_14 = new JLabel("New label");
		playerPanel5.add(label_14);
		
		playerPanel6 = new JPanel();
		panel_1.add(playerPanel6);
		
		player6 = new JTextField();
		player6.setText("Player 6");
		player6.setColumns(10);
		playerPanel6.add(player6);
		
		label_15 = new JLabel("New label");
		playerPanel6.add(label_15);
		
		label_16 = new JLabel("New label");
		playerPanel6.add(label_16);
		
		label_17 = new JLabel("New label");
		playerPanel6.add(label_17);
		
		label_18 = new JLabel("New label");
		playerPanel6.add(label_18);
		
		label_19 = new JLabel("New label");
		playerPanel6.add(label_19);
		
		dealerPanel = new JPanel();
		panel_1.add(dealerPanel);
		
		dealer = new JTextField();
		dealer.setText("Dealer");
		dealer.setColumns(10);
		dealerPanel.add(dealer);
		
		label_20 = new JLabel("New label");
		dealerPanel.add(label_20);
		
		label_21 = new JLabel("New label");
		dealerPanel.add(label_21);
		
		label_22 = new JLabel("New label");
		dealerPanel.add(label_22);
		
		label_23 = new JLabel("New label");
		dealerPanel.add(label_23);
		
		label_24 = new JLabel("New label");
		dealerPanel.add(label_24);
		
		
		
		
		ausgeben("Weitere Meldungen");
		
		
	}
	
	private void connect() {
		this.bc = new ExtendetClient(ip.getText(), Integer.valueOf(port.getText()), this);
	}
	

	public void returnCards() {
		
	}
	
	public void ausgeben(String message) {
		String bisher = this.output.getText();
		bisher = message + "\n" + bisher;
		this.output.setText(bisher);
	}
	
	public void send() {
		if(txtSend.getText().equals("")) {
			ausgeben("Please enter text");
		}else {
			bc.send(txtSend.getText());
		}
	}
	
	
	

}
