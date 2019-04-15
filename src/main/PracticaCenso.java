package main;

import java.awt.EventQueue;

import UI.CensoFrame;

public class PracticaCenso {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CensoFrame frame = new CensoFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
	}
}
