import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
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
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

public class PliroforiesApothikis {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PliroforiesApothikis window = new PliroforiesApothikis();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void showpliroforiesapothikis() {
		frame.show();
	}

	/**
	 * Create the application.
	 */
	public PliroforiesApothikis() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("P.Diner.A. Diathesima Ylika");
		frame.setBounds(100, 100, 440, 402);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Image icon = Toolkit.getDefaultToolkit().getImage("src/logo.png"); 
        frame.setIconImage(icon);
		
		ImageIcon png = new ImageIcon("src/logo.png");
		frame.getContentPane().setLayout(null);
		JLabel logo = new JLabel(png);
		logo.setBounds(116, 236, 202, 111);
        frame.getContentPane().add(logo);
        
        JLabel title = new JLabel("Apothiki");
		title.setFont(new Font("Tahoma", Font.BOLD, 16));
		title.setBounds(166, 10, 77, 15);
		frame.getContentPane().add(title);
		
		JButton btnNewButton = new JButton("Prosthiki Promithion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.dispose();
        		
				PlaisiaEisagogisTimon newwindow = new PlaisiaEisagogisTimon();
				newwindow.showplaisiatimwn();
			}
		});
		btnNewButton.setBounds(118, 178, 188, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.dispose();
        		
        		Apothiki newwindow = new Apothiki();
				newwindow.showapothiki();
			}
		});
		btnBack.setBounds(12, 12, 67, 15);
		frame.getContentPane().add(btnBack);
		
		try {
        	
        	
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
			Statement stmt = c.createStatement();
			String sql = "SELECT * FROM food";
			ResultSet rs = stmt.executeQuery(sql);
			//PreparedStatement pst = connection.prepareStatement(sql);
			//pst.setString(1, textFieldSearch.getText());
			//ResultSet rs = pst.executeQuery();
			//System.out.println("Fagito     Posotita     Imerominia");
			
			//String[] columnNames = {"Fagito", "Posotita", "Imerominia"};
			
			
			DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Fagito", "Posotita", "Imerominia","Oriaellipsis"}, 0){

			    @Override
			    public boolean isCellEditable(int row, int column) {
			       //ola ta kelia mh epexergasima
			       return false;
			    }
			};
			
			
			while (rs.next()) {
	            
	            String fagito = rs.getString("Fagito");
	            int posotita = rs.getInt("Posotita");
	            String date = rs.getDate("Imerominia").toString();
	            int oriaell = rs.getInt("Oriaellipsis");
	            
	            //System.out.println(fagito+"    "+posotita+"            "+date);
	            
	            String[] data = { fagito, Integer.toString(posotita), date, Integer.toString(oriaell)};
	            tableModel.addRow(data);
	            //model.addRow(new Object[]{fagito,posotita,date});
	            
	         }

			//JTable jt = new JTable(new DefaultTableModel(columnNames, 0));
			//JTable jt = new JTable(tableModel);
			JTable jt = new JTable(tableModel);
			
			JScrollPane js=new JScrollPane(jt);
			//js.setVisible(true);
			
			js.setBounds(64, 52, 287, 104);
			frame.getContentPane().add(js);
			
			c.close();
			stmt.close();
			rs.close();
			
		}catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
}
