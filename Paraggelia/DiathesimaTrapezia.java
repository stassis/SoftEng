import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class DiathesimaTrapezia extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiathesimaTrapezia frame = new DiathesimaTrapezia();
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
	public DiathesimaTrapezia() {
		setTitle("P.Diner.A Entos_EpiloghTrapeziou");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Epilekste trapezi:");
		lblNewLabel.setBounds(123, 21, 131, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnEpilogTrapeziou = new JButton("epilogh");
		btnEpilogTrapeziou.setBounds(123, 249, 89, 23);
		contentPane.add(btnEpilogTrapeziou);
		
		JList list = new JList();
		list.setBounds(63, 46, 239, 175);
		contentPane.add(list);
		list.setToolTipText("");
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"trapezi1", "trapezi2", "trapezi3", "trapezi4", "trapezi5"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JLabel lbl_logo = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		lbl_logo.setIcon(new ImageIcon(img));
		lbl_logo.setBounds(78, 284, 213, 128);
		contentPane.add(lbl_logo);
	}
}
