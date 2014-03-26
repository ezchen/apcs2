public class Hail {
	public static void main(String[] args) {
		System.out.println(hailLen(3));
		System.out.println(hailLen(6));
		System.out.println(longestHail(6));
		System.out.println(longestHail(5));
		System.out.println(longestHail(1000));
		System.out.println(longestHailI(1000000));
	}

	public static void hail(long n) {
		if (n==1) {
			System.out.println(n);
		} else if (n % 2 == 0) {
			System.out.println(n);
			hail(n/2);
		} else {
			System.out.println(n);
			hail(3 * n + 1);
		}
	}

	public static long hailLen(long n) {
		if (n==1) {
			return 1;
		} else if (n % 2 == 0) {
			return 1 + hailLen(n/2);
		} else {
			return 1 + hailLen(3 * n + 1);
		}
	}

	public static long longestHail(long n) {
		return helper(1,n);
	}

	public static long helper(long i, long n) {
		if (n==1) {
			return i;
		} else {
			if (hailLen(n) > hailLen(i)) {
				return helper(n, n - 1);
			} else {
				return helper(i, n - 1);
			}
		}
	}

	public static long longestHailI(long n) {
		long longest = 1;
		while (n != 1) {
			longest = (hailLen(n) > hailLen(longest)) ? n : longest;
			n = n - 1;
		}
		return longest;
	}
		
}
