import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Proetoimasia {
	
	public Proetoimasia() {
		JFrame frame;
		JTable table;
		
		frame = new JFrame("Prepare Order");
		frame.setBounds(100, 100, 436, 402);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Image icon = Toolkit.getDefaultToolkit().getImage("src/logo.png"); 
        frame.setIconImage(icon);
		
		ImageIcon png = new ImageIcon("src/logo.png");
		frame.getContentPane().setLayout(null);
		JLabel logo = new JLabel(png);
		logo.setBounds(116, 236, 202, 111);
        frame.getContentPane().add(logo);
        
        JButton btnBack_1 = new JButton("Back");
        btnBack_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		frame.dispose();
        		new MainMenu();
        	}
        });
        btnBack_1.setBounds(12, 32, 67, 15);
        frame.getContentPane().add(btnBack_1);
        
        JLabel lblPrep = new JLabel("Pick an Order to view");
        lblPrep.setBounds(116, 52, 157, 15);
        frame.getContentPane().add(lblPrep);
	//JList<String> list;
	
	try {
    	Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
		String sql = "SELECT * FROM orders WHERE flag = 'submitted'";
		Statement stmt = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		ResultSet rs = stmt.executeQuery(sql);
		
		int rowcount = 0;
		if (rs.last()) {
		  rowcount = rs.getRow();
		  rs.beforeFirst(); 
		}
		
		DefaultTableModel tableModel = new DefaultTableModel(new String[]{"ID", "State"}, 0){

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //ola ta kelia mh epexergasima
		       return false;
		    }
		};
		
		int count = 0;
		
		String[] combo = new String[rowcount];
		
		while (rs.next()) {
			
            int order_id = rs.getInt("order_id");
            String flag = rs.getString("flag");
            combo[count] = String.valueOf(order_id);
            
            String[] data = { Integer.toString(order_id), flag};
            tableModel.addRow(data);
            count++;
                        
         }
		
				
		JTable jt = new JTable(tableModel);		
		JScrollPane js=new JScrollPane(jt);
		//js.setVisible(true);
		
		js.setBounds(38, 121, 334, 104);
		frame.getContentPane().add(js);
				
		JLabel lblOrders = new JLabel("Orders");
		lblOrders.setBounds(38, 96, 46, 14);
		frame.getContentPane().add(lblOrders);
		
		JComboBox comboBox = new JComboBox(combo);
		comboBox.setMaximumRowCount(20);
		comboBox.setBounds(262, 48, 46, 22);
		frame.getContentPane().add(comboBox);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int oid = Integer.parseInt((String)comboBox.getSelectedItem());
				new ProetDetails(oid);
				frame.dispose();
			}
		});
		btnView.setBounds(310, 48, 62, 22);
		frame.getContentPane().add(btnView);
		
		c.close();stmt.close();rs.close();
		
	}catch (Exception ee) {ee.printStackTrace();}
	
	frame.setVisible(true);
	}



	public static void main(String Args[]){
	new Proetoimasia(); }	
 }
