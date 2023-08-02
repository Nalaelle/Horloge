package com.horloge;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Horloge extends JPanel {
	//Variable time
	/*heure
	 * min
	 * sec
	 * date
	 * chrono
	 * minuteur
	 * calendrier + infos jour (une phrase)
	 * */
	private SimpleDateFormat dateFormat;
	
	public Horloge() {
		dateFormat = new SimpleDateFormat("HH:mm:ss");
		
		Timer timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				repaint();				
			}
		});
		timer.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		String time = dateFormat.format(new Date());
		g.setFont(new Font("Arial", Font.PLAIN, 30));
		g.drawString(time, 20, 30);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Horloge");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 100);
		frame.add(new Horloge());
		frame.setVisible(true);

	}

}
