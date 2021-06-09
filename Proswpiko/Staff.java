import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Staff {
	
	Staff() {
		JFrame frame = new JFrame("Staff");
		JButton btnback = new JButton("Back");
		btnback.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            	frame.dispose();
            	new MainMenu();
            	}});
		btnback.setBounds(6,6,70,20);
		frame.add(btnback);
		
		try {
			
			DefaultTableModel tm = new DefaultTableModel(new String[]{"ID", "Role", "Pass"}, 0){@Override
			    public boolean isCellEditable(int row, int column) {return false;}};
				
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
			Statement stmt = c.createStatement();
			String sql = "SELECT * FROM user2 WHERE role IN ('Owner', 'Chef', 'Delivery')";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String id = String.valueOf(rs.getInt("id"));
				String role = rs.getString("Role");
	            String pass = rs.getString("Password");
	            	
	            String[] data = {id, role, pass};
	            tm.addRow(data);
	          }
			
			JTable tbl = new JTable(tm);
			JScrollPane js = new JScrollPane(tbl);
			js.setBounds(10, 50, 250, 200);
			
			frame.getContentPane().setLayout(null);
			frame.getContentPane().add(js);
			frame.setSize(300,500);
			
			JTextField tf=new JTextField();
			JTextField tfp=new JTextField();
			JComboBox tfr=new JComboBox();
			tfr.addItem("owner");tfr.addItem("chef");tfr.addItem("delivery");
			
			JLabel del = new JLabel("Enter ID and press DELETE to drop staff");
			JLabel addpass = new JLabel("Password");
			JLabel addrole = new JLabel("Enter role and Press ADD to add staff");
			
			JButton delete = new JButton("DELETE");
			delete.addActionListener(new ActionListener(){  
	            public void actionPerformed(ActionEvent e){
	            	if(tf.getText().equals("1")) { JOptionPane.showMessageDialog(null, "Owner 1 can not be dropped");  }
	            	else {dropStaff(tf.getText());
	            	JOptionPane.showMessageDialog(null, "Staff with ID: "+tf.getText()+" dropped");
	            	frame.dispose();
	            	new Staff();
	            	}}});
			delete.setBounds(170,300,90,15);
			
			JButton add = new JButton("ADD");
			add.addActionListener(new ActionListener(){  
	            public void actionPerformed(ActionEvent e){  	          
	            	addStaff(tfr.getSelectedItem().toString(), tfp.getText());
	            	JOptionPane.showMessageDialog(null, "New "+tfr.getSelectedItem().toString()+" with pass: "+tfp.getText()+" added");
	            	frame.dispose();
	            	new Staff();
	            	}});
			add.setBounds(170,388,90,15);
			
			
			tf.setBounds(70,300,90,15);
			tfr.setBounds(70,362,90,20);
			tfp.setBounds(70,388,90,15);
			addpass.setBounds(10,388,63,15);addrole.setBounds(10,346,250,15);
			del.setBounds(10,280,250,15);
			
			frame.getContentPane().add(tf); frame.getContentPane().add(tfr); frame.getContentPane().add(tfp); 
			frame.getContentPane().add(delete); frame.getContentPane().add(add);
			frame.getContentPane().add(addpass); frame.getContentPane().add(addrole);
			frame.getContentPane().add(del); 
			
			JLabel lblId = new JLabel("ID");
			lblId.setBounds(10, 301, 63, 15);
			frame.getContentPane().add(lblId);
			
			JLabel lblRole = new JLabel("Role");
			lblRole.setBounds(10, 363, 63, 15);
			frame.getContentPane().add(lblRole);
			frame.setVisible(true);
			
			c.close();
			stmt.close();
			rs.close();
			}catch (ClassNotFoundException | SQLException e) {e.printStackTrace();}
	
	}


public void dropStaff(String id) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
		Statement stmt = c.createStatement();
		String sql = "DELETE FROM user2 WHERE id='"+Integer.parseInt(id)+"'";
		stmt.execute(sql);
		}catch (ClassNotFoundException | SQLException e) {e.printStackTrace();}
}	


public void addStaff(String role, String pass) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
		Statement stmt = c.createStatement();
		String sql = "INSERT INTO user2 (`Role`, `Password`) VALUES ('"+role+"', '"+pass+"')";
		stmt.execute(sql);
		}catch (ClassNotFoundException | SQLException e) {e.printStackTrace();}
}	
	
public static void main(String Args[]) {
	new Staff();
}
}
