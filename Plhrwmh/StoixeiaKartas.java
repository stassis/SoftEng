import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class StoixeiaKartas extends JFrame {

	private JPanel contentPane;
	private JTextField txtArithmosKartas;
	private JTextField txtOnomaKartas;
	private JTextField txtMhnasLhkshs;
	private JTextField txtEtosLhksh;
	private JTextField txtCCV2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoixeiaKartas frame = new StoixeiaKartas();
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
	public StoixeiaKartas() {
		setTitle("P.Diner.A Plhrwmh-Stoixeia Kartas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Eisagete ta stoixeia ths kartas");
		lblNewLabel.setBounds(100, 11, 172, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Arithmos kartas:");
		lblNewLabel_1.setBounds(20, 43, 100, 14);
		contentPane.add(lblNewLabel_1);
		
		txtArithmosKartas = new JTextField();
		txtArithmosKartas.setBounds(120, 40, 227, 20);
		contentPane.add(txtArithmosKartas);
		txtArithmosKartas.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Onoma katoxou:");
		lblNewLabel_2.setBounds(20, 89, 100, 14);
		contentPane.add(lblNewLabel_2);
		
		txtOnomaKartas = new JTextField();
		txtOnomaKartas.setBounds(120, 86, 227, 20);
		contentPane.add(txtOnomaKartas);
		txtOnomaKartas.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Hmeromhnia lhkshs kartas:");
		lblNewLabel_3.setBounds(20, 131, 172, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mhnas:");
		lblNewLabel_4.setBounds(20, 159, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		txtMhnasLhkshs = new JTextField();
		txtMhnasLhkshs.setBounds(65, 156, 86, 20);
		contentPane.add(txtMhnasLhkshs);
		txtMhnasLhkshs.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Etos:");
		lblNewLabel_5.setBounds(175, 159, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		txtEtosLhksh = new JTextField();
		txtEtosLhksh.setBounds(224, 156, 86, 20);
		contentPane.add(txtEtosLhksh);
		txtEtosLhksh.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("CCV2:");
		lblNewLabel_6.setBounds(20, 205, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		txtCCV2 = new JTextField();
		txtCCV2.setBounds(65, 202, 86, 20);
		contentPane.add(txtCCV2);
		txtCCV2.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBounds(133, 244, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lbl_logo = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		lbl_logo.setIcon(new ImageIcon(img));
		lbl_logo.setBounds(78, 284, 213, 128);
		contentPane.add(lbl_logo);
	}
}
