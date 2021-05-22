import java.awt.event.*;  
    import javax.swing.*;
       
    public class Login extends JFrame {   
    	JFrame f=new JFrame("P.Diner.A. Log In");  
        JLabel wlc=new JLabel("Welcome to P.Diner.A."); 
        JLabel msg=new JLabel("Choose your role");
        
        ImageIcon png = new ImageIcon("src/logo.png");
        JLabel logo = new JLabel(png);
        String txt;
                
        public Login (){
        f.setBackground(new java.awt.Color(200, 200, 200));
        msg.setBackground(new java.awt.Color(200, 200, 200));
        
        wlc.setBounds(50,30,150,30);                      
        msg.setBounds(50,50,150,30);  
        logo.setBounds(20,300,200,150);
        
        JButton bcust=new JButton("Customer");  
        JButton bstaff=new JButton("Staff");
        
        bcust.setBounds(50,100,100,30); 
        bstaff.setBounds(50,150,100,30); 
        
        f.add(bcust);f.add(msg);f.add(bstaff);f.add(logo);f.add(wlc);
        
        f.setSize(300,500); f.setLayout(null); f.setVisible(true);  
        f.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent we) {System.exit(0);}});
        
        
        bcust.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            	f.remove(bcust);
            	f.remove(bstaff);
            	f.remove(msg);
            	txt = "customer";
            	f.setVisible(false);
            	new Login(txt, f);  
                }});
        
        bstaff.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            	f.remove(bcust);
            	f.remove(bstaff);
            	txt = "staff";
            	f.setVisible(false);
            	new Login(txt, f); 
                }});
        
        }
        
        public Login (String txt, JFrame f) {
        	if(txt.equals("staff") ) {
        		JButton own=new JButton("Owner");
            	JButton chef=new JButton("Chef");
                JButton del=new JButton("Delivery"); 
                
                own.setBounds(50,100,100,30); 
                chef.setBounds(50,150,100,30);
                del.setBounds(50,200,100,30); 
                
                f.add(own);f.add(chef);f.add(del);
                f.setVisible(true);
                
        }
        	else if(txt.equals("customer") ) {
        		JLabel n = new JLabel("Enter Password:");
        		n.setBounds(50,70,150,30);
        				
        		JTextField pass=new JTextField();
        		JButton ok=new JButton("Enter");
        		
        		ok.setBounds(50,130,100,30);
                pass.setBounds (50, 100, 150, 20);
                
        		f.add(pass); f.add(ok);f.add(n);
        		f.setVisible(true);
                
        	}
        }
    
    
public static void main(String Args[]) {
	new Login();
}
}
              
