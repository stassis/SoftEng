import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Sef_menou {

	private JFrame frame;
	private JTextField newplate1 = new JTextField();
	private JTextField newplate2 = new JTextField();
	private JTextField newplate3 = new JTextField();
	private JTextField newplate4 = new JTextField();
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	
	public Sef_menou() {
		
		frame = new JFrame();
		//frame.setIconImage(Toolkit.getDefaultToolkit().getImage(kostologhsh.class.getResource("src/logo.png")));
		frame.setBounds(100, 100, 300, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ImageIcon png = new ImageIcon("src/logo.png");
        JLabel logo = new JLabel(png);
        logo.setBounds(41,210,200,150);
        frame.getContentPane().add(logo);
		
		JButton btnback = new JButton("Back");
		btnback.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            	frame.dispose();
            	new MainMenu();
            	}});
		btnback.setBounds(6,6,70,20);
		frame.getContentPane().add(btnback);
		
				
			try {
				
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
			Statement stmt = c.createStatement();
			String sql = "SELECT * FROM plate";
			ResultSet rs = stmt.executeQuery(sql);
			String[] plates = new String[4];
			
			int i=0;
			
			while (rs.next()) {
				plates[i] = rs.getString("name");
				
				i++;
	          }
			
		
		JLabel plate1 = new JLabel(plates[0]);
		plate1.setBounds(10, 48, 66, 21);
		frame.getContentPane().add(plate1);
		
	
		
		JLabel plate2 = new JLabel(plates[1]);
		plate2.setBounds(10, 78, 66, 21);
		frame.getContentPane().add(plate2);
		
		
		
		JLabel plate3 = new JLabel(plates[2]);
		plate3.setBounds(10, 108, 66, 21);
		frame.getContentPane().add(plate3);
		
		
		
		JLabel plate4 = new JLabel(plates[3]);
		plate4.setBounds(10, 138, 66, 21);
		frame.getContentPane().add(plate4);
		
	
		
		JLabel newPlate = new JLabel("New Plate ");
		newPlate.setBounds(178, 17, 80, 21);
		frame.getContentPane().add(newPlate);
		
		newplate1.setBounds(178, 49, 80, 19);
		frame.getContentPane().add(newplate1);
		newplate1.setColumns(10);
		
		newplate2.setBounds(178, 79, 80, 19);
		frame.getContentPane().add(newplate2);
		newplate2.setColumns(10);
		
		newplate3.setBounds(178, 109, 80, 19);
		frame.getContentPane().add(newplate3);
		newplate3.setColumns(10);
		
		newplate4.setBounds(178, 138, 80, 19);
		frame.getContentPane().add(newplate4);
		newplate4.setColumns(10);
		
		btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				String[] newplates = {(newplate1.getText().isEmpty())? "0":newplate1.getText(), 
									  (newplate2.getText().isEmpty())? "0":newplate2.getText(),
									  (newplate3.getText().isEmpty())? "0":newplate3.getText(),
									  (newplate4.getText().isEmpty())? "0":newplate4.getText()};
				updatePlates(plates,newplates);
				JOptionPane.showMessageDialog(null, "Plates Updated");
				new Sef_menou();
			}
		});
		btnNewButton.setBounds(178, 176, 80, 21);
		frame.getContentPane().add(btnNewButton);
		
	
		
		
		
		
			}catch (ClassNotFoundException | SQLException e) {e.printStackTrace();}
			
			frame.setVisible(true);
	}
	

	
public void updatePlates(String[] plates, String[] Newplate) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
				Statement st = conn.createStatement();
				
				for(int i=1; i<=4; i++){
					String sql = "UPDATE plate SET name = '"+(Newplate[i-1])+"' WHERE id = '"+i+"'";
							st.execute(sql);}
				conn.close();st.close();
			}catch (ClassNotFoundException | SQLException e) {e.printStackTrace();} 
	}



public static void main(String[] Args) {new Sef_menou();}
}