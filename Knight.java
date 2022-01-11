import java.util.Arrays;
import java.util.Random;

public class Knight {
	private Square currentSquare;
	private Square startingSquare;
	private boolean[][] board;
	static Random randy = new Random();

	/**
	 * Constructs a Knight. This Knight's board should be created with size rows
	 * x cols. Sets the value of the Square represented by s to true. Sets all
	 * other board values to false. Sets currentSquare and startingSquare to s.
	 * 
	 * @param s
	 *            the starting Square for this Knight
	 * @param rows
	 *            the number of rows in this Knight's board
	 * @param cols
	 *            the number of columns in this Knight's board
	 */
	public Knight(Square s, int rows, int cols) {
		// 1
		board = new boolean[rows][cols];
		currentSquare = s;
		startingSquare = s;
		clearBoard();
		board[s.getRow()][s.getCol()] = true;
	}

	/**
	 * Returns this Knight's current Square.
	 * 
	 * @return this Knight's current Square.
	 */
	public Square getCurrentSquare() {
		// 2
		return currentSquare;
	}

	/**
	 * Returns this Knight's starting Square.
	 * 
	 * @return this Knight's starting Square.
	 */
	public Square getStartingSquare() {
		return startingSquare;
	}

	/**
	 * Returns this Knight's board.
	 * 
	 * @return this Knight's board.
	 */
	public boolean[][] getBoard() {
		return board;
	}

	/**
	 * Returns a 1D array of Square representing a Knights Tour for this Knight.
	 * 
	 * @return a 1D array of Square representing a Knights Tour for this Knight
	 */
	public Square[] solve() {
		// 13
		int moves=board.length*board[0].length;
		Square[] tour = new Square[moves];
		tour[0] = startingSquare;
//		System.out.println(Arrays.toString(tour));
//		System.out.println(moves);
		while (tour[moves-1]==null) {
			setCurrentSquare(this.getStartingSquare());
			for (int k=0; k<moves-1; k++) {
//			int k=0;
				setCurrentSquare(this.getCurrentSquare());
				Square next = getBestSquare(getBestSquares(getPossibleSquares()));
				setCurrentSquare(next);
				board[next.getRow()][next.getCol()] = true;
				tour[k+1]=next;
//				k++;
			}
			clearBoard();
		}
		return tour;
		
//		int moves = 0;
////		ArrayList<Square> fin = new ArrayList<Square>();
//		setStartingSquare(this.currentSquare);
//		while (boardisFalse() == true) {
//			setCurrentSquare(this.getCurrentSquare());
//			Square next = getBestSquare(getBestSquares(getPossibleSquares()));
//			setCurrentSquare(next);
//			board[next.getRow()][next.getCol()] = true;
//			moves++;
////			fin.add(next);
//		}
//		Square[] pre = new Square[moves];
////		Square[] pre = new Square[board.length*board[0].length];
////		for(int i = 0; i< pre.length;i++) {
////			System.out.println(pre[i]);
////		}
//		int k = 0;
////		clearBoard();
////		while (pre[pre.length-1]==null) {
//		setCurrentSquare(this.getStartingSquare());
//		while (boardisFalse() == true) {
//			setCurrentSquare(this.getCurrentSquare());
//			Square next = getBestSquare(getBestSquares(getPossibleSquares()));
//			setCurrentSquare(next);
//			board[next.getRow()][next.getCol()] = true;
//			pre[k] = next;
//			k++;
////		}
////		clearBoard();
//		}
////		Square[]tour=pre;
//		return pre;
////		return toArray(fin);
////		for (int i=0;i<fin.size();i++) {
////			tour[i] = fin.get(i);
////		}
////		return tour;
	}

