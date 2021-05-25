import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menou extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menou frame = new Menou();
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
	public Menou() {
		setTitle("P.Diner.A Menou");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Epilekste piata:");
		lblNewLabel.setBounds(116, 11, 108, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Place Order");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				TroposParadoshs delivery = new TroposParadoshs();
				delivery.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(116, 236, 108, 23);
		contentPane.add(btnNewButton);
		
		JList list = new JList();
		list.setBounds(62, 57, 229, 168);
		contentPane.add(list);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Piato1", "Piato2", "Piato3", "Piato4", "Piato5"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JLabel lbl_logo = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		lbl_logo.setIcon(new ImageIcon(img));
		lbl_logo.setBounds(78, 284, 213, 128);
		contentPane.add(lbl_logo);
		
	}
}
