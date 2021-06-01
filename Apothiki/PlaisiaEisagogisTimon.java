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
	private JTextField posotita;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlaisiaEisagogisTimon window = new PlaisiaEisagogisTimon();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
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
		frame = new JFrame("P.Diner.A. Plaisia Eisagogis Timon");
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
        
        
        posotita = new JTextField();
        posotita.setBounds(250, 112, 114, 19);
        frame.getContentPane().add(posotita);
        posotita.setColumns(10);
        
        
        
        JLabel lblOnomaYlikoy = new JLabel("Onoma Ylikoy:");
        lblOnomaYlikoy.setFont(new Font("Dialog", Font.PLAIN, 10));
        lblOnomaYlikoy.setBounds(50, 85, 82, 15);
        frame.getContentPane().add(lblOnomaYlikoy);
        
        JLabel lblPosothta = new JLabel("Posothta:");
        lblPosothta.setFont(new Font("Dialog", Font.PLAIN, 10));
        lblPosothta.setBounds(250, 84, 70, 15);
        frame.getContentPane().add(lblPosothta);
        
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
        //LocalDateTime now = LocalDateTime.now();  
        //System.out.println(dtf.format(now)); 
        
        
        JButton btnProsthiki = new JButton("Prosthiki");
        btnProsthiki.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		String textFieldPosotita = posotita.getText();
        		
        		String textFieldYliko = onomaYlikoy.getText();
        		
        		if(!(textFieldPosotita.length() == 0 || textFieldYliko.length() == 0)) {
        			
        			try {
        				
        			int intFieldPosotita=Integer.parseInt(textFieldPosotita);
        			
        				if(intFieldPosotita >= 0) {
        			
		        			try {
		            			
		        				//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		        				//Date date = new Date();
		        				
		        				Class.forName("com.mysql.cj.jdbc.Driver");
		    					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
		    	        		//Statement stmt = c.createStatement();
		    	        		String sql = "INSERT INTO `food`(`Fagito`, `Posotita`, `Imerominia`,`Oriaellipsis`) VALUES (?,?,?,2)";
		    	        		PreparedStatement stmt = c.prepareStatement(sql);
		    	        		stmt.setString(1, textFieldYliko);
		    	        		stmt.setInt(2, intFieldPosotita);
		    	        		stmt.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
		    	        		
		    	        		stmt.execute();
		    	        		
		    	        		stmt.close();
		    	        		c.close();
		    	        		
		    	        		JOptionPane.showMessageDialog(null, "To Yliko " + textFieldYliko + " me posotita " + intFieldPosotita +" kataxwrithike!");
		    	        		posotita.setText("");
		    	        		onomaYlikoy.setText("");
		    	    			
		    				} catch (ClassNotFoundException | SQLException e1) {
		    					
		    					e1.printStackTrace();
		    				}
		        			
        				}else {
            				
            				JOptionPane.showMessageDialog(null, "Eisagete thetikes times(akeraies)!");
            				
            			}
        			}catch(NumberFormatException e1) {
        				JOptionPane.showMessageDialog(null, "Eisagete thetikes times(akeraies)!"); 
     				   // Here catch NumberFormatException
     				   // So input is not a int.
     				 } 	
        		}else {
        			
        			JOptionPane.showMessageDialog(null, "Symplhrwste stoixeia!");
        			
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
