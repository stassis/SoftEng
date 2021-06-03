import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class orario {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					orario window = new orario();
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
	public orario() {
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
		
		JButton btnNewButton = new JButton("orario");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				orario_info oi= new orario_info();
				oi.setVisible(true);
			
			}
		});
		btnNewButton.setBounds(167, 63, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}

}
