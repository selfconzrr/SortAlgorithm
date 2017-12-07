import java.util.Scanner;

public class QuickSort {

	private static void quickSort(int[] unsorted, int left, int right) {
		if (left < right) {
			int pos = partition(unsorted, left, right);
			quickSort(unsorted, left, pos - 1);
			quickSort(unsorted, pos + 1, right);
		}
	}

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
		int[] unsorted = new int[5];
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入五个数： ");
		for (int i = 0; i < 5; i++) {
			unsorted[i] = scan.nextInt();
		}
		quickSort(unsorted, 0, 4);
		for (int x : unsorted)
			System.out.print(" " + x);
		System.out.println();
	}
}
