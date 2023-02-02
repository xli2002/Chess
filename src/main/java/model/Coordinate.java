package model;

public class Coordinate {
    private char column;
    private int row;

    public Coordinate(char column, int row) {
        this.column = Character.toUpperCase(column);
        this.row = row;
    }

    public char getColumn() {
        return column;
    }
    public int getRow() {
        return row;
    }

    public Coordinate up() {
        return new Coordinate(column, row - 1);
    }
    public Coordinate down() {
        return new Coordinate(column, row + 1);
    }
    public Coordinate left() {
        return new Coordinate((char)(column -1), row);
    }
    public Coordinate right() {
        return new Coordinate((char)(column +1), row);
    }
    public Coordinate diagonalUpLeft() {
        return up().left();
    }
    public Coordinate diagonalUpRight() {
        return up().right();
    }
    public Coordinate diagonalDownLeft() {
        return down().left();
    }
    public Coordinate diagonalDownRight() {
        return down().right();
    }
@Override
    public String toString() {
        return "(" + column + "," + row + ")";
}

@Override
    public boolean equals(Object o) {
        if(! (o instanceof Coordinate))
            return false;
        Coordinate c = (Coordinate) o;
        return (c.getColumn() == this.column)
                && (c.getRow() == this.row);
    }

}
