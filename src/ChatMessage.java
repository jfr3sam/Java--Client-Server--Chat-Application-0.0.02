
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;


public class ChatMessage  {

	private JPanel contentPane;
	public Researcher researcher;
	public JFrame ChatMassagesFrame = new JFrame();
	static JTextField textField;
	static ServerSocket ss;
	static Socket s;
	static DataInputStream din;
	static DataOutputStream dout;
	static JTextArea textArea;
	private JTextField tUploadFile;
	private FileInputStream in;
	private JFileChooser fc = new JFileChooser();;
	int i;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatMessage windows = new ChatMessage();
					windows.ChatMassagesFrame.setVisible(true);
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
				textField.setText(textField.getText().trim() + "\n\n" + msgin);
			}
			
			
		}catch(Exception e) {
			
		}
	}

	/**
	 * Create the frame.
	 */
	public ChatMessage() {
		ChatMassagesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ChatMassagesFrame.setBounds(100, 100, 890, 692);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		ChatMassagesFrame.setContentPane(contentPane);
		contentPane.setLayout(null);
		ChatMassagesFrame.setResizable(false);
		ChatMassagesFrame.setLocationRelativeTo(null);
		JButton btnUploadFile = new JButton("Upload File");
		JPanel panelChat = new JPanel();
		JPanel panelLogout = new JPanel();
		
		//******************* Upload Button *******************//
		JButton btnUpload = new JButton("Upload");
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUploadFile.setVisible(true);
				tUploadFile.setVisible(false);
				btnUpload.setVisible(false);
				textField.setEditable(true);
				textField.addMouseListener(new java.awt.event.MouseAdapter() {
				    public void mouseEntered(java.awt.event.MouseEvent evt) {
				    	textField.setBackground(Color.WHITE);
				    }
				    public void mouseExited(java.awt.event.MouseEvent evt) {
				    	textField.setBackground(new JButton().getBackground());
				    }
				});
			}
		});
		btnUpload.setBackground(new Color(152, 251, 152));
		btnUploadFile.setForeground(Color.GRAY);
		btnUploadFile.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnUpload.setBackground(new JButton().getBackground());
		btnUploadFile.setVisible(true);
		btnUpload.setVisible(false);
		btnUpload.setCursor(new Cursor(Cursor.HAND_CURSOR));
		//******************* Adding hover  effect for Upload Button *******************//
		btnUpload.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnUpload.setBackground(new Color(50, 205, 05));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnUpload.setBackground(new JButton().getBackground());
		    }
		});
		
		//******************* To change the pointer into  HAND_CURSOR *******************//
		JLabel label = new JLabel("https://stackoverflow.com");
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		
		//******************* Menu Panel *******************//
		JPanel panelMain = new JPanel();
		panelMain.setBorder(UIManager.getBorder("FormattedTextField.border"));
		panelMain.setBackground(new Color(245, 245, 245));
		panelMain.setBounds(0, 0, 876, 665);
		contentPane.add(panelMain);
		panelMain.setLayout(null);
		
		//******************* Start Chat Button *******************//
		JButton btnStartChat = new JButton("");
		btnStartChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelChat.setVisible(true);
				btnStartChat.setVisible(false);
				panelLogout.setVisible(false);
			}
		});
		Image ChatIconImg = new ImageIcon(this.getClass().getResource("User-Chat-icon.png")).getImage().getScaledInstance(50, 50, 50);
		btnStartChat.setIcon(new ImageIcon(ChatIconImg));
		btnStartChat.setBackground(new Color(245, 245, 245));
		btnStartChat.setFont(new Font("Arial", Font.BOLD, 18));
		btnStartChat.setBounds(793, 548, 49, 50);
		panelMain.add(btnStartChat);
		btnStartChat.setBorderPainted(false);
		btnStartChat.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnStartChat.setBorderPainted(false);
		
		//******************* Main Panel *******************//
		panelChat.setBounds(220, 0, 656, 655);
		panelMain.add(panelChat);
		panelChat.setBackground(new Color(211, 211, 211));
		panelChat.setLayout(null);
		panelChat.setVisible(false);
		
		JPanel panelSend_TextField = new JPanel();
		panelSend_TextField.setBorder(UIManager.getBorder("InternalFrame.border"));
		panelSend_TextField.setBounds(21, 495, 600, 64);
		panelChat.add(panelSend_TextField);
		panelSend_TextField.setLayout(null);
					
		//******************* Message Field *******************//
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.PLAIN, 15));
		textField.setBounds(0, 0, 515, 63);
		panelSend_TextField.add(textField);
		textField.setBackground(new Color(245, 245, 245));
		textField.setColumns(10);
		textField.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	textField.setBackground(Color.WHITE);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	textField.setBackground(new JButton().getBackground());
		    }
		});
		
		
			
		//******************* Send Button *******************//
		JButton btnSend = new JButton("");
		btnSend.setBounds(515, 0, 85, 63);
		panelSend_TextField.add(btnSend);
		Image SendIconImg = new ImageIcon(this.getClass().getResource("email-send-icon.png")).getImage().getScaledInstance(70, 70, 70);
		btnSend.setIcon(new ImageIcon(SendIconImg));
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textField.getText();				// example of the output of the textArea
				textArea.setText(text);
				tUploadFile.setVisible(false);
				btnUpload.setVisible(false);
				btnUploadFile.setVisible(true);
				textField.setEditable(true);
				
