package sortingAlgorithms;

import java.awt.Rectangle;

import visualize.SortGraphics;

public class QuickSort {
	static int iterations = 0;
	
	public static void quickSortFunc (int[] array, int start, int end, SortGraphics sg, boolean test)
	{
		//if (start >= end) return;
		
		int i = start;
		int j = end;
		int pivot = array[(start + end) / 2];
		
		while (i < j)
		{
			while (array[i] < pivot) i++;
			while (array[j] > pivot) j--;
			if (i <= j)
			{
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
			if (test == false) {
				sg.setHighlights(i, j, pivot);
				sg.paintImmediately(new Rectangle(0,0, sg.getWIDTH(), sg.getHEIGHT()));
				try        
				{
				    Thread.sleep(10); //FIX DIS
				} 
				catch(InterruptedException ex) 
				{
				    Thread.currentThread().interrupt();
				}
			}
			else
				iterations++;

//			if (array[i] < pivot)
//				i++;
//			if (array[j] > pivot)
//				j--;
//			if (array[i] >= pivot && array[j] <= pivot)
//			{
//				int temp = array[i];
//				array[i] = array[j];
//				array[j] = temp;
//				i++;
//				j--;
//			}
//			if (j < start)
//				j++;
//			if (i > end)
//				i--;
		}

		if (start < j) quickSortFunc (array, start, j, sg, test);
		if (i < end) quickSortFunc (array, i, end, sg, test);
		
	}
	
	public static int quickSort (int[] array, SortGraphics sg, boolean test)
	{
		iterations = 0;
		quickSortFunc(array, 0, array.length - 1, sg, test);
		return iterations;
	}
}
