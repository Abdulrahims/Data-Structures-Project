import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static JCheckBox[] box = new JCheckBox[4];
	private JPanel mainPanel;
	private LinkedList<String> venueTypes = new LinkedList<String>();
	private boolean running = false;


	public GUI() {
		
		running = true;
		
		//When Object is created, sets JFrame to middle of the screen
		//Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		
		//Necessary JFrame statements
		this.setSize(300,100);
		this.setTitle("Allez");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout());
		
		this.add(mainPanel);
		
		//creating the check box 1
		box[0] = new JCheckBox("Restaurant");
		box[1] = new JCheckBox("Bar");
		box[2] = new JCheckBox("Club");
		
		for (int i = 0; i < 3 ; i++) {
			mainPanel.add(box[i]);
		}
		
		//DoneButton
		JButton done = new JButton("Done");
		mainPanel.add(done);
		this.setVisible(true);
		
		
		done.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(box[0].isSelected()) {
			this.venueTypes.add("restaurant");
		}
		
		if(box[1].isSelected()) {
			this.venueTypes.add("bar");
		}
		
		if(box[2].isSelected()) {
			this.venueTypes.add("club");
		}
		
		running = false;
		this.dispose();
		
	}
	
	public LinkedList<String> getVenueTypes() {
		return venueTypes;
	}
	
	public boolean isRunning() {
		return running;
	}
}
