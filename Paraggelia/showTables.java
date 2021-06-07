import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class showTables {
	
	
	public static int table;
	
	
	showTables(int flag) {
		
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
		
		if((flag % 10) == 0) {stf.getContentPane().add(t1);}
		flag = flag/10;
		if((flag % 10) == 0) {stf.getContentPane().add(t2);}
		flag = flag/10;
		if((flag % 1000) == 0) {stf.getContentPane().add(t3);}
		flag = flag/10;
		if((flag % 10000) == 0) {stf.getContentPane().add(t4);}
		flag = flag/10;
		if((flag % 100000) == 0) {stf.getContentPane().add(t5);}
		
		stf.getContentPane().add(lbdiner);
		stf.setSize(400,500); stf.setVisible(true);
		
		t1.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
				table=1;
				stf.dispose();
				Menou scr = new Menou();
				scr.setVisible(true);
				}}); 
		t2.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
				table=2;
				stf.dispose();
				Menou scr = new Menou();
				scr.setVisible(true);
				}});  
		t3.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
				table=3;
				stf.dispose();
				Menou scr = new Menou();
				scr.setVisible(true);
				}}); 
		t4.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
				table=4;
				stf.dispose();
				Menou scr = new Menou();
				scr.setVisible(true);
				}});  
		t5.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
				table=5;
				stf.dispose();
				Menou scr = new Menou();
				scr.setVisible(true);
				}});  
		
				
	}

}
