import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;  
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ProetDetails {
	
	ProetDetails(int order)
	{
		String[] plates = new String[4];
		int flag=0,q1=0,q2=0,q3=0,q4=0;
		
		JFrame frame = new JFrame("Order "+order+" details");
		frame.setBounds(100, 100, 436, 402);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image icon = Toolkit.getDefaultToolkit().getImage("src/logo.png");frame.setIconImage(icon);
		ImageIcon png = new ImageIcon("src/logo.png");
		frame.getContentPane().setLayout(null);
		JLabel logo = new JLabel(png);
        
        JButton btnBack_1 = new JButton("Back");
        btnBack_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		frame.dispose();
        		new Proetoimasia();}
        });
        btnBack_1.setBounds(10, 11, 67, 15);
        frame.getContentPane().add(btnBack_1);
		
        
		DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Ingredient", "Available", "Use"}, 0){@Override
		    public boolean isCellEditable(int row, int column) {
			if(column == 2) {return true;}
			else{return false;}}};
			
		DefaultTableModel tableModel2 = new DefaultTableModel(new String[]{"Ingredient", "Available", "Use"}, 0){@Override
		    public boolean isCellEditable(int row, int column) {
			if(column == 2) {return true;}
			else{return false;}}};	
				
		DefaultTableModel tableModel3 = new DefaultTableModel(new String[]{"Ingredient", "Available", "Use"}, 0){@Override
		    public boolean isCellEditable(int row, int column) {
			if(column == 2) {return true;}
			else{return false;}}};
			
		DefaultTableModel tableModel4 = new DefaultTableModel(new String[]{"Ingredient", "Available", "Use"}, 0){@Override
		    public boolean isCellEditable(int row, int column) {
			if(column == 2) {return true;}
			else{return false;}}};	
		try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
			String sql = "SELECT * FROM orders WHERE order_id = '"+order+"'";
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				q1 = rs.getInt("quantity1"); if(q1 != 0) {flag = flag + 1;}
	            q2 = rs.getInt("quantity2"); if(q2 != 0) {flag = flag + 10;}
	            q3 = rs.getInt("quantity3"); if(q3 != 0) {flag = flag + 100;}
	            q4 = rs.getInt("quantity4"); if(q4 != 0) {flag = flag + 1000;}
	            
	       }
			
			sql = "SELECT * FROM plate";
			rs = stmt.executeQuery(sql);
			
			int i=0;
			
			while (rs.next()) {
				plates[i] = rs.getString("name");
				i++;}
			
			
			
			sql = "SELECT * FROM food";
			rs = stmt.executeQuery(sql);
			
			
			while (rs.next()) {
	            String Ing = rs.getString("Fagito");
	            int quan = rs.getInt("Posotita");
	            String[] data = { Ing, Integer.toString(quan)};
	            tableModel.addRow(data);tableModel2.addRow(data);tableModel3.addRow(data);tableModel4.addRow(data);}

			c.close();stmt.close();rs.close();
			
	}catch (Exception ee) {ee.printStackTrace();}
		
		int[] first = {30, 50, 80};
		int[] second = {130, 150, 180};
		int[] third = {230, 250, 280};
		int[] fourth = {330, 350, 380};
		
		int[] i = {0,0,0};
		int[] j = {0,0,0};
		int[] k = {0,0,0};
		
		int active = 0;
		
		
		//Prwto Piato
		JTable ylika1 = new JTable(tableModel);
		JScrollPane js1=new JScrollPane(ylika1);
		js1.setBounds(116, first[0], 240, 85);
		
		JLabel plate1 = new JLabel(plates[0]+"  x"+q1);
		plate1.setBounds(10, first[1], 98, 14);
		
		JToggleButton ready1 = new JToggleButton("Not Ready");
		ready1.addItemListener(new ItemListener(){
		    public void itemStateChanged(ItemEvent e) {
		         JToggleButton item=(JToggleButton)e.getSource();
		      if(e.getStateChange()==ItemEvent.SELECTED){ready1.setText("Ready");} 
		      else if(e.getStateChange()==ItemEvent.DESELECTED){ready1.setText("Not Ready");}}});
		ready1.setBounds(10, first[2], 95, 23);
		
		if (flag%10 == 1) {
		frame.getContentPane().add(plate1);
		frame.getContentPane().add(js1);
		frame.getContentPane().add(ready1);
		active++;}
		else {ready1.setText("Ready");}
		
		if(active==0) {i=first;}
		else if(active==1) {i=second;}
		
		flag = flag/10;
		
		//Deutero
		JTable ylika2 = new JTable(tableModel2);
		JScrollPane js2 = new JScrollPane(ylika2);
		js2.setBounds(116, i[0], 240, 85);
	
		JLabel plate2 = new JLabel(plates[1]+"  x"+q2);
		plate2.setBounds(10, i[1], 95, 14);
		
		JToggleButton ready2 = new JToggleButton("Not Ready");
		ready2.setBounds(10, i[2], 95, 23);
		ready2.addItemListener(new ItemListener(){
		    public void itemStateChanged(ItemEvent e) {
		         JToggleButton item=(JToggleButton)e.getSource();
		      if(e.getStateChange()==ItemEvent.SELECTED){ready2.setText("Ready");} 
		      else if(e.getStateChange()==ItemEvent.DESELECTED){ready2.setText("Not Ready");}}});
		
		if (flag%10 == 1) {
		frame.getContentPane().add(plate2);
		frame.getContentPane().add(js2);
		frame.getContentPane().add(ready2);
		active++;}
		else {ready2.setText("Ready");}
		
		if(active==0) {j=first;}
		else if(active==1) {j=second;}
		else if(active==2) {j=third;}
		
		flag = flag/10;
		
		//Trito
		JTable ylika3 = new JTable(tableModel3);
		JScrollPane js3 = new JScrollPane(ylika3);
		js3.setBounds(116, j[0], 240, 85);
		
		
		JLabel plate3 = new JLabel(plates[2]+"  x"+q3);
		plate3.setBounds(10, j[1], 95, 14);
		
		
		JToggleButton ready3 = new JToggleButton("Not Ready");
		ready3.setBounds(10, j[2], 95, 23);
		ready3.addItemListener(new ItemListener(){
		    public void itemStateChanged(ItemEvent e) {
		         JToggleButton item=(JToggleButton)e.getSource();
		      if(e.getStateChange()==ItemEvent.SELECTED){ready3.setText("Ready");} 
		      else if(e.getStateChange()==ItemEvent.DESELECTED){ready3.setText("Not Ready");}}});
		
		if (flag%10 == 1) {
		frame.getContentPane().add(js3);
		frame.getContentPane().add(plate3);
		frame.getContentPane().add(ready3);
		active++;}
		else {ready3.setText("Ready");}
		
		if(active==0) {k=first;}
		else if(active==1) {k=second;}
		else if(active==2) {k=third;}
		else if(active==3) {k=fourth;}
		
		flag = flag/10;
		
		//Tetarto
		JTable ylika4 = new JTable(tableModel4);
		JScrollPane js4 = new JScrollPane(ylika4);
		js4.setBounds(116, k[0], 240, 85);
	
		JLabel plate4 = new JLabel(plates[3]+"  x"+q4);
		plate4.setBounds(10, k[1], 95, 14);
		
		JToggleButton ready4 = new JToggleButton("Not Ready");
		ready4.setBounds(10, k[2], 95, 23);
		ready4.addItemListener(new ItemListener(){
		    public void itemStateChanged(ItemEvent e) {
		         JToggleButton item=(JToggleButton)e.getSource();
		      if(e.getStateChange()==ItemEvent.SELECTED){ready4.setText("Ready");} 
		      else if(e.getStateChange()==ItemEvent.DESELECTED){ready4.setText("Not Ready");}}});
		
		if (flag%10 == 1) {
		frame.getContentPane().add(js4);
		frame.getContentPane().add(plate4);
		frame.getContentPane().add(ready4);
		active++;}
		else {ready4.setText("Ready");}
		
		if(active==3) {frame.setSize(430,600);}
		if(active==4) {frame.setSize(430,700);}
		
		
		JButton btnGO = new JButton("SUBMIT COMPLETED ORDERS");
        btnGO.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if (ready1.getText().equals("Ready")
        			&&ready2.getText().equals("Ready")
        			&&ready3.getText().equals("Ready")
        			&&ready4.getText().equals("Ready")) {
        			
        			new ProetUpdate(tableModel,tableModel2,tableModel3,tableModel4);
        			frame.dispose();
        			JOptionPane.showMessageDialog(null, "Delivery notified");
        			//new Notification
        			new MainMenu();}
        		
        		else {JOptionPane.showMessageDialog(null, "Not Everything Ready");}
        		}
        });
        btnGO.setBounds(50, 30+100*active, 300, 40);
        frame.getContentPane().add(btnGO);
        
		
		logo.setBounds(116, 80+100*active, 202, 111);
        frame.getContentPane().add(logo);
		frame.setVisible(true);
		}


//public void updatemodels(DefaultTableModel tm) {
	

//} 
}