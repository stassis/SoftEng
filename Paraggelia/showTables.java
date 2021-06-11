import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class showTables {
	
	
	public static int table;
	
	
	showTables(int[] flag) {
		
		JFrame stf = new JFrame("Choose your table");
		stf.getContentPane().setLayout(null);
		JButton t1 = new JButton("1"); t1.setBounds(40,30,50,80);
		JButton t2 = new JButton("2"); t2.setBounds(40,225,50,80);
		JButton t3 = new JButton("3"); t3.setBounds(150,30,50,80);
		JButton t4 = new JButton("4"); t4.setBounds(75,140,80,50);
		JButton t5 = new JButton("5"); t5.setBounds(150,225,50,80);
		
		ImageIcon diner = new ImageIcon("src/diner.png");
		JLabel lbdiner = new JLabel(diner);
		lbdiner.setBounds(0,0,400,400);
		
		if(flag[0]==0) {stf.getContentPane().add(t1);}
		if(flag[1]==0) {stf.getContentPane().add(t2);}
		if(flag[2]==0) {stf.getContentPane().add(t3);}
		if(flag[3]==0) {stf.getContentPane().add(t4);}
		if(flag[4]==0) {stf.getContentPane().add(t5);}
		
		stf.getContentPane().add(lbdiner);
		stf.setSize(400,500); stf.setVisible(true);
		Table t = new Table(1);
		
		t1.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
				table=1;
				t.setTableStatus(1,1);
				stf.dispose();
				Menou scr = new Menou();
				scr.setVisible(true);
				}}); 
		t2.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
				table=2;
				t.setTableStatus(2,1);
				stf.dispose();
				Menou scr = new Menou();
				scr.setVisible(true);
				}});  
		t3.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
				table=3;
				t.setTableStatus(3,1);
				stf.dispose();
				Menou scr = new Menou();
				scr.setVisible(true);
				}}); 
		t4.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
				table=4;
				t.setTableStatus(4,1);
				stf.dispose();
				Menou scr = new Menou();
				scr.setVisible(true);
				}});  
		t5.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
				table=5;
				t.setTableStatus(5,1);
				stf.dispose();
				Menou scr = new Menou();
				scr.setVisible(true);
				}});  
		
		JButton btnback = new JButton("back");
		btnback.setBounds(295, 438, 89, 23);
		stf.getContentPane().add(btnback);
		btnback.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			stf.dispose(); 
        	TroposParadoshs scr=new TroposParadoshs();
        	scr.setVisible(true);
			}}); 		
	}

}