//				r.send(text,);
				textField.addMouseListener(new java.awt.event.MouseAdapter() {
				    public void mouseEntered(java.awt.event.MouseEvent evt) {
				    	textField.setBackground(Color.WHITE);
				    }
				    public void mouseExited(java.awt.event.MouseEvent evt) {
				    	textField.setBackground(new JButton().getBackground());
				    }
				});
			}
		});
		btnSend.setBorderPainted(false);
		btnSend.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		//******************* Adding hover  effect for Send Button *******************//
		btnSend.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnSend.setBackground(new Color(50, 205, 05));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnSend.setBackground(new JButton().getBackground());
		    }
		});

	
		//******************* Text Field & Send Button Panel *******************//
		JPanel panelTextFieldMassages = new JPanel();
		panelTextFieldMassages.setBorder(UIManager.getBorder("FormattedTextField.border"));
		panelTextFieldMassages.setBounds(21, 22, 600, 472);
		panelChat.add(panelTextFieldMassages);
		panelTextFieldMassages.setLayout(null);
		
		
		//******************* Messages Text Area *******************//
		textArea = new JTextArea();
		textArea.setBounds(0, 0, 599, 473);
		panelTextFieldMassages.add(textArea);
		textArea.setEditable(false);
		
		//******************* Upload Panel *******************//
		JPanel panelUploadFile = new JPanel();
		panelUploadFile.setLayout(null);
		panelUploadFile.setBorder(UIManager.getBorder("InternalFrame.border"));
		panelUploadFile.setBounds(21, 559, 600, 64);
		panelChat.add(panelUploadFile);
		
		//******************* Upload File Button *******************//
		btnUploadFile.setBounds(0, 0, 600, 64);
		Image uploadIconImg = new ImageIcon(this.getClass().getResource("Upload-Folder-icon.png")).getImage().getScaledInstance(50, 50, 50);
		btnUploadFile.setIcon(new ImageIcon(uploadIconImg));
		panelUploadFile.add(btnUploadFile);
		tUploadFile = new JTextField();
		tUploadFile.setBounds(0, 0, 515, 39);
		panelUploadFile.add(tUploadFile);
		tUploadFile.setColumns(10);
		btnUploadFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUploadFile.setVisible(false);
				tUploadFile.setVisible(true);
				btnUpload.setVisible(true);
				textField.setEditable(false);
				textField.addMouseListener(new java.awt.event.MouseAdapter() {
				    public void mouseEntered(java.awt.event.MouseEvent evt) {
				    	textField.setBackground(new JButton().getBackground());
				    }
				    public void mouseExited(java.awt.event.MouseEvent evt) {
				    	textField.setBackground(new JButton().getBackground());
				    }
				});
			}
		});
		//******************* Adding hover  effect for Upload text Field *******************//
		tUploadFile.addMouseListener(new java.awt.event.MouseAdapter() {
				    public void mouseEntered(java.awt.event.MouseEvent evt) {
				    	tUploadFile.setBackground(Color.WHITE);
				    }
				    public void mouseExited(java.awt.event.MouseEvent evt) {
				    	tUploadFile.setBackground(new JButton().getBackground());
				    }
				});
		btnUpload.setBounds(0, 37, 335, 26);
		tUploadFile.setVisible(false);
		panelUploadFile.add(btnUpload);
		btnUploadFile.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		//******************* Browse Button *******************//
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            s = new Socket("localhost", 10);
		            dout = new DataOutputStream(s.getOutputStream());
		            din = new DataInputStream(s.getInputStream());
		            send();
		        } catch (Exception e4) {
		        }
		        try {
		            if (e.getSource() == btnBrowse) {
		                int x = fc.showOpenDialog(null);
		                if (x == JFileChooser.APPROVE_OPTION) {
		                    copy();
		                }
		            }
		            if (e.getSource() == btnUpload) {
		                send();
		            }
		        } catch (Exception ex) {
		        }
			}
		});
		//******************* Adding hover  effect for Send Button *******************//
		btnBrowse.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnBrowse.setBackground(new Color(30, 144, 255));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnBrowse.setBackground(new JButton().getBackground());
		    }
		});
		btnBrowse.setBounds(515, 0, 85, 36);
		panelUploadFile.add(btnBrowse);
		btnBrowse.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		//******************* Cancel Button *******************//
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tUploadFile.setText(null);
				btnUploadFile.setVisible(true);
				tUploadFile.setVisible(false);
				btnUpload.setVisible(false);
				
				textField.setEditable(true);
				textField.addMouseListener(new java.awt.event.MouseAdapter() {
				    public void mouseEntered(java.awt.event.MouseEvent evt) {
				    	textField.setBackground(Color.WHITE);
				    }
				    public void mouseExited(java.awt.event.MouseEvent evt) {
				    	textField.setBackground(new JButton().getBackground());
				    }
				});
			}
		});
		//******************* Adding hover  effect for Cancel Button *******************//
		btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnCancel.setBackground(new Color(250, 128, 114));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnCancel.setBackground(new JButton().getBackground());
		    }
		});
		btnCancel.setBounds(335, 37, 265, 26);
		btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelUploadFile.add(btnCancel);
		
		JLabel lblArrows = new JLabel("");
		Image ExitIconImg = new ImageIcon(this.getClass().getResource("Close-2-icon.png")).getImage().getScaledInstance(20, 20, 20);
		lblArrows.setIcon(new ImageIcon(ExitIconImg));
		lblArrows.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	panelChat.setVisible(false);
		    	btnStartChat.setVisible(true);
		    	panelLogout.setVisible(true);
		    }
		}); 
		lblArrows.setBounds(620, 8, 20, 20);
		lblArrows.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelChat.add(lblArrows);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBounds(0, 0, 220, 655);
		panelMain.add(panelMenu);
		panelMenu.setLayout(null);
		
		panelLogout.setBounds(0, 558, 220, 62);
		panelMenu.add(panelLogout);
		panelLogout.setLayout(null);
		
		JLabel lblLogout = new JLabel("Log out");
		lblLogout.setFont(new Font("Arial", Font.BOLD, 24));
		Image logoutIconImg = new ImageIcon(this.getClass().getResource("Apps-session-logout-icon.png")).getImage().getScaledInstance(50, 50, 50);
		lblLogout.setIcon(new ImageIcon(logoutIconImg));
		lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	JOptionPane.showConfirmDialog(ChatMassagesFrame, "Conform log out ....");
		    	ChatMassagesFrame.dispose();
		    }
		}); 
		lblLogout.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogout.setBounds(47, 10, 163, 52);
		lblLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelLogout.add(lblLogout);
		
		
		
		////////////////////////////////////END////////////////////////
	}

	
	
	
    public void copy() throws IOException {
        File f1 = fc.getSelectedFile();
        tUploadFile.setText(f1.getAbsolutePath());
        in = new FileInputStream(f1.getAbsolutePath());
        while ((i = in.read()) != -1) {
            System.out.print(i);
        }
    }
    
    public void send() throws IOException {
        dout.write(i);
        dout.flush();

    }
}
