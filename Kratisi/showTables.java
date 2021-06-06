import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class showTables {
	
	
	public showTables(int sH, int sm, int eH, int em, int Seats, int cust_id, String Name) {
		
		int start = sH*100 + sm;
		int end = eH*100 + em;
		int[] flag = {1,1,1,1,1,1};
		
		JFrame stf = new JFrame("Choose your table");
		stf.getContentPane().setLayout(null);
		JButton t1 = new JButton("1"); t1.setBounds(40,30,50,80);
		JButton t2 = new JButton("2"); t2.setBounds(40,225,50,80);
		JButton t3 = new JButton("3"); t3.setBounds(150,30,50,80);
		JButton t4 = new JButton("4"); t4.setBounds(75,140,80,50);
		JButton t5 = new JButton("5"); t5.setBounds(150,225,50,80);
		
		ImageIcon diner = new ImageIcon("src/diner.png");
		JLabel lbdiner = new JLabel(diner);
		lbdiner.setBounds(0,0,400,400);
		
		stf.getContentPane().add(lbdiner);
		stf.setSize(400,500); 
		stf.setVisible(true);
		
		try
	    {Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
			String sql = "SELECT * FROM `booking` WHERE 1";
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int tmps = rs.getInt("startHH") * 100 + rs.getInt("startmm");
				int tmpe = rs.getInt("endHH") * 100 + rs.getInt("endmm");
				int i = rs.getInt("table_id");
				
				if (start >= tmps && start <= tmpe) {flag[i] = 0;}
				if (end >= tmps && end <= tmpe) {flag[i] = 0;}
				}
			c.close();
				
	    }
	    catch (Exception ee){System.err.println(ee.getMessage());}
		

		t1.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
				new Booking(sH, sm, eH, em, 1, Seats, cust_id, Name);
				JOptionPane.showMessageDialog(null, "Table 1 booked for "+Name+" on "+start+":"+end+".");
				stf.dispose(); new MainMenu();
				}}); 
		t2.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
				new Booking(sH, sm, eH, em, 2, Seats, cust_id, Name);
				JOptionPane.showMessageDialog(null, "Table 2 booked for "+Name+" on "+sH+":"+sm+".");
				stf.dispose(); new MainMenu();
				}});  
		t3.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
				new Booking(sH, sm, eH, em, 3, Seats, cust_id, Name);
				JOptionPane.showMessageDialog(null, "Table 3 booked for "+Name+" on "+sH+":"+sm+".");
				stf.dispose(); new MainMenu();
				}}); 
		t4.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
				new Booking(sH, sm, eH, em, 4, Seats, cust_id, Name);
				JOptionPane.showMessageDialog(null, "Table 4 booked for "+Name+" on "+sH+":"+sm+".");
				stf.dispose(); new MainMenu();
				}});  
		t5.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
				new Booking(sH, sm, eH, em, 5, Seats, cust_id, Name);
				JOptionPane.showMessageDialog(null, "Table 5 booked for "+Name+" on "+sH+":"+sm+".");
				stf.dispose(); new MainMenu();
				}});  
		
		if(flag[1] != 0) {stf.getContentPane().add(t1);}
		if(flag[2] != 0) {stf.getContentPane().add(t2);}
		if(flag[3] != 0) {stf.getContentPane().add(t3);}
		if(flag[4] != 0) {stf.getContentPane().add(t4);}
		if(flag[5] != 0) {stf.getContentPane().add(t5);}
			
		stf.getContentPane().add(lbdiner);
		stf.setSize(400,500); 
		stf.setVisible(true);
	}

}
