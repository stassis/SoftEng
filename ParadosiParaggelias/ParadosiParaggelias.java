import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ParadosiParaggelias {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParadosiParaggelias window = new ParadosiParaggelias();
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
	public ParadosiParaggelias() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("P.Diner.A. Paradosi Paraggelias");
		frame.setBounds(100, 100, 451, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ImageIcon png = new ImageIcon("src/logo.png");
        JLabel logo = new JLabel(png);
        
        logo.setBounds(122, 334, 200, 111);
        frame.getContentPane().add(logo);
        
        Image icon = Toolkit.getDefaultToolkit().getImage("src/logo.png"); 
        frame.setIconImage(icon); 
		
		JLabel lblParaggeliesProsParadosi = new JLabel("Orders to be Delivered");
		lblParaggeliesProsParadosi.setFont(new Font("Dialog", Font.BOLD, 16));
		lblParaggeliesProsParadosi.setBounds(128, 11, 212, 15);
		frame.getContentPane().add(lblParaggeliesProsParadosi);
		
		JButton btnNewButton = new JButton("In Restaurant");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				new EntosXwrou().setVisible(true);
			}
		});
		btnNewButton.setBounds(144, 52, 142, 46);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDelivery = new JButton("Delivery");
		btnDelivery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				new Delivery().setVisible(true);
			}
		});
		btnDelivery.setBounds(144, 128, 142, 46);
		frame.getContentPane().add(btnDelivery);
		
		JButton btnTakeAway = new JButton("Take Away");
		btnTakeAway.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				new TakeAway().setVisible(true);
			}
		});
		btnTakeAway.setBounds(144, 200, 142, 46);
		frame.getContentPane().add(btnTakeAway);
		
		 JButton home = new JButton("Home");
	        home.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        		frame.dispose();
	        		new MainMenu();
	        	}
	        });
	        home.setBounds(0, 11, 76, 23);
	        frame.getContentPane().add(home);
	        
	        JButton btnTables = new JButton("Tables");
	        btnTables.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        		frame.dispose();
	        		new alterTables().setVisible(true);
	        	}
	        });
	        btnTables.setBounds(144, 273, 142, 46);
	        frame.getContentPane().add(btnTables);
	}
}
