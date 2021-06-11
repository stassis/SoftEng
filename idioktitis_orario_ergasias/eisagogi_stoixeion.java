import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class eisagogi_stoixeion extends JFrame {

	private JPanel contentPane;
	private JTextField emp;
	private JTextField clk_in;
	private JTextField clk_out;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					eisagogi_stoixeion frame = new eisagogi_stoixeion();
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
	public void showeisagogi_stoixeion() {
		JFrame frame = new JFrame("P.Diner.A. Eisagogi Stoixeion");
		frame.setBounds(100, 100, 436, 402);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.show();
	}
	
	public eisagogi_stoixeion() throws SQLException {
		
		JFrame frame = new JFrame("P.Diner.A. Eisagogi Stoixeion");
		frame.setBounds(100, 100, 436, 402);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.show();		
try {
        	
        	//syndesi me ti vasi + ektelesi query
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
			Statement stmt = c.createStatement();
			String sql = "SELECT * FROM orario";
			ResultSet rs = stmt.executeQuery(sql);
			
			//dimiourgia table me ta katallhla columns
			DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Employee", "Clock_In", "Clock_Out"}, 0){

			    @Override
			    public boolean isCellEditable(int row, int column) {
			       //ola ta kelia mh epexergasima
			       return false;
			    }
			};
			
			
			while (rs.next()) {
	            
				//****apokthsh periexomenou ths kathe sthlhs ana seira***
	            String Employee = rs.getString("Employee");
	            String Clock_In = rs.getString("Clock_In");
	            String Clock_Out = rs.getString("Clock_Out");


	            //****-****
	            
	            //**prosthiki kathe grammhs sto table**
	            String[] data = { Employee, Clock_In, Clock_Out};
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(59, 24, 84, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Clock In:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(59, 73, 84, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Clock Out:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(59, 110, 84, 14);
		contentPane.add(lblNewLabel_2);
		
		emp = new JTextField();
		emp.setBounds(181, 21, 115, 20);
		contentPane.add(emp);
		emp.setColumns(10);
		
		clk_in = new JTextField();
		clk_in.setBounds(181, 70, 115, 20);
		contentPane.add(clk_in);
		clk_in.setColumns(10);
		
		clk_out = new JTextField();
		clk_out.setBounds(181, 107, 115, 20);
		contentPane.add(clk_out);
		clk_out.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
        			
        			//sundesi me ti vasi dedomenwn + ektelesi query
        			Class.forName("com.mysql.cj.jdbc.Driver");
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
	        		Statement stmt = c.createStatement();
	        		String sql = "UPDATE orario SET Clock_In= '"+clk_in.getText()+"', Clock_Out= '"+clk_out.getText()+"' WHERE Employee = '"+emp.getText()+"'  ";
	    			stmt.executeUpdate(sql);
	    			
	    			//apeleutherosi porwn
	    			c.close();
	    			stmt.close();
	    				    			
				} catch (ClassNotFoundException | SQLException e1) {
					
					e1.printStackTrace();
				}
    			
        			
								
				
				JOptionPane.showMessageDialog(null, "Saved!");
				dispose();				
				orario or= new orario();
				or.showmain();
			}
		});
		btnNewButton.setBounds(287, 138, 137, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				orario or = new orario();
				or.showmain();
			}
		});
		btnNewButton_1.setBounds(59, 201, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
