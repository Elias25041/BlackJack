package basicClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BasicGUI extends JFrame {

	private int port;
	private String ip;
	private JPanel contentPane;
	private BasicClient bc;
	private JTextField Port;
	private JTextField IP;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BasicGUI frame = new BasicGUI();
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
	public BasicGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		IP = new JTextField();
		IP.setText("IP");
		panel.add(IP);
		IP.setColumns(10);
		
		Port = new JTextField();
		panel.add(Port);
		Port.setColumns(10);
		Port.getText();
		
		JLabel Ausgabefeld = new JLabel("Ausgabe");
		panel.add(Ausgabefeld);
		
		JButton btnCommit = new JButton("Commit");
		btnCommit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Port.getText().equals("") || IP.getText().equals("")) {
					Ausgabefeld.setText("Missing input");
				}else {
					ip = IP.getText();
					port = Integer.parseInt(Port.getText());
					
					
				}
			}
		});
		panel.add(btnCommit);
	}
	
	
	
	

}
