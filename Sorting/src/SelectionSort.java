
public class SelectionSort {
	
	public static void selectionSort(int[] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			int minimum = array[i];
			int minIndex = i;
			for (int j = i; j < array.length; j++)
				if (array[j] < minimum)
				{
					minimum = array[j];
					minIndex = j;
				}
			int temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}
	}
	
	public static void main (String args[])
	{
		int[] array = {-1, 2, 3, 5, 2, -2, -1, 4, 6, 0, 1};

		selectionSort(array);
		
		for (int i = 0; i < array.length; i++)
			System.out.println(array[i]);
	}
}
