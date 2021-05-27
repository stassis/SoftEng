	import java.awt.event.*;  
    import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
    
    
public class MainMenu {
	JFrame f = new JFrame("HI!");
	
	MainMenu() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		f.getContentPane().setLayout(gridBagLayout);
		
		JButton btnApothiki = new JButton("Apothiki");
		btnApothiki.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				Apothiki apo = new Apothiki();
				apo.initialize();
			}
		});
		GridBagConstraints gbc_btnApothiki = new GridBagConstraints();
		gbc_btnApothiki.insets = new Insets(0, 0, 0, 5);
		gbc_btnApothiki.anchor = GridBagConstraints.NORTH;
		gbc_btnApothiki.gridx = 1;
		gbc_btnApothiki.gridy = 2;
		f.getContentPane().add(btnApothiki, gbc_btnApothiki);
		
		JButton btnMenu = new JButton("Menou");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
		
			}
		});
		GridBagConstraints gbc_btnMenu = new GridBagConstraints();
		gbc_btnMenu.insets = new Insets(0, 0, 0, 5);
		gbc_btnMenu.gridx = 3;
		gbc_btnMenu.gridy = 2;
		f.getContentPane().add(btnMenu, gbc_btnMenu);
		
		JButton btnVardia = new JButton("Vardia");
		GridBagConstraints gbc_btnVardia = new GridBagConstraints();
		gbc_btnVardia.gridx = 5;
		gbc_btnVardia.gridy = 2;
		f.getContentPane().add(btnVardia, gbc_btnVardia);
		f.setSize(500,500);
		f.setVisible(true);
	}
	
}
