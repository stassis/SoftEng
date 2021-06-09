
	import java.awt.event.*;  
    import javax.swing.*;

import java.sql.*;
       
    public class Login extends JFrame {   
    	JFrame f=new JFrame("P.Diner.A. Log In");  
        JLabel wlc=new JLabel("Welcome to P.Diner.A."); 
        JLabel msg=new JLabel("Choose your role");
        
        ImageIcon png = new ImageIcon("src/logo.png");
        JLabel logo = new JLabel(png);
        
        JButton bcust=new JButton("Customer");  
        JButton bstaff=new JButton("Staff");
        JButton own=new JButton("Owner");
    	JButton chef=new JButton("Chef");
        JButton del=new JButton("Delivery"); 
        JButton enter=new JButton("Enter");
        JButton back = new JButton("back");
        
        //JTextField tfid = new JTextField();
        JTextField tf=new JTextField();
        String role, pass;
        int sw; //switch to dispose after completion
        
        
        
        
        public Login (){
        f.setBackground(new java.awt.Color(200, 200, 200));
                
        wlc.setBounds(42,41,150,30);                      
        msg.setBounds(42,59,150,30);  
        logo.setBounds(15,251,200,150);
        own.setBounds(67,100,100,30); 
        chef.setBounds(67,150,100,30);
        del.setBounds(67,200,100,30); 
        bcust.setBounds(67,100,100,30); 
        bstaff.setBounds(67,150,100,30); 
        enter.setBounds(67,150,100,30);
        back.setBounds(6, 6, 71, 23);
        tf.setBounds(67,115,100,30);
        
        wlc.setHorizontalAlignment(SwingConstants.CENTER);
        msg.setHorizontalAlignment(SwingConstants.CENTER);
        
        f.getContentPane().setLayout(null);
        
        f.getContentPane().add(bcust);f.getContentPane().add(msg);f.getContentPane().add(bstaff);f.getContentPane().add(logo);f.getContentPane().add(wlc);
        
        
        
        f.setSize(250,500);  f.setVisible(true);  
        
        f.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent we) {System.exit(0);}});
        
        
        bcust.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            	f.remove(bcust);
            	f.remove(bstaff);
            	msg.setText("Enter your Password");
            	f.getContentPane().add(tf);
            	f.getContentPane().add(enter);
            	f.getContentPane().add(back);
            	role = "Customer";
            	f.setVisible(false);f.setVisible(true);
            	}});
        
        bstaff.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            	f.remove(bcust);
            	f.remove(bstaff);
            	f.getContentPane().add(own);f.getContentPane().add(chef);f.getContentPane().add(del);
            	f.getContentPane().add(back);
            	f.setVisible(false);f.setVisible(true);
            	}});
                
        own.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            	f.remove(own);f.remove(chef);f.remove(del);
            	msg.setText("Enter your Password");
            	f.getContentPane().add(tf);
            	f.getContentPane().add(enter);
            	role = "Owner";
            	f.setVisible(false);f.setVisible(true);
            	}});
        
        chef.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){ 
            	role = "Chef";
            	f.remove(own);f.remove(chef);f.remove(del);
            	msg.setText("Enter your Password");
            	f.getContentPane().add(tf);
            	f.getContentPane().add(enter);
            	f.setVisible(false);f.setVisible(true);
            	}});
        
        del.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            	f.remove(own);f.remove(chef);f.remove(del);
            	msg.setText("Enter your Password");
            	f.getContentPane().add(tf);//f.add(tfid);
            	f.getContentPane().add(enter);
            	role = "Delivery";
            	f.setVisible(false);f.setVisible(true);
            	}});
        
        back.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            	f.dispose();
            	new Login();
            	}});
       
        enter.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            	
            	pass = tf.getText();
            	try {
					sw = checkPass(pass,role);
					if(sw==0)	{f.dispose();}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            	
            	}});
        
        }
        
        
        
public int checkPass(String ck_pass, String ck_role) throws SQLException {
        	String rrole="";
        	int id = 0;
        	
        	try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
			
			String sql = "SELECT * FROM user2 WHERE Password='"+ck_pass+"' and Role='"+ck_role+"'";
			
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			int count=0;
			while(rs.next()) {
				id = rs.getInt("id");
				rrole = rs.getString("Role");
				count++;}
			
			if(count==1) { //success
				new MainMenu(rrole,id); 
				sw = 0;}
			
			else if(ck_role.equals("Customer")) { //creates new customer with chosen pass
				new User(ck_role,ck_pass); 
				JOptionPane.showMessageDialog(null, "A new account with password \""+ck_pass+"\" created");
				sw = 0;
				checkPass(ck_pass,ck_role);}
				
			else if(count==0) {
				JOptionPane.showMessageDialog(null, "Wrong Password");
				sw = 1;}
        	}

        	catch (ClassNotFoundException e) {e.printStackTrace();}
    			
        	return sw;
        }
    
    
public static void main(String Args[]) {
	new Login();
}
}
              
