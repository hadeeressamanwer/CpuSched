import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.util.Queue;
public class Output extends JFrame {

	private JPanel contentPane;

	/**
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Output frame = new Output();
					frame.setVisible(true);
				} catch (Exception e) {
	        	e.printStackTrace();
				}
		 	}
		});
	}

	/**
	 * Create the frame.
	 */
	public Output() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Average waiting time\r\n");
		lblNewLabel.setBounds(10, 21, 127, 14);
		contentPane.add(lblNewLabel);
		Event event1=new Event();
	    event1.setSize(CPUScheduler.size);
	    event1.fcfsV(CPUScheduler.processInfo);
		double w=event1.getWaitingTime();
		JTextArea WaitingTime = new JTextArea();
		WaitingTime.setBounds(131, 16, 100, 22);
		contentPane.add(WaitingTime);
		Queue <Color> colors=new LinkedList<>();
		colors.add(Color.RED);
	    colors.add(Color.BLUE);
	    colors.add(Color.GREEN);
	    colors.add(Color.YELLOW);
	    WaitingTime.setText(Double. toString(w));
     for (int i=0;i<event1.finalV.size();i++)
     {  
     	String x=event1.finalV.elementAt(i).processName;
	 	JLabel label = new JLabel(x);
	 	label.setBounds(15*event1.finalV.elementAt(i).startTime.intValue(), 87, 14, 14);
	 	contentPane.add(label);
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(15*event1.finalV.elementAt(i).startTime.intValue(), 116, 15*event1.finalV.elementAt(i).burstTime.intValue(), 23);
		btnNewButton.setBackground(colors.peek());
		Color z=colors.peek();
		colors.remove();
		colors.add(z);
		contentPane.add(btnNewButton);
		JLabel lblNewLabel_1 = new JLabel(Double.toString(event1.finalV.elementAt(i).startTime));
		lblNewLabel_1.setBounds(15*event1.finalV.elementAt(i).startTime.intValue(), 151, 20, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel label_1 = new JLabel(Double.toString(event1.finalV.elementAt(i).finishTime));
		label_1.setBounds(10*event1.finalV.elementAt(i).finishTime.intValue(), 151, 20, 14);
		contentPane.add(label_1);
	}
     
	}
}
