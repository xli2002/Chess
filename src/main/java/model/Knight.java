package model;

import tad.ListCoor;

public abstract class Knight extends Piece {
    private ListCoor coordinates;

    public Knight(Type type, Cell cell) {
        super(type, cell);
    }

    @Override
    public ListCoor getNextMovements() {
        coordinates = new ListCoor();
        Coordinate position = getCell().getCoordinate();
        Coordinate c;

        //Up
        c = position.up().up().right();
        check(c,coordinates);
        c = position.up().up().left();
        check(c,coordinates);

        //Down
        c = position.down().down().left();
        check(c,coordinates);
        c = position.down().down().right();
        check(c,coordinates);

        //Left
        c = position.left().left().up();
        check(c,coordinates);
        c = position.left().left().down();
        check(c,coordinates);

        //right
        c = position.right().right().down();
        check(c,coordinates);
        c = position.right().right().up();
        check(c,coordinates);

        return coordinates;
    }


}
