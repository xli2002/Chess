package model;
import tad.ListCoor;

    public abstract class King extends Piece{

        public King(Type type, Cell cell) {
            super(type, cell);
        }

        @Override
        public ListCoor getNextMovements() {
            ListCoor coordinates = new ListCoor();
            Coordinate position = getCell().getCoordinate();
            Coordinate c;

            c = position.up();
            check(c, coordinates);
            c = position.left();
            check(c, coordinates);
            c = position.down();
            check(c, coordinates);
            c = position.right();
            check(c, coordinates);
            c = position.diagonalDownLeft();
            check(c, coordinates);
            c = position.diagonalDownRight();
            check(c, coordinates);
            c = position.diagonalUpLeft();
            check(c, coordinates);
            c = position.diagonalUpRight();
            check(c, coordinates);

            return coordinates;

        }
}
