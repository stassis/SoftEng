import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vathmologia {

	private JFrame frame;
	private JTextField txtEpileksteAsteria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vathmologia window = new vathmologia();
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
	public vathmologia() {
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
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(vathmologia.class.getResource("/source/logo.png")));
		lblNewLabel.setBounds(105, 146, 209, 107);
		frame.getContentPane().add(lblNewLabel);
		
		txtEpileksteAsteria = new JTextField();
		txtEpileksteAsteria.setText("epilekste asteria");
		txtEpileksteAsteria.setBounds(10, 55, 96, 19);
		frame.getContentPane().add(txtEpileksteAsteria);
		txtEpileksteAsteria.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(158, 55, 46, 20);
		frame.getContentPane().add(spinner);
		
		JButton btnNewButton = new JButton("upovolh");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				kritiki k = new kritiki();
				k.initialize();
				JOptionPane.showMessageDialog(null, "H vathmologia sas kataxwrithike euxaristoume pou mas epileksate");
			}
		});
		btnNewButton.setBounds(142, 115, 85, 21);
		frame.getContentPane().add(btnNewButton);
	}

}
