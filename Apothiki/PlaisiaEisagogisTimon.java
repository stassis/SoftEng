import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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
import java.text.DateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
import java.util.*;
import java.text.*;

public class PlaisiaEisagogisTimon {

	private JFrame frame;
	private JTextField onomaYlikoy;
	private JTextField quantity;
	
	public void showplaisiatimwn() {
		frame.show();
	}

	/**
	 * Create the application.
	 */
	public PlaisiaEisagogisTimon() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("P.Diner.A. Add Ingredients");
		frame.setBounds(100, 100, 440, 402);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Image icon = Toolkit.getDefaultToolkit().getImage("src/logo.png"); 
        frame.setIconImage(icon);
		
		ImageIcon png = new ImageIcon("src/logo.png");
		frame.getContentPane().setLayout(null);
		JLabel logo = new JLabel(png);
		logo.setBounds(116, 236, 202, 111);
        frame.getContentPane().add(logo);
        
        onomaYlikoy = new JTextField();
        onomaYlikoy.setBounds(44, 112, 114, 19);
        frame.getContentPane().add(onomaYlikoy);
        onomaYlikoy.setColumns(10);
        
        
        quantity = new JTextField();
        quantity.setBounds(250, 112, 114, 19);
        frame.getContentPane().add(quantity);
        quantity.setColumns(10);
        
        
        
        JLabel lblOnomaYlikoy = new JLabel("Ingredient Name:");
        lblOnomaYlikoy.setFont(new Font("Dialog", Font.PLAIN, 10));
        lblOnomaYlikoy.setBounds(50, 85, 82, 15);
        frame.getContentPane().add(lblOnomaYlikoy);
        
        JLabel lblPosothta = new JLabel("Quantity:");
        lblPosothta.setFont(new Font("Dialog", Font.PLAIN, 10));
        lblPosothta.setBounds(250, 84, 70, 15);
        frame.getContentPane().add(lblPosothta);        
        
        JButton btnProsthiki = new JButton("ADD");
        btnProsthiki.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		String textFieldPosotita = quantity.getText();
        		
        		String textFieldYliko = onomaYlikoy.getText();
        		
        		//elegxos an kai ta 2 text fileds den exoun times
        		if(!(textFieldPosotita.length() == 0 || textFieldYliko.length() == 0)) {
        			
        			try {//elegxos an o arithmos posotitas einai integer i allos typos (catch statement)
        			
        			//metatropi tou textfiled posotita string se integer
        			int intFieldPosotita=Integer.parseInt(textFieldPosotita);
        			
        				if(intFieldPosotita >= 0) {//i posotita prepei na einai thetikos arithmos
        			
		        			try {
		        				
		        				//syndesi me ti vasi + ektelesi sql query
		        				Class.forName("com.mysql.cj.jdbc.Driver");
		    					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
		    	        		//Statement stmt = c.createStatement();
		    	        		String sql = "INSERT INTO `food`(`Fagito`, `Posotita`, `Imerominia`,`Oriaellipsis`) VALUES (?,?,?,2)";
		    	        		PreparedStatement stmt = c.prepareStatement(sql);
		    	        		stmt.setString(1, textFieldYliko);
		    	        		stmt.setInt(2, intFieldPosotita);
		    	        		stmt.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
		    	        		
		    	        		stmt.execute();
		    	        		
		    	        		//apeleytherosi porwn
		    	        		stmt.close();
		    	        		c.close();
		    	        		
		    	        		JOptionPane.showMessageDialog(null, "To Yliko " + textFieldYliko + " me posotita " + intFieldPosotita +" kataxwrithike!");
		    	        		quantity.setText("");
		    	        		onomaYlikoy.setText("");
		    	    			
		    				} catch (ClassNotFoundException | SQLException e1) {
		    					
		    					e1.printStackTrace();
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
        btnProsthiki.setBounds(142, 166, 117, 25);
        frame.getContentPane().add(btnProsthiki);
        
        JButton btnBack_1 = new JButton("Back");
        btnBack_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		frame.dispose();
        		
        		PliroforiesApothikis newwindow = new PliroforiesApothikis();
				newwindow.showpliroforiesapothikis();
        	}
        });
        btnBack_1.setBounds(12, 23, 67, 15);
        frame.getContentPane().add(btnBack_1);
	}
}
