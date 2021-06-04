import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class idioktitismenou {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					idioktitismenou window = new idioktitismenou();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public idioktitismenou() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(idioktitismenou.class.getResource("/source/logo.png")));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JButton btnNewButton_1 = new JButton("MENOU");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "To Menou hmeras perilamvanei:Pastitsio,Faghta ths wras sta karvouna,mpriam,mousaka");
			}
		});
		btnNewButton_1.setBounds(151, 33, 109, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("kostologhsh");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				kostologhsh k = new kostologhsh();
				k.initialize();
			}
		});
		btnNewButton.setBounds(151, 102, 109, 21);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(idioktitismenou.class.getResource("/source/logo.png")));
		lblNewLabel.setBounds(88, 153, 276, 100);
		frame.getContentPane().add(lblNewLabel);
	}

}
