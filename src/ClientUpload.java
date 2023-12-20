import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

class ClientUpload extends JFrame implements ActionListener {

    JFileChooser fc;
    JButton b, b1;
    JTextField tf;
    FileInputStream in;
    Socket s;
    DataOutputStream dout;
    DataInputStream din;
    int i;

    ClientUpload() {
        super("client");
        tf = new JTextField();
        tf.setBounds(20, 50, 190, 30);
        add(tf);

        b = new JButton("Browse");
        b.setBounds(250, 50, 80, 30);
        add(b);
        b.addActionListener(this);
        b1 = new JButton("Upload");
        b1.setBounds(250, 100, 80, 30);
        add(b1);
//        b1.addActionListener(this);
//        fc = new JFileChooser();
//        setLayout(null);
//        setSize(400, 300);
//        setVisible(true);
        try {
            s = new Socket("localhost", 10);
            dout = new DataOutputStream(s.getOutputStream());
            din = new DataInputStream(s.getInputStream());
            send();
        } catch (Exception e) {
        }
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == b) {
                int x = fc.showOpenDialog(null);
                if (x == JFileChooser.APPROVE_OPTION) {
                    copy();
                }
            }
            if (e.getSource() == b1) {
                send();
            }
        } catch (Exception ex) {
        }
    }

    public void copy() throws IOException {
        File f1 = fc.getSelectedFile();
        tf.setText(f1.getAbsolutePath());
        in = new FileInputStream(f1.getAbsolutePath());
        while ((i = in.read()) != -1) {
            System.out.print(i);
        }
    }

    public void send() throws IOException {
        dout.write(i);
        dout.flush();

    }

    public static void main(String... d) {
        new ClientUpload();
    }
}
