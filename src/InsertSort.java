import java.util.Scanner;

/*
 * ��������
 * ʱ�临�Ӷ�O(n^2),�ռ临�Ӷ�O(1)
 * in-place����
 * �ȶ����򣬲��ı���ͬԪ��ԭ����˳��
 * ����˼·��ÿ�ν�һ���������Ԫ�����������Ԫ�ؽ�����һ�Ƚϣ�ֱ���ҵ����ʵ�λ�ð���С���롣
 * eg:2 5 1 3 6
 */
public class InsertSort {

	private static void insertSort(int[] sorted) {
		for (int i = 1; i < sorted.length; i++) {
			// i=1:2<5
			// i=2:5>1,temp=1,j=2,5>1,5�����ڳ�λ�ýo1,2>1,2�����ڳ�λ�ýo1
			// i=3:5>3,temp=3,j=3,5>3,5�����ڳ�λ�ýo3,2<3
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
		int[] unsorted = new int[5];
		Scanner scan = new Scanner(System.in);
		System.out.println("������������� ");
		for (int i = 0; i < 5; i++) {
			unsorted[i] = scan.nextInt();
		}
		insertSort(unsorted);
	}
}
