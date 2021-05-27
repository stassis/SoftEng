import java.awt.event.*;  
    import javax.swing.*;
       
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
        JTextField tf=new JTextField();
        String role, pass, s = "1"; //checkPass
        
        
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
        tf.setBounds(50,100,100,30);
        f.setLayout(null);
        
        f.add(bcust);f.add(msg);f.add(bstaff);f.add(logo);f.add(wlc);
        f.setSize(500,500);  f.setVisible(true);  
        
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
            	f.add(tf);
            	f.add(enter);
            	role = "del";
            	f.setVisible(false);f.setVisible(true);
            	}});
       
        enter.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            	//to be replace by checkPass()
            	pass = tf.getText();
            	if(pass.equals(s)) {
            		f.dispose();
            		new MainMenu();
            	}
            	}});
        
        }
        
        
    
    
public static void main(String Args[]) {
	new Login();
}
}
              
