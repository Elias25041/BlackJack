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
import javax.swing.JLabel;

public class ExtendetClientFrame extends JFrame{

	private JPanel contentPane;
	private JTextField ip;
	private JTextField port;
	private JTextField txtSend;
	
	private ExtendetClient bc;
	private JPanel panel;
	private JPanel panel_1;
	private JTextArea output;
	private JLabel cardWorth;
	private JButton btnHit;
	private JButton btnStand;
	private JButton btnStartgame;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		buttom.add(btnStartgame);
		
		txtSend = new JTextField();
		buttom.add(txtSend);
		txtSend.setColumns(10);
		buttom.add(btnServer);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		cardWorth = new JLabel("cardWorth");
		panel_1.add(cardWorth);
		
		btnHit = new JButton("Hit");
		panel_1.add(btnHit);
		
		btnStand = new JButton("Stand");
		panel_1.add(btnStand);
		btnStand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bc.send("S");
			}
		});
		btnHit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bc.send("H");
			}
		});
		
		output = new JTextArea();
		panel.add(output, BorderLayout.NORTH);
	}
	
	private void connect() {
		this.bc = new ExtendetClient(ip.getText(), Integer.valueOf(port.getText()), this);
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
