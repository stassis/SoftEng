    import java.awt.event.*;  
    import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Window.Type;
       
    public class Login extends JFrame {   
    	JFrame f=new JFrame("P.Diner.A. Log In");  
        
        ImageIcon png = new ImageIcon("src/logo.png");
        String txt;
                
        public Login (){
        f.setBackground(new java.awt.Color(200, 200, 200));
        
        f.setSize(300,500);f.setVisible(true);  
        f.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent we) {System.exit(0);}});
        
        }
        
        public Login (String txt, JFrame f) {
        	if(txt.equals("staff") ) {
        		JButton own=new JButton("Owner");
            	JButton chef=new JButton("Chef");
                JButton del=new JButton("Delivery"); 
                
                own.setBounds(50,100,100,30); 
                chef.setBounds(50,150,100,30);
                del.setBounds(50,200,100,30); 
                
                f.getContentPane().add(own);f.getContentPane().add(chef);f.getContentPane().add(del);
                f.setVisible(true);
                
        }
        	else if(txt.equals("customer") ) {
        		JLabel n = new JLabel("Enter Password:");
        		n.setBounds(50,70,150,30);
        				
        		JTextField pass=new JTextField();
        		JButton ok=new JButton("Enter");
        		
        		ok.setBounds(50,130,100,30);
                pass.setBounds (50, 100, 150, 20);
                
        		f.getContentPane().add(pass); f.getContentPane().add(ok);f.getContentPane().add(n);
        		f.setVisible(true);
                
        	}
        }
    
    
public static void main(String Args[]) {
	new Login();
}
}
              

