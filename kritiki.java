import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class kritiki {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kritiki window = new kritiki();
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
	public kritiki() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(kritiki.class.getResource("/source/logo.png")));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JButton btnkritiki = new JButton("kritiki");
		btnkritiki.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				kritiki1 k1 = new kritiki1();
				k1.initialize();
				
			}
		});
		btnkritiki.setBounds(144, 10, 114, 40);
		frame.getContentPane().add(btnkritiki);
		
		JButton btnNewButton_1 = new JButton("vathmologia");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				vathmologia v = new vathmologia();
				v.initialize();
			}
		});
		btnNewButton_1.setBounds(144, 72, 114, 32);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(kritiki.class.getResource("/source/logo.png")));
		lblNewLabel.setBounds(99, 128, 258, 111);
		frame.getContentPane().add(lblNewLabel);
	}

}
	