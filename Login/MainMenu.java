	import java.awt.event.*;  
    import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
    
    
public class MainMenu {
	JFrame f = new JFrame("HI!");
	
	
	MainMenu(String role) {
		
		JButton btnApothiki = new JButton("Apothiki");
		btnApothiki.setBounds(30, 60, 71, 23);
		btnApothiki.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				Apothiki newwindow = new Apothiki();
				newwindow.showapothiki();
			}
		});
		f.getContentPane().setLayout(null);
		f.getContentPane().add(btnApothiki);
		
		JButton btnMenu = new JButton("Menou");
		btnMenu.setBounds(136, 60, 65, 23);
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
		
			}
		});
		f.getContentPane().add(btnMenu);
		
		JButton btnVardia = new JButton("Vardia");
		btnVardia.setBounds(236, 60, 63, 23);
		btnVardia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				f.dispose();
				
				Vardia var = new Vardia();
				var.showmain();
				
			}
		});
		f.getContentPane().add(btnVardia);
		
		JLabel lblRole = new JLabel(role);
		lblRole.setBounds(76, 23, 46, 14);
		f.getContentPane().add(lblRole);
		f.setSize(500,500);
		f.setVisible(true);
	}
}
