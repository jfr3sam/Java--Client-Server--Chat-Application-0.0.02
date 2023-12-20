
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartUpUi{

	private JPanel contentPane;
	public JFrame AppOpenUiFrame = new JFrame();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartUpUi window = new StartUpUi();
					window.AppOpenUiFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StartUpUi() {
		
		AppOpenUiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AppOpenUiFrame.setBounds(100, 100, 385, 306);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		AppOpenUiFrame.setContentPane(contentPane);
		AppOpenUiFrame.setLocationRelativeTo(null);
		AppOpenUiFrame.setResizable(false);
		
		//************************** Log in Button **************************//
		JButton btnLogin = new JButton("Log in");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.loginFrame.setVisible(true);
				
				AppOpenUiFrame.dispose();
			}
		});
		contentPane.setLayout(null);
		btnLogin.setBounds(98, 112, 82, 21);
		contentPane.add(btnLogin);
		
		//************************** Form Button **************************//
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegistrationForm form = new RegistrationForm();
				form.RegistrationFormFrame.setVisible(true);
				AppOpenUiFrame.dispose();
			}
		});
		btnNewButton_1.setBounds(190, 112, 86, 21);
		contentPane.add(btnNewButton_1);
	}

}
