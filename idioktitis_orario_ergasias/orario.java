import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class orario {

	private JFrame frmPdineraTimetable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					orario window = new orario();
					window.frmPdineraTimetable.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void showmain() {
		frmPdineraTimetable.show();
	}

	/**
	 * Create the application.
	 */
	public orario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPdineraTimetable = new JFrame("P.Diner.A. Orario");
		frmPdineraTimetable.setTitle("P.Diner.A. Timetable");
		frmPdineraTimetable.setBounds(100, 100, 440, 402);
		frmPdineraTimetable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPdineraTimetable.getContentPane().setLayout(null);
		
		ImageIcon png = new ImageIcon("src/logo.png");
        JLabel logo = new JLabel(png);
        
        logo.setBounds(116, 236, 202, 111);
        frmPdineraTimetable.getContentPane().add(logo);
		
		JButton btnNewButton = new JButton("Timetable");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmPdineraTimetable.dispose();
				orario_info oi= new orario_info();
				oi.setVisible(true);
			
			}
		});
		btnNewButton.setBounds(167, 63, 89, 23);
		frmPdineraTimetable.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmPdineraTimetable.dispose();
				new MainMenu();
			}
		});
		btnNewButton_1.setBounds(0, 11, 76, 23);
		frmPdineraTimetable.getContentPane().add(btnNewButton_1);
	}

}
