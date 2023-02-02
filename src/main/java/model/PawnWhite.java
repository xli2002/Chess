package model;

import tad.ListCoor;

public class PawnWhite extends Pawn{
    public PawnWhite(Cell cell){
        super(Type.WHITE_PAWN, cell);
    }

    @Override
    public ListCoor getNextMovements() {
        coordinates = new ListCoor();
        Coordinate position = getCell().getCoordinate();
        Coordinate c;

        c = position.up();
        checkPawnMove(c);
        if(getCell().getCoordinate().getRow()==7){
            c = position.up().up();
            checkPawnMove(c);
        }

        c=position.diagonalUpLeft();
        checkPawnKiller(c);
        c=position.diagonalUpRight();
        checkPawnKiller(c);

        return coordinates;

    }

    @Override
    public void transform() {
        new QueenWhite(getCell());
        cell=null;
    }

}