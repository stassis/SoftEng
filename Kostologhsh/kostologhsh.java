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

public class kostologhsh {

	private JFrame frame;
	private JTextField newprice1 = new JTextField();
	private JTextField newprice2 = new JTextField();
	private JTextField newprice3 = new JTextField();
	private JTextField newprice4 = new JTextField();
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	
	public kostologhsh() {
		
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
			String[] prices = new String[4];
			int i=0;
			
			while (rs.next()) {
				plates[i] = rs.getString("name");
				prices[i] = String.valueOf(rs.getInt("price"));
				i++;
	          }
			
		
		JLabel plate1 = new JLabel(plates[0]);
		plate1.setBounds(10, 48, 66, 21);
		frame.getContentPane().add(plate1);
		
		JLabel price1 = new JLabel(prices[0]);
		price1.setBounds(110, 48, 66, 21);
		price1.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(price1);
		
		JLabel plate2 = new JLabel(plates[1]);
		plate2.setBounds(10, 78, 66, 21);
		frame.getContentPane().add(plate2);
		
		JLabel price2 = new JLabel(prices[1]);
		price2.setBounds(110, 80, 66, 21);
		price2.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(price2);
		
		JLabel plate3 = new JLabel(plates[2]);
		plate3.setBounds(10, 108, 66, 21);
		frame.getContentPane().add(plate3);
		
		JLabel price3 = new JLabel(prices[2]);
		price3.setBounds(110, 108, 66, 21);
		price3.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(price3);
		
		JLabel plate4 = new JLabel(plates[3]);
		plate4.setBounds(10, 138, 66, 21);
		frame.getContentPane().add(plate4);
		
		JLabel price4 = new JLabel(prices[3]);
		price4.setBounds(110, 138, 66, 21);
		price4.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(price4);
		
		JLabel newPrice = new JLabel("New Price \u20AC");
		newPrice.setBounds(178, 17, 80, 21);
		frame.getContentPane().add(newPrice);
		
		newprice1.setBounds(178, 49, 80, 19);
		frame.getContentPane().add(newprice1);
		newprice1.setColumns(10);
		
		newprice2.setBounds(178, 79, 80, 19);
		frame.getContentPane().add(newprice2);
		newprice2.setColumns(10);
		
		newprice3.setBounds(178, 109, 80, 19);
		frame.getContentPane().add(newprice3);
		newprice3.setColumns(10);
		
		newprice4.setBounds(178, 138, 80, 19);
		frame.getContentPane().add(newprice4);
		newprice4.setColumns(10);
		
		btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				String[] newprices = {(newprice1.getText().isEmpty())? "0":newprice1.getText(), 
									  (newprice2.getText().isEmpty())? "0":newprice2.getText(),
									  (newprice3.getText().isEmpty())? "0":newprice3.getText(),
									  (newprice4.getText().isEmpty())? "0":newprice4.getText()};
				updatePrices(plates,newprices);
				JOptionPane.showMessageDialog(null, "Prices Updated");
				new kostologhsh();
			}
		});
		btnNewButton.setBounds(178, 176, 80, 21);
		frame.getContentPane().add(btnNewButton);
		
		JLabel oldprice = new JLabel("Old Price");
		oldprice.setBounds(96, 17, 80, 21);
		frame.getContentPane().add(oldprice);
		
		
		
		
			}catch (ClassNotFoundException | SQLException e) {e.printStackTrace();}
			
			frame.setVisible(true);
	}
	

	
public void updatePrices(String[] plates, String[] prices) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
				Statement st = conn.createStatement();
				
				for(int i=1; i<=4; i++){
					if(prices[i-1].equals("0") ) {}
					else {
					String sql = "UPDATE plate SET price = '"+Integer.parseInt(prices[i-1])+"' WHERE id = '"+i+"'";
							st.execute(sql);}
				}
				conn.close();st.close();
			}catch (ClassNotFoundException | SQLException e) {e.printStackTrace();} 
	}



public static void main(String[] Args) {new kostologhsh();}
}