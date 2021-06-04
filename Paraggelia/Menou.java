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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import javax.swing.JSpinner;

public class Menou extends JFrame {

	private JPanel contentPane;
	private JTable table;
	JSpinner spinner1 = new JSpinner();
	JSpinner spinner2 = new JSpinner();
	JSpinner spinner3 = new JSpinner();
	JSpinner spinner4 = new JSpinner();
	String a[]={"0","0","0","0"};
    int b[]= {0,0,0,0};
    
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
		lblNewLabel.setBounds(127, 11, 108, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnOrder = new JButton("Place Order");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				new Order(12,(int)spinner1.getValue(),(int)spinner2.getValue(),(int)spinner3.getValue(),(int)spinner4.getValue());
				TroposPlhrwmhs scr = new TroposPlhrwmhs();
				scr.setVisible(true);
				
			}
		});
		btnOrder.setBounds(116, 236, 108, 23);
		contentPane.add(btnOrder);
		
		JLabel lbl_logo = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		lbl_logo.setIcon(new ImageIcon(img));
		lbl_logo.setBounds(78, 284, 213, 128);
		contentPane.add(lbl_logo);
		
		
		
		
		spinner1.setBounds(248, 47, 30, 20);
		contentPane.add(spinner1);
		
		
		spinner2.setBounds(248, 83, 30, 20);
		contentPane.add(spinner2);
		
		
		spinner3.setBounds(248, 125, 30, 20);
		contentPane.add(spinner3);
		
		
		spinner4.setBounds(248, 168, 30, 20);
		contentPane.add(spinner4);
		
try {
        	
        	
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
			Statement stmt = c.createStatement();
			String sql = "SELECT * FROM plate";
			ResultSet rs = stmt.executeQuery(sql);
			//PreparedStatement pst = connection.prepareStatement(sql);
			//pst.setString(1, textFieldSearch.getText());
			//ResultSet rs = pst.executeQuery();
			//System.out.println("Fagito     Posotita     Imerominia");
			
			//String[] columnNames = {"Fagito", "Posotita", "Imerominia"};
			
			
			DefaultTableModel tableModel = new DefaultTableModel(new String[]{"ID", "Name", "Price", "Quantity"}, 0){

			    //@Override
			    //public boolean isCellEditable(int row, int column) {
			       //ola ta kelia mh epexergasima
			       //return false;
			    //}
			};
			
			int k=0;
			while (rs.next()) {
				
				int id = rs.getInt("ID");
	            String plate_name = rs.getString("Name");
	            int price = rs.getInt("Price");
	            int quantity = 0;
	            
	            
	            String[] data = { Integer.toString(id), plate_name , Integer.toString(price) , Integer.toString(quantity)};
	            tableModel.addRow(data);
	            a[k] = plate_name; 
	            b[k] = price;
	            
	            k++;
	            
	         }
			
			c.close();
			stmt.close();
			rs.close();
			
		}catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}

JLabel lblPlate1 = new JLabel(a[0]);
lblPlate1.setBounds(38, 50, 86, 14);
contentPane.add(lblPlate1);

JLabel lblPlate2 = new JLabel(a[1]);
lblPlate2.setBounds(38, 86, 86, 14);
contentPane.add(lblPlate2);

JLabel lblPrice1 = new JLabel(Integer.toString(b[0]));
lblPrice1.setBounds(157, 50, 46, 14);
contentPane.add(lblPrice1);

JLabel lblPrice2 = new JLabel(Integer.toString(b[1]));
lblPrice2.setBounds(157, 86, 46, 14);
contentPane.add(lblPrice2);

JLabel lblPlate3 = new JLabel(a[2]);
lblPlate3.setBounds(38, 128, 86, 14);
contentPane.add(lblPlate3);

JLabel lblPlate4 = new JLabel(a[3]);
lblPlate4.setBounds(38, 171, 70, 14);
contentPane.add(lblPlate4);

JLabel lblPrice3 = new JLabel(Integer.toString(b[2]));
lblPrice3.setBounds(157, 128, 46, 14);
contentPane.add(lblPrice3);

JLabel lbl4 = new JLabel(Integer.toString(b[3]));
lbl4.setBounds(157, 171, 46, 14);
contentPane.add(lbl4);


	}
}
