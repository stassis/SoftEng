import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Delivery_SumplhrwshStoixeiwn extends JFrame {

	private JPanel contentPane;
	private JTextField Name;
	private JTextField Address;
	private JTextField Floor;
	private JTextField Door;
	public static String address;
	

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
		
		JLabel lblonoma = new JLabel("Onomatepwnumo:");
		lblonoma.setBounds(21, 46, 112, 14);
		contentPane.add(lblonoma);
		
		Name = new JTextField();
		Name.setBounds(143, 43, 182, 20);
		contentPane.add(Name);
		Name.setColumns(10);
		
		JLabel lbldieuthinsi = new JLabel("Odos kai arithmos:");
		lbldieuthinsi.setBounds(21, 94, 123, 14);
		contentPane.add(lbldieuthinsi);
		
		Address = new JTextField();
		Address.setBounds(143, 91, 182, 20);
		contentPane.add(Address);
		Address.setColumns(10);
		
		JLabel lblorofos = new JLabel("Orofos:");
		lblorofos.setBounds(21, 137, 56, 14);
		contentPane.add(lblorofos);
		
		Floor = new JTextField();
		Floor.setBounds(74, 134, 56, 20);
		contentPane.add(Floor);
		Floor.setColumns(10);
		
		JLabel lblkoudouni = new JLabel("Koudouni:");
		lblkoudouni.setBounds(143, 137, 70, 14);
		contentPane.add(lblkoudouni);
		
		Door = new JTextField();
		Door.setBounds(202, 134, 123, 20);
		contentPane.add(Door);
		Door.setColumns(10);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			address = Address.getText();
				
				dispose();
				Menou scr = new Menou();
				scr.setVisible(true);
			}
		});
		btnOK.setBounds(134, 215, 89, 23);
		contentPane.add(btnOK);
	}
}
