import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;

//Creating extended class of JComponent class

//Creating JFrame
class MapFrame extends JFrame implements ActionListener {
		
	private static final long serialVersionUID = 1L;
	private int width = 5;
	private int length = 5;
	private JButton buttons[][] = new JButton[width][length]; 
	
	private int x, y;
	
	private boolean running = true;
		
	public MapFrame() throws IOException 
		{
			this.pack();
			this.setSize(760, 510);
			this.setLocationRelativeTo(null);
			this.setTitle("Choose your Location");
			this.setVisible(true);
		 
			// read image file in my HardDisk using imageIO and assign it to buffered image reference
			BufferedImage bf = ImageIO.read(new File("MapFrame.jpg"));
			// adding created component to the JFrame using my backImage class
			this.setContentPane(new backImage(bf));
			//adding other component
			
			GridLayout experimentLayout = new GridLayout(5,5);
			this.setLayout(experimentLayout);
			
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < length; j++) {	
					buttons[i][j] = new JButton();
					buttons[i][j].addActionListener(this);
					clear(buttons[i][j]);
					this.add(buttons[i][j]);
				}
			}
		}
		
	private void clear(JButton b) {
		b.setOpaque(false);
		b.setContentAreaFilled(false);
		b.setBorderPainted(false); //-- to make borders invisible
		//b.setVisible(false); //-- check button location

		
	}
	
	public void actionPerformed(ActionEvent e) 
	{			
		for (int i = 0; i < 5; i++) {	
			for (int j = 0; j < 5; j++) {
				if (e.getSource()==buttons[i][j]) {
					this.x = i;
					this.y = j;
					running = false;
				}
			}
		}
	}
		
	public boolean isRunning() {
		return running;
	}
		
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
}
