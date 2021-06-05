import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class paraggelia_promitheion {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					paraggelia_promitheion window = new paraggelia_promitheion();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void showparaggelia_promitheion() {
		frame.show();
	}

	/**
	 * Create the application.
	 */
	public paraggelia_promitheion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("P.Diner.A. Paraggelia Promitheion");
		frame.setBounds(100, 100, 440, 402);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon png = new ImageIcon("src/logo.png");
		frame.getContentPane().setLayout(null);
		JLabel logo = new JLabel(png);
		logo.setBounds(116, 236, 202, 111);
        frame.getContentPane().add(logo);
        
        Image icon = Toolkit.getDefaultToolkit().getImage("src/logo.png"); 
        frame.setIconImage(icon); 
        
        JButton btninfo = new JButton("Apothiki");
        btninfo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		frame.dispose();
        		
        		paraggelia_promitheion_plhrofories newwindow = new paraggelia_promitheion_plhrofories();
				newwindow.showparaggelia_promitheion_plhrofories();        		
        	}
        });
        btninfo.setBounds(116, 47, 193, 25);
        frame.getContentPane().add(btninfo);
        
        
	}
}
