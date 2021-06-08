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

public class Apothiki {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apothiki window = new Apothiki();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void showapothiki() {
		frame.show();
	}

	/**
	 * Create the application.
	 */
	public Apothiki() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("P.Diner.A. Apothiki");
		frame.setBounds(100, 100, 440, 402);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon png = new ImageIcon("src/logo.png");
		frame.getContentPane().setLayout(null);
		JLabel logo = new JLabel(png);
		logo.setBounds(116, 236, 202, 111);
        frame.getContentPane().add(logo);
        
        Image icon = Toolkit.getDefaultToolkit().getImage("src/logo.png"); 
        frame.setIconImage(icon); 
        
        JButton btnApothiki = new JButton("Storage");
        btnApothiki.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		frame.dispose();
        		
        		PliroforiesApothikis newwindow = new PliroforiesApothikis();
				newwindow.showpliroforiesapothikis();
        		
        	}
        });
        btnApothiki.setBounds(116, 47, 193, 25);
        frame.getContentPane().add(btnApothiki);
        
        JButton btnAllagiOriwnElleipsis = new JButton("Change Thresholds");
        btnAllagiOriwnElleipsis.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		frame.dispose();
        		
        		OriaElleipsis newwindow = new OriaElleipsis();
				newwindow.showporiaelleipsis();
        	}
        });
        btnAllagiOriwnElleipsis.setBounds(116, 99, 193, 25);
        frame.getContentPane().add(btnAllagiOriwnElleipsis);
        
        JButton btnNewButton = new JButton("Expired Ingredients");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		frame.dispose();
        		
        		AlloiwmenaYlika newwindow;
				try {
					
					newwindow = new AlloiwmenaYlika();
					newwindow.showpligmenaylika();
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
        	}
        });
        btnNewButton.setBounds(116, 150, 193, 25);
        frame.getContentPane().add(btnNewButton);
	}
}