	public boolean boardisFalse() {
		int count = 0;
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				if (board[r][c] == false) {
					count++;
				}
			}
		}
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	// regular set method, give instance variable the parameter's value, should
	// also put value true
	public void setCurrentSquare(Square currentSquare) {
		// 5
		this.currentSquare = currentSquare;
		board[currentSquare.getRow()][currentSquare.getCol()] = true;

	}

	// ask about
	public void setStartingSquare(Square startingSquare) {
		// 6
		this.startingSquare = startingSquare;
		clearBoard();
		currentSquare = startingSquare;
		board[startingSquare.getRow()][startingSquare.getCol()] = true;
	}

	/**
	 * Determines if starting Square is reachable in one move from current
	 * Square.
	 * 
	 * @return true if starting Square is reachable in one move from current
	 *         Square, false otherwise
	 */
	public boolean startIsReachableFromCurrent() {
		// 14 (not necessary unless you are doing a closed Knight's Tour)
		if (startingSquare.getRow()==currentSquare.getRow()+2 && startingSquare.getCol()==currentSquare.getCol()+1) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Returns a 1D array of Square in which each Square has the smallest
	 * positive score.
	 * 
	 * @param possible
	 *            the array of Square
	 * @return a 1D array of Square in which each Square has the smallest score
	 *         in possible
	 */
	public Square[] getBestSquares(Square[] possible) {
		// 11
		int min = getScoreOfSquare(possible[0].getRow(), possible[0].getCol());
		int count = 0;
		int m = 0;
		for (int k = 0; k < possible.length; k++) {
			if (min > getScoreOfSquare(possible[k].getRow(), possible[k].getCol())) {
				min = getScoreOfSquare(possible[k].getRow(), possible[k].getCol());
			}
		}
		for (int n = 0; n < possible.length; n++) {
			if (min == getScoreOfSquare(possible[n].getRow(), possible[n].getCol())) {
				count++;
			}
		}
		Square[] toReturn = new Square[count];
		for (int n = 0; n < possible.length; n++) {
			if (min == getScoreOfSquare(possible[n].getRow(), possible[n].getCol())) {
				toReturn[m] = possible[n];
				m++;
			}
		}
		return toReturn;
	}

	/**
	 * Randomly chooses a Square from squaresWithBestScore
	 * 
	 * @param squaresWithBestScore
	 *            an array of Square
	 * @return a randomly-chosen Square from squaresWithBestScore
	 */
	public Square getBestSquare(Square[] squaresWithBestScore) {
		// 12
		if (squaresWithBestScore.length == 1) {
			return squaresWithBestScore[0];
		} else {
			Random randy = new Random();
			int r = randy.nextInt(squaresWithBestScore.length - 1);
			return squaresWithBestScore[r];
		}
	}

	/**
	 * Sets all values in this Knight's board to false.
	 */
	public void clearBoard() {
		// 7
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				board[r][c] = false;
			}
		}
	}

	/**
	 * Returns a 1D array of all unvisited Squares that are within one knight
	 * move of this Knight's current Square.
	 * 
	 * @return a 1D array of all unvisited Squares that are within one knight
	 *         move of this Knight's current Square
	 */
	public Square[] getPossibleSquares() {
		// 10
		int row = currentSquare.getRow();
		int col = currentSquare.getCol();
		Square[] toReturn = new Square[getScoreOfSquare(currentSquare.getRow(), currentSquare.getCol())];
		int k = 0;
		// k<toReturn.length;
		if (isValid(row + 2, col + 1) && board[row + 2][col + 1] == false) {
			Square a = new Square(row + 2, col + 1);
			toReturn[k] = a;
			k++;
		}
		if (isValid(row + 2, col - 1) && board[row + 2][col - 1] == false) {
			Square a = new Square(row + 2, col - 1);
			toReturn[k] = a;
			k++;
		}
		if (isValid(row - 2, col + 1) && board[row - 2][col + 1] == false) {
			Square a = new Square(row - 2, col + 1);
			toReturn[k] = a;
			k++;
		}
		if (isValid(row - 2, col - 1) && board[row - 2][col - 1] == false) {
			Square a = new Square(row - 2, col - 1);
			toReturn[k] = a;
			k++;
		}
		if (isValid(row - 1, col + 2) && board[row - 1][col + 2] == false) {
			Square a = new Square(row - 1, col + 2);
			toReturn[k] = a;
			k++;
		}
		if (isValid(row + 1, col + 2) && board[row + 1][col + 2] == false) {
			Square a = new Square(row + 1, col + 2);
			toReturn[k] = a;
			k++;
		}
		if (isValid(row - 1, col - 2) && board[row - 1][col - 2] == false) {
			Square a = new Square(row - 1, col - 2);
			toReturn[k] = a;
			k++;
		}
		if (isValid(row + 1, col - 2) && board[row + 1][col - 2] == false) {
			Square a = new Square(row + 1, col - 2);
			toReturn[k] = a;
			k++;

		}

		return toReturn;
	}

	/**
	 * Returns the number of unvisited Squares that can be reached (with a
	 * knight move) from the Square at row, col.
	 * 
	 * @param row
	 *            the row
	 * @param col
	 *            the column
	 * @return the number of unvisited Squares that can be reached (with a
	 *         knight move) from the Square at row, col
	 */
	public int getScoreOfSquare(int row, int col) {
		// 9
		int count = 0;
		if (isValid(row + 2, col + 1) && board[row + 2][col + 1] == false) {
			count++;
		}
		if (isValid(row + 2, col - 1) && board[row + 2][col - 1] == false) {
			count++;
		}
		if (isValid(row - 2, col + 1) && board[row - 2][col + 1] == false) {
			count++;
		}
		if (isValid(row - 2, col - 1) && board[row - 2][col - 1] == false) {
			count++;
		}
		if (isValid(row - 1, col + 2) && board[row - 1][col + 2] == false) {
			count++;
		}
		if (isValid(row + 1, col + 2) && board[row + 1][col + 2] == false) {
			count++;
		}
		if (isValid(row - 1, col - 2) && board[row - 1][col - 2] == false) {
			count++;
		}
		if (isValid(row + 1, col - 2) && board[row + 1][col - 2] == false) {
			count++;
		}
		return count;
	}

	/**
	 * Returns true if the square at row r, column c is in this Knight's board;
	 * returns false otherwise.
	 * 
	 * @param r
	 *            the row
	 * @param c
	 *            the column
	 * @return true if the square at row r, column c is in this Knight's board;
	 *         false otherwise
	 */
	public boolean isValid(int r, int c) {
		// 8
		if (r >= 0 && r < board.length && c >= 0 && c < board[0].length) {
			return true;
		} else {
			return false;
		}
	}
}
