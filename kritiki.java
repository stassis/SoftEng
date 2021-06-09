import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class kritiki {

	private JFrame frmRating;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kritiki window = new kritiki();
					window.frmRating.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public kritiki() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		frmRating = new JFrame();
		frmRating.setTitle("Rating");
		frmRating.setBounds(100, 100, 450, 300);
		frmRating.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRating.setLayout(null);
		frmRating.setVisible(true);
		
		Image icon = Toolkit.getDefaultToolkit().getImage("src/logo.png"); 
        frmRating.setIconImage(icon); 
        
		JButton btnkritiki = new JButton("Short Text");
		btnkritiki.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmRating.dispose();
				new kritiki1();
				
				
			}
		});
		btnkritiki.setBounds(144, 10, 114, 40);
		frmRating.getContentPane().add(btnkritiki);
		
		JButton btnNewButton_1 = new JButton("Rate with Stars");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmRating.dispose();
				new vathmologia();
				
			}
		});
		btnNewButton_1.setBounds(144, 72, 114, 32);
		frmRating.getContentPane().add(btnNewButton_1);

		ImageIcon png = new ImageIcon("src/logo.png");
        JLabel logo = new JLabel(png);
		logo.setBounds(110,113,200,150);
		frmRating.getContentPane().add(logo);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmRating.dispose();
				new MainMenu();
			}
		});
		btnNewButton.setBounds(0, 10, 74, 23);
		frmRating.getContentPane().add(btnNewButton);
	}
}
	