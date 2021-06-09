import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class idioktitismenou {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					idioktitismenou window = new idioktitismenou();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public idioktitismenou() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		//frame.setIconImage(Toolkit.getDefaultToolkit().getImage(idioktitismenou.class.getResource("/source/logo.png")));
		frame.setBounds(50, 50, 250, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JButton btnNewButton_1 = new JButton("Available Plates");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {Class.forName("com.mysql.cj.jdbc.Driver");
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
					Statement stmt = c.createStatement();
					String sql = "SELECT * FROM plate";
					ResultSet rs = stmt.executeQuery(sql);
					String[] plates = new String[4];
					int i=0;
					
					while (rs.next()) {plates[i] = rs.getString("name");i++; }
				
				
				JOptionPane.showMessageDialog(null, "<html>Available Plates: <br>"+
						plates[0]+"<br>"+
						plates[1]+"<br>"+
						plates[2]+"<br>"+
						plates[3]+"<br></html>");
				
				}catch (ClassNotFoundException | SQLException sqle) {sqle.printStackTrace();}
			
			}});
		btnNewButton_1.setBounds(42, 44, 150, 70);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Menu Pricing");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				kostologhsh k = new kostologhsh();
				k.initialize();
			}
		});
		btnNewButton.setBounds(42, 125, 150, 70);
		frame.getContentPane().add(btnNewButton);
		
		ImageIcon png = new ImageIcon("src/logo.png");
        JLabel logo = new JLabel(png);
        logo.setBounds(20,210,200,150);
        frame.getContentPane().add(logo);
        
        JButton btnback = new JButton("Back");
		btnback.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            	frame.dispose();
            	new MainMenu();
            	}});
		btnback.setBounds(6,6,70,20);
		frame.getContentPane().add(btnback);
        
	}

}
