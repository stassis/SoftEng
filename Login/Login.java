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
        String role, id, pass;
        
        
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
            	role = "customer";
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
            	role = "owner";
            	f.setVisible(false);f.setVisible(true);
            	}});
        
        chef.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            	f.remove(own);f.remove(chef);f.remove(del);
            	msg.setText("Enter your Password");
            	f.add(tf);
            	f.add(enter);
            	role = "chef";
            	f.setVisible(false);f.setVisible(true);
            	}});
        
        del.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            	f.remove(own);f.remove(chef);f.remove(del);
            	msg.setText("Enter your Password");
            	f.add(tf);//f.add(tfid);
            	f.add(enter);
            	role = "del";
            	f.setVisible(false);f.setVisible(true);
            	}});
       
        enter.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            	
            	pass = tf.getText();
            	try {
					checkPass(pass);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            	
            	}});
        
        }
        
        
        
        public void checkPass(String user_pass) throws SQLException {
        	String user_id, role="";
        	
        	try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
			
			String sql = "SELECT * FROM user2 WHERE Password='"+user_pass+"'";
			
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			int count=0;
			while(rs.next()) {
				user_id = rs.getString("id");
				role = rs.getString("Role");
				count++;}
			
			if(count==1) {
				new MainMenu(role);}
			else { new User("3","Chef","hhh");}
        	}
        	
        	catch (ClassNotFoundException e) {
    			
    			e.printStackTrace();
    		}
        	
        }
    
    
public static void main(String Args[]) {
	new Login();
}
}
              
