import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TakeAway extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public TakeAway() {
		setTitle("Delivery - Take Away");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Image icon = Toolkit.getDefaultToolkit().getImage("src/logo.png");
	    setIconImage(icon); 
		
		ImageIcon png = new ImageIcon("src/logo.png");
		getContentPane().setLayout(null);
		JLabel logo = new JLabel(png);
		logo.setBounds(150, 302, 202, 111);
		getContentPane().add(logo);
		
		new getTakeAway();
		
		JScrollPane js=new JScrollPane(getTakeAway.jt);
		js.setVisible(true);
		js.setBounds(22, 57, 477, 125);
		getContentPane().add(js);
		
		JLabel lblNewLabel = new JLabel("Take Away");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(205, 17, 127, 29);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				new ParadosiParaggelias().main(null);
			}
		});
		btnNewButton.setBounds(0, 11, 63, 23);
		contentPane.add(btnNewButton);
		
		JComboBox<Object> comboBox = new JComboBox<Object>(getTakeAway.ids.toArray());
		comboBox.setBounds(10, 233, 121, 36);
		contentPane.add(comboBox);
		
		JButton remove = new JButton("Delivered");
		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = String.valueOf(comboBox.getSelectedItem());
				new submittedOrder(id);
    			JOptionPane.showMessageDialog(null, "The Order has been delivered!");
    			
				dispose();
				new ParadosiParaggelias();
				ParadosiParaggelias.main(null);
			}
		});
		remove.setBounds(150, 240, 121, 23);
		contentPane.add(remove);
		
		JLabel removelabel = new JLabel("Select Order");
		removelabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		removelabel.setBounds(10, 208, 127, 14);
		contentPane.add(removelabel);
		
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = String.valueOf(comboBox.getSelectedItem());
				new removeOrder(id);
    			JOptionPane.showMessageDialog(null, "The Order has been cancelled!");

				dispose();
				new ParadosiParaggelias();
				ParadosiParaggelias.main(null);
			}
		});
		cancel.setBounds(291, 240, 89, 23);
		contentPane.add(cancel);
	}

}
