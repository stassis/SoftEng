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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OriaElleipsis window = new OriaElleipsis();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
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
        
        JLabel lblEisagetename = new JLabel("Eisagete onoma Ylikoy:");
        lblEisagetename.setFont(new Font("Dialog", Font.PLAIN, 10));
        lblEisagetename.setBounds(40, 91, 114, 15);
        frame.getContentPane().add(lblEisagetename);
        
        JLabel lblNeoOrio = new JLabel("Neo Orio:");
        lblNeoOrio.setFont(new Font("Dialog", Font.PLAIN, 10));
        lblNeoOrio.setBounds(248, 90, 70, 15);
        frame.getContentPane().add(lblNeoOrio);
        
        JButton btnYpovolh = new JButton("Ypovolh");
        btnYpovolh.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		if(!(name.getText().length() == 0 || orio.getText().length() == 0)) {
        			
        			try {
        				
        				int orioInt=Integer.parseInt(orio.getText());
        			
        				if(orioInt >= 0) {
        					
        					pass = true;
        					
        					try {	
			        			
			        			Class.forName("com.mysql.cj.jdbc.Driver");
			        			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
			        			String sql = "SELECT * FROM food WHERE Fagito=?";
			
			        			PreparedStatement stmt = c.prepareStatement(sql);
			        			
				        		stmt.setString(1, name.getText());
				        		
				        		ResultSet rs = stmt.executeQuery();
				        		
				        		if(!rs.next()) {
				        			
				        			JOptionPane.showMessageDialog(null, "To yliko poy eisagate den yparxei!");
				        			pass = false;
				        			
				        			orio.setText("");
					        		name.setText("");
				        		}
				        		
				        		rs.close();
				        		stmt.close();
				        		c.close();
			        			
			        		}catch (ClassNotFoundException | SQLException e1) {
			        			
			        			e1.printStackTrace();
			        		}
        					
        					if(pass) {
				        		try {	
				        			
				        			Class.forName("com.mysql.cj.jdbc.Driver");
				        			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
				        			String sql = "UPDATE food SET Oriaellipsis=? WHERE Fagito=?";
				
				        			PreparedStatement stmt = c.prepareStatement(sql);
				        			stmt.setInt(1, orioInt);
					        		stmt.setString(2, name.getText());
					        		
					        		stmt.execute();
					        		
					        		stmt.close();
					        		c.close();
					        		
					        		JOptionPane.showMessageDialog(null, "Oria Ylikoy " + name.getText() +" allaxan se " + orioInt + "!");
					        		orio.setText("");
					        		name.setText("");
				        			
				        		}catch (ClassNotFoundException | SQLException e1) {
				        			
				        			e1.printStackTrace();
				        		}
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
