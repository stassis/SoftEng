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

public class Delivery_SumplhrwshStoixeiwn extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delivery_SumplhrwshStoixeiwn frame = new Delivery_SumplhrwshStoixeiwn();
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
	public Delivery_SumplhrwshStoixeiwn() {
		setTitle("P.Diner.A Delivery-Stoixeia Paraggelias");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_logo = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		lbl_logo.setIcon(new ImageIcon(img));
		lbl_logo.setBounds(83, 282, 202, 119);
		contentPane.add(lbl_logo);
		
		JLabel lblNewLabel_1 = new JLabel("Sumplhrwste ta stoixeia tis paraggelias");
		lblNewLabel_1.setBounds(74, 11, 300, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Onomatepwnumo:");
		lblNewLabel_2.setBounds(21, 46, 112, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(143, 43, 182, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Odos kai arithmos:");
		lblNewLabel_3.setBounds(21, 94, 123, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(143, 91, 182, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Orofos:");
		lblNewLabel_4.setBounds(21, 137, 56, 14);
		contentPane.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(74, 134, 56, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Thlefwno:");
		lblNewLabel_5.setBounds(20, 178, 70, 14);
		contentPane.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(84, 175, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Koudouni:");
		lblNewLabel_6.setBounds(143, 137, 70, 14);
		contentPane.add(lblNewLabel_6);
		
		textField_4 = new JTextField();
		textField_4.setBounds(202, 134, 123, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBounds(131, 225, 89, 23);
		contentPane.add(btnNewButton);
	}
}
