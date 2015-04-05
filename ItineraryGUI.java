import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;


public class ItineraryGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private JButton btnChangeRestaurant;
	private JButton btnChangeBar;
	private JButton btnChangeClub;
	private JButton btnDone;
	private JButton btnRestart;
	
	private JLabel lblRestName, lblRestAddress;
	private JLabel lblBarName, lblBarAddress;
	private JLabel lblClubName, lblClubAddress;
	private JLabel lblRestScore, lblBarScore, lblClubScore;
	
	private boolean restart = false;
	private boolean running = false;
	
	private Itinerary itin;
	private JLabel lblItinerary;

	/**
	 * Create the frame.
	 */
	public ItineraryGUI(Itinerary itin) throws IOException {
		running = true;
		
		this.itin = itin;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 407);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		if (itin.hasA("restaurant")) {	
			JLabel lblRestaurant = new JLabel("Restaurant");
			lblRestaurant.setFont(new Font("HanziPen TC", Font.PLAIN, 22));
			lblRestaurant.setBounds(25, 71, 106, 29);
			contentPane.add(lblRestaurant);
			
			int indexRestaurant = itin.indexOf("restaurant");
			lblRestName = new JLabel();
			lblRestName.setFont(new Font("HanziPen TC", Font.PLAIN, 20));
			lblRestName.setText(itin.getItinerary().get(indexRestaurant).getData().getName());
			lblRestName.setBounds(56, 103, 329, 35);
			contentPane.add(lblRestName);
			
			lblRestAddress = new JLabel();
			lblRestAddress.setFont(new Font("HanziPen TC", Font.PLAIN, 20));
			lblRestAddress.setText(itin.getItinerary().get(indexRestaurant).getData().getAddress());
			lblRestAddress.setBounds(407, 103, 411, 42);
			contentPane.add(lblRestAddress);
			
			lblRestScore = new JLabel();
			lblRestScore.setFont(new Font("HanziPen TC", Font.PLAIN, 20));
			lblRestScore.setText(Integer.toString(itin.getItinerary().get(indexRestaurant).getData().getScore()));
			lblRestScore.setBounds(105, 131, 61, 33);
			contentPane.add(lblRestScore);
			
			btnChangeRestaurant = new JButton("Change");
			btnChangeRestaurant.setFont(new Font("HanziPen TC", Font.PLAIN, 16));
			btnChangeRestaurant.setBounds(822, 114, 74, 29);
			contentPane.add(btnChangeRestaurant);
			btnChangeRestaurant.addActionListener(this);
		}
		
		if (itin.hasA("bar")) {
			JLabel lblBar = new JLabel("Bar");
			lblBar.setFont(new Font("HanziPen TC", Font.PLAIN, 22));
			lblBar.setBounds(25, 150, 170, 42);
			contentPane.add(lblBar);
			
			int indexBar = itin.indexOf("bar");
			lblBarName = new JLabel();
			lblBarName.setFont(new Font("HanziPen TC", Font.PLAIN, 20));
			lblBarName.setText(itin.getItinerary().get(indexBar).getData().getName());
			lblBarName.setBounds(56, 176, 329, 43);
			contentPane.add(lblBarName);
			
			lblBarAddress = new JLabel();
			lblBarAddress.setFont(new Font("HanziPen TC", Font.PLAIN, 20));
			lblBarAddress.setText(itin.getItinerary().get(indexBar).getData().getAddress());
			lblBarAddress.setBounds(407, 176, 411, 43);
			contentPane.add(lblBarAddress);
			
			lblBarScore = new JLabel();
			lblBarScore.setFont(new Font("HanziPen TC", Font.PLAIN, 20));
			lblBarScore.setText(Integer.toString(itin.getItinerary().get(indexBar).getData().getScore()));
			lblBarScore.setBounds(105, 217, 61, 29);
			contentPane.add(lblBarScore);
			
			btnChangeBar = new JButton("Change");
			btnChangeBar.setFont(new Font("HanziPen TC", Font.PLAIN, 16));
			btnChangeBar.setBounds(822, 187, 74, 29);
			contentPane.add(btnChangeBar);
			btnChangeBar.addActionListener(this);
		}
		
		if (itin.hasA("club")) {	
			JLabel lblClub = new JLabel("Club");
			lblClub.setFont(new Font("HanziPen TC", Font.PLAIN, 22));
			lblClub.setBounds(25, 231, 187, 40);
			contentPane.add(lblClub);
			
			int indexClub = itin.indexOf("club");
			lblClubName = new JLabel();
			lblClubName.setFont(new Font("HanziPen TC", Font.PLAIN, 20));
			lblClubName.setText(itin.getItinerary().get(indexClub).getData().getName());
			lblClubName.setBounds(56, 259, 329, 40);
			contentPane.add(lblClubName);
			
			lblClubAddress = new JLabel();
			lblClubAddress.setFont(new Font("HanziPen TC", Font.PLAIN, 20));
			lblClubAddress.setText(itin.getItinerary().get(indexClub).getData().getAddress());
			lblClubAddress.setBounds(407, 259, 411, 40);
			contentPane.add(lblClubAddress);
			
			lblClubScore = new JLabel();
			lblClubScore.setFont(new Font("HanziPen TC", Font.PLAIN, 20));
			lblClubScore.setText(Integer.toString(itin.getItinerary().get(indexClub).getData().getScore()));
			lblClubScore.setBounds(105, 298, 61, 29);
			contentPane.add(lblClubScore);

			btnChangeClub = new JButton("Change");
			btnChangeClub.setFont(new Font("HanziPen TC", Font.PLAIN, 16));
			btnChangeClub.setBounds(822, 270, 74, 29);
			contentPane.add(btnChangeClub);
			btnChangeClub.addActionListener(this);
		}
		
		btnRestart = new JButton("Restart");
		btnRestart.setFont(new Font("HanziPen TC", Font.PLAIN, 16));
		btnRestart.setBounds(347, 339, 117, 29);
		contentPane.add(btnRestart);
		btnRestart.addActionListener(this);

		btnDone = new JButton("Done");
		btnDone.setFont(new Font("HanziPen TC", Font.PLAIN, 16));
		btnDone.setBounds(460, 339, 117, 29);
		contentPane.add(btnDone);
		
		lblItinerary = new JLabel("— Itinerary —");
		lblItinerary.setFont(new Font("HanziPen TC", Font.PLAIN, 26));
		lblItinerary.setBounds(370, -3, 187, 59);
		contentPane.add(lblItinerary);
		btnDone.addActionListener(this);
		
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnChangeRestaurant) {
			int indexOfRestaurant = itin.indexOf("restaurant");
			itin.changeVenue(indexOfRestaurant); //Replaces the chosen venue with the next best option
			this.lblRestName.setText(itin.getItinerary().get(indexOfRestaurant).getData().getName());
			this.lblRestAddress.setText(itin.getItinerary().get(indexOfRestaurant).getData().getAddress());
			this.lblRestScore.setText(Integer.toString(itin.getItinerary().get(indexOfRestaurant).getData().getScore()));
		}
		if (e.getSource() == btnChangeBar) {
			int indexOfBar = itin.indexOf("bar");
			itin.changeVenue(indexOfBar);
			this.lblBarName.setText(itin.getItinerary().get(indexOfBar).getData().getName());
			this.lblBarAddress.setText(itin.getItinerary().get(indexOfBar).getData().getAddress());
			this.lblBarScore.setText(Integer.toString(itin.getItinerary().get(indexOfBar).getData().getScore()));
		}
		if (e.getSource() == btnChangeClub) {
			int indexOfClub = itin.indexOf("club");
			itin.changeVenue(indexOfClub);
			this.lblClubName.setText(itin.getItinerary().get(indexOfClub).getData().getName());
			this.lblClubAddress.setText(itin.getItinerary().get(indexOfClub).getData().getAddress());
			this.lblClubScore.setText(Integer.toString(itin.getItinerary().get(indexOfClub).getData().getScore()));
		}
		
		this.repaint();
		
		if (e.getSource() == btnRestart) {
			restart = true;
			running = false;
		}
		
		if (e.getSource() == btnDone) {
			running = false;
		}
		
	}
	
	public boolean restart() {
		return restart;
	}
	
	public boolean isRunning() {
		return running;
	}
}
