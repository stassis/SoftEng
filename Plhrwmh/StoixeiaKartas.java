import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		
		JLabel lblNewLabel = new JLabel("Fill in card details:");
		lblNewLabel.setBounds(119, 11, 172, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Card number:");
		lblNewLabel_1.setBounds(20, 43, 100, 14);
		contentPane.add(lblNewLabel_1);
		
		txtArithmosKartas = new JTextField();
		txtArithmosKartas.setBounds(120, 40, 227, 20);
		contentPane.add(txtArithmosKartas);
		txtArithmosKartas.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Owner's name:");
		lblNewLabel_2.setBounds(20, 89, 100, 14);
		contentPane.add(lblNewLabel_2);
		
		txtOnomaKartas = new JTextField();
		txtOnomaKartas.setBounds(120, 86, 227, 20);
		contentPane.add(txtOnomaKartas);
		txtOnomaKartas.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Expire date:");
		lblNewLabel_3.setBounds(34, 130, 172, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Month:");
		lblNewLabel_4.setBounds(20, 159, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		txtMhnasLhkshs = new JTextField();
		txtMhnasLhkshs.setBounds(65, 156, 86, 20);
		contentPane.add(txtMhnasLhkshs);
		txtMhnasLhkshs.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Year:");
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
		btnNewButton.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ArithmosKartas = txtArithmosKartas.getText();
				String OnomaKartas = txtOnomaKartas.getText();
				String MhnasLhkshs = txtMhnasLhkshs.getText();
				String EtosLhkshs = txtEtosLhksh.getText();
				String CCV2 = txtCCV2.getText();
				
				
				if(!(ArithmosKartas.length() == 0 || OnomaKartas.length() == 0 || MhnasLhkshs.length() == 0)) {
        			
        			try {
        			
        			int intArithmosKartas=Integer.parseInt(ArithmosKartas);
        			int intMhnasLhkshs=Integer.parseInt(MhnasLhkshs);
        			int intEtosLhkshs=Integer.parseInt(EtosLhkshs);
        			int intCCV2=Integer.parseInt(CCV2);
        			
        			
        				if( intArithmosKartas > 0 && intMhnasLhkshs > 0 && intEtosLhkshs > 0 && intCCV2>0 ) {
		        				
        					
        					dispose();
        					OloklhrwshPlhrwmhs scr = new OloklhrwshPlhrwmhs();
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
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(202, 244, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lbl_logo = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		lbl_logo.setIcon(new ImageIcon(img));
		lbl_logo.setBounds(78, 284, 213, 128);
		contentPane.add(lbl_logo);
		
		JButton btnNewButton_1 = new JButton("back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				dispose();
				new MainMenu();
				
			}
		});
		btnNewButton_1.setBounds(62, 244, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
