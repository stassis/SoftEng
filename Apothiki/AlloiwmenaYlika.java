import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.*;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;

public class AlloiwmenaYlika {

	private JFrame frame;
	private JTable table;
    Date date = new Date();
	
	public void showpligmenaylika() {
		frame.show();
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public AlloiwmenaYlika() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		frame = new JFrame("P.Diner.A. Expired Ingredients");
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
        		
        		Apothiki newwindow = new Apothiki();
				newwindow.showapothiki();
        	}
        });
        btnBack_1.setBounds(12, 32, 67, 15);
        frame.getContentPane().add(btnBack_1);
        
        JLabel lblAlloiwmenaYlika = new JLabel("Expired Ingredients");
        lblAlloiwmenaYlika.setBounds(157, 32, 126, 15);
        frame.getContentPane().add(lblAlloiwmenaYlika);
        
        try {
        	
        	//syndesi me ti vasi + ektelesi query
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
			Statement stmt = c.createStatement();
			String sql = "SELECT * FROM food WHERE Imerominia <= '2021-06-10'";
			ResultSet rs = stmt.executeQuery(sql);
			
			//dimiourgia table me ta katallhla columns
			DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Ingredients", "Quantity", "Exp.Date","Sh.Limits"}, 0){

			    @Override
			    public boolean isCellEditable(int row, int column) {
			       //ola ta kelia mh epexergasima
			       return false;
			    }
			};
			
			
			while (rs.next()) {
	            
				//****apokthsh periexomenou ths kathe sthlhs ana seira***
	            String fagito = rs.getString("Fagito");
	            int posotita = rs.getInt("Posotita");
	            String date = rs.getDate("Imerominia").toString();
	            int oriaell = rs.getInt("Oriaellipsis");
	            //****-****
	            
	            //**prosthiki kathe grammhs sto table**
	            String[] data = { fagito, Integer.toString(posotita), date, Integer.toString(oriaell)};
	            tableModel.addRow(data);
	            //**-**
	            
	         }
			
			//***dimiourgia scrollable pinaka***
			JTable jt = new JTable(tableModel);
			
			JScrollPane js=new JScrollPane(jt);
			
			js.setBounds(12, 99, 302, 104);
			frame.getContentPane().add(js);
			//***-***
			
			//apeleutherosi porwn
			c.close();
			stmt.close();
			rs.close();
			
		}catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
        
        JButton btnAfairesi = new JButton("Remove");
        btnAfairesi.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		try {
        			
        			//sundesi me ti vasi dedomenwn + ektelesi query
        			Class.forName("com.mysql.cj.jdbc.Driver");
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
	        		Statement stmt = c.createStatement();
	        		String sql = "DELETE FROM food WHERE Imerominia <= '2021-06-10'";
	    			stmt.executeUpdate(sql);
	    			
	    			//apeleutherosi porwn
	    			c.close();
	    			stmt.close();
	    			
	    			JOptionPane.showMessageDialog(null, "Expired Ingredients have been removed!");
	    			
				} catch (ClassNotFoundException | SQLException e1) {
					
					e1.printStackTrace();
				}
    			
        		
        		try {
        			
        			frame.dispose();
        			AlloiwmenaYlika al = new AlloiwmenaYlika();
        			al.frame.setVisible(true);
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
        		
        	}
        });
        btnAfairesi.setBounds(324, 111, 98, 25);
        frame.getContentPane().add(btnAfairesi);
        
        
	}
}
