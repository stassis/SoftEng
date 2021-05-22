import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.ButtonGroup;

public class TroposPlhrwmhs extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TroposPlhrwmhs frame = new TroposPlhrwmhs();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TroposPlhrwmhs() {
		setTitle("P.Diner.A Plhrwmh-Tropos Plhrwmhs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Epilekste tropo plhrwmhs");
		lblNewLabel.setBounds(110, 11, 174, 14);
		contentPane.add(lblNewLabel);
		
		JRadioButton rdbtn_metrhta = new JRadioButton("Plhrwmh me metrhta");
		rdbtn_metrhta.setSelected(true);
		buttonGroup.add(rdbtn_metrhta);
		rdbtn_metrhta.setBounds(110, 58, 158, 23);
		contentPane.add(rdbtn_metrhta);
		
		JRadioButton rdbtn_karta = new JRadioButton("Plhrwmh me karta");
		buttonGroup.add(rdbtn_karta);
		rdbtn_karta.setBounds(110, 111, 158, 23);
		contentPane.add(rdbtn_karta);
		
		JButton btnOK = new JButton("OK");
		btnOK.setBounds(124, 187, 89, 23);
		contentPane.add(btnOK);
		
		JLabel lbl_logo = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		lbl_logo.setIcon(new ImageIcon(img));
		lbl_logo.setBounds(78, 284, 213, 128);
		contentPane.add(lbl_logo);
	}
}
