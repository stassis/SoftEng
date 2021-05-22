import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.AbstractListModel;

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
		
		ImageIcon png = new ImageIcon("src/logo.png");
		frame.getContentPane().setLayout(null);
		JLabel logo = new JLabel(png);
		logo.setBounds(116, 236, 202, 111);
        frame.getContentPane().add(logo);
		
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
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"patates,5", "tomato,6", "selino,7"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(116, 47, 188, 87);
		frame.getContentPane().add(list);
		
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
		
		
	}
}
