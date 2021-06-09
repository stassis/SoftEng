import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Notification {

	String role, msg, info;
	int nid, type;
	
	Notification (String role, int type, String info) {
		this.type = type;
		this.role = role;
		this.msg = msg;
		this.info = info;
	}
	
	public void addNotif(String role, int type, int info) {
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
	    String sql = "INSERT INTO `notification` (`role`, `type`, `info`) VALUES ('"+role+"','"+type+"','"+info+"')";	               		      
	    PreparedStatement pr = c.prepareStatement(sql);
	      
	    pr.execute();	               		      
	    c.close();	               		   
	    }
	    catch (Exception ee)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(ee.getMessage());
	    }
	}
	
	
	public void showNotif(String r) {
		
		JFrame frame = new JFrame("Notifications");
		frame.setLayout(null);
		frame.setSize(300,500);
		
		JButton back = new JButton("back");
		back.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){ 
            	frame.dispose();
            	new MainMenu();
            	}});
		back.setBounds(6,6,90,20);
		frame.getContentPane().add(back);
		
		Notification n = new Notification();
		DefaultTableModel tm = n.getNotif(r);
		int h = tm.getRowCount();
		
		JTable jt = new JTable(tm);		
		JScrollPane js=new JScrollPane(jt);
		
		js.setBounds(10, 40, 250, 150);
		frame.getContentPane().add(js);
		
		JButton drop = new JButton("Delete Notifications");
		drop.setBounds(45,240,180,40);
		drop.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            	JOptionPane.showMessageDialog(null, "Notifications deleted");
            	frame.dispose();
            	
            	for(int i=0; i < h; i++) {
            		dropNotif(Integer.parseInt((String)tm.getValueAt(i,0).toString()));
            	}
            	new MainMenu();
            	}});
		
		frame.getContentPane().add(drop);
		
		frame.setVisible(true);
		
	}
	
	
	
	
	
	public DefaultTableModel getNotif(String role) {
		
		DefaultTableModel tableModel = new DefaultTableModel(new String[]{"id", "type", "info"}, 0){@Override
		    public boolean isCellEditable(int row, int column) { return false;}};
		    
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
			Statement stmt = c.createStatement();
			String sql = "SELECT id,type,info FROM notification WHERE role = '"+role+"'";
			String txt = "";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
	            int type = rs.getInt("type");
	            	if(type == 0) {txt = "New order";}
	            	if(type == 1) {txt = "Order Ready";}
	            	if(type == 2) {txt = "Employee Late";}
	            	if(type == 3) {txt = "Ingredient Shortage";}
	            	
	            String info= rs.getString("info");
	            String id = String.valueOf(rs.getInt("id"));
	            String[] data = {id, txt, info};
	            tableModel.addRow(data);
	          }

			//JTable jt = new JTable(tableModel);
			//JScrollPane js=new JScrollPane(jt);
			//js.setBounds(64, 52, 287, 104);
			//frame.getContentPane().add(js);
			
			c.close();
			stmt.close();
			rs.close();
			
			
		}catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
	}
			return tableModel;
			
	}
	
	
	public void dropNotif(int id) {
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
	    String sql = "DELETE FROM notification WHERE id='"+id+"'";	               		      
	    PreparedStatement pr = c.prepareStatement(sql);
	      
	    pr.execute();	               		      
	    c.close();	               		   
	    }
	    catch (Exception ee)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(ee.getMessage());
	    }
	}
	
	
	Notification () {}
}
