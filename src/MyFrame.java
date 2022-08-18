import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MyFrame extends JFrame{
	
	//Calendar calendar;
	SimpleDateFormat timeFormat;
	JLabel timeLabel;
	String time;
	
	SimpleDateFormat dayFormat;
	JLabel dayLabel;
	String day;
	
	SimpleDateFormat dateFormat;
	JLabel dateLabel;
	String date;
	
	SimpleDateFormat yearFormat;
	JLabel yearLabel;
	String year;
	
	MyFrame(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("ClockApp");
		this.setSize(350,210);
		this.setResizable(false);
		this.setLayout(new FlowLayout());
		
		timeFormat = new SimpleDateFormat("hh:mm:ss a"); //https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
		
		timeLabel = new JLabel();
		timeLabel.setFont(new Font("Verdana",Font.PLAIN,50));
		timeLabel.setForeground(new Color(0x00FF00));
		timeLabel.setBackground(Color.black);
		timeLabel.setOpaque(true);
		
		dayFormat = new SimpleDateFormat("EEEE");// name of the day in the week
		dayLabel = new JLabel();
		dayLabel.setFont(new Font("Ink Free",Font.PLAIN,45));
		
		dateFormat = new SimpleDateFormat("dd MMMMM yyyy"); // day in the month
		dateLabel = new JLabel();
		dateLabel.setFont(new Font("Ink Free",Font.PLAIN,40));
		dateLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		
		
		this.add(timeLabel);
		this.add(dayLabel);
		this.add(dateLabel);
		
		this.setVisible(true);
		
		setTime(); // the time will be updated each 1s
				
	}
	public void setTime(){
		while(true) {
			time = timeFormat.format(Calendar.getInstance().getTime());
			timeLabel.setText(time);
			
			day = dayFormat.format(Calendar.getInstance().getTime());
			dayLabel.setText(day);
			
			
			
			date = dateFormat.format(Calendar.getInstance().getTime());
			dateLabel.setText(date);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	

}
