import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class vathmologia {

	private JFrame frmRating;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vathmologia window = new vathmologia();
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
	public vathmologia() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmRating = new JFrame();
		frmRating.setTitle("Rating");
		frmRating.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmRating.setBounds(100, 100, 450, 300);
		frmRating.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRating.getContentPane().setLayout(null);
		frmRating.setVisible(true);
		
		ImageIcon png = new ImageIcon("src/logo.png");
        JLabel logo = new JLabel(png);
		logo.setBounds(111,113,200,150);
		frmRating.getContentPane().add(logo);
		
		Image icon = Toolkit.getDefaultToolkit().getImage("src/logo.png"); 
        frmRating.setIconImage(icon);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(158, 55, 46, 20);
		frmRating.getContentPane().add(spinner);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "H vathmologia sas kataxwrithike euxaristoume pou mas epileksate");
				frmRating.dispose();
				new kritiki();
			}
		});
		btnNewButton.setBounds(272, 55, 85, 21);
		frmRating.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Choose Stars");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 58, 105, 14);
		frmRating.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmRating.dispose();
				new kritiki();
			}
		});
		btnNewButton_1.setBounds(0, 11, 65, 23);
		frmRating.getContentPane().add(btnNewButton_1);
	}
}
