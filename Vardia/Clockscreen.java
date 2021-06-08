//import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Clockscreen extends JFrame {

	private JPanel contentPane;
	private JLabel clockinStatus;
	private String user;

	/**
	 * Create the frame.
	 */
	
	
	public Clockscreen() {
		setTitle("Orario");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		ImageIcon png = new ImageIcon("src/logo.png");
        JLabel logo = new JLabel(png);
        logo.setBounds(122, 324, 202, 111);
        contentPane.add(logo);
        
        Image icon = Toolkit.getDefaultToolkit().getImage("src/logo.png"); 
        setIconImage(icon); 
        
        user = "Dianomeas";
        
        JButton btnClockIn = new JButton("Clock in");
		btnClockIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Schedule sch = new Schedule();
//**Debugging**	System.out.print(sch.clockInState());
				
				//an den exei ginei clock in
				if(!sch.clockInState()) {
					
					try {//ektelese leitoyrgia clockin
						
						sch.checkInTimetable(user);
						
					} catch (SQLException | ParseException e1) {
						
						e1.printStackTrace();
					}
					
					if(sch.clockInState()) {//dhlwsh energou clockin
						
						clockinStatus.setText("Active");
						
					}
				//mhnuma othonis, an exei ginei idi clock in, kai patithei to clockin button	
				}else {
					
					JOptionPane.showMessageDialog(null, "You have already set Clock In!");
				}
			}
		});
		btnClockIn.setBounds(65, 167, 117, 25);
		contentPane.add(btnClockIn);
		
		JButton btnClockOut = new JButton("Clock out");
		btnClockOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Schedule sch = new Schedule();
					
					//h leitourgia clockout trexei gia oles tis periptwseis/katastaseis
					try {
						
						sch.checkOutTimetable(user);
						
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
					//JOptionPane.showMessageDialog(null, "Telos Vardias!");
					
					//dhlwsh oti den yparxei pia energo clock in, AN eixe ginei
					if(!sch.clockOutState()) {
						
						clockinStatus.setText("Deactivated");
					}
					
			}
		});
		btnClockOut.setBounds(268, 167, 117, 25);
		contentPane.add(btnClockOut);
		
		JLabel lblClockIn = new JLabel("Clock in:");
		lblClockIn.setBounds(158, 72, 70, 15);
		contentPane.add(lblClockIn);
		
		clockinStatus = new JLabel();
		clockinStatus.setBounds(238, 72, 70, 15);
		contentPane.add(clockinStatus);
		
		Schedule sch = new Schedule();
        
        if(sch.clockInState()) {
			clockinStatus.setText("Active");
		}else {
			clockinStatus.setText("Deactivated");
		}
		
		JButton btnNewButton = new JButton("Back");//proigoumenh othoni
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				new Vardia().setVisible(true);;
				
			}
		});
		
		btnNewButton.setBounds(160, 229, 117, 25);
		contentPane.add(btnNewButton);
	}

}
