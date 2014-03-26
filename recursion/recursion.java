public class recursion{
    public String lastName(){
        return "Chen";
    }
    public String firstName(){
        return "Eric";
    }

    public int hailLen(int n){
		if (n == 1) {
			return 1;
		} else {
			return 1 + ((n % 2 == 0) ? hailLen(n/2) : hailLen(3 * n + 1));
		}
    }

    public int longestHail(int n){
		return longestHailHelper(1, n);
    }

	public int longestHailHelper(int a, int n) {
		if (n==1)
			return a;
		return (hailLen(a) < hailLen(n)) ? longestHailHelper(n, n-1) : longestHailHelper(a, n-1);
	}


    public int fibItr(int n){
		if (n<=1)
			return n;
		return fibHelp(0,1,n-2);
    }

	public int fibHelp(int a,int b,int n) {
		if (n == 0) {
			return a+b;
		} else {
			return fibHelp(b,a+b,n-1);
		}
	}



    public recursion(){
        /*leave alone*/
    }
}
