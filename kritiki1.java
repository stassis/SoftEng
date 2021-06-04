import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;

public class kritiki1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kritiki1 window = new kritiki1();
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
	public kritiki1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(133, 10, 211, 92);
		frame.getContentPane().add(editorPane);
		
		JLabel lblNewLabel = new JLabel("grapste thn kritiki sas");
		lblNewLabel.setBounds(10, 22, 101, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("upovolh");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				kritiki k = new kritiki();
				k.initialize();
				JOptionPane.showMessageDialog(null, "H kritiki sas kataxwrithike euxaristoume pou mas epileksate");
				
			}
		});
		btnNewButton.setBounds(185, 132, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(kritiki1.class.getResource("/source/logo.png")));
		lblNewLabel_1.setBounds(133, 163, 211, 90);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
