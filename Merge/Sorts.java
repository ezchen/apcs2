import java.util.ArrayList;

// Class contains msort and quicksort. Methods are indicated by the comments.
public class Sorts {

	//
	// Merge Sort methods
	public static void msort(ArrayList<String> L){ 
		if (L.size() > 1) {
			// make two new arrays 1/2 size of a
			ArrayList<String> b = new ArrayList<String>();
			ArrayList<String> c = new ArrayList<String>();
			// copy a to the two arrays
			// O(n)
			copy(L, b, 0, L.size()/2);
			copy(L, c, L.size()/2, L.size());

			// msort the two arrays
			msort(b);
			msort(c);
			// ans = merge(2 arrays)
			// O(n)
			ArrayList<String> ans = merge(b,c);
			// copy the two arrays
			// O(n)
			copy(ans, L, 0, L.size());
		}
    }


	public static ArrayList<String> merge(ArrayList<String> a, ArrayList<String> b) {
		int indexA = 0;
		int indexB = 0;
		int length = a.size() + b.size();
		ArrayList<String> o = new ArrayList<String>();

		for (int i = 0; i < length; i++) {
			if (indexA >= a.size()) {
				o.add(b.get(indexB));
				indexB++;
			} else if (indexB >= b.size()) {
				o.add(a.get(indexA));
				indexA++;
			} else if (a.get(indexA).compareTo(b.get(indexB)) < 0) {
				o.add(a.get(indexA));
				indexA++;
			} else {
				o.add(b.get(indexB));
				indexB++;
			}
		}
		return o;
	}
   
	public static void copy(ArrayList<String> a, ArrayList<String> target, int start, int end) {
		target.clear();
		for (int i = start; i < end; i++) {
			target.add(a.get(i));
		}
	}

/*
 * I attempted to create a new class called Tuple to hold the values
 * of where the duplicate pivot points are. This allows me to know
 * what part of the array is already sorted and gets rid of sorting through
 * a lot of duplicate pivot numbers. However, object generation is expensive
 * and whatever optimization this created is slowed by creating a new Tuple
 * every time partition is called. This method is a lot faster for a large
 * array of duplicates but extremely slow otherwise.
 *
 * Please ignore the horrible run time
 */
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

    public static String name(){
        return "Chen,Eric";
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

	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
