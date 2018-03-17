
public class SelectionSort {

	/*
	 * 简单的排序方法，它的基本思想是：第一次从R[0]~R[n-1]中选取最小值，与R[0]交换，第二次从R[1]~R[n-1]中选取最小值，
	 * 与R[1]交换，….，第i次从R[i-1]~R[n-1]中选取最小值，与R[i-1]交换，…..，第n-1次从R[n-2]~R[n-1]
	 * 中选取最小值，与R[n-2]交换， 总共通过n-1次，得到一个按排序码从小到大排列的有序序列。
	 * 
	 * 因为在n-1趟比较中，每趟比较的目的就是选出本趟中的最小元素而放在第一位，所以我们在每趟比较中找出最小的元素后只与第一位的元素进行一次交换
	 * ，而不是在每次比较中一旦发现某个数比第一位小就立即交换。
	 */
	public static void straightSelectionSort() {
		// 测试数据
		int[] data = { 14, 13, 11, 15, 12, 1, 5, 2, 3, 9 };
		int len = data.length;
		for (int i = 0; i < len - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < len; j++) {
				if (data[j] < data[minIndex])
					minIndex = j;
			}
			if (minIndex != i) {
				int temp = data[i];
				data[i] = data[minIndex];
				data[minIndex] = temp;
			}
		}
		System.out.println("直接选择排序结果：");
		for (int x : data)
			System.out.print(x + " ");
	}

	/*
	 * 堆排序
	 */
	public static void adjustHeap(int[] a, int i, int size) { // 原数组，要调整的元素的下标，数组长度
		int tmp = a[i]; // 用变量存储当前要调整的元素，这样调整时避免了交换，直接赋值就行。可以省一些赋值次数
		while (2 * i + 1 < size) { // 如果有左孩子
			int maxchild = 2 * i + 1;
			if (2 * i + 1 < size - 1) // 如果有右孩子
				if (a[2 * i + 1] < a[2 * i + 2])
					maxchild++; // 确定较大的那个子节点的下标
			if (tmp < a[maxchild]) {
				a[i] = a[maxchild];
				i = maxchild; // 下移一层。这一步不能忘
			} else
				break;
		}
		a[i] = tmp; // 现在这个i就是最终位置
	}

	public static void heapSort() {
		int[] a = { 14, 13, 11, 15, 12, 1, 5, 2, 3, 9 };
		for (int i = a.length / 2; i >= 0; i--) // 把原数组变成堆。调整一半元素即可
			adjustHeap(a, i, a.length);
		for (int i = a.length - 1; i > 0; i--) { // 进行流程2
			int tmp = a[0];
			a[0] = a[i];
			a[i] = tmp; // 交换根节点和最后的节点
			adjustHeap(a, 0, i); // 把剩余的i个元素调整成堆，要调整的元素是根节点
		}
		System.out.println("堆排序结果：");
		for (int x : a)
			System.out.print(x + " ");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SelectionSort.heapSort();
	}

}
