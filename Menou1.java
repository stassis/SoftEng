import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menou1 {

	private JFrame frame;
	private JEditorPane editorPane;
	private JEditorPane editorPane_1;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menou1 window = new Menou1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menou1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Menou1.class.getResource("/source/logo.png")));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JLabel lblNewLabel = new JLabel("FAGHTO");
		lblNewLabel.setBounds(10, 25, 61, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("APAITOYMENA YLIKA");
		lblNewLabel_1.setBounds(10, 118, 111, 29);
		frame.getContentPane().add(lblNewLabel_1);
		
		editorPane = new JEditorPane();
		editorPane.setBounds(163, 10, 251, 87);
		frame.getContentPane().add(editorPane);
		
		editorPane_1 = new JEditorPane();
		editorPane_1.setBounds(163, 118, 251, 122);
		frame.getContentPane().add(editorPane_1);
		
		btnNewButton = new JButton("upovolh");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				SefMenou S = new SefMenou();
				S.initialize();
			}
		});
		btnNewButton.setBounds(24, 219, 85, 21);
		frame.getContentPane().add(btnNewButton);
	}

}
