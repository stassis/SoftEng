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
        //JTextField tfid = new JTextField();
        JTextField tf=new JTextField();
        String role, pass;
        int sw; //switch to dispose after completion
        
        
        public Login (){
        f.setBackground(new java.awt.Color(200, 200, 200));
                
        wlc.setBounds(50,30,150,30);                      
        msg.setBounds(50,50,150,30);  
        logo.setBounds(20,300,200,150);
        own.setBounds(50,100,100,30); 
        chef.setBounds(50,150,100,30);
        del.setBounds(50,200,100,30); 
        bcust.setBounds(50,100,100,30); 
        bstaff.setBounds(50,150,100,30); 
        enter.setBounds(50,150,100,30);
        //tfid.setBounds(50,80,100,30);
        tf.setBounds(50,115,100,30);
        f.setLayout(null);
        
        f.add(bcust);f.add(msg);f.add(bstaff);f.add(logo);f.add(wlc);
        f.setSize(300,500);  f.setVisible(true);  
        
        f.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent we) {System.exit(0);}});
        
        
        bcust.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            	f.remove(bcust);
            	f.remove(bstaff);
            	msg.setText("Enter your Password");
            	f.add(tf);
            	f.add(enter);
            	role = "Customer";
            	f.setVisible(false);f.setVisible(true);
            	}});
        
        bstaff.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            	f.remove(bcust);
            	f.remove(bstaff);
            	f.add(own);f.add(chef);f.add(del);
            	f.setVisible(false);f.setVisible(true);
            	}});
                
        own.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            	f.remove(own);f.remove(chef);f.remove(del);
            	msg.setText("Enter your Password");
            	f.add(tf);
            	f.add(enter);
            	role = "Owner";
            	f.setVisible(false);f.setVisible(true);
            	}});
        
        chef.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){ 
            	role = "Chef";
            	f.remove(own);f.remove(chef);f.remove(del);
            	msg.setText("Enter your Password");
            	f.add(tf);
            	f.add(enter);
            	f.setVisible(false);f.setVisible(true);
            	}});
        
        del.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            	f.remove(own);f.remove(chef);f.remove(del);
            	msg.setText("Enter your Password");
            	f.add(tf);//f.add(tfid);
            	f.add(enter);
            	role = "Delivery";
            	f.setVisible(false);f.setVisible(true);
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
				checkPass(ck_pass,ck_role);
				sw = 0;}
				
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
              
