
public class MergeSort {
	
	public static void mergeSortFunc(int[] array, int[] arrayS, int start, int end)
	{
		if (start == end)
			return;
		else
		{
			int mid = start + ((end - start) / 2);
			mergeSortFunc(array, arrayS, start, mid);
			mergeSortFunc(array, arrayS, mid + 1, end);
			
			int index = start;
			int a = start;
			int b = mid + 1;
			while (a <= mid && b <= end)
			{
				if (array[a] < array[b])
				{
					arrayS[index] = array[a];
					a++;
				}
				else
				{
					arrayS[index] = array[b];
					b++;
				}
				index++;
			}
			if (a > mid)
				while (index <= end)
				{
					arrayS[index] = array[b];
					index++;
					b++;
				}
			else
				while (index <= end)
				{
					arrayS[index] = array[a];
					index++;
					a++;
				}
			for (int i = start; i <= end; i++)
				array[i] = arrayS[i];
		}
		
		return;
	}
	public static void mergeSort(int[] array)
	{
		int[] arrayS = new int[array.length];
		mergeSortFunc(array, arrayS, 0, array.length - 1);
		return;
	}

	public static void main (String args[])
	{
		int[] array = {1, 2, 4, 1, 5, 2, 7, 1, 1, -1, 8, 1};
		
		mergeSort(array);
		
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
	}
}
