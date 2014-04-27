package QuickSort;

import QuickSort.Stack;
import QuickSort.Stack.task;
import java.util.Random;

public class QuickNonRecursive {
	private static void exch(Comparable[] arr, int i, int j) {
		Comparable t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	private static int partition(Comparable[] arr, int low, int high) {
		int i = low;
		int j = high+1;
		Comparable v = arr[low];
		while (true) {
			while (arr[++i].compareTo(v) < 0)
				if (i == high) break;
			while (v.compareTo(arr[--j]) < 0)
				if (j == low) break;
			if (i >= j) break;
			exch(arr, i, j);
		}
		exch(arr, low, j);
		return j;
	}
	public static void sort(Comparable[] arr) {
		Stack stack = new Stack();
		stack.push(0, arr.length-1);
		while (!stack.isEmpty()) {
			task t = stack.pop();
			int low = t.low, high = t.high;
			int j = partition(arr, low, high);
			if (low < j) {
				stack.push(low, j-1);
			}
			if (j+1 < high) {
				stack.push(j+1, high);
			}
		}
	}
	public static boolean isSorted(Comparable[] a) {
		for (int i = 0; i < a.length-1; i++)
			if (a[i].compareTo(a[i+1]) > 0) return false;
		return true;
	}
	public static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rnd = new Random();
		Integer[] arr = new Integer[1000];
		for (int i = 0; i < 1000; i++) {
			arr[i] = rnd.nextInt(1000);
		}
		show(arr);
		sort(arr);
		if (isSorted(arr)) show(arr);
		else System.out.println("not sorted");
	}
}
