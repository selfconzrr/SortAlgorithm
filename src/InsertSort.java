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

	public static void main(String[] args) {
		int[] unsorted = { 14, 13, 11, 15, 12, 1, 5, 2, 3, 9 };;
		insertSort(unsorted);
	}
}
