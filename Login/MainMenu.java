	import java.awt.event.*;  
    import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
    
    
public class MainMenu {
	
	
	
	MainMenu(String role,int id) {
        
		JFrame f = new JFrame("Welcome to P.Diner.A.");
		f.getContentPane().setLayout(null);
		
		JLabel lblID = new JLabel("User ID = "+id);
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
		f.getContentPane().add(lblRole);
		
		ImageIcon png = new ImageIcon("src/logo.png");
        JLabel logo = new JLabel(png);
		
		if(role.equals("Customer")) {
			
		JButton btnNewOrder = new JButton("Place an Order");
		btnNewOrder.setBounds(35, 60, 213, 50);
		f.getContentPane().add(btnNewOrder);
		
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
            	new Kratisi();
            	}});
            	
        
		logo.setBounds(41,280,200,150);
		}
		
		else if(role.equals("Chef")) {
			JButton btnPrepare = new JButton("Prepare an Order");
			btnPrepare.setBounds(35, 60, 213, 50);
			f.getContentPane().add(btnPrepare);
			
			JButton btnStorage = new JButton("Storage");
			btnStorage.setBounds(35, 130, 213, 50);
			f.getContentPane().add(btnStorage);
			btnStorage.addActionListener(new ActionListener(){  
	            public void actionPerformed(ActionEvent e){  
	            	f.dispose();
	            	new Apothiki();
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
	            	new Vardia();
	            	}});
			
			logo.setBounds(41,320,200,150);
			}
		
		else if(role.equals("Owner")) {
			JButton btnStaff = new JButton("Staff Management");
			btnStaff.setBounds(35, 60, 213, 50);
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
			
			logo.setBounds(41,320,200,150);
			}
		
		else if(role.equals("Delivery")) {
			JButton btnPrepare = new JButton("Deliver Order");
			btnPrepare.setBounds(35, 60, 213, 50);
			f.getContentPane().add(btnPrepare);
			
			JButton btnClock = new JButton("Clock In/out");
			btnClock.setBounds(35,130,213,50);
			f.getContentPane().add(btnClock);
			btnClock.addActionListener(new ActionListener(){  
	            public void actionPerformed(ActionEvent e){  
	            	f.dispose();
	            	new Vardia();
	            	}});
			
			logo.setBounds(41,210,200,150);
			}
		
		f.getContentPane().add(logo);
		f.setSize(300,500);
		f.setVisible(true);
	}
}
