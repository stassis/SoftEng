import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Vardia extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vardia frame = new Vardia();
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
	public Vardia() {
		setTitle("Vardia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("SHIFT");//epomeni othoni
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dispose();
				new Clockscreen().setVisible(true);;
				
			}
		});
		btnNewButton.setBounds(147, 72, 117, 25);
		contentPane.add(btnNewButton);
		
		ImageIcon png = new ImageIcon("src/logo.png");
		JLabel logo = new JLabel(png);
		
		Image icon = Toolkit.getDefaultToolkit().getImage("src/logo.png"); 
        setIconImage(icon); 
        
        logo.setBounds(114, 235, 202, 111);
        contentPane.add(logo);
        
        JButton home = new JButton("Home");
        home.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		dispose();
        		new MainMenu();
        	}
        });
        home.setBounds(0, 11, 76, 23);
        contentPane.add(home);
	}

}
