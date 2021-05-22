import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class AlloiwmenaYlika {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlloiwmenaYlika window = new AlloiwmenaYlika();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void showpligmenaylika() {
		frame.show();
	}

	/**
	 * Create the application.
	 */
	public AlloiwmenaYlika() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("P.Diner.A. Alloiwmena Ylika");
		frame.setBounds(100, 100, 440, 402);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon png = new ImageIcon("src/logo.png");
		frame.getContentPane().setLayout(null);
		JLabel logo = new JLabel(png);
		logo.setBounds(116, 236, 202, 111);
        frame.getContentPane().add(logo);
        
        JButton btnBack_1 = new JButton("Back");
        btnBack_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		frame.dispose();
        		
        		Apothiki newwindow = new Apothiki();
				newwindow.showapothiki();
        	}
        });
        btnBack_1.setBounds(12, 32, 67, 15);
        frame.getContentPane().add(btnBack_1);
        
        JLabel lblAlloiwmenaYlika = new JLabel("Alloiwmena Ylika");
        lblAlloiwmenaYlika.setBounds(157, 32, 126, 15);
        frame.getContentPane().add(lblAlloiwmenaYlika);
        
        JList list = new JList();
        list.setModel(new AbstractListModel() {
        	String[] values = new String[] {"patates,3", "tomato,1"};
        	public int getSize() {
        		return values.length;
        	}
        	public Object getElementAt(int index) {
        		return values[index];
        	}
        });
        list.setBounds(116, 97, 168, 104);
        frame.getContentPane().add(list);
        
        
        
        JButton btnAfairesi = new JButton("Afairesi");
        btnAfairesi.setBounds(311, 110, 98, 25);
        frame.getContentPane().add(btnAfairesi);
	}

}
