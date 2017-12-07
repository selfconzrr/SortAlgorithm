import java.util.Scanner;

public class BubbleSort {

	/*
	 * 最基本的交换排序算法。每趟排序按顺序依次比较相邻元素，较大的值交换到后面，较小的值交换到前面。
	 * 每趟排序可以排好一个最大的数。这样在下次排序时就可以不用考虑这个数和其他已排序的数了。
	 * 在最好的情况下（已排序），冒泡排序只要一趟就结束了，复杂度是N。但在最坏的情况下（完全倒序），
	 * 则需要最多的比较和交换次数，复杂度为N^2。
	 */
	private static void bubbleSort(int[] unsorted) {

		for (int i = 0; i < unsorted.length; i++)
			for (int j = 0; j < unsorted.length - i - 1; j++) {
				if (unsorted[j] > unsorted[j + 1]) {
					int temp = unsorted[j];
					unsorted[j] = unsorted[j + 1];
					unsorted[j + 1] = temp;
				}
			}
		for (int x : unsorted)
			System.out.print(" " + x);
	}

	/*
	 * 一个简单的事实是，若序列已经完全有序了，那么冒泡排序不需要进行任何一次交换。
	 * 反之，若某一趟排序没有进行任何一次交换，则可以说明现在的序列已经有序了。
	 * 因此，一种改进的方法为设置标志位来判断是否进行了交换。
	 */
	private static void modifiedBubbleSort(int[] unsorted) {
		boolean notFinished = true;
		for (int i = 0; i < unsorted.length && notFinished; i++)
			for (int j = 0; j < unsorted.length - i - 1; j++) {
				notFinished = false;
				if (unsorted[j] > unsorted[j + 1]) {
					int temp = unsorted[j];
					unsorted[j] = unsorted[j + 1];
					unsorted[j + 1] = temp;
					notFinished = true;
				}
			}
		for (int x : unsorted)
			System.out.print(" " + x);
	}

	public static void main(String[] args) {

		int[] unsorted = new int[5];
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入五个数： ");
		for (int i = 0; i < 5; i++) {
			unsorted[i] = scan.nextInt();
		}
		bubbleSort(unsorted);
		System.out.println();
		modifiedBubbleSort(unsorted);
	}
}