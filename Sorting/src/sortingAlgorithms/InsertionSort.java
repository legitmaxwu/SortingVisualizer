package sortingAlgorithms;

import java.awt.Rectangle;

import visualize.SortGraphics;

public class InsertionSort {
	
	public static int insertionSort(int[] array, SortGraphics sg, boolean test, int sleep)
	{
		int iterations = 0;
		for (int i = 1; i < array.length; i++)
		{
			if (array[i] < array[i - 1])
			{
				int value = array[i];
				int j;
				for (j = i; j > 0 && array[j - 1] > value; j--) {
					array[j] = array[j - 1];
					if (test == false) {
						sg.setHighlights(j, -1, i);
						sg.paintImmediately(new Rectangle(0,0, sg.getWIDTH(), sg.getHEIGHT()));
						try        
						{
						    Thread.sleep(sleep); //FIX DIS
						} 
						catch(InterruptedException ex) 
						{
						    Thread.currentThread().interrupt();
						}
					}
					else
						iterations++;
				}
				array[j] = value;
			}
		}
		return iterations;
	}
	public static void main (String args[])
	{
		int[] array = {-1, 2, 3, 5, 2, -2, -1, 4, 6};

// ATTEMPT 1
//		for (int i = 1; i < array.length; i++)
//		{
//			if (array[i] < array[i - 1])
//			{
//				int value = array[i];
//				int index = i;
//				for (int j = i; j > 0; j--)
//				{
//					if (value < array[j - 1])
//					{
//						array[j] = array[j - 1];
//						index = j - 1;
//					}
//				}
//				array[index] = value;
//			}
//		}
		
// ATTEMPT 2

		
		for (int i = 0; i < array.length; i++)
			System.out.println(array[i]);
	}
}
