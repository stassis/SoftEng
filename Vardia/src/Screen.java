import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.ObjectInputFilter.Status;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Screen extends JFrame {

	private JPanel contentPane;
	private JLabel clockinStatus;
	private JLabel clockoutStatus;
	private boolean clockinState;
	private boolean clockoutState;
	private boolean check;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Screen frame = new Screen();
					frame.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Screen() {
		
		clockinState = true;
		clockoutState = true;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon png = new ImageIcon("src/logo.png");
        JLabel logo = new JLabel(png);
        
        logo.setBounds(122, 324, 202, 111);
        contentPane.add(logo);
		
		JButton btnClockIn = new JButton("Clock in");
		btnClockIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(clockinState) {
					
					JOptionPane.showMessageDialog(null, "Enarxi Vardias!");
					clockinStatus.setText("Active");
					clockoutStatus.setText("Deactivted");
					
				}else {
					
					JOptionPane.showMessageDialog(null, "Clock in already active!");
					clockinStatus.setText("Active");
					clockoutStatus.setText("Deactivted");
					
				}
			}
		});
		btnClockIn.setBounds(65, 167, 117, 25);
		contentPane.add(btnClockIn);
		
		JButton btnClockOut = new JButton("Clock out");
		btnClockOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(clockoutState) {
					
					JOptionPane.showMessageDialog(null, "Telos Vardias!");
					clockinStatus.setText("Deactivted");
					clockoutStatus.setText("Active");
					
				}else {
					
					JOptionPane.showMessageDialog(null, "I vardia den teleiwse!\nYpoleipomenos xronos: 45m");
					clockinStatus.setText("Active");
					clockoutStatus.setText("Deactivted");
				}
			}
		});
		btnClockOut.setBounds(268, 167, 117, 25);
		contentPane.add(btnClockOut);
		
		JLabel lblClockIn = new JLabel("Clock in:");
		lblClockIn.setBounds(65, 53, 70, 15);
		contentPane.add(lblClockIn);
		
		JLabel lblClockOut = new JLabel("Clock out:");
		lblClockOut.setBounds(268, 53, 70, 15);
		contentPane.add(lblClockOut);
		
		clockinStatus = new JLabel("STATUS");
		clockinStatus.setBounds(136, 53, 70, 15);
		contentPane.add(clockinStatus);
		
		clockoutStatus = new JLabel("STATUS");
		clockoutStatus.setBounds(350, 53, 70, 15);
		contentPane.add(clockoutStatus);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
				Vardia var = new Vardia();
				var.showmain();
			}
		});
		
		
		
		btnNewButton.setBounds(160, 229, 117, 25);
		contentPane.add(btnNewButton);
	}
}
