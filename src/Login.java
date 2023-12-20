import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login{

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JLabel lblTitle;
	public JFrame loginFrame = new JFrame();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.loginFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setBounds(100, 100, 380, 291);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		loginFrame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblPassword.setBounds(58, 109, 85, 13);
		contentPane.add(lblPassword);
		
		//************************** Log in Button **************************//
		
		passwordField = new JPasswordField();
		passwordField.setBounds(133, 107, 116, 19);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Log in");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
					ChatMessage window = new ChatMessage();
					window.ChatMassagesFrame.setVisible(true);
					loginFrame.dispose();
				
			}
		});
		btnLogin.setBackground(Color.GREEN);
		btnLogin.setBounds(83, 176, 85, 21);
		contentPane.add(btnLogin);
		
	
		
		//************************** Log in Title **************************//
		lblTitle = new JLabel("Log in ");
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setBackground(Color.LIGHT_GRAY);
		lblTitle.setFont(new Font("Goudy Stout", Font.BOLD, 16));
		lblTitle.setBounds(136, 21, 149, 28);
		contentPane.add(lblTitle);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 58, 346, 2);
		contentPane.add(separator);
		
		//************************** Cancel Button **************************//
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartUpUi window = new StartUpUi();
				window.AppOpenUiFrame.setVisible(true);
				loginFrame.dispose();
			}
		});
		btnCancel.setBackground(Color.RED);
		btnCancel.setBounds(200, 176, 85, 21);
		contentPane.add(btnCancel);
	}
}
