import java.util.Scanner;

public class BubbleSort {

	/*
	 * ������Ľ��������㷨��ÿ������˳�����αȽ�����Ԫ�أ��ϴ��ֵ���������棬��С��ֵ������ǰ�档
	 * ÿ����������ź�һ�����������������´�����ʱ�Ϳ��Բ��ÿ������������������������ˡ�
	 * ����õ�����£������򣩣�ð������ֻҪһ�˾ͽ����ˣ����Ӷ���N�������������£���ȫ���򣩣�
	 * ����Ҫ���ıȽϺͽ������������Ӷ�ΪN^2��
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
	 * һ���򵥵���ʵ�ǣ��������Ѿ���ȫ�����ˣ���ôð��������Ҫ�����κ�һ�ν�����
	 * ��֮����ĳһ������û�н����κ�һ�ν����������˵�����ڵ������Ѿ������ˡ�
	 * ��ˣ�һ�ָĽ��ķ���Ϊ���ñ�־λ���ж��Ƿ�����˽�����
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
		System.out.println("������������� ");
		for (int i = 0; i < 5; i++) {
			unsorted[i] = scan.nextInt();
		}
		bubbleSort(unsorted);
		System.out.println();
		modifiedBubbleSort(unsorted);
	}
}