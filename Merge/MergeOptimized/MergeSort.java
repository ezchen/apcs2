public class MergeSort {
	public static void main(String[] args) {
		MergeSort m = new MergeSort();
		
		int[] a = new int[10];

		for (int i = 0; i < a.length; i++) {
			a[i] = (int)(Math.random() * 10);
		}

		long time = System.currentTimeMillis();
		m.msort(a);
		long ans = System.currentTimeMillis() - time;

		System.out.println(ans);
		printArray(a);


	}

	public static void merge(int[] a, int aIndex, int endIndex,
							 int[] o, int startIndex) {
		int indexA = 0;
		int indexB = 0;
		int length = endIndex - aIndex;

		while (indexA + indexB < length + 1) {
			if (indexA <= length / 2 && (indexB + endIndex/2+1 > length || a[indexA + aIndex] < a[indexB + endIndex/2+1])) {
				o[startIndex] = a[indexA + aIndex];
				indexA++;
			} else {
				o[startIndex] = a[indexB + endIndex/2+1];
				indexB++;
			}
			startIndex++;
		}
	}

	public static void msort(int[] a) {
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			b[i] = a[i];
		}
		msort(a, 0, a.length, b);
		printArray(a);
		printArray(b);
	}	

	public static void msort(int[] a, int aIndex, int endIndex, int[] o) {
		if (endIndex-aIndex > 2) {
			printArray(a);
			printArray(o);
			msort(o, aIndex, endIndex/2+aIndex/2, a, false);
			msort(o, endIndex/2+aIndex/2, endIndex, a, false);

			merge(o, aIndex, endIndex-1, a, aIndex);
			System.out.println();
		}
		/*
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
		*/
	}

	public static void msort(int[] a, int aIndex, int endIndex, int[] o, boolean b) {
		if (endIndex-aIndex > 1) {
			printArray(a);
			printArray(o);
			msort(a, aIndex, endIndex/2+aIndex/2, o);
			msort(a, endIndex/2+aIndex/2, endIndex, o);

			merge(a, aIndex, endIndex-1, o, aIndex);
			System.out.println();
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
			System.out.println();
	}
}
