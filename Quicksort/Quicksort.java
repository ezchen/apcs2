import java.util.Arrays;

/*
 * I attempted to create a new class called Tuple to hold the values
 * of where the duplicate pivot points are. This allows me to know
 * what part of the array is already sorted and gets rid of sorting through
 * a lot of duplicate pivot numbers. Object generation is expensive though
 * and whatever optimization this created is slowed by creating a new Tuple
 * every time partition is called. This method is a lot faster for a large
 * array of duplicates but extremely slow otherwise.
 */

public class Quicksort {

	public static void quicksort(int[] L) {
		quicksort(L, 0, L.length-1);
	}

	public static void quicksort(int[] L, int left, int right) {
		if (right-left < 2)
			return;

		Tuple i = partition(L, left, right);

		quicksort(L, left, i.x-1);
		quicksort(L, i.y+1, right);
	}

	public static Tuple partition(int[] L, int left, int right) {
		// variable used to traverse through array
		int i = left;

		// select a random pivot
		int pivotIndex = (int)(left + (Math.random() * (right - left + 1)));
		int pivot = L[pivotIndex];

		// swap the pivotIndex to the end
		swap(L, pivotIndex, right);
		pivotIndex = right;
		right--;

		// traverse the array
		while (i <= right) {
			if (L[i] < pivot) {
				swap(L, left, i);
				left++;
				i++;
			} else if (L[i] > pivot) {
				swap(L, i, right);
				right--;
			} else {
				i++;
			}
		}

		// swap the pivotIndex into its right position
		swap(L, right+1, pivotIndex);
		pivotIndex = right+1;

		// return the tuple with
		// left is the leftmost index that is already sorted
		// right is the rightmost index that is already sorted
		return new Tuple(left, right+1);
	}

	// swaps two values in the array
	private static void swap(int[] L, int i1, int i2) {
		int temp = L[i1];
		L[i1] = L[i2];
		L[i2] = temp;
	}

	private static boolean isSorted(int[] L) {
		for (int i = 0; i < L.length-1; i++)
			if (L[i] > L[i+1])
				return false;
		return true;
	}

	public static void main(String[] args) {
		int numElements = Integer.parseInt(args[0]);
		int range = Integer.parseInt(args[1]);

		int[] L = new int[numElements];

		for (int i = 0; i < L.length; i++) {
			L[i] = (int)(Math.random() * (range+1));
		}

		quicksort(L);
		System.out.println(isSorted(L));
	}
}

// Used to indicate already sorted region in the instance of duplicate
// pivot numbers
// ex. [ 0 1 1 1 1 1 1 2]
// x would be 1
// y would be 6
class Tuple {
	public int x;
	public int y;

	public Tuple(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
