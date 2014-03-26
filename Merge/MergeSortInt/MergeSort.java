public class MergeSort {
	public static void main(String[] args) {
		MergeSort m = new MergeSort();
		
		int[] a = new int[10000000];

		for (int i = 0; i < a.length; i++) {
			a[i] = (int)(Math.random() * 10000000);
		}

		long time = System.currentTimeMillis();
		m.msort(a);
		long ans = System.currentTimeMillis() - time;

		System.out.println(ans);
	}

	public static int[] merge(int[] a, int[] b, int[] o) {
		int indexA = 0;
		int indexB = 0;

		for (int i = 0; i < o.length; i++) {
			if (indexA >= a.length) {
				o[i] = b[indexB];
				indexB++;
			} else if (indexB >= b.length) {
				o[i] = a[indexA];
				indexA++;
			} else if (a[indexA] < b[indexB]) {
				o[i] = a[indexA];
				indexA++;
			} else {
				o[i] = b[indexB];
				indexB++;
			}
		}
		return o;
	}

	public static void msort(int[] a) {
		if (a.length > 1) {
			// make two new arrays 1/2 size of a
			int[] b = new int[a.length/2];
			int[] c = new int[a.length - b.length];
			// copy a to the two arrays
			// O(n)
			copy(a, b, 0, b.length);
			copy(a, c, b.length, a.length);
			// msort the two arrays
			msort(b);
			msort(c);
			// ans = merge(2 arrays)
			// O(n)
			merge(b,c,a);
		}
	}

	public static void copy(int[] a, int[] target, int start, int end) {
		int index = 0;
		for (int i = start; i < end; i++) {
			target[index] = a[i];
			index++;
		}
	}

	public static void printArray(int[] a) {
		for (int b : a) {
			System.out.print(b + ", ");
		}
	}
}
