import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.io.*;
public class chat extends JFrame {

	private JPanel contentPane;
	static ServerSocket ss;
	static Socket s;
	static DataInputStream din;
	static DataOutputStream dout;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chat frame = new chat();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		String msgin = "";
		try {
			ss = new ServerSocket(1201);
			s = ss.accept();
			
			din = new DataInputStream(s.getInputStream());
			dout =  new DataOutputStream(s.getOutputStream());
			
			while(! msgin.equals("exit")) {
				msgin = din.readUTF();
//				msg_are
			}
			
			
		}catch(Exception e) {
			
		}
		
		
	}

	/**
	 * Create the frame.
	 */
	public chat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
