import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

public class Schedule {

	private static boolean clockIn = false;
	private static boolean clockOut = false;
	private String st;
	private String en;
	private boolean inTime;
	private boolean beforeTime;
	private boolean afterTime;
	private boolean exactTime;
	
	public boolean clockInState(){
		return clockIn;
	}
	
	public boolean clockOutState(){
		return clockOut;
	}
	
	
	public void checkInTimetable(String inputUser) throws SQLException, ParseException {
		
		try {
			
			//Syndesi me th vasi
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
			Statement stmt = c.createStatement();
			String sql = "SELECT Start,End FROM Schedule WHERE User = '"+ inputUser +"'";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

	            st= rs.getTime("Start").toString();
	            en= rs.getTime("End").toString();
  
	         }
			//****Metatropi Time se Calendar gia ypologismo praxewn****
			Date time1 = (Date) new SimpleDateFormat("HH:mm:ss").parse(st);
		    Calendar calendar1 = Calendar.getInstance();
		    calendar1.setTime(time1);
		    calendar1.add(Calendar.DATE, 1);
		    
		    Date time2 = (Date) new SimpleDateFormat("HH:mm:ss").parse(en);
		    Calendar calendar2 = Calendar.getInstance();
		    calendar2.setTime(time2);
		    calendar2.add(Calendar.DATE, 1);
		    
			java.util.Date utilDate = new java.util.Date();
            java.sql.Time sqlTime = new java.sql.Time(utilDate.getTime());
            String sqtime = sqlTime.toString();
            
            Date d = (Date) new SimpleDateFormat("HH:mm:ss").parse(sqtime);
            Calendar calendar3 = Calendar.getInstance();
            calendar3.setTime(d);
            calendar3.add(Calendar.DATE, 1);
            
            Date x = (Date) calendar3.getTime();
            //**** - ****
            
            if(x.equals(calendar1.getTime())) {
                //checkes whether the current time is exactly Sef-09:00:00/Dianomeas-10:00:00.
            	exactTime=true;
            	
            }else {
            	
            	exactTime=false;
            }
            if (x.after(calendar1.getTime()) && x.before(calendar2.getTime())) {
                //checkes whether the current time is between Sef-09:00:00/Dianomeas-10:00:00 and 17:00:00.
                //System.out.println(true);
            	inTime=true;
            	
            }else {
            	
            	inTime=false;
            }
            
            if (x.after(calendar2.getTime())) {
                //checkes whether the current time is before Sef-09:00:00/Dianomeas-10:00:00
                //System.out.println(true);
            	afterTime=true;
            	
            }else {
            	
            	afterTime=false;
            }
            
            if (x.before(calendar1.getTime())) {
                //checkes whether the current time is after 17:00:00.
                //System.out.println(true);
            	beforeTime=true;
            	
            }else {
            	
            	beforeTime=false;
            }
			
		
//**Debugging**	            System.out.println(resultStart);
//**Debugging**	            System.out.println(resultEnd);
//**Debugging**	            System.out.println(sqlTime);
//**Debugging**	            System.out.println(start);
//**Debugging**	            System.out.println(end);
//**Debugging**	            System.out.println(st);
//**Debugging**	            System.out.print(en);
            
            if(exactTime) {//To melos proswpikou (Sef,Dianomeas) kaneo clockin akrivws sthn wra enarxis
            	
            	JOptionPane.showMessageDialog(null, "Shift Start!");

            	clockIn = true;
            	clockOut = true;
            	
            }else if(inTime){//To melos proswpikou (Sef,Dianomeas) kanei clockin meta thn wra enarxis kai prin thn wra lixis
        		
            	JOptionPane.showMessageDialog(null, "Delayed Shift Start! The owner will be notified!");

            	clockIn = true;
            	clockOut = true;
            	//notifyHost();
            	
        	}else if(beforeTime){//To melos proswpikou (Sef,Dianomeas) kanei clockin prin thn wra enarxis
            	
            	JOptionPane.showMessageDialog(null, "Restaurant has not Opened yet!");
            	
            	
            }else {//To melos proswpikou (Sef,Dianomeas) kanei clockin meta thn wra lixis
            	
            	JOptionPane.showMessageDialog(null, "Store is closed...");
            	
            }
            
            //***apeleutherosi porwn
			rs.close();
			stmt.close();
			c.close();
			//***
			
		}catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	
public void checkOutTimetable(String inputUser) throws SQLException {
		
		try {
	    	
			//Syndesi me th vasi
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
			Statement stmt = c.createStatement();
			String sql = "SELECT Start,End FROM Schedule WHERE User = '"+ inputUser +"'";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
	            
	            st= rs.getTime("Start").toString();
	            en= rs.getTime("End").toString();
  
	         }
			
			//****Metatropi Time se Calendar gia ypologismo praxewn
			Date time1 = (Date) new SimpleDateFormat("HH:mm:ss").parse(st);
		    Calendar calendar1 = Calendar.getInstance();
		    calendar1.setTime(time1);
		    calendar1.add(Calendar.DATE, 1);
		    
		    Date time2 = (Date) new SimpleDateFormat("HH:mm:ss").parse(en);
		    Calendar calendar2 = Calendar.getInstance();
		    calendar2.setTime(time2);
		    calendar2.add(Calendar.DATE, 1);
		    
			java.util.Date utilDate = new java.util.Date();
            java.sql.Time sqlTime = new java.sql.Time(utilDate.getTime());
            String sqtime = sqlTime.toString();
            
            Date d = (Date) new SimpleDateFormat("HH:mm:ss").parse(sqtime);
            Calendar calendar3 = Calendar.getInstance();
            calendar3.setTime(d);
            calendar3.add(Calendar.DATE, 1);
            
            Date x = (Date) calendar3.getTime();
            //****
            
            if(x.equals(calendar1.getTime())) {
                //checkes whether the current time is exactly Sef-09:00:00/Dianomeas-10:00:00.
            	exactTime=true;
            	
            }else {
            	
            	exactTime=false;
            }
            if (x.after(calendar1.getTime()) && x.before(calendar2.getTime())) {
                //checkes whether the current time is between Sef-09:00:00/Dianomeas-10:00:00 and 17:00:00.
                //System.out.println(true);
            	inTime=true;
            	
            }else {
            	
            	inTime=false;
            }
            
            if (x.after(calendar2.getTime())) {
                //checkes whether the current time is before Sef-09:00:00/Dianomeas-10:00:00
                //System.out.println(true);
            	afterTime=true;
            	
            }else {
            	
            	afterTime=false;
            }
            
            if (x.before(calendar1.getTime())) {
                //checkes whether the current time is after 17:00:00.
                //System.out.println(true);
            	beforeTime=true;
            	
            }else {
            	
            	beforeTime=false;
            }
	
            	if(afterTime) {//An h wra einai meta th lixi tis vardias
            		
            		if(clockOut) {//An yparxei energo clockin, tote epityxes clockout(teleiwse th vardia)
            			
            			JOptionPane.showMessageDialog(null, "Successful Clock Out!");
            			clockIn = false;
                    	clockOut = false;
            			
            		}else {//Den yparxei energo clockin, opote h vardia exei lixi idi
            			
            			JOptionPane.showMessageDialog(null, "Shift is Over!");
            		}
            		
            	}else {//h wra einai prin th lixi tis vardias
            		
            		if(clockOut) {//exei ginei clock in, ara to *clockout* einai *true*. Ypologizetai h enapomeinousa wra mexri th lixi tis vardias
	            		
            			long diff =  time2.getTime() - d.getTime();
            			
            			String hms = String.format("%02d:%02d:%02d", 
            				    TimeUnit.MILLISECONDS.toHours(diff),
            				    TimeUnit.MILLISECONDS.toMinutes(diff) - 
            				    TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(diff)),
            				    TimeUnit.MILLISECONDS.toSeconds(diff) - 
            				    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(diff)));
            			
						JOptionPane.showMessageDialog(null, "Shift is not Over! Elapsed Time: "+hms);
						
	            	}else {//Den exei ginei pote clockin opote den mporei na ginei clockout
	            		
						JOptionPane.showMessageDialog(null, "You have to Clock In first!");
	            	}
            	}
            	
            //apeleutherosi porwn
			rs.close();
			stmt.close();
			c.close();
			
		}catch (ClassNotFoundException | ParseException e) {
			
			e.printStackTrace();
		}
	}
}