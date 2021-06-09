import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TroposParadoshs extends JFrame {
    
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private boolean takeaway;
	private boolean delivery;
	public static String del;

	

	/*** Create the frame.*/
	public TroposParadoshs() {
		
		setTitle("P.Diner.A Tropos Paradoshs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_msg = new JLabel("Epilekste tropo paradoshs:");
		lbl_msg.setBounds(125, 28, 156, 14);
		contentPane.add(lbl_msg);
		
		JRadioButton rdbtn_entos = new JRadioButton("Entos tou xwrou");
		rdbtn_entos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				takeaway = false;
				delivery = false;
			}
		});
		buttonGroup.add(rdbtn_entos);
		rdbtn_entos.setSelected(true);
		rdbtn_entos.setBounds(125, 64, 150, 23);
		contentPane.add(rdbtn_entos);
		
		JRadioButton rdbtn_delivery = new JRadioButton("Delivery sto spiti");
		rdbtn_delivery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				delivery = true;
				
				
			}
		});
		buttonGroup.add(rdbtn_delivery);
		rdbtn_delivery.setBounds(125, 100, 150, 23);
		contentPane.add(rdbtn_delivery);
		
		JRadioButton rdbtn_takeaway = new JRadioButton("Take Away");
		rdbtn_takeaway.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				takeaway = true;
				
			}
		});
		buttonGroup.add(rdbtn_takeaway);
		rdbtn_takeaway.setBounds(125, 136, 150, 23);
		contentPane.add(rdbtn_takeaway);
		
		JLabel lbl_logo = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		lbl_logo.setIcon(new ImageIcon(img));
		lbl_logo.setBounds(85, 259, 213, 128);
		contentPane.add(lbl_logo);
		
		JButton btn_OK = new JButton("OK");
		btn_OK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(delivery) {
					del = "Delivery";
					dispose();
					Delivery_SumplhrwshStoixeiwn scr = new Delivery_SumplhrwshStoixeiwn();
					scr.setVisible(true);
					
				}else if (takeaway){
					del = "TakeAway";
					dispose();
					Menou scr = new Menou();
					scr.setVisible(true);
					
					
				}else {
					del = "Entos tou xwrou";
					dispose();
					Table t = new Table(1);					
					showTables scr = new showTables(t.getTables());
					//scr.setVisible(true);
					
				}
				
			}
		});
		btn_OK.setBounds(207, 190, 89, 23);
		contentPane.add(btn_OK);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				new MainMenu();
				
			}
		});
		btnNewButton.setBounds(54, 190, 89, 23);
		contentPane.add(btnNewButton);
		
	}
}
