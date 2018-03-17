public class QuickSort {

	private static void quickSort(int[] unsorted, int left, int right) {
		if (left < right) {
			int pivot_pos = partition(unsorted, left, right);
			quickSort(unsorted, left, pivot_pos - 1);
			quickSort(unsorted, pivot_pos + 1, right);
		}
	}

	/*
	 * partition方法用来把数组分开，返回已排序的那个主元的位置。然后对左边和右边分别进行快速排序。
	 * 该方法中内层的两个while在与主元比较时需至少有一个等号，否则若存在重复元素则出现死循环。
	 * 如果只有一个等号，那么会把重复元素都分在一边。这里并没有使用交换的方法，而是直接赋值
	 */
	private static int partition(int[] a, int low, int high) {
		int pivot = a[low];
		while (low < high) {
			while (low < high && a[high] >= pivot)
				high--;
			a[low] = a[high];
			while (low < high && a[low] <= pivot)
				low++;
			a[high] = a[low];
		}
		a[low] = pivot;
		return low;
	}

	public static void main(String[] args) {
		int[] unsorted = { 5,1,2,4,3 };;
		quickSort(unsorted, 0, 4);
		for (int x : unsorted)
			System.out.print(" " + x);
		System.out.println();
	}
	
}
