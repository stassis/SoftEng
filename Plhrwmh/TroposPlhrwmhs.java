import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextPane;

public class TroposPlhrwmhs extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private boolean type;
	int pr[]= {0,0,0,0};
	int qua1=0;
	int qua2=0;
	int qua3=0;
	int qua4=0;
	int amount=0;

	/**
	 * Create the frame.
	 */
	public TroposPlhrwmhs(Order o) {
		setTitle("P.Diner.A Plhrwmh-Tropos Plhrwmhs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Choose payment method:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(91, 11, 174, 14);
		contentPane.add(lblNewLabel);
		
		JRadioButton rdbtn_metrhta = new JRadioButton("Pay with cash");
		rdbtn_metrhta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				type=false;
			}
		});
		rdbtn_metrhta.setSelected(true);
		buttonGroup.add(rdbtn_metrhta);
		rdbtn_metrhta.setBounds(110, 49, 158, 23);
		contentPane.add(rdbtn_metrhta);
		
		JRadioButton rdbtn_karta = new JRadioButton("Pay with card");
		rdbtn_karta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				type=true;
			}
		});
		buttonGroup.add(rdbtn_karta);
		rdbtn_karta.setBounds(110, 84, 158, 23);
		contentPane.add(rdbtn_karta);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				
				if(type) {
					
					dispose();
					StoixeiaKartas scr = new StoixeiaKartas(o);
					scr.setVisible(true);
					
				}else {
					
					dispose();
					OloklhrwshPlhrwmhs scr = new OloklhrwshPlhrwmhs(o);
					scr.setVisible(true);
					
				}
			}
		});
		btnOK.setBounds(127, 210, 89, 23);
		contentPane.add(btnOK);
		
		qua1 = o.q1;
		qua2 = o.q2;
		qua3 = o.q3;
		qua4 = o.q4;
		
		try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
			Statement stmt = c.createStatement();
			String sql = "SELECT * FROM plate";
			ResultSet rs = stmt.executeQuery(sql);
			
			DefaultTableModel tableModel = new DefaultTableModel(new String[]{"ID", "Name", "Price"}, 0){

			};
			
			int k=0;
			while (rs.next()) {
				
				int id = rs.getInt("ID");
	            String plate_name = rs.getString("Name");
	            int price = rs.getInt("Price");
	            
	            
	            
	            String[] data = { Integer.toString(id), plate_name , Integer.toString(price) };
	            tableModel.addRow(data); 
	            pr[k] = price;
	            
	            k++;
	            
	         }
			
			c.close();
			stmt.close();
			rs.close();
			
		}catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}

		
		amount = (pr[0]*qua1) + (pr[1]*qua2) + (pr[2]*qua3) + (pr[3]*qua4);
		
		
		JLabel lbl_logo = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		lbl_logo.setIcon(new ImageIcon(img));
		lbl_logo.setBounds(78, 284, 213, 128);
		contentPane.add(lbl_logo);
		
		JLabel lblTotalCost = new JLabel("Total Cost:");
		lblTotalCost.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTotalCost.setBounds(83, 163, 94, 14);
		contentPane.add(lblTotalCost);
		
		JLabel lblCost = new JLabel(Integer.toString(amount));
		lblCost.setBounds(170, 164, 46, 14);
		contentPane.add(lblCost);
	}
}
