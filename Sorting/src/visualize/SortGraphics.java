package visualize;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Arrays;

import javax.swing.JPanel;

import sortingAlgorithms.*;

public class SortGraphics extends JPanel{
	private Main main;
	
	private int WIDTH = 700;
	private int HEIGHT = 350;
	private int numElements;
	private int maxElement;
	private int[] elements;
	private Color elementColor = Color.BLACK;
	private boolean rainbow = false;
	
	private int hIndex1 = -1;
	private int hIndex2 = -1;
	private int hPivot = -1;
	
	private int sleepLength;
	public int getSleep() {return sleepLength;}
	public void setSleep(int s) {sleepLength = s;
							main.getTxtDelay().setText("" + sleepLength);}
	public void setSleep() {sleepLength = (int)(time * 1000.0 / (double)main.getIterations());
							main.getTxtDelay().setText("" + sleepLength);}
	private double time;
	public double getTime() {return time;}
	public void setTime(double t) {time = t;
							main.getTxtTime().setText("" + (int)time);}
	public void setTime() {time = (double)((double)sleepLength / 1000.0 * (double)main.getIterations());
							main.getTxtTime().setText("" + (int)time);};
	
	private boolean KILL = false;
	public boolean getKILL() {return KILL;}
	public void setKILL(boolean b) {KILL = b;}
	
	public void clearHighlights() {
		hIndex1 = -1;
		hIndex2 = -1;
		hPivot = -1;
	}
	
	public void setHighlights(int hI1, int hI2, int hP) {
		hIndex1 = hI1;
		hIndex2 = hI2;
		hPivot = hP;
	}
	
	public SortGraphics(Main m) {
		main = m;
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
        //setBackground(Color.GREEN);
        setBounds(50,50, WIDTH,HEIGHT);
        setVisible(true);
	}
	
	public int[] getElements() {return elements;}
	public int getWIDTH() {return WIDTH;}
	public int getHEIGHT() {return HEIGHT;}
	
	public void backgroundColor(String desired) {
		if (desired.equals("White"))
			setBackground(Color.WHITE);
		if (desired.equals("Black"))
			setBackground(Color.BLACK);
		if (desired.equals("Gray"))
			setBackground(Color.GRAY);
		repaint();
	}
	
	public void elementColor(String desired) {
		rainbow = false;
		if (desired.equals("Rainbow"))
			rainbow = true;
		if (desired.equals("White"))
			elementColor = Color.WHITE;
		if (desired.equals("Black"))
			elementColor = Color.BLACK;
		repaint();
	}
	
	public void initElements(int size) {
		numElements = size;
		elements = new int[numElements];
		maxElement = Integer.MIN_VALUE;
		for (int i = 0; i < elements.length; i++) {
			elements[i] = i + 1;
			if (elements[i] > maxElement)
				maxElement = elements[i];
		}
		updateIterations((String)main.drpChooseSort.getSelectedItem());
		setTime();
		setSleep();
		repaint();
	}
	
	public void scramble(String desired) {
		if (desired.equals("Random")) {
			int j = 0;
			int temp = 0;
			for (int i = 0; i < elements.length; i++) {
				j = 0 + (int)(Math.random() * elements.length);
				temp = elements[i];
				elements[i] = elements[j];
				elements[j] = temp;
			}
		}
		
		setSleep(15);
		updateIterations((String)main.drpChooseSort.getSelectedItem());
		repaint();
	}
	
	public int getIterations(String sortType) {
		SortingMain s = new SortingMain(this, sortType);
		boolean test = true;
		return s.sort(test, 0);
	}
	
	public void updateIterations(String sortType) {
		int[] temp = Arrays.copyOf(elements, elements.length);
		int i = getIterations(sortType);
		//System.out.println(i);
		main.setIterations(i);
		main.updateIterations();
		elements = temp;
		setTime();
	}
	
	public void sort(String desired) {
		SortingMain s = new SortingMain(this, desired);
		boolean test = false;
		s.sort(test, sleepLength);
		clearHighlights();
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
//		numElements = 500;
//		initElements();
		
		int j = 0;
		for (int i = 0; i < WIDTH; i++) {
			g.setColor(elementColor);

			if ((double)i / (double)WIDTH >= (double)(j + 1) / (double)numElements)
				j++;
			
			//Color and Highlighting Management
			if (rainbow == true) {
				g.setColor(new Color(Color.HSBtoRGB(0.8f * (float)(elements[j] - 1) / (float)maxElement, 1.0f, 1.0f)));
			}
			if (j == hIndex1 || j == hIndex2) {
				g.setColor(Color.YELLOW);
				if (rainbow == true)
					g.setColor(new Color(Color.HSBtoRGB(0.8f * (float)(elements[j] - 1) / (float)maxElement, 1.0f, 0.6f)));
			}
			if (j == hPivot) {
				g.setColor(Color.RED);
				if (rainbow == true)
					g.setColor(new Color(Color.HSBtoRGB(0.8f * (float)(elements[j] - 1) / (float)maxElement, 1.0f, 0.4f)));
			}
			
			if (j > numElements) {
				j--;
				break;
			}
			
			int buffer = (int)((double)elements[j] / (double)maxElement * (double)HEIGHT);
			g.fillRect(i,HEIGHT-buffer, 1,buffer);
		}
	}
}

