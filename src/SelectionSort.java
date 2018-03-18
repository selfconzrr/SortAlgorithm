
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
		int leftChild = 2 * i + 1;// 左孩子结点的位置。(i+1 为当前调整结点的右孩子结点的位置)
		while (leftChild < size) { // 如果有左孩子
			if (leftChild + 1 < size && a[leftChild] < a[leftChild + 1]) // 如果右孩子大于左孩子(找到比当前待调整结点大的孩子结点)
				leftChild++; // 确定较大的那个子节点的下标
			if (a[i] < a[leftChild]) {// 如果较大的子结点大于父结点
				a[i] = a[leftChild];// 那么把较大的子结点往上移动，替换它的父结点
				i = leftChild;// 重新设置i ,即待调整的下一个结点的位置
				leftChild = 2 * i + 1;// 如果当前待调整结点大于它的左右孩子，则不需要调整，直接退出
			} else
				break;
			a[i] = tmp; // 当前待调整的结点放到比其大的孩子结点位置上
		}
	}

	public static void heapSort() {
		int[] a = { 14, 13, 11, 15, 12, 1, 5, 2, 3, 9 };
		/*
		 * 初始堆进行调整 将H[0..length-1]建成堆，最后一个有孩子的节点的位置 i=
		 * (length -1) / 2
		 */
		for (int i = (a.length - 1) / 2; i >= 0; i--)
			adjustHeap(a, i, a.length);// 调整成最大堆

		// 从最后一个元素开始对序列进行调整
		for (int i = a.length - 1; i > 0; i--) { // 进行流程2
			int tmp = a[0];
			a[0] = a[i];
			a[i] = tmp; // 交换根节点和最后的节点
			adjustHeap(a, 0, i); // 每次交换堆顶元素和堆中最后一个元素之后，都要对堆进行调整
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
