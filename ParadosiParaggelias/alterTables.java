import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					alterTables frame = new alterTables();
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
	public alterTables() {
		setTitle("Set Available Tables");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon png = new ImageIcon("src/logo.png");
        JLabel logo = new JLabel(png);
        
        logo.setBounds(119, 143, 200, 111);
        getContentPane().add(logo);
        
        Image icon = Toolkit.getDefaultToolkit().getImage("src/logo.png"); 
        setIconImage(icon); 
		
		String[] choices = { "Table 1","Table 2", "Table 3","Table 4","Table 5"};
		
		JComboBox comboBox = new JComboBox(choices);
		comboBox.setBounds(259, 63, 139, 45);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Select Table");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(259, 38, 88, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Set as Available");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = String.valueOf(comboBox.getSelectedItem());
				new setAvailableTable(id);
			}
		});
		btnNewButton.setBounds(61, 63, 139, 45);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				new ParadosiParaggelias();
				ParadosiParaggelias.main(null);
			}
		});
		btnNewButton_1.setBounds(0, 11, 76, 23);
		contentPane.add(btnNewButton_1);
		
		
	}
}
