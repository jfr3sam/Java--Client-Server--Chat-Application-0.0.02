import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JPasswordField;

public  class RegistrationForm implements ActionListener {

	private Container c;
	private JLabel title;
	private JLabel name;
	private JTextField tname;
	private JLabel mno;
	private JTextField tmno;
	private JLabel gender;
	private JRadioButton male;
	private JRadioButton female;
	private ButtonGroup gengp;
	private JLabel dob;
	@SuppressWarnings("rawtypes")
	private JComboBox date;
	@SuppressWarnings("rawtypes")
	private JComboBox month;
	@SuppressWarnings("rawtypes")
	private JComboBox year;
	private JLabel EmailAdd;
	private JCheckBox term;
	private JButton sub;
	private JButton reset;
	private JTextArea tout;
	private JLabel res;
	private JTextArea resadd;

	private String dates[]
		= { "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "10",
			"11", "12", "13", "14", "15",
			"16", "17", "18", "19", "20",
			"21", "22", "23", "24", "25",
			"26", "27", "28", "29", "30",
			"31" };
	private String months[]
		= { "Jan", "feb", "Mar", "Apr",
			"May", "Jun", "July", "Aug",
			"Sup", "Oct", "Nov", "Dec" };
	private String years[]
		= { "1995", "1996", "1997", "1998",
			"1999", "2000", "2001", "2002",
			"2003", "2004", "2005", "2006",
			"2007", "2008", "2009", "2010",
			"2011", "2012", "2013", "2014",
			"2015", "2016", "2017", "2018",
			"2019", "2020", "2021", "2022" };
	
