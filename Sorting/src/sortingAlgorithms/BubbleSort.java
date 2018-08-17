package sortingAlgorithms;

public class BubbleSort {
	
	public static void bubbleSort (int[] array)
	{
		int end = array.length - 1;
		
		while (end > 0)
		{
			for (int i = 0; i < end; i++)
				if (array[i] > array[i + 1])
				{
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}
			end--;
		}
	}
	
	public static void main (String args[])
	{
		int[] array = {1, 3, 6, 2, 6, 2, 3, -1, 6, 2};
		
		bubbleSort (array);
		
		for (int i = 0; i < array.length; i++)
			System.out.print (array[i] + " ");
	}
}
