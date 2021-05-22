import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OriaElleipsis {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OriaElleipsis window = new OriaElleipsis();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void showporiaelleipsis() {
		frame.show();
	}

	/**
	 * Create the application.
	 */
	public OriaElleipsis() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("P.Diner.A. Allagi oriwn Elleipsis");
		frame.setBounds(100, 100, 440, 402);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon png = new ImageIcon("src/logo.png");
		frame.getContentPane().setLayout(null);
		JLabel logo = new JLabel(png);
		logo.setBounds(116, 236, 202, 111);
        frame.getContentPane().add(logo);
        
        textField = new JTextField();
        textField.setBounds(40, 118, 114, 19);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setBounds(244, 118, 114, 19);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblEisageteOnomaYlikoy = new JLabel("Eisagete onoma Ylikoy:");
        lblEisageteOnomaYlikoy.setFont(new Font("Dialog", Font.PLAIN, 10));
        lblEisageteOnomaYlikoy.setBounds(40, 91, 114, 15);
        frame.getContentPane().add(lblEisageteOnomaYlikoy);
        
        JLabel lblNeoOrio = new JLabel("Neo Orio:");
        lblNeoOrio.setFont(new Font("Dialog", Font.PLAIN, 10));
        lblNeoOrio.setBounds(248, 90, 70, 15);
        frame.getContentPane().add(lblNeoOrio);
        
        JButton btnYpovolh = new JButton("Ypovolh");
        btnYpovolh.setBounds(133, 171, 117, 25);
        frame.getContentPane().add(btnYpovolh);
        
        JButton btnBack_1 = new JButton("Back");
        btnBack_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		frame.dispose();
        		
        		Apothiki newwindow = new Apothiki();
				newwindow.showapothiki();
        	}
        });
        btnBack_1.setBounds(12, 43, 67, 15);
        frame.getContentPane().add(btnBack_1);
	}

}
