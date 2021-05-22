import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ParadosiParaggelias {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParadosiParaggelias window = new ParadosiParaggelias();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ParadosiParaggelias() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("P.Diner.A. Paradosi Paraggelias");
		frame.setBounds(100, 100, 451, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ImageIcon png = new ImageIcon("src/logo.png");
        JLabel logo = new JLabel(png);
        
        logo.setBounds(122, 334, 200, 111);
        frame.getContentPane().add(logo);
		
		JLabel lblParaggeliesProsParadosi = new JLabel("Orders to be Delivered");
		lblParaggeliesProsParadosi.setFont(new Font("Dialog", Font.BOLD, 16));
		lblParaggeliesProsParadosi.setBounds(110, 12, 281, 15);
		frame.getContentPane().add(lblParaggeliesProsParadosi);
		
		JLabel lblTable = new JLabel("Table");
		lblTable.setBounds(345, 39, 70, 15);
		frame.getContentPane().add(lblTable);
		
		JLabel lblNewLabel = new JLabel("Disk");
		lblNewLabel.setBounds(298, 39, 43, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(216, 39, 70, 15);
		frame.getContentPane().add(lblQuantity);
		
		JLabel lblFoodtype = new JLabel("FoodType");
		lblFoodtype.setBounds(58, 62, 70, 15);
		frame.getContentPane().add(lblFoodtype);
		
		JLabel lblDisks = new JLabel("Disks");
		lblDisks.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDisks.setBounds(183, 109, 70, 15);
		frame.getContentPane().add(lblDisks);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.disabledText"));
		panel.setBounds(58, 138, 70, 103);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Dialog", Font.BOLD, 10));
		lblStatus.setBounds(12, 12, 58, 15);
		panel.add(lblStatus);
		
		JLabel lblTbl = new JLabel("TBL");
		lblTbl.setBounds(12, 81, 35, 15);
		panel.add(lblTbl);
		
		JLabel lblDeliverTo = new JLabel("Deliver to");
		lblDeliverTo.setFont(new Font("Dialog", Font.BOLD, 10));
		lblDeliverTo.setBounds(0, 39, 70, 15);
		panel.add(lblDeliverTo);
		
		JLabel lblTable_1 = new JLabel("Table");
		lblTable_1.setFont(new Font("Dialog", Font.BOLD, 10));
		lblTable_1.setBounds(0, 54, 70, 15);
		panel.add(lblTable_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("Button.disabledText"));
		panel_1.setBounds(193, 138, 70, 103);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblWaitingFor = new JLabel("Waiting for");
		lblWaitingFor.setFont(new Font("Dialog", Font.BOLD, 10));
		lblWaitingFor.setBounds(0, 12, 70, 15);
		panel_1.add(lblWaitingFor);
		
		JLabel lblChef = new JLabel("chef");
		lblChef.setFont(new Font("Dialog", Font.BOLD, 10));
		lblChef.setBounds(0, 28, 70, 15);
		panel_1.add(lblChef);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(UIManager.getColor("Button.disabledText"));
		panel_2.setBounds(321, 138, 70, 103);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblWaitingFor_1 = new JLabel("Waiting for");
		lblWaitingFor_1.setFont(new Font("Dialog", Font.BOLD, 10));
		lblWaitingFor_1.setBounds(0, 12, 70, 15);
		panel_2.add(lblWaitingFor_1);
		
		JLabel lblChef_1 = new JLabel("chef");
		lblChef_1.setFont(new Font("Dialog", Font.BOLD, 10));
		lblChef_1.setBounds(0, 23, 70, 15);
		panel_2.add(lblChef_1);
		
		JButton btnDone = new JButton("Done!");
		btnDone.setBounds(51, 253, 77, 15);
		frame.getContentPane().add(btnDone);
		
		JButton btnDone_1 = new JButton("Done!");
		btnDone_1.setBounds(183, 253, 77, 15);
		frame.getContentPane().add(btnDone_1);
		
		JButton btnDone_2 = new JButton("Done!");
		btnDone_2.setBounds(314, 253, 77, 15);
		frame.getContentPane().add(btnDone_2);
		
		JLabel lblQnty = new JLabel("QNTY");
		lblQnty.setBounds(216, 62, 70, 15);
		frame.getContentPane().add(lblQnty);
		
		JLabel lblDsk = new JLabel("DSK");
		lblDsk.setBounds(298, 62, 70, 15);
		frame.getContentPane().add(lblDsk);
		
		JLabel lblTbl_1 = new JLabel("TBL");
		lblTbl_1.setBounds(345, 62, 70, 15);
		frame.getContentPane().add(lblTbl_1);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Dialog", Font.BOLD, 10));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancel.setBounds(51, 280, 77, 15);
		frame.getContentPane().add(btnCancel);
		
		JButton btnCancel_1 = new JButton("Cancel");
		btnCancel_1.setFont(new Font("Dialog", Font.BOLD, 10));
		btnCancel_1.setBounds(183, 280, 77, 15);
		frame.getContentPane().add(btnCancel_1);
		
		JButton btnCancel_2 = new JButton("Cancel");
		btnCancel_2.setFont(new Font("Dialog", Font.BOLD, 10));
		btnCancel_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancel_2.setBounds(314, 280, 77, 15);
		frame.getContentPane().add(btnCancel_2);
	}
}
