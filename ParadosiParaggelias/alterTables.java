import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class alterTables extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public alterTables() {
		setTitle("Set Available Tables");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon png = new ImageIcon("src/logo.png");
        JLabel logo = new JLabel(png);
        
        logo.setBounds(161, 319, 200, 111);
        getContentPane().add(logo);
        
        Image icon = Toolkit.getDefaultToolkit().getImage("src/logo.png"); 
        setIconImage(icon);
        
        new getTableAvailability();
        
        JScrollPane js=new JScrollPane(getTableAvailability.tabav);
		js.setVisible(true);
		js.setBounds(0, 59, 518, 103);
		getContentPane().add(js);
		
		String[] choices = { "Table 1","Table 2", "Table 3","Table 4","Table 5"};
		
		JComboBox comboBox = new JComboBox(choices);
		comboBox.setBounds(275, 248, 139, 45);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Select Table");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(275, 223, 88, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Set as Available");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = String.valueOf(comboBox.getSelectedItem());
				new setAvailableTable(id);
				dispose();
				new alterTables().setVisible(true);
			}
		});
		btnNewButton.setBounds(62, 248, 139, 45);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				new MainMenu();
			}
		});
		btnNewButton_1.setBounds(0, 11, 76, 23);
		contentPane.add(btnNewButton_1);
		
		
	}
}
