public class Knight {

	private int[][] board;
	private int openSpaces;
	private boolean solved = false;

	public Knight(int boardSize) {
		board = new int[boardSize][boardSize];
		board[0][0] = 0;
		openSpaces = (boardSize*boardSize);
	}

    public String go(int x,int y){
		return ("["+x+";"+y+"H");
    }
    
    public String clear(){
		return  "[2J";
    }

    public void wait(int millis){
		try {
			Thread.sleep(millis);
		}
		catch (InterruptedException e) {
		}
    }

	public String toString() {
		String ans = "\n";
		for (int i = 0; i < board.length * board.length; i++) {
			if (i%board.length == 0 && i != 0) {
				ans += "\n";
			}
			ans += "\t" + board[i%board.length][i/board.length];
		}
		return ans+"\n";
	}

	public void solve() {
		System.out.println("row" + "\t" + "col");
		solve(0,0);
	}

	public void solve(int c, int r) {
		if (openSpaces <= 0) {
			solved = true;
		}

		if (!solved && r >= 0 && c >= 0 && r<board.length && c<board.length) {
			if (board[r][c] == 0) {
				board[r][c] = board.length*board.length - openSpaces + 1;
				openSpaces--;
				// try all directions
				
				// up directions
				solve(c-1, r-2);
				solve(c+1, r-2);

				// right
				solve(c+2, r+1);
				solve(c+2, r-1);

				// down
				solve(c-1, r+2);
				solve(c+1, r+2);

				// left
				solve(c-2, r+1);
				solve(c-2, r-1);

				// go back or print out the step
				if (!solved) {
					openSpaces++;
					board[r][c] = 0;
				} else {
					System.out.println(c + "\t" + r);
				}
			}

		}
	}
			
	public static void main(String[] args) {
		int size;
		if (args.length == 0)
			size = 5;
		else {
			try {
				size = Integer.parseInt(args[0]);
			} catch (Exception e) {
				System.out.println("invalid input, using 5 as board width/height");
				size = 5;
			}
		}
		Knight k = new Knight(size);
		k.solve();
	}
}
