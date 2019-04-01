package Affichage;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class Menu extends JPanel {
	
	private JButton solo, deux, autre;
	private int choix;
	
	public int getChoix() {
		return choix;
	}

	public Menu() {
		choix = 0;
		setPreferredSize(new Dimension(600,100));
		solo = new JButton("Solo");
		solo.setPreferredSize(new Dimension(190,90));
		solo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				choix = 1;
				
			}
		});
		
		deux = new JButton("Deux");
		deux.setPreferredSize(new Dimension(190,90));
		deux.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				choix = 2;
				
			}
		});
		
		autre = new JButton("Charger");
		autre.setPreferredSize(new Dimension(190,90));
		autre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				choix = 3;
				
			}
		});
		
		add(solo);
		add(deux);
		add(autre);
	}
	
	public void setChoix(int choix) {
		this.choix = choix;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int w = getWidth();
		int h = getHeight();
	}
}
