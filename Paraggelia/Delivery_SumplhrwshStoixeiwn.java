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
		setTitle("P.Diner.A Delivery-Order details");
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
		
		JLabel lblNewLabel_1 = new JLabel("Fill in order details:");
		lblNewLabel_1.setBounds(111, 11, 174, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblonoma = new JLabel("Full name:");
		lblonoma.setBounds(32, 46, 112, 14);
		contentPane.add(lblonoma);
		
		Name = new JTextField();
		Name.setBounds(111, 43, 182, 20);
		contentPane.add(Name);
		Name.setColumns(10);
		
		JLabel lbldieuthinsi = new JLabel("Address:");
		lbldieuthinsi.setBounds(32, 94, 123, 14);
		contentPane.add(lbldieuthinsi);
		
		Address = new JTextField();
		Address.setBounds(111, 91, 182, 20);
		contentPane.add(Address);
		Address.setColumns(10);
		
		JLabel lblorofos = new JLabel("Floor:");
		lblorofos.setBounds(22, 149, 56, 14);
		contentPane.add(lblorofos);
		
		Floor = new JTextField();
		Floor.setBounds(71, 146, 56, 20);
		contentPane.add(Floor);
		Floor.setColumns(10);
		
		JLabel lblkoudouni = new JLabel("Door:");
		lblkoudouni.setBounds(144, 149, 70, 14);
		contentPane.add(lblkoudouni);
		
		Door = new JTextField();
		Door.setBounds(202, 146, 123, 20);
		contentPane.add(Door);
		Door.setColumns(10);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String textFieldName = Name.getText();
        		String textFieldAddress = Address.getText();
        		String textFieldOrofos = Floor.getText();
        		String textFieldKoudouni = Door.getText();
        		
        		
        		
        		
        		if(!(textFieldName.length() == 0 || textFieldAddress.length() == 0 || textFieldKoudouni.length() == 0)) {
        			
        			try {
        				
        			int intFieldOrofos=Integer.parseInt(textFieldOrofos);
        			
        				if(intFieldOrofos >= 0) {
		            			
		        				address = Address.getText();
		        				
								dispose();
								Menou scr = new Menou();
								scr.setVisible(true);
		
		        			
        				}else {
            				
            				JOptionPane.showMessageDialog(null, "Enter positive values(integer)!");
            				
            			}
        			}catch(NumberFormatException e1) {
        				JOptionPane.showMessageDialog(null, "Enter positive values(integer)!"); 
     				   
     				 } 	
        		}else {
        			
        			JOptionPane.showMessageDialog(null, "Please fill in the textfields!");
        			
        		}
        		
		btnOK.setBounds(134, 215, 89, 23);
		contentPane.add(btnOK);
	}

});
		btnOK.setBounds(196, 215, 89, 23);
		contentPane.add(btnOK);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				dispose();
				new MainMenu();
			
			}
		});
		btnNewButton.setBounds(55, 215, 89, 23);
		contentPane.add(btnNewButton);
}
}	
