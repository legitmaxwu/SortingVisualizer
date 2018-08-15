
public class InsertionSort {
	
	public static void insertionSort(int[] array)
	{
		for (int i = 1; i < array.length; i++)
		{
			if (array[i] < array[i - 1])
			{
				int value = array[i];
				int j;
				for (j = i; j > 0 && array[j - 1] > value; j--)
					array[j] = array[j - 1];
				array[j] = value;
			}
		}
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
