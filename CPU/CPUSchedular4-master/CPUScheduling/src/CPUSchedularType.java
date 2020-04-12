import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CPUSchedularType extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CPUSchedularType frame = new CPUSchedularType();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CPUSchedularType() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton fcfs = new JButton("FCFS");
		fcfs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Event event1=new Event();
			    event1.setSize(CPUScheduler.size);
				event1.fcfsV(CPUScheduler.processInfo);
				double x=event1.getWaitingTime();
				System.out.println(x);
				dispose();
				Output frame3=new Output();
				frame3.setVisible(true);
			}
			
		});
		fcfs.setFont(new Font("Arial", Font.PLAIN, 20));
		fcfs.setBounds(75, 35, 250, 36);
		contentPane.add(fcfs);
		
		JButton sjf = new JButton("SJF");
		sjf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Event event3=new Event();
				event3.setSize(CPUScheduler.size);
				event3.sjf(CPUScheduler.processInfo);
				double z=event3.getWaitingTime();
				
				System.out.println(z);
				dispose();
			}
		});
		sjf.setFont(new Font("Arial", Font.PLAIN, 20));
		sjf.setBounds(75, 92, 250, 36);
		contentPane.add(sjf);
		
		JButton priority = new JButton("Priority");
		priority.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Event event2=new Event();
				event2.setSize(CPUScheduler.size);
				event2.priority(CPUScheduler.processInfo);
				double y=event2.getWaitingTime();
				
				System.out.println(y);
				dispose();
			}
		});
		priority.setFont(new Font("Arial", Font.PLAIN, 20));
		priority.setBounds(75, 154, 250, 36);
		contentPane.add(priority);
		
		JButton roundRobin = new JButton("RoundRobin");
		roundRobin.setFont(new Font("Arial", Font.PLAIN, 20));
		roundRobin.setBounds(75, 219, 250, 36);
		contentPane.add(roundRobin);
	}
}
