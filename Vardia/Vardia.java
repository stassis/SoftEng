import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;


public class Vardia {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vardia window = new Vardia();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void showmain() {
		frame.show();
	}

	/**
	 * Create the application.
	 */
	public Vardia() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("P.Diner.A. Vardia");
		frame.setBounds(100, 100, 440, 402);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ImageIcon png = new ImageIcon("src/logo.png");
        JLabel logo = new JLabel(png);
        
        logo.setBounds(116, 236, 202, 111);
        frame.getContentPane().add(logo);
		
		JButton btnVardia = new JButton("Vardia");
		btnVardia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//frame.hide();
				frame.dispose();
				Screen scr = new Screen();
				scr.setVisible(true);
				
				
			}
		});
		btnVardia.setBounds(158, 125, 117, 25);
		frame.getContentPane().add(btnVardia);
	}
}
