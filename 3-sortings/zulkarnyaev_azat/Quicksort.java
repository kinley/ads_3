import java.util.Date;
import java.util.Random;

public class Quicksort {
	private int[] numbers;
	private int number;

	public void sort(int[] values) {
		
		if (values == null || values.length == 0) {
			return;
		}
		this.numbers = values;
		number = values.length;
		quicksort(0, number - 1);
	}

	private int getMedianIndex(int i1, int i2, int i3) {
		if (numbers[i1] > numbers[i2] && numbers[i1] < numbers[i3]) {
			return i1;
		} else {
			if (numbers[i2] > numbers[i1] && numbers[i2] < numbers[i3]) {
				return i2;
			} else {
				return i3;
			}
		}
	}

	private boolean validate(int[] numbers) {
		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] > numbers[i + 1]) {
				return false;
			}
		}
		return true;
	}

	private void quicksort(int low, int high) {
		int i = low, j = high;
		// Выбор опорного элемента. Три варианта - первый, средний, медиана
		// из первого, среднего и предпоследнего.
		int i1 = low;
		int i2 = low + (high - low) / 2;
		int i3 = high - 1;
		// int pivot = numbers[getMedianIndex(i1, i2, i3)];
		// int pivot = numbers[low + (high - low) / 2];
		int pivot = numbers[low];

		while (i <= j) {

			while (numbers[i] < pivot) {
				i++;
			}

			while (numbers[j] > pivot) {
				j--;
			}

			if (i <= j) {
				exchange(i, j);
				i++;
				j--;
			}
		}

		if (low < j) {
			quicksort(low, j);
		}
		if (i < high) {
			quicksort(i, high);
		}
	}

	private void exchange(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	public static void main(String[] args) {
		Random rnd = new Random();
		int[] arr = new int[1024 * 1024];
		for (int i = 0; i < 1024 * 1024; i++) {
			arr[i] = rnd.nextInt(10000);
		}
		Quicksort sorter = new Quicksort();
		System.out.println("Array with " + arr.length
				+ " random elements generated!");
		Date start = new Date();
		sorter.sort(arr);
		Date end = new Date();
		int time = (int) (end.getTime() - start.getTime());
		System.out.print(sorter.validate(sorter.numbers) ? "Sorted for "
				: "Not sorted. Time - ");
		System.out.println(time + " ms.");
		for (int i = 0; i < 1024 * 1024; i++) {
			arr[i] = i;
		}
		System.out.println("Array with " + arr.length
				+ " increasing elements generated!");
		start = new Date();
		sorter.sort(arr);
		end = new Date();
		time = (int) (end.getTime() - start.getTime());
		System.out.print(sorter.validate(sorter.numbers) ? "Sorted for "
				: "Not sorted. Time - ");
		System.out.println(time + " ms.");
	}
}
