
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
    
    
public class MainMenu {
	
	MainMenu(String role,int id) {
		try{
		      Class.forName("com.mysql.cj.jdbc.Driver");
		      Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
		      
		      String sql = "UPDATE `lastlog` SET `id`=?,`Role`=? WHERE 1";	               		      
			     
		      PreparedStatement pr = c.prepareStatement(sql);
		      
		      pr.setString (2, role);pr.setInt (1, id);
		      pr.execute();c.close();	               		   
		    }
		    catch (Exception ee)
		    {
		      System.err.println("Got an exception!");
		      System.err.println(ee.getMessage());
		    }
		
        JFrame f = new JFrame("Welcome to P.Diner.A.");
		f.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0,0,285,40);
		f.getContentPane().add(toolBar);
		
		toolBar.setRollover(true);
		
		JButton btnNotif = new JButton("Notifications");
		btnNotif.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            	f.dispose();
            	Notification n = new Notification();
            	n.showNotif(role);
            	}});
		
		JLabel lblid = new JLabel("<html>User ID: "+id+". <br> Role: "+role+"</html>");
		lblid.setHorizontalAlignment(SwingConstants.LEFT);
		lblid.setFont(new Font("Calibri", Font.BOLD, 13));
		lblid.setForeground(Color.RED);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            	f.dispose();
            	new Login();
            	}});
		
		toolBar.add(lblid); 
		toolBar.add(Box.createGlue());
		toolBar.add(btnNotif);
		toolBar.addSeparator();
		toolBar.add(btnLogout);
						
		//f.getContentPane().setLayout(BorderLayout);
		
		/*JLabel lblID = new JLabel("User ID = "+id);
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setFont(new Font("Calibri", Font.BOLD, 13));
		lblID.setBounds(195, 0, 89, 23);
		lblID.setForeground(Color.RED);
		lblID.setBackground(UIManager.getColor(Color.BLACK));
		f.getContentPane().add(lblID);
				
		JLabel lblRole = new JLabel(role);
		lblRole.setHorizontalAlignment(SwingConstants.CENTER);
		lblRole.setForeground(Color.RED);
		lblRole.setFont(new Font("Calibri", Font.BOLD, 13));
		lblRole.setBackground((Color) null);
		lblRole.setBounds(195, 11, 89, 28);
		f.getContentPane().add(lblRole);*/
		
		ImageIcon png = new ImageIcon("src/logo.png");
        JLabel logo = new JLabel(png);
		
		if(role.equals("Customer")) {
			
		JButton btnNewOrder = new JButton("Place an Order");
		btnNewOrder.setBounds(35, 60, 213, 50);
		f.getContentPane().add(btnNewOrder);
		btnNewOrder.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            	f.dispose();
            	TroposParadoshs scr=new TroposParadoshs();
            	scr.setVisible(true);
            	}});
		
		
		JButton btnReview = new JButton("Leave a Review");
		btnReview.setBounds(35, 200, 213, 50);
		f.getContentPane().add(btnReview);
		btnReview.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            	f.dispose();
            	new kritiki();
            	}});
		
		JButton btnReservation = new JButton("Make a Reservation");
		btnReservation.setBounds(35, 130, 213, 50);
		f.getContentPane().add(btnReservation);
		btnReservation.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            	f.dispose();
            	new Kratisi(id);
            	}});
            	
        
		logo.setBounds(41,330,200,150);
		}
		
		else if(role.equals("Chef")) {
			JButton btnPrepare = new JButton("Prepare an Order");
			btnPrepare.setBounds(35, 60, 213, 50);
			f.getContentPane().add(btnPrepare);
			btnPrepare.addActionListener(new ActionListener(){  
	            public void actionPerformed(ActionEvent e){  
	            	f.dispose();
	            	new Proetoimasia();
	            	}});
			
			JButton btnStorage = new JButton("Storage");
			btnStorage.setBounds(35, 130, 213, 50);
			f.getContentPane().add(btnStorage);
			btnStorage.addActionListener(new ActionListener(){  
	            public void actionPerformed(ActionEvent e){  
	            	f.dispose();
	            	new Apothiki().showapothiki();
	            	}});
			
			JButton btnMenu = new JButton("Menu");
			btnMenu.setBounds(35, 200, 213, 50);
			f.getContentPane().add(btnMenu);
			
			JButton btnClock = new JButton("Clock In/out");
			btnClock.setBounds(35,270,213,50);
			f.getContentPane().add(btnClock);
			btnClock.addActionListener(new ActionListener(){  
	            public void actionPerformed(ActionEvent e){  
	            	f.dispose();
	            	new Vardia().setVisible(true);
	            	}});
			
			logo.setBounds(41,330,200,150);
			}
		
		else if(role.equals("Owner")) {
			JButton btnStaff = new JButton("Staff Management");
			btnStaff.setBounds(35, 60, 213, 50);
			btnStaff.addActionListener(new ActionListener(){  
	            public void actionPerformed(ActionEvent e){  
	            	f.dispose();
	            	new Staff();
	            	}});
			f.getContentPane().add(btnStaff);
			
			JButton btnSched = new JButton("Staff Schedule");
			btnSched.setBounds(35, 130, 213, 50);
			f.getContentPane().add(btnSched);
			btnSched.addActionListener(new ActionListener(){  
	            public void actionPerformed(ActionEvent e){  
	            	f.dispose();
	            	new orario();
	            	}});
			
			JButton btnMenu = new JButton("Menu");
			btnMenu.setBounds(35, 200, 213, 50);
			f.getContentPane().add(btnMenu);
			btnMenu.addActionListener(new ActionListener(){  
	            public void actionPerformed(ActionEvent e){  
	            	f.dispose();
	            	new idioktitismenou();
	            	}});
			
			JButton btnItems = new JButton("Order Items");
			btnItems.setBounds(35,270,213,50);
			f.getContentPane().add(btnItems);
			
			logo.setBounds(41,330,200,150);
			}
		
		else if(role.equals("Delivery")) {
			JButton btnPrepare = new JButton("Deliver Order");
			btnPrepare.setBounds(35, 60, 213, 50);
			f.getContentPane().add(btnPrepare);
			btnPrepare.addActionListener(new ActionListener(){  
	            public void actionPerformed(ActionEvent e){  
	            	f.dispose();
	            	new ParadosiParaggelias();
					ParadosiParaggelias.main(null);
	        }});
			
			JButton btnClock = new JButton("Clock In/out");
			btnClock.setBounds(35,130,213,50);
			f.getContentPane().add(btnClock);
			btnClock.addActionListener(new ActionListener(){  
	            public void actionPerformed(ActionEvent e){  
	            	f.dispose();
	            	new Vardia().setVisible(true);
	        }});
			
			logo.setBounds(41,210,200,150);
			}
		
		f.getContentPane().add(logo);
		f.setSize(300,500);
		f.setVisible(true);
	}
	
	
	MainMenu() {
		int nd=0; String nr="";
		try{
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
	      Statement stmt = c.createStatement();
	      String sql = "SELECT `role`,`id` FROM lastlog";	               		      
	      ResultSet rs = stmt.executeQuery(sql);
	      
	      while (rs.next()) {nd = rs.getInt("id");
	      nr = rs.getString("role");}
	      
	      new MainMenu(nr, nd);	                    		      
	      c.close();	               		   
	    }
	    catch (Exception ee)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(ee.getMessage());
	    }
	}
}


