import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class OriaElleipsis {

	private JFrame frame;
	private JTextField name;
	private JTextField orio;
	private boolean pass;
	
	public void showporiaelleipsis() {
		frame.show();
	}

	/**
	 * Create the application.
	 */
	public OriaElleipsis() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("P.Diner.A. Allagi oriwn Elleipsis");
		frame.setBounds(100, 100, 440, 402);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Image icon = Toolkit.getDefaultToolkit().getImage("src/logo.png"); 
        frame.setIconImage(icon);
		
		ImageIcon png = new ImageIcon("src/logo.png");
		frame.getContentPane().setLayout(null);
		JLabel logo = new JLabel(png);
		logo.setBounds(116, 236, 202, 111);
        frame.getContentPane().add(logo);
        
        name = new JTextField();
        name.setBounds(40, 118, 114, 19);
        frame.getContentPane().add(name);
        name.setColumns(10);
        
        orio = new JTextField();
        orio.setBounds(244, 118, 114, 19);
        frame.getContentPane().add(orio);
        orio.setColumns(10);
        
        JLabel lblEisagetename = new JLabel("Ingredient Name:");
        lblEisagetename.setFont(new Font("Dialog", Font.PLAIN, 10));
        lblEisagetename.setBounds(40, 91, 114, 15);
        frame.getContentPane().add(lblEisagetename);
        
        JLabel lblNeoOrio = new JLabel("New Threshold:");
        lblNeoOrio.setFont(new Font("Dialog", Font.PLAIN, 10));
        lblNeoOrio.setBounds(248, 90, 70, 15);
        frame.getContentPane().add(lblNeoOrio);
        
        JButton btnYpovolh = new JButton("Submit");
        btnYpovolh.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		//elegxos an kai ta 2 text fileds den exoun times
        		if(!(name.getText().length() == 0 || orio.getText().length() == 0)) {
       			
        			try {//elegxos an o arithmos posotitas einai integer i allos typos (catch statement)
        				
        				//metatropi tou oriou string se integer
        				int orioInt=Integer.parseInt(orio.getText());
        			
        				if(orioInt >= 0) {
        					
        					pass = true;
        					
        					try {//*****Elegxos an yparxei to yliko sth vash. An den yparxei pass=false***** 	
			        			
			        			Class.forName("com.mysql.cj.jdbc.Driver");
			        			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
			        			String sql = "SELECT * FROM food WHERE Fagito=?";
			
			        			PreparedStatement stmt = c.prepareStatement(sql);
			        			
				        		stmt.setString(1, name.getText());
				        		
				        		ResultSet rs = stmt.executeQuery();
				        		
				        		if(!rs.next()) {//an den yparxei grammh pou epestrepse to ResulSet
				        			
				        			JOptionPane.showMessageDialog(null, "The ingredient you entered does not exist!");
				        			pass = false;
				        			
				        			//ekkatharisi textfields
				        			orio.setText("");
					        		name.setText("");
				        		}
				        		
				        		//apeleytherosi porwn
				        		rs.close();
				        		stmt.close();
				        		c.close();
			        			
			        		}catch (ClassNotFoundException | SQLException e1) {
			        			
			        			e1.printStackTrace();
			        		}//*****Elegxos an yparxei to yliko sth vash. An den yparxei pass=false*****
        					
        					if(pass) {//an yparxei to yliko sth vash
				        		try {//enhmerwse ta oria	
				        			
				        			Class.forName("com.mysql.cj.jdbc.Driver");
				        			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
				        			String sql = "UPDATE food SET Oriaellipsis=? WHERE Fagito=?";
				
				        			PreparedStatement stmt = c.prepareStatement(sql);
				        			stmt.setInt(1, orioInt);
					        		stmt.setString(2, name.getText());
					        		
					        		stmt.execute();
					        		
					        		//apeleutherosi porwn
					        		stmt.close();
					        		c.close();
					        		
					        		JOptionPane.showMessageDialog(null, "Ingredient " + name.getText() +"\'s threshold changed to " + orioInt + "!");
					        		orio.setText("");
					        		name.setText("");
				        			
				        		}catch (ClassNotFoundException | SQLException e1) {
				        			
				        			e1.printStackTrace();
				        		}
        					}
        					
	        				}else {
	        				
	        				JOptionPane.showMessageDialog(null, "Enter positive values(integer)!");
	        				
	        				}
        				
        			}catch(NumberFormatException e1) {
        				JOptionPane.showMessageDialog(null, "Enter positive values(integer)!"); 
     				   // Here catch NumberFormatException
     				   // So input is not a int.
     				 } 		
        			
        		}else {
        			
        			JOptionPane.showMessageDialog(null, "Please fill in the textfields!");
        			
        		}
        		
        	}
        });
        btnYpovolh.setBounds(133, 171, 117, 25);
        frame.getContentPane().add(btnYpovolh);
        
        JButton btnBack_1 = new JButton("Back");
        btnBack_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		frame.dispose();
        		
        		Apothiki newwindow = new Apothiki();
				newwindow.showapothiki();
        	}
        });
        btnBack_1.setBounds(12, 43, 67, 15);
        frame.getContentPane().add(btnBack_1);
         
	}

}
