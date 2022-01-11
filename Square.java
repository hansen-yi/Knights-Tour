public class Square {
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	private int row;
	private int col;
	public Square(int row, int col) {
		this.row = row;
		this.col = col;
	}
	@Override
	public String toString() {
		return "Square [row=" + row + ", col=" + col + "]";
	}
	
	public boolean equals(Object x) {
		Square other = (Square)x;
		return this.row == other.row && this.col == other.col;
	}
	
}
