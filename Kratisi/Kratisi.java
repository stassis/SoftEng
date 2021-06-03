import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;



public class Kratisi {
	
	JFrame f = new JFrame("P.Diner.A. Reservation");
	private JTextField textField;
	JSpinner spStartHH = new JSpinner();
	JSpinner spStartmm = new JSpinner();
	JSpinner spEndHH = new JSpinner();
	JSpinner spEndmm = new JSpinner();
	
	Kratisi() {
		f.getContentPane().setLayout(null);
		
		ImageIcon png = new ImageIcon("src/logo.png");
        JLabel logo = new JLabel(png);
        logo.setBounds(20,200,200,150);
        f.getContentPane().add(logo);
        
		JLabel lblStart = new JLabel("Start");
		lblStart.setBounds(30, 84, 46, 14);
		f.getContentPane().add(lblStart);
		
		JLabel lblEnd = new JLabel("End");
		lblEnd.setBounds(30, 118, 46, 14);
		f.getContentPane().add(lblEnd);
		
		JLabel lbl = new JLabel("Enter your reservation info");
		lbl.setBounds(30, 33, 173, 14);
		f.getContentPane().add(lbl);
		
		JLabel lblSeats = new JLabel("Seats");
		lblSeats.setBounds(244, 84, 46, 14);
		f.getContentPane().add(lblSeats);
		
		JSpinner spSeats = new JSpinner();
		spSeats.setBounds(300, 81, 32, 20);
		f.getContentPane().add(spSeats);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(244, 115, 46, 14);
		f.getContentPane().add(lblName);
		
		textField = new JTextField();
		textField.setBounds(300, 112, 93, 20);
		f.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnCheck = new JButton("Choose Table");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int eH = (int)spEndHH.getValue();
				int em = (int)spEndmm.getValue();
				int sH = (int)spStartHH.getValue();
				int sm = (int)spStartmm.getValue();
				
				if(eH < sH) { new Warn("Start later than End"); }
				else if(eH == sH) {
					if (em < sm) { new Warn("Start later than End"); }
				}
				else {
					int Seats = (int)spSeats.getValue();
					String Name = textField.getText();
					
					//showTables();
					//selects table
					//new Booking(Name, Seats, sH, sm, eH, em);
				}
				
		}}); 
		
		btnCheck.setBounds(30, 180, 111, 23);
		f.getContentPane().add(btnCheck);
		
				
		
		spStartHH.setBounds(95, 84, 46, 20);
		spStartHH.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		f.getContentPane().add(spStartHH);
		
		spEndHH.setBounds(95, 115, 46, 20);
		spEndHH.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		f.getContentPane().add(spEndHH);
		
		spStartmm.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spStartmm.setBounds(151, 84, 46, 20);
		f.getContentPane().add(spStartmm);
		
		spEndmm.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spEndmm.setBounds(151, 115, 46, 20);
		f.getContentPane().add(spEndmm);
					
		f.setSize(500,400);f.setVisible(true);
		
	}
	
	//TEMPORARY, MAINLY FOR TESTING
	class Warn {
		Warn (String ss) {
			JFrame w = new JFrame ("Warning");
			JLabel wrn = new JLabel(ss);
			wrn.setBounds(80,80,50,50);w.add(wrn);w.setSize(200,200);w.setVisible(true);
			w.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent we) {w.dispose();}});
		}
	}
	
	public static void main(String Args[]) {
		new Kratisi();
	}
	
	}