	private JPanel contentPane;
	private FileWriter fileWriter;
	private JTextField textField;
	private JTextField tEmailAdd;
	public JFrame RegistrationFormFrame = new JFrame();
	private JTextField tIPAddress;
	private JTextField tPassword;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationForm window = new RegistrationForm();
					window.RegistrationFormFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public RegistrationForm() {
		RegistrationFormFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		RegistrationFormFrame.setBounds(300, 90, 900, 656);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		RegistrationFormFrame.setContentPane(contentPane);
		RegistrationFormFrame.setResizable(false);
		
		c =contentPane;
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		title = new JLabel("Registration Form");
		title.setBounds(300, 30, 300, 30);
		title.setFont(new Font("Arial", Font.PLAIN, 30));
		c.add(title);

		name = new JLabel("Name");
		name.setBounds(100, 100, 100, 20);
		name.setFont(new Font("Arial", Font.PLAIN, 20));
		c.add(name);

		tname = new JTextField();
		tname.setBounds(223, 100, 190, 20);
		tname.setFont(new Font("Arial", Font.PLAIN, 15));
		c.add(tname);

		mno = new JLabel("Mobile");
		mno.setBounds(100, 150, 100, 20);
		mno.setFont(new Font("Arial", Font.PLAIN, 20));
		c.add(mno);

		tmno = new JTextField();
		tmno.setBounds(223, 150, 150, 20);
		tmno.setFont(new Font("Arial", Font.PLAIN, 15));
		c.add(tmno);

		gender = new JLabel("Gender");
		gender.setBounds(100, 200, 100, 20);
		gender.setFont(new Font("Arial", Font.PLAIN, 20));
		c.add(gender);

		male = new JRadioButton("Male");
		male.setBounds(223, 200, 75, 20);
		male.setFont(new Font("Arial", Font.PLAIN, 15));
		male.setSelected(true);
		c.add(male);

		female = new JRadioButton("Female");
		female.setBounds(298, 200, 80, 20);
		female.setFont(new Font("Arial", Font.PLAIN, 15));
		female.setSelected(false);
		c.add(female);

		gengp = new ButtonGroup();
		gengp.add(male);
		gengp.add(female);

		dob = new JLabel("DOB");
		dob.setBounds(100, 250, 100, 20);
		dob.setFont(new Font("Arial", Font.PLAIN, 20));
		c.add(dob);

		date = new JComboBox(dates);
		date.setBounds(223, 250, 50, 20);
		date.setFont(new Font("Arial", Font.PLAIN, 15));
		c.add(date);

		month = new JComboBox(months);
		month.setBounds(273, 250, 60, 20);
		month.setFont(new Font("Arial", Font.PLAIN, 15));
		c.add(month);

		year = new JComboBox(years);
		year.setBounds(343, 250, 60, 20);
		year.setFont(new Font("Arial", Font.PLAIN, 15));
		c.add(year);

		EmailAdd = new JLabel("Email Address");
		EmailAdd.setBounds(100, 300, 126, 20);
		EmailAdd.setFont(new Font("Arial", Font.PLAIN, 18));
		c.add(EmailAdd);

		term = new JCheckBox("Accept Terms And Conditions.");
		term.setBounds(153, 473, 250, 20);
		term.setFont(new Font("Arial", Font.PLAIN, 15));
		c.add(term);

		sub = new JButton("Submit");
		sub.setBounds(153, 505, 100, 20);
		sub.setBackground(new Color(102, 204, 102));
		sub.setFont(new Font("Arial", Font.BOLD, 15));
		sub.addActionListener(this);
		c.add(sub);

		reset = new JButton("Reset");
		reset.setBounds(273, 505, 100, 20);
		reset.setBackground(new Color(204, 204, 204));
		reset.setFont(new Font("Arial", Font.BOLD, 15));
		reset.addActionListener(this);
		c.add(reset);

		tout = new JTextArea();
		tout.setBounds(500, 100, 300, 400);
		tout.setBackground(SystemColor.inactiveCaption);
		tout.setFont(new Font("Calibri", Font.PLAIN, 16));
		tout.setLineWrap(true);
		tout.setEditable(false);
		c.add(tout);

		res = new JLabel("");
		res.setBounds(100, 545, 500, 25);
		res.setFont(new Font("Arial", Font.PLAIN, 20));
		c.add(res);

		resadd = new JTextArea();
		resadd.setBounds(580, 175, 200, 75);
		resadd.setFont(new Font("Arial", Font.PLAIN, 15));
		resadd.setLineWrap(true);
		c.add(resadd);
		
		textField = new JTextField();
		textField.setBounds(0, 0, 0, 0);
		contentPane.add(textField);
		textField.setColumns(10);
		
		tEmailAdd = new JTextField();
		tEmailAdd.setBounds(223, 304, 190, 19);
		contentPane.add(tEmailAdd);
		tEmailAdd.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(100, 345, 100, 30);
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(lblPassword);
		
		tIPAddress = new JTextField();
		tIPAddress.setBounds(223, 403, 150, 19);
		contentPane.add(tIPAddress);
		tIPAddress.setColumns(10);
		
		JLabel lblIPAddress = new JLabel("IP Address");
		lblIPAddress.setBounds(100, 400, 100, 21);
		lblIPAddress.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(lblIPAddress);
		
		tPassword = new JTextField();
		tPassword.setColumns(10);
		tPassword.setBounds(223, 353, 150, 19);
		contentPane.add(tPassword);

		RegistrationFormFrame.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == sub) {
			
			if (term.isSelected()) {
				String data1;
				String data
					= "Name : "
					+ tname.getText().trim() + "\n"
					+ "Mobile : "
					+ tmno.getText().trim() + "\n";
				if (male.isSelected())
					data1 = "Gender : Male"
							+ "\n";
				else
					data1 = "Gender : Female"
							+ "\n";
				String data2
					= "DOB : "
					+ (String)date.getSelectedItem()
					+ "/" + (String)month.getSelectedItem()
					+ "/" + (String)year.getSelectedItem()
					+ "\n";

				String data3 = "Email Address : " + tEmailAdd.getText().trim() + "\n";
				String data4 = "Password: "  + tPassword.getText() + "\n";
				tout.setText(data + data1 + data2 + data3 + data4);
				tout.setEditable(false);
				res.setText("Registration Successfully..");
				
				// to send the info to a file
				
				try {
					
					fileWriter = new FileWriter("C:\\Users\\DELL\\eclipse-workspace\\SWE_311_project_form\\form.txt", true);
					
					fileWriter.write("Name: " + tname.getText().trim() + "\n");
					fileWriter.write("Mobile: " +  tmno.getText() + "\n");
					if (male.isSelected()) {
						fileWriter.write("Gender: Male " +  "\n" );
					}
					else {
						fileWriter.write("Gender: Female " +  "\n" );
					}

					fileWriter.write("Email Address: " + EmailAdd.getText() + "\n\n" );
					fileWriter.write("**************************\n\n");
					
					fileWriter.close();
					
				}catch(IOException a) {
					System.out.println("");
				}
			}

			else {
				tout.setText("");
				resadd.setText("");
				res.setText("Please accept the"
							+ " terms & conditions..");
			}
		
		}

		else if (e.getSource() == reset) {
			String def = "";
			tname.setText(def);
			tEmailAdd.setText(def);
			tmno.setText(def);
			res.setText(def);
			tout.setText(def);
			term.setSelected(false);
			date.setSelectedIndex(0);
			month.setSelectedIndex(0);
			year.setSelectedIndex(0);
			resadd.setText(def);
			
		}
	}
}
