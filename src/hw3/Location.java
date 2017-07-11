package hw3;

public class Location {
	private int row;
	private int column;
	private Location precursor;

	public Location(int r, int c, Location pre) {
		setRow(r);
		setColumn(c);
		setPrecursor(pre);
	}

	public Location(int r, int c) {
		this(r, c, null);
	}

	public Location() {
		this(0, 0, null);
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public Location getPrecursor() {
		return precursor;
	}

	public void setPrecursor(Location precursor) {
		this.precursor = precursor;
	}

}
