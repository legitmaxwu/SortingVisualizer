package sortingAlgorithms;

import java.awt.Rectangle;
import visualize.*;

public class SelectionSort {
	
	public static int selectionSort(int[] elements, SortGraphics sg, boolean test)
	{
		int iterations = 0;
		for (int i = 0; i < elements.length; i++)
		{
			int minimum = elements[i];
			int minIndex = i;
			for (int j = i; j < elements.length; j++)
				if (elements[j] < minimum)
				{
					minimum = elements[j];
					minIndex = j;
					if (test == false) {
						sg.setHighlights(j, -1, i);
						sg.paintImmediately(new Rectangle(0,0, sg.getWIDTH(), sg.getHEIGHT()));
						try        
						{
						    Thread.sleep(50); //FIX DIS
						} 
						catch(InterruptedException ex) 
						{
						    Thread.currentThread().interrupt();
						}
					}
					else
						iterations++;
				}
			int temp = elements[i];
			elements[i] = elements[minIndex];
			elements[minIndex] = temp;
		}
		if (test == false)
			sg.paintImmediately(new Rectangle(0,0, sg.getWIDTH(), sg.getHEIGHT()));
		return iterations;
	}
	
	public static void main (String args[])
	{

	}
}
