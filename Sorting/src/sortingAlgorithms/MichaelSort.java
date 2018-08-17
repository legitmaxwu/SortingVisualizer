//warning: this is bad for sets of numbers with a large range.

package sortingAlgorithms;

public class MichaelSort {
	public static void michaelSort2(int[] array)
	{
		
	}
	
	public static void michaelSort(int[] array)
	{
		int highest = array[0];
		int smallest = array[0];
		
		for (int i = 0; i < array.length; i++)
		{
			if (array[i] > highest)
				highest = array[i];
			if (array[i] < smallest)
				smallest = array[i];
		}
		
		int[] counterArray = new int[highest - smallest + 1];
		
		for (int i = 0; i < array.length; i++)
		{
			counterArray[array[i] - smallest]++;
		}
		
		int i = 0;
		int j = 0;
		while (i < highest - smallest + 1)
		{
			if (counterArray[i] > 0) {
				array[j] = smallest + i;
				j++;
				counterArray[i]--;
			}
			else
				i++;
		}
	}
	
	public static void main (String args[])
	{
		
	}
}
