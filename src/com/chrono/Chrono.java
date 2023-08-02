package com.chrono;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Chrono extends JFrame {
	private Timer timer;
	private int seconds;
	private JLabel timeLabel;
	
	public Chrono() {
		setTitle("Chronomètre");
		setSize(200, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		timeLabel = new JLabel("00:00:00");
		panel.add(timeLabel);
		
		JButton startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				start();
			}
		});
		panel.add(startButton);
		
		JButton stopButton = new JButton("Stop");
		stopButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				stop();
			}
		});
		panel.add(stopButton);
		
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		panel.add(resetButton);
		
		add(panel);
		
	}
	
	private void start() {
		timer.start();
	}
	private void stop() {
		timer.stop();
	}
	private void reset() {
		seconds = 0;
		updateTimeLabel();
	}
	
	private void updateTimeLabel() {
		int hours = seconds / 3600;
		int minutes = (seconds % 3600) / 60;
		int secs = seconds % 60;
		timeLabel.setText(String.format("%02d:%02d:%02d", hours, minutes, secs));
	}

	public static void main(String[] args) {
		Chrono chrono = new Chrono();
		
		chrono.timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				chrono.seconds++;
				chrono.updateTimeLabel();
			}
		});
		chrono.setVisible(true);
	}

}
