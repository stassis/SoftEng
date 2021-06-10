import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import javax.swing.SpinnerNumberModel;
import java.awt.Font;

public class Menou extends JFrame {

	private JPanel contentPane;
	private JTable table;
	JSpinner spinner1 = new JSpinner();
	JSpinner spinner2 = new JSpinner();
	JSpinner spinner3 = new JSpinner();
	JSpinner spinner4 = new JSpinner();
	String a[]={"0","0","0","0"};
    int b[]= {0,0,0,0};
    int nd=0; String nr="";
    String d;
    String address;
    int orderstable;
	
    
	/**
	 * Create the frame.
	 */
    
	public Menou() {
		
		d = TroposParadoshs.del;
		orderstable = showTables.table; 
		address = Delivery_SumplhrwshStoixeiwn.address;
		
		setTitle("P.Diner.A Menou");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnOrder = new JButton("Place Order");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				Order o = new Order(nd,(int)spinner1.getValue(),(int)spinner2.getValue(),(int)spinner3.getValue(),(int)spinner4.getValue(), d , orderstable ,address);
				new Notification ("chef",0,"1");
				TroposPlhrwmhs scr = new TroposPlhrwmhs(o);
				scr.setVisible(true);
				
			}
		});
		btnOrder.setBounds(183, 238, 108, 23);
		contentPane.add(btnOrder);
		
		JLabel lbl_logo = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		lbl_logo.setIcon(new ImageIcon(img));
		lbl_logo.setBounds(78, 284, 213, 128);
		contentPane.add(lbl_logo);
		spinner1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		
		
		
		
		spinner1.setBounds(265, 58, 30, 20);
		contentPane.add(spinner1);
		spinner2.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		
		
		spinner2.setBounds(265, 94, 30, 20);
		contentPane.add(spinner2);
		spinner3.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		
		
		spinner3.setBounds(265, 136, 30, 20);
		contentPane.add(spinner3);
		spinner4.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		
		
		spinner4.setBounds(265, 179, 30, 20);
		contentPane.add(spinner4);
		
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

try{
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
	  Statement stmt = c.createStatement();
	  String sql = "SELECT `role`,`id` FROM lastlog";	               		      
	  ResultSet rs = stmt.executeQuery(sql);
	  
	  while (rs.next()) {nd = rs.getInt("id");
	  nr = rs.getString("role");}
	                      		      
	  c.close();	               		   
	}
	catch (Exception ee)
	{
	  System.err.println("Got an exception!");
	  System.err.println(ee.getMessage());
	}



	

JLabel lblPlate1 = new JLabel(a[0]);
lblPlate1.setBounds(55, 61, 86, 14);
contentPane.add(lblPlate1);

JLabel lblPlate2 = new JLabel(a[1]);
lblPlate2.setBounds(55, 97, 86, 14);
contentPane.add(lblPlate2);

JLabel lblPrice1 = new JLabel(Integer.toString(b[0]));
lblPrice1.setBounds(174, 61, 46, 14);
contentPane.add(lblPrice1);

JLabel lblPrice2 = new JLabel(Integer.toString(b[1]));
lblPrice2.setBounds(174, 97, 46, 14);
contentPane.add(lblPrice2);

JLabel lblPlate3 = new JLabel(a[2]);
lblPlate3.setBounds(55, 139, 86, 14);
contentPane.add(lblPlate3);

JLabel lblPlate4 = new JLabel(a[3]);
lblPlate4.setBounds(55, 182, 70, 14);
contentPane.add(lblPlate4);

JLabel lblPrice3 = new JLabel(Integer.toString(b[2]));
lblPrice3.setBounds(174, 139, 46, 14);
contentPane.add(lblPrice3);

JLabel lbl4 = new JLabel(Integer.toString(b[3]));
lbl4.setBounds(174, 182, 46, 14);
contentPane.add(lbl4);

JLabel lblPiata = new JLabel("Plates:");
lblPiata.setFont(new Font("Tahoma", Font.BOLD, 14));
lblPiata.setBounds(38, 36, 46, 14);
contentPane.add(lblPiata);

JLabel lblPrice = new JLabel("Price:");
lblPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
lblPrice.setBounds(154, 36, 46, 14);
contentPane.add(lblPrice);

JLabel lblNewLabel_1 = new JLabel("Quantity:");
lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
lblNewLabel_1.setBounds(242, 36, 75, 14);
contentPane.add(lblNewLabel_1);

JButton btnNewButton = new JButton("back");
btnNewButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		
		dispose();
		new MainMenu();
		
	}
});
btnNewButton.setBounds(55, 238, 70, 23);
contentPane.add(btnNewButton);


	}
}
