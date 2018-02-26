package BasicClient;

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

public class BasicClientFrame extends JFrame{

	private JPanel contentPane;
	private JTextField ip;
	private JTextField port;
	private JTextField txtSend;
	private JTextField output;
	
	private BasicClient bc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BasicClientFrame frame = new BasicClientFrame();
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
	public BasicClientFrame() {
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
		ip.setText("IP");
		top.add(ip);
		ip.setColumns(10);
		
		port = new JTextField();
		port.setToolTipText("");
		port.setText("Port");
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
		
		txtSend = new JTextField();
		buttom.add(txtSend);
		txtSend.setColumns(10);
		
		JButton btnServer = new JButton("-> Server");
		btnServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				send();
			}
		});
		buttom.add(btnServer);
		
		output = new JTextField();
		contentPane.add(output, BorderLayout.CENTER);
		output.setColumns(10);
	}
	
	private void connect() {
		this.bc = new BasicClient(ip.getText(), Integer.valueOf(port.getText()), this);
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
