package visualize;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;
import javax.swing.Timer;

class SortGraphics extends JPanel{
	private int WIDTH = 700;
	private int HEIGHT = 350;
	private int numElements;
	private int maxElement;
	private int[] elements;
	
	public SortGraphics() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
        //setBackground(Color.GREEN);
        setBounds(50,50, WIDTH,HEIGHT);
        setVisible(true);
	}
	
	public void initElements(int size) {
		numElements = size;
		elements = new int[numElements];
		maxElement = Integer.MIN_VALUE;
		for (int i = 0; i < elements.length; i++) {
			elements[i] = (i - 10) * (i - 10);//elements.length - i;
			if (elements[i] > maxElement)
				maxElement = elements[i];
		}
		repaint();
	}
	
	public void sort() {
		for (int i = 0; i < elements.length; i++)
		{
			int minimum = elements[i];
			int minIndex = i;
			for (int j = i; j < elements.length; j++)
				if (elements[j] < minimum)
				{
					minimum = elements[j];
					minIndex = j;
				}
			int temp = elements[i];
			elements[i] = elements[minIndex];
			elements[minIndex] = temp;
			paintImmediately(new Rectangle(0,0, WIDTH,HEIGHT));
			try        
			{
			    Thread.sleep(100);
			} 
			catch(InterruptedException ex) 
			{
			    Thread.currentThread().interrupt();
			}
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
//		numElements = 500;
//		initElements();
		g.setColor(Color.BLACK);
		int j = 0;
		for (int i = 0; i < WIDTH - 1; i++) {
			if ((double)i / (double)WIDTH > (double)(j + 1) / (double)numElements) {
				j++;
			}
			if (j >= numElements) {
				j--;
				break;
			}
			int buffer = (int)((double)elements[j] / (double)maxElement * (double)HEIGHT);
			g.fillRect(i,HEIGHT-buffer, 1,buffer);
		}
	}
}

