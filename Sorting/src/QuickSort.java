
public class QuickSort {
	
	public static void quickSortFunc (int[] array, int start, int end)
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

		if (start < j) quickSortFunc (array, start, j);
		if (i < end) quickSortFunc (array, i, end);
		
	}
	
	public static void quickSort (int[] array)
	{
		quickSortFunc(array, 0, array.length - 1);
	}
	
	public static void main (String args[])
	{
		 int[] array = {3381, 443, 6918, -4429, 1531, 4315, 862, -2062, -8358, -5806, -7567, -5437, -6660, -3483, -2651, 5305, 9164, -7098, 1408, -6435, -9306, -5091, -437, -5228, -1196, -5312, -4654, 9895, -7803, 1636, -6296, -3011, 2185, 663, 4016, -759, 6016, -3910, -4643, 686, -2373, 5082, 6201, 6240, 6638, 9984, 9819, -6736, -8280, 7932, -5210, -3511, -915, -6887, -2265, -2133, -1292, -9621, 7449, 451, 2765, -4811, -5825, 9327, -6109, 962, -2363, 2837, 8754, 8414, -5950, -930, 7391, -1574, 4514, -4607, 8941, 7010, -357, -9295, 2337, -6914, 6448, -7880, -2134, -8797, 5310, -2017, 585, -2826, -1244, -9290, -5723, 7473, -5460, -6406, 3857, 1089, 2669, -2807, -6598, -7025, -7512, -8397, -5027, -4457, 3818, -5861, -3930, -5905, 404, -9466, -4208, -5352, -5137, -9254, 6129, 9257, -112, -3457, 314, 6306, 7857, -5851, 8589, 2159, -5264, -7905, -5421, 2589, 1945, -6711, -9422, -3903, -869, 9798, -1245, 3295, -1739, 756, -5244, -7396, -6120, 4203, -762, 6213, -8005, 4606, -9677, 5305, -7428, -5276, 7150, 3434, 1496, -5736, 3100, 7219, 8626, 8664, -4300, 7572, -6091, -7421, 6306, 4138, -1364, -8980, -7514, 6492, 2519, -9190, -2939, 5458, 7882, 7183, 1547, -7266, 3605, 5848, 4650, 3624, 524, -3313, 5622, -3865, -9391, 3416, 4479, 3110, 7630, -2013, 6510, 5085, -5563, 8033, -2656, 5074, -6304, 6927};
		 //int[] array = {};
		//int[] array = {4, 2, 3, 1};
		 quickSort (array);
		 
		 for(int i = 0; i < array.length; i++) {
			 System.out.print(array[i] + " ");
		 }
		 System.out.println();
		 for (int i = 0; i < array.length - 1; i++)
			 if (array[i] > array[i + 1]) {
				 System.out.print(array[i] + " ");
				 System.out.print(i + " ");
				 System.out.print(array.length);
				 System.out.println();
			 }
	}
}
