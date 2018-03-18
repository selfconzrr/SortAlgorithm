/*
 * 插入排序
 * 时间复杂度O(n^2),空间复杂度O(1)
 * in-place操作
 * 稳定排序，不改变相同元素原来的顺序
 * 排序思路：每次将一个待排序的元素与已排序的元素进行逐一比较，直到找到合适的位置按大小插入。
 * eg:2 5 1 3 6
 */
public class InsertSort {

	private static void insertSort(int[] sorted) {
		for (int i = 1; i < sorted.length; i++) {
			// i=1:2<5
			// i=2:5>1,temp=1,j=2,5>1,5后移腾出位置給1,2>1,2后移腾出位置給1
			// i=3:5>3,temp=3,j=3,5>3,5后移腾出位置給3,2<3
			// i=4:5<6
			if (sorted[i - 1] > sorted[i]) {
				int temp = sorted[i];
				int j = i;
				while (j > 0 && sorted[j - 1] > temp) {
					sorted[j] = sorted[j - 1];
					j--;
				}
				sorted[j] = temp;
			}
		}
		for (int x : sorted)
			System.out.print(" " + x);
	}

	private static void binarySort(int[] data) {
		int length = data.length;
		for (int i = 1; i < length; i++) {
			int temp = data[i];
			int low = 0;
			int height = i - 1;
			while (low <= height) {
				// 找到中间值
				int mid = (low + height) / 2;
				if (temp > data[mid]) {
					// 限制在大于中点搜索
					low = mid + 1;
				} else {
					// 限制在小于中点搜索
					height = mid - 1;
				}
			}
			// 将low到i处的所有元素向后整体移一位
			for (int j = i; j > low; j--) {
				data[j] = data[j - 1];
			}
			// 最后将tmp的值插入合适位置
			data[low] = temp;
		}
		for (int x : data)
			System.out.print(" " + x);
	}

	public static void shellSort(int[] data) {
		// 开始排序
		int len = data.length;
		// h保存增量
		int h = 1;
		// 按h*3+1得到具体的增量
		while (h <= len / 3) {
			h = h * 3 + 1;
		}
		while (h > 0) {
			for (int i = h; i < len; i++) {
				// 当整体移动时，保证data[i]的值不变
				int temp = data[i];
				// 当i索引的值大于前面的值表示无需插入，而此时i-1之前的数据都是有序的，i-1索引元素的值就是最大值
				if (data[i] < data[i - h]) {
					int j = i - h;
					// 整体后移h格
					for (; j >= 0 && data[j] > temp; j -= h) {
						data[j + h] = data[j];
					}
					// 最后把tmp的值插入合适位置
					data[j + h] = temp;
				}
			}
			h = (h - 1) / 3;
		}
		// 输出验证
		for (int i = 0; i < len; i++)
			System.out.println(data[i]);
	}

	public static void main(String[] args) {
		int[] unsorted = { 14, 13, 11, 15, 12, 1, 5, 2, 3, 9 };
		// insertSort(unsorted);
//		binarySort(unsorted);
		shellSort(unsorted);
	}
}
