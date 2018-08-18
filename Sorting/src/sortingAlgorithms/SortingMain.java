package sortingAlgorithms;

import visualize.*;

public class SortingMain {
	static SortGraphics g;
	static String d;
	
	public SortingMain(SortGraphics sg, String desired) {
		g = sg;
		d = desired;
	}
	
	public static int sort(boolean test, int sleep) {
		if (d.equals("Selection Sort"))
			return SelectionSort.selectionSort(g.getElements(), g, test, sleep);
		if (d.equals("Quick Sort"))
			return QuickSort.quickSort(g.getElements(), g, test, sleep);
		if (d.equals("Insertion Sort"))
			return InsertionSort.insertionSort(g.getElements(), g, test, sleep);
		return 0;
	}
	
	public SortGraphics getG () {
		return g;
	}
	
	public static void printArray (int[] array)
	{
		for (int i = 0; i < array.length; i++)
			System.out.printf("%5d", array[i]);
		System.out.println();
	}
	
	public static void copyArray (int[] array, int[] array2)
	{
		for (int i = 0; i < array.length; i++)
			array2[i] = array[i];
	}
	
	public static void main (String args[])
	{
		//OBSOLETE FOR NOW
		
//		int[] arrayOg = {1, 6346, -132, 6, 162, 23, 1, 7, 8, 0, 0, 12, -12, 6233, -734, 0};
//		int[] array = new int[arrayOg.length];
//		
//		copyArray(arrayOg, array);
//		System.out.print("Original: \t\t");
//		printArray(array);
//		
//		copyArray(arrayOg, array);
//		BubbleSort.bubbleSort(array);
//		System.out.print("Bubble Sort: \t\t");
//		printArray(array);
//		
//		copyArray(arrayOg, array);
//		InsertionSort.insertionSort(array);
//		System.out.print("Insertion Sort: \t");
//		printArray(array);
//		
//		copyArray(arrayOg, array);
//		MergeSort.mergeSort(array);
//		System.out.print("Merge Sort: \t\t");
//		printArray(array);
//		
//		copyArray(arrayOg, array);
//		QuickSort.quickSort(array);
//		System.out.print("Quick Sort: \t\t");
//		printArray(array);
//		
//		copyArray(arrayOg, array);
//		SelectionSort.selectionSort(array);
//		System.out.print("Selection Sort: \t");
//		printArray(array);
//		
//		copyArray(arrayOg, array);
//		MichaelSort.michaelSort(array);
//		System.out.print("Michael Sort: \t\t");
//		printArray(array);
	}
}
