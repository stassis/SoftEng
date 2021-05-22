import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlaisiaEisagogisTimon {

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
					PlaisiaEisagogisTimon window = new PlaisiaEisagogisTimon();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void showplaisiatimwn() {
		frame.show();
	}

	/**
	 * Create the application.
	 */
	public PlaisiaEisagogisTimon() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("P.Diner.A. Plaisia Eisagogis Timon");
		frame.setBounds(100, 100, 440, 402);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ImageIcon png = new ImageIcon("src/logo.png");
		frame.getContentPane().setLayout(null);
		JLabel logo = new JLabel(png);
		logo.setBounds(116, 236, 202, 111);
        frame.getContentPane().add(logo);
        
        textField = new JTextField();
        textField.setBounds(44, 112, 114, 19);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setBounds(250, 112, 114, 19);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblOnomaYlikoy = new JLabel("Onoma Ylikoy:");
        lblOnomaYlikoy.setFont(new Font("Dialog", Font.PLAIN, 10));
        lblOnomaYlikoy.setBounds(50, 85, 82, 15);
        frame.getContentPane().add(lblOnomaYlikoy);
        
        JLabel lblPosothta = new JLabel("Posothta:");
        lblPosothta.setFont(new Font("Dialog", Font.PLAIN, 10));
        lblPosothta.setBounds(250, 84, 70, 15);
        frame.getContentPane().add(lblPosothta);
        
        JButton btnProsthiki = new JButton("Prosthiki");
        btnProsthiki.setBounds(142, 166, 117, 25);
        frame.getContentPane().add(btnProsthiki);
        
        JButton btnBack_1 = new JButton("Back");
        btnBack_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		frame.dispose();
        		
        		PliroforiesApothikis newwindow = new PliroforiesApothikis();
				newwindow.showpliroforiesapothikis();
        	}
        });
        btnBack_1.setBounds(12, 23, 67, 15);
        frame.getContentPane().add(btnBack_1);
	}
}
